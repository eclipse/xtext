package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.unorderedGroups.services.ExBacktrackingBug325745TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExBacktrackingBug325745TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_6", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "Tokens"
    };
    public static final int RULE_ML_COMMENT=13;
    public static final int RULE_ID=10;
    public static final int KEYWORD_4=8;
    public static final int RULE_WS=15;
    public static final int KEYWORD_1=5;
    public static final int RULE_INT=11;
    public static final int EOF=-1;
    public static final int RULE_STRING=12;
    public static final int KEYWORD_5=9;
    public static final int KEYWORD_6=4;
    public static final int Tokens=17;
    public static final int RULE_ANY_OTHER=16;
    public static final int KEYWORD_2=6;
    public static final int RULE_SL_COMMENT=14;
    public static final int KEYWORD_3=7;

        public InternalExBacktrackingBug325745TestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[27+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

     	private ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;
     	
        public InternalExBacktrackingBug325745TestLanguageParser(TokenStream input, IAstFactory factory, ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";	
       	} 
       	   	
       	@Override
       	protected ExBacktrackingBug325745TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleDelegateModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:78:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegateModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:79:2: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:80:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDelegateModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel73);
            iv_ruleDelegateModel=ruleDelegateModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDelegateModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegateModel83); if (failed) return current;

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
    // $ANTLR end entryRuleDelegateModel


    // $ANTLR start ruleDelegateModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:87:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:92:6: (this_Model_0= ruleModel )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:94:2: this_Model_0= ruleModel
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleDelegateModel132);
            this_Model_0=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

                      current = this_Model_0;
                      currentNode = currentNode.getParent();
                  
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
    // $ANTLR end ruleDelegateModel


    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:113:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:114:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:115:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel165);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel175); if (failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:122:1: ruleModel returns [EObject current=null] : ( () ( (lv_fields_1_0= ruleElement ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_fields_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:127:6: ( ( () ( (lv_fields_1_0= ruleElement ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:128:1: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:128:1: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:128:2: () ( (lv_fields_1_0= ruleElement ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:128:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:129:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:142:2: ( (lv_fields_1_0= ruleElement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:143:1: (lv_fields_1_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:143:1: (lv_fields_1_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:144:3: lv_fields_1_0= ruleElement
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFieldsElementParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel233);
            	    lv_fields_1_0=ruleElement();
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
            	      	       			"fields",
            	      	        		lv_fields_1_0, 
            	      	        		"Element", 
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
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:174:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:175:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:176:2: iv_ruleElement= ruleElement EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement269);
            iv_ruleElement=ruleElement();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement279); if (failed) return current;

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:183:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) KEYWORD_3 ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_dataType_1_0 = null;

        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:188:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) KEYWORD_3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:189:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) KEYWORD_3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:189:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) KEYWORD_3 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:189:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) KEYWORD_3
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:189:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:190:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:190:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:191:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement321); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:213:2: ( (lv_dataType_1_0= ruleDataType ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2()) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:214:1: (lv_dataType_1_0= ruleDataType )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:214:1: (lv_dataType_1_0= ruleDataType )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:215:3: lv_dataType_1_0= ruleDataType
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getDataTypeDataTypeParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDataType_in_ruleElement347);
                    lv_dataType_1_0=ruleDataType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"dataType",
                      	        		lv_dataType_1_0, 
                      	        		"DataType", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:237:3: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:238:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:238:1: (lv_expression_2_0= ruleExpression )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:239:3: lv_expression_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getExpressionExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleElement369);
            lv_expression_2_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_2_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_ruleElement380); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getElementAccess().getFullStopKeyword_3(), null); 
                  
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
    // $ANTLR end ruleElement


    // $ANTLR start entryRuleDataType
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:274:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:275:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:276:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataType_in_entryRuleDataType415);
            iv_ruleDataType=ruleDataType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataType425); if (failed) return current;

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
    // $ANTLR end entryRuleDataType


    // $ANTLR start ruleDataType
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:283:1: ruleDataType returns [EObject current=null] : ( ( (lv_baseType_0_0= RULE_ID ) ) ( KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_baseType_0_0=null;
        Token lv_defaultValue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:288:6: ( ( ( (lv_baseType_0_0= RULE_ID ) ) ( KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:289:1: ( ( (lv_baseType_0_0= RULE_ID ) ) ( KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:289:1: ( ( (lv_baseType_0_0= RULE_ID ) ) ( KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:289:2: ( (lv_baseType_0_0= RULE_ID ) ) ( KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:289:2: ( (lv_baseType_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:290:1: (lv_baseType_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:290:1: (lv_baseType_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:291:3: lv_baseType_0_0= RULE_ID
            {
            lv_baseType_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDataType467); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getDataTypeAccess().getBaseTypeIDTerminalRuleCall_0_0(), "baseType"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDataTypeRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"baseType",
              	        		lv_baseType_0_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:313:2: ( KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==KEYWORD_6) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:314:2: KEYWORD_6 ( (lv_defaultValue_2_0= RULE_STRING ) )
                    {
                    match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_ruleDataType484); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDataTypeAccess().getColonEqualsSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:318:1: ( (lv_defaultValue_2_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:319:1: (lv_defaultValue_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:319:1: (lv_defaultValue_2_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:320:3: lv_defaultValue_2_0= RULE_STRING
                    {
                    lv_defaultValue_2_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDataType501); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getDataTypeAccess().getDefaultValueSTRINGTerminalRuleCall_1_1_0(), "defaultValue"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDataTypeRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"defaultValue",
                      	        		lv_defaultValue_2_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
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
    // $ANTLR end ruleDataType


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:350:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        			grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        		);
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:357:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:358:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression549);
            iv_ruleExpression=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression559); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:368:1: ruleExpression returns [EObject current=null] : ( () ( ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) ) ) ( ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )? )* ( ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_3_0=null;
        Token lv_postfix_9_0=null;
        EObject lv_terms_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        			grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        		);
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:377:6: ( ( () ( ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) ) ) ( ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )? )* ( ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:378:1: ( () ( ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) ) ) ( ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )? )* ( ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:378:1: ( () ( ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) ) ) ( ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )? )* ( ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:378:2: () ( ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) ) ) ( ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )? )* ( ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:378:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:379:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getExpressionAccess().getExpressionAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getExpressionAccess().getExpressionAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:392:2: ( ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:394:1: ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:394:1: ( ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:395:2: ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:398:2: ( ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:399:3: ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:399:3: ( ({...}? => ( ( KEYWORD_4 ) ) ) | ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==KEYWORD_4) ) {
                    int LA4_1 = input.LA(2);

                    if ( synpred4() &&getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
                        alt4=1;
                    }


                }
                else if ( LA4_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
                    int LA4_4 = input.LA(2);

                    if ( synpred5() &&getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:401:4: ({...}? => ( ( KEYWORD_4 ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:401:4: ({...}? => ( ( KEYWORD_4 ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:402:5: {...}? => ( ( KEYWORD_4 ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            	        if (backtracking>0) {failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:402:107: ( ( KEYWORD_4 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:403:6: ( KEYWORD_4 )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:406:6: ( KEYWORD_4 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:407:2: KEYWORD_4
            	    {
            	    match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleExpression654); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_1_0(), null); 
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:418:4: ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:418:4: ({...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:419:5: {...}? => ( ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            	        if (backtracking>0) {failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:419:107: ( ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:420:6: ( (lv_prefix_3_0= RULE_STRING ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:423:6: ( (lv_prefix_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:424:1: (lv_prefix_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:424:1: (lv_prefix_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:425:3: lv_prefix_3_0= RULE_STRING
            	    {
            	    lv_prefix_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleExpression722); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getExpressionAccess().getPrefixSTRINGTerminalRuleCall_1_1_0(), "prefix"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"prefix",
            	      	        		lv_prefix_3_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:461:2: ( ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==KEYWORD_4||(LA7_0>=RULE_ID && LA7_0<=RULE_INT)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:461:3: ( KEYWORD_4 )? ( (lv_terms_5_0= ruleSimpleTerm ) ) ( KEYWORD_5 )?
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:461:3: ( KEYWORD_4 )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==KEYWORD_4) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:462:2: KEYWORD_4
            	            {
            	            match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleExpression779); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:466:3: ( (lv_terms_5_0= ruleSimpleTerm ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:467:1: (lv_terms_5_0= ruleSimpleTerm )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:467:1: (lv_terms_5_0= ruleSimpleTerm )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:468:3: lv_terms_5_0= ruleSimpleTerm
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getTermsSimpleTermParserRuleCall_2_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSimpleTerm_in_ruleExpression802);
            	    lv_terms_5_0=ruleSimpleTerm();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"terms",
            	      	        		lv_terms_5_0, 
            	      	        		"SimpleTerm", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:490:2: ( KEYWORD_5 )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==KEYWORD_5) ) {
            	        int LA6_1 = input.LA(2);

            	        if ( (synpred7()) ) {
            	            alt6=1;
            	        }
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:491:2: KEYWORD_5
            	            {
            	            match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleExpression814); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:495:5: ( ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:497:1: ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:497:1: ( ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:498:2: ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:501:2: ( ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:502:3: ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:502:3: ( ({...}? => ( ( KEYWORD_5 ) ) ) | ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( LA8_0 ==KEYWORD_5 && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:504:4: ({...}? => ( ( KEYWORD_5 ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:504:4: ({...}? => ( ( KEYWORD_5 ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:505:5: {...}? => ( ( KEYWORD_5 ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (backtracking>0) {failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:505:107: ( ( KEYWORD_5 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:506:6: ( KEYWORD_5 )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:509:6: ( KEYWORD_5 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:510:2: KEYWORD_5
            	    {
            	    match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleExpression872); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_3_0(), null); 
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:521:4: ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:521:4: ({...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:522:5: {...}? => ( ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (backtracking>0) {failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:522:107: ( ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:523:6: ( (lv_postfix_9_0= RULE_STRING ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:526:6: ( (lv_postfix_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:527:1: (lv_postfix_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:527:1: (lv_postfix_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:528:3: lv_postfix_9_0= RULE_STRING
            	    {
            	    lv_postfix_9_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleExpression940); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getExpressionAccess().getPostfixSTRINGTerminalRuleCall_3_1_0(), "postfix"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"postfix",
            	      	        		lv_postfix_9_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

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

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleSimpleTerm
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:575:1: entryRuleSimpleTerm returns [EObject current=null] : iv_ruleSimpleTerm= ruleSimpleTerm EOF ;
    public final EObject entryRuleSimpleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTerm = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:576:2: (iv_ruleSimpleTerm= ruleSimpleTerm EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:577:2: iv_ruleSimpleTerm= ruleSimpleTerm EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleTermRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTerm_in_entryRuleSimpleTerm1023);
            iv_ruleSimpleTerm=ruleSimpleTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleTerm1033); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleTerm


    // $ANTLR start ruleSimpleTerm
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:584:1: ruleSimpleTerm returns [EObject current=null] : ( ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleTerm() throws RecognitionException {
        EObject current = null;

        Token lv_lineCount_0_0=null;
        Token lv_charCount_2_0=null;
        Token lv_charSet_4_0=null;
        Token lv_refChar_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:589:6: ( ( ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:590:1: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:590:1: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_INT) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("590:1: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:590:2: ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:590:2: ( ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:590:3: ( (lv_lineCount_0_0= RULE_INT ) ) ( KEYWORD_2 )? ( (lv_charCount_2_0= RULE_INT ) )? ( KEYWORD_1 )? ( (lv_charSet_4_0= RULE_ID ) )?
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:590:3: ( (lv_lineCount_0_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:591:1: (lv_lineCount_0_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:591:1: (lv_lineCount_0_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:592:3: lv_lineCount_0_0= RULE_INT
                    {
                    lv_lineCount_0_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSimpleTerm1076); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSimpleTermAccess().getLineCountINTTerminalRuleCall_0_0_0(), "lineCount"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSimpleTermRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"lineCount",
                      	        		lv_lineCount_0_0, 
                      	        		"INT", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:614:2: ( KEYWORD_2 )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==KEYWORD_2) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:615:2: KEYWORD_2
                            {
                            match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleSimpleTerm1093); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getSimpleTermAccess().getAsteriskKeyword_0_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:619:3: ( (lv_charCount_2_0= RULE_INT ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_INT) ) {
                        int LA10_1 = input.LA(2);

                        if ( (synpred12()) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:620:1: (lv_charCount_2_0= RULE_INT )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:620:1: (lv_charCount_2_0= RULE_INT )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:621:3: lv_charCount_2_0= RULE_INT
                            {
                            lv_charCount_2_0=(Token)input.LT(1);
                            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSimpleTerm1112); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSimpleTermAccess().getCharCountINTTerminalRuleCall_0_2_0(), "charCount"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSimpleTermRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"charCount",
                              	        		lv_charCount_2_0, 
                              	        		"INT", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:643:3: ( KEYWORD_1 )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==KEYWORD_1) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:644:2: KEYWORD_1
                            {
                            match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleSimpleTerm1130); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getSimpleTermAccess().getExclamationMarkKeyword_0_3(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:648:3: ( (lv_charSet_4_0= RULE_ID ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        int LA12_1 = input.LA(2);

                        if ( (synpred14()) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:649:1: (lv_charSet_4_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:649:1: (lv_charSet_4_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:650:3: lv_charSet_4_0= RULE_ID
                            {
                            lv_charSet_4_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleTerm1149); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSimpleTermAccess().getCharSetIDTerminalRuleCall_0_4_0(), "charSet"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSimpleTermRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"charSet",
                              	        		lv_charSet_4_0, 
                              	        		"ID", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:673:6: ( (lv_refChar_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:673:6: ( (lv_refChar_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:674:1: (lv_refChar_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:674:1: (lv_refChar_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:675:3: lv_refChar_5_0= RULE_ID
                    {
                    lv_refChar_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleTerm1179); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSimpleTermAccess().getRefCharIDTerminalRuleCall_1_0(), "refChar"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSimpleTermRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"refChar",
                      	        		lv_refChar_5_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
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
    // $ANTLR end ruleSimpleTerm

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:214:1: ( ( ruleDataType ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:214:1: ( ruleDataType )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:214:1: ( ruleDataType )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:215:3: ruleDataType
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getDataTypeDataTypeParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleDataType_in_synpred2347);
        ruleDataType();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:401:4: ( ({...}? => ( ( KEYWORD_4 ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:401:4: ({...}? => ( ( KEYWORD_4 ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:401:4: ({...}? => ( ( KEYWORD_4 ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:402:5: {...}? => ( ( KEYWORD_4 ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            if (backtracking>0) {failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
        }
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:402:107: ( ( KEYWORD_4 ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:403:6: ( KEYWORD_4 )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:406:6: ( KEYWORD_4 )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:407:2: KEYWORD_4
        {
        match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_synpred4654); if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:418:4: ( ({...}? => ( ( ( RULE_STRING ) ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:418:4: ({...}? => ( ( ( RULE_STRING ) ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:418:4: ({...}? => ( ( ( RULE_STRING ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:419:5: {...}? => ( ( ( RULE_STRING ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            if (backtracking>0) {failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
        }
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:419:107: ( ( ( RULE_STRING ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:420:6: ( ( RULE_STRING ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:423:6: ( ( RULE_STRING ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:424:1: ( RULE_STRING )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:424:1: ( RULE_STRING )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:425:3: RULE_STRING
        {
        match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred5722); if (failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:491:2: ( KEYWORD_5 )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:491:2: KEYWORD_5
        {
        match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_synpred7814); if (failed) return ;

        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred9
    public final void synpred9_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:504:4: ( ({...}? => ( ( KEYWORD_5 ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:504:4: ({...}? => ( ( KEYWORD_5 ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:504:4: ({...}? => ( ( KEYWORD_5 ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:505:5: {...}? => ( ( KEYWORD_5 ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            if (backtracking>0) {failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
        }
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:505:107: ( ( KEYWORD_5 ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:506:6: ( KEYWORD_5 )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:509:6: ( KEYWORD_5 )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:510:2: KEYWORD_5
        {
        match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_synpred9872); if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9

    // $ANTLR start synpred10
    public final void synpred10_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:521:4: ( ({...}? => ( ( ( RULE_STRING ) ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:521:4: ({...}? => ( ( ( RULE_STRING ) ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:521:4: ({...}? => ( ( ( RULE_STRING ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:522:5: {...}? => ( ( ( RULE_STRING ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            if (backtracking>0) {failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
        }
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:522:107: ( ( ( RULE_STRING ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:523:6: ( ( RULE_STRING ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:526:6: ( ( RULE_STRING ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:527:1: ( RULE_STRING )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:527:1: ( RULE_STRING )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:528:3: RULE_STRING
        {
        match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred10940); if (failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10

    // $ANTLR start synpred12
    public final void synpred12_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:620:1: ( ( RULE_INT ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:620:1: ( RULE_INT )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:620:1: ( RULE_INT )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:621:3: RULE_INT
        {
        match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred121112); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred12

    // $ANTLR start synpred14
    public final void synpred14_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:649:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:649:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:649:1: ( RULE_ID )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalExBacktrackingBug325745TestLanguage.g:650:3: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred141149); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred14

    public final boolean synpred12() {
        backtracking++;
        int start = input.mark();
        try {
            synpred12_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred9() {
        backtracking++;
        int start = input.mark();
        try {
            synpred9_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
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
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred14() {
        backtracking++;
        int start = input.mark();
        try {
            synpred14_fragment(); // can never throw exception
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
    public final boolean synpred10() {
        backtracking++;
        int start = input.mark();
        try {
            synpred10_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegateModel83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleDelegateModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel233 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement269 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement321 = new BitSet(new long[]{0x0000000000001F80L});
        public static final BitSet FOLLOW_ruleDataType_in_ruleElement347 = new BitSet(new long[]{0x0000000000001F80L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleElement369 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_KEYWORD_3_in_ruleElement380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType415 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataType425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDataType467 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_KEYWORD_6_in_ruleDataType484 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDataType501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleExpression654 = new BitSet(new long[]{0x0000000000001F02L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleExpression722 = new BitSet(new long[]{0x0000000000001F02L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleExpression779 = new BitSet(new long[]{0x0000000000000C00L});
        public static final BitSet FOLLOW_ruleSimpleTerm_in_ruleExpression802 = new BitSet(new long[]{0x0000000000001F02L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleExpression814 = new BitSet(new long[]{0x0000000000001F02L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleExpression872 = new BitSet(new long[]{0x0000000000001202L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleExpression940 = new BitSet(new long[]{0x0000000000001202L});
        public static final BitSet FOLLOW_ruleSimpleTerm_in_entryRuleSimpleTerm1023 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTerm1033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSimpleTerm1076 = new BitSet(new long[]{0x0000000000000C62L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleSimpleTerm1093 = new BitSet(new long[]{0x0000000000000C22L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSimpleTerm1112 = new BitSet(new long[]{0x0000000000000422L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleSimpleTerm1130 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleTerm1149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleTerm1179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataType_in_synpred2347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_synpred4654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred5722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_5_in_synpred7814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_5_in_synpred9872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred10940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred121112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred141149 = new BitSet(new long[]{0x0000000000000002L});
    }


}
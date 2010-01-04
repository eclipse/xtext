package org.eclipse.xtext.parser.datatyperules.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDatatypeRulesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'#'", "'+'", "'*'", "';'", "'.'", "'/'", "'('", "')'", "'..'", "'-'", "'E'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDatatypeRulesTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g"; }



     	private DatatypeRulesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDatatypeRulesTestLanguageParser(TokenStream input, IAstFactory factory, DatatypeRulesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CompositeModel";	
       	} 



    // $ANTLR start entryRuleCompositeModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:72:1: entryRuleCompositeModel returns [EObject current=null] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final EObject entryRuleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:73:2: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:74:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCompositeModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel75);
            iv_ruleCompositeModel=ruleCompositeModel();
            _fsp--;

             current =iv_ruleCompositeModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeModel85); 

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
    // $ANTLR end entryRuleCompositeModel


    // $ANTLR start ruleCompositeModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:81:1: ruleCompositeModel returns [EObject current=null] : ( (lv_model_0_0= ruleModel ) )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:86:6: ( ( (lv_model_0_0= ruleModel ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:87:1: ( (lv_model_0_0= ruleModel ) )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:87:1: ( (lv_model_0_0= ruleModel ) )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:88:1: (lv_model_0_0= ruleModel )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:88:1: (lv_model_0_0= ruleModel )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:89:3: lv_model_0_0= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getCompositeModelAccess().getModelModelParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleCompositeModel130);
            	    lv_model_0_0=ruleModel();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCompositeModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"model",
            	    	        		lv_model_0_0, 
            	    	        		"Model", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCompositeModel


    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:119:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:120:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:121:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel166);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel176); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:128:1: ruleModel returns [EObject current=null] : ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ( '*' ( (lv_double_8_0= ruleDouble ) ) )? ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id_0_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_vector_4_0 = null;

        AntlrDatatypeRuleToken lv_dots_6_0 = null;

        AntlrDatatypeRuleToken lv_double_8_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:133:6: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ( '*' ( (lv_double_8_0= ruleDouble ) ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:134:1: ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ( '*' ( (lv_double_8_0= ruleDouble ) ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:134:1: ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ( '*' ( (lv_double_8_0= ruleDouble ) ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:134:2: ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ( '*' ( (lv_double_8_0= ruleDouble ) ) )? ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:134:2: ( (lv_id_0_0= ruleNestedModelId ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:135:1: (lv_id_0_0= ruleNestedModelId )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:135:1: (lv_id_0_0= ruleNestedModelId )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:136:3: lv_id_0_0= ruleNestedModelId
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getIdNestedModelIdParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedModelId_in_ruleModel222);
            lv_id_0_0=ruleNestedModelId();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"id",
            	        		lv_id_0_0, 
            	        		"NestedModelId", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:158:2: ( ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:158:4: ':' ( (lv_value_2_0= ruleFraction ) )
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel233); 

                            createLeafNode(grammarAccess.getModelAccess().getColonKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:162:1: ( (lv_value_2_0= ruleFraction ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:163:1: (lv_value_2_0= ruleFraction )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:163:1: (lv_value_2_0= ruleFraction )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:164:3: lv_value_2_0= ruleFraction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueFractionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFraction_in_ruleModel254);
                    lv_value_2_0=ruleFraction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_2_0, 
                    	        		"Fraction", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:186:4: ( '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:186:6: '#' ( (lv_vector_4_0= ruleVector ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel267); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:190:1: ( (lv_vector_4_0= ruleVector ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:191:1: (lv_vector_4_0= ruleVector )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:191:1: (lv_vector_4_0= ruleVector )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:192:3: lv_vector_4_0= ruleVector
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getVectorVectorParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleVector_in_ruleModel288);
                    lv_vector_4_0=ruleVector();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"vector",
                    	        		lv_vector_4_0, 
                    	        		"Vector", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:214:4: ( '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:214:6: '+' ( (lv_dots_6_0= ruleDots ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel301); 

                            createLeafNode(grammarAccess.getModelAccess().getPlusSignKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:218:1: ( (lv_dots_6_0= ruleDots ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:219:1: (lv_dots_6_0= ruleDots )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:219:1: (lv_dots_6_0= ruleDots )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:220:3: lv_dots_6_0= ruleDots
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDotsDotsParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDots_in_ruleModel322);
                    lv_dots_6_0=ruleDots();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"dots",
                    	        		lv_dots_6_0, 
                    	        		"Dots", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:242:4: ( '*' ( (lv_double_8_0= ruleDouble ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:242:6: '*' ( (lv_double_8_0= ruleDouble ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel335); 

                            createLeafNode(grammarAccess.getModelAccess().getAsteriskKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:1: ( (lv_double_8_0= ruleDouble ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:247:1: (lv_double_8_0= ruleDouble )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:247:1: (lv_double_8_0= ruleDouble )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:248:3: lv_double_8_0= ruleDouble
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDoubleDoubleParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDouble_in_ruleModel356);
                    lv_double_8_0=ruleDouble();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"double",
                    	        		lv_double_8_0, 
                    	        		"Double", 
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

            match(input,15,FollowSets000.FOLLOW_15_in_ruleModel368); 

                    createLeafNode(grammarAccess.getModelAccess().getSemicolonKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start entryRuleModelId
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:282:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:283:2: (iv_ruleModelId= ruleModelId EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:284:2: iv_ruleModelId= ruleModelId EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelIdRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_entryRuleModelId405);
            iv_ruleModelId=ruleModelId();
            _fsp--;

             current =iv_ruleModelId.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelId416); 

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
    // $ANTLR end entryRuleModelId


    // $ANTLR start ruleModelId
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:291:1: ruleModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:296:6: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:297:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:297:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:297:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelId456); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getModelIdAccess().getIDTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,16,FollowSets000.FOLLOW_16_in_ruleModelId474); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getModelIdAccess().getFullStopKeyword_1(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelId489); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.getModelIdAccess().getIDTerminalRuleCall_2(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModelId


    // $ANTLR start entryRuleNestedModelId
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:325:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:326:2: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:327:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedModelIdRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId535);
            iv_ruleNestedModelId=ruleNestedModelId();
            _fsp--;

             current =iv_ruleNestedModelId.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedModelId546); 

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
    // $ANTLR end entryRuleNestedModelId


    // $ANTLR start ruleNestedModelId
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:334:1: ruleNestedModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) ;
    public final AntlrDatatypeRuleToken ruleNestedModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ModelId_0 = null;

        AntlrDatatypeRuleToken this_ModelId_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:339:6: ( (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:340:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:340:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:341:5: this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId
            {
             
                    currentNode=createCompositeNode(grammarAccess.getNestedModelIdAccess().getModelIdParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_ruleNestedModelId593);
            this_ModelId_0=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId_0);
                
             
                    currentNode = currentNode.getParent();
                
            kw=(Token)input.LT(1);
            match(input,16,FollowSets000.FOLLOW_16_in_ruleNestedModelId611); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getNestedModelIdAccess().getFullStopKeyword_1(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getNestedModelIdAccess().getModelIdParserRuleCall_2(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_ruleNestedModelId633);
            this_ModelId_2=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId_2);
                
             
                    currentNode = currentNode.getParent();
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNestedModelId


    // $ANTLR start entryRuleFraction
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:376:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFraction = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:377:2: (iv_ruleFraction= ruleFraction EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:378:2: iv_ruleFraction= ruleFraction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFractionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFraction_in_entryRuleFraction679);
            iv_ruleFraction=ruleFraction();
            _fsp--;

             current =iv_ruleFraction.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFraction690); 

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
    // $ANTLR end entryRuleFraction


    // $ANTLR start ruleFraction
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:385:1: ruleFraction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFraction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:390:6: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:391:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:391:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:391:6: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFraction730); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getFractionAccess().getINTTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:398:1: (kw= '/' this_INT_2= RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:399:2: kw= '/' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleFraction749); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getFractionAccess().getSolidusKeyword_1_0(), null); 
                        
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFraction764); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getFractionAccess().getINTTerminalRuleCall_1_1(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFraction


    // $ANTLR start entryRuleVector
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:419:1: entryRuleVector returns [String current=null] : iv_ruleVector= ruleVector EOF ;
    public final String entryRuleVector() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVector = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:420:2: (iv_ruleVector= ruleVector EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:421:2: iv_ruleVector= ruleVector EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVectorRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleVector_in_entryRuleVector812);
            iv_ruleVector=ruleVector();
            _fsp--;

             current =iv_ruleVector.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVector823); 

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
    // $ANTLR end entryRuleVector


    // $ANTLR start ruleVector
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:428:1: ruleVector returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleVector() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:6: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:434:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:434:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:435:2: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,18,FollowSets000.FOLLOW_18_in_ruleVector861); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getVectorAccess().getLeftParenthesisKeyword_0(), null); 
                
            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVector876); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.getVectorAccess().getINTTerminalRuleCall_1(), null); 
                
            this_INT_2=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVector896); 

            		current.merge(this_INT_2);
                
             
                createLeafNode(grammarAccess.getVectorAccess().getINTTerminalRuleCall_2(), null); 
                
            kw=(Token)input.LT(1);
            match(input,19,FollowSets000.FOLLOW_19_in_ruleVector914); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getVectorAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVector


    // $ANTLR start entryRuleDots
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:468:1: entryRuleDots returns [String current=null] : iv_ruleDots= ruleDots EOF ;
    public final String entryRuleDots() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDots = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:469:2: (iv_ruleDots= ruleDots EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:470:2: iv_ruleDots= ruleDots EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDotsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDots_in_entryRuleDots955);
            iv_ruleDots=ruleDots();
            _fsp--;

             current =iv_ruleDots.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDots966); 

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
    // $ANTLR end entryRuleDots


    // $ANTLR start ruleDots
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:477:1: ruleDots returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleDots() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:482:6: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:483:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:483:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("483:1: ( (kw= '.' kw= '.' ) | kw= '..' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:483:2: (kw= '.' kw= '.' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:483:2: (kw= '.' kw= '.' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:484:2: kw= '.' kw= '.'
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleDots1005); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDotsAccess().getFullStopKeyword_0_0(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleDots1018); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDotsAccess().getFullStopKeyword_0_1(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:497:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleDots1038); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDotsAccess().getFullStopFullStopKeyword_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDots


    // $ANTLR start entryRuleDouble
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:510:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:511:2: (iv_ruleDouble= ruleDouble EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:512:2: iv_ruleDouble= ruleDouble EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDouble_in_entryRuleDouble1079);
            iv_ruleDouble=ruleDouble();
            _fsp--;

             current =iv_ruleDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDouble1090); 

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
    // $ANTLR end entryRuleDouble


    // $ANTLR start ruleDouble
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:519:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_6=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:524:6: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:525:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:525:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:525:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:525:2: (kw= '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:526:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleDouble1129); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDoubleAccess().getHyphenMinusKeyword_0(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:531:3: (this_INT_1= RULE_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:531:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1147); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,16,FollowSets000.FOLLOW_16_in_ruleDouble1167); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDoubleAccess().getFullStopKeyword_2(), null); 
                
            this_INT_3=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1182); 

            		current.merge(this_INT_3);
                
             
                createLeafNode(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:551:1: (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:552:2: kw= 'E' (kw= '-' )? this_INT_6= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleDouble1201); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDoubleAccess().getEKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:557:1: (kw= '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:558:2: kw= '-'
                            {
                            kw=(Token)input.LT(1);
                            match(input,21,FollowSets000.FOLLOW_21_in_ruleDouble1215); 

                                    current.merge(kw);
                                    createLeafNode(grammarAccess.getDoubleAccess().getHyphenMinusKeyword_4_1(), null); 
                                

                            }
                            break;

                    }

                    this_INT_6=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1232); 

                    		current.merge(this_INT_6);
                        
                     
                        createLeafNode(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_4_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDouble


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel130 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel222 = new BitSet(new long[]{0x000000000000F800L});
        public static final BitSet FOLLOW_11_in_ruleModel233 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFraction_in_ruleModel254 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_12_in_ruleModel267 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleVector_in_ruleModel288 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_13_in_ruleModel301 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_ruleDots_in_ruleModel322 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleModel335 = new BitSet(new long[]{0x0000000000210020L});
        public static final BitSet FOLLOW_ruleDouble_in_ruleModel356 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId405 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelId416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelId456 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleModelId474 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelId489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId593 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNestedModelId611 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction679 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFraction690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFraction730 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleFraction749 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFraction764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVector_in_entryRuleVector812 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVector823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleVector861 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVector876 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVector896 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleVector914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDots_in_entryRuleDots955 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDots966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDots1005 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDots1018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleDots1038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble1079 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDouble1090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleDouble1129 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1147 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDouble1167 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1182 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleDouble1201 = new BitSet(new long[]{0x0000000000200020L});
        public static final BitSet FOLLOW_21_in_ruleDouble1215 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1232 = new BitSet(new long[]{0x0000000000000002L});
    }


}
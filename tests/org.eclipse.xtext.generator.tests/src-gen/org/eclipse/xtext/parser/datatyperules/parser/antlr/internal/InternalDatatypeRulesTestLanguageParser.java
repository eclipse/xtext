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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'#'", "'+'", "';'", "'.'", "'/'", "'('", "')'", "'..'"
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:72:56: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:73:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCompositeModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel73);
            iv_ruleCompositeModel=ruleCompositeModel();
            _fsp--;

             current =iv_ruleCompositeModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:80:1: ruleCompositeModel returns [EObject current=null] : ( (lv_model_0_0= ruleModel ) )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:85:6: ( ( (lv_model_0_0= ruleModel ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:86:1: ( (lv_model_0_0= ruleModel ) )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:86:1: ( (lv_model_0_0= ruleModel ) )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:87:1: (lv_model_0_0= ruleModel )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:87:1: (lv_model_0_0= ruleModel )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:88:3: lv_model_0_0= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getCompositeModelAccess().getModelModelParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModel_in_ruleCompositeModel128);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:117:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:117:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:118:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel161);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel171); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:125:1: ruleModel returns [EObject current=null] : ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id_0_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_vector_4_0 = null;

        AntlrDatatypeRuleToken lv_dots_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:130:6: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:131:1: ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:131:1: ( ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:131:2: ( (lv_id_0_0= ruleNestedModelId ) ) ( ':' ( (lv_value_2_0= ruleFraction ) ) )? ( '#' ( (lv_vector_4_0= ruleVector ) ) )? ( '+' ( (lv_dots_6_0= ruleDots ) ) )? ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:131:2: ( (lv_id_0_0= ruleNestedModelId ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:132:1: (lv_id_0_0= ruleNestedModelId )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:132:1: (lv_id_0_0= ruleNestedModelId )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:133:3: lv_id_0_0= ruleNestedModelId
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getIdNestedModelIdParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNestedModelId_in_ruleModel217);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:155:2: ( ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:155:4: ':' ( (lv_value_2_0= ruleFraction ) )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel228); 

                            createLeafNode(grammarAccess.getModelAccess().getColonKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:159:1: ( (lv_value_2_0= ruleFraction ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:160:1: (lv_value_2_0= ruleFraction )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:160:1: (lv_value_2_0= ruleFraction )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:161:3: lv_value_2_0= ruleFraction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueFractionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFraction_in_ruleModel249);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:183:4: ( '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:183:6: '#' ( (lv_vector_4_0= ruleVector ) )
                    {
                    match(input,12,FOLLOW_12_in_ruleModel262); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:187:1: ( (lv_vector_4_0= ruleVector ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:188:1: (lv_vector_4_0= ruleVector )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:188:1: (lv_vector_4_0= ruleVector )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:189:3: lv_vector_4_0= ruleVector
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getVectorVectorParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleModel283);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:211:4: ( '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:211:6: '+' ( (lv_dots_6_0= ruleDots ) )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel296); 

                            createLeafNode(grammarAccess.getModelAccess().getPlusSignKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:215:1: ( (lv_dots_6_0= ruleDots ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:216:1: (lv_dots_6_0= ruleDots )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:216:1: (lv_dots_6_0= ruleDots )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:217:3: lv_dots_6_0= ruleDots
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDotsDotsParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDots_in_ruleModel317);
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

            match(input,14,FOLLOW_14_in_ruleModel329); 

                    createLeafNode(grammarAccess.getModelAccess().getSemicolonKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:250:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:250:48: (iv_ruleModelId= ruleModelId EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:251:2: iv_ruleModelId= ruleModelId EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelIdRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelId_in_entryRuleModelId363);
            iv_ruleModelId=ruleModelId();
            _fsp--;

             current =iv_ruleModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelId374); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:258:1: ruleModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:263:6: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:264:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:264:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:264:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId414); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getModelIdAccess().getIDTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleModelId432); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getModelIdAccess().getFullStopKeyword_1(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId447); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:292:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:292:54: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:293:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedModelIdRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId491);
            iv_ruleNestedModelId=ruleNestedModelId();
            _fsp--;

             current =iv_ruleNestedModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedModelId502); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:300:1: ruleNestedModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) ;
    public final AntlrDatatypeRuleToken ruleNestedModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ModelId_0 = null;

        AntlrDatatypeRuleToken this_ModelId_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:305:6: ( (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:306:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:306:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:307:5: this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId
            {
             
                    currentNode=createCompositeNode(grammarAccess.getNestedModelIdAccess().getModelIdParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId549);
            this_ModelId_0=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId_0);
                
             
                    currentNode = currentNode.getParent();
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleNestedModelId567); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getNestedModelIdAccess().getFullStopKeyword_1(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getNestedModelIdAccess().getModelIdParserRuleCall_2(), currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId589);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:342:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFraction = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:342:49: (iv_ruleFraction= ruleFraction EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:343:2: iv_ruleFraction= ruleFraction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFractionRule(), currentNode); 
            pushFollow(FOLLOW_ruleFraction_in_entryRuleFraction633);
            iv_ruleFraction=ruleFraction();
            _fsp--;

             current =iv_ruleFraction.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFraction644); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:350:1: ruleFraction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFraction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:355:6: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:356:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:356:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:356:6: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction684); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getFractionAccess().getINTTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:363:1: (kw= '/' this_INT_2= RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:364:2: kw= '/' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleFraction703); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getFractionAccess().getSolidusKeyword_1_0(), null); 
                        
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction718); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:384:1: entryRuleVector returns [String current=null] : iv_ruleVector= ruleVector EOF ;
    public final String entryRuleVector() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVector = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:384:47: (iv_ruleVector= ruleVector EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:385:2: iv_ruleVector= ruleVector EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVectorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVector_in_entryRuleVector764);
            iv_ruleVector=ruleVector();
            _fsp--;

             current =iv_ruleVector.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVector775); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:392:1: ruleVector returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleVector() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:397:6: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:398:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:398:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:399:2: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleVector813); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getVectorAccess().getLeftParenthesisKeyword_0(), null); 
                
            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector828); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.getVectorAccess().getINTTerminalRuleCall_1(), null); 
                
            this_INT_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector848); 

            		current.merge(this_INT_2);
                
             
                createLeafNode(grammarAccess.getVectorAccess().getINTTerminalRuleCall_2(), null); 
                
            kw=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleVector866); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:1: entryRuleDots returns [String current=null] : iv_ruleDots= ruleDots EOF ;
    public final String entryRuleDots() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDots = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:45: (iv_ruleDots= ruleDots EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:2: iv_ruleDots= ruleDots EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDotsRule(), currentNode); 
            pushFollow(FOLLOW_ruleDots_in_entryRuleDots905);
            iv_ruleDots=ruleDots();
            _fsp--;

             current =iv_ruleDots.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDots916); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:440:1: ruleDots returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleDots() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:445:6: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:446:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:446:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==19) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("446:1: ( (kw= '.' kw= '.' ) | kw= '..' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:446:2: (kw= '.' kw= '.' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:446:2: (kw= '.' kw= '.' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:447:2: kw= '.' kw= '.'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots955); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDotsAccess().getFullStopKeyword_0_0(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots968); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDotsAccess().getFullStopKeyword_0_1(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:460:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleDots988); 

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


 

    public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel128 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel217 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_11_in_ruleModel228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFraction_in_ruleModel249 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_12_in_ruleModel262 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleVector_in_ruleModel283 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModel296 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_ruleDots_in_ruleModel317 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModel329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelId374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId414 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModelId432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId491 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId549 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNestedModelId567 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFraction644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction684 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFraction703 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVector_in_entryRuleVector764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVector775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVector813 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector828 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector848 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVector866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDots_in_entryRuleDots905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDots916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDots955 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDots968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDots988 = new BitSet(new long[]{0x0000000000000002L});

}
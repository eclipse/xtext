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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:69:1: entryRuleCompositeModel returns [EObject current=null] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final EObject entryRuleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:69:56: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:70:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCompositeModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel71);
            iv_ruleCompositeModel=ruleCompositeModel();
            _fsp--;

             current =iv_ruleCompositeModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeModel81); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:77:1: ruleCompositeModel returns [EObject current=null] : (lv_model_0= ruleModel )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:82:6: ( (lv_model_0= ruleModel )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:83:1: (lv_model_0= ruleModel )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:83:1: (lv_model_0= ruleModel )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:86:6: lv_model_0= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prCompositeModel().ele0ParserRuleCallModel(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModel_in_ruleCompositeModel139);
            	    lv_model_0=ruleModel();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prCompositeModel().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "model", lv_model_0, "Model", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:111:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:111:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:112:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel176);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel186); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:119:1: ruleModel returns [EObject current=null] : ( (lv_id_0= ruleNestedModelId ) ( ':' (lv_value_2= ruleFraction ) )? ( '#' (lv_vector_4= ruleVector ) )? ( '+' (lv_dots_6= ruleDots ) )? ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id_0 = null;

        AntlrDatatypeRuleToken lv_value_2 = null;

        AntlrDatatypeRuleToken lv_vector_4 = null;

        AntlrDatatypeRuleToken lv_dots_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:6: ( ( (lv_id_0= ruleNestedModelId ) ( ':' (lv_value_2= ruleFraction ) )? ( '#' (lv_vector_4= ruleVector ) )? ( '+' (lv_dots_6= ruleDots ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:125:1: ( (lv_id_0= ruleNestedModelId ) ( ':' (lv_value_2= ruleFraction ) )? ( '#' (lv_vector_4= ruleVector ) )? ( '+' (lv_dots_6= ruleDots ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:125:1: ( (lv_id_0= ruleNestedModelId ) ( ':' (lv_value_2= ruleFraction ) )? ( '#' (lv_vector_4= ruleVector ) )? ( '+' (lv_dots_6= ruleDots ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:125:2: (lv_id_0= ruleNestedModelId ) ( ':' (lv_value_2= ruleFraction ) )? ( '#' (lv_vector_4= ruleVector ) )? ( '+' (lv_dots_6= ruleDots ) )? ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:125:2: (lv_id_0= ruleNestedModelId )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:128:6: lv_id_0= ruleNestedModelId
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prModel().ele00ParserRuleCallNestedModelId(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNestedModelId_in_ruleModel245);
            lv_id_0=ruleNestedModelId();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "id", lv_id_0, "NestedModelId", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:146:2: ( ':' (lv_value_2= ruleFraction ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:146:3: ':' (lv_value_2= ruleFraction )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel259); 

                            createLeafNode(grammarAccess.prModel().ele10KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:150:1: (lv_value_2= ruleFraction )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:153:6: lv_value_2= ruleFraction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele110ParserRuleCallFraction(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFraction_in_ruleModel293);
                    lv_value_2=ruleFraction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_2, "Fraction", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:171:4: ( '#' (lv_vector_4= ruleVector ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:171:5: '#' (lv_vector_4= ruleVector )
                    {
                    match(input,12,FOLLOW_12_in_ruleModel309); 

                            createLeafNode(grammarAccess.prModel().ele20KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:175:1: (lv_vector_4= ruleVector )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:178:6: lv_vector_4= ruleVector
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele210ParserRuleCallVector(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleModel343);
                    lv_vector_4=ruleVector();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "vector", lv_vector_4, "Vector", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:196:4: ( '+' (lv_dots_6= ruleDots ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:196:5: '+' (lv_dots_6= ruleDots )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel359); 

                            createLeafNode(grammarAccess.prModel().ele30KeywordPlusSign(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:200:1: (lv_dots_6= ruleDots )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:203:6: lv_dots_6= ruleDots
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele310ParserRuleCallDots(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDots_in_ruleModel393);
                    lv_dots_6=ruleDots();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "dots", lv_dots_6, "Dots", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleModel408); 

                    createLeafNode(grammarAccess.prModel().ele4KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:232:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:232:48: (iv_ruleModelId= ruleModelId EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:233:2: iv_ruleModelId= ruleModelId EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModelId().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelId_in_entryRuleModelId442);
            iv_ruleModelId=ruleModelId();
            _fsp--;

             current =iv_ruleModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelId453); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:240:1: ruleModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:6: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:247:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:247:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:247:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId493); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prModelId().ele0TerminalRuleCallID(), null); 
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleModelId511); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prModelId().ele1KeywordFullStop(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId526); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.prModelId().ele2TerminalRuleCallID(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:275:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:275:54: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:276:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNestedModelId().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId570);
            iv_ruleNestedModelId=ruleNestedModelId();
            _fsp--;

             current =iv_ruleNestedModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedModelId581); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:283:1: ruleNestedModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) ;
    public final AntlrDatatypeRuleToken ruleNestedModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ModelId_0 = null;

        AntlrDatatypeRuleToken this_ModelId_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:289:6: ( (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:290:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:290:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:291:5: this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId
            {
             
                    currentNode=createCompositeNode(grammarAccess.prNestedModelId().ele0ParserRuleCallModelId(), currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId628);
            this_ModelId_0=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId_0);
                
             
                    currentNode = currentNode.getParent();
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleNestedModelId646); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prNestedModelId().ele1KeywordFullStop(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prNestedModelId().ele2ParserRuleCallModelId(), currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId668);
            this_ModelId_2=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId_2);
                
             
                    currentNode = currentNode.getParent();
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:326:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFraction = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:326:49: (iv_ruleFraction= ruleFraction EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:327:2: iv_ruleFraction= ruleFraction EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFraction().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFraction_in_entryRuleFraction712);
            iv_ruleFraction=ruleFraction();
            _fsp--;

             current =iv_ruleFraction.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFraction723); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:334:1: ruleFraction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFraction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:340:6: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:341:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:341:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:341:6: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction763); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.prFraction().ele0TerminalRuleCallINT(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:348:1: (kw= '/' this_INT_2= RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:349:2: kw= '/' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleFraction782); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prFraction().ele10KeywordSolidus(), null); 
                        
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction797); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.prFraction().ele11TerminalRuleCallINT(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:369:1: entryRuleVector returns [String current=null] : iv_ruleVector= ruleVector EOF ;
    public final String entryRuleVector() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVector = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:369:47: (iv_ruleVector= ruleVector EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:370:2: iv_ruleVector= ruleVector EOF
            {
             currentNode = createCompositeNode(grammarAccess.prVector().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleVector_in_entryRuleVector843);
            iv_ruleVector=ruleVector();
            _fsp--;

             current =iv_ruleVector.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVector854); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:377:1: ruleVector returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleVector() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:6: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:384:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:384:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:385:2: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleVector892); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prVector().ele0KeywordLeftParenthesis(), null); 
                
            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector907); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.prVector().ele1TerminalRuleCallINT(), null); 
                
            this_INT_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector927); 

            		current.merge(this_INT_2);
                
             
                createLeafNode(grammarAccess.prVector().ele2TerminalRuleCallINT(), null); 
                
            kw=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleVector945); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prVector().ele3KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:418:1: entryRuleDots returns [String current=null] : iv_ruleDots= ruleDots EOF ;
    public final String entryRuleDots() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDots = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:418:45: (iv_ruleDots= ruleDots EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:419:2: iv_ruleDots= ruleDots EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDots().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDots_in_entryRuleDots984);
            iv_ruleDots=ruleDots();
            _fsp--;

             current =iv_ruleDots.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDots995); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:426:1: ruleDots returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleDots() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:6: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:1: ( (kw= '.' kw= '.' ) | kw= '..' )
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
                    new NoViableAltException("433:1: ( (kw= '.' kw= '.' ) | kw= '..' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:2: (kw= '.' kw= '.' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:2: (kw= '.' kw= '.' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:434:2: kw= '.' kw= '.'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots1034); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prDots().ele00KeywordFullStop(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots1047); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prDots().ele01KeywordFullStop(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:447:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleDots1067); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prDots().ele1KeywordFullStopFullStop(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
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


 

    public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel139 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel245 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_11_in_ruleModel259 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFraction_in_ruleModel293 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_12_in_ruleModel309 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleVector_in_ruleModel343 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModel359 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_ruleDots_in_ruleModel393 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModel408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelId453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId493 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModelId511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId628 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNestedModelId646 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFraction723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction763 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFraction782 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVector_in_entryRuleVector843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVector854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVector892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector907 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector927 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVector945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDots_in_entryRuleDots984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDots995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDots1034 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDots1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDots1067 = new BitSet(new long[]{0x0000000000000002L});

}
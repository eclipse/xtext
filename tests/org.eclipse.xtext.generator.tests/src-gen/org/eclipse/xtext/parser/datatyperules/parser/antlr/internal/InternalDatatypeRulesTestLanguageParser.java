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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g"; }


     
        public InternalDatatypeRulesTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalDatatypeRulesTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CompositeModel";	
       	} 



    // $ANTLR start entryRuleCompositeModel
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:68:1: entryRuleCompositeModel returns [EObject current=null] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final EObject entryRuleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:68:56: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:69:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel72);
            iv_ruleCompositeModel=ruleCompositeModel();
            _fsp--;

             current =iv_ruleCompositeModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeModel82); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:76:1: ruleCompositeModel returns [EObject current=null] : (lv_model= ruleModel )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:80:6: ( (lv_model= ruleModel )+ )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:81:1: (lv_model= ruleModel )+
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:81:1: (lv_model= ruleModel )+
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
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:84:6: lv_model= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModel_in_ruleCompositeModel140);
            	    lv_model=ruleModel();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("CompositeModel");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "model", lv_model, "Model", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:111:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:111:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:112:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel179);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel189); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:119:1: ruleModel returns [EObject current=null] : ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id = null;

        AntlrDatatypeRuleToken lv_value = null;

        AntlrDatatypeRuleToken lv_vector = null;

        AntlrDatatypeRuleToken lv_dots = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:123:6: ( ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:1: ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:1: ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:2: ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:2: ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:3: ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:3: ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:4: ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:4: ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:5: (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:124:5: (lv_id= ruleNestedModelId )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:127:6: lv_id= ruleNestedModelId
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNestedModelId_in_ruleModel251);
            lv_id=ruleNestedModelId();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Model");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "id", lv_id, "NestedModelId", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:145:2: ( ':' (lv_value= ruleFraction ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:145:3: ':' (lv_value= ruleFraction )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel265); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:149:1: (lv_value= ruleFraction )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:152:6: lv_value= ruleFraction
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFraction_in_ruleModel299);
                    lv_value=ruleFraction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "value", lv_value, "Fraction", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:170:5: ( '#' (lv_vector= ruleVector ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:170:6: '#' (lv_vector= ruleVector )
                    {
                    match(input,12,FOLLOW_12_in_ruleModel316); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:174:1: (lv_vector= ruleVector )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:177:6: lv_vector= ruleVector
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleModel350);
                    lv_vector=ruleVector();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "vector", lv_vector, "Vector", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:195:5: ( '+' (lv_dots= ruleDots ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:195:6: '+' (lv_dots= ruleDots )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel367); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:199:1: (lv_dots= ruleDots )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:202:6: lv_dots= ruleDots
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDots_in_ruleModel401);
                    lv_dots=ruleDots();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "dots", lv_dots, "Dots", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,14,FOLLOW_14_in_ruleModel417); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:233:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:233:48: (iv_ruleModelId= ruleModelId EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:234:2: iv_ruleModelId= ruleModelId EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModelId_in_entryRuleModelId453);
            iv_ruleModelId=ruleModelId();
            _fsp--;

             current =iv_ruleModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelId464); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:241:1: ruleModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:245:6: ( ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:1: ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:1: ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:2: (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:2: (this_ID= RULE_ID kw= '.' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:246:7: this_ID= RULE_ID kw= '.'
            {
            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId505); 

            		current.merge(this_ID);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, null); 
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleModelId523); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId539); 

            		current.merge(this_ID);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:276:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedModelId = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:276:54: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:277:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId585);
            iv_ruleNestedModelId=ruleNestedModelId();
            _fsp--;

             current =iv_ruleNestedModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedModelId596); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:284:1: ruleNestedModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId ) ;
    public final AntlrDatatypeRuleToken ruleNestedModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ModelId = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:288:6: ( ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:289:1: ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:289:1: ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:289:2: (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:289:2: (this_ModelId= ruleModelId kw= '.' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:290:5: this_ModelId= ruleModelId kw= '.'
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId644);
            this_ModelId=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId);
                
             
                    currentNode = currentNode.getParent();
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleNestedModelId662); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId685);
            this_ModelId=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId);
                
             
                    currentNode = currentNode.getParent();
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:327:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFraction = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:327:49: (iv_ruleFraction= ruleFraction EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:328:2: iv_ruleFraction= ruleFraction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFraction_in_entryRuleFraction731);
            iv_ruleFraction=ruleFraction();
            _fsp--;

             current =iv_ruleFraction.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFraction742); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:335:1: ruleFraction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFraction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:339:6: ( (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:340:1: (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:340:1: (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:340:6: this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )?
            {
            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction782); 

            		current.merge(this_INT);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:347:1: (kw= '/' this_INT= RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:348:2: kw= '/' this_INT= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleFraction801); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    this_INT=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction816); 

                    		current.merge(this_INT);
                        
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::RuleCall */, null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:370:1: entryRuleVector returns [String current=null] : iv_ruleVector= ruleVector EOF ;
    public final String entryRuleVector() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVector = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:370:47: (iv_ruleVector= ruleVector EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:371:2: iv_ruleVector= ruleVector EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleVector_in_entryRuleVector864);
            iv_ruleVector=ruleVector();
            _fsp--;

             current =iv_ruleVector.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVector875); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:378:1: ruleVector returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleVector() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:382:6: ( ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:1: ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:1: ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:2: ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:2: ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:3: (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:383:3: (kw= '(' this_INT= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:384:2: kw= '(' this_INT= RULE_INT
            {
            kw=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleVector915); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector930); 

            		current.merge(this_INT);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, null); 
                

            }

            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector951); 

            		current.merge(this_INT);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, null); 
                

            }

            kw=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleVector970); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:419:1: entryRuleDots returns [String current=null] : iv_ruleDots= ruleDots EOF ;
    public final String entryRuleDots() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDots = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:419:45: (iv_ruleDots= ruleDots EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:420:2: iv_ruleDots= ruleDots EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleDots_in_entryRuleDots1011);
            iv_ruleDots=ruleDots();
            _fsp--;

             current =iv_ruleDots.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDots1022); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:427:1: ruleDots returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleDots() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:431:6: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:1: ( (kw= '.' kw= '.' ) | kw= '..' )
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
                    new NoViableAltException("432:1: ( (kw= '.' kw= '.' ) | kw= '..' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:2: (kw= '.' kw= '.' )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:432:2: (kw= '.' kw= '.' )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:433:2: kw= '.' kw= '.'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots1061); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6/@alternatives/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots1074); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6/@alternatives/@groups.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:446:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleDots1094); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6/@alternatives/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
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


 

    public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel251 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_11_in_ruleModel265 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFraction_in_ruleModel299 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_12_in_ruleModel316 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleVector_in_ruleModel350 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModel367 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_ruleDots_in_ruleModel401 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModel417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelId464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId505 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModelId523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId644 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNestedModelId662 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFraction742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction782 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFraction801 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVector_in_entryRuleVector864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVector875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVector915 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector930 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector951 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVector970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDots_in_entryRuleDots1011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDots1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDots1061 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDots1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDots1094 = new BitSet(new long[]{0x0000000000000002L});

}
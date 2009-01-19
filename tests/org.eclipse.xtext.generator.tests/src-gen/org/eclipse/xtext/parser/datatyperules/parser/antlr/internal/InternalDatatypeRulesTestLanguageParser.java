// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g 2009-01-19 11:41:34

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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g"; }


     
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:66:1: entryRuleCompositeModel returns [EObject current=null] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final EObject entryRuleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:66:56: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:67:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:74:1: ruleCompositeModel returns [EObject current=null] : (lv_model= ruleModel )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:76:33: ( (lv_model= ruleModel )+ )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:77:1: (lv_model= ruleModel )+
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:77:1: (lv_model= ruleModel )+
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
            	    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:80:6: lv_model= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModel_in_ruleCompositeModel139);
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:105:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:105:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:106:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:113:1: ruleModel returns [EObject current=null] : ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id = null;

        AntlrDatatypeRuleToken lv_value = null;

        AntlrDatatypeRuleToken lv_vector = null;

        AntlrDatatypeRuleToken lv_dots = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:115:33: ( ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:1: ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:1: ( ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:2: ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:2: ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )? )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:3: ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? ) ( '+' (lv_dots= ruleDots ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:3: ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )? )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:4: ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ( '#' (lv_vector= ruleVector ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:4: ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:5: (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:116:5: (lv_id= ruleNestedModelId )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:119:6: lv_id= ruleNestedModelId
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNestedModelId_in_ruleModel248);
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

            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:137:2: ( ':' (lv_value= ruleFraction ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:137:3: ':' (lv_value= ruleFraction )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel262); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:141:1: (lv_value= ruleFraction )
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:144:6: lv_value= ruleFraction
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFraction_in_ruleModel296);
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

            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:162:5: ( '#' (lv_vector= ruleVector ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:162:6: '#' (lv_vector= ruleVector )
                    {
                    match(input,12,FOLLOW_12_in_ruleModel313); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:166:1: (lv_vector= ruleVector )
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:169:6: lv_vector= ruleVector
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleModel347);
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

            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:187:5: ( '+' (lv_dots= ruleDots ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:187:6: '+' (lv_dots= ruleDots )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel364); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:191:1: (lv_dots= ruleDots )
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:194:6: lv_dots= ruleDots
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDots_in_ruleModel398);
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

            match(input,14,FOLLOW_14_in_ruleModel414); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:223:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelId = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:223:48: (iv_ruleModelId= ruleModelId EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:224:2: iv_ruleModelId= ruleModelId EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModelId_in_entryRuleModelId448);
            iv_ruleModelId=ruleModelId();
            _fsp--;

             current =iv_ruleModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelId459); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:231:1: ruleModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:233:33: ( ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:234:1: ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:234:1: ( (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:234:2: (this_ID= RULE_ID kw= '.' ) this_ID= RULE_ID
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:234:2: (this_ID= RULE_ID kw= '.' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:234:7: this_ID= RULE_ID kw= '.'
            {
            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId500); 

            		current.merge(this_ID);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, null); 
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleModelId518); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId534); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:262:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedModelId = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:262:54: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:263:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId578);
            iv_ruleNestedModelId=ruleNestedModelId();
            _fsp--;

             current =iv_ruleNestedModelId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedModelId589); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:270:1: ruleNestedModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId ) ;
    public final AntlrDatatypeRuleToken ruleNestedModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ModelId = null;


         setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:272:33: ( ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:273:1: ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:273:1: ( (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:273:2: (this_ModelId= ruleModelId kw= '.' ) this_ModelId= ruleModelId
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:273:2: (this_ModelId= ruleModelId kw= '.' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:274:5: this_ModelId= ruleModelId kw= '.'
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId637);
            this_ModelId=ruleModelId();
            _fsp--;


            		current.merge(this_ModelId);
                
             
                    currentNode = currentNode.getParent();
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleNestedModelId655); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId678);
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:309:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFraction = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:309:49: (iv_ruleFraction= ruleFraction EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:310:2: iv_ruleFraction= ruleFraction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFraction_in_entryRuleFraction722);
            iv_ruleFraction=ruleFraction();
            _fsp--;

             current =iv_ruleFraction.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFraction733); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:317:1: ruleFraction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFraction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:319:33: ( (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:320:1: (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:320:1: (this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )? )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:320:6: this_INT= RULE_INT (kw= '/' this_INT= RULE_INT )?
            {
            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction773); 

            		current.merge(this_INT);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:327:1: (kw= '/' this_INT= RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:328:2: kw= '/' this_INT= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleFraction792); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    this_INT=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction807); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:348:1: entryRuleVector returns [String current=null] : iv_ruleVector= ruleVector EOF ;
    public final String entryRuleVector() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVector = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:348:47: (iv_ruleVector= ruleVector EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:349:2: iv_ruleVector= ruleVector EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleVector_in_entryRuleVector853);
            iv_ruleVector=ruleVector();
            _fsp--;

             current =iv_ruleVector.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVector864); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:356:1: ruleVector returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleVector() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:358:33: ( ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:359:1: ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:359:1: ( ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:359:2: ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT ) kw= ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:359:2: ( (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:359:3: (kw= '(' this_INT= RULE_INT ) this_INT= RULE_INT
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:359:3: (kw= '(' this_INT= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:360:2: kw= '(' this_INT= RULE_INT
            {
            kw=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleVector904); 

                    current.merge(kw);
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector919); 

            		current.merge(this_INT);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, null); 
                

            }

            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector940); 

            		current.merge(this_INT);
                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, null); 
                

            }

            kw=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleVector959); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:393:1: entryRuleDots returns [String current=null] : iv_ruleDots= ruleDots EOF ;
    public final String entryRuleDots() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDots = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:393:45: (iv_ruleDots= ruleDots EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:394:2: iv_ruleDots= ruleDots EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleDots_in_entryRuleDots998);
            iv_ruleDots=ruleDots();
            _fsp--;

             current =iv_ruleDots.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDots1009); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:401:1: ruleDots returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleDots() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:403:33: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:404:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:404:1: ( (kw= '.' kw= '.' ) | kw= '..' )
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
                    new NoViableAltException("404:1: ( (kw= '.' kw= '.' ) | kw= '..' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:404:2: (kw= '.' kw= '.' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:404:2: (kw= '.' kw= '.' )
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:405:2: kw= '.' kw= '.'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots1048); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6/@alternatives/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleDots1061); 

                            current.merge(kw);
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.6/@alternatives/@groups.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g:418:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleDots1081); 

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


 

    public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel139 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel248 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_11_in_ruleModel262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFraction_in_ruleModel296 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_12_in_ruleModel313 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleVector_in_ruleModel347 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModel364 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_ruleDots_in_ruleModel398 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModel414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelId459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId500 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModelId518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId637 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNestedModelId655 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFraction733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction773 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFraction792 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVector_in_entryRuleVector853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVector864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVector904 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector919 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector940 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVector959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDots_in_entryRuleDots998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDots1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDots1048 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDots1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDots1081 = new BitSet(new long[]{0x0000000000000002L});

}
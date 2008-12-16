// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g 2008-12-16 15:27:18

package org.eclipse.xtext.parser.datatyperules.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.ValueConverterException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDatatypeRulesTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "';'", "'.'", "'/'"
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g"; }


     
        public InternalDatatypeRulesTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalDatatypeRulesTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CompositeModel";	
       	} 



    // $ANTLR start entryRuleCompositeModel
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:64:1: entryRuleCompositeModel returns [EObject current=null] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final EObject entryRuleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:64:56: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:65:2: iv_ruleCompositeModel= ruleCompositeModel EOF
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:72:1: ruleCompositeModel returns [EObject current=null] : (lv_model= ruleModel )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:74:33: ( (lv_model= ruleModel )+ )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:75:1: (lv_model= ruleModel )+
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:75:1: (lv_model= ruleModel )+
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
            	    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:78:6: lv_model= ruleModel
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModel_in_ruleCompositeModel139);
            	    lv_model=ruleModel();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("CompositeModel");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "model", lv_model,"Model");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:103:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:103:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:104:2: iv_ruleModel= ruleModel EOF
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:111:1: ruleModel returns [EObject current=null] : ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        String lv_id = null;

        String lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:113:33: ( ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:114:1: ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:114:1: ( ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:114:2: ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:114:2: ( (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )? )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:114:3: (lv_id= ruleNestedModelId ) ( ':' (lv_value= ruleFraction ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:114:3: (lv_id= ruleNestedModelId )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:117:6: lv_id= ruleNestedModelId
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNestedModelId_in_ruleModel246);
            lv_id=ruleNestedModelId();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Model");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "id", lv_id,"NestedModelId");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:135:2: ( ':' (lv_value= ruleFraction ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:135:3: ':' (lv_value= ruleFraction )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel260); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:139:1: (lv_value= ruleFraction )
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:142:6: lv_value= ruleFraction
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFraction_in_ruleModel294);
                    lv_value=ruleFraction();
                    _fsp--;


                    	        currentNode = currentNode.getParent();
                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "value", lv_value,"Fraction");
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,12,FOLLOW_12_in_ruleModel310); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:171:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        String iv_ruleModelId = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:171:48: (iv_ruleModelId= ruleModelId EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:172:2: iv_ruleModelId= ruleModelId EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModelId_in_entryRuleModelId344);
            iv_ruleModelId=ruleModelId();
            _fsp--;

             current =iv_ruleModelId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelId355); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:179:1: ruleModelId returns [String current=null] : ( (this_ID= RULE_ID '.' ) this_ID= RULE_ID ) ;
    public final String ruleModelId() throws RecognitionException {
        String current = null;

        Token this_ID=null;

         StringBuilder buffer=new StringBuilder(20); setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:181:91: ( ( (this_ID= RULE_ID '.' ) this_ID= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:182:1: ( (this_ID= RULE_ID '.' ) this_ID= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:182:1: ( (this_ID= RULE_ID '.' ) this_ID= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:182:2: (this_ID= RULE_ID '.' ) this_ID= RULE_ID
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:182:2: (this_ID= RULE_ID '.' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:182:7: this_ID= RULE_ID '.'
            {
            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId396); 


            		buffer.append(this_ID.getText());

                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, null); 
                
            match(input,13,FOLLOW_13_in_ruleModelId410); 

                    buffer.append(".");
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelId426); 


            		buffer.append(this_ID.getText());

                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, null); 
                

            }


            }

             resetLookahead(); current = buffer.length() > 0 ? buffer.toString() : null; 
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:213:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        String iv_ruleNestedModelId = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:213:54: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:214:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId470);
            iv_ruleNestedModelId=ruleNestedModelId();
            _fsp--;

             current =iv_ruleNestedModelId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedModelId481); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:221:1: ruleNestedModelId returns [String current=null] : ( (this_ModelId= ruleModelId '.' ) this_ModelId= ruleModelId ) ;
    public final String ruleNestedModelId() throws RecognitionException {
        String current = null;

        String this_ModelId = null;


         StringBuilder buffer=new StringBuilder(20); setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:223:91: ( ( (this_ModelId= ruleModelId '.' ) this_ModelId= ruleModelId ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:224:1: ( (this_ModelId= ruleModelId '.' ) this_ModelId= ruleModelId )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:224:1: ( (this_ModelId= ruleModelId '.' ) this_ModelId= ruleModelId )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:224:2: (this_ModelId= ruleModelId '.' ) this_ModelId= ruleModelId
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:224:2: (this_ModelId= ruleModelId '.' )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:225:5: this_ModelId= ruleModelId '.'
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId529);
            this_ModelId=ruleModelId();
            _fsp--;



            		if (this_ModelId != null) buffer.append(this_ModelId);

                
             
                    currentNode = currentNode.getParent();
                
            match(input,13,FOLLOW_13_in_ruleNestedModelId543); 

                    buffer.append(".");
                    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleModelId_in_ruleNestedModelId566);
            this_ModelId=ruleModelId();
            _fsp--;



            		if (this_ModelId != null) buffer.append(this_ModelId);

                
             
                    currentNode = currentNode.getParent();
                

            }


            }

             resetLookahead(); current = buffer.length() > 0 ? buffer.toString() : null; 
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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:263:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        String iv_ruleFraction = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:263:49: (iv_ruleFraction= ruleFraction EOF )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:264:2: iv_ruleFraction= ruleFraction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFraction_in_entryRuleFraction610);
            iv_ruleFraction=ruleFraction();
            _fsp--;

             current =iv_ruleFraction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFraction621); 

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
    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:271:1: ruleFraction returns [String current=null] : (this_INT= RULE_INT ( '/' this_INT= RULE_INT )? ) ;
    public final String ruleFraction() throws RecognitionException {
        String current = null;

        Token this_INT=null;

         StringBuilder buffer=new StringBuilder(20); setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:273:91: ( (this_INT= RULE_INT ( '/' this_INT= RULE_INT )? ) )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:274:1: (this_INT= RULE_INT ( '/' this_INT= RULE_INT )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:274:1: (this_INT= RULE_INT ( '/' this_INT= RULE_INT )? )
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:274:6: this_INT= RULE_INT ( '/' this_INT= RULE_INT )?
            {
            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction661); 


            		buffer.append(this_INT.getText());

                
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:283:1: ( '/' this_INT= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g:283:2: '/' this_INT= RULE_INT
                    {
                    match(input,14,FOLLOW_14_in_ruleFraction676); 

                            buffer.append("/");
                            createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    this_INT=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFraction691); 


                    		buffer.append(this_INT.getText());

                        
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::RuleCall */, null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); current = buffer.length() > 0 ? buffer.toString() : null; 
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


 

    public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel139 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel246 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_11_in_ruleModel260 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFraction_in_ruleModel294 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelId355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId396 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleModelId410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelId426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId529 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNestedModelId543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFraction621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction661 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleFraction676 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFraction691 = new BitSet(new long[]{0x0000000000000002L});

}
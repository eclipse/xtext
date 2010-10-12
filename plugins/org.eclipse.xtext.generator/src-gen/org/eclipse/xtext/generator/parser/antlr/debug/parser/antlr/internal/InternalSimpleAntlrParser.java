package org.eclipse.xtext.generator.parser.antlr.debug.parser.antlr.internal; 

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
import org.eclipse.xtext.generator.parser.antlr.debug.services.SimpleAntlrGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleAntlrParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "';'", "'options'", "'{'", "'}'", "'='", "':'", "'|'", "'+'", "'*'", "'?'", "'~'", "'..'", "'('", "')'", "'{skip();}'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSimpleAntlrParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g"; }



     	private SimpleAntlrGrammarAccess grammarAccess;
     	
        public InternalSimpleAntlrParser(TokenStream input, IAstFactory factory, SimpleAntlrGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AntlrGrammar";	
       	}
       	
       	@Override
       	protected SimpleAntlrGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleAntlrGrammar
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:77:1: entryRuleAntlrGrammar returns [EObject current=null] : iv_ruleAntlrGrammar= ruleAntlrGrammar EOF ;
    public final EObject entryRuleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntlrGrammar = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:78:2: (iv_ruleAntlrGrammar= ruleAntlrGrammar EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:79:2: iv_ruleAntlrGrammar= ruleAntlrGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAntlrGrammarRule(), currentNode); 
            pushFollow(FOLLOW_ruleAntlrGrammar_in_entryRuleAntlrGrammar75);
            iv_ruleAntlrGrammar=ruleAntlrGrammar();
            _fsp--;

             current =iv_ruleAntlrGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAntlrGrammar85); 

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
    // $ANTLR end entryRuleAntlrGrammar


    // $ANTLR start ruleAntlrGrammar
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:86:1: ruleAntlrGrammar returns [EObject current=null] : ( 'grammar' ( (lv_name_1_0= RULE_ID ) ) ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) ;
    public final EObject ruleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_options_3_0 = null;

        EObject lv_rules_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:91:6: ( ( 'grammar' ( (lv_name_1_0= RULE_ID ) ) ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:92:1: ( 'grammar' ( (lv_name_1_0= RULE_ID ) ) ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:92:1: ( 'grammar' ( (lv_name_1_0= RULE_ID ) ) ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:92:3: 'grammar' ( (lv_name_1_0= RULE_ID ) ) ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )*
            {
            match(input,11,FOLLOW_11_in_ruleAntlrGrammar120); 

                    createLeafNode(grammarAccess.getAntlrGrammarAccess().getGrammarKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:96:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:97:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:97:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:98:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAntlrGrammar137); 

            			createLeafNode(grammarAccess.getAntlrGrammarAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAntlrGrammarRule().getType().getClassifier());
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

            match(input,12,FOLLOW_12_in_ruleAntlrGrammar152); 

                    createLeafNode(grammarAccess.getAntlrGrammarAccess().getSemicolonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:124:1: ( (lv_options_3_0= ruleOptions ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:125:1: (lv_options_3_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:125:1: (lv_options_3_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:126:3: lv_options_3_0= ruleOptions
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAntlrGrammarAccess().getOptionsOptionsParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleAntlrGrammar173);
                    lv_options_3_0=ruleOptions();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAntlrGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"options",
                    	        		lv_options_3_0, 
                    	        		"Options", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:148:3: ( (lv_rules_4_0= ruleRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:149:1: (lv_rules_4_0= ruleRule )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:149:1: (lv_rules_4_0= ruleRule )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:150:3: lv_rules_4_0= ruleRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAntlrGrammarAccess().getRulesRuleParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRule_in_ruleAntlrGrammar195);
            	    lv_rules_4_0=ruleRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAntlrGrammarRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"rules",
            	    	        		lv_rules_4_0, 
            	    	        		"Rule", 
            	    	        		currentNode);
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
    // $ANTLR end ruleAntlrGrammar


    // $ANTLR start entryRuleOptions
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:180:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:181:2: (iv_ruleOptions= ruleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:182:2: iv_ruleOptions= ruleOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionsRule(), currentNode); 
            pushFollow(FOLLOW_ruleOptions_in_entryRuleOptions232);
            iv_ruleOptions=ruleOptions();
            _fsp--;

             current =iv_ruleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptions242); 

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
    // $ANTLR end entryRuleOptions


    // $ANTLR start ruleOptions
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:189:1: ruleOptions returns [EObject current=null] : ( () 'options' '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* '}' ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        EObject lv_optionValues_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:194:6: ( ( () 'options' '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* '}' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:195:1: ( () 'options' '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* '}' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:195:1: ( () 'options' '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* '}' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:195:2: () 'options' '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* '}'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:195:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:196:5: 
            {
             
                    temp=factory.create(grammarAccess.getOptionsAccess().getOptionsAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getOptionsAccess().getOptionsAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,13,FOLLOW_13_in_ruleOptions286); 

                    createLeafNode(grammarAccess.getOptionsAccess().getOptionsKeyword_1(), null); 
                
            match(input,14,FOLLOW_14_in_ruleOptions296); 

                    createLeafNode(grammarAccess.getOptionsAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:214:1: ( (lv_optionValues_3_0= ruleOptionValue ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:215:1: (lv_optionValues_3_0= ruleOptionValue )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:215:1: (lv_optionValues_3_0= ruleOptionValue )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:216:3: lv_optionValues_3_0= ruleOptionValue
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOptionsAccess().getOptionValuesOptionValueParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionValue_in_ruleOptions317);
            	    lv_optionValues_3_0=ruleOptionValue();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOptionsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"optionValues",
            	    	        		lv_optionValues_3_0, 
            	    	        		"OptionValue", 
            	    	        		currentNode);
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

            match(input,15,FOLLOW_15_in_ruleOptions328); 

                    createLeafNode(grammarAccess.getOptionsAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleOptions


    // $ANTLR start entryRuleOptionValue
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:250:1: entryRuleOptionValue returns [EObject current=null] : iv_ruleOptionValue= ruleOptionValue EOF ;
    public final EObject entryRuleOptionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionValue = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:251:2: (iv_ruleOptionValue= ruleOptionValue EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:252:2: iv_ruleOptionValue= ruleOptionValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleOptionValue_in_entryRuleOptionValue364);
            iv_ruleOptionValue=ruleOptionValue();
            _fsp--;

             current =iv_ruleOptionValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptionValue374); 

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
    // $ANTLR end entryRuleOptionValue


    // $ANTLR start ruleOptionValue
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:259:1: ruleOptionValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= ruleIdOrInt ) ) ';' ) ;
    public final EObject ruleOptionValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:264:6: ( ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= ruleIdOrInt ) ) ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:265:1: ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= ruleIdOrInt ) ) ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:265:1: ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= ruleIdOrInt ) ) ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:265:2: ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= ruleIdOrInt ) ) ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:265:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:266:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:266:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:267:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptionValue416); 

            			createLeafNode(grammarAccess.getOptionValueAccess().getKeyIDTerminalRuleCall_0_0(), "key"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOptionValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"key",
            	        		lv_key_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleOptionValue431); 

                    createLeafNode(grammarAccess.getOptionValueAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:293:1: ( (lv_value_2_0= ruleIdOrInt ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:294:1: (lv_value_2_0= ruleIdOrInt )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:294:1: (lv_value_2_0= ruleIdOrInt )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:295:3: lv_value_2_0= ruleIdOrInt
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOptionValueAccess().getValueIdOrIntParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleIdOrInt_in_ruleOptionValue452);
            lv_value_2_0=ruleIdOrInt();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOptionValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"IdOrInt", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleOptionValue462); 

                    createLeafNode(grammarAccess.getOptionValueAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleOptionValue


    // $ANTLR start entryRuleIdOrInt
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:329:1: entryRuleIdOrInt returns [String current=null] : iv_ruleIdOrInt= ruleIdOrInt EOF ;
    public final String entryRuleIdOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrInt = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:330:2: (iv_ruleIdOrInt= ruleIdOrInt EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:331:2: iv_ruleIdOrInt= ruleIdOrInt EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIdOrIntRule(), currentNode); 
            pushFollow(FOLLOW_ruleIdOrInt_in_entryRuleIdOrInt499);
            iv_ruleIdOrInt=ruleIdOrInt();
            _fsp--;

             current =iv_ruleIdOrInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrInt510); 

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
    // $ANTLR end entryRuleIdOrInt


    // $ANTLR start ruleIdOrInt
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:338:1: ruleIdOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleIdOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:343:6: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:344:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:344:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("344:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:344:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdOrInt550); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(grammarAccess.getIdOrIntAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:352:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIdOrInt576); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getIdOrIntAccess().getINTTerminalRuleCall_1(), null); 
                        

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
    // $ANTLR end ruleIdOrInt


    // $ANTLR start entryRuleRule
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:367:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:368:2: (iv_ruleRule= ruleRule EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:369:2: iv_ruleRule= ruleRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRule_in_entryRuleRule621);
            iv_ruleRule=ruleRule();
            _fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRule631); 

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
    // $ANTLR end entryRuleRule


    // $ANTLR start ruleRule
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:376:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_body_2_0= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:381:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_body_2_0= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:382:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_body_2_0= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:382:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_body_2_0= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:382:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_body_2_0= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:382:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:383:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:383:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:384:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRule673); 

            			createLeafNode(grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleRule().getType().getClassifier());
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

            match(input,17,FOLLOW_17_in_ruleRule688); 

                    createLeafNode(grammarAccess.getRuleAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:410:1: ( (lv_body_2_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:411:1: (lv_body_2_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:411:1: (lv_body_2_0= ruleAlternatives )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:412:3: lv_body_2_0= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRuleAccess().getBodyAlternativesParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleRule709);
            lv_body_2_0=ruleAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_2_0, 
            	        		"Alternatives", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleRule719); 

                    createLeafNode(grammarAccess.getRuleAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleRule


    // $ANTLR start entryRuleAlternatives
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:446:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:447:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:448:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives755);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives765); 

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
    // $ANTLR end entryRuleAlternatives


    // $ANTLR start ruleAlternatives
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:455:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:460:6: ( (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:461:1: (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:461:1: (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:462:5: this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives812);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:470:1: ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:470:2: () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:470:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:471:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:486:2: ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:486:4: '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    match(input,18,FOLLOW_18_in_ruleAlternatives832); 

                    	            createLeafNode(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:490:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:491:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:491:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:492:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives853);
                    	    lv_groups_3_0=ruleGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"groups",
                    	    	        		lv_groups_3_0, 
                    	    	        		"Group", 
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
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:522:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:523:2: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:524:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup893);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup903); 

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
    // $ANTLR end entryRuleGroup


    // $ANTLR start ruleGroup
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:531:1: ruleGroup returns [EObject current=null] : (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject lv_elements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:536:6: ( (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:537:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:537:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:538:5: this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAtomParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAtom_in_ruleGroup950);
            this_Atom_0=ruleAtom();
            _fsp--;

             
                    current = this_Atom_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:546:1: ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==RULE_STRING||LA8_0==13||LA8_0==22||LA8_0==24||(LA8_0>=26 && LA8_0<=27)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:546:2: () ( (lv_elements_2_0= ruleAtom ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:546:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:547:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getGroupAccess().getGroupElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getGroupAccess().getGroupElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:562:2: ( (lv_elements_2_0= ruleAtom ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID||LA7_0==RULE_STRING||LA7_0==13||LA7_0==22||LA7_0==24||(LA7_0>=26 && LA7_0<=27)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:563:1: (lv_elements_2_0= ruleAtom )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:563:1: (lv_elements_2_0= ruleAtom )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:564:3: lv_elements_2_0= ruleAtom
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getElementsAtomParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAtom_in_ruleGroup980);
                    	    lv_elements_2_0=ruleAtom();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_2_0, 
                    	    	        		"Atom", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:594:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:595:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:596:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom1019);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom1029); 

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
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:603:1: ruleAtom returns [EObject current=null] : ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_OtherElement_0 = null;

        EObject this_RuleOptions_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:608:6: ( ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:609:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:609:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==RULE_STRING||LA11_0==22||LA11_0==24||LA11_0==27) ) {
                alt11=1;
            }
            else if ( (LA11_0==13||LA11_0==26) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("609:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:609:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:609:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:610:5: this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getOtherElementParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOtherElement_in_ruleAtom1077);
                    this_OtherElement_0=ruleOtherElement();
                    _fsp--;

                     
                            current = this_OtherElement_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:618:1: ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=19 && LA10_0<=21)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:618:2: () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:618:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:619:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getAtomAccess().getElementWithCardinalityElementAction_0_1_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "element", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getAtomAccess().getElementWithCardinalityElementAction_0_1_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:634:2: ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:635:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:635:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:636:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:636:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            int alt9=3;
                            switch ( input.LA(1) ) {
                            case 19:
                                {
                                alt9=1;
                                }
                                break;
                            case 20:
                                {
                                alt9=2;
                                }
                                break;
                            case 21:
                                {
                                alt9=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("636:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )", 9, 0, input);

                                throw nvae;
                            }

                            switch (alt9) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:637:3: lv_cardinality_2_1= '+'
                                    {
                                    lv_cardinality_2_1=(Token)input.LT(1);
                                    match(input,19,FOLLOW_19_in_ruleAtom1106); 

                                            createLeafNode(grammarAccess.getAtomAccess().getCardinalityPlusSignKeyword_0_1_1_0_0(), "cardinality"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getAtomRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "cardinality", lv_cardinality_2_1, null, lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:655:8: lv_cardinality_2_2= '*'
                                    {
                                    lv_cardinality_2_2=(Token)input.LT(1);
                                    match(input,20,FOLLOW_20_in_ruleAtom1135); 

                                            createLeafNode(grammarAccess.getAtomAccess().getCardinalityAsteriskKeyword_0_1_1_0_1(), "cardinality"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getAtomRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "cardinality", lv_cardinality_2_2, null, lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:673:8: lv_cardinality_2_3= '?'
                                    {
                                    lv_cardinality_2_3=(Token)input.LT(1);
                                    match(input,21,FOLLOW_21_in_ruleAtom1164); 

                                            createLeafNode(grammarAccess.getAtomAccess().getCardinalityQuestionMarkKeyword_0_1_1_0_2(), "cardinality"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getAtomRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "cardinality", lv_cardinality_2_3, null, lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }
                                    break;

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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:696:5: this_RuleOptions_3= ruleRuleOptions
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getRuleOptionsParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleOptions_in_ruleAtom1211);
                    this_RuleOptions_3=ruleRuleOptions();
                    _fsp--;

                     
                            current = this_RuleOptions_3; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleOtherElement
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:712:1: entryRuleOtherElement returns [EObject current=null] : iv_ruleOtherElement= ruleOtherElement EOF ;
    public final EObject entryRuleOtherElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherElement = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:713:2: (iv_ruleOtherElement= ruleOtherElement EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:714:2: iv_ruleOtherElement= ruleOtherElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOtherElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleOtherElement_in_entryRuleOtherElement1246);
            iv_ruleOtherElement=ruleOtherElement();
            _fsp--;

             current =iv_ruleOtherElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherElement1256); 

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
    // $ANTLR end entryRuleOtherElement


    // $ANTLR start ruleOtherElement
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:1: ruleOtherElement returns [EObject current=null] : ( ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) ;
    public final EObject ruleOtherElement() throws RecognitionException {
        EObject current = null;

        EObject lv_element_2_1 = null;

        EObject lv_element_2_2 = null;

        EObject this_Parenthesized_3 = null;

        EObject this_Literal_4 = null;

        EObject lv_right_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:726:6: ( ( ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:727:1: ( ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:727:1: ( ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt14=1;
                }
                break;
            case 24:
                {
                alt14=2;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case 27:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("727:1: ( ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:727:2: ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:727:2: ( () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:727:3: () '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:727:3: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:728:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getOtherElementAccess().getNegatedElementAction_0_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getOtherElementAccess().getNegatedElementAction_0_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,22,FOLLOW_22_in_ruleOtherElement1301); 

                            createLeafNode(grammarAccess.getOtherElementAccess().getTildeKeyword_0_1(), null); 
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:742:1: ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:743:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:743:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:744:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:744:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==24) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_ID||LA12_0==RULE_STRING||LA12_0==27) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("744:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:745:3: lv_element_2_1= ruleParenthesized
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getElementParenthesizedParserRuleCall_0_2_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1324);
                            lv_element_2_1=ruleParenthesized();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getOtherElementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"element",
                            	        		lv_element_2_1, 
                            	        		"Parenthesized", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:766:8: lv_element_2_2= ruleLiteral
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getElementLiteralParserRuleCall_0_2_0_1(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1343);
                            lv_element_2_2=ruleLiteral();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getOtherElementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"element",
                            	        		lv_element_2_2, 
                            	        		"Literal", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:792:5: this_Parenthesized_3= ruleParenthesized
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getParenthesizedParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1375);
                    this_Parenthesized_3=ruleParenthesized();
                    _fsp--;

                     
                            current = this_Parenthesized_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:801:6: (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:801:6: (this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:802:5: this_Literal_4= ruleLiteral ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getLiteralParserRuleCall_2_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1403);
                    this_Literal_4=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_4; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:810:1: ( () '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:810:2: () '..' ( (lv_right_7_0= ruleLiteral ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:810:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:811:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getOtherElementAccess().getUntilElementLeftAction_2_1_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getOtherElementAccess().getUntilElementLeftAction_2_1_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            match(input,23,FOLLOW_23_in_ruleOtherElement1422); 

                                    createLeafNode(grammarAccess.getOtherElementAccess().getFullStopFullStopKeyword_2_1_1(), null); 
                                
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:830:1: ( (lv_right_7_0= ruleLiteral ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:831:1: (lv_right_7_0= ruleLiteral )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:831:1: (lv_right_7_0= ruleLiteral )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:832:3: lv_right_7_0= ruleLiteral
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getRightLiteralParserRuleCall_2_1_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1443);
                            lv_right_7_0=ruleLiteral();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getOtherElementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"right",
                            	        		lv_right_7_0, 
                            	        		"Literal", 
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


                    }


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
    // $ANTLR end ruleOtherElement


    // $ANTLR start entryRuleEmptyParenthesis
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:862:1: entryRuleEmptyParenthesis returns [String current=null] : iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF ;
    public final String entryRuleEmptyParenthesis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEmptyParenthesis = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:863:2: (iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:864:2: iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyParenthesisRule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyParenthesis_in_entryRuleEmptyParenthesis1483);
            iv_ruleEmptyParenthesis=ruleEmptyParenthesis();
            _fsp--;

             current =iv_ruleEmptyParenthesis.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyParenthesis1494); 

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
    // $ANTLR end entryRuleEmptyParenthesis


    // $ANTLR start ruleEmptyParenthesis
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:871:1: ruleEmptyParenthesis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleEmptyParenthesis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:876:6: ( (kw= '(' kw= ')' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:877:1: (kw= '(' kw= ')' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:877:1: (kw= '(' kw= ')' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:878:2: kw= '(' kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,24,FOLLOW_24_in_ruleEmptyParenthesis1532); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getEmptyParenthesisAccess().getLeftParenthesisKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,25,FOLLOW_25_in_ruleEmptyParenthesis1545); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getEmptyParenthesisAccess().getRightParenthesisKeyword_1(), null); 
                

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
    // $ANTLR end ruleEmptyParenthesis


    // $ANTLR start entryRuleParenthesized
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:897:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:898:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:899:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesized_in_entryRuleParenthesized1585);
            iv_ruleParenthesized=ruleParenthesized();
            _fsp--;

             current =iv_ruleParenthesized; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesized1595); 

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
    // $ANTLR end entryRuleParenthesized


    // $ANTLR start ruleParenthesized
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:906:1: ruleParenthesized returns [EObject current=null] : ( '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives ')' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:911:6: ( ( '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives ')' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:912:1: ( '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives ')' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:912:1: ( '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives ')' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:912:3: '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives ')' ( ruleEmptyParenthesis )*
            {
            match(input,24,FOLLOW_24_in_ruleParenthesized1630); 

                    createLeafNode(grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:916:1: ( ruleEmptyParenthesis )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==25) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:917:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1647);
            	    ruleEmptyParenthesis();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAccess().getAlternativesParserRuleCall_2(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesized1670);
            this_Alternatives_2=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_2; 
                    currentNode = currentNode.getParent();
                
            match(input,25,FOLLOW_25_in_ruleParenthesized1679); 

                    createLeafNode(grammarAccess.getParenthesizedAccess().getRightParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:937:1: ( ruleEmptyParenthesis )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    int LA16_2 = input.LA(2);

                    if ( (LA16_2==25) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:938:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_4(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1696);
            	    ruleEmptyParenthesis();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


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
    // $ANTLR end ruleParenthesized


    // $ANTLR start entryRuleRuleOptions
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:953:1: entryRuleRuleOptions returns [EObject current=null] : iv_ruleRuleOptions= ruleRuleOptions EOF ;
    public final EObject entryRuleRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:954:2: (iv_ruleRuleOptions= ruleRuleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:955:2: iv_ruleRuleOptions= ruleRuleOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleOptionsRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleOptions_in_entryRuleRuleOptions1733);
            iv_ruleRuleOptions=ruleRuleOptions();
            _fsp--;

             current =iv_ruleRuleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleOptions1743); 

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
    // $ANTLR end entryRuleRuleOptions


    // $ANTLR start ruleRuleOptions
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:1: ruleRuleOptions returns [EObject current=null] : ( ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () '{skip();}' ) ) ;
    public final EObject ruleRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject lv_options_0_0 = null;

        EObject lv_element_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:967:6: ( ( ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () '{skip();}' ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:1: ( ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () '{skip();}' ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:1: ( ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () '{skip();}' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            else if ( (LA17_0==26) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("968:1: ( ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () '{skip();}' ) )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:2: ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:2: ( ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:3: ( (lv_options_0_0= ruleOptions ) ) ':' ( (lv_element_2_0= ruleAtom ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:3: ( (lv_options_0_0= ruleOptions ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:969:1: (lv_options_0_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:969:1: (lv_options_0_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:970:3: lv_options_0_0= ruleOptions
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleOptionsAccess().getOptionsOptionsParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleRuleOptions1790);
                    lv_options_0_0=ruleOptions();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleOptionsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"options",
                    	        		lv_options_0_0, 
                    	        		"Options", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleRuleOptions1800); 

                            createLeafNode(grammarAccess.getRuleOptionsAccess().getColonKeyword_0_1(), null); 
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:996:1: ( (lv_element_2_0= ruleAtom ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:997:1: (lv_element_2_0= ruleAtom )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:997:1: (lv_element_2_0= ruleAtom )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:998:3: lv_element_2_0= ruleAtom
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleOptionsAccess().getElementAtomParserRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAtom_in_ruleRuleOptions1821);
                    lv_element_2_0=ruleAtom();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleOptionsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"element",
                    	        		lv_element_2_0, 
                    	        		"Atom", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1021:6: ( () '{skip();}' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1021:6: ( () '{skip();}' )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1021:7: () '{skip();}'
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1021:7: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1022:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRuleOptionsAccess().getSkipAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRuleOptionsAccess().getSkipAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,26,FOLLOW_26_in_ruleRuleOptions1848); 

                            createLeafNode(grammarAccess.getRuleOptionsAccess().getSkipKeyword_1_1(), null); 
                        

                    }


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
    // $ANTLR end ruleRuleOptions


    // $ANTLR start entryRuleLiteral
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1044:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1045:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1046:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1885);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1895); 

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
    // $ANTLR end entryRuleLiteral


    // $ANTLR start ruleLiteral
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1053:1: ruleLiteral returns [EObject current=null] : (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RuleCall_0 = null;

        EObject this_Keyword_1 = null;

        EObject this_Wildcard_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1058:6: ( (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1059:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1059:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt18=1;
                }
                break;
            case RULE_STRING:
                {
                alt18=2;
                }
                break;
            case 27:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1059:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1060:5: this_RuleCall_0= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getRuleCallParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleLiteral1942);
                    this_RuleCall_0=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1070:5: this_Keyword_1= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getKeywordParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleLiteral1969);
                    this_Keyword_1=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1080:5: this_Wildcard_2= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getWildcardParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleLiteral1996);
                    this_Wildcard_2=ruleWildcard();
                    _fsp--;

                     
                            current = this_Wildcard_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleLiteral


    // $ANTLR start entryRuleRuleCall
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1096:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1097:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1098:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2031);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2041); 

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
    // $ANTLR end entryRuleRuleCall


    // $ANTLR start ruleRuleCall
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1105:1: ruleRuleCall returns [EObject current=null] : ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_rule_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1110:6: ( ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1111:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1111:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1111:2: ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1111:2: ( (lv_rule_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1112:1: (lv_rule_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1112:1: (lv_rule_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1113:3: lv_rule_0_0= RULE_ID
            {
            lv_rule_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2083); 

            			createLeafNode(grammarAccess.getRuleCallAccess().getRuleIDTerminalRuleCall_0_0(), "rule"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rule",
            	        		lv_rule_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1135:2: ( ruleEmptyParenthesis )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==24) ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2==25) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1136:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getRuleCallAccess().getEmptyParenthesisParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2105);
            	    ruleEmptyParenthesis();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


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
    // $ANTLR end ruleRuleCall


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1151:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1152:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1153:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2142);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2152); 

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
    // $ANTLR end entryRuleKeyword


    // $ANTLR start ruleKeyword
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1160:1: ruleKeyword returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1165:6: ( ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1166:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1166:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1166:2: ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1166:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1167:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1167:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1168:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2194); 

            			createLeafNode(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKeywordRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1190:2: ( ruleEmptyParenthesis )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==24) ) {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2==25) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1191:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getKeywordAccess().getEmptyParenthesisParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2216);
            	    ruleEmptyParenthesis();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1206:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1207:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1208:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard2253);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard2263); 

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
    // $ANTLR end entryRuleWildcard


    // $ANTLR start ruleWildcard
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1215:1: ruleWildcard returns [EObject current=null] : ( () '.' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1220:6: ( ( () '.' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1221:1: ( () '.' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1221:1: ( () '.' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1221:2: () '.' ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1221:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1222:5: 
            {
             
                    temp=factory.create(grammarAccess.getWildcardAccess().getWildcardAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getWildcardAccess().getWildcardAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,27,FOLLOW_27_in_ruleWildcard2307); 

                    createLeafNode(grammarAccess.getWildcardAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1236:1: ( ruleEmptyParenthesis )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==24) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==25) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1237:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getWildcardAccess().getEmptyParenthesisParserRuleCall_2(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2324);
            	    ruleEmptyParenthesis();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


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
    // $ANTLR end ruleWildcard


 

    public static final BitSet FOLLOW_ruleAntlrGrammar_in_entryRuleAntlrGrammar75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAntlrGrammar85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAntlrGrammar120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAntlrGrammar137 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAntlrGrammar152 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleAntlrGrammar173 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleRule_in_ruleAntlrGrammar195 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOptions286 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleOptions296 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleOptionValue_in_ruleOptions317 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleOptions328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionValue_in_entryRuleOptionValue364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptionValue374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptionValue416 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOptionValue431 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleIdOrInt_in_ruleOptionValue452 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleOptionValue462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrInt_in_entryRuleIdOrInt499 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrInt510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrInt550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIdOrInt576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRule_in_entryRuleRule621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRule631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRule673 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRule688 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleRule709 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRule719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives812 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleAlternatives832 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives853 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleGroup950 = new BitSet(new long[]{0x000000000D402052L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleGroup980 = new BitSet(new long[]{0x000000000D402052L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom1019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherElement_in_ruleAtom1077 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_19_in_ruleAtom1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAtom1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAtom1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleOptions_in_ruleAtom1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherElement_in_entryRuleOtherElement1246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherElement1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOtherElement1301 = new BitSet(new long[]{0x0000000009000050L});
    public static final BitSet FOLLOW_ruleParenthesized_in_ruleOtherElement1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesized_in_ruleOtherElement1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1403 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleOtherElement1422 = new BitSet(new long[]{0x0000000008000050L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_entryRuleEmptyParenthesis1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyParenthesis1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleEmptyParenthesis1532 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEmptyParenthesis1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesized_in_entryRuleParenthesized1585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesized1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesized1630 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1647 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesized1670 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParenthesized1679 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1696 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleRuleOptions_in_entryRuleRuleOptions1733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleOptions1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleRuleOptions1790 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRuleOptions1800 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleRuleOptions1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRuleOptions1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleLiteral1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleLiteral1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleLiteral1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2083 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2105 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2194 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2216 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleWildcard2307 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2324 = new BitSet(new long[]{0x0000000001000002L});

}
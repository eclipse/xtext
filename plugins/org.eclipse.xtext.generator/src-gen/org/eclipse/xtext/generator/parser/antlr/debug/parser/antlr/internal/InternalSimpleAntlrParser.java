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
    public static final int T__12=12;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalSimpleAntlrParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleAntlrParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleAntlrParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g"; }



     	private SimpleAntlrGrammarAccess grammarAccess;
     	
        public InternalSimpleAntlrParser(TokenStream input, IAstFactory factory, SimpleAntlrGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AntlrGrammar";	
       	}
       	
       	@Override
       	protected SimpleAntlrGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAntlrGrammar"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:71:1: entryRuleAntlrGrammar returns [EObject current=null] : iv_ruleAntlrGrammar= ruleAntlrGrammar EOF ;
    public final EObject entryRuleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntlrGrammar = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:72:2: (iv_ruleAntlrGrammar= ruleAntlrGrammar EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:73:2: iv_ruleAntlrGrammar= ruleAntlrGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAntlrGrammarRule(), currentNode); 
            pushFollow(FOLLOW_ruleAntlrGrammar_in_entryRuleAntlrGrammar75);
            iv_ruleAntlrGrammar=ruleAntlrGrammar();

            state._fsp--;

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
    // $ANTLR end "entryRuleAntlrGrammar"


    // $ANTLR start "ruleAntlrGrammar"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:80:1: ruleAntlrGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) ;
    public final EObject ruleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_options_3_0 = null;

        EObject lv_rules_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:85:6: ( (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:86:1: (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:86:1: (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:86:3: otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAntlrGrammar122); 

                	createLeafNode(otherlv_0, grammarAccess.getAntlrGrammarAccess().getGrammarKeyword_0(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:91:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAntlrGrammar139); 

            			createLeafNode(lv_name_1_0, grammarAccess.getAntlrGrammarAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleAntlrGrammar156); 

                	createLeafNode(otherlv_2, grammarAccess.getAntlrGrammarAccess().getSemicolonKeyword_2(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:118:1: ( (lv_options_3_0= ruleOptions ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:119:1: (lv_options_3_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:119:1: (lv_options_3_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:120:3: lv_options_3_0= ruleOptions
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAntlrGrammarAccess().getOptionsOptionsParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleAntlrGrammar177);
                    lv_options_3_0=ruleOptions();

                    state._fsp--;


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

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:142:3: ( (lv_rules_4_0= ruleRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:143:1: (lv_rules_4_0= ruleRule )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:143:1: (lv_rules_4_0= ruleRule )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:144:3: lv_rules_4_0= ruleRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAntlrGrammarAccess().getRulesRuleParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRule_in_ruleAntlrGrammar199);
            	    lv_rules_4_0=ruleRule();

            	    state._fsp--;


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
    // $ANTLR end "ruleAntlrGrammar"


    // $ANTLR start "entryRuleOptions"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:174:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:175:2: (iv_ruleOptions= ruleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:176:2: iv_ruleOptions= ruleOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionsRule(), currentNode); 
            pushFollow(FOLLOW_ruleOptions_in_entryRuleOptions236);
            iv_ruleOptions=ruleOptions();

            state._fsp--;

             current =iv_ruleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptions246); 

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
    // $ANTLR end "entryRuleOptions"


    // $ANTLR start "ruleOptions"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:183:1: ruleOptions returns [EObject current=null] : ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_optionValues_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:188:6: ( ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:189:1: ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:189:1: ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:189:2: () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:189:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:190:5: 
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

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleOptions292); 

                	createLeafNode(otherlv_1, grammarAccess.getOptionsAccess().getOptionsKeyword_1(), null);
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleOptions304); 

                	createLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getLeftCurlyBracketKeyword_2(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:208:1: ( (lv_optionValues_3_0= ruleOptionValue ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:209:1: (lv_optionValues_3_0= ruleOptionValue )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:209:1: (lv_optionValues_3_0= ruleOptionValue )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:210:3: lv_optionValues_3_0= ruleOptionValue
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOptionsAccess().getOptionValuesOptionValueParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionValue_in_ruleOptions325);
            	    lv_optionValues_3_0=ruleOptionValue();

            	    state._fsp--;


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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleOptions338); 

                	createLeafNode(otherlv_4, grammarAccess.getOptionsAccess().getRightCurlyBracketKeyword_4(), null);
                

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
    // $ANTLR end "ruleOptions"


    // $ANTLR start "entryRuleOptionValue"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:244:1: entryRuleOptionValue returns [EObject current=null] : iv_ruleOptionValue= ruleOptionValue EOF ;
    public final EObject entryRuleOptionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionValue = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:245:2: (iv_ruleOptionValue= ruleOptionValue EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:246:2: iv_ruleOptionValue= ruleOptionValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleOptionValue_in_entryRuleOptionValue374);
            iv_ruleOptionValue=ruleOptionValue();

            state._fsp--;

             current =iv_ruleOptionValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptionValue384); 

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
    // $ANTLR end "entryRuleOptionValue"


    // $ANTLR start "ruleOptionValue"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:253:1: ruleOptionValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' ) ;
    public final EObject ruleOptionValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:258:6: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:259:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:259:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:259:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:259:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:260:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:260:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:261:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptionValue426); 

            			createLeafNode(lv_key_0_0, grammarAccess.getOptionValueAccess().getKeyIDTerminalRuleCall_0_0(), "key"); 
            		

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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleOptionValue443); 

                	createLeafNode(otherlv_1, grammarAccess.getOptionValueAccess().getEqualsSignKeyword_1(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:287:1: ( (lv_value_2_0= ruleIdOrInt ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:288:1: (lv_value_2_0= ruleIdOrInt )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:288:1: (lv_value_2_0= ruleIdOrInt )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:289:3: lv_value_2_0= ruleIdOrInt
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOptionValueAccess().getValueIdOrIntParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleIdOrInt_in_ruleOptionValue464);
            lv_value_2_0=ruleIdOrInt();

            state._fsp--;


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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleOptionValue476); 

                	createLeafNode(otherlv_3, grammarAccess.getOptionValueAccess().getSemicolonKeyword_3(), null);
                

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
    // $ANTLR end "ruleOptionValue"


    // $ANTLR start "entryRuleIdOrInt"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:323:1: entryRuleIdOrInt returns [String current=null] : iv_ruleIdOrInt= ruleIdOrInt EOF ;
    public final String entryRuleIdOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrInt = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:324:2: (iv_ruleIdOrInt= ruleIdOrInt EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:325:2: iv_ruleIdOrInt= ruleIdOrInt EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIdOrIntRule(), currentNode); 
            pushFollow(FOLLOW_ruleIdOrInt_in_entryRuleIdOrInt513);
            iv_ruleIdOrInt=ruleIdOrInt();

            state._fsp--;

             current =iv_ruleIdOrInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrInt524); 

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
    // $ANTLR end "entryRuleIdOrInt"


    // $ANTLR start "ruleIdOrInt"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:332:1: ruleIdOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleIdOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:337:6: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:338:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:338:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:338:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdOrInt564); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(this_ID_0, grammarAccess.getIdOrIntAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:346:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIdOrInt590); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(this_INT_1, grammarAccess.getIdOrIntAccess().getINTTerminalRuleCall_1(), null); 
                        

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
    // $ANTLR end "ruleIdOrInt"


    // $ANTLR start "entryRuleRule"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:361:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:362:2: (iv_ruleRule= ruleRule EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:363:2: iv_ruleRule= ruleRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRule_in_entryRuleRule635);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRule645); 

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
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:370:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:375:6: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:376:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:376:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:376:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:376:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:377:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:377:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:378:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRule687); 

            			createLeafNode(lv_name_0_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleRule704); 

                	createLeafNode(otherlv_1, grammarAccess.getRuleAccess().getColonKeyword_1(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:404:1: ( (lv_body_2_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:405:1: (lv_body_2_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:405:1: (lv_body_2_0= ruleAlternatives )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:406:3: lv_body_2_0= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRuleAccess().getBodyAlternativesParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleRule725);
            lv_body_2_0=ruleAlternatives();

            state._fsp--;


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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRule737); 

                	createLeafNode(otherlv_3, grammarAccess.getRuleAccess().getSemicolonKeyword_3(), null);
                

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
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleAlternatives"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:440:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:441:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:442:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives773);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives783); 

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
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:449:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:454:6: ( (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:455:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:455:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:456:5: this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives830);
            this_Group_0=ruleGroup();

            state._fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:464:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:464:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:464:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:465:5: 
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

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:480:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
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
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:480:4: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleAlternatives852); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:484:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:485:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:485:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:486:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives873);
                    	    lv_groups_3_0=ruleGroup();

                    	    state._fsp--;


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
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleGroup"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:516:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:517:2: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:518:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup913);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup923); 

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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:525:1: ruleGroup returns [EObject current=null] : (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject lv_elements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:530:6: ( (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:531:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:531:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:532:5: this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAtomParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAtom_in_ruleGroup970);
            this_Atom_0=ruleAtom();

            state._fsp--;

             
                    current = this_Atom_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:540:1: ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==RULE_STRING||LA8_0==13||LA8_0==22||LA8_0==24||(LA8_0>=26 && LA8_0<=27)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:540:2: () ( (lv_elements_2_0= ruleAtom ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:540:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:541:5: 
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

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:556:2: ( (lv_elements_2_0= ruleAtom ) )+
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
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:557:1: (lv_elements_2_0= ruleAtom )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:557:1: (lv_elements_2_0= ruleAtom )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:558:3: lv_elements_2_0= ruleAtom
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getElementsAtomParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAtom_in_ruleGroup1000);
                    	    lv_elements_2_0=ruleAtom();

                    	    state._fsp--;


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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAtom"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:588:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:589:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:590:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom1039);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom1049); 

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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:597:1: ruleAtom returns [EObject current=null] : ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_OtherElement_0 = null;

        EObject this_RuleOptions_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:602:6: ( ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:603:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:603:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
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
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:603:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:603:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:604:5: this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getOtherElementParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOtherElement_in_ruleAtom1097);
                    this_OtherElement_0=ruleOtherElement();

                    state._fsp--;

                     
                            current = this_OtherElement_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:612:1: ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=19 && LA10_0<=21)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:612:2: () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:612:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:613:5: 
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

                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:628:2: ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:629:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:629:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:630:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:630:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
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
                                    new NoViableAltException("", 9, 0, input);

                                throw nvae;
                            }

                            switch (alt9) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:631:3: lv_cardinality_2_1= '+'
                                    {
                                    lv_cardinality_2_1=(Token)match(input,19,FOLLOW_19_in_ruleAtom1126); 

                                            createLeafNode(lv_cardinality_2_1, grammarAccess.getAtomAccess().getCardinalityPlusSignKeyword_0_1_1_0_0(), "cardinality");
                                        

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
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:649:8: lv_cardinality_2_2= '*'
                                    {
                                    lv_cardinality_2_2=(Token)match(input,20,FOLLOW_20_in_ruleAtom1155); 

                                            createLeafNode(lv_cardinality_2_2, grammarAccess.getAtomAccess().getCardinalityAsteriskKeyword_0_1_1_0_1(), "cardinality");
                                        

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
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:667:8: lv_cardinality_2_3= '?'
                                    {
                                    lv_cardinality_2_3=(Token)match(input,21,FOLLOW_21_in_ruleAtom1184); 

                                            createLeafNode(lv_cardinality_2_3, grammarAccess.getAtomAccess().getCardinalityQuestionMarkKeyword_0_1_1_0_2(), "cardinality");
                                        

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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:690:5: this_RuleOptions_3= ruleRuleOptions
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getRuleOptionsParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleOptions_in_ruleAtom1231);
                    this_RuleOptions_3=ruleRuleOptions();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleOtherElement"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:706:1: entryRuleOtherElement returns [EObject current=null] : iv_ruleOtherElement= ruleOtherElement EOF ;
    public final EObject entryRuleOtherElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherElement = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:707:2: (iv_ruleOtherElement= ruleOtherElement EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:708:2: iv_ruleOtherElement= ruleOtherElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOtherElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleOtherElement_in_entryRuleOtherElement1266);
            iv_ruleOtherElement=ruleOtherElement();

            state._fsp--;

             current =iv_ruleOtherElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherElement1276); 

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
    // $ANTLR end "entryRuleOtherElement"


    // $ANTLR start "ruleOtherElement"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:715:1: ruleOtherElement returns [EObject current=null] : ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) ;
    public final EObject ruleOtherElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_element_2_1 = null;

        EObject lv_element_2_2 = null;

        EObject this_Parenthesized_3 = null;

        EObject this_Literal_4 = null;

        EObject lv_right_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:720:6: ( ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
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
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:3: () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:3: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:722:5: 
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

                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleOtherElement1323); 

                        	createLeafNode(otherlv_1, grammarAccess.getOtherElementAccess().getTildeKeyword_0_1(), null);
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:736:1: ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:737:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:737:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:738:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:738:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
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
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:739:3: lv_element_2_1= ruleParenthesized
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getElementParenthesizedParserRuleCall_0_2_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1346);
                            lv_element_2_1=ruleParenthesized();

                            state._fsp--;


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
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:760:8: lv_element_2_2= ruleLiteral
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getElementLiteralParserRuleCall_0_2_0_1(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1365);
                            lv_element_2_2=ruleLiteral();

                            state._fsp--;


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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:786:5: this_Parenthesized_3= ruleParenthesized
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getParenthesizedParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1397);
                    this_Parenthesized_3=ruleParenthesized();

                    state._fsp--;

                     
                            current = this_Parenthesized_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:795:6: (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:795:6: (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:796:5: this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getLiteralParserRuleCall_2_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1425);
                    this_Literal_4=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_4; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:804:1: ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:804:2: () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:804:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:805:5: 
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

                            otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleOtherElement1446); 

                                	createLeafNode(otherlv_6, grammarAccess.getOtherElementAccess().getFullStopFullStopKeyword_2_1_1(), null);
                                
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:824:1: ( (lv_right_7_0= ruleLiteral ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:825:1: (lv_right_7_0= ruleLiteral )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:825:1: (lv_right_7_0= ruleLiteral )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:826:3: lv_right_7_0= ruleLiteral
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getOtherElementAccess().getRightLiteralParserRuleCall_2_1_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1467);
                            lv_right_7_0=ruleLiteral();

                            state._fsp--;


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
    // $ANTLR end "ruleOtherElement"


    // $ANTLR start "entryRuleEmptyParenthesis"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:856:1: entryRuleEmptyParenthesis returns [String current=null] : iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF ;
    public final String entryRuleEmptyParenthesis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEmptyParenthesis = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:857:2: (iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:858:2: iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyParenthesisRule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyParenthesis_in_entryRuleEmptyParenthesis1507);
            iv_ruleEmptyParenthesis=ruleEmptyParenthesis();

            state._fsp--;

             current =iv_ruleEmptyParenthesis.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyParenthesis1518); 

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
    // $ANTLR end "entryRuleEmptyParenthesis"


    // $ANTLR start "ruleEmptyParenthesis"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:865:1: ruleEmptyParenthesis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleEmptyParenthesis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:870:6: ( (kw= '(' kw= ')' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:871:1: (kw= '(' kw= ')' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:871:1: (kw= '(' kw= ')' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:872:2: kw= '(' kw= ')'
            {
            kw=(Token)match(input,24,FOLLOW_24_in_ruleEmptyParenthesis1556); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getEmptyParenthesisAccess().getLeftParenthesisKeyword_0(), null); 
                
            kw=(Token)match(input,25,FOLLOW_25_in_ruleEmptyParenthesis1569); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getEmptyParenthesisAccess().getRightParenthesisKeyword_1(), null); 
                

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
    // $ANTLR end "ruleEmptyParenthesis"


    // $ANTLR start "entryRuleParenthesized"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:891:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:892:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:893:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesized_in_entryRuleParenthesized1609);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;

             current =iv_ruleParenthesized; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesized1619); 

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
    // $ANTLR end "entryRuleParenthesized"


    // $ANTLR start "ruleParenthesized"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:900:1: ruleParenthesized returns [EObject current=null] : (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_Alternatives_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:905:6: ( (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:906:1: (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:906:1: (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:906:3: otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )*
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleParenthesized1656); 

                	createLeafNode(otherlv_0, grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:910:1: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:911:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1673);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAccess().getAlternativesParserRuleCall_2(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesized1696);
            this_Alternatives_2=ruleAlternatives();

            state._fsp--;

             
                    current = this_Alternatives_2; 
                    currentNode = currentNode.getParent();
                
            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleParenthesized1707); 

                	createLeafNode(otherlv_3, grammarAccess.getParenthesizedAccess().getRightParenthesisKeyword_3(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:931:1: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:932:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_4(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1724);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
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
    // $ANTLR end "ruleParenthesized"


    // $ANTLR start "entryRuleRuleOptions"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:947:1: entryRuleRuleOptions returns [EObject current=null] : iv_ruleRuleOptions= ruleRuleOptions EOF ;
    public final EObject entryRuleRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:948:2: (iv_ruleRuleOptions= ruleRuleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:949:2: iv_ruleRuleOptions= ruleRuleOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleOptionsRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleOptions_in_entryRuleRuleOptions1761);
            iv_ruleRuleOptions=ruleRuleOptions();

            state._fsp--;

             current =iv_ruleRuleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleOptions1771); 

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
    // $ANTLR end "entryRuleRuleOptions"


    // $ANTLR start "ruleRuleOptions"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:956:1: ruleRuleOptions returns [EObject current=null] : ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) ) ;
    public final EObject ruleRuleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_options_0_0 = null;

        EObject lv_element_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:961:6: ( ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) )
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
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:3: ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:962:3: ( (lv_options_0_0= ruleOptions ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:963:1: (lv_options_0_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:963:1: (lv_options_0_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:964:3: lv_options_0_0= ruleOptions
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleOptionsAccess().getOptionsOptionsParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleRuleOptions1818);
                    lv_options_0_0=ruleOptions();

                    state._fsp--;


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

                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleRuleOptions1830); 

                        	createLeafNode(otherlv_1, grammarAccess.getRuleOptionsAccess().getColonKeyword_0_1(), null);
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:990:1: ( (lv_element_2_0= ruleAtom ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:991:1: (lv_element_2_0= ruleAtom )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:991:1: (lv_element_2_0= ruleAtom )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:992:3: lv_element_2_0= ruleAtom
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleOptionsAccess().getElementAtomParserRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAtom_in_ruleRuleOptions1851);
                    lv_element_2_0=ruleAtom();

                    state._fsp--;


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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1015:6: ( () otherlv_4= '{skip();}' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1015:6: ( () otherlv_4= '{skip();}' )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1015:7: () otherlv_4= '{skip();}'
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1015:7: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1016:5: 
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

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleRuleOptions1880); 

                        	createLeafNode(otherlv_4, grammarAccess.getRuleOptionsAccess().getSkipKeyword_1_1(), null);
                        

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
    // $ANTLR end "ruleRuleOptions"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1038:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1039:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1040:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1917);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1927); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1047:1: ruleLiteral returns [EObject current=null] : (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RuleCall_0 = null;

        EObject this_Keyword_1 = null;

        EObject this_Wildcard_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1052:6: ( (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1053:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1053:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
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
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1054:5: this_RuleCall_0= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getRuleCallParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleLiteral1974);
                    this_RuleCall_0=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1064:5: this_Keyword_1= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getKeywordParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleLiteral2001);
                    this_Keyword_1=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1074:5: this_Wildcard_2= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getWildcardParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleLiteral2028);
                    this_Wildcard_2=ruleWildcard();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleRuleCall"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1090:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1091:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1092:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2063);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2073); 

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
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1099:1: ruleRuleCall returns [EObject current=null] : ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_rule_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1104:6: ( ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1105:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1105:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1105:2: ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1105:2: ( (lv_rule_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1106:1: (lv_rule_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1106:1: (lv_rule_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1107:3: lv_rule_0_0= RULE_ID
            {
            lv_rule_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2115); 

            			createLeafNode(lv_rule_0_0, grammarAccess.getRuleCallAccess().getRuleIDTerminalRuleCall_0_0(), "rule"); 
            		

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

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1129:2: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1130:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getRuleCallAccess().getEmptyParenthesisParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2137);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleKeyword"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1145:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1146:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1147:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2174);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2184); 

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
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1154:1: ruleKeyword returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1159:6: ( ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1160:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1160:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1160:2: ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1160:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1161:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1161:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1162:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2226); 

            			createLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0_0(), "value"); 
            		

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

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1184:2: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1185:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getKeywordAccess().getEmptyParenthesisParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2248);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleWildcard"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1200:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1201:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1202:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard2285);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard2295); 

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
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1209:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1214:6: ( ( () otherlv_1= '.' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1215:1: ( () otherlv_1= '.' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1215:1: ( () otherlv_1= '.' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1215:2: () otherlv_1= '.' ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1215:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1216:5: 
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

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleWildcard2341); 

                	createLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1230:1: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1231:5: ruleEmptyParenthesis
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getWildcardAccess().getEmptyParenthesisParserRuleCall_2(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2358);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
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
    // $ANTLR end "ruleWildcard"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAntlrGrammar_in_entryRuleAntlrGrammar75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAntlrGrammar85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAntlrGrammar122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAntlrGrammar139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAntlrGrammar156 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleAntlrGrammar177 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleRule_in_ruleAntlrGrammar199 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOptions292 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleOptions304 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleOptionValue_in_ruleOptions325 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleOptions338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionValue_in_entryRuleOptionValue374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptionValue384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptionValue426 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOptionValue443 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleIdOrInt_in_ruleOptionValue464 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleOptionValue476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrInt_in_entryRuleIdOrInt513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrInt524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrInt564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIdOrInt590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRule_in_entryRuleRule635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRule645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRule687 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRule704 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleRule725 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRule737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives830 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleAlternatives852 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives873 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleGroup970 = new BitSet(new long[]{0x000000000D402052L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleGroup1000 = new BitSet(new long[]{0x000000000D402052L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom1039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherElement_in_ruleAtom1097 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_19_in_ruleAtom1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAtom1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAtom1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleOptions_in_ruleAtom1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherElement_in_entryRuleOtherElement1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherElement1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOtherElement1323 = new BitSet(new long[]{0x0000000009400050L});
    public static final BitSet FOLLOW_ruleParenthesized_in_ruleOtherElement1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesized_in_ruleOtherElement1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1425 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleOtherElement1446 = new BitSet(new long[]{0x0000000009400050L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_entryRuleEmptyParenthesis1507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyParenthesis1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleEmptyParenthesis1556 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEmptyParenthesis1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesized_in_entryRuleParenthesized1609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesized1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesized1656 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1673 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesized1696 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParenthesized1707 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1724 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleRuleOptions_in_entryRuleRuleOptions1761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleOptions1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleRuleOptions1818 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRuleOptions1830 = new BitSet(new long[]{0x000000000D402050L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleRuleOptions1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRuleOptions1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleLiteral1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleLiteral2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleLiteral2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2115 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2137 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2226 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2248 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleWildcard2341 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2358 = new BitSet(new long[]{0x0000000001000002L});

}
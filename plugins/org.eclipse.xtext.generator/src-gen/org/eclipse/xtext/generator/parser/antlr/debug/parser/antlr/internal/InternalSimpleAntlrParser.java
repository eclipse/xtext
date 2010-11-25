package org.eclipse.xtext.generator.parser.antlr.debug.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
     	
        public InternalSimpleAntlrParser(TokenStream input, SimpleAntlrGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:67:1: entryRuleAntlrGrammar returns [EObject current=null] : iv_ruleAntlrGrammar= ruleAntlrGrammar EOF ;
    public final EObject entryRuleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntlrGrammar = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:68:2: (iv_ruleAntlrGrammar= ruleAntlrGrammar EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:69:2: iv_ruleAntlrGrammar= ruleAntlrGrammar EOF
            {
             newCompositeNode(grammarAccess.getAntlrGrammarRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:76:1: ruleAntlrGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) ;
    public final EObject ruleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_options_3_0 = null;

        EObject lv_rules_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:79:28: ( (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:80:1: (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:80:1: (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:80:3: otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAntlrGrammar122); 

                	newLeafNode(otherlv_0, grammarAccess.getAntlrGrammarAccess().getGrammarKeyword_0());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAntlrGrammar139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAntlrGrammarAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAntlrGrammarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleAntlrGrammar156); 

                	newLeafNode(otherlv_2, grammarAccess.getAntlrGrammarAccess().getSemicolonKeyword_2());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:106:1: ( (lv_options_3_0= ruleOptions ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:107:1: (lv_options_3_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:107:1: (lv_options_3_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:108:3: lv_options_3_0= ruleOptions
                    {
                     
                    	        newCompositeNode(grammarAccess.getAntlrGrammarAccess().getOptionsOptionsParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleAntlrGrammar177);
                    lv_options_3_0=ruleOptions();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAntlrGrammarRule());
                    	        }
                           		set(
                           			current, 
                           			"options",
                            		lv_options_3_0, 
                            		"Options");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:124:3: ( (lv_rules_4_0= ruleRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:125:1: (lv_rules_4_0= ruleRule )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:125:1: (lv_rules_4_0= ruleRule )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:126:3: lv_rules_4_0= ruleRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAntlrGrammarAccess().getRulesRuleParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRule_in_ruleAntlrGrammar199);
            	    lv_rules_4_0=ruleRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAntlrGrammarRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_4_0, 
            	            		"Rule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:150:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:151:2: (iv_ruleOptions= ruleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:152:2: iv_ruleOptions= ruleOptions EOF
            {
             newCompositeNode(grammarAccess.getOptionsRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:159:1: ruleOptions returns [EObject current=null] : ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_optionValues_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:162:28: ( ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:163:1: ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:163:1: ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:163:2: () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:163:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:164:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionsAccess().getOptionsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleOptions292); 

                	newLeafNode(otherlv_1, grammarAccess.getOptionsAccess().getOptionsKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleOptions304); 

                	newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:177:1: ( (lv_optionValues_3_0= ruleOptionValue ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:178:1: (lv_optionValues_3_0= ruleOptionValue )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:178:1: (lv_optionValues_3_0= ruleOptionValue )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:179:3: lv_optionValues_3_0= ruleOptionValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionValuesOptionValueParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionValue_in_ruleOptions325);
            	    lv_optionValues_3_0=ruleOptionValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOptionsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"optionValues",
            	            		lv_optionValues_3_0, 
            	            		"OptionValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleOptions338); 

                	newLeafNode(otherlv_4, grammarAccess.getOptionsAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:207:1: entryRuleOptionValue returns [EObject current=null] : iv_ruleOptionValue= ruleOptionValue EOF ;
    public final EObject entryRuleOptionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionValue = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:208:2: (iv_ruleOptionValue= ruleOptionValue EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:209:2: iv_ruleOptionValue= ruleOptionValue EOF
            {
             newCompositeNode(grammarAccess.getOptionValueRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:216:1: ruleOptionValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' ) ;
    public final EObject ruleOptionValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:219:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:220:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:220:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:220:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:220:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:221:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:221:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:222:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptionValue426); 

            			newLeafNode(lv_key_0_0, grammarAccess.getOptionValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleOptionValue443); 

                	newLeafNode(otherlv_1, grammarAccess.getOptionValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:242:1: ( (lv_value_2_0= ruleIdOrInt ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:243:1: (lv_value_2_0= ruleIdOrInt )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:243:1: (lv_value_2_0= ruleIdOrInt )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:244:3: lv_value_2_0= ruleIdOrInt
            {
             
            	        newCompositeNode(grammarAccess.getOptionValueAccess().getValueIdOrIntParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleIdOrInt_in_ruleOptionValue464);
            lv_value_2_0=ruleIdOrInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"IdOrInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleOptionValue476); 

                	newLeafNode(otherlv_3, grammarAccess.getOptionValueAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:272:1: entryRuleIdOrInt returns [String current=null] : iv_ruleIdOrInt= ruleIdOrInt EOF ;
    public final String entryRuleIdOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrInt = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:273:2: (iv_ruleIdOrInt= ruleIdOrInt EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:274:2: iv_ruleIdOrInt= ruleIdOrInt EOF
            {
             newCompositeNode(grammarAccess.getIdOrIntRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:281:1: ruleIdOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleIdOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:284:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:285:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:285:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:285:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdOrInt564); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getIdOrIntAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:293:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIdOrInt590); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getIdOrIntAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:308:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:309:2: (iv_ruleRule= ruleRule EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:310:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:317:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:320:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleAlternatives ) ) otherlv_3= ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:322:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:322:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:323:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRule687); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleRule704); 

                	newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getColonKeyword_1());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:343:1: ( (lv_body_2_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:344:1: (lv_body_2_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:344:1: (lv_body_2_0= ruleAlternatives )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:345:3: lv_body_2_0= ruleAlternatives
            {
             
            	        newCompositeNode(grammarAccess.getRuleAccess().getBodyAlternativesParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleRule725);
            lv_body_2_0=ruleAlternatives();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_2_0, 
                    		"Alternatives");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRule737); 

                	newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:373:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:374:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:375:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAlternativesRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:382:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:385:28: ( (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:386:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:386:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:387:5: this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives830);
            this_Group_0=ruleGroup();

            state._fsp--;

             
                    current = this_Group_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:395:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:395:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:395:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:396:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:401:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
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
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:401:4: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleAlternatives852); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:405:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:406:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:406:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:407:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives873);
                    	    lv_groups_3_0=ruleGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"groups",
                    	            		lv_groups_3_0, 
                    	            		"Group");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:431:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:432:2: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:433:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:440:1: ruleGroup returns [EObject current=null] : (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:443:28: ( (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:444:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:444:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:445:5: this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getGroupAccess().getAtomParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAtom_in_ruleGroup970);
            this_Atom_0=ruleAtom();

            state._fsp--;

             
                    current = this_Atom_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:453:1: ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==RULE_STRING||LA8_0==13||LA8_0==22||LA8_0==24||(LA8_0>=26 && LA8_0<=27)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:453:2: () ( (lv_elements_2_0= ruleAtom ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:453:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:454:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getGroupAccess().getGroupElementsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:459:2: ( (lv_elements_2_0= ruleAtom ) )+
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
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:460:1: (lv_elements_2_0= ruleAtom )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:460:1: (lv_elements_2_0= ruleAtom )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:461:3: lv_elements_2_0= ruleAtom
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGroupAccess().getElementsAtomParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAtom_in_ruleGroup1000);
                    	    lv_elements_2_0=ruleAtom();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGroupRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_2_0, 
                    	            		"Atom");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:485:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:486:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:487:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:494:1: ruleAtom returns [EObject current=null] : ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_OtherElement_0 = null;

        EObject this_RuleOptions_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:497:28: ( ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:498:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:498:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:498:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:498:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:499:5: this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getOtherElementParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleOtherElement_in_ruleAtom1097);
                    this_OtherElement_0=ruleOtherElement();

                    state._fsp--;

                     
                            current = this_OtherElement_0; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:507:1: ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=19 && LA10_0<=21)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:507:2: () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:507:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:508:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getAtomAccess().getElementWithCardinalityElementAction_0_1_0(),
                                        current);
                                

                            }

                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:513:2: ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:514:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:514:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:515:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:515:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
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
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:516:3: lv_cardinality_2_1= '+'
                                    {
                                    lv_cardinality_2_1=(Token)match(input,19,FOLLOW_19_in_ruleAtom1126); 

                                            newLeafNode(lv_cardinality_2_1, grammarAccess.getAtomAccess().getCardinalityPlusSignKeyword_0_1_1_0_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAtomRule());
                                    	        }
                                           		setWithLastConsumed(current, "cardinality", lv_cardinality_2_1, null);
                                    	    

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:528:8: lv_cardinality_2_2= '*'
                                    {
                                    lv_cardinality_2_2=(Token)match(input,20,FOLLOW_20_in_ruleAtom1155); 

                                            newLeafNode(lv_cardinality_2_2, grammarAccess.getAtomAccess().getCardinalityAsteriskKeyword_0_1_1_0_1());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAtomRule());
                                    	        }
                                           		setWithLastConsumed(current, "cardinality", lv_cardinality_2_2, null);
                                    	    

                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:540:8: lv_cardinality_2_3= '?'
                                    {
                                    lv_cardinality_2_3=(Token)match(input,21,FOLLOW_21_in_ruleAtom1184); 

                                            newLeafNode(lv_cardinality_2_3, grammarAccess.getAtomAccess().getCardinalityQuestionMarkKeyword_0_1_1_0_2());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAtomRule());
                                    	        }
                                           		setWithLastConsumed(current, "cardinality", lv_cardinality_2_3, null);
                                    	    

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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:557:5: this_RuleOptions_3= ruleRuleOptions
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getRuleOptionsParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRuleOptions_in_ruleAtom1231);
                    this_RuleOptions_3=ruleRuleOptions();

                    state._fsp--;

                     
                            current = this_RuleOptions_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:573:1: entryRuleOtherElement returns [EObject current=null] : iv_ruleOtherElement= ruleOtherElement EOF ;
    public final EObject entryRuleOtherElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherElement = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:574:2: (iv_ruleOtherElement= ruleOtherElement EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:575:2: iv_ruleOtherElement= ruleOtherElement EOF
            {
             newCompositeNode(grammarAccess.getOtherElementRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:582:1: ruleOtherElement returns [EObject current=null] : ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) ;
    public final EObject ruleOtherElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_element_2_1 = null;

        EObject lv_element_2_2 = null;

        EObject this_Parenthesized_3 = null;

        EObject this_Literal_4 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:585:28: ( ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:586:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:586:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:586:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:586:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:586:3: () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:586:3: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:587:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getOtherElementAccess().getNegatedElementAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleOtherElement1323); 

                        	newLeafNode(otherlv_1, grammarAccess.getOtherElementAccess().getTildeKeyword_0_1());
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:596:1: ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:597:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:597:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:598:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:598:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
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
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:599:3: lv_element_2_1= ruleParenthesized
                            {
                             
                            	        newCompositeNode(grammarAccess.getOtherElementAccess().getElementParenthesizedParserRuleCall_0_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1346);
                            lv_element_2_1=ruleParenthesized();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getOtherElementRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"element",
                                    		lv_element_2_1, 
                                    		"Parenthesized");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:614:8: lv_element_2_2= ruleLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getOtherElementAccess().getElementLiteralParserRuleCall_0_2_0_1()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1365);
                            lv_element_2_2=ruleLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getOtherElementRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"element",
                                    		lv_element_2_2, 
                                    		"Literal");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:634:5: this_Parenthesized_3= ruleParenthesized
                    {
                     
                            newCompositeNode(grammarAccess.getOtherElementAccess().getParenthesizedParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1397);
                    this_Parenthesized_3=ruleParenthesized();

                    state._fsp--;

                     
                            current = this_Parenthesized_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:643:6: (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:643:6: (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:644:5: this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    {
                     
                            newCompositeNode(grammarAccess.getOtherElementAccess().getLiteralParserRuleCall_2_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1425);
                    this_Literal_4=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_4; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:652:1: ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:652:2: () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:652:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:653:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getOtherElementAccess().getUntilElementLeftAction_2_1_0(),
                                        current);
                                

                            }

                            otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleOtherElement1446); 

                                	newLeafNode(otherlv_6, grammarAccess.getOtherElementAccess().getFullStopFullStopKeyword_2_1_1());
                                
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:662:1: ( (lv_right_7_0= ruleLiteral ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:663:1: (lv_right_7_0= ruleLiteral )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:663:1: (lv_right_7_0= ruleLiteral )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:664:3: lv_right_7_0= ruleLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getOtherElementAccess().getRightLiteralParserRuleCall_2_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1467);
                            lv_right_7_0=ruleLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getOtherElementRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"right",
                                    		lv_right_7_0, 
                                    		"Literal");
                            	        afterParserOrEnumRuleCall();
                            	    

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

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:688:1: entryRuleEmptyParenthesis returns [String current=null] : iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF ;
    public final String entryRuleEmptyParenthesis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEmptyParenthesis = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:689:2: (iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:690:2: iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF
            {
             newCompositeNode(grammarAccess.getEmptyParenthesisRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:697:1: ruleEmptyParenthesis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleEmptyParenthesis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:700:28: ( (kw= '(' kw= ')' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:701:1: (kw= '(' kw= ')' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:701:1: (kw= '(' kw= ')' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:702:2: kw= '(' kw= ')'
            {
            kw=(Token)match(input,24,FOLLOW_24_in_ruleEmptyParenthesis1556); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEmptyParenthesisAccess().getLeftParenthesisKeyword_0()); 
                
            kw=(Token)match(input,25,FOLLOW_25_in_ruleEmptyParenthesis1569); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEmptyParenthesisAccess().getRightParenthesisKeyword_1()); 
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:721:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:722:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:723:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:730:1: ruleParenthesized returns [EObject current=null] : (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_Alternatives_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:733:28: ( (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:734:1: (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:734:1: (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:734:3: otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )*
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleParenthesized1656); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:738:1: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:739:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1673);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getParenthesizedAccess().getAlternativesParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesized1696);
            this_Alternatives_2=ruleAlternatives();

            state._fsp--;

             
                    current = this_Alternatives_2; 
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleParenthesized1707); 

                	newLeafNode(otherlv_3, grammarAccess.getParenthesizedAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:759:1: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:760:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_4()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1724);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:775:1: entryRuleRuleOptions returns [EObject current=null] : iv_ruleRuleOptions= ruleRuleOptions EOF ;
    public final EObject entryRuleRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:776:2: (iv_ruleRuleOptions= ruleRuleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:777:2: iv_ruleRuleOptions= ruleRuleOptions EOF
            {
             newCompositeNode(grammarAccess.getRuleOptionsRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:784:1: ruleRuleOptions returns [EObject current=null] : ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) ) ;
    public final EObject ruleRuleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_options_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:787:28: ( ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:788:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:788:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) )
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:788:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:788:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:788:3: ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:788:3: ( (lv_options_0_0= ruleOptions ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:789:1: (lv_options_0_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:789:1: (lv_options_0_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:790:3: lv_options_0_0= ruleOptions
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleOptionsAccess().getOptionsOptionsParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleRuleOptions1818);
                    lv_options_0_0=ruleOptions();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleOptionsRule());
                    	        }
                           		set(
                           			current, 
                           			"options",
                            		lv_options_0_0, 
                            		"Options");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleRuleOptions1830); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleOptionsAccess().getColonKeyword_0_1());
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:810:1: ( (lv_element_2_0= ruleAtom ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:811:1: (lv_element_2_0= ruleAtom )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:811:1: (lv_element_2_0= ruleAtom )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:812:3: lv_element_2_0= ruleAtom
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleOptionsAccess().getElementAtomParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAtom_in_ruleRuleOptions1851);
                    lv_element_2_0=ruleAtom();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleOptionsRule());
                    	        }
                           		set(
                           			current, 
                           			"element",
                            		lv_element_2_0, 
                            		"Atom");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:829:6: ( () otherlv_4= '{skip();}' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:829:6: ( () otherlv_4= '{skip();}' )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:829:7: () otherlv_4= '{skip();}'
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:829:7: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:830:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleOptionsAccess().getSkipAction_1_0(),
                                current);
                        

                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleRuleOptions1880); 

                        	newLeafNode(otherlv_4, grammarAccess.getRuleOptionsAccess().getSkipKeyword_1_1());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:847:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:848:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:849:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:856:1: ruleLiteral returns [EObject current=null] : (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RuleCall_0 = null;

        EObject this_Keyword_1 = null;

        EObject this_Wildcard_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:859:28: ( (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:860:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:860:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:861:5: this_RuleCall_0= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getRuleCallParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleLiteral1974);
                    this_RuleCall_0=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:871:5: this_Keyword_1= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getKeywordParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleLiteral2001);
                    this_Keyword_1=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:881:5: this_Wildcard_2= ruleWildcard
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getWildcardParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleLiteral2028);
                    this_Wildcard_2=ruleWildcard();

                    state._fsp--;

                     
                            current = this_Wildcard_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:897:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:898:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:899:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:906:1: ruleRuleCall returns [EObject current=null] : ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_rule_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:909:28: ( ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:910:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:910:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:910:2: ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:910:2: ( (lv_rule_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:911:1: (lv_rule_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:911:1: (lv_rule_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:912:3: lv_rule_0_0= RULE_ID
            {
            lv_rule_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2115); 

            			newLeafNode(lv_rule_0_0, grammarAccess.getRuleCallAccess().getRuleIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"rule",
                    		lv_rule_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:928:2: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:929:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getRuleCallAccess().getEmptyParenthesisParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2137);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:944:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:945:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:946:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:953:1: ruleKeyword returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:956:28: ( ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:957:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:957:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:957:2: ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:957:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:958:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:958:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:959:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2226); 

            			newLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:975:2: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:976:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getKeywordAccess().getEmptyParenthesisParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2248);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:991:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:992:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:993:2: iv_ruleWildcard= ruleWildcard EOF
            {
             newCompositeNode(grammarAccess.getWildcardRule()); 
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1000:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1003:28: ( ( () otherlv_1= '.' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1004:1: ( () otherlv_1= '.' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1004:1: ( () otherlv_1= '.' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1004:2: () otherlv_1= '.' ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1004:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1005:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWildcardAccess().getWildcardAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleWildcard2341); 

                	newLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1014:1: ( ruleEmptyParenthesis )*
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
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1015:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getWildcardAccess().getEmptyParenthesisParserRuleCall_2()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2358);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
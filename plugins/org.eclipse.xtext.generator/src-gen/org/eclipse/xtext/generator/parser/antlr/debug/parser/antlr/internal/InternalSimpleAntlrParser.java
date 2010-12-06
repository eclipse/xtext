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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "';'", "'options'", "'{'", "'}'", "'='", "'fragment'", "':'", "'|'", "'+'", "'*'", "'?'", "'~'", "'..'", "'('", "')'", "'{skip();}'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
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

                if ( (LA2_0==RULE_ID||LA2_0==17) ) {
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:317:1: ruleRule returns [EObject current=null] : ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_body_3_0= ruleAlternatives ) ) otherlv_4= ';' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:320:28: ( ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_body_3_0= ruleAlternatives ) ) otherlv_4= ';' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:1: ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_body_3_0= ruleAlternatives ) ) otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:1: ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_body_3_0= ruleAlternatives ) ) otherlv_4= ';' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:2: ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_body_3_0= ruleAlternatives ) ) otherlv_4= ';'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:321:2: ( (lv_fragment_0_0= 'fragment' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:322:1: (lv_fragment_0_0= 'fragment' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:322:1: (lv_fragment_0_0= 'fragment' )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:323:3: lv_fragment_0_0= 'fragment'
                    {
                    lv_fragment_0_0=(Token)match(input,17,FOLLOW_17_in_ruleRule688); 

                            newLeafNode(lv_fragment_0_0, grammarAccess.getRuleAccess().getFragmentFragmentKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleRule());
                    	        }
                           		setWithLastConsumed(current, "fragment", true, "fragment");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:336:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:337:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:337:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:338:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRule719); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleRule736); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getColonKeyword_2());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:358:1: ( (lv_body_3_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:359:1: (lv_body_3_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:359:1: (lv_body_3_0= ruleAlternatives )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:360:3: lv_body_3_0= ruleAlternatives
            {
             
            	        newCompositeNode(grammarAccess.getRuleAccess().getBodyAlternativesParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleRule757);
            lv_body_3_0=ruleAlternatives();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_3_0, 
                    		"Alternatives");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleRule769); 

                	newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getSemicolonKeyword_4());
                

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:388:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:389:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:390:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAlternativesRule()); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives805);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives815); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:397:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:400:28: ( (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:401:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:401:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:402:5: this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives862);
            this_Group_0=ruleGroup();

            state._fsp--;

             
                    current = this_Group_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:410:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:410:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:410:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:411:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:416:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==19) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:416:4: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleAlternatives884); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:420:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:421:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:421:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:422:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives905);
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
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:446:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:447:2: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:448:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup945);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup955); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:455:1: ruleGroup returns [EObject current=null] : (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:458:28: ( (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:459:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:459:1: (this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:460:5: this_Atom_0= ruleAtom ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getGroupAccess().getAtomParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAtom_in_ruleGroup1002);
            this_Atom_0=ruleAtom();

            state._fsp--;

             
                    current = this_Atom_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:468:1: ( () ( (lv_elements_2_0= ruleAtom ) )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==RULE_STRING||LA9_0==13||LA9_0==23||LA9_0==25||(LA9_0>=27 && LA9_0<=28)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:468:2: () ( (lv_elements_2_0= ruleAtom ) )+
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:468:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:469:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getGroupAccess().getGroupElementsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:474:2: ( (lv_elements_2_0= ruleAtom ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID||LA8_0==RULE_STRING||LA8_0==13||LA8_0==23||LA8_0==25||(LA8_0>=27 && LA8_0<=28)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:475:1: (lv_elements_2_0= ruleAtom )
                    	    {
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:475:1: (lv_elements_2_0= ruleAtom )
                    	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:476:3: lv_elements_2_0= ruleAtom
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGroupAccess().getElementsAtomParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAtom_in_ruleGroup1032);
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
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:500:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:501:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:502:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom1071);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom1081); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:509:1: ruleAtom returns [EObject current=null] : ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_OtherElement_0 = null;

        EObject this_RuleOptions_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:512:28: ( ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:513:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:513:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||LA12_0==RULE_STRING||LA12_0==23||LA12_0==25||LA12_0==28) ) {
                alt12=1;
            }
            else if ( (LA12_0==13||LA12_0==27) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:513:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:513:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:514:5: this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getOtherElementParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleOtherElement_in_ruleAtom1129);
                    this_OtherElement_0=ruleOtherElement();

                    state._fsp--;

                     
                            current = this_OtherElement_0; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:522:1: ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=20 && LA11_0<=22)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:522:2: () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:522:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:523:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getAtomAccess().getElementWithCardinalityElementAction_0_1_0(),
                                        current);
                                

                            }

                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:528:2: ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:529:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:529:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:530:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:530:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            int alt10=3;
                            switch ( input.LA(1) ) {
                            case 20:
                                {
                                alt10=1;
                                }
                                break;
                            case 21:
                                {
                                alt10=2;
                                }
                                break;
                            case 22:
                                {
                                alt10=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 0, input);

                                throw nvae;
                            }

                            switch (alt10) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:531:3: lv_cardinality_2_1= '+'
                                    {
                                    lv_cardinality_2_1=(Token)match(input,20,FOLLOW_20_in_ruleAtom1158); 

                                            newLeafNode(lv_cardinality_2_1, grammarAccess.getAtomAccess().getCardinalityPlusSignKeyword_0_1_1_0_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAtomRule());
                                    	        }
                                           		setWithLastConsumed(current, "cardinality", lv_cardinality_2_1, null);
                                    	    

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:543:8: lv_cardinality_2_2= '*'
                                    {
                                    lv_cardinality_2_2=(Token)match(input,21,FOLLOW_21_in_ruleAtom1187); 

                                            newLeafNode(lv_cardinality_2_2, grammarAccess.getAtomAccess().getCardinalityAsteriskKeyword_0_1_1_0_1());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAtomRule());
                                    	        }
                                           		setWithLastConsumed(current, "cardinality", lv_cardinality_2_2, null);
                                    	    

                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:555:8: lv_cardinality_2_3= '?'
                                    {
                                    lv_cardinality_2_3=(Token)match(input,22,FOLLOW_22_in_ruleAtom1216); 

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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:572:5: this_RuleOptions_3= ruleRuleOptions
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getRuleOptionsParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRuleOptions_in_ruleAtom1263);
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:588:1: entryRuleOtherElement returns [EObject current=null] : iv_ruleOtherElement= ruleOtherElement EOF ;
    public final EObject entryRuleOtherElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherElement = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:589:2: (iv_ruleOtherElement= ruleOtherElement EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:590:2: iv_ruleOtherElement= ruleOtherElement EOF
            {
             newCompositeNode(grammarAccess.getOtherElementRule()); 
            pushFollow(FOLLOW_ruleOtherElement_in_entryRuleOtherElement1298);
            iv_ruleOtherElement=ruleOtherElement();

            state._fsp--;

             current =iv_ruleOtherElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherElement1308); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:597:1: ruleOtherElement returns [EObject current=null] : ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) ;
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
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:600:28: ( ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:601:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:601:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Parenthesized_3= ruleParenthesized | (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt15=1;
                }
                break;
            case 25:
                {
                alt15=2;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case 28:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:601:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:601:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:601:3: () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:601:3: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:602:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getOtherElementAccess().getNegatedElementAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleOtherElement1355); 

                        	newLeafNode(otherlv_1, grammarAccess.getOtherElementAccess().getTildeKeyword_0_1());
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:611:1: ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:612:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:612:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:613:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:613:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==25) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==RULE_ID||LA13_0==RULE_STRING||LA13_0==28) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:614:3: lv_element_2_1= ruleParenthesized
                            {
                             
                            	        newCompositeNode(grammarAccess.getOtherElementAccess().getElementParenthesizedParserRuleCall_0_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1378);
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
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:629:8: lv_element_2_2= ruleLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getOtherElementAccess().getElementLiteralParserRuleCall_0_2_0_1()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1397);
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:649:5: this_Parenthesized_3= ruleParenthesized
                    {
                     
                            newCompositeNode(grammarAccess.getOtherElementAccess().getParenthesizedParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleParenthesized_in_ruleOtherElement1429);
                    this_Parenthesized_3=ruleParenthesized();

                    state._fsp--;

                     
                            current = this_Parenthesized_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:658:6: (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:658:6: (this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )? )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:659:5: this_Literal_4= ruleLiteral ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    {
                     
                            newCompositeNode(grammarAccess.getOtherElementAccess().getLiteralParserRuleCall_2_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1457);
                    this_Literal_4=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_4; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:667:1: ( () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==24) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:667:2: () otherlv_6= '..' ( (lv_right_7_0= ruleLiteral ) )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:667:2: ()
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:668:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getOtherElementAccess().getUntilElementLeftAction_2_1_0(),
                                        current);
                                

                            }

                            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleOtherElement1478); 

                                	newLeafNode(otherlv_6, grammarAccess.getOtherElementAccess().getFullStopFullStopKeyword_2_1_1());
                                
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:677:1: ( (lv_right_7_0= ruleLiteral ) )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:678:1: (lv_right_7_0= ruleLiteral )
                            {
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:678:1: (lv_right_7_0= ruleLiteral )
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:679:3: lv_right_7_0= ruleLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getOtherElementAccess().getRightLiteralParserRuleCall_2_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteral_in_ruleOtherElement1499);
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:703:1: entryRuleEmptyParenthesis returns [String current=null] : iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF ;
    public final String entryRuleEmptyParenthesis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEmptyParenthesis = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:704:2: (iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:705:2: iv_ruleEmptyParenthesis= ruleEmptyParenthesis EOF
            {
             newCompositeNode(grammarAccess.getEmptyParenthesisRule()); 
            pushFollow(FOLLOW_ruleEmptyParenthesis_in_entryRuleEmptyParenthesis1539);
            iv_ruleEmptyParenthesis=ruleEmptyParenthesis();

            state._fsp--;

             current =iv_ruleEmptyParenthesis.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyParenthesis1550); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:712:1: ruleEmptyParenthesis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleEmptyParenthesis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:715:28: ( (kw= '(' kw= ')' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:716:1: (kw= '(' kw= ')' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:716:1: (kw= '(' kw= ')' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:717:2: kw= '(' kw= ')'
            {
            kw=(Token)match(input,25,FOLLOW_25_in_ruleEmptyParenthesis1588); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEmptyParenthesisAccess().getLeftParenthesisKeyword_0()); 
                
            kw=(Token)match(input,26,FOLLOW_26_in_ruleEmptyParenthesis1601); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:736:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:737:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:738:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedRule()); 
            pushFollow(FOLLOW_ruleParenthesized_in_entryRuleParenthesized1641);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;

             current =iv_ruleParenthesized; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesized1651); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:745:1: ruleParenthesized returns [EObject current=null] : (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_Alternatives_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:748:28: ( (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:749:1: (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:749:1: (otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:749:3: otherlv_0= '(' ( ruleEmptyParenthesis )* this_Alternatives_2= ruleAlternatives otherlv_3= ')' ( ruleEmptyParenthesis )*
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleParenthesized1688); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:753:1: ( ruleEmptyParenthesis )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    int LA16_2 = input.LA(2);

                    if ( (LA16_2==26) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:754:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1705);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getParenthesizedAccess().getAlternativesParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesized1728);
            this_Alternatives_2=ruleAlternatives();

            state._fsp--;

             
                    current = this_Alternatives_2; 
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleParenthesized1739); 

                	newLeafNode(otherlv_3, grammarAccess.getParenthesizedAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:774:1: ( ruleEmptyParenthesis )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==26) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:775:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getParenthesizedAccess().getEmptyParenthesisParserRuleCall_4()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1756);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:790:1: entryRuleRuleOptions returns [EObject current=null] : iv_ruleRuleOptions= ruleRuleOptions EOF ;
    public final EObject entryRuleRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleOptions = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:791:2: (iv_ruleRuleOptions= ruleRuleOptions EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:792:2: iv_ruleRuleOptions= ruleRuleOptions EOF
            {
             newCompositeNode(grammarAccess.getRuleOptionsRule()); 
            pushFollow(FOLLOW_ruleRuleOptions_in_entryRuleRuleOptions1793);
            iv_ruleRuleOptions=ruleRuleOptions();

            state._fsp--;

             current =iv_ruleRuleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleOptions1803); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:799:1: ruleRuleOptions returns [EObject current=null] : ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) ) ;
    public final EObject ruleRuleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_options_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:802:28: ( ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:803:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:803:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{skip();}' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            else if ( (LA18_0==27) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:803:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:803:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:803:3: ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:803:3: ( (lv_options_0_0= ruleOptions ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:804:1: (lv_options_0_0= ruleOptions )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:804:1: (lv_options_0_0= ruleOptions )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:805:3: lv_options_0_0= ruleOptions
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleOptionsAccess().getOptionsOptionsParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOptions_in_ruleRuleOptions1850);
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

                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRuleOptions1862); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleOptionsAccess().getColonKeyword_0_1());
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:825:1: ( (lv_element_2_0= ruleAtom ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:826:1: (lv_element_2_0= ruleAtom )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:826:1: (lv_element_2_0= ruleAtom )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:827:3: lv_element_2_0= ruleAtom
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleOptionsAccess().getElementAtomParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAtom_in_ruleRuleOptions1883);
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
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:844:6: ( () otherlv_4= '{skip();}' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:844:6: ( () otherlv_4= '{skip();}' )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:844:7: () otherlv_4= '{skip();}'
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:844:7: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:845:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleOptionsAccess().getSkipAction_1_0(),
                                current);
                        

                    }

                    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleRuleOptions1912); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:862:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:863:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:864:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1949);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1959); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:871:1: ruleLiteral returns [EObject current=null] : (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RuleCall_0 = null;

        EObject this_Keyword_1 = null;

        EObject this_Wildcard_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:874:28: ( (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:875:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:875:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            int alt19=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt19=1;
                }
                break;
            case RULE_STRING:
                {
                alt19=2;
                }
                break;
            case 28:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:876:5: this_RuleCall_0= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getRuleCallParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleLiteral2006);
                    this_RuleCall_0=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:886:5: this_Keyword_1= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getKeywordParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleLiteral2033);
                    this_Keyword_1=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:896:5: this_Wildcard_2= ruleWildcard
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getWildcardParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleLiteral2060);
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:912:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:913:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:914:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2095);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2105); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:921:1: ruleRuleCall returns [EObject current=null] : ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_rule_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:924:28: ( ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:925:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:925:1: ( ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:925:2: ( (lv_rule_0_0= RULE_ID ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:925:2: ( (lv_rule_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:926:1: (lv_rule_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:926:1: (lv_rule_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:927:3: lv_rule_0_0= RULE_ID
            {
            lv_rule_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2147); 

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

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:943:2: ( ruleEmptyParenthesis )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2==26) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:944:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getRuleCallAccess().getEmptyParenthesisParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2169);
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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleKeyword"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:959:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:960:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:961:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2206);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2216); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:968:1: ruleKeyword returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:971:28: ( ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:972:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:972:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:972:2: ( (lv_value_0_0= RULE_STRING ) ) ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:972:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:973:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:973:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:974:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2258); 

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

            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:990:2: ( ruleEmptyParenthesis )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==25) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==26) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:991:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getKeywordAccess().getEmptyParenthesisParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2280);
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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleWildcard"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1006:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1007:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1008:2: iv_ruleWildcard= ruleWildcard EOF
            {
             newCompositeNode(grammarAccess.getWildcardRule()); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard2317);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard2327); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1015:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ( ruleEmptyParenthesis )* ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1018:28: ( ( () otherlv_1= '.' ( ruleEmptyParenthesis )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1019:1: ( () otherlv_1= '.' ( ruleEmptyParenthesis )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1019:1: ( () otherlv_1= '.' ( ruleEmptyParenthesis )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1019:2: () otherlv_1= '.' ( ruleEmptyParenthesis )*
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1019:2: ()
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1020:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWildcardAccess().getWildcardAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleWildcard2373); 

                	newLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1());
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1029:1: ( ruleEmptyParenthesis )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==26) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/debug/parser/antlr/internal/InternalSimpleAntlr.g:1030:5: ruleEmptyParenthesis
            	    {
            	     
            	            newCompositeNode(grammarAccess.getWildcardAccess().getEmptyParenthesisParserRuleCall_2()); 
            	        
            	    pushFollow(FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2390);
            	    ruleEmptyParenthesis();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
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
    public static final BitSet FOLLOW_12_in_ruleAntlrGrammar156 = new BitSet(new long[]{0x0000000000022012L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleAntlrGrammar177 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_ruleRule_in_ruleAntlrGrammar199 = new BitSet(new long[]{0x0000000000020012L});
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
    public static final BitSet FOLLOW_17_in_ruleRule688 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRule719 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRule736 = new BitSet(new long[]{0x000000001A802050L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleRule757 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRule769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives862 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAlternatives884 = new BitSet(new long[]{0x000000001A802050L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives905 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleGroup1002 = new BitSet(new long[]{0x000000001A802052L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleGroup1032 = new BitSet(new long[]{0x000000001A802052L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom1071 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherElement_in_ruleAtom1129 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_20_in_ruleAtom1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAtom1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleAtom1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleOptions_in_ruleAtom1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherElement_in_entryRuleOtherElement1298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherElement1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOtherElement1355 = new BitSet(new long[]{0x0000000012800050L});
    public static final BitSet FOLLOW_ruleParenthesized_in_ruleOtherElement1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesized_in_ruleOtherElement1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1457 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleOtherElement1478 = new BitSet(new long[]{0x0000000012800050L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleOtherElement1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_entryRuleEmptyParenthesis1539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyParenthesis1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleEmptyParenthesis1588 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleEmptyParenthesis1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesized_in_entryRuleParenthesized1641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesized1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleParenthesized1688 = new BitSet(new long[]{0x000000001A802050L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1705 = new BitSet(new long[]{0x000000001A802050L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesized1728 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesized1739 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleParenthesized1756 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleRuleOptions_in_entryRuleRuleOptions1793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleOptions1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleRuleOptions1850 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRuleOptions1862 = new BitSet(new long[]{0x000000001A802050L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleRuleOptions1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleRuleOptions1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleLiteral2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleLiteral2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleLiteral2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2147 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleRuleCall2169 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2258 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleKeyword2280 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleWildcard2373 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEmptyParenthesis_in_ruleWildcard2390 = new BitSet(new long[]{0x0000000002000002L});

}
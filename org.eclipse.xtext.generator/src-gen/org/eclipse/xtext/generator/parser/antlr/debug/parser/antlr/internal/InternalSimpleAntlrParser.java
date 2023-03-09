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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSimpleAntlrParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_OPEN", "RULE_STRING", "RULE_EMPTY_PAREN", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'grammar'", "';'", "'options'", "'{'", "'}'", "'='", "'fragment'", "'['", "','", "']'", "':'", "'|'", "'+'", "'*'", "'?'", "'~'", "'..'", "'=>'", "'||'", "'&&'", "'!'", "')'", "'skip();'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_OPEN=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int RULE_EMPTY_PAREN=8;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalSimpleAntlrParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleAntlrParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleAntlrParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleAntlr.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
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
    // InternalSimpleAntlr.g:73:1: entryRuleAntlrGrammar returns [EObject current=null] : iv_ruleAntlrGrammar= ruleAntlrGrammar EOF ;
    public final EObject entryRuleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntlrGrammar = null;


        try {
            // InternalSimpleAntlr.g:74:2: (iv_ruleAntlrGrammar= ruleAntlrGrammar EOF )
            // InternalSimpleAntlr.g:75:2: iv_ruleAntlrGrammar= ruleAntlrGrammar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAntlrGrammarRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAntlrGrammar=ruleAntlrGrammar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAntlrGrammar; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:82:1: ruleAntlrGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) ;
    public final EObject ruleAntlrGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_options_3_0 = null;

        EObject lv_rules_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:85:28: ( (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* ) )
            // InternalSimpleAntlr.g:86:1: (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            {
            // InternalSimpleAntlr.g:86:1: (otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )* )
            // InternalSimpleAntlr.g:86:3: otherlv_0= 'grammar' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_options_3_0= ruleOptions ) )? ( (lv_rules_4_0= ruleRule ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAntlrGrammarAccess().getGrammarKeyword_0());
                  
            }
            // InternalSimpleAntlr.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleAntlr.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleAntlr.g:91:1: (lv_name_1_0= RULE_ID )
            // InternalSimpleAntlr.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getAntlrGrammarAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAntlrGrammarRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAntlrGrammarAccess().getSemicolonKeyword_2());
                  
            }
            // InternalSimpleAntlr.g:112:1: ( (lv_options_3_0= ruleOptions ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSimpleAntlr.g:113:1: (lv_options_3_0= ruleOptions )
                    {
                    // InternalSimpleAntlr.g:113:1: (lv_options_3_0= ruleOptions )
                    // InternalSimpleAntlr.g:114:3: lv_options_3_0= ruleOptions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAntlrGrammarAccess().getOptionsOptionsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_options_3_0=ruleOptions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAntlrGrammarRule());
                      	        }
                             		set(
                             			current, 
                             			"options",
                              		lv_options_3_0, 
                              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Options");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleAntlr.g:130:3: ( (lv_rules_4_0= ruleRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSimpleAntlr.g:131:1: (lv_rules_4_0= ruleRule )
            	    {
            	    // InternalSimpleAntlr.g:131:1: (lv_rules_4_0= ruleRule )
            	    // InternalSimpleAntlr.g:132:3: lv_rules_4_0= ruleRule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAntlrGrammarAccess().getRulesRuleParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_rules_4_0=ruleRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAntlrGrammarRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"rules",
            	              		lv_rules_4_0, 
            	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Rule");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAntlrGrammar"


    // $ANTLR start "entryRuleOptions"
    // InternalSimpleAntlr.g:156:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // InternalSimpleAntlr.g:157:2: (iv_ruleOptions= ruleOptions EOF )
            // InternalSimpleAntlr.g:158:2: iv_ruleOptions= ruleOptions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOptions=ruleOptions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptions; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:165:1: ruleOptions returns [EObject current=null] : ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )+ otherlv_4= '}' ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_optionValues_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:168:28: ( ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )+ otherlv_4= '}' ) )
            // InternalSimpleAntlr.g:169:1: ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )+ otherlv_4= '}' )
            {
            // InternalSimpleAntlr.g:169:1: ( () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )+ otherlv_4= '}' )
            // InternalSimpleAntlr.g:169:2: () otherlv_1= 'options' otherlv_2= '{' ( (lv_optionValues_3_0= ruleOptionValue ) )+ otherlv_4= '}'
            {
            // InternalSimpleAntlr.g:169:2: ()
            // InternalSimpleAntlr.g:170:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOptionsAccess().getOptionsAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,15,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOptionsAccess().getOptionsKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,16,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalSimpleAntlr.g:186:1: ( (lv_optionValues_3_0= ruleOptionValue ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSimpleAntlr.g:187:1: (lv_optionValues_3_0= ruleOptionValue )
            	    {
            	    // InternalSimpleAntlr.g:187:1: (lv_optionValues_3_0= ruleOptionValue )
            	    // InternalSimpleAntlr.g:188:3: lv_optionValues_3_0= ruleOptionValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionValuesOptionValueParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_optionValues_3_0=ruleOptionValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOptionsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"optionValues",
            	              		lv_optionValues_3_0, 
            	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.OptionValue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOptionsAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOptions"


    // $ANTLR start "entryRuleOptionValue"
    // InternalSimpleAntlr.g:216:1: entryRuleOptionValue returns [EObject current=null] : iv_ruleOptionValue= ruleOptionValue EOF ;
    public final EObject entryRuleOptionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionValue = null;


        try {
            // InternalSimpleAntlr.g:217:2: (iv_ruleOptionValue= ruleOptionValue EOF )
            // InternalSimpleAntlr.g:218:2: iv_ruleOptionValue= ruleOptionValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOptionValue=ruleOptionValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:225:1: ruleOptionValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' ) ;
    public final EObject ruleOptionValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:228:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' ) )
            // InternalSimpleAntlr.g:229:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' )
            {
            // InternalSimpleAntlr.g:229:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';' )
            // InternalSimpleAntlr.g:229:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleIdOrInt ) ) otherlv_3= ';'
            {
            // InternalSimpleAntlr.g:229:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalSimpleAntlr.g:230:1: (lv_key_0_0= RULE_ID )
            {
            // InternalSimpleAntlr.g:230:1: (lv_key_0_0= RULE_ID )
            // InternalSimpleAntlr.g:231:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_key_0_0, grammarAccess.getOptionValueAccess().getKeyIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOptionValueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOptionValueAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalSimpleAntlr.g:251:1: ( (lv_value_2_0= ruleIdOrInt ) )
            // InternalSimpleAntlr.g:252:1: (lv_value_2_0= ruleIdOrInt )
            {
            // InternalSimpleAntlr.g:252:1: (lv_value_2_0= ruleIdOrInt )
            // InternalSimpleAntlr.g:253:3: lv_value_2_0= ruleIdOrInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOptionValueAccess().getValueIdOrIntParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_value_2_0=ruleIdOrInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOptionValueRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.IdOrInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOptionValueAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOptionValue"


    // $ANTLR start "entryRuleIdOrInt"
    // InternalSimpleAntlr.g:281:1: entryRuleIdOrInt returns [String current=null] : iv_ruleIdOrInt= ruleIdOrInt EOF ;
    public final String entryRuleIdOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrInt = null;


        try {
            // InternalSimpleAntlr.g:282:2: (iv_ruleIdOrInt= ruleIdOrInt EOF )
            // InternalSimpleAntlr.g:283:2: iv_ruleIdOrInt= ruleIdOrInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrIntRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrInt=ruleIdOrInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrInt.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:290:1: ruleIdOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleIdOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:293:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) )
            // InternalSimpleAntlr.g:294:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            {
            // InternalSimpleAntlr.g:294:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSimpleAntlr.g:294:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdOrIntAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:302:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_1, grammarAccess.getIdOrIntAccess().getINTTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIdOrInt"


    // $ANTLR start "entryRuleRule"
    // InternalSimpleAntlr.g:317:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalSimpleAntlr.g:318:2: (iv_ruleRule= ruleRule EOF )
            // InternalSimpleAntlr.g:319:2: iv_ruleRule= ruleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:326:1: ruleRule returns [EObject current=null] : ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']' )? otherlv_7= ':' ( (lv_body_8_0= ruleAlternatives ) ) otherlv_9= ';' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_body_8_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:329:28: ( ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']' )? otherlv_7= ':' ( (lv_body_8_0= ruleAlternatives ) ) otherlv_9= ';' ) )
            // InternalSimpleAntlr.g:330:1: ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']' )? otherlv_7= ':' ( (lv_body_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            {
            // InternalSimpleAntlr.g:330:1: ( ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']' )? otherlv_7= ':' ( (lv_body_8_0= ruleAlternatives ) ) otherlv_9= ';' )
            // InternalSimpleAntlr.g:330:2: ( (lv_fragment_0_0= 'fragment' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']' )? otherlv_7= ':' ( (lv_body_8_0= ruleAlternatives ) ) otherlv_9= ';'
            {
            // InternalSimpleAntlr.g:330:2: ( (lv_fragment_0_0= 'fragment' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSimpleAntlr.g:331:1: (lv_fragment_0_0= 'fragment' )
                    {
                    // InternalSimpleAntlr.g:331:1: (lv_fragment_0_0= 'fragment' )
                    // InternalSimpleAntlr.g:332:3: lv_fragment_0_0= 'fragment'
                    {
                    lv_fragment_0_0=(Token)match(input,19,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_fragment_0_0, grammarAccess.getRuleAccess().getFragmentFragmentKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRuleRule());
                      	        }
                             		setWithLastConsumed(current, "fragment", true, "fragment");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleAntlr.g:345:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleAntlr.g:346:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleAntlr.g:346:1: (lv_name_1_0= RULE_ID )
            // InternalSimpleAntlr.g:347:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.ID");
              	    
            }

            }


            }

            // InternalSimpleAntlr.g:363:2: (otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSimpleAntlr.g:363:4: otherlv_2= '[' ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // InternalSimpleAntlr.g:367:1: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalSimpleAntlr.g:368:1: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalSimpleAntlr.g:368:1: (lv_parameters_3_0= ruleParameter )
                    // InternalSimpleAntlr.g:369:3: lv_parameters_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleAccess().getParametersParameterParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_12);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleRule());
                      	        }
                             		add(
                             			current, 
                             			"parameters",
                              		lv_parameters_3_0, 
                              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Parameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSimpleAntlr.g:385:2: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==21) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSimpleAntlr.g:385:4: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // InternalSimpleAntlr.g:389:1: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalSimpleAntlr.g:390:1: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalSimpleAntlr.g:390:1: (lv_parameters_5_0= ruleParameter )
                    	    // InternalSimpleAntlr.g:391:3: lv_parameters_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleAccess().getParametersParameterParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"parameters",
                    	              		lv_parameters_5_0, 
                    	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Parameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getRightSquareBracketKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            otherlv_7=(Token)match(input,23,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getRuleAccess().getColonKeyword_3());
                  
            }
            // InternalSimpleAntlr.g:415:1: ( (lv_body_8_0= ruleAlternatives ) )
            // InternalSimpleAntlr.g:416:1: (lv_body_8_0= ruleAlternatives )
            {
            // InternalSimpleAntlr.g:416:1: (lv_body_8_0= ruleAlternatives )
            // InternalSimpleAntlr.g:417:3: lv_body_8_0= ruleAlternatives
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleAccess().getBodyAlternativesParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_body_8_0=ruleAlternatives();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRuleRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_8_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Alternatives");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getRuleAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleParameter"
    // InternalSimpleAntlr.g:445:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSimpleAntlr.g:446:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalSimpleAntlr.g:447:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSimpleAntlr.g:454:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:457:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimpleAntlr.g:458:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimpleAntlr.g:458:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimpleAntlr.g:458:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSimpleAntlr.g:458:2: ( (lv_type_0_0= RULE_ID ) )
            // InternalSimpleAntlr.g:459:1: (lv_type_0_0= RULE_ID )
            {
            // InternalSimpleAntlr.g:459:1: (lv_type_0_0= RULE_ID )
            // InternalSimpleAntlr.g:460:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_type_0_0, grammarAccess.getParameterAccess().getTypeIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.ID");
              	    
            }

            }


            }

            // InternalSimpleAntlr.g:476:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleAntlr.g:477:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleAntlr.g:477:1: (lv_name_1_0= RULE_ID )
            // InternalSimpleAntlr.g:478:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.ID");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleAlternatives"
    // InternalSimpleAntlr.g:502:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // InternalSimpleAntlr.g:503:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // InternalSimpleAntlr.g:504:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternatives; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:511:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:514:28: ( (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // InternalSimpleAntlr.g:515:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // InternalSimpleAntlr.g:515:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // InternalSimpleAntlr.g:516:2: this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_15);
            this_Group_0=ruleGroup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Group_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSimpleAntlr.g:527:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSimpleAntlr.g:527:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // InternalSimpleAntlr.g:527:2: ()
                    // InternalSimpleAntlr.g:528:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndAdd(
                                  grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSimpleAntlr.g:536:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==24) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalSimpleAntlr.g:536:4: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	          
                    	    }
                    	    // InternalSimpleAntlr.g:540:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // InternalSimpleAntlr.g:541:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // InternalSimpleAntlr.g:541:1: (lv_groups_3_0= ruleGroup )
                    	    // InternalSimpleAntlr.g:542:3: lv_groups_3_0= ruleGroup
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_groups_3_0=ruleGroup();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAlternativesRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"groups",
                    	              		lv_groups_3_0, 
                    	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Group");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleGroup"
    // InternalSimpleAntlr.g:566:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalSimpleAntlr.g:567:2: (iv_ruleGroup= ruleGroup EOF )
            // InternalSimpleAntlr.g:568:2: iv_ruleGroup= ruleGroup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroup; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:575:1: ruleGroup returns [EObject current=null] : (this_Guarded_0= ruleGuarded | (this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )? ) ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_Guarded_0 = null;

        EObject this_Atom_1 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:578:28: ( (this_Guarded_0= ruleGuarded | (this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )? ) ) )
            // InternalSimpleAntlr.g:579:1: (this_Guarded_0= ruleGuarded | (this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )? ) )
            {
            // InternalSimpleAntlr.g:579:1: (this_Guarded_0= ruleGuarded | (this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )? ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_ID||LA12_1==RULE_OPEN||LA12_1==33) ) {
                    alt12=1;
                }
                else if ( (LA12_1==35) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==RULE_ID||(LA12_0>=RULE_OPEN && LA12_0<=RULE_STRING)||LA12_0==15||LA12_0==28||LA12_0==36) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalSimpleAntlr.g:580:2: this_Guarded_0= ruleGuarded
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupAccess().getGuardedParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Guarded_0=ruleGuarded();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Guarded_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:592:6: (this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )? )
                    {
                    // InternalSimpleAntlr.g:592:6: (this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )? )
                    // InternalSimpleAntlr.g:593:2: this_Atom_1= ruleAtom ( () ( (lv_elements_3_0= ruleAtom ) )+ )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupAccess().getAtomParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_16);
                    this_Atom_1=ruleAtom();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Atom_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSimpleAntlr.g:604:1: ( () ( (lv_elements_3_0= ruleAtom ) )+ )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_ID||(LA11_0>=RULE_OPEN && LA11_0<=RULE_STRING)||(LA11_0>=15 && LA11_0<=16)||LA11_0==28||LA11_0==36) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSimpleAntlr.g:604:2: () ( (lv_elements_3_0= ruleAtom ) )+
                            {
                            // InternalSimpleAntlr.g:604:2: ()
                            // InternalSimpleAntlr.g:605:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getGroupAccess().getGroupElementsAction_1_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalSimpleAntlr.g:613:2: ( (lv_elements_3_0= ruleAtom ) )+
                            int cnt10=0;
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==RULE_ID||(LA10_0>=RULE_OPEN && LA10_0<=RULE_STRING)||(LA10_0>=15 && LA10_0<=16)||LA10_0==28||LA10_0==36) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // InternalSimpleAntlr.g:614:1: (lv_elements_3_0= ruleAtom )
                            	    {
                            	    // InternalSimpleAntlr.g:614:1: (lv_elements_3_0= ruleAtom )
                            	    // InternalSimpleAntlr.g:615:3: lv_elements_3_0= ruleAtom
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getGroupAccess().getElementsAtomParserRuleCall_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_16);
                            	    lv_elements_3_0=ruleAtom();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getGroupRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"elements",
                            	              		lv_elements_3_0, 
                            	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Atom");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt10 >= 1 ) break loop10;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(10, input);
                                        throw eee;
                                }
                                cnt10++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAtom"
    // InternalSimpleAntlr.g:639:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalSimpleAntlr.g:640:2: (iv_ruleAtom= ruleAtom EOF )
            // InternalSimpleAntlr.g:641:2: iv_ruleAtom= ruleAtom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtom; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:648:1: ruleAtom returns [EObject current=null] : ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_OtherElement_0 = null;

        EObject this_RuleOptions_3 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:651:28: ( ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions ) )
            // InternalSimpleAntlr.g:652:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            {
            // InternalSimpleAntlr.g:652:1: ( (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? ) | this_RuleOptions_3= ruleRuleOptions )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||(LA15_0>=RULE_OPEN && LA15_0<=RULE_STRING)||LA15_0==28||LA15_0==36) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=15 && LA15_0<=16)) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalSimpleAntlr.g:652:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    {
                    // InternalSimpleAntlr.g:652:2: (this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )? )
                    // InternalSimpleAntlr.g:653:2: this_OtherElement_0= ruleOtherElement ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getOtherElementParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_17);
                    this_OtherElement_0=ruleOtherElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OtherElement_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSimpleAntlr.g:664:1: ( () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=25 && LA14_0<=27)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalSimpleAntlr.g:664:2: () ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            {
                            // InternalSimpleAntlr.g:664:2: ()
                            // InternalSimpleAntlr.g:665:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getAtomAccess().getElementWithCardinalityElementAction_0_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalSimpleAntlr.g:673:2: ( ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) ) )
                            // InternalSimpleAntlr.g:674:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            {
                            // InternalSimpleAntlr.g:674:1: ( (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' ) )
                            // InternalSimpleAntlr.g:675:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            {
                            // InternalSimpleAntlr.g:675:1: (lv_cardinality_2_1= '+' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '?' )
                            int alt13=3;
                            switch ( input.LA(1) ) {
                            case 25:
                                {
                                alt13=1;
                                }
                                break;
                            case 26:
                                {
                                alt13=2;
                                }
                                break;
                            case 27:
                                {
                                alt13=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 0, input);

                                throw nvae;
                            }

                            switch (alt13) {
                                case 1 :
                                    // InternalSimpleAntlr.g:676:3: lv_cardinality_2_1= '+'
                                    {
                                    lv_cardinality_2_1=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_cardinality_2_1, grammarAccess.getAtomAccess().getCardinalityPlusSignKeyword_0_1_1_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getAtomRule());
                                      	        }
                                             		setWithLastConsumed(current, "cardinality", lv_cardinality_2_1, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalSimpleAntlr.g:688:8: lv_cardinality_2_2= '*'
                                    {
                                    lv_cardinality_2_2=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_cardinality_2_2, grammarAccess.getAtomAccess().getCardinalityAsteriskKeyword_0_1_1_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getAtomRule());
                                      	        }
                                             		setWithLastConsumed(current, "cardinality", lv_cardinality_2_2, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 3 :
                                    // InternalSimpleAntlr.g:700:8: lv_cardinality_2_3= '?'
                                    {
                                    lv_cardinality_2_3=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_cardinality_2_3, grammarAccess.getAtomAccess().getCardinalityQuestionMarkKeyword_0_1_1_0_2());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getAtomRule());
                                      	        }
                                             		setWithLastConsumed(current, "cardinality", lv_cardinality_2_3, null);
                                      	    
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
                    // InternalSimpleAntlr.g:717:2: this_RuleOptions_3= ruleRuleOptions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomAccess().getRuleOptionsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RuleOptions_3=ruleRuleOptions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RuleOptions_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleOtherElement"
    // InternalSimpleAntlr.g:736:1: entryRuleOtherElement returns [EObject current=null] : iv_ruleOtherElement= ruleOtherElement EOF ;
    public final EObject entryRuleOtherElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherElement = null;


        try {
            // InternalSimpleAntlr.g:737:2: (iv_ruleOtherElement= ruleOtherElement EOF )
            // InternalSimpleAntlr.g:738:2: iv_ruleOtherElement= ruleOtherElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOtherElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOtherElement=ruleOtherElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOtherElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:745:1: ruleOtherElement returns [EObject current=null] : ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Predicated_3= rulePredicated | this_Parenthesized_4= ruleParenthesized | (this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )? ) ) ;
    public final EObject ruleOtherElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_7=null;
        EObject lv_element_2_1 = null;

        EObject lv_element_2_2 = null;

        EObject this_Predicated_3 = null;

        EObject this_Parenthesized_4 = null;

        EObject this_Literal_5 = null;

        EObject lv_right_8_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:748:28: ( ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Predicated_3= rulePredicated | this_Parenthesized_4= ruleParenthesized | (this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )? ) ) )
            // InternalSimpleAntlr.g:749:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Predicated_3= rulePredicated | this_Parenthesized_4= ruleParenthesized | (this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )? ) )
            {
            // InternalSimpleAntlr.g:749:1: ( ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) ) | this_Predicated_3= rulePredicated | this_Parenthesized_4= ruleParenthesized | (this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )? ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt18=1;
                }
                break;
            case RULE_OPEN:
                {
                int LA18_2 = input.LA(2);

                if ( (synpred19_InternalSimpleAntlr()) ) {
                    alt18=2;
                }
                else if ( (synpred20_InternalSimpleAntlr()) ) {
                    alt18=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case 36:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalSimpleAntlr.g:749:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    {
                    // InternalSimpleAntlr.g:749:2: ( () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) ) )
                    // InternalSimpleAntlr.g:749:3: () otherlv_1= '~' ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    {
                    // InternalSimpleAntlr.g:749:3: ()
                    // InternalSimpleAntlr.g:750:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getOtherElementAccess().getNegatedElementAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getOtherElementAccess().getTildeKeyword_0_1());
                          
                    }
                    // InternalSimpleAntlr.g:762:1: ( ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) ) )
                    // InternalSimpleAntlr.g:763:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    {
                    // InternalSimpleAntlr.g:763:1: ( (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral ) )
                    // InternalSimpleAntlr.g:764:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    {
                    // InternalSimpleAntlr.g:764:1: (lv_element_2_1= ruleParenthesized | lv_element_2_2= ruleLiteral )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_OPEN) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==RULE_ID||LA16_0==RULE_STRING||LA16_0==36) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalSimpleAntlr.g:765:3: lv_element_2_1= ruleParenthesized
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getOtherElementAccess().getElementParenthesizedParserRuleCall_0_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_element_2_1=ruleParenthesized();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getOtherElementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"element",
                                      		lv_element_2_1, 
                                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Parenthesized");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSimpleAntlr.g:780:8: lv_element_2_2= ruleLiteral
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getOtherElementAccess().getElementLiteralParserRuleCall_0_2_0_1()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_element_2_2=ruleLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getOtherElementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"element",
                                      		lv_element_2_2, 
                                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Literal");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:800:2: this_Predicated_3= rulePredicated
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOtherElementAccess().getPredicatedParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Predicated_3=rulePredicated();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Predicated_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleAntlr.g:813:2: this_Parenthesized_4= ruleParenthesized
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOtherElementAccess().getParenthesizedParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Parenthesized_4=ruleParenthesized();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Parenthesized_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSimpleAntlr.g:825:6: (this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )? )
                    {
                    // InternalSimpleAntlr.g:825:6: (this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )? )
                    // InternalSimpleAntlr.g:826:2: this_Literal_5= ruleLiteral ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOtherElementAccess().getLiteralParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_19);
                    this_Literal_5=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Literal_5; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSimpleAntlr.g:837:1: ( () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==29) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalSimpleAntlr.g:837:2: () otherlv_7= '..' ( (lv_right_8_0= ruleLiteral ) )
                            {
                            // InternalSimpleAntlr.g:837:2: ()
                            // InternalSimpleAntlr.g:838:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getOtherElementAccess().getUntilElementLeftAction_3_1_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_7=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getOtherElementAccess().getFullStopFullStopKeyword_3_1_1());
                                  
                            }
                            // InternalSimpleAntlr.g:850:1: ( (lv_right_8_0= ruleLiteral ) )
                            // InternalSimpleAntlr.g:851:1: (lv_right_8_0= ruleLiteral )
                            {
                            // InternalSimpleAntlr.g:851:1: (lv_right_8_0= ruleLiteral )
                            // InternalSimpleAntlr.g:852:3: lv_right_8_0= ruleLiteral
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getOtherElementAccess().getRightLiteralParserRuleCall_3_1_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_8_0=ruleLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getOtherElementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"right",
                                      		lv_right_8_0, 
                                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Literal");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOtherElement"


    // $ANTLR start "entryRuleGuarded"
    // InternalSimpleAntlr.g:876:1: entryRuleGuarded returns [EObject current=null] : iv_ruleGuarded= ruleGuarded EOF ;
    public final EObject entryRuleGuarded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuarded = null;


        try {
            // InternalSimpleAntlr.g:877:2: (iv_ruleGuarded= ruleGuarded EOF )
            // InternalSimpleAntlr.g:878:2: iv_ruleGuarded= ruleGuarded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGuarded=ruleGuarded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuarded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleGuarded"


    // $ANTLR start "ruleGuarded"
    // InternalSimpleAntlr.g:885:1: ruleGuarded returns [EObject current=null] : (otherlv_0= '{' ( (lv_guard_1_0= ruleOrExpression ) ) otherlv_2= '}' otherlv_3= '?' otherlv_4= '=>' ( (lv_guarded_5_0= ruleParenthesized ) ) ) ;
    public final EObject ruleGuarded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_guard_1_0 = null;

        EObject lv_guarded_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:888:28: ( (otherlv_0= '{' ( (lv_guard_1_0= ruleOrExpression ) ) otherlv_2= '}' otherlv_3= '?' otherlv_4= '=>' ( (lv_guarded_5_0= ruleParenthesized ) ) ) )
            // InternalSimpleAntlr.g:889:1: (otherlv_0= '{' ( (lv_guard_1_0= ruleOrExpression ) ) otherlv_2= '}' otherlv_3= '?' otherlv_4= '=>' ( (lv_guarded_5_0= ruleParenthesized ) ) )
            {
            // InternalSimpleAntlr.g:889:1: (otherlv_0= '{' ( (lv_guard_1_0= ruleOrExpression ) ) otherlv_2= '}' otherlv_3= '?' otherlv_4= '=>' ( (lv_guarded_5_0= ruleParenthesized ) ) )
            // InternalSimpleAntlr.g:889:3: otherlv_0= '{' ( (lv_guard_1_0= ruleOrExpression ) ) otherlv_2= '}' otherlv_3= '?' otherlv_4= '=>' ( (lv_guarded_5_0= ruleParenthesized ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGuardedAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // InternalSimpleAntlr.g:893:1: ( (lv_guard_1_0= ruleOrExpression ) )
            // InternalSimpleAntlr.g:894:1: (lv_guard_1_0= ruleOrExpression )
            {
            // InternalSimpleAntlr.g:894:1: (lv_guard_1_0= ruleOrExpression )
            // InternalSimpleAntlr.g:895:3: lv_guard_1_0= ruleOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGuardedAccess().getGuardOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
            lv_guard_1_0=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGuardedRule());
              	        }
                     		set(
                     			current, 
                     			"guard",
                      		lv_guard_1_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.OrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getGuardedAccess().getRightCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,27,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getGuardedAccess().getQuestionMarkKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,30,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getGuardedAccess().getEqualsSignGreaterThanSignKeyword_4());
                  
            }
            // InternalSimpleAntlr.g:923:1: ( (lv_guarded_5_0= ruleParenthesized ) )
            // InternalSimpleAntlr.g:924:1: (lv_guarded_5_0= ruleParenthesized )
            {
            // InternalSimpleAntlr.g:924:1: (lv_guarded_5_0= ruleParenthesized )
            // InternalSimpleAntlr.g:925:3: lv_guarded_5_0= ruleParenthesized
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGuardedAccess().getGuardedParenthesizedParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_guarded_5_0=ruleParenthesized();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGuardedRule());
              	        }
                     		set(
                     			current, 
                     			"guarded",
                      		lv_guarded_5_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Parenthesized");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleGuarded"


    // $ANTLR start "entryRuleOrExpression"
    // InternalSimpleAntlr.g:949:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalSimpleAntlr.g:950:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalSimpleAntlr.g:951:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalSimpleAntlr.g:958:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:961:28: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalSimpleAntlr.g:962:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalSimpleAntlr.g:962:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalSimpleAntlr.g:963:2: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_25);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSimpleAntlr.g:974:1: ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==31) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSimpleAntlr.g:974:2: () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalSimpleAntlr.g:974:2: ()
            	    // InternalSimpleAntlr.g:975:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	          
            	    }
            	    // InternalSimpleAntlr.g:987:1: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalSimpleAntlr.g:988:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalSimpleAntlr.g:988:1: (lv_right_3_0= ruleAndExpression )
            	    // InternalSimpleAntlr.g:989:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalSimpleAntlr.g:1013:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalSimpleAntlr.g:1014:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalSimpleAntlr.g:1015:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalSimpleAntlr.g:1022:1: ruleAndExpression returns [EObject current=null] : (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1025:28: ( (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* ) )
            // InternalSimpleAntlr.g:1026:1: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            {
            // InternalSimpleAntlr.g:1026:1: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            // InternalSimpleAntlr.g:1027:2: this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_26);
            this_NotExpression_0=ruleNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NotExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSimpleAntlr.g:1038:1: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSimpleAntlr.g:1038:2: () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) )
            	    {
            	    // InternalSimpleAntlr.g:1038:2: ()
            	    // InternalSimpleAntlr.g:1039:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	          
            	    }
            	    // InternalSimpleAntlr.g:1051:1: ( (lv_right_3_0= ruleNotExpression ) )
            	    // InternalSimpleAntlr.g:1052:1: (lv_right_3_0= ruleNotExpression )
            	    {
            	    // InternalSimpleAntlr.g:1052:1: (lv_right_3_0= ruleNotExpression )
            	    // InternalSimpleAntlr.g:1053:3: lv_right_3_0= ruleNotExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_right_3_0=ruleNotExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.NotExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleNotExpression"
    // InternalSimpleAntlr.g:1077:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // InternalSimpleAntlr.g:1078:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // InternalSimpleAntlr.g:1079:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNotExpression=ruleNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // InternalSimpleAntlr.g:1086:1: ruleNotExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1089:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) ) ) ) )
            // InternalSimpleAntlr.g:1090:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) ) ) )
            {
            // InternalSimpleAntlr.g:1090:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||LA21_0==RULE_OPEN) ) {
                alt21=1;
            }
            else if ( (LA21_0==33) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSimpleAntlr.g:1091:2: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNotExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:1103:6: ( () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) ) )
                    {
                    // InternalSimpleAntlr.g:1103:6: ( () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) ) )
                    // InternalSimpleAntlr.g:1103:7: () otherlv_2= '!' ( (lv_value_3_0= ruleNotExpression ) )
                    {
                    // InternalSimpleAntlr.g:1103:7: ()
                    // InternalSimpleAntlr.g:1104:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNotExpressionAccess().getNotExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,33,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_1_1());
                          
                    }
                    // InternalSimpleAntlr.g:1116:1: ( (lv_value_3_0= ruleNotExpression ) )
                    // InternalSimpleAntlr.g:1117:1: (lv_value_3_0= ruleNotExpression )
                    {
                    // InternalSimpleAntlr.g:1117:1: (lv_value_3_0= ruleNotExpression )
                    // InternalSimpleAntlr.g:1118:3: lv_value_3_0= ruleNotExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNotExpressionAccess().getValueNotExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleNotExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNotExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.NotExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalSimpleAntlr.g:1142:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSimpleAntlr.g:1143:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSimpleAntlr.g:1144:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalSimpleAntlr.g:1151:1: rulePrimaryExpression returns [EObject current=null] : (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_ReferenceOrLiteral_1= ruleReferenceOrLiteral ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ParenthesizedExpression_0 = null;

        EObject this_ReferenceOrLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1154:28: ( (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_ReferenceOrLiteral_1= ruleReferenceOrLiteral ) )
            // InternalSimpleAntlr.g:1155:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_ReferenceOrLiteral_1= ruleReferenceOrLiteral )
            {
            // InternalSimpleAntlr.g:1155:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_ReferenceOrLiteral_1= ruleReferenceOrLiteral )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_OPEN) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ID) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalSimpleAntlr.g:1156:2: this_ParenthesizedExpression_0= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ParenthesizedExpression_0=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:1169:2: this_ReferenceOrLiteral_1= ruleReferenceOrLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceOrLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ReferenceOrLiteral_1=ruleReferenceOrLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReferenceOrLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalSimpleAntlr.g:1188:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalSimpleAntlr.g:1189:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalSimpleAntlr.g:1190:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalSimpleAntlr.g:1197:1: ruleParenthesizedExpression returns [EObject current=null] : (this_OPEN_0= RULE_OPEN this_OrExpression_1= ruleOrExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token this_OPEN_0=null;
        Token otherlv_2=null;
        EObject this_OrExpression_1 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1200:28: ( (this_OPEN_0= RULE_OPEN this_OrExpression_1= ruleOrExpression otherlv_2= ')' ) )
            // InternalSimpleAntlr.g:1201:1: (this_OPEN_0= RULE_OPEN this_OrExpression_1= ruleOrExpression otherlv_2= ')' )
            {
            // InternalSimpleAntlr.g:1201:1: (this_OPEN_0= RULE_OPEN this_OrExpression_1= ruleOrExpression otherlv_2= ')' )
            // InternalSimpleAntlr.g:1201:2: this_OPEN_0= RULE_OPEN this_OrExpression_1= ruleOrExpression otherlv_2= ')'
            {
            this_OPEN_0=(Token)match(input,RULE_OPEN,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_OPEN_0, grammarAccess.getParenthesizedExpressionAccess().getOPENTerminalRuleCall_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getOrExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_27);
            this_OrExpression_1=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleReferenceOrLiteral"
    // InternalSimpleAntlr.g:1229:1: entryRuleReferenceOrLiteral returns [EObject current=null] : iv_ruleReferenceOrLiteral= ruleReferenceOrLiteral EOF ;
    public final EObject entryRuleReferenceOrLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceOrLiteral = null;


        try {
            // InternalSimpleAntlr.g:1230:2: (iv_ruleReferenceOrLiteral= ruleReferenceOrLiteral EOF )
            // InternalSimpleAntlr.g:1231:2: iv_ruleReferenceOrLiteral= ruleReferenceOrLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceOrLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReferenceOrLiteral=ruleReferenceOrLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceOrLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReferenceOrLiteral"


    // $ANTLR start "ruleReferenceOrLiteral"
    // InternalSimpleAntlr.g:1238:1: ruleReferenceOrLiteral returns [EObject current=null] : ( (lv_name_0_0= ruleQName ) ) ;
    public final EObject ruleReferenceOrLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1241:28: ( ( (lv_name_0_0= ruleQName ) ) )
            // InternalSimpleAntlr.g:1242:1: ( (lv_name_0_0= ruleQName ) )
            {
            // InternalSimpleAntlr.g:1242:1: ( (lv_name_0_0= ruleQName ) )
            // InternalSimpleAntlr.g:1243:1: (lv_name_0_0= ruleQName )
            {
            // InternalSimpleAntlr.g:1243:1: (lv_name_0_0= ruleQName )
            // InternalSimpleAntlr.g:1244:3: lv_name_0_0= ruleQName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceOrLiteralAccess().getNameQNameParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleQName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceOrLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.QName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleReferenceOrLiteral"


    // $ANTLR start "entryRuleParenthesized"
    // InternalSimpleAntlr.g:1268:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // InternalSimpleAntlr.g:1269:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // InternalSimpleAntlr.g:1270:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesized; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:1277:1: ruleParenthesized returns [EObject current=null] : (this_OPEN_0= RULE_OPEN this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token this_OPEN_0=null;
        Token otherlv_2=null;
        EObject this_Alternatives_1 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1280:28: ( (this_OPEN_0= RULE_OPEN this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // InternalSimpleAntlr.g:1281:1: (this_OPEN_0= RULE_OPEN this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // InternalSimpleAntlr.g:1281:1: (this_OPEN_0= RULE_OPEN this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // InternalSimpleAntlr.g:1281:2: this_OPEN_0= RULE_OPEN this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {
            this_OPEN_0=(Token)match(input,RULE_OPEN,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_OPEN_0, grammarAccess.getParenthesizedAccess().getOPENTerminalRuleCall_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParenthesizedAccess().getAlternativesParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_27);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Alternatives_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParenthesizedAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParenthesized"


    // $ANTLR start "entryRulePredicated"
    // InternalSimpleAntlr.g:1309:1: entryRulePredicated returns [EObject current=null] : iv_rulePredicated= rulePredicated EOF ;
    public final EObject entryRulePredicated() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicated = null;


        try {
            // InternalSimpleAntlr.g:1310:2: (iv_rulePredicated= rulePredicated EOF )
            // InternalSimpleAntlr.g:1311:2: iv_rulePredicated= rulePredicated EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicatedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredicated=rulePredicated();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicated; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePredicated"


    // $ANTLR start "rulePredicated"
    // InternalSimpleAntlr.g:1318:1: rulePredicated returns [EObject current=null] : (this_OPEN_0= RULE_OPEN this_OPEN_1= RULE_OPEN ( (lv_predicate_2_0= ruleAlternatives ) ) otherlv_3= ')' otherlv_4= '=>' ( (lv_element_5_0= ruleOtherElement ) ) otherlv_6= ')' ) ;
    public final EObject rulePredicated() throws RecognitionException {
        EObject current = null;

        Token this_OPEN_0=null;
        Token this_OPEN_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_predicate_2_0 = null;

        EObject lv_element_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1321:28: ( (this_OPEN_0= RULE_OPEN this_OPEN_1= RULE_OPEN ( (lv_predicate_2_0= ruleAlternatives ) ) otherlv_3= ')' otherlv_4= '=>' ( (lv_element_5_0= ruleOtherElement ) ) otherlv_6= ')' ) )
            // InternalSimpleAntlr.g:1322:1: (this_OPEN_0= RULE_OPEN this_OPEN_1= RULE_OPEN ( (lv_predicate_2_0= ruleAlternatives ) ) otherlv_3= ')' otherlv_4= '=>' ( (lv_element_5_0= ruleOtherElement ) ) otherlv_6= ')' )
            {
            // InternalSimpleAntlr.g:1322:1: (this_OPEN_0= RULE_OPEN this_OPEN_1= RULE_OPEN ( (lv_predicate_2_0= ruleAlternatives ) ) otherlv_3= ')' otherlv_4= '=>' ( (lv_element_5_0= ruleOtherElement ) ) otherlv_6= ')' )
            // InternalSimpleAntlr.g:1322:2: this_OPEN_0= RULE_OPEN this_OPEN_1= RULE_OPEN ( (lv_predicate_2_0= ruleAlternatives ) ) otherlv_3= ')' otherlv_4= '=>' ( (lv_element_5_0= ruleOtherElement ) ) otherlv_6= ')'
            {
            this_OPEN_0=(Token)match(input,RULE_OPEN,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_OPEN_0, grammarAccess.getPredicatedAccess().getOPENTerminalRuleCall_0()); 
                  
            }
            this_OPEN_1=(Token)match(input,RULE_OPEN,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_OPEN_1, grammarAccess.getPredicatedAccess().getOPENTerminalRuleCall_1()); 
                  
            }
            // InternalSimpleAntlr.g:1330:1: ( (lv_predicate_2_0= ruleAlternatives ) )
            // InternalSimpleAntlr.g:1331:1: (lv_predicate_2_0= ruleAlternatives )
            {
            // InternalSimpleAntlr.g:1331:1: (lv_predicate_2_0= ruleAlternatives )
            // InternalSimpleAntlr.g:1332:3: lv_predicate_2_0= ruleAlternatives
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPredicatedAccess().getPredicateAlternativesParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
            lv_predicate_2_0=ruleAlternatives();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPredicatedRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_2_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Alternatives");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPredicatedAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,30,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getPredicatedAccess().getEqualsSignGreaterThanSignKeyword_4());
                  
            }
            // InternalSimpleAntlr.g:1356:1: ( (lv_element_5_0= ruleOtherElement ) )
            // InternalSimpleAntlr.g:1357:1: (lv_element_5_0= ruleOtherElement )
            {
            // InternalSimpleAntlr.g:1357:1: (lv_element_5_0= ruleOtherElement )
            // InternalSimpleAntlr.g:1358:3: lv_element_5_0= ruleOtherElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPredicatedAccess().getElementOtherElementParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
            lv_element_5_0=ruleOtherElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPredicatedRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_5_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.OtherElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getPredicatedAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePredicated"


    // $ANTLR start "entryRuleRuleOptions"
    // InternalSimpleAntlr.g:1386:1: entryRuleRuleOptions returns [EObject current=null] : iv_ruleRuleOptions= ruleRuleOptions EOF ;
    public final EObject entryRuleRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleOptions = null;


        try {
            // InternalSimpleAntlr.g:1387:2: (iv_ruleRuleOptions= ruleRuleOptions EOF )
            // InternalSimpleAntlr.g:1388:2: iv_ruleRuleOptions= ruleRuleOptions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleOptionsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleOptions=ruleRuleOptions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleOptions; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:1395:1: ruleRuleOptions returns [EObject current=null] : ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}' ) ) ;
    public final EObject ruleRuleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_options_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1398:28: ( ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}' ) ) )
            // InternalSimpleAntlr.g:1399:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}' ) )
            {
            // InternalSimpleAntlr.g:1399:1: ( ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) ) | ( () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                alt23=1;
            }
            else if ( (LA23_0==16) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalSimpleAntlr.g:1399:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    {
                    // InternalSimpleAntlr.g:1399:2: ( ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) ) )
                    // InternalSimpleAntlr.g:1399:3: ( (lv_options_0_0= ruleOptions ) ) otherlv_1= ':' ( (lv_element_2_0= ruleAtom ) )
                    {
                    // InternalSimpleAntlr.g:1399:3: ( (lv_options_0_0= ruleOptions ) )
                    // InternalSimpleAntlr.g:1400:1: (lv_options_0_0= ruleOptions )
                    {
                    // InternalSimpleAntlr.g:1400:1: (lv_options_0_0= ruleOptions )
                    // InternalSimpleAntlr.g:1401:3: lv_options_0_0= ruleOptions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleOptionsAccess().getOptionsOptionsParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_options_0_0=ruleOptions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleOptionsRule());
                      	        }
                             		set(
                             			current, 
                             			"options",
                              		lv_options_0_0, 
                              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Options");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,23,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getRuleOptionsAccess().getColonKeyword_0_1());
                          
                    }
                    // InternalSimpleAntlr.g:1421:1: ( (lv_element_2_0= ruleAtom ) )
                    // InternalSimpleAntlr.g:1422:1: (lv_element_2_0= ruleAtom )
                    {
                    // InternalSimpleAntlr.g:1422:1: (lv_element_2_0= ruleAtom )
                    // InternalSimpleAntlr.g:1423:3: lv_element_2_0= ruleAtom
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleOptionsAccess().getElementAtomParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_element_2_0=ruleAtom();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleOptionsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_2_0, 
                              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.Atom");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:1440:6: ( () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}' )
                    {
                    // InternalSimpleAntlr.g:1440:6: ( () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}' )
                    // InternalSimpleAntlr.g:1440:7: () otherlv_4= '{' otherlv_5= 'skip();' otherlv_6= '}'
                    {
                    // InternalSimpleAntlr.g:1440:7: ()
                    // InternalSimpleAntlr.g:1441:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getRuleOptionsAccess().getSkipAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,16,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRuleOptionsAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }
                    otherlv_5=(Token)match(input,35,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRuleOptionsAccess().getSkipKeyword_1_2());
                          
                    }
                    otherlv_6=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleOptionsAccess().getRightCurlyBracketKeyword_1_3());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRuleOptions"


    // $ANTLR start "entryRuleLiteral"
    // InternalSimpleAntlr.g:1469:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalSimpleAntlr.g:1470:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalSimpleAntlr.g:1471:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:1478:1: ruleLiteral returns [EObject current=null] : (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RuleCall_0 = null;

        EObject this_Keyword_1 = null;

        EObject this_Wildcard_2 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1481:28: ( (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard ) )
            // InternalSimpleAntlr.g:1482:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            {
            // InternalSimpleAntlr.g:1482:1: (this_RuleCall_0= ruleRuleCall | this_Keyword_1= ruleKeyword | this_Wildcard_2= ruleWildcard )
            int alt24=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt24=1;
                }
                break;
            case RULE_STRING:
                {
                alt24=2;
                }
                break;
            case 36:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalSimpleAntlr.g:1483:2: this_RuleCall_0= ruleRuleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getRuleCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RuleCall_0=ruleRuleCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RuleCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleAntlr.g:1496:2: this_Keyword_1= ruleKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getKeywordParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Keyword_1=ruleKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Keyword_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleAntlr.g:1509:2: this_Wildcard_2= ruleWildcard
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getWildcardParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Wildcard_2=ruleWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Wildcard_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleRuleCall"
    // InternalSimpleAntlr.g:1528:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // InternalSimpleAntlr.g:1529:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // InternalSimpleAntlr.g:1530:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:1537:1: ruleRuleCall returns [EObject current=null] : ( ( (lv_rule_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']' )? ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_rule_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1540:28: ( ( ( (lv_rule_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']' )? ) )
            // InternalSimpleAntlr.g:1541:1: ( ( (lv_rule_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']' )? )
            {
            // InternalSimpleAntlr.g:1541:1: ( ( (lv_rule_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']' )? )
            // InternalSimpleAntlr.g:1541:2: ( (lv_rule_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']' )?
            {
            // InternalSimpleAntlr.g:1541:2: ( (lv_rule_0_0= RULE_ID ) )
            // InternalSimpleAntlr.g:1542:1: (lv_rule_0_0= RULE_ID )
            {
            // InternalSimpleAntlr.g:1542:1: (lv_rule_0_0= RULE_ID )
            // InternalSimpleAntlr.g:1543:3: lv_rule_0_0= RULE_ID
            {
            lv_rule_0_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_rule_0_0, grammarAccess.getRuleCallAccess().getRuleIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRuleCallRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"rule",
                      		lv_rule_0_0, 
                      		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.ID");
              	    
            }

            }


            }

            // InternalSimpleAntlr.g:1559:2: (otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSimpleAntlr.g:1559:4: otherlv_1= '[' ( (lv_arguments_2_0= ruleOrExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getRuleCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // InternalSimpleAntlr.g:1563:1: ( (lv_arguments_2_0= ruleOrExpression ) )
                    // InternalSimpleAntlr.g:1564:1: (lv_arguments_2_0= ruleOrExpression )
                    {
                    // InternalSimpleAntlr.g:1564:1: (lv_arguments_2_0= ruleOrExpression )
                    // InternalSimpleAntlr.g:1565:3: lv_arguments_2_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleCallAccess().getArgumentsOrExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_12);
                    lv_arguments_2_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.OrExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSimpleAntlr.g:1581:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==21) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalSimpleAntlr.g:1581:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleOrExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalSimpleAntlr.g:1585:1: ( (lv_arguments_4_0= ruleOrExpression ) )
                    	    // InternalSimpleAntlr.g:1586:1: (lv_arguments_4_0= ruleOrExpression )
                    	    {
                    	    // InternalSimpleAntlr.g:1586:1: (lv_arguments_4_0= ruleOrExpression )
                    	    // InternalSimpleAntlr.g:1587:3: lv_arguments_4_0= ruleOrExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleCallAccess().getArgumentsOrExpressionParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    lv_arguments_4_0=ruleOrExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRuleCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"org.eclipse.xtext.generator.parser.antlr.debug.SimpleAntlr.OrExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRuleCallAccess().getRightSquareBracketKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleQName"
    // InternalSimpleAntlr.g:1615:1: entryRuleQName returns [String current=null] : iv_ruleQName= ruleQName EOF ;
    public final String entryRuleQName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQName = null;


        try {
            // InternalSimpleAntlr.g:1616:2: (iv_ruleQName= ruleQName EOF )
            // InternalSimpleAntlr.g:1617:2: iv_ruleQName= ruleQName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQName=ruleQName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQName"


    // $ANTLR start "ruleQName"
    // InternalSimpleAntlr.g:1624:1: ruleQName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1627:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // InternalSimpleAntlr.g:1628:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // InternalSimpleAntlr.g:1628:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // InternalSimpleAntlr.g:1628:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalSimpleAntlr.g:1635:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==36) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSimpleAntlr.g:1636:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,36,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQNameAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getQNameAccess().getIDTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQName"


    // $ANTLR start "entryRuleKeyword"
    // InternalSimpleAntlr.g:1656:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // InternalSimpleAntlr.g:1657:2: (iv_ruleKeyword= ruleKeyword EOF )
            // InternalSimpleAntlr.g:1658:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:1665:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1668:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSimpleAntlr.g:1669:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSimpleAntlr.g:1669:1: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSimpleAntlr.g:1670:1: (lv_value_0_0= RULE_STRING )
            {
            // InternalSimpleAntlr.g:1670:1: (lv_value_0_0= RULE_STRING )
            // InternalSimpleAntlr.g:1671:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getKeywordRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleWildcard"
    // InternalSimpleAntlr.g:1695:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // InternalSimpleAntlr.g:1696:2: (iv_ruleWildcard= ruleWildcard EOF )
            // InternalSimpleAntlr.g:1697:2: iv_ruleWildcard= ruleWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcard; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalSimpleAntlr.g:1704:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalSimpleAntlr.g:1707:28: ( ( () otherlv_1= '.' ) )
            // InternalSimpleAntlr.g:1708:1: ( () otherlv_1= '.' )
            {
            // InternalSimpleAntlr.g:1708:1: ( () otherlv_1= '.' )
            // InternalSimpleAntlr.g:1708:2: () otherlv_1= '.'
            {
            // InternalSimpleAntlr.g:1708:2: ()
            // InternalSimpleAntlr.g:1709:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWildcardAccess().getWildcardAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleWildcard"

    // $ANTLR start synpred19_InternalSimpleAntlr
    public final void synpred19_InternalSimpleAntlr_fragment() throws RecognitionException {   
        EObject this_Predicated_3 = null;


        // InternalSimpleAntlr.g:800:2: (this_Predicated_3= rulePredicated )
        // InternalSimpleAntlr.g:800:2: this_Predicated_3= rulePredicated
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_2);
        this_Predicated_3=rulePredicated();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalSimpleAntlr

    // $ANTLR start synpred20_InternalSimpleAntlr
    public final void synpred20_InternalSimpleAntlr_fragment() throws RecognitionException {   
        EObject this_Parenthesized_4 = null;


        // InternalSimpleAntlr.g:813:2: (this_Parenthesized_4= ruleParenthesized )
        // InternalSimpleAntlr.g:813:2: this_Parenthesized_4= ruleParenthesized
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_2);
        this_Parenthesized_4=ruleParenthesized();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalSimpleAntlr

    // Delegated rules

    public final boolean synpred20_InternalSimpleAntlr() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalSimpleAntlr_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalSimpleAntlr() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalSimpleAntlr_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000088012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000010100180D0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000010100180D2L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000E000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000010100000D0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200000050L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000002L});

}
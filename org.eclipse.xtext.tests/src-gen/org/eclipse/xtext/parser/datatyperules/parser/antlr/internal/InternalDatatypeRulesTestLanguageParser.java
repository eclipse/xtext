package org.eclipse.xtext.parser.datatyperules.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDatatypeRulesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'#'", "'+'", "'*'", "';'", "'.'", "'/'", "'('", "')'", "'..'", "'-'", "'E'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalDatatypeRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDatatypeRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDatatypeRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDatatypeRulesTestLanguage.g"; }



     	private DatatypeRulesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDatatypeRulesTestLanguageParser(TokenStream input, DatatypeRulesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CompositeModel";	
       	}
       	
       	@Override
       	protected DatatypeRulesTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleCompositeModel"
    // InternalDatatypeRulesTestLanguage.g:67:1: entryRuleCompositeModel returns [EObject current=null] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final EObject entryRuleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeModel = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:68:2: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // InternalDatatypeRulesTestLanguage.g:69:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             newCompositeNode(grammarAccess.getCompositeModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCompositeModel=ruleCompositeModel();

            state._fsp--;

             current =iv_ruleCompositeModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleCompositeModel"


    // $ANTLR start "ruleCompositeModel"
    // InternalDatatypeRulesTestLanguage.g:76:1: ruleCompositeModel returns [EObject current=null] : ( (lv_model_0_0= ruleModel ) )+ ;
    public final EObject ruleCompositeModel() throws RecognitionException {
        EObject current = null;

        EObject lv_model_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:79:28: ( ( (lv_model_0_0= ruleModel ) )+ )
            // InternalDatatypeRulesTestLanguage.g:80:1: ( (lv_model_0_0= ruleModel ) )+
            {
            // InternalDatatypeRulesTestLanguage.g:80:1: ( (lv_model_0_0= ruleModel ) )+
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
            	    // InternalDatatypeRulesTestLanguage.g:81:1: (lv_model_0_0= ruleModel )
            	    {
            	    // InternalDatatypeRulesTestLanguage.g:81:1: (lv_model_0_0= ruleModel )
            	    // InternalDatatypeRulesTestLanguage.g:82:3: lv_model_0_0= ruleModel
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositeModelAccess().getModelModelParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_model_0_0=ruleModel();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompositeModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"model",
            	            		lv_model_0_0, 
            	            		"org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage.Model");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleCompositeModel"


    // $ANTLR start "entryRuleModel"
    // InternalDatatypeRulesTestLanguage.g:106:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:107:2: (iv_ruleModel= ruleModel EOF )
            // InternalDatatypeRulesTestLanguage.g:108:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalDatatypeRulesTestLanguage.g:115:1: ruleModel returns [EObject current=null] : ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_vector_4_0 = null;

        AntlrDatatypeRuleToken lv_dots_6_0 = null;

        AntlrDatatypeRuleToken lv_double_8_0 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:118:28: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) )
            // InternalDatatypeRulesTestLanguage.g:119:1: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            {
            // InternalDatatypeRulesTestLanguage.g:119:1: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            // InternalDatatypeRulesTestLanguage.g:119:2: ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';'
            {
            // InternalDatatypeRulesTestLanguage.g:119:2: ( (lv_id_0_0= ruleNestedModelId ) )
            // InternalDatatypeRulesTestLanguage.g:120:1: (lv_id_0_0= ruleNestedModelId )
            {
            // InternalDatatypeRulesTestLanguage.g:120:1: (lv_id_0_0= ruleNestedModelId )
            // InternalDatatypeRulesTestLanguage.g:121:3: lv_id_0_0= ruleNestedModelId
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getIdNestedModelIdParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_id_0_0=ruleNestedModelId();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage.NestedModelId");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDatatypeRulesTestLanguage.g:137:2: (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:137:4: otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getColonKeyword_1_0());
                        
                    // InternalDatatypeRulesTestLanguage.g:141:1: ( (lv_value_2_0= ruleFraction ) )
                    // InternalDatatypeRulesTestLanguage.g:142:1: (lv_value_2_0= ruleFraction )
                    {
                    // InternalDatatypeRulesTestLanguage.g:142:1: (lv_value_2_0= ruleFraction )
                    // InternalDatatypeRulesTestLanguage.g:143:3: lv_value_2_0= ruleFraction
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getValueFractionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_value_2_0=ruleFraction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_2_0, 
                            		"org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage.Fraction");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalDatatypeRulesTestLanguage.g:159:4: (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:159:6: otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_3, grammarAccess.getModelAccess().getNumberSignKeyword_2_0());
                        
                    // InternalDatatypeRulesTestLanguage.g:163:1: ( (lv_vector_4_0= ruleVector ) )
                    // InternalDatatypeRulesTestLanguage.g:164:1: (lv_vector_4_0= ruleVector )
                    {
                    // InternalDatatypeRulesTestLanguage.g:164:1: (lv_vector_4_0= ruleVector )
                    // InternalDatatypeRulesTestLanguage.g:165:3: lv_vector_4_0= ruleVector
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getVectorVectorParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_vector_4_0=ruleVector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"vector",
                            		lv_vector_4_0, 
                            		"org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage.Vector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalDatatypeRulesTestLanguage.g:181:4: (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:181:6: otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) )
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getPlusSignKeyword_3_0());
                        
                    // InternalDatatypeRulesTestLanguage.g:185:1: ( (lv_dots_6_0= ruleDots ) )
                    // InternalDatatypeRulesTestLanguage.g:186:1: (lv_dots_6_0= ruleDots )
                    {
                    // InternalDatatypeRulesTestLanguage.g:186:1: (lv_dots_6_0= ruleDots )
                    // InternalDatatypeRulesTestLanguage.g:187:3: lv_dots_6_0= ruleDots
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getDotsDotsParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_dots_6_0=ruleDots();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"dots",
                            		lv_dots_6_0, 
                            		"org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage.Dots");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalDatatypeRulesTestLanguage.g:203:4: (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:203:6: otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_11); 

                        	newLeafNode(otherlv_7, grammarAccess.getModelAccess().getAsteriskKeyword_4_0());
                        
                    // InternalDatatypeRulesTestLanguage.g:207:1: ( (lv_double_8_0= ruleDouble ) )
                    // InternalDatatypeRulesTestLanguage.g:208:1: (lv_double_8_0= ruleDouble )
                    {
                    // InternalDatatypeRulesTestLanguage.g:208:1: (lv_double_8_0= ruleDouble )
                    // InternalDatatypeRulesTestLanguage.g:209:3: lv_double_8_0= ruleDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getDoubleDoubleParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_double_8_0=ruleDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"double",
                            		lv_double_8_0, 
                            		"org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage.Double");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getModelAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelId"
    // InternalDatatypeRulesTestLanguage.g:237:1: entryRuleModelId returns [String current=null] : iv_ruleModelId= ruleModelId EOF ;
    public final String entryRuleModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelId = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:238:2: (iv_ruleModelId= ruleModelId EOF )
            // InternalDatatypeRulesTestLanguage.g:239:2: iv_ruleModelId= ruleModelId EOF
            {
             newCompositeNode(grammarAccess.getModelIdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModelId=ruleModelId();

            state._fsp--;

             current =iv_ruleModelId.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleModelId"


    // $ANTLR start "ruleModelId"
    // InternalDatatypeRulesTestLanguage.g:246:1: ruleModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:249:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // InternalDatatypeRulesTestLanguage.g:250:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // InternalDatatypeRulesTestLanguage.g:250:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // InternalDatatypeRulesTestLanguage.g:250:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getModelIdAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,16,FollowSets000.FOLLOW_14); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModelIdAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getModelIdAccess().getIDTerminalRuleCall_2()); 
                

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
    // $ANTLR end "ruleModelId"


    // $ANTLR start "entryRuleNestedModelId"
    // InternalDatatypeRulesTestLanguage.g:278:1: entryRuleNestedModelId returns [String current=null] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final String entryRuleNestedModelId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedModelId = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:279:2: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // InternalDatatypeRulesTestLanguage.g:280:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             newCompositeNode(grammarAccess.getNestedModelIdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedModelId=ruleNestedModelId();

            state._fsp--;

             current =iv_ruleNestedModelId.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNestedModelId"


    // $ANTLR start "ruleNestedModelId"
    // InternalDatatypeRulesTestLanguage.g:287:1: ruleNestedModelId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) ;
    public final AntlrDatatypeRuleToken ruleNestedModelId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ModelId_0 = null;

        AntlrDatatypeRuleToken this_ModelId_2 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:290:28: ( (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId ) )
            // InternalDatatypeRulesTestLanguage.g:291:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            {
            // InternalDatatypeRulesTestLanguage.g:291:1: (this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId )
            // InternalDatatypeRulesTestLanguage.g:292:5: this_ModelId_0= ruleModelId kw= '.' this_ModelId_2= ruleModelId
            {
             
                    newCompositeNode(grammarAccess.getNestedModelIdAccess().getModelIdParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_13);
            this_ModelId_0=ruleModelId();

            state._fsp--;


            		current.merge(this_ModelId_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,16,FollowSets000.FOLLOW_14); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNestedModelIdAccess().getFullStopKeyword_1()); 
                
             
                    newCompositeNode(grammarAccess.getNestedModelIdAccess().getModelIdParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_ModelId_2=ruleModelId();

            state._fsp--;


            		current.merge(this_ModelId_2);
                
             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleNestedModelId"


    // $ANTLR start "entryRuleFraction"
    // InternalDatatypeRulesTestLanguage.g:327:1: entryRuleFraction returns [String current=null] : iv_ruleFraction= ruleFraction EOF ;
    public final String entryRuleFraction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFraction = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:328:2: (iv_ruleFraction= ruleFraction EOF )
            // InternalDatatypeRulesTestLanguage.g:329:2: iv_ruleFraction= ruleFraction EOF
            {
             newCompositeNode(grammarAccess.getFractionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFraction=ruleFraction();

            state._fsp--;

             current =iv_ruleFraction.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleFraction"


    // $ANTLR start "ruleFraction"
    // InternalDatatypeRulesTestLanguage.g:336:1: ruleFraction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFraction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:339:28: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // InternalDatatypeRulesTestLanguage.g:340:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // InternalDatatypeRulesTestLanguage.g:340:1: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // InternalDatatypeRulesTestLanguage.g:340:6: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getFractionAccess().getINTTerminalRuleCall_0()); 
                
            // InternalDatatypeRulesTestLanguage.g:347:1: (kw= '/' this_INT_2= RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:348:2: kw= '/' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFractionAccess().getSolidusKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getFractionAccess().getINTTerminalRuleCall_1_1()); 
                        

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
    // $ANTLR end "ruleFraction"


    // $ANTLR start "entryRuleVector"
    // InternalDatatypeRulesTestLanguage.g:368:1: entryRuleVector returns [String current=null] : iv_ruleVector= ruleVector EOF ;
    public final String entryRuleVector() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVector = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:369:2: (iv_ruleVector= ruleVector EOF )
            // InternalDatatypeRulesTestLanguage.g:370:2: iv_ruleVector= ruleVector EOF
            {
             newCompositeNode(grammarAccess.getVectorRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVector=ruleVector();

            state._fsp--;

             current =iv_ruleVector.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // InternalDatatypeRulesTestLanguage.g:377:1: ruleVector returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleVector() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:380:28: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // InternalDatatypeRulesTestLanguage.g:381:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // InternalDatatypeRulesTestLanguage.g:381:1: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // InternalDatatypeRulesTestLanguage.g:382:2: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {
            kw=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getVectorAccess().getLeftParenthesisKeyword_0()); 
                
            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getVectorAccess().getINTTerminalRuleCall_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_16); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getVectorAccess().getINTTerminalRuleCall_2()); 
                
            kw=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getVectorAccess().getRightParenthesisKeyword_3()); 
                

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
    // $ANTLR end "ruleVector"


    // $ANTLR start "entryRuleDots"
    // InternalDatatypeRulesTestLanguage.g:415:1: entryRuleDots returns [String current=null] : iv_ruleDots= ruleDots EOF ;
    public final String entryRuleDots() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDots = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:416:2: (iv_ruleDots= ruleDots EOF )
            // InternalDatatypeRulesTestLanguage.g:417:2: iv_ruleDots= ruleDots EOF
            {
             newCompositeNode(grammarAccess.getDotsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDots=ruleDots();

            state._fsp--;

             current =iv_ruleDots.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDots"


    // $ANTLR start "ruleDots"
    // InternalDatatypeRulesTestLanguage.g:424:1: ruleDots returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleDots() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:427:28: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // InternalDatatypeRulesTestLanguage.g:428:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // InternalDatatypeRulesTestLanguage.g:428:1: ( (kw= '.' kw= '.' ) | kw= '..' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:428:2: (kw= '.' kw= '.' )
                    {
                    // InternalDatatypeRulesTestLanguage.g:428:2: (kw= '.' kw= '.' )
                    // InternalDatatypeRulesTestLanguage.g:429:2: kw= '.' kw= '.'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_13); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotsAccess().getFullStopKeyword_0_0()); 
                        
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotsAccess().getFullStopKeyword_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypeRulesTestLanguage.g:442:2: kw= '..'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotsAccess().getFullStopFullStopKeyword_1()); 
                        

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
    // $ANTLR end "ruleDots"


    // $ANTLR start "entryRuleDouble"
    // InternalDatatypeRulesTestLanguage.g:455:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // InternalDatatypeRulesTestLanguage.g:456:2: (iv_ruleDouble= ruleDouble EOF )
            // InternalDatatypeRulesTestLanguage.g:457:2: iv_ruleDouble= ruleDouble EOF
            {
             newCompositeNode(grammarAccess.getDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // InternalDatatypeRulesTestLanguage.g:464:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // InternalDatatypeRulesTestLanguage.g:467:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) )
            // InternalDatatypeRulesTestLanguage.g:468:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            {
            // InternalDatatypeRulesTestLanguage.g:468:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            // InternalDatatypeRulesTestLanguage.g:468:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            {
            // InternalDatatypeRulesTestLanguage.g:468:2: (kw= '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:469:2: kw= '-'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_17); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // InternalDatatypeRulesTestLanguage.g:474:3: (this_INT_1= RULE_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:474:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_13); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_18); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // InternalDatatypeRulesTestLanguage.g:494:1: (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDatatypeRulesTestLanguage.g:495:2: kw= 'E' (kw= '-' )? this_INT_6= RULE_INT
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_19); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDoubleAccess().getEKeyword_4_0()); 
                        
                    // InternalDatatypeRulesTestLanguage.g:500:1: (kw= '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalDatatypeRulesTestLanguage.g:501:2: kw= '-'
                            {
                            kw=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    		current.merge(this_INT_6);
                        
                     
                        newLeafNode(this_INT_6, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_4_2()); 
                        

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
    // $ANTLR end "ruleDouble"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000F800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000210020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200020L});
    }


}
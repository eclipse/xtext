package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssignmentsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'simple'", "'complex'", "'id'", "'alternative'", "'string'", "'ids'", "'alternatives'", "'strings'", "'datatypeid'", "'datatypealternative'", "'datatypestring'", "'datatypeids'", "'datatypealternatives'", "'datatypestrings'"
    };
    public static final int RULE_STRING=5;
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
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalAssignmentsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAssignmentsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAssignmentsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAssignmentsTestLanguage.g"; }



     	private AssignmentsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAssignmentsTestLanguageParser(TokenStream input, AssignmentsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected AssignmentsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalAssignmentsTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAssignmentsTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalAssignmentsTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalAssignmentsTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_5=null;
        EObject lv_single_1_0 = null;

        EObject lv_multi_2_0 = null;

        EObject lv_single_3_0 = null;

        EObject lv_multi_4_0 = null;

        EObject lv_object_6_1 = null;

        EObject lv_object_6_2 = null;

        EObject lv_object_6_3 = null;

        EObject lv_object_6_4 = null;


         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:79:28: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // InternalAssignmentsTestLanguage.g:80:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // InternalAssignmentsTestLanguage.g:80:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssignmentsTestLanguage.g:80:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:80:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // InternalAssignmentsTestLanguage.g:80:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getSimpleKeyword_0_0());
                        
                    // InternalAssignmentsTestLanguage.g:84:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    int alt1=4;
                    switch ( input.LA(1) ) {
                    case 13:
                    case 14:
                    case 15:
                        {
                        alt1=1;
                        }
                        break;
                    case 16:
                    case 17:
                    case 18:
                        {
                        alt1=2;
                        }
                        break;
                    case 19:
                    case 20:
                    case 21:
                        {
                        alt1=3;
                        }
                        break;
                    case 22:
                    case 23:
                    case 24:
                        {
                        alt1=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }

                    switch (alt1) {
                        case 1 :
                            // InternalAssignmentsTestLanguage.g:84:2: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // InternalAssignmentsTestLanguage.g:84:2: ( (lv_single_1_0= ruleSingleValue ) )
                            // InternalAssignmentsTestLanguage.g:85:1: (lv_single_1_0= ruleSingleValue )
                            {
                            // InternalAssignmentsTestLanguage.g:85:1: (lv_single_1_0= ruleSingleValue )
                            // InternalAssignmentsTestLanguage.g:86:3: lv_single_1_0= ruleSingleValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getSingleSingleValueParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_single_1_0=ruleSingleValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"single",
                                    		lv_single_1_0, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.SingleValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssignmentsTestLanguage.g:103:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // InternalAssignmentsTestLanguage.g:103:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            // InternalAssignmentsTestLanguage.g:104:1: (lv_multi_2_0= ruleMultiValue )
                            {
                            // InternalAssignmentsTestLanguage.g:104:1: (lv_multi_2_0= ruleMultiValue )
                            // InternalAssignmentsTestLanguage.g:105:3: lv_multi_2_0= ruleMultiValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getMultiMultiValueParserRuleCall_0_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_multi_2_0=ruleMultiValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"multi",
                                    		lv_multi_2_0, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.MultiValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalAssignmentsTestLanguage.g:122:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // InternalAssignmentsTestLanguage.g:122:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // InternalAssignmentsTestLanguage.g:123:1: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // InternalAssignmentsTestLanguage.g:123:1: (lv_single_3_0= ruleSingleDatatype )
                            // InternalAssignmentsTestLanguage.g:124:3: lv_single_3_0= ruleSingleDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getSingleSingleDatatypeParserRuleCall_0_1_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_single_3_0=ruleSingleDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"single",
                                    		lv_single_3_0, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.SingleDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalAssignmentsTestLanguage.g:141:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // InternalAssignmentsTestLanguage.g:141:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // InternalAssignmentsTestLanguage.g:142:1: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // InternalAssignmentsTestLanguage.g:142:1: (lv_multi_4_0= ruleMultiDatatype )
                            // InternalAssignmentsTestLanguage.g:143:3: lv_multi_4_0= ruleMultiDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getMultiMultiDatatypeParserRuleCall_0_1_3_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_multi_4_0=ruleMultiDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"multi",
                                    		lv_multi_4_0, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.MultiDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentsTestLanguage.g:160:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:160:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // InternalAssignmentsTestLanguage.g:160:8: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getComplexKeyword_1_0());
                        
                    // InternalAssignmentsTestLanguage.g:164:1: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:165:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // InternalAssignmentsTestLanguage.g:165:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // InternalAssignmentsTestLanguage.g:166:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:166:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    int alt2=4;
                    switch ( input.LA(1) ) {
                    case 13:
                    case 14:
                    case 15:
                        {
                        alt2=1;
                        }
                        break;
                    case 16:
                    case 17:
                    case 18:
                        {
                        alt2=2;
                        }
                        break;
                    case 19:
                    case 20:
                    case 21:
                        {
                        alt2=3;
                        }
                        break;
                    case 22:
                    case 23:
                    case 24:
                        {
                        alt2=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // InternalAssignmentsTestLanguage.g:167:3: lv_object_6_1= ruleSingleValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectSingleValueParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_1=ruleSingleValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"object",
                                    		lv_object_6_1, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.SingleValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalAssignmentsTestLanguage.g:182:8: lv_object_6_2= ruleMultiValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectMultiValueParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_2=ruleMultiValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"object",
                                    		lv_object_6_2, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.MultiValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 3 :
                            // InternalAssignmentsTestLanguage.g:197:8: lv_object_6_3= ruleSingleDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectSingleDatatypeParserRuleCall_1_1_0_2()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_3=ruleSingleDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"object",
                                    		lv_object_6_3, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.SingleDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 4 :
                            // InternalAssignmentsTestLanguage.g:212:8: lv_object_6_4= ruleMultiDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectMultiDatatypeParserRuleCall_1_1_0_3()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_4=ruleMultiDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"object",
                                    		lv_object_6_4, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.MultiDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSingleValue"
    // InternalAssignmentsTestLanguage.g:238:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // InternalAssignmentsTestLanguage.g:239:2: (iv_ruleSingleValue= ruleSingleValue EOF )
            // InternalAssignmentsTestLanguage.g:240:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             newCompositeNode(grammarAccess.getSingleValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleValue=ruleSingleValue();

            state._fsp--;

             current =iv_ruleSingleValue; 
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
    // $ANTLR end "entryRuleSingleValue"


    // $ANTLR start "ruleSingleValue"
    // InternalAssignmentsTestLanguage.g:247:1: ruleSingleValue returns [EObject current=null] : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:250:28: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // InternalAssignmentsTestLanguage.g:251:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // InternalAssignmentsTestLanguage.g:251:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case 15:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalAssignmentsTestLanguage.g:251:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:251:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // InternalAssignmentsTestLanguage.g:251:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_0, grammarAccess.getSingleValueAccess().getIdKeyword_0_0());
                        
                    // InternalAssignmentsTestLanguage.g:255:1: ( (lv_value_1_0= RULE_ID ) )
                    // InternalAssignmentsTestLanguage.g:256:1: (lv_value_1_0= RULE_ID )
                    {
                    // InternalAssignmentsTestLanguage.g:256:1: (lv_value_1_0= RULE_ID )
                    // InternalAssignmentsTestLanguage.g:257:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_value_1_0, grammarAccess.getSingleValueAccess().getValueIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentsTestLanguage.g:274:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:274:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // InternalAssignmentsTestLanguage.g:274:8: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleValueAccess().getAlternativeKeyword_1_0());
                        
                    // InternalAssignmentsTestLanguage.g:278:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // InternalAssignmentsTestLanguage.g:279:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // InternalAssignmentsTestLanguage.g:279:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // InternalAssignmentsTestLanguage.g:280:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // InternalAssignmentsTestLanguage.g:280:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_STRING) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalAssignmentsTestLanguage.g:281:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            			newLeafNode(lv_value_3_1, grammarAccess.getSingleValueAccess().getValueIDTerminalRuleCall_1_1_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSingleValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_3_1, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }
                            break;
                        case 2 :
                            // InternalAssignmentsTestLanguage.g:296:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            			newLeafNode(lv_value_3_2, grammarAccess.getSingleValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSingleValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_3_2, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentsTestLanguage.g:315:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:315:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // InternalAssignmentsTestLanguage.g:315:8: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleValueAccess().getStringKeyword_2_0());
                        
                    // InternalAssignmentsTestLanguage.g:319:1: ( (lv_value_5_0= RULE_STRING ) )
                    // InternalAssignmentsTestLanguage.g:320:1: (lv_value_5_0= RULE_STRING )
                    {
                    // InternalAssignmentsTestLanguage.g:320:1: (lv_value_5_0= RULE_STRING )
                    // InternalAssignmentsTestLanguage.g:321:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_value_5_0, grammarAccess.getSingleValueAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


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
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleMultiValue"
    // InternalAssignmentsTestLanguage.g:345:1: entryRuleMultiValue returns [EObject current=null] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final EObject entryRuleMultiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiValue = null;


        try {
            // InternalAssignmentsTestLanguage.g:346:2: (iv_ruleMultiValue= ruleMultiValue EOF )
            // InternalAssignmentsTestLanguage.g:347:2: iv_ruleMultiValue= ruleMultiValue EOF
            {
             newCompositeNode(grammarAccess.getMultiValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiValue=ruleMultiValue();

            state._fsp--;

             current =iv_ruleMultiValue; 
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
    // $ANTLR end "entryRuleMultiValue"


    // $ANTLR start "ruleMultiValue"
    // InternalAssignmentsTestLanguage.g:354:1: ruleMultiValue returns [EObject current=null] : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleMultiValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:357:28: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // InternalAssignmentsTestLanguage.g:358:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // InternalAssignmentsTestLanguage.g:358:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 18:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalAssignmentsTestLanguage.g:358:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:358:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // InternalAssignmentsTestLanguage.g:358:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_0, grammarAccess.getMultiValueAccess().getIdsKeyword_0_0());
                        
                    // InternalAssignmentsTestLanguage.g:362:1: ( (lv_value_1_0= RULE_ID ) )
                    // InternalAssignmentsTestLanguage.g:363:1: (lv_value_1_0= RULE_ID )
                    {
                    // InternalAssignmentsTestLanguage.g:363:1: (lv_value_1_0= RULE_ID )
                    // InternalAssignmentsTestLanguage.g:364:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_value_1_0, grammarAccess.getMultiValueAccess().getValueIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiValueRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentsTestLanguage.g:381:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:381:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // InternalAssignmentsTestLanguage.g:381:8: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiValueAccess().getAlternativesKeyword_1_0());
                        
                    // InternalAssignmentsTestLanguage.g:385:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // InternalAssignmentsTestLanguage.g:386:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // InternalAssignmentsTestLanguage.g:386:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // InternalAssignmentsTestLanguage.g:387:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // InternalAssignmentsTestLanguage.g:387:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==RULE_STRING) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalAssignmentsTestLanguage.g:388:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            			newLeafNode(lv_value_3_1, grammarAccess.getMultiValueAccess().getValueIDTerminalRuleCall_1_1_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getMultiValueRule());
                            	        }
                                   		addWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_3_1, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }
                            break;
                        case 2 :
                            // InternalAssignmentsTestLanguage.g:403:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            			newLeafNode(lv_value_3_2, grammarAccess.getMultiValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getMultiValueRule());
                            	        }
                                   		addWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_3_2, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentsTestLanguage.g:422:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:422:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // InternalAssignmentsTestLanguage.g:422:8: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultiValueAccess().getStringsKeyword_2_0());
                        
                    // InternalAssignmentsTestLanguage.g:426:1: ( (lv_value_5_0= RULE_STRING ) )
                    // InternalAssignmentsTestLanguage.g:427:1: (lv_value_5_0= RULE_STRING )
                    {
                    // InternalAssignmentsTestLanguage.g:427:1: (lv_value_5_0= RULE_STRING )
                    // InternalAssignmentsTestLanguage.g:428:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_value_5_0, grammarAccess.getMultiValueAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiValueRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


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
    // $ANTLR end "ruleMultiValue"


    // $ANTLR start "entryRuleSingleDatatype"
    // InternalAssignmentsTestLanguage.g:452:1: entryRuleSingleDatatype returns [EObject current=null] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final EObject entryRuleSingleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleDatatype = null;


        try {
            // InternalAssignmentsTestLanguage.g:453:2: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // InternalAssignmentsTestLanguage.g:454:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
            {
             newCompositeNode(grammarAccess.getSingleDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleDatatype=ruleSingleDatatype();

            state._fsp--;

             current =iv_ruleSingleDatatype; 
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
    // $ANTLR end "entryRuleSingleDatatype"


    // $ANTLR start "ruleSingleDatatype"
    // InternalAssignmentsTestLanguage.g:461:1: ruleSingleDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleSingleDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:464:28: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // InternalAssignmentsTestLanguage.g:465:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // InternalAssignmentsTestLanguage.g:465:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // InternalAssignmentsTestLanguage.g:465:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:465:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:465:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_0, grammarAccess.getSingleDatatypeAccess().getDatatypeidKeyword_0_0());
                        
                    // InternalAssignmentsTestLanguage.g:469:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // InternalAssignmentsTestLanguage.g:470:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:470:1: (lv_value_1_0= ruleIdDatatype )
                    // InternalAssignmentsTestLanguage.g:471:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_1_0=ruleIdDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleDatatypeRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.IdDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentsTestLanguage.g:488:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:488:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // InternalAssignmentsTestLanguage.g:488:8: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0());
                        
                    // InternalAssignmentsTestLanguage.g:492:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:493:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // InternalAssignmentsTestLanguage.g:493:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // InternalAssignmentsTestLanguage.g:494:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:494:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_STRING) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalAssignmentsTestLanguage.g:495:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_1=ruleIdDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSingleDatatypeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_3_1, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.IdDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalAssignmentsTestLanguage.g:510:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_2=ruleStringDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSingleDatatypeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_3_2, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.StringDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentsTestLanguage.g:529:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:529:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:529:8: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleDatatypeAccess().getDatatypestringKeyword_2_0());
                        
                    // InternalAssignmentsTestLanguage.g:533:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // InternalAssignmentsTestLanguage.g:534:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:534:1: (lv_value_5_0= ruleStringDatatype )
                    // InternalAssignmentsTestLanguage.g:535:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_5_0=ruleStringDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleDatatypeRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.StringDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleSingleDatatype"


    // $ANTLR start "entryRuleMultiDatatype"
    // InternalAssignmentsTestLanguage.g:559:1: entryRuleMultiDatatype returns [EObject current=null] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final EObject entryRuleMultiDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDatatype = null;


        try {
            // InternalAssignmentsTestLanguage.g:560:2: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // InternalAssignmentsTestLanguage.g:561:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
            {
             newCompositeNode(grammarAccess.getMultiDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiDatatype=ruleMultiDatatype();

            state._fsp--;

             current =iv_ruleMultiDatatype; 
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
    // $ANTLR end "entryRuleMultiDatatype"


    // $ANTLR start "ruleMultiDatatype"
    // InternalAssignmentsTestLanguage.g:568:1: ruleMultiDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleMultiDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:571:28: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // InternalAssignmentsTestLanguage.g:572:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // InternalAssignmentsTestLanguage.g:572:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt11=1;
                }
                break;
            case 23:
                {
                alt11=2;
                }
                break;
            case 24:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalAssignmentsTestLanguage.g:572:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:572:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:572:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_0, grammarAccess.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0());
                        
                    // InternalAssignmentsTestLanguage.g:576:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // InternalAssignmentsTestLanguage.g:577:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:577:1: (lv_value_1_0= ruleIdDatatype )
                    // InternalAssignmentsTestLanguage.g:578:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_1_0=ruleIdDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMultiDatatypeRule());
                    	        }
                           		add(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.IdDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentsTestLanguage.g:595:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:595:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // InternalAssignmentsTestLanguage.g:595:8: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0());
                        
                    // InternalAssignmentsTestLanguage.g:599:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:600:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // InternalAssignmentsTestLanguage.g:600:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // InternalAssignmentsTestLanguage.g:601:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:601:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RULE_STRING) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalAssignmentsTestLanguage.g:602:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_1=ruleIdDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMultiDatatypeRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"value",
                                    		lv_value_3_1, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.IdDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalAssignmentsTestLanguage.g:617:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_2=ruleStringDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMultiDatatypeRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"value",
                                    		lv_value_3_2, 
                                    		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.StringDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentsTestLanguage.g:636:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // InternalAssignmentsTestLanguage.g:636:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // InternalAssignmentsTestLanguage.g:636:8: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0());
                        
                    // InternalAssignmentsTestLanguage.g:640:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // InternalAssignmentsTestLanguage.g:641:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // InternalAssignmentsTestLanguage.g:641:1: (lv_value_5_0= ruleStringDatatype )
                    // InternalAssignmentsTestLanguage.g:642:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_5_0=ruleStringDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMultiDatatypeRule());
                    	        }
                           		add(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage.StringDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleMultiDatatype"


    // $ANTLR start "entryRuleIdDatatype"
    // InternalAssignmentsTestLanguage.g:666:1: entryRuleIdDatatype returns [String current=null] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final String entryRuleIdDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdDatatype = null;


        try {
            // InternalAssignmentsTestLanguage.g:667:2: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // InternalAssignmentsTestLanguage.g:668:2: iv_ruleIdDatatype= ruleIdDatatype EOF
            {
             newCompositeNode(grammarAccess.getIdDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdDatatype=ruleIdDatatype();

            state._fsp--;

             current =iv_ruleIdDatatype.getText(); 
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
    // $ANTLR end "entryRuleIdDatatype"


    // $ANTLR start "ruleIdDatatype"
    // InternalAssignmentsTestLanguage.g:675:1: ruleIdDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:678:28: (this_ID_0= RULE_ID )
            // InternalAssignmentsTestLanguage.g:679:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getIdDatatypeAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleIdDatatype"


    // $ANTLR start "entryRuleStringDatatype"
    // InternalAssignmentsTestLanguage.g:694:1: entryRuleStringDatatype returns [String current=null] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final String entryRuleStringDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringDatatype = null;


        try {
            // InternalAssignmentsTestLanguage.g:695:2: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // InternalAssignmentsTestLanguage.g:696:2: iv_ruleStringDatatype= ruleStringDatatype EOF
            {
             newCompositeNode(grammarAccess.getStringDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringDatatype=ruleStringDatatype();

            state._fsp--;

             current =iv_ruleStringDatatype.getText(); 
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
    // $ANTLR end "entryRuleStringDatatype"


    // $ANTLR start "ruleStringDatatype"
    // InternalAssignmentsTestLanguage.g:703:1: ruleStringDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalAssignmentsTestLanguage.g:706:28: (this_STRING_0= RULE_STRING )
            // InternalAssignmentsTestLanguage.g:707:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getStringDatatypeAccess().getSTRINGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleStringDatatype"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    }


}
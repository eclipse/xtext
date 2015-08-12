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
    public static final int RULE_ID=4;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalAssignmentsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAssignmentsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAssignmentsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:79:28: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getSimpleKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:84:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:84:2: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:84:2: ( (lv_single_1_0= ruleSingleValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:85:1: (lv_single_1_0= ruleSingleValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:85:1: (lv_single_1_0= ruleSingleValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:3: lv_single_1_0= ruleSingleValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getSingleSingleValueParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel145);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:103:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:103:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:104:1: (lv_multi_2_0= ruleMultiValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:104:1: (lv_multi_2_0= ruleMultiValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:105:3: lv_multi_2_0= ruleMultiValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getMultiMultiValueParserRuleCall_0_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel172);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:122:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:122:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:123:1: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:123:1: (lv_single_3_0= ruleSingleDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:124:3: lv_single_3_0= ruleSingleDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getSingleSingleDatatypeParserRuleCall_0_1_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel199);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:141:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:141:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:142:1: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:142:1: (lv_multi_4_0= ruleMultiDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:143:3: lv_multi_4_0= ruleMultiDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getMultiMultiDatatypeParserRuleCall_0_1_3_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel226);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:160:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:160:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:160:8: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel247); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getComplexKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:164:1: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:165:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:165:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:166:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:166:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:167:3: lv_object_6_1= ruleSingleValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectSingleValueParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel270);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:182:8: lv_object_6_2= ruleMultiValue
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectMultiValueParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel289);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:197:8: lv_object_6_3= ruleSingleDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectSingleDatatypeParserRuleCall_1_1_0_2()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel308);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:212:8: lv_object_6_4= ruleMultiDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getObjectMultiDatatypeParserRuleCall_1_1_0_3()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel327);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:238:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:239:2: (iv_ruleSingleValue= ruleSingleValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:240:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             newCompositeNode(grammarAccess.getSingleValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_entryRuleSingleValue367);
            iv_ruleSingleValue=ruleSingleValue();

            state._fsp--;

             current =iv_ruleSingleValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleValue377); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:247:1: ruleSingleValue returns [EObject current=null] : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:250:28: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:251:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:251:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:251:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:251:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:251:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleValue415); 

                        	newLeafNode(otherlv_0, grammarAccess.getSingleValueAccess().getIdKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:255:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:256:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:256:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:257:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue432); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:274:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:274:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:274:8: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleValue457); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleValueAccess().getAlternativeKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:278:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:279:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:279:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:280:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:280:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:281:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue476); 

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:296:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue496); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:315:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:315:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:315:8: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleValue524); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleValueAccess().getStringKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:319:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:320:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:320:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:321:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue541); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:345:1: entryRuleMultiValue returns [EObject current=null] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final EObject entryRuleMultiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:346:2: (iv_ruleMultiValue= ruleMultiValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:347:2: iv_ruleMultiValue= ruleMultiValue EOF
            {
             newCompositeNode(grammarAccess.getMultiValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_entryRuleMultiValue583);
            iv_ruleMultiValue=ruleMultiValue();

            state._fsp--;

             current =iv_ruleMultiValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiValue593); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:354:1: ruleMultiValue returns [EObject current=null] : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:357:28: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:358:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:358:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:358:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:358:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:358:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiValue631); 

                        	newLeafNode(otherlv_0, grammarAccess.getMultiValueAccess().getIdsKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:362:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:363:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:363:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:364:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue648); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:381:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:381:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:381:8: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiValue673); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiValueAccess().getAlternativesKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:385:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:386:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:386:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:387:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:387:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:388:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue692); 

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:403:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue712); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:422:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:422:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:422:8: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiValue740); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultiValueAccess().getStringsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:426:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:427:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:427:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:428:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue757); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:452:1: entryRuleSingleDatatype returns [EObject current=null] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final EObject entryRuleSingleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:453:2: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:454:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
            {
             newCompositeNode(grammarAccess.getSingleDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype799);
            iv_ruleSingleDatatype=ruleSingleDatatype();

            state._fsp--;

             current =iv_ruleSingleDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleDatatype809); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:461:1: ruleSingleDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:464:28: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleDatatype847); 

                        	newLeafNode(otherlv_0, grammarAccess.getSingleDatatypeAccess().getDatatypeidKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:469:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:470:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:470:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:471:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype868);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:488:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:488:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:488:8: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSingleDatatype888); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:492:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:493:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:493:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:494:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:494:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:495:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype911);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:510:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype930);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:529:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:529:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:529:8: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSingleDatatype953); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleDatatypeAccess().getDatatypestringKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:533:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:534:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:534:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:535:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype974);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:559:1: entryRuleMultiDatatype returns [EObject current=null] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final EObject entryRuleMultiDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:560:2: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:561:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
            {
             newCompositeNode(grammarAccess.getMultiDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype1011);
            iv_ruleMultiDatatype=ruleMultiDatatype();

            state._fsp--;

             current =iv_ruleMultiDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiDatatype1021); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:568:1: ruleMultiDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:571:28: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiDatatype1059); 

                        	newLeafNode(otherlv_0, grammarAccess.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:576:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:577:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:577:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:578:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1080);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:595:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:595:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:595:8: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiDatatype1100); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:599:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:600:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:600:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:601:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:601:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1123);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:617:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1142);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:636:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:636:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:636:8: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiDatatype1165); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:640:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:641:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:641:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:642:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1186);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:666:1: entryRuleIdDatatype returns [String current=null] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final String entryRuleIdDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:667:2: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:668:2: iv_ruleIdDatatype= ruleIdDatatype EOF
            {
             newCompositeNode(grammarAccess.getIdDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1224);
            iv_ruleIdDatatype=ruleIdDatatype();

            state._fsp--;

             current =iv_ruleIdDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdDatatype1235); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:675:1: ruleIdDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:678:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:679:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdDatatype1274); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:694:1: entryRuleStringDatatype returns [String current=null] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final String entryRuleStringDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:695:2: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:696:2: iv_ruleStringDatatype= ruleStringDatatype EOF
            {
             newCompositeNode(grammarAccess.getStringDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1319);
            iv_ruleStringDatatype=ruleStringDatatype();

            state._fsp--;

             current =iv_ruleStringDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringDatatype1330); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:703:1: ruleStringDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:28: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:707:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringDatatype1369); 

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel247 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleValue_in_entryRuleSingleValue367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleValue377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSingleValue415 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSingleValue457 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSingleValue524 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_entryRuleMultiValue583 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiValue593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMultiValue631 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiValue673 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiValue740 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleDatatype809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleDatatype847 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleSingleDatatype888 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleSingleDatatype953 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype1011 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiDatatype1021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMultiDatatype1059 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleMultiDatatype1100 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleMultiDatatype1165 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdDatatype1235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdDatatype1274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringDatatype1330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleStringDatatype1369 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

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
     	
        public InternalAssignmentsTestLanguageParser(TokenStream input, IAstFactory factory, AssignmentsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:79:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:82:28: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:83:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:83:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:83:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:83:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:83:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getSimpleKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:87:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:87:2: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:87:2: ( (lv_single_1_0= ruleSingleValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:88:1: (lv_single_1_0= ruleSingleValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:88:1: (lv_single_1_0= ruleSingleValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:89:3: lv_single_1_0= ruleSingleValue
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
                                    		"SingleValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:106:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:106:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:107:1: (lv_multi_2_0= ruleMultiValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:107:1: (lv_multi_2_0= ruleMultiValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:108:3: lv_multi_2_0= ruleMultiValue
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
                                    		"MultiValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:125:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:125:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:126:1: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:126:1: (lv_single_3_0= ruleSingleDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:127:3: lv_single_3_0= ruleSingleDatatype
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
                                    		"SingleDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:144:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:144:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:145:1: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:145:1: (lv_multi_4_0= ruleMultiDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:146:3: lv_multi_4_0= ruleMultiDatatype
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
                                    		"MultiDatatype");
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:163:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:163:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:163:8: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel247); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getComplexKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:167:1: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:168:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:168:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:169:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:169:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:170:3: lv_object_6_1= ruleSingleValue
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
                                    		"SingleValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:185:8: lv_object_6_2= ruleMultiValue
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
                                    		"MultiValue");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:200:8: lv_object_6_3= ruleSingleDatatype
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
                                    		"SingleDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:215:8: lv_object_6_4= ruleMultiDatatype
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
                                    		"MultiDatatype");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:241:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:242:2: (iv_ruleSingleValue= ruleSingleValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:243:2: iv_ruleSingleValue= ruleSingleValue EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:250:1: ruleSingleValue returns [EObject current=null] : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:253:28: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:254:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:254:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:254:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:254:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:254:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleValue415); 

                        	newLeafNode(otherlv_0, grammarAccess.getSingleValueAccess().getIdKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:258:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:259:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:259:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:260:3: lv_value_1_0= RULE_ID
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
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:277:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:277:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:277:8: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleValue457); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleValueAccess().getAlternativeKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:281:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:282:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:282:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:283:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:283:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:284:3: lv_value_3_1= RULE_ID
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
                                    		"ID");
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:299:8: lv_value_3_2= RULE_STRING
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
                                    		"STRING");
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:318:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:318:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:318:8: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleValue524); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleValueAccess().getStringKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:322:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:323:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:323:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:324:3: lv_value_5_0= RULE_STRING
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
                            		"STRING");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:348:1: entryRuleMultiValue returns [EObject current=null] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final EObject entryRuleMultiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:349:2: (iv_ruleMultiValue= ruleMultiValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:350:2: iv_ruleMultiValue= ruleMultiValue EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:357:1: ruleMultiValue returns [EObject current=null] : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:360:28: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:361:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:361:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:361:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:361:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:361:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiValue631); 

                        	newLeafNode(otherlv_0, grammarAccess.getMultiValueAccess().getIdsKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:365:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:366:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:366:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:367:3: lv_value_1_0= RULE_ID
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
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:384:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:384:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:384:8: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiValue673); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiValueAccess().getAlternativesKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:388:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:389:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:389:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:390:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:390:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:391:3: lv_value_3_1= RULE_ID
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
                                    		"ID");
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:406:8: lv_value_3_2= RULE_STRING
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
                                    		"STRING");
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:425:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:425:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:425:8: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiValue740); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultiValueAccess().getStringsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:429:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:430:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:430:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:431:3: lv_value_5_0= RULE_STRING
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
                            		"STRING");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:455:1: entryRuleSingleDatatype returns [EObject current=null] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final EObject entryRuleSingleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:456:2: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:457:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:464:1: ruleSingleDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:467:28: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:468:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:468:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:468:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:468:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:468:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleDatatype847); 

                        	newLeafNode(otherlv_0, grammarAccess.getSingleDatatypeAccess().getDatatypeidKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:472:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:473:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:473:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:474:3: lv_value_1_0= ruleIdDatatype
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
                            		"IdDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:491:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:491:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:491:8: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSingleDatatype888); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:495:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:496:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:496:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:497:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:497:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:498:3: lv_value_3_1= ruleIdDatatype
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
                                    		"IdDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:513:8: lv_value_3_2= ruleStringDatatype
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
                                    		"StringDatatype");
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:532:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:532:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:532:8: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSingleDatatype953); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleDatatypeAccess().getDatatypestringKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:536:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:537:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:537:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:538:3: lv_value_5_0= ruleStringDatatype
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
                            		"StringDatatype");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:562:1: entryRuleMultiDatatype returns [EObject current=null] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final EObject entryRuleMultiDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:563:2: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:564:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:571:1: ruleMultiDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:574:28: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:575:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:575:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:575:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:575:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:575:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiDatatype1059); 

                        	newLeafNode(otherlv_0, grammarAccess.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:580:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:580:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:581:3: lv_value_1_0= ruleIdDatatype
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
                            		"IdDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:598:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:598:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:598:8: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiDatatype1100); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:603:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:603:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:604:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:604:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:605:3: lv_value_3_1= ruleIdDatatype
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
                                    		"IdDatatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:620:8: lv_value_3_2= ruleStringDatatype
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
                                    		"StringDatatype");
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:639:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:639:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:639:8: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiDatatype1165); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:643:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:644:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:644:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:645:3: lv_value_5_0= ruleStringDatatype
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
                            		"StringDatatype");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:669:1: entryRuleIdDatatype returns [String current=null] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final String entryRuleIdDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:670:2: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:671:2: iv_ruleIdDatatype= ruleIdDatatype EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:678:1: ruleIdDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:681:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:682:5: this_ID_0= RULE_ID
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:697:1: entryRuleStringDatatype returns [String current=null] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final String entryRuleStringDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:2: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:699:2: iv_ruleStringDatatype= ruleStringDatatype EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:1: ruleStringDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:709:28: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:710:5: this_STRING_0= RULE_STRING
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
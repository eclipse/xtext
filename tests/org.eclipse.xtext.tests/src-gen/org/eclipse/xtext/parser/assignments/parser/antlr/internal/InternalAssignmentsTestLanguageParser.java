package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

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
            this.factory = factory;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:85:6: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:1: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:2: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getSimpleKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:90:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:90:2: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:90:2: ( (lv_single_1_0= ruleSingleValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:91:1: (lv_single_1_0= ruleSingleValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:91:1: (lv_single_1_0= ruleSingleValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:3: lv_single_1_0= ruleSingleValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSingleSingleValueParserRuleCall_0_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel145);
                            lv_single_1_0=ruleSingleValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"single",
                            	        		lv_single_1_0, 
                            	        		"SingleValue", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:115:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:115:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:116:1: (lv_multi_2_0= ruleMultiValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:116:1: (lv_multi_2_0= ruleMultiValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:117:3: lv_multi_2_0= ruleMultiValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiMultiValueParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel172);
                            lv_multi_2_0=ruleMultiValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"multi",
                            	        		lv_multi_2_0, 
                            	        		"MultiValue", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:140:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:140:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:141:1: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:141:1: (lv_single_3_0= ruleSingleDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:142:3: lv_single_3_0= ruleSingleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSingleSingleDatatypeParserRuleCall_0_1_2_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel199);
                            lv_single_3_0=ruleSingleDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"single",
                            	        		lv_single_3_0, 
                            	        		"SingleDatatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:165:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:165:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:166:1: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:166:1: (lv_multi_4_0= ruleMultiDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:167:3: lv_multi_4_0= ruleMultiDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiMultiDatatypeParserRuleCall_0_1_3_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel226);
                            lv_multi_4_0=ruleMultiDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"multi",
                            	        		lv_multi_4_0, 
                            	        		"MultiDatatype", 
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
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:190:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:190:6: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:190:8: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel247); 

                        	createLeafNode(otherlv_5, grammarAccess.getModelAccess().getComplexKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:194:1: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:195:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:195:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:197:3: lv_object_6_1= ruleSingleValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectSingleValueParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel270);
                            lv_object_6_1=ruleSingleValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"object",
                            	        		lv_object_6_1, 
                            	        		"SingleValue", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:218:8: lv_object_6_2= ruleMultiValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectMultiValueParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel289);
                            lv_object_6_2=ruleMultiValue();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"object",
                            	        		lv_object_6_2, 
                            	        		"MultiValue", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:239:8: lv_object_6_3= ruleSingleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectSingleDatatypeParserRuleCall_1_1_0_2(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel308);
                            lv_object_6_3=ruleSingleDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"object",
                            	        		lv_object_6_3, 
                            	        		"SingleDatatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:260:8: lv_object_6_4= ruleMultiDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectMultiDatatypeParserRuleCall_1_1_0_3(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel327);
                            lv_object_6_4=ruleMultiDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"object",
                            	        		lv_object_6_4, 
                            	        		"MultiDatatype", 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSingleValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:292:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:293:2: (iv_ruleSingleValue= ruleSingleValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:294:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleValueRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:301:1: ruleSingleValue returns [EObject current=null] : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:306:6: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:307:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:307:1: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:307:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:307:2: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:307:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleValue415); 

                        	createLeafNode(otherlv_0, grammarAccess.getSingleValueAccess().getIdKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:311:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:312:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:312:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:313:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue432); 

                    			createLeafNode(lv_value_1_0, grammarAccess.getSingleValueAccess().getValueIDTerminalRuleCall_0_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:336:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:336:6: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:336:8: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleValue457); 

                        	createLeafNode(otherlv_2, grammarAccess.getSingleValueAccess().getAlternativeKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:340:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:341:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:341:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:342:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:342:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:343:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue476); 

                            			createLeafNode(lv_value_3_1, grammarAccess.getSingleValueAccess().getValueIDTerminalRuleCall_1_1_0_0(), "value"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSingleValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_1, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:364:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue496); 

                            			createLeafNode(lv_value_3_2, grammarAccess.getSingleValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1(), "value"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSingleValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_2, 
                            	        		"STRING", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:389:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:389:6: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:389:8: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleValue524); 

                        	createLeafNode(otherlv_4, grammarAccess.getSingleValueAccess().getStringKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:393:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:394:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:394:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:395:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue541); 

                    			createLeafNode(lv_value_5_0, grammarAccess.getSingleValueAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_5_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


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
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleMultiValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:425:1: entryRuleMultiValue returns [EObject current=null] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final EObject entryRuleMultiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:426:2: (iv_ruleMultiValue= ruleMultiValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:427:2: iv_ruleMultiValue= ruleMultiValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiValueRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:434:1: ruleMultiValue returns [EObject current=null] : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleMultiValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:439:6: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:1: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:2: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiValue631); 

                        	createLeafNode(otherlv_0, grammarAccess.getMultiValueAccess().getIdsKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:444:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:445:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:445:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:446:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue648); 

                    			createLeafNode(lv_value_1_0, grammarAccess.getMultiValueAccess().getValueIDTerminalRuleCall_0_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMultiValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:469:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:469:6: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:469:8: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiValue673); 

                        	createLeafNode(otherlv_2, grammarAccess.getMultiValueAccess().getAlternativesKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:473:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:474:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:474:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:475:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:475:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:476:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue692); 

                            			createLeafNode(lv_value_3_1, grammarAccess.getMultiValueAccess().getValueIDTerminalRuleCall_1_1_0_0(), "value"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getMultiValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_1, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:497:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue712); 

                            			createLeafNode(lv_value_3_2, grammarAccess.getMultiValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1(), "value"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getMultiValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_2, 
                            	        		"STRING", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:522:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:522:6: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:522:8: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiValue740); 

                        	createLeafNode(otherlv_4, grammarAccess.getMultiValueAccess().getStringsKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:526:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:527:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:527:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:528:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue757); 

                    			createLeafNode(lv_value_5_0, grammarAccess.getMultiValueAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMultiValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_5_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


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
    // $ANTLR end "ruleMultiValue"


    // $ANTLR start "entryRuleSingleDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:558:1: entryRuleSingleDatatype returns [EObject current=null] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final EObject entryRuleSingleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:559:2: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:560:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleDatatypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:567:1: ruleSingleDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleSingleDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:6: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:1: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:2: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleDatatype847); 

                        	createLeafNode(otherlv_0, grammarAccess.getSingleDatatypeAccess().getDatatypeidKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:577:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:578:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:578:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype868);
                    lv_value_1_0=ruleIdDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleDatatypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_1_0, 
                    	        		"IdDatatype", 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:6: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:8: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSingleDatatype888); 

                        	createLeafNode(otherlv_2, grammarAccess.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:606:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:607:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:607:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:608:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:608:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:609:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype911);
                            lv_value_3_1=ruleIdDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSingleDatatypeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_1, 
                            	        		"IdDatatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:630:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype930);
                            lv_value_3_2=ruleStringDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSingleDatatypeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_2, 
                            	        		"StringDatatype", 
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
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:655:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:655:6: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:655:8: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSingleDatatype953); 

                        	createLeafNode(otherlv_4, grammarAccess.getSingleDatatypeAccess().getDatatypestringKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:659:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:660:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:660:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:661:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype974);
                    lv_value_5_0=ruleStringDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleDatatypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_5_0, 
                    	        		"StringDatatype", 
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
    // $ANTLR end "ruleSingleDatatype"


    // $ANTLR start "entryRuleMultiDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:691:1: entryRuleMultiDatatype returns [EObject current=null] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final EObject entryRuleMultiDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:692:2: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:693:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiDatatypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:700:1: ruleMultiDatatype returns [EObject current=null] : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleMultiDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:705:6: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:1: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:2: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiDatatype1059); 

                        	createLeafNode(otherlv_0, grammarAccess.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:710:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:711:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:711:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:712:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1080);
                    lv_value_1_0=ruleIdDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMultiDatatypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_1_0, 
                    	        		"IdDatatype", 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:735:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:735:6: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:735:8: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiDatatype1100); 

                        	createLeafNode(otherlv_2, grammarAccess.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:739:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:740:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:740:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:741:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:741:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:742:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1123);
                            lv_value_3_1=ruleIdDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getMultiDatatypeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_1, 
                            	        		"IdDatatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:763:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1142);
                            lv_value_3_2=ruleStringDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getMultiDatatypeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_3_2, 
                            	        		"StringDatatype", 
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
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:788:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:788:6: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:788:8: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiDatatype1165); 

                        	createLeafNode(otherlv_4, grammarAccess.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:792:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:793:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:793:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:794:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1186);
                    lv_value_5_0=ruleStringDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMultiDatatypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_5_0, 
                    	        		"StringDatatype", 
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
    // $ANTLR end "ruleMultiDatatype"


    // $ANTLR start "entryRuleIdDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:824:1: entryRuleIdDatatype returns [String current=null] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final String entryRuleIdDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:825:2: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:826:2: iv_ruleIdDatatype= ruleIdDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIdDatatypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:833:1: ruleIdDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:838:6: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:839:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdDatatype1274); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getIdDatatypeAccess().getIDTerminalRuleCall(), null); 
                

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
    // $ANTLR end "ruleIdDatatype"


    // $ANTLR start "entryRuleStringDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:854:1: entryRuleStringDatatype returns [String current=null] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final String entryRuleStringDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:855:2: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:856:2: iv_ruleStringDatatype= ruleStringDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringDatatypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:863:1: ruleStringDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:868:6: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:869:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringDatatype1369); 

            		current.merge(this_STRING_0);
                
             
                createLeafNode(this_STRING_0, grammarAccess.getStringDatatypeAccess().getSTRINGTerminalRuleCall(), null); 
                

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
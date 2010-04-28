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

public class InternalAssignmentsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'simple'", "'complex'", "'id'", "'alternative'", "'string'", "'ids'", "'alternatives'", "'strings'", "'datatypeid'", "'datatypealternative'", "'datatypestring'", "'datatypeids'", "'datatypealternatives'", "'datatypestrings'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalAssignmentsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g"; }



     	private AssignmentsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAssignmentsTestLanguageParser(TokenStream input, IAstFactory factory, AssignmentsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected AssignmentsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_single_1_0 = null;

        EObject lv_multi_2_0 = null;

        EObject lv_single_3_0 = null;

        EObject lv_multi_4_0 = null;

        EObject lv_object_6_1 = null;

        EObject lv_object_6_2 = null;

        EObject lv_object_6_3 = null;

        EObject lv_object_6_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:91:6: ( ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:1: ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:1: ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    new NoViableAltException("92:1: ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:2: ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:2: ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:4: 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel121); 

                            createLeafNode(grammarAccess.getModelAccess().getSimpleKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:96:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            new NoViableAltException("96:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )", 1, 0, input);

                        throw nvae;
                    }

                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:96:2: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:96:2: ( (lv_single_1_0= ruleSingleValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:97:1: (lv_single_1_0= ruleSingleValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:97:1: (lv_single_1_0= ruleSingleValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:98:3: lv_single_1_0= ruleSingleValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSingleSingleValueParserRuleCall_0_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel143);
                            lv_single_1_0=ruleSingleValue();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:121:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:121:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:122:1: (lv_multi_2_0= ruleMultiValue )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:122:1: (lv_multi_2_0= ruleMultiValue )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:123:3: lv_multi_2_0= ruleMultiValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiMultiValueParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel170);
                            lv_multi_2_0=ruleMultiValue();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:146:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:146:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:147:1: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:147:1: (lv_single_3_0= ruleSingleDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:148:3: lv_single_3_0= ruleSingleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSingleSingleDatatypeParserRuleCall_0_1_2_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel197);
                            lv_single_3_0=ruleSingleDatatype();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:171:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:171:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:172:1: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:172:1: (lv_multi_4_0= ruleMultiDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:173:3: lv_multi_4_0= ruleMultiDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiMultiDatatypeParserRuleCall_0_1_3_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel224);
                            lv_multi_4_0=ruleMultiDatatype();
                            _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:6: ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:6: ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:8: 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel243); 

                            createLeafNode(grammarAccess.getModelAccess().getComplexKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:200:1: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:201:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:201:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:202:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:202:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            new NoViableAltException("202:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:203:3: lv_object_6_1= ruleSingleValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectSingleValueParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel266);
                            lv_object_6_1=ruleSingleValue();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:224:8: lv_object_6_2= ruleMultiValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectMultiValueParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel285);
                            lv_object_6_2=ruleMultiValue();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:245:8: lv_object_6_3= ruleSingleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectSingleDatatypeParserRuleCall_1_1_0_2(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel304);
                            lv_object_6_3=ruleSingleDatatype();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:266:8: lv_object_6_4= ruleMultiDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectMultiDatatypeParserRuleCall_1_1_0_3(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel323);
                            lv_object_6_4=ruleMultiDatatype();
                            _fsp--;


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleSingleValue
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:298:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:299:2: (iv_ruleSingleValue= ruleSingleValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:300:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleValueRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_entryRuleSingleValue363);
            iv_ruleSingleValue=ruleSingleValue();
            _fsp--;

             current =iv_ruleSingleValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleValue373); 

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
    // $ANTLR end entryRuleSingleValue


    // $ANTLR start ruleSingleValue
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:307:1: ruleSingleValue returns [EObject current=null] : ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token lv_value_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:312:6: ( ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:313:1: ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:313:1: ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    new NoViableAltException("313:1: ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:313:2: ( 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:313:2: ( 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:313:4: 'id' ( (lv_value_1_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleValue409); 

                            createLeafNode(grammarAccess.getSingleValueAccess().getIdKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:317:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:318:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:318:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:319:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue426); 

                    			createLeafNode(grammarAccess.getSingleValueAccess().getValueIDTerminalRuleCall_0_1_0(), "value"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:342:6: ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:342:6: ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:342:8: 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleValue449); 

                            createLeafNode(grammarAccess.getSingleValueAccess().getAlternativeKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:346:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:347:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:347:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:348:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:348:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            new NoViableAltException("348:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:349:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue468); 

                            			createLeafNode(grammarAccess.getSingleValueAccess().getValueIDTerminalRuleCall_1_1_0_0(), "value"); 
                            		

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:370:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue488); 

                            			createLeafNode(grammarAccess.getSingleValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1(), "value"); 
                            		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:395:6: ( 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:395:6: ( 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:395:8: 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleValue514); 

                            createLeafNode(grammarAccess.getSingleValueAccess().getStringKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:399:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:400:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:400:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:401:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue531); 

                    			createLeafNode(grammarAccess.getSingleValueAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    		

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
    // $ANTLR end ruleSingleValue


    // $ANTLR start entryRuleMultiValue
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:431:1: entryRuleMultiValue returns [EObject current=null] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final EObject entryRuleMultiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:432:2: (iv_ruleMultiValue= ruleMultiValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:433:2: iv_ruleMultiValue= ruleMultiValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiValueRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_entryRuleMultiValue573);
            iv_ruleMultiValue=ruleMultiValue();
            _fsp--;

             current =iv_ruleMultiValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiValue583); 

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
    // $ANTLR end entryRuleMultiValue


    // $ANTLR start ruleMultiValue
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:1: ruleMultiValue returns [EObject current=null] : ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleMultiValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token lv_value_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:445:6: ( ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:446:1: ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:446:1: ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    new NoViableAltException("446:1: ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:446:2: ( 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:446:2: ( 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:446:4: 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiValue619); 

                            createLeafNode(grammarAccess.getMultiValueAccess().getIdsKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:450:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:451:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:451:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:452:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue636); 

                    			createLeafNode(grammarAccess.getMultiValueAccess().getValueIDTerminalRuleCall_0_1_0(), "value"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:475:6: ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:475:6: ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:475:8: 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiValue659); 

                            createLeafNode(grammarAccess.getMultiValueAccess().getAlternativesKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:479:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:480:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:480:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:481:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:481:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            new NoViableAltException("481:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:482:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue678); 

                            			createLeafNode(grammarAccess.getMultiValueAccess().getValueIDTerminalRuleCall_1_1_0_0(), "value"); 
                            		

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:503:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue698); 

                            			createLeafNode(grammarAccess.getMultiValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1(), "value"); 
                            		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:528:6: ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:528:6: ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:528:8: 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiValue724); 

                            createLeafNode(grammarAccess.getMultiValueAccess().getStringsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:532:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:533:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:533:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:534:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue741); 

                    			createLeafNode(grammarAccess.getMultiValueAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    		

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
    // $ANTLR end ruleMultiValue


    // $ANTLR start entryRuleSingleDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:564:1: entryRuleSingleDatatype returns [EObject current=null] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final EObject entryRuleSingleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:565:2: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:566:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleDatatypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype783);
            iv_ruleSingleDatatype=ruleSingleDatatype();
            _fsp--;

             current =iv_ruleSingleDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleDatatype793); 

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
    // $ANTLR end entryRuleSingleDatatype


    // $ANTLR start ruleSingleDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:1: ruleSingleDatatype returns [EObject current=null] : ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleSingleDatatype() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:578:6: ( ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:1: ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:1: ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    new NoViableAltException("579:1: ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:2: ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:2: ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:579:4: 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleDatatype829); 

                            createLeafNode(grammarAccess.getSingleDatatypeAccess().getDatatypeidKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:583:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:584:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:584:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:585:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype850);
                    lv_value_1_0=ruleIdDatatype();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:608:6: ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:608:6: ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:608:8: 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleSingleDatatype868); 

                            createLeafNode(grammarAccess.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:612:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:613:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:613:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:614:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:614:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            new NoViableAltException("614:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:615:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype891);
                            lv_value_3_1=ruleIdDatatype();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:636:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype910);
                            lv_value_3_2=ruleStringDatatype();
                            _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:661:6: ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:661:6: ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:661:8: 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleSingleDatatype931); 

                            createLeafNode(grammarAccess.getSingleDatatypeAccess().getDatatypestringKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:665:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:666:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:666:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:667:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype952);
                    lv_value_5_0=ruleStringDatatype();
                    _fsp--;


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
    // $ANTLR end ruleSingleDatatype


    // $ANTLR start entryRuleMultiDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:697:1: entryRuleMultiDatatype returns [EObject current=null] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final EObject entryRuleMultiDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:2: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:699:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiDatatypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype989);
            iv_ruleMultiDatatype=ruleMultiDatatype();
            _fsp--;

             current =iv_ruleMultiDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiDatatype999); 

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
    // $ANTLR end entryRuleMultiDatatype


    // $ANTLR start ruleMultiDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:706:1: ruleMultiDatatype returns [EObject current=null] : ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleMultiDatatype() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:711:6: ( ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:712:1: ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:712:1: ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    new NoViableAltException("712:1: ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:712:2: ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:712:2: ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:712:4: 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiDatatype1035); 

                            createLeafNode(grammarAccess.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:716:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:717:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:717:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:718:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1056);
                    lv_value_1_0=ruleIdDatatype();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:741:6: ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:741:6: ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:741:8: 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiDatatype1074); 

                            createLeafNode(grammarAccess.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:745:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:746:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:746:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:747:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:747:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            new NoViableAltException("747:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:748:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1097);
                            lv_value_3_1=ruleIdDatatype();
                            _fsp--;


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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:769:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1116);
                            lv_value_3_2=ruleStringDatatype();
                            _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:794:6: ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:794:6: ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:794:8: 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiDatatype1137); 

                            createLeafNode(grammarAccess.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:798:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:799:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:799:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:800:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1158);
                    lv_value_5_0=ruleStringDatatype();
                    _fsp--;


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
    // $ANTLR end ruleMultiDatatype


    // $ANTLR start entryRuleIdDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:830:1: entryRuleIdDatatype returns [String current=null] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final String entryRuleIdDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:831:2: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:832:2: iv_ruleIdDatatype= ruleIdDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIdDatatypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1196);
            iv_ruleIdDatatype=ruleIdDatatype();
            _fsp--;

             current =iv_ruleIdDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdDatatype1207); 

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
    // $ANTLR end entryRuleIdDatatype


    // $ANTLR start ruleIdDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:839:1: ruleIdDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:844:6: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:845:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdDatatype1246); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getIdDatatypeAccess().getIDTerminalRuleCall(), null); 
                

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
    // $ANTLR end ruleIdDatatype


    // $ANTLR start entryRuleStringDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:860:1: entryRuleStringDatatype returns [String current=null] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final String entryRuleStringDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:861:2: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:862:2: iv_ruleStringDatatype= ruleStringDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringDatatypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1291);
            iv_ruleStringDatatype=ruleStringDatatype();
            _fsp--;

             current =iv_ruleStringDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringDatatype1302); 

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
    // $ANTLR end entryRuleStringDatatype


    // $ANTLR start ruleStringDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:869:1: ruleStringDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:874:6: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:875:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringDatatype1341); 

            		current.merge(this_STRING_0);
                
             
                createLeafNode(grammarAccess.getStringDatatypeAccess().getSTRINGTerminalRuleCall(), null); 
                

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
    // $ANTLR end ruleStringDatatype


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel243 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleValue_in_entryRuleSingleValue363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleValue373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSingleValue409 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSingleValue449 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSingleValue514 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_entryRuleMultiValue573 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiValue583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMultiValue619 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiValue659 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiValue724 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleDatatype793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleDatatype829 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleSingleDatatype868 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleSingleDatatype931 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype989 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiDatatype999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMultiDatatype1035 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleMultiDatatype1074 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleMultiDatatype1137 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdDatatype1207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdDatatype1246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1291 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringDatatype1302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleStringDatatype1341 = new BitSet(new long[]{0x0000000000000002L});
    }


}
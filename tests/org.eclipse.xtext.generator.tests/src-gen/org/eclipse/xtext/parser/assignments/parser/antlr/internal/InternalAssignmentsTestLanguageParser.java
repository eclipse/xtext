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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalAssignmentsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g"; }


     
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



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:85:6: ( ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:1: ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:1: ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    new NoViableAltException("86:1: ( ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:2: ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:2: ( 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:86:3: 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel118); 

                            createLeafNode(grammarAccess.getModelAccess().getSimpleKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:90:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            new NoViableAltException("90:1: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )", 1, 0, input);

                        throw nvae;
                    }

                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:90:2: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:90:2: ( (lv_single_1_0= ruleSingleValue ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:91:1: (lv_single_1_0= ruleSingleValue )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:91:1: (lv_single_1_0= ruleSingleValue )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:92:3: lv_single_1_0= ruleSingleValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSingleSingleValueParserRuleCall_0_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSingleValue_in_ruleModel140);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:115:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:115:6: ( (lv_multi_2_0= ruleMultiValue ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:116:1: (lv_multi_2_0= ruleMultiValue )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:116:1: (lv_multi_2_0= ruleMultiValue )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:117:3: lv_multi_2_0= ruleMultiValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiMultiValueParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMultiValue_in_ruleModel167);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:140:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:140:6: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:141:1: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:141:1: (lv_single_3_0= ruleSingleDatatype )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:142:3: lv_single_3_0= ruleSingleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSingleSingleDatatypeParserRuleCall_0_1_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSingleDatatype_in_ruleModel194);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:165:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:165:6: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:166:1: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:166:1: (lv_multi_4_0= ruleMultiDatatype )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:167:3: lv_multi_4_0= ruleMultiDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiMultiDatatypeParserRuleCall_0_1_3_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMultiDatatype_in_ruleModel221);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:190:6: ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:190:6: ( 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:190:7: 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {
                    match(input,12,FOLLOW_12_in_ruleModel239); 

                            createLeafNode(grammarAccess.getModelAccess().getComplexKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:194:1: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:195:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:195:1: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:196:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            new NoViableAltException("196:1: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:197:3: lv_object_6_1= ruleSingleValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectSingleValueParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSingleValue_in_ruleModel262);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:218:8: lv_object_6_2= ruleMultiValue
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectMultiValueParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMultiValue_in_ruleModel281);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:239:8: lv_object_6_3= ruleSingleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectSingleDatatypeParserRuleCall_1_1_0_2(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSingleDatatype_in_ruleModel300);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:260:8: lv_object_6_4= ruleMultiDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getObjectMultiDatatypeParserRuleCall_1_1_0_3(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMultiDatatype_in_ruleModel319);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:291:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:291:53: (iv_ruleSingleValue= ruleSingleValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:292:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleValue_in_entryRuleSingleValue356);
            iv_ruleSingleValue=ruleSingleValue();
            _fsp--;

             current =iv_ruleSingleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleValue366); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:299:1: ruleSingleValue returns [EObject current=null] : ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token lv_value_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:304:6: ( ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:305:1: ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:305:1: ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    new NoViableAltException("305:1: ( ( 'id' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:305:2: ( 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:305:2: ( 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:305:3: 'id' ( (lv_value_1_0= RULE_ID ) )
                    {
                    match(input,13,FOLLOW_13_in_ruleSingleValue401); 

                            createLeafNode(grammarAccess.getSingleValueAccess().getIdKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:309:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:310:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:310:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:311:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleValue418); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:334:6: ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:334:6: ( 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:334:7: 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    match(input,14,FOLLOW_14_in_ruleSingleValue440); 

                            createLeafNode(grammarAccess.getSingleValueAccess().getAlternativeKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:338:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:339:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:339:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:340:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:340:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            new NoViableAltException("340:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:341:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleValue459); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:362:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleValue479); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:387:6: ( 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:387:6: ( 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:387:7: 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    match(input,15,FOLLOW_15_in_ruleSingleValue504); 

                            createLeafNode(grammarAccess.getSingleValueAccess().getStringKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:391:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:392:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:392:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:393:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleValue521); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:422:1: entryRuleMultiValue returns [EObject current=null] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final EObject entryRuleMultiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:422:52: (iv_ruleMultiValue= ruleMultiValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:423:2: iv_ruleMultiValue= ruleMultiValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiValue_in_entryRuleMultiValue560);
            iv_ruleMultiValue=ruleMultiValue();
            _fsp--;

             current =iv_ruleMultiValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiValue570); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:430:1: ruleMultiValue returns [EObject current=null] : ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleMultiValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token lv_value_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:435:6: ( ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:436:1: ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:436:1: ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    new NoViableAltException("436:1: ( ( 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:436:2: ( 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:436:2: ( 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:436:3: 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleMultiValue605); 

                            createLeafNode(grammarAccess.getMultiValueAccess().getIdsKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:440:1: ( (lv_value_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:441:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:441:1: (lv_value_1_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:442:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMultiValue622); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:6: ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:6: ( 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:465:7: 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleMultiValue644); 

                            createLeafNode(grammarAccess.getMultiValueAccess().getAlternativesKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:469:1: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:470:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:470:1: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:471:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:471:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            new NoViableAltException("471:1: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:472:3: lv_value_3_1= RULE_ID
                            {
                            lv_value_3_1=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMultiValue663); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:493:8: lv_value_3_2= RULE_STRING
                            {
                            lv_value_3_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMultiValue683); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:518:6: ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:518:6: ( 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:518:7: 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    match(input,18,FOLLOW_18_in_ruleMultiValue708); 

                            createLeafNode(grammarAccess.getMultiValueAccess().getStringsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:522:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:523:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:523:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:524:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMultiValue725); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:553:1: entryRuleSingleDatatype returns [EObject current=null] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final EObject entryRuleSingleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:553:56: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:554:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype764);
            iv_ruleSingleDatatype=ruleSingleDatatype();
            _fsp--;

             current =iv_ruleSingleDatatype; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleDatatype774); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:561:1: ruleSingleDatatype returns [EObject current=null] : ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleSingleDatatype() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:566:6: ( ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:567:1: ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:567:1: ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    new NoViableAltException("567:1: ( ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:567:2: ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:567:2: ( 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:567:3: 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleSingleDatatype809); 

                            createLeafNode(grammarAccess.getSingleDatatypeAccess().getDatatypeidKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:571:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:572:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:573:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleIdDatatype_in_ruleSingleDatatype830);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:596:6: ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:596:6: ( 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:596:7: 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    match(input,20,FOLLOW_20_in_ruleSingleDatatype847); 

                            createLeafNode(grammarAccess.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:600:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:601:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:601:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:602:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            new NoViableAltException("602:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:603:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleIdDatatype_in_ruleSingleDatatype870);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:624:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleStringDatatype_in_ruleSingleDatatype889);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:649:6: ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:649:6: ( 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:649:7: 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    match(input,21,FOLLOW_21_in_ruleSingleDatatype909); 

                            createLeafNode(grammarAccess.getSingleDatatypeAccess().getDatatypestringKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:653:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:654:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:654:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:655:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleStringDatatype_in_ruleSingleDatatype930);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:684:1: entryRuleMultiDatatype returns [EObject current=null] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final EObject entryRuleMultiDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:684:55: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:685:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype964);
            iv_ruleMultiDatatype=ruleMultiDatatype();
            _fsp--;

             current =iv_ruleMultiDatatype; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiDatatype974); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:692:1: ruleMultiDatatype returns [EObject current=null] : ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final EObject ruleMultiDatatype() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_1 = null;

        AntlrDatatypeRuleToken lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:697:6: ( ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:1: ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:1: ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    new NoViableAltException("698:1: ( ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:2: ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:2: ( 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:698:3: 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {
                    match(input,22,FOLLOW_22_in_ruleMultiDatatype1009); 

                            createLeafNode(grammarAccess.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:702:1: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:703:1: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:703:1: (lv_value_1_0= ruleIdDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:704:3: lv_value_1_0= ruleIdDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1030);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:727:6: ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:727:6: ( 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:727:7: 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {
                    match(input,23,FOLLOW_23_in_ruleMultiDatatype1047); 

                            createLeafNode(grammarAccess.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:731:1: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:732:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:732:1: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:733:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:733:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            new NoViableAltException("733:1: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:734:3: lv_value_3_1= ruleIdDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1070);
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:755:8: lv_value_3_2= ruleStringDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1089);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:780:6: ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:780:6: ( 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:780:7: 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {
                    match(input,24,FOLLOW_24_in_ruleMultiDatatype1109); 

                            createLeafNode(grammarAccess.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:784:1: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:785:1: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:785:1: (lv_value_5_0= ruleStringDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:786:3: lv_value_5_0= ruleStringDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1130);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:815:1: entryRuleIdDatatype returns [String current=null] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final String entryRuleIdDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:815:51: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:816:2: iv_ruleIdDatatype= ruleIdDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIdDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1165);
            iv_ruleIdDatatype=ruleIdDatatype();
            _fsp--;

             current =iv_ruleIdDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdDatatype1176); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:823:1: ruleIdDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:828:6: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:829:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdDatatype1215); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:844:1: entryRuleStringDatatype returns [String current=null] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final String entryRuleStringDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:844:55: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:845:2: iv_ruleStringDatatype= ruleStringDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1258);
            iv_ruleStringDatatype=ruleStringDatatype();
            _fsp--;

             current =iv_ruleStringDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringDatatype1269); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:852:1: ruleStringDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:857:6: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalAssignmentsTestLanguage.g:858:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringDatatype1308); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel118 = new BitSet(new long[]{0x0000000001FFE000L});
    public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModel239 = new BitSet(new long[]{0x0000000001FFE000L});
    public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleValue_in_entryRuleSingleValue356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleValue366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSingleValue401 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSingleValue440 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSingleValue504 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiValue_in_entryRuleMultiValue560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiValue570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMultiValue605 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleMultiValue644 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleMultiValue708 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleDatatype774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSingleDatatype809 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleSingleDatatype847 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSingleDatatype909 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiDatatype974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleMultiDatatype1009 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleMultiDatatype1047 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleMultiDatatype1109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdDatatype1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdDatatype1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringDatatype1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringDatatype1308 = new BitSet(new long[]{0x0000000000000002L});

}
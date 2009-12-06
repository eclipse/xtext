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
import org.eclipse.xtext.parser.assignments.services.Bug287184TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug287184TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ML_COMMENT", "RULE_INT", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'detail'", "'private'", "'protected'", "'public'", "'associated'", "';'", "'.'"
    };
    public static final int RULE_ML_COMMENT=5;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug287184TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g"; }



     	private Bug287184TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287184TestLanguageParser(TokenStream input, IAstFactory factory, Bug287184TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( 'model' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        AntlrDatatypeRuleToken lv_name_1_2 = null;

        EObject lv_detail_2_1 = null;

        EObject lv_detail_2_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:85:6: ( ( 'model' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:86:1: ( 'model' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:86:1: ( 'model' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:86:3: 'model' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            {
            match(input,11,FOLLOW_11_in_ruleModel118); 

                    createLeafNode(grammarAccess.getModelAccess().getModelKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:90:1: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:91:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:91:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:92:1: (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:92:1: (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==18) ) {
                    alt1=2;
                }
                else if ( (LA1_1==RULE_ML_COMMENT||LA1_1==12||LA1_1==16) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("92:1: (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN )", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("92:1: (lv_name_1_1= RULE_ID | lv_name_1_2= ruleFQN )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:93:3: lv_name_1_1= RULE_ID
                    {
                    lv_name_1_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel137); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_1, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:114:8: lv_name_1_2= ruleFQN
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getNameFQNParserRuleCall_1_0_1(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleModel161);
                    lv_name_1_2=ruleFQN();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_2, 
                    	        		"FQN", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:138:2: ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ML_COMMENT||LA3_0==12||LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:139:1: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:139:1: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:140:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:140:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==RULE_ML_COMMENT||LA2_0==12) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==16) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("140:1: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:141:3: lv_detail_2_1= ruleDetail
            	            {
            	             
            	            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDetailDetailParserRuleCall_2_0_0(), currentNode); 
            	            	    
            	            pushFollow(FOLLOW_ruleDetail_in_ruleModel187);
            	            lv_detail_2_1=ruleDetail();
            	            _fsp--;


            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	            	        }
            	            	        try {
            	            	       		add(
            	            	       			current, 
            	            	       			"detail",
            	            	        		lv_detail_2_1, 
            	            	        		"Detail", 
            	            	        		currentNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	        currentNode = currentNode.getParent();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:162:8: lv_detail_2_2= ruleAssociatedDetail
            	            {
            	             
            	            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDetailAssociatedDetailParserRuleCall_2_0_1(), currentNode); 
            	            	    
            	            pushFollow(FOLLOW_ruleAssociatedDetail_in_ruleModel206);
            	            lv_detail_2_2=ruleAssociatedDetail();
            	            _fsp--;


            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	            	        }
            	            	        try {
            	            	       		add(
            	            	       			current, 
            	            	       			"detail",
            	            	        		lv_detail_2_2, 
            	            	        		"AssociatedDetail", 
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
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


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


    // $ANTLR start entryRuleDetail
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:195:1: entryRuleDetail returns [EObject current=null] : iv_ruleDetail= ruleDetail EOF ;
    public final EObject entryRuleDetail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetail = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:195:48: (iv_ruleDetail= ruleDetail EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:196:2: iv_ruleDetail= ruleDetail EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDetailRule(), currentNode); 
            pushFollow(FOLLOW_ruleDetail_in_entryRuleDetail245);
            iv_ruleDetail=ruleDetail();
            _fsp--;

             current =iv_ruleDetail; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetail255); 

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
    // $ANTLR end entryRuleDetail


    // $ANTLR start ruleDetail
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:203:1: ruleDetail returns [EObject current=null] : ( ( (lv_doc_0_0= RULE_ML_COMMENT ) )? 'detail' ( ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) ) )? ( ( ruleFQN ) ) ) ;
    public final EObject ruleDetail() throws RecognitionException {
        EObject current = null;

        Token lv_doc_0_0=null;
        Token lv_visibility_2_1=null;
        Token lv_visibility_2_2=null;
        Token lv_visibility_2_3=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:208:6: ( ( ( (lv_doc_0_0= RULE_ML_COMMENT ) )? 'detail' ( ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) ) )? ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:209:1: ( ( (lv_doc_0_0= RULE_ML_COMMENT ) )? 'detail' ( ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:209:1: ( ( (lv_doc_0_0= RULE_ML_COMMENT ) )? 'detail' ( ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:209:2: ( (lv_doc_0_0= RULE_ML_COMMENT ) )? 'detail' ( ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) ) )? ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:209:2: ( (lv_doc_0_0= RULE_ML_COMMENT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ML_COMMENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:210:1: (lv_doc_0_0= RULE_ML_COMMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:210:1: (lv_doc_0_0= RULE_ML_COMMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:211:3: lv_doc_0_0= RULE_ML_COMMENT
                    {
                    lv_doc_0_0=(Token)input.LT(1);
                    match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_ruleDetail297); 

                    			createLeafNode(grammarAccess.getDetailAccess().getDocML_COMMENTTerminalRuleCall_0_0(), "doc"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDetailRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"doc",
                    	        		lv_doc_0_0, 
                    	        		"ML_COMMENT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleDetail313); 

                    createLeafNode(grammarAccess.getDetailAccess().getDetailKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:237:1: ( ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=13 && LA6_0<=15)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:238:1: ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:238:1: ( (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:239:1: (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:239:1: (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' )
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
                            new NoViableAltException("239:1: (lv_visibility_2_1= 'private' | lv_visibility_2_2= 'protected' | lv_visibility_2_3= 'public' )", 5, 0, input);

                        throw nvae;
                    }

                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:240:3: lv_visibility_2_1= 'private'
                            {
                            lv_visibility_2_1=(Token)input.LT(1);
                            match(input,13,FOLLOW_13_in_ruleDetail333); 

                                    createLeafNode(grammarAccess.getDetailAccess().getVisibilityPrivateKeyword_2_0_0(), "visibility"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getDetailRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "visibility", lv_visibility_2_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:258:8: lv_visibility_2_2= 'protected'
                            {
                            lv_visibility_2_2=(Token)input.LT(1);
                            match(input,14,FOLLOW_14_in_ruleDetail362); 

                                    createLeafNode(grammarAccess.getDetailAccess().getVisibilityProtectedKeyword_2_0_1(), "visibility"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getDetailRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "visibility", lv_visibility_2_2, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:276:8: lv_visibility_2_3= 'public'
                            {
                            lv_visibility_2_3=(Token)input.LT(1);
                            match(input,15,FOLLOW_15_in_ruleDetail391); 

                                    createLeafNode(grammarAccess.getDetailAccess().getVisibilityPublicKeyword_2_0_2(), "visibility"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getDetailRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "visibility", lv_visibility_2_3, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:297:3: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:298:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:298:1: ( ruleFQN )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:299:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDetailRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getDetailAccess().getDetailClassModelCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleDetail431);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }


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
    // $ANTLR end ruleDetail


    // $ANTLR start entryRuleAssociatedDetail
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:320:1: entryRuleAssociatedDetail returns [EObject current=null] : iv_ruleAssociatedDetail= ruleAssociatedDetail EOF ;
    public final EObject entryRuleAssociatedDetail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociatedDetail = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:320:58: (iv_ruleAssociatedDetail= ruleAssociatedDetail EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:321:2: iv_ruleAssociatedDetail= ruleAssociatedDetail EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociatedDetailRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssociatedDetail_in_entryRuleAssociatedDetail464);
            iv_ruleAssociatedDetail=ruleAssociatedDetail();
            _fsp--;

             current =iv_ruleAssociatedDetail; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociatedDetail474); 

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
    // $ANTLR end entryRuleAssociatedDetail


    // $ANTLR start ruleAssociatedDetail
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:328:1: ruleAssociatedDetail returns [EObject current=null] : ( 'associated' ( ( ( RULE_ID | ruleFQN ) ) ) ';' ) ;
    public final EObject ruleAssociatedDetail() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:333:6: ( ( 'associated' ( ( ( RULE_ID | ruleFQN ) ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:334:1: ( 'associated' ( ( ( RULE_ID | ruleFQN ) ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:334:1: ( 'associated' ( ( ( RULE_ID | ruleFQN ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:334:3: 'associated' ( ( ( RULE_ID | ruleFQN ) ) ) ';'
            {
            match(input,16,FOLLOW_16_in_ruleAssociatedDetail509); 

                    createLeafNode(grammarAccess.getAssociatedDetailAccess().getAssociatedKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:338:1: ( ( ( RULE_ID | ruleFQN ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:339:1: ( ( RULE_ID | ruleFQN ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:339:1: ( ( RULE_ID | ruleFQN ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:340:3: ( RULE_ID | ruleFQN )
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAssociatedDetailRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:346:3: ( RULE_ID | ruleFQN )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==17) ) {
                    alt7=1;
                }
                else if ( (LA7_1==18) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("346:3: ( RULE_ID | ruleFQN )", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("346:3: ( RULE_ID | ruleFQN )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:346:5: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociatedDetail530); 

                    		createLeafNode(grammarAccess.getAssociatedDetailAccess().getDetailClassModelCrossReference_1_0(), "detailClass"); 
                    	

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:351:8: ruleFQN
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAssociatedDetailAccess().getDetailClassModelCrossReference_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleAssociatedDetail547);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

            match(input,17,FOLLOW_17_in_ruleAssociatedDetail559); 

                    createLeafNode(grammarAccess.getAssociatedDetailAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleAssociatedDetail


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:371:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:371:44: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:372:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN593);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN604); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:379:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:384:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:385:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:385:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:385:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN644); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:392:1: (kw= '.' this_ID_2= RULE_ID )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g:393:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,18,FOLLOW_18_in_ruleFQN663); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN678); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // $ANTLR end ruleFQN


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel137 = new BitSet(new long[]{0x0000000000011020L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleModel161 = new BitSet(new long[]{0x0000000000011020L});
    public static final BitSet FOLLOW_ruleDetail_in_ruleModel187 = new BitSet(new long[]{0x0000000000011022L});
    public static final BitSet FOLLOW_ruleAssociatedDetail_in_ruleModel206 = new BitSet(new long[]{0x0000000000011022L});
    public static final BitSet FOLLOW_ruleDetail_in_entryRuleDetail245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetail255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleDetail297 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDetail313 = new BitSet(new long[]{0x000000000000E010L});
    public static final BitSet FOLLOW_13_in_ruleDetail333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14_in_ruleDetail362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15_in_ruleDetail391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDetail431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociatedDetail_in_entryRuleAssociatedDetail464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociatedDetail474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleAssociatedDetail509 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociatedDetail530 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleAssociatedDetail547 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAssociatedDetail559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN644 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFQN663 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN678 = new BitSet(new long[]{0x0000000000040002L});

}
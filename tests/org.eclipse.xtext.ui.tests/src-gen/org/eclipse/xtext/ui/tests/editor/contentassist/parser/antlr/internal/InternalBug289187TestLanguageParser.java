package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug289187TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug289187TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract'", "'transient'", "'class'", "'extends'", "'implements'", "','", "'{'", "'classNumber'", "'='", "'quid'", "'documentation'", "'}'", "'attribute'", "'operation'", "'PRIVATE'", "'PROTECTED'", "'PACKAGE_PRIVATE'", "'PUBLIC'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug289187TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g"; }



     	private Bug289187TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289187TestLanguageParser(TokenStream input, IAstFactory factory, Bug289187TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:74:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:75:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:82:1: ruleModel returns [EObject current=null] : ( (lv_classes_0_0= ruleClass ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_classes_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:88:6: ( ( (lv_classes_0_0= ruleClass ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:89:1: ( (lv_classes_0_0= ruleClass ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:89:1: ( (lv_classes_0_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:90:1: (lv_classes_0_0= ruleClass )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:90:1: (lv_classes_0_0= ruleClass )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:91:3: lv_classes_0_0= ruleClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getClassesClassParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleClass_in_ruleModel130);
            	    lv_classes_0_0=ruleClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"classes",
            	    	        		lv_classes_0_0, 
            	    	        		"Class", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start entryRuleClass
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:121:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:122:2: (iv_ruleClass= ruleClass EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:123:2: iv_ruleClass= ruleClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getClassRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleClass_in_entryRuleClass166);
            iv_ruleClass=ruleClass();
            _fsp--;

             current =iv_ruleClass; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleClass176); 

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
    // $ANTLR end entryRuleClass


    // $ANTLR start ruleClass
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:130:1: ruleClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? 'class' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ( 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )* )? '{' ( 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? ( 'quid' '=' ( (lv_quid_17_0= RULE_INT ) ) )? ( 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token lv_transient_1_0=null;
        Token lv_name_3_0=null;
        Token lv_classNumber_14_0=null;
        Token lv_quid_17_0=null;
        Token lv_documentation_20_0=null;
        EObject lv_attributes_21_0 = null;

        EObject lv_operations_22_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:136:6: ( ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? 'class' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ( 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )* )? '{' ( 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? ( 'quid' '=' ( (lv_quid_17_0= RULE_INT ) ) )? ( 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:137:1: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? 'class' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ( 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )* )? '{' ( 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? ( 'quid' '=' ( (lv_quid_17_0= RULE_INT ) ) )? ( 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:137:1: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? 'class' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ( 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )* )? '{' ( 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? ( 'quid' '=' ( (lv_quid_17_0= RULE_INT ) ) )? ( 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:137:2: ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? 'class' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ( 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )* )? '{' ( 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? ( 'quid' '=' ( (lv_quid_17_0= RULE_INT ) ) )? ( 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:137:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:138:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:138:1: (lv_abstract_0_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:139:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleClass219); 

                            createLeafNode(grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:158:3: ( (lv_transient_1_0= 'transient' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:159:1: (lv_transient_1_0= 'transient' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:159:1: (lv_transient_1_0= 'transient' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:160:3: lv_transient_1_0= 'transient'
                    {
                    lv_transient_1_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleClass251); 

                            createLeafNode(grammarAccess.getClassAccess().getTransientTransientKeyword_1_0(), "transient"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "transient", true, "transient", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleClass275); 

                    createLeafNode(grammarAccess.getClassAccess().getClassKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:183:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:184:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:184:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:185:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass292); 

            			createLeafNode(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:207:2: ( 'extends' ( ( RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:207:4: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleClass308); 

                            createLeafNode(grammarAccess.getClassAccess().getExtendsKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:211:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:212:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:212:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:213:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass326); 

                    		createLeafNode(grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0(), "superClass"); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:225:4: ( 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:225:6: 'implements' ( ( RULE_ID ) ) ( ',' 'implements' ( ( RULE_ID ) ) )*
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleClass339); 

                            createLeafNode(grammarAccess.getClassAccess().getImplementsKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:229:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:230:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:230:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:231:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass357); 

                    		createLeafNode(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0(), "implementedInterfaces"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:243:2: ( ',' 'implements' ( ( RULE_ID ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:243:4: ',' 'implements' ( ( RULE_ID ) )
                    	    {
                    	    match(input,16,FollowSets000.FOLLOW_16_in_ruleClass368); 

                    	            createLeafNode(grammarAccess.getClassAccess().getCommaKeyword_5_2_0(), null); 
                    	        
                    	    match(input,15,FollowSets000.FOLLOW_15_in_ruleClass378); 

                    	            createLeafNode(grammarAccess.getClassAccess().getImplementsKeyword_5_2_1(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:251:1: ( ( RULE_ID ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:252:1: ( RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:252:1: ( RULE_ID )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:253:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass396); 

                    	    		createLeafNode(grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0(), "implementedInterfaces"); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleClass410); 

                    createLeafNode(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:269:1: ( 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:269:3: 'classNumber' '=' ( (lv_classNumber_14_0= RULE_INT ) )
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleClass421); 

                            createLeafNode(grammarAccess.getClassAccess().getClassNumberKeyword_7_0(), null); 
                        
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleClass431); 

                            createLeafNode(grammarAccess.getClassAccess().getEqualsSignKeyword_7_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:277:1: ( (lv_classNumber_14_0= RULE_INT ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:278:1: (lv_classNumber_14_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:278:1: (lv_classNumber_14_0= RULE_INT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:279:3: lv_classNumber_14_0= RULE_INT
                    {
                    lv_classNumber_14_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleClass448); 

                    			createLeafNode(grammarAccess.getClassAccess().getClassNumberINTTerminalRuleCall_7_2_0(), "classNumber"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"classNumber",
                    	        		lv_classNumber_14_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:301:4: ( 'quid' '=' ( (lv_quid_17_0= RULE_INT ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:301:6: 'quid' '=' ( (lv_quid_17_0= RULE_INT ) )
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleClass466); 

                            createLeafNode(grammarAccess.getClassAccess().getQuidKeyword_8_0(), null); 
                        
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleClass476); 

                            createLeafNode(grammarAccess.getClassAccess().getEqualsSignKeyword_8_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:309:1: ( (lv_quid_17_0= RULE_INT ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:310:1: (lv_quid_17_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:310:1: (lv_quid_17_0= RULE_INT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:311:3: lv_quid_17_0= RULE_INT
                    {
                    lv_quid_17_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleClass493); 

                    			createLeafNode(grammarAccess.getClassAccess().getQuidINTTerminalRuleCall_8_2_0(), "quid"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"quid",
                    	        		lv_quid_17_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:333:4: ( 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:333:6: 'documentation' '=' ( (lv_documentation_20_0= RULE_STRING ) )
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleClass511); 

                            createLeafNode(grammarAccess.getClassAccess().getDocumentationKeyword_9_0(), null); 
                        
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleClass521); 

                            createLeafNode(grammarAccess.getClassAccess().getEqualsSignKeyword_9_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:341:1: ( (lv_documentation_20_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:342:1: (lv_documentation_20_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:342:1: (lv_documentation_20_0= RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:343:3: lv_documentation_20_0= RULE_STRING
                    {
                    lv_documentation_20_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleClass538); 

                    			createLeafNode(grammarAccess.getClassAccess().getDocumentationSTRINGTerminalRuleCall_9_2_0(), "documentation"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"documentation",
                    	        		lv_documentation_20_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:365:4: ( (lv_attributes_21_0= ruleAttribute ) )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA10_4 = input.LA(2);

                    if ( (LA10_4==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 23:
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:366:1: (lv_attributes_21_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:366:1: (lv_attributes_21_0= ruleAttribute )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:367:3: lv_attributes_21_0= ruleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_10_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleClass566);
            	    lv_attributes_21_0=ruleAttribute();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"attributes",
            	    	        		lv_attributes_21_0, 
            	    	        		"Attribute", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:389:3: ( (lv_operations_22_0= ruleOperation ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=24 && LA11_0<=28)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:390:1: (lv_operations_22_0= ruleOperation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:390:1: (lv_operations_22_0= ruleOperation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:391:3: lv_operations_22_0= ruleOperation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getOperationsOperationParserRuleCall_11_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleOperation_in_ruleClass588);
            	    lv_operations_22_0=ruleOperation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"operations",
            	    	        		lv_operations_22_0, 
            	    	        		"Operation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(input,22,FollowSets000.FOLLOW_22_in_ruleClass599); 

                    createLeafNode(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_12(), null); 
                

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
    // $ANTLR end ruleClass


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:425:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:426:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:427:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute635);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute645); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:434:1: ruleAttribute returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? 'attribute' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:440:6: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? 'attribute' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:441:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? 'attribute' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:441:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? 'attribute' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:441:2: ( (lv_visibility_0_0= ruleVisibility ) )? 'attribute' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:441:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=25 && LA12_0<=28)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:442:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:442:1: (lv_visibility_0_0= ruleVisibility )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:443:3: lv_visibility_0_0= ruleVisibility
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getVisibilityVisibilityEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_ruleAttribute691);
                    lv_visibility_0_0=ruleVisibility();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"visibility",
                    	        		lv_visibility_0_0, 
                    	        		"Visibility", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleAttribute702); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttributeKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:469:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:470:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:470:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:471:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute719); 

            			createLeafNode(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:501:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:502:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:503:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_in_entryRuleOperation760);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation770); 

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
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:510:1: ruleOperation returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:516:6: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:517:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:517:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:517:2: ( (lv_visibility_0_0= ruleVisibility ) )? 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:517:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=25 && LA13_0<=28)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:518:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:518:1: (lv_visibility_0_0= ruleVisibility )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:519:3: lv_visibility_0_0= ruleVisibility
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_ruleOperation816);
                    lv_visibility_0_0=ruleVisibility();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"visibility",
                    	        		lv_visibility_0_0, 
                    	        		"Visibility", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation827); 

                    createLeafNode(grammarAccess.getOperationAccess().getOperationKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:545:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:546:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:546:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:547:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation844); 

            			createLeafNode(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleOperation


    // $ANTLR start ruleVisibility
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:577:1: ruleVisibility returns [Enumerator current=null] : ( ( 'PRIVATE' ) | ( 'PROTECTED' ) | ( 'PACKAGE_PRIVATE' ) | ( 'PUBLIC' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:581:6: ( ( ( 'PRIVATE' ) | ( 'PROTECTED' ) | ( 'PACKAGE_PRIVATE' ) | ( 'PUBLIC' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:582:1: ( ( 'PRIVATE' ) | ( 'PROTECTED' ) | ( 'PACKAGE_PRIVATE' ) | ( 'PUBLIC' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:582:1: ( ( 'PRIVATE' ) | ( 'PROTECTED' ) | ( 'PACKAGE_PRIVATE' ) | ( 'PUBLIC' ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt14=1;
                }
                break;
            case 26:
                {
                alt14=2;
                }
                break;
            case 27:
                {
                alt14=3;
                }
                break;
            case 28:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("582:1: ( ( 'PRIVATE' ) | ( 'PROTECTED' ) | ( 'PACKAGE_PRIVATE' ) | ( 'PUBLIC' ) )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:582:2: ( 'PRIVATE' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:582:2: ( 'PRIVATE' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:582:4: 'PRIVATE'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleVisibility897); 

                            current = grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:588:6: ( 'PROTECTED' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:588:6: ( 'PROTECTED' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:588:8: 'PROTECTED'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleVisibility912); 

                            current = grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:594:6: ( 'PACKAGE_PRIVATE' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:594:6: ( 'PACKAGE_PRIVATE' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:594:8: 'PACKAGE_PRIVATE'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_ruleVisibility927); 

                            current = grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:600:6: ( 'PUBLIC' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:600:6: ( 'PUBLIC' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:600:8: 'PUBLIC'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_ruleVisibility942); 

                            current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end ruleVisibility


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClass_in_ruleModel130 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_ruleClass_in_entryRuleClass166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleClass176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleClass219 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleClass251 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleClass275 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass292 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_14_in_ruleClass308 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass326 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_15_in_ruleClass339 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass357 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleClass368 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleClass378 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass396 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleClass410 = new BitSet(new long[]{0x000000001FF40000L});
        public static final BitSet FOLLOW_18_in_ruleClass421 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleClass431 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleClass448 = new BitSet(new long[]{0x000000001FF00000L});
        public static final BitSet FOLLOW_20_in_ruleClass466 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleClass476 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleClass493 = new BitSet(new long[]{0x000000001FE00000L});
        public static final BitSet FOLLOW_21_in_ruleClass511 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleClass521 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleClass538 = new BitSet(new long[]{0x000000001FC00000L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleClass566 = new BitSet(new long[]{0x000000001FC00000L});
        public static final BitSet FOLLOW_ruleOperation_in_ruleClass588 = new BitSet(new long[]{0x000000001F400000L});
        public static final BitSet FOLLOW_22_in_ruleClass599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute635 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_ruleAttribute691 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleAttribute702 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation760 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_ruleOperation816 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation827 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleVisibility897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleVisibility912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleVisibility927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleVisibility942 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.ui.common.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.Bug288760TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug288760TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_START_TAG", "RULE_END_TAG_SHORT", "RULE_GT", "RULE_END_TAG", "RULE_ID", "RULE_EQ", "RULE_STRING", "RULE_ML_COMMENT", "RULE_LT", "RULE_END_TAG_START", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_START_TAG=4;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=8;
    public static final int RULE_WS=15;
    public static final int RULE_END_TAG_START=13;
    public static final int RULE_INT=14;
    public static final int RULE_EQ=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=10;
    public static final int RULE_END_TAG_SHORT=5;
    public static final int RULE_LT=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_GT=6;
    public static final int RULE_END_TAG=7;

        public InternalBug288760TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g"; }



     	private Bug288760TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug288760TestLanguageParser(TokenStream input, IAstFactory factory, Bug288760TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "WorkflowElement";	
       	} 



    // $ANTLR start entryRuleWorkflowElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:72:1: entryRuleWorkflowElement returns [EObject current=null] : iv_ruleWorkflowElement= ruleWorkflowElement EOF ;
    public final EObject entryRuleWorkflowElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflowElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:73:2: (iv_ruleWorkflowElement= ruleWorkflowElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:74:2: iv_ruleWorkflowElement= ruleWorkflowElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWorkflowElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWorkflowElement_in_entryRuleWorkflowElement75);
            iv_ruleWorkflowElement=ruleWorkflowElement();
            _fsp--;

             current =iv_ruleWorkflowElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWorkflowElement85); 

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
    // $ANTLR end entryRuleWorkflowElement


    // $ANTLR start ruleWorkflowElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:81:1: ruleWorkflowElement returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) ) ;
    public final EObject ruleWorkflowElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_3_0=null;
        Token lv_end_7_0=null;
        EObject lv_attributes_1_0 = null;

        EObject lv_attributes_4_0 = null;

        EObject lv_children_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:86:6: ( ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:87:1: ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:87:1: ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:87:2: ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:87:2: ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:87:3: ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:87:3: ( (lv_name_0_0= RULE_START_TAG ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:88:1: (lv_name_0_0= RULE_START_TAG )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:88:1: (lv_name_0_0= RULE_START_TAG )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:89:3: lv_name_0_0= RULE_START_TAG
                    {
                    lv_name_0_0=(Token)input.LT(1);
                    match(input,RULE_START_TAG,FollowSets000.FOLLOW_RULE_START_TAG_in_ruleWorkflowElement128); 

                    			createLeafNode(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_0_0_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getWorkflowElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_0_0, 
                    	        		"START_TAG", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:111:2: ( (lv_attributes_1_0= ruleAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:112:1: (lv_attributes_1_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:112:1: (lv_attributes_1_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:113:3: lv_attributes_1_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleWorkflowElement154);
                    	    lv_attributes_1_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWorkflowElementRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_1_0, 
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
                    	    break loop1;
                        }
                    } while (true);

                    match(input,RULE_END_TAG_SHORT,FollowSets000.FOLLOW_RULE_END_TAG_SHORT_in_ruleWorkflowElement164); 
                     
                        createLeafNode(grammarAccess.getWorkflowElementAccess().getEND_TAG_SHORTTerminalRuleCall_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:140:6: ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:140:6: ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:140:7: ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:140:7: ( (lv_name_3_0= RULE_START_TAG ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:141:1: (lv_name_3_0= RULE_START_TAG )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:141:1: (lv_name_3_0= RULE_START_TAG )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:142:3: lv_name_3_0= RULE_START_TAG
                    {
                    lv_name_3_0=(Token)input.LT(1);
                    match(input,RULE_START_TAG,FollowSets000.FOLLOW_RULE_START_TAG_in_ruleWorkflowElement188); 

                    			createLeafNode(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_1_0_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getWorkflowElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_3_0, 
                    	        		"START_TAG", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:164:2: ( (lv_attributes_4_0= ruleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:165:1: (lv_attributes_4_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:165:1: (lv_attributes_4_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:166:3: lv_attributes_4_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleWorkflowElement214);
                    	    lv_attributes_4_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWorkflowElementRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_4_0, 
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
                    	    break loop2;
                        }
                    } while (true);

                    match(input,RULE_GT,FollowSets000.FOLLOW_RULE_GT_in_ruleWorkflowElement224); 
                     
                        createLeafNode(grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:192:1: ( (lv_children_6_0= ruleWorkflowElement ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_START_TAG) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:193:1: (lv_children_6_0= ruleWorkflowElement )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:193:1: (lv_children_6_0= ruleWorkflowElement )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:194:3: lv_children_6_0= ruleWorkflowElement
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWorkflowElementAccess().getChildrenWorkflowElementParserRuleCall_1_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWorkflowElement_in_ruleWorkflowElement244);
                    	    lv_children_6_0=ruleWorkflowElement();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWorkflowElementRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"children",
                    	    	        		lv_children_6_0, 
                    	    	        		"WorkflowElement", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:216:3: ( (lv_end_7_0= RULE_END_TAG ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:217:1: (lv_end_7_0= RULE_END_TAG )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:217:1: (lv_end_7_0= RULE_END_TAG )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:218:3: lv_end_7_0= RULE_END_TAG
                    {
                    lv_end_7_0=(Token)input.LT(1);
                    match(input,RULE_END_TAG,FollowSets000.FOLLOW_RULE_END_TAG_in_ruleWorkflowElement262); 

                    			createLeafNode(grammarAccess.getWorkflowElementAccess().getEndEND_TAGTerminalRuleCall_1_4_0(), "end"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getWorkflowElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"end",
                    	        		lv_end_7_0, 
                    	        		"END_TAG", 
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
    // $ANTLR end ruleWorkflowElement


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:248:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:249:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:250:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute304);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute314); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:257:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_value_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:262:6: ( ( ( (lv_name_0_0= RULE_ID ) ) RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:263:1: ( ( (lv_name_0_0= RULE_ID ) ) RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:263:1: ( ( (lv_name_0_0= RULE_ID ) ) RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:263:2: ( (lv_name_0_0= RULE_ID ) ) RULE_EQ ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:263:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:264:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:264:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:265:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute356); 

            			createLeafNode(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,RULE_EQ,FollowSets000.FOLLOW_RULE_EQ_in_ruleAttribute370); 
             
                createLeafNode(grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:291:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:292:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:292:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug288760TestLanguage.g:293:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute386); 

            			createLeafNode(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"STRING", 
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


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\7\uffff";
    static final String DFA4_eofS =
        "\7\uffff";
    static final String DFA4_minS =
        "\1\4\1\5\1\11\2\uffff\1\12\1\5";
    static final String DFA4_maxS =
        "\1\4\1\10\1\11\2\uffff\1\12\1\10";
    static final String DFA4_acceptS =
        "\3\uffff\1\1\1\2\2\uffff";
    static final String DFA4_specialS =
        "\7\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\3\1\4\1\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\3\1\4\1\uffff\1\2"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "87:1: ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleWorkflowElement_in_entryRuleWorkflowElement75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWorkflowElement85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_START_TAG_in_ruleWorkflowElement128 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleWorkflowElement154 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_RULE_END_TAG_SHORT_in_ruleWorkflowElement164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_START_TAG_in_ruleWorkflowElement188 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleWorkflowElement214 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_RULE_GT_in_ruleWorkflowElement224 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_ruleWorkflowElement_in_ruleWorkflowElement244 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_RULE_END_TAG_in_ruleWorkflowElement262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute356 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_EQ_in_ruleAttribute370 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute386 = new BitSet(new long[]{0x0000000000000002L});
    }


}
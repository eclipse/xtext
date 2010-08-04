package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug291022TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "':'", "';'", "'='"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBug291022TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g"; }



     	private Bug291022TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug291022TestLanguageParser(TokenStream input, IAstFactory factory, Bug291022TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootModel";	
       	}
       	
       	@Override
       	protected Bug291022TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRootModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:77:1: entryRuleRootModel returns [EObject current=null] : iv_ruleRootModel= ruleRootModel EOF ;
    public final EObject entryRuleRootModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:78:2: (iv_ruleRootModel= ruleRootModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:79:2: iv_ruleRootModel= ruleRootModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRootModel_in_entryRuleRootModel75);
            iv_ruleRootModel=ruleRootModel();
            _fsp--;

             current =iv_ruleRootModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootModel85); 

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
    // $ANTLR end entryRuleRootModel


    // $ANTLR start ruleRootModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:86:1: ruleRootModel returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_ID ) )? ( '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}' )? )? ;
    public final EObject ruleRootModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_elements_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:91:6: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_ID ) )? ( '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}' )? )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:92:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_ID ) )? ( '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}' )? )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:92:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_ID ) )? ( '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}' )? )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:92:2: () ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_ID ) )? ( '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}' )?
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:92:2: ()
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:93:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRootModelAccess().getRootModelAction_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRootModelAccess().getRootModelAction_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:103:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:104:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:104:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:105:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRootModel136); 

                    			createLeafNode(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRootModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:127:2: ( ( RULE_ID ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ID) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:128:1: ( RULE_ID )
                            {
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:128:1: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:129:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getRootModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRootModel159); 

                            		createLeafNode(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0(), "type"); 
                            	

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:141:3: ( '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==11) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:141:5: '{' ( (lv_elements_4_0= ruleModelAttribute ) )* '}'
                            {
                            match(input,11,FollowSets000.FOLLOW_11_in_ruleRootModel171); 

                                    createLeafNode(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0(), null); 
                                
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:145:1: ( (lv_elements_4_0= ruleModelAttribute ) )*
                            loop2:
                            do {
                                int alt2=2;
                                int LA2_0 = input.LA(1);

                                if ( (LA2_0==RULE_ID) ) {
                                    alt2=1;
                                }


                                switch (alt2) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:146:1: (lv_elements_4_0= ruleModelAttribute )
                            	    {
                            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:146:1: (lv_elements_4_0= ruleModelAttribute )
                            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:147:3: lv_elements_4_0= ruleModelAttribute
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_ruleRootModel192);
                            	    lv_elements_4_0=ruleModelAttribute();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getRootModelRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"elements",
                            	    	        		lv_elements_4_0, 
                            	    	        		"ModelAttribute", 
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

                            match(input,12,FollowSets000.FOLLOW_12_in_ruleRootModel203); 

                                    createLeafNode(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2(), null); 
                                

                            }
                            break;

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
    // $ANTLR end ruleRootModel


    // $ANTLR start entryRuleModelElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:181:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:182:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:183:2: iv_ruleModelElement= ruleModelElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement242);
            iv_ruleModelElement=ruleModelElement();
            _fsp--;

             current =iv_ruleModelElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement252); 

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
    // $ANTLR end entryRuleModelElement


    // $ANTLR start ruleModelElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:190:1: ruleModelElement returns [EObject current=null] : ( ( ( RULE_ID ) ) ( ':' ( (lv_name_2_0= RULE_ID ) ) )? ( ( RULE_ID ) )? ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) ) ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_elements_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:195:6: ( ( ( ( RULE_ID ) ) ( ':' ( (lv_name_2_0= RULE_ID ) ) )? ( ( RULE_ID ) )? ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:196:1: ( ( ( RULE_ID ) ) ( ':' ( (lv_name_2_0= RULE_ID ) ) )? ( ( RULE_ID ) )? ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:196:1: ( ( ( RULE_ID ) ) ( ':' ( (lv_name_2_0= RULE_ID ) ) )? ( ( RULE_ID ) )? ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:196:2: ( ( RULE_ID ) ) ( ':' ( (lv_name_2_0= RULE_ID ) ) )? ( ( RULE_ID ) )? ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:196:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:197:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:197:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:198:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement295); 

            		createLeafNode(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0(), "firstReference"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:210:2: ( ':' ( (lv_name_2_0= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:210:4: ':' ( (lv_name_2_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModelElement306); 

                            createLeafNode(grammarAccess.getModelElementAccess().getColonKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:214:1: ( (lv_name_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:215:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:215:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:216:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement323); 

                    			createLeafNode(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
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
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:238:4: ( ( RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:239:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:239:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:240:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement348); 

                    		createLeafNode(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0(), "secondReference"); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:252:3: ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("252:3: ( ';' | ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' ) )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:252:5: ';'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModelElement360); 

                            createLeafNode(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:257:6: ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:257:6: ( '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:257:8: '{' ( (lv_elements_6_0= ruleModelAttribute ) )* '}'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModelElement377); 

                            createLeafNode(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:261:1: ( (lv_elements_6_0= ruleModelAttribute ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:262:1: (lv_elements_6_0= ruleModelAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:262:1: (lv_elements_6_0= ruleModelAttribute )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:263:3: lv_elements_6_0= ruleModelAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_ruleModelElement398);
                    	    lv_elements_6_0=ruleModelAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_6_0, 
                    	    	        		"ModelAttribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModelElement409); 

                            createLeafNode(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleModelElement


    // $ANTLR start entryRuleModelAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:297:1: entryRuleModelAttribute returns [EObject current=null] : iv_ruleModelAttribute= ruleModelAttribute EOF ;
    public final EObject entryRuleModelAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:298:2: (iv_ruleModelAttribute= ruleModelAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:299:2: iv_ruleModelAttribute= ruleModelAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute447);
            iv_ruleModelAttribute=ruleModelAttribute();
            _fsp--;

             current =iv_ruleModelAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelAttribute457); 

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
    // $ANTLR end entryRuleModelAttribute


    // $ANTLR start ruleModelAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:306:1: ruleModelAttribute returns [EObject current=null] : (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute ) ;
    public final EObject ruleModelAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_ModelElement_0 = null;

        EObject this_Attribute_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:311:6: ( (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:312:1: (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:312:1: (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==15) ) {
                    alt9=2;
                }
                else if ( (LA9_1==RULE_ID||LA9_1==11||(LA9_1>=13 && LA9_1<=14)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("312:1: (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute )", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("312:1: (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:313:5: this_ModelElement_0= ruleModelElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_ruleModelAttribute504);
                    this_ModelElement_0=ruleModelElement();
                    _fsp--;

                     
                            current = this_ModelElement_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:323:5: this_Attribute_1= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleModelAttribute531);
                    this_Attribute_1=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleModelAttribute


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:339:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:340:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:341:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute566);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute576); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:348:1: ruleAttribute returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:353:6: ( ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:354:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:354:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:354:2: ( ( RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:354:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:355:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:355:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:356:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute619); 

            		createLeafNode(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0(), "feature"); 
            	

            }


            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleAttribute629); 

                    createLeafNode(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:372:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:373:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:373:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:374:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute646); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRootModel_in_entryRuleRootModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRootModel136 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRootModel159 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_11_in_ruleRootModel171 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_ruleRootModel192 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleRootModel203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement295 = new BitSet(new long[]{0x0000000000006810L});
        public static final BitSet FOLLOW_13_in_ruleModelElement306 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement323 = new BitSet(new long[]{0x0000000000004810L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement348 = new BitSet(new long[]{0x0000000000004800L});
        public static final BitSet FOLLOW_14_in_ruleModelElement360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModelElement377 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_ruleModelElement398 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleModelElement409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute447 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelAttribute457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_ruleModelAttribute504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleModelAttribute531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute566 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute619 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleAttribute629 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute646 = new BitSet(new long[]{0x0000000000000002L});
    }


}
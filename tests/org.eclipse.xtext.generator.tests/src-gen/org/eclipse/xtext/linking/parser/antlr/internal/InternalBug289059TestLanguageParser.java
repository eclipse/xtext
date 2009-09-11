package org.eclipse.xtext.linking.parser.antlr.internal; 

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
import org.eclipse.xtext.linking.services.Bug289059TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug289059TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'enabled'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug289059TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g"; }


     
     	private Bug289059TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289059TestLanguageParser(TokenStream input, IAstFactory factory, Bug289059TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( ( RULE_ID ) )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_enabled_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:85:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:86:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:86:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:86:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:86:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:87:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:87:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:88:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel125); 

            			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:110:2: ( (lv_enabled_1_0= ruleUnassignedAction ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:111:1: (lv_enabled_1_0= ruleUnassignedAction )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:111:1: (lv_enabled_1_0= ruleUnassignedAction )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:112:3: lv_enabled_1_0= ruleUnassignedAction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getEnabledUnassignedActionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnassignedAction_in_ruleModel151);
                    lv_enabled_1_0=ruleUnassignedAction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"enabled",
                    	        		lv_enabled_1_0, 
                    	        		"UnassignedAction", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:134:3: ( ( RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:135:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:135:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:136:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel170); 

                    		createLeafNode(grammarAccess.getModelAccess().getReferenceModelCrossReference_2_0(), "reference"); 
                    	

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleUnassignedAction
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:155:1: entryRuleUnassignedAction returns [EObject current=null] : iv_ruleUnassignedAction= ruleUnassignedAction EOF ;
    public final EObject entryRuleUnassignedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:155:58: (iv_ruleUnassignedAction= ruleUnassignedAction EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:156:2: iv_ruleUnassignedAction= ruleUnassignedAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnassignedAction_in_entryRuleUnassignedAction204);
            iv_ruleUnassignedAction=ruleUnassignedAction();
            _fsp--;

             current =iv_ruleUnassignedAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnassignedAction214); 

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
    // $ANTLR end entryRuleUnassignedAction


    // $ANTLR start ruleUnassignedAction
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:163:1: ruleUnassignedAction returns [EObject current=null] : ( () 'enabled' ) ;
    public final EObject ruleUnassignedAction() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:168:6: ( ( () 'enabled' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:169:1: ( () 'enabled' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:169:1: ( () 'enabled' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:169:2: () 'enabled'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:169:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug289059TestLanguage.g:170:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnassignedActionAccess().getUnassignedActionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnassignedActionAccess().getUnassignedActionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,11,FOLLOW_11_in_ruleUnassignedAction257); 

                    createLeafNode(grammarAccess.getUnassignedActionAccess().getEnabledKeyword_1(), null); 
                

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
    // $ANTLR end ruleUnassignedAction


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel125 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ruleUnassignedAction_in_ruleModel151 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnassignedAction_in_entryRuleUnassignedAction204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleUnassignedAction257 = new BitSet(new long[]{0x0000000000000002L});

}
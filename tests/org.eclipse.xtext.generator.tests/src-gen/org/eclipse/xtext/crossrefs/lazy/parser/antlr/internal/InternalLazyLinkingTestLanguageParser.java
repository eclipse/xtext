package org.eclipse.xtext.crossrefs.lazy.parser.antlr.internal; 

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
import org.eclipse.xtext.crossrefs.lazy.services.LazyLinkingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLazyLinkingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'extends'", "'.'", "'for'", "'in'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalLazyLinkingTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g"; }


     
     	private LazyLinkingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLazyLinkingTestLanguageParser(TokenStream input, IAstFactory factory, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:69:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel71);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel81); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:77:1: ruleModel returns [EObject current=null] : (lv_types_0= ruleType )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:82:6: ( (lv_types_0= ruleType )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:83:1: (lv_types_0= ruleType )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:83:1: (lv_types_0= ruleType )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:6: lv_types_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleModel139);
            	    lv_types_0=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "types", lv_types_0, "Type", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:111:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:111:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:112:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType176);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType186); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:119:1: ruleType returns [EObject current=null] : ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* '}' ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_properties_11 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:124:6: ( ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:125:1: ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:125:1: ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:125:2: 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleType220); 

                    createLeafNode(grammarAccess.getTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:129:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:131:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType242); 

            		createLeafNode(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:149:2: ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:149:3: 'extends' ( RULE_ID ) '.' ( RULE_ID )
                    {
                    match(input,12,FOLLOW_12_in_ruleType260); 

                            createLeafNode(grammarAccess.getTypeAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:153:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:156:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType282); 

                    		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), "extends"); 
                    	

                    }

                    match(input,13,FOLLOW_13_in_ruleType294); 

                            createLeafNode(grammarAccess.getTypeAccess().getFullStopKeyword_2_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:173:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:176:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType316); 

                    		createLeafNode(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0(), "parentId"); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:189:4: ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:189:5: 'for' ( RULE_ID ) 'in' ( RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleType331); 

                            createLeafNode(grammarAccess.getTypeAccess().getForKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:193:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:196:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType353); 

                    		createLeafNode(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0(), "parentId"); 
                    	

                    }

                    match(input,15,FOLLOW_15_in_ruleType365); 

                            createLeafNode(grammarAccess.getTypeAccess().getInKeyword_3_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:213:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:216:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType387); 

                    		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0(), "extends"); 
                    	

                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleType401); 

                    createLeafNode(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:233:1: (lv_properties_11= ruleProperty )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:236:6: lv_properties_11= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleType435);
            	    lv_properties_11=ruleProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "properties", lv_properties_11, "Property", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,17,FOLLOW_17_in_ruleType449); 

                    createLeafNode(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_6(), null); 
                

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:265:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:265:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:266:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty482);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty492); 

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
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:273:1: ruleProperty returns [EObject current=null] : ( ( RULE_ID ) (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:278:6: ( ( ( RULE_ID ) (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:279:1: ( ( RULE_ID ) (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:279:1: ( ( RULE_ID ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:279:2: ( RULE_ID ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:279:2: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:282:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty539); 

            		createLeafNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), "type"); 
            	

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:295:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/crossrefs/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:297:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty564); 

            		createLeafNode(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleProperty


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleModel139 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleType220 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType242 = new BitSet(new long[]{0x0000000000015000L});
    public static final BitSet FOLLOW_12_in_ruleType260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType282 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType316 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleType331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType353 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleType365 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType387 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleType401 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleType435 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleType449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty564 = new BitSet(new long[]{0x0000000000000002L});

}
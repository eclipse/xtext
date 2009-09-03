package org.eclipse.xtext.linking.lazy.parser.antlr.internal; 

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
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLazyLinkingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'extends'", "'.'", "'for'", "'in'", "'{'", "'}'", "';'", "'unresolved'"
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g"; }


     
     	private LazyLinkingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLazyLinkingTestLanguageParser(TokenStream input, IAstFactory factory, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (lv_types_0_0= ruleType ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:85:6: ( ( (lv_types_0_0= ruleType ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:1: ( (lv_types_0_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:1: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:87:1: (lv_types_0_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:87:1: (lv_types_0_0= ruleType )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:88:3: lv_types_0_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleModel128);
            	    lv_types_0_0=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"types",
            	    	        		lv_types_0_0, 
            	    	        		"Type", 
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


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:117:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:117:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:118:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType161);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType171); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:125:1: ruleType returns [EObject current=null] : ( 'type' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )? ( 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) ) )? '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* '}' ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_properties_11_0 = null;

        EObject lv_unresolvedProxyProperty_12_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:130:6: ( ( 'type' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )? ( 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) ) )? '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:131:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )? ( 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) ) )? '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:131:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )? ( 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) ) )? '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:131:2: 'type' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )? ( 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) ) )? '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleType205); 

                    createLeafNode(grammarAccess.getTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:135:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:136:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:136:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:137:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType222); 

            			createLeafNode(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:159:2: ( 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:159:3: 'extends' ( ( RULE_ID ) ) '.' ( ( RULE_ID ) )
                    {
                    match(input,12,FOLLOW_12_in_ruleType237); 

                            createLeafNode(grammarAccess.getTypeAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:163:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:164:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:164:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:165:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType255); 

                    		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), "extends"); 
                    	

                    }


                    }

                    match(input,13,FOLLOW_13_in_ruleType264); 

                            createLeafNode(grammarAccess.getTypeAccess().getFullStopKeyword_2_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:181:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:182:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:182:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:183:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType282); 

                    		createLeafNode(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0(), "parentId"); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:195:4: ( 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:195:5: 'for' ( ( RULE_ID ) ) 'in' ( ( RULE_ID ) )
                    {
                    match(input,14,FOLLOW_14_in_ruleType294); 

                            createLeafNode(grammarAccess.getTypeAccess().getForKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:199:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:200:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:200:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:201:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType312); 

                    		createLeafNode(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0(), "parentId"); 
                    	

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleType321); 

                            createLeafNode(grammarAccess.getTypeAccess().getInKeyword_3_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:217:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:218:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:218:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:219:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType339); 

                    		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0(), "extends"); 
                    	

                    }


                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleType350); 

                    createLeafNode(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:235:1: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:236:1: (lv_properties_11_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:236:1: (lv_properties_11_0= ruleProperty )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:237:3: lv_properties_11_0= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleType371);
            	    lv_properties_11_0=ruleProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"properties",
            	    	        		lv_properties_11_0, 
            	    	        		"Property", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:259:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:260:1: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:260:1: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:261:3: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnresolvedProxyProperty_in_ruleType393);
            	    lv_unresolvedProxyProperty_12_0=ruleUnresolvedProxyProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"unresolvedProxyProperty",
            	    	        		lv_unresolvedProxyProperty_12_0, 
            	    	        		"UnresolvedProxyProperty", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,17,FOLLOW_17_in_ruleType403); 

                    createLeafNode(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_7(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:294:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:294:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:295:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty436);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty446); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:302:1: ruleProperty returns [EObject current=null] : ( ( ( RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:307:6: ( ( ( ( RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:308:1: ( ( ( RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:308:1: ( ( ( RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:308:2: ( ( RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:308:2: ( ( RULE_ID ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:309:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:309:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:310:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty489); 

            	    		createLeafNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), "type"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:322:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:323:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:323:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:324:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty507); 

            			createLeafNode(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleProperty521); 

                    createLeafNode(grammarAccess.getPropertyAccess().getSemicolonKeyword_2(), null); 
                

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


    // $ANTLR start entryRuleUnresolvedProxyProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:357:1: entryRuleUnresolvedProxyProperty returns [EObject current=null] : iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF ;
    public final EObject entryRuleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnresolvedProxyProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:357:65: (iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:358:2: iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnresolvedProxyPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty554);
            iv_ruleUnresolvedProxyProperty=ruleUnresolvedProxyProperty();
            _fsp--;

             current =iv_ruleUnresolvedProxyProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty564); 

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
    // $ANTLR end entryRuleUnresolvedProxyProperty


    // $ANTLR start ruleUnresolvedProxyProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:365:1: ruleUnresolvedProxyProperty returns [EObject current=null] : ( 'unresolved' ( ( RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:370:6: ( ( 'unresolved' ( ( RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:371:1: ( 'unresolved' ( ( RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:371:1: ( 'unresolved' ( ( RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:371:2: 'unresolved' ( ( RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) ';'
            {
            match(input,19,FOLLOW_19_in_ruleUnresolvedProxyProperty598); 

                    createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:375:1: ( ( RULE_ID ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==RULE_ID) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:376:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:376:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:377:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty616); 

            	    		createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0(), "type"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:389:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:390:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:390:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:391:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty634); 

            			createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleUnresolvedProxyProperty648); 

                    createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleUnresolvedProxyProperty


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleModel128 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleType205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType222 = new BitSet(new long[]{0x0000000000015000L});
    public static final BitSet FOLLOW_12_in_ruleType237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType255 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType282 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleType294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType312 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleType321 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType339 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleType350 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleType371 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_ruleType393 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleType403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty507 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleProperty521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleUnresolvedProxyProperty598 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty616 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty634 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnresolvedProxyProperty648 = new BitSet(new long[]{0x0000000000000002L});

}
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (lv_types_0= ruleType )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:85:6: ( (lv_types_0= ruleType )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:1: (lv_types_0= ruleType )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:1: (lv_types_0= ruleType )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:89:6: lv_types_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleModel141);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:114:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:114:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:115:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType178);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType188); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:122:1: ruleType returns [EObject current=null] : ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* (lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty )* '}' ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_properties_11 = null;

        EObject lv_unresolvedProxyProperty_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:127:6: ( ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* (lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:128:1: ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* (lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:128:1: ( 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* (lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:128:2: 'type' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )? ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )? '{' (lv_properties_11= ruleProperty )* (lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleType222); 

                    createLeafNode(grammarAccess.getTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:132:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:134:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType244); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:152:2: ( 'extends' ( RULE_ID ) '.' ( RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:152:3: 'extends' ( RULE_ID ) '.' ( RULE_ID )
                    {
                    match(input,12,FOLLOW_12_in_ruleType262); 

                            createLeafNode(grammarAccess.getTypeAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:156:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:159:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType284); 

                    		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), "extends"); 
                    	

                    }

                    match(input,13,FOLLOW_13_in_ruleType296); 

                            createLeafNode(grammarAccess.getTypeAccess().getFullStopKeyword_2_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:176:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:179:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType318); 

                    		createLeafNode(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0(), "parentId"); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:192:4: ( 'for' ( RULE_ID ) 'in' ( RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:192:5: 'for' ( RULE_ID ) 'in' ( RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleType333); 

                            createLeafNode(grammarAccess.getTypeAccess().getForKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:196:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:199:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType355); 

                    		createLeafNode(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0(), "parentId"); 
                    	

                    }

                    match(input,15,FOLLOW_15_in_ruleType367); 

                            createLeafNode(grammarAccess.getTypeAccess().getInKeyword_3_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:216:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:219:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType389); 

                    		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0(), "extends"); 
                    	

                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleType403); 

                    createLeafNode(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:236:1: (lv_properties_11= ruleProperty )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:239:6: lv_properties_11= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleType437);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:257:3: (lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:260:6: lv_unresolvedProxyProperty_12= ruleUnresolvedProxyProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnresolvedProxyProperty_in_ruleType476);
            	    lv_unresolvedProxyProperty_12=ruleUnresolvedProxyProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "unresolvedProxyProperty", lv_unresolvedProxyProperty_12, "UnresolvedProxyProperty", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,17,FOLLOW_17_in_ruleType490); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:289:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:289:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:290:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty523);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty533); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:297:1: ruleProperty returns [EObject current=null] : ( ( RULE_ID )+ (lv_name_1= RULE_ID ) ';' ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:302:6: ( ( ( RULE_ID )+ (lv_name_1= RULE_ID ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:303:1: ( ( RULE_ID )+ (lv_name_1= RULE_ID ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:303:1: ( ( RULE_ID )+ (lv_name_1= RULE_ID ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:303:2: ( RULE_ID )+ (lv_name_1= RULE_ID ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:303:2: ( RULE_ID )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:306:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty580); 

            	    		createLeafNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), "type"); 
            	    	

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:319:3: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:321:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty606); 

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

            match(input,18,FOLLOW_18_in_ruleProperty623); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:350:1: entryRuleUnresolvedProxyProperty returns [EObject current=null] : iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF ;
    public final EObject entryRuleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnresolvedProxyProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:350:65: (iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:351:2: iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnresolvedProxyPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty656);
            iv_ruleUnresolvedProxyProperty=ruleUnresolvedProxyProperty();
            _fsp--;

             current =iv_ruleUnresolvedProxyProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty666); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:358:1: ruleUnresolvedProxyProperty returns [EObject current=null] : ( 'unresolved' ( RULE_ID )+ (lv_name_2= RULE_ID ) ';' ) ;
    public final EObject ruleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:363:6: ( ( 'unresolved' ( RULE_ID )+ (lv_name_2= RULE_ID ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:364:1: ( 'unresolved' ( RULE_ID )+ (lv_name_2= RULE_ID ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:364:1: ( 'unresolved' ( RULE_ID )+ (lv_name_2= RULE_ID ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:364:2: 'unresolved' ( RULE_ID )+ (lv_name_2= RULE_ID ) ';'
            {
            match(input,19,FOLLOW_19_in_ruleUnresolvedProxyProperty700); 

                    createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:368:1: ( RULE_ID )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:371:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty722); 

            	    		createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0(), "type"); 
            	    	

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:384:3: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:386:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty748); 

            		createLeafNode(grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,18,FOLLOW_18_in_ruleUnresolvedProxyProperty765); 

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
    public static final BitSet FOLLOW_ruleType_in_ruleModel141 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleType222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType244 = new BitSet(new long[]{0x0000000000015000L});
    public static final BitSet FOLLOW_12_in_ruleType262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType284 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType318 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleType333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType355 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleType367 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType389 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleType403 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleType437 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_ruleType476 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleType490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty523 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty580 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty606 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleProperty623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleUnresolvedProxyProperty700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty748 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnresolvedProxyProperty765 = new BitSet(new long[]{0x0000000000000002L});

}
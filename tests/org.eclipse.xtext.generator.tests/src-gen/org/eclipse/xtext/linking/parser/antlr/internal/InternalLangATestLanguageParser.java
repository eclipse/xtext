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
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLangATestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalLangATestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g"; }


     
     	private LangATestLanguageGrammarAccess grammarAccess;
     	
        public InternalLangATestLanguageParser(TokenStream input, IAstFactory factory, LangATestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	} 



    // $ANTLR start entryRuleMain
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:72:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:72:46: (iv_ruleMain= ruleMain EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:73:2: iv_ruleMain= ruleMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMainRule(), currentNode); 
            pushFollow(FOLLOW_ruleMain_in_entryRuleMain73);
            iv_ruleMain=ruleMain();
            _fsp--;

             current =iv_ruleMain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMain83); 

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
    // $ANTLR end entryRuleMain


    // $ANTLR start ruleMain
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:80:1: ruleMain returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_types_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:85:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:86:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:86:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:87:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:87:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:88:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMain129);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMainRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_0_0, 
            	    	        		"Import", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:110:3: ( (lv_types_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:111:1: (lv_types_1_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:111:1: (lv_types_1_0= ruleType )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:112:3: lv_types_1_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleMain151);
            	    lv_types_1_0=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMainRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"types",
            	    	        		lv_types_1_0, 
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
            	    break loop2;
                }
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
    // $ANTLR end ruleMain


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:141:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:141:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:142:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport185);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport195); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:149:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_uri_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:154:6: ( ( 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:155:1: ( 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:155:1: ( 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:155:2: 'import' ( (lv_uri_1_0= RULE_STRING ) )
            {
            match(input,11,FOLLOW_11_in_ruleImport229); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:159:1: ( (lv_uri_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:160:1: (lv_uri_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:160:1: (lv_uri_1_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:161:3: lv_uri_1_0= RULE_STRING
            {
            lv_uri_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport246); 

            			createLeafNode(grammarAccess.getImportAccess().getUriSTRINGTerminalRuleCall_1_0(), "uri"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"uri",
            	        		lv_uri_1_0, 
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:190:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:190:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:191:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType284);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType294); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:198:1: ruleType returns [EObject current=null] : ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:203:6: ( ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:204:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:204:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:204:2: 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) )
            {
            match(input,12,FOLLOW_12_in_ruleType328); 

                    createLeafNode(grammarAccess.getTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:208:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:209:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:209:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:210:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType345); 

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

            match(input,13,FOLLOW_13_in_ruleType359); 

                    createLeafNode(grammarAccess.getTypeAccess().getExtendsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:236:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:237:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:237:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g:238:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType377); 

            		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0(), "extends"); 
            	

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
    // $ANTLR end ruleType


 

    public static final BitSet FOLLOW_ruleMain_in_entryRuleMain73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMain83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMain129 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleType_in_ruleMain151 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport185 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleType328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType345 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType359 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType377 = new BitSet(new long[]{0x0000000000000002L});

}
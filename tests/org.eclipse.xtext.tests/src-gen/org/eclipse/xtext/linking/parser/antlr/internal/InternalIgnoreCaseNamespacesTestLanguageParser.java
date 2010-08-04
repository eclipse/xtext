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
import org.eclipse.xtext.linking.services.IgnoreCaseNamespacesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIgnoreCaseNamespacesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g"; }



     	private IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input, IAstFactory factory, IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected IgnoreCaseNamespacesTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_elements_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:91:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:92:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:92:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:92:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:92:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:93:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:93:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:94:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel131);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:116:3: ( (lv_elements_1_0= ruleElement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:117:1: (lv_elements_1_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:117:1: (lv_elements_1_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:118:3: lv_elements_1_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel153);
            	    lv_elements_1_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_1_0, 
            	    	        		"Element", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:148:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:149:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:150:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport190);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport200); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:157:1: ruleImport returns [EObject current=null] : ( (lv_importedNamespace_0_0= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importedNamespace_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:162:6: ( ( (lv_importedNamespace_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:163:1: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:163:1: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:164:1: (lv_importedNamespace_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:164:1: (lv_importedNamespace_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:165:3: lv_importedNamespace_0_0= RULE_STRING
            {
            lv_importedNamespace_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImport241); 

            			createLeafNode(grammarAccess.getImportAccess().getImportedNamespaceSTRINGTerminalRuleCall_0(), "importedNamespace"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importedNamespace",
            	        		lv_importedNamespace_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:195:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:196:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:197:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement281);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement291); 

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:204:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? '{' ( (lv_elements_3_0= ruleElement ) )* '}' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:209:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? '{' ( (lv_elements_3_0= ruleElement ) )* '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:210:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? '{' ( (lv_elements_3_0= ruleElement ) )* '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:210:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? '{' ( (lv_elements_3_0= ruleElement ) )* '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:210:2: ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? '{' ( (lv_elements_3_0= ruleElement ) )* '}'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:210:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:211:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:211:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:212:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement333); 

            			createLeafNode(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:234:2: ( ( RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:235:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:235:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:236:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement356); 

                    		createLeafNode(grammarAccess.getElementAccess().getReferenceElementCrossReference_1_0(), "reference"); 
                    	

                    }


                    }
                    break;

            }

            match(input,11,FollowSets000.FOLLOW_11_in_ruleElement367); 

                    createLeafNode(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:252:1: ( (lv_elements_3_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:253:1: (lv_elements_3_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:253:1: (lv_elements_3_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g:254:3: lv_elements_3_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getElementsElementParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleElement388);
            	    lv_elements_3_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_3_0, 
            	    	        		"Element", 
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleElement399); 

                    createLeafNode(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleElement


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel153 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImport241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement333 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement356 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleElement367 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_ruleElement_in_ruleElement388 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_12_in_ruleElement399 = new BitSet(new long[]{0x0000000000000002L});
    }


}
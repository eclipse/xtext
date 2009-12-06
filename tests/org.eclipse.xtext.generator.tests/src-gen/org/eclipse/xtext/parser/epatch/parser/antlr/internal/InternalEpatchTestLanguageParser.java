package org.eclipse.xtext.parser.epatch.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEpatchTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_FRAGMENT", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'epatch'", "'{'", "'}'", "'import'", "'uri'", "'ns'", "'java'", "'.'", "'extension'", "'::'", "'resource'", "'left'", "';'", "'right'", "'object'", "'='", "'|'", "'['", "','", "']'", "':'", "'null'", "'new'", "'copy'", "'migrate'", "'as'", "'each'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_FRAGMENT=6;

        public InternalEpatchTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g"; }



     	private EpatchTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEpatchTestLanguageParser(TokenStream input, IAstFactory factory, EpatchTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EPatch";	
       	} 



    // $ANTLR start entryRuleEPatch
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:72:1: entryRuleEPatch returns [EObject current=null] : iv_ruleEPatch= ruleEPatch EOF ;
    public final EObject entryRuleEPatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPatch = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:72:48: (iv_ruleEPatch= ruleEPatch EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:73:2: iv_ruleEPatch= ruleEPatch EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPatchRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPatch_in_entryRuleEPatch73);
            iv_ruleEPatch=ruleEPatch();
            _fsp--;

             current =iv_ruleEPatch; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPatch83); 

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
    // $ANTLR end entryRuleEPatch


    // $ANTLR start ruleEPatch
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:80:1: ruleEPatch returns [EObject current=null] : ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_imports_3_0 = null;

        EObject lv_resources_4_0 = null;

        EObject lv_objects_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:85:6: ( ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:1: ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:1: ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:3: 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}'
            {
            match(input,12,FOLLOW_12_in_ruleEPatch118); 

                    createLeafNode(grammarAccess.getEPatchAccess().getEpatchKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPatch135); 

            			createLeafNode(grammarAccess.getEPatchAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
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

            match(input,13,FOLLOW_13_in_ruleEPatch150); 

                    createLeafNode(grammarAccess.getEPatchAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:118:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:119:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:119:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:120:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getImportsImportParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleEPatch171);
            	    lv_imports_3_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_3_0, 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:142:3: ( (lv_resources_4_0= ruleNamedResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:143:1: (lv_resources_4_0= ruleNamedResource )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:143:1: (lv_resources_4_0= ruleNamedResource )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:144:3: lv_resources_4_0= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getResourcesNamedResourceParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResource_in_ruleEPatch193);
            	    lv_resources_4_0=ruleNamedResource();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"resources",
            	    	        		lv_resources_4_0, 
            	    	        		"NamedResource", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:166:3: ( (lv_objects_5_0= ruleObjectRef ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:167:1: (lv_objects_5_0= ruleObjectRef )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:167:1: (lv_objects_5_0= ruleObjectRef )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:168:3: lv_objects_5_0= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getObjectsObjectRefParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleObjectRef_in_ruleEPatch215);
            	    lv_objects_5_0=ruleObjectRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"objects",
            	    	        		lv_objects_5_0, 
            	    	        		"ObjectRef", 
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

            match(input,14,FOLLOW_14_in_ruleEPatch226); 

                    createLeafNode(grammarAccess.getEPatchAccess().getRightCurlyBracketKeyword_6(), null); 
                

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
    // $ANTLR end ruleEPatch


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport259);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport269); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:209:1: ruleImport returns [EObject current=null] : (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport_0 = null;

        EObject this_JavaImport_1 = null;

        EObject this_ExtensionImport_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:214:6: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:215:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:215:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt4=1;
                    }
                    break;
                case 20:
                    {
                    alt4=3;
                    }
                    break;
                case 18:
                    {
                    alt4=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("215:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("215:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:216:5: this_ModelImport_0= ruleModelImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getModelImportParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleModelImport_in_ruleImport316);
                    this_ModelImport_0=ruleModelImport();
                    _fsp--;

                     
                            current = this_ModelImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:226:5: this_JavaImport_1= ruleJavaImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getJavaImportParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaImport_in_ruleImport343);
                    this_JavaImport_1=ruleJavaImport();
                    _fsp--;

                     
                            current = this_JavaImport_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:236:5: this_ExtensionImport_2= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getExtensionImportParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExtensionImport_in_ruleImport370);
                    this_ExtensionImport_2=ruleExtensionImport();
                    _fsp--;

                     
                            current = this_ExtensionImport_2; 
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleModelImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:251:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:251:53: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:252:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelImport_in_entryRuleModelImport402);
            iv_ruleModelImport=ruleModelImport();
            _fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelImport412); 

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
    // $ANTLR end entryRuleModelImport


    // $ANTLR start ruleModelImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:259:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport_0 = null;

        EObject this_EPackageImport_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:264:6: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:265:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:265:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==16) ) {
                        alt5=1;
                    }
                    else if ( (LA5_2==17) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("265:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("265:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("265:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:266:5: this_ResourceImport_0= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelImportAccess().getResourceImportParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceImport_in_ruleModelImport459);
                    this_ResourceImport_0=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:276:5: this_EPackageImport_1= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelImportAccess().getEPackageImportParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEPackageImport_in_ruleModelImport486);
                    this_EPackageImport_1=ruleEPackageImport();
                    _fsp--;

                     
                            current = this_EPackageImport_1; 
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
    // $ANTLR end ruleModelImport


    // $ANTLR start entryRuleResourceImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:291:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:291:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceImport_in_entryRuleResourceImport518);
            iv_ruleResourceImport=ruleResourceImport();
            _fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceImport528); 

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
    // $ANTLR end entryRuleResourceImport


    // $ANTLR start ruleResourceImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:299:1: ruleResourceImport returns [EObject current=null] : ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_uri_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:304:6: ( ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:305:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:305:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:305:3: 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) )
            {
            match(input,15,FOLLOW_15_in_ruleResourceImport563); 

                    createLeafNode(grammarAccess.getResourceImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:309:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:310:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:310:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:311:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceImport580); 

            			createLeafNode(grammarAccess.getResourceImportAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceImportRule().getType().getClassifier());
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

            match(input,16,FOLLOW_16_in_ruleResourceImport595); 

                    createLeafNode(grammarAccess.getResourceImportAccess().getUriKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:337:1: ( (lv_uri_3_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:338:1: (lv_uri_3_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:338:1: (lv_uri_3_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:339:3: lv_uri_3_0= RULE_STRING
            {
            lv_uri_3_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceImport612); 

            			createLeafNode(grammarAccess.getResourceImportAccess().getUriSTRINGTerminalRuleCall_3_0(), "uri"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"uri",
            	        		lv_uri_3_0, 
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
    // $ANTLR end ruleResourceImport


    // $ANTLR start entryRuleEPackageImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:368:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:368:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:369:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPackageImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport650);
            iv_ruleEPackageImport=ruleEPackageImport();
            _fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageImport660); 

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
    // $ANTLR end entryRuleEPackageImport


    // $ANTLR start ruleEPackageImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:376:1: ruleEPackageImport returns [EObject current=null] : ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_nsURI_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:381:6: ( ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:382:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:382:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:382:3: 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) )
            {
            match(input,15,FOLLOW_15_in_ruleEPackageImport695); 

                    createLeafNode(grammarAccess.getEPackageImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:386:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:387:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:387:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:388:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPackageImport712); 

            			createLeafNode(grammarAccess.getEPackageImportAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageImportRule().getType().getClassifier());
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

            match(input,17,FOLLOW_17_in_ruleEPackageImport727); 

                    createLeafNode(grammarAccess.getEPackageImportAccess().getNsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:414:1: ( (lv_nsURI_3_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:415:1: (lv_nsURI_3_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:415:1: (lv_nsURI_3_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:416:3: lv_nsURI_3_0= RULE_STRING
            {
            lv_nsURI_3_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageImport744); 

            			createLeafNode(grammarAccess.getEPackageImportAccess().getNsURISTRINGTerminalRuleCall_3_0(), "nsURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"nsURI",
            	        		lv_nsURI_3_0, 
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
    // $ANTLR end ruleEPackageImport


    // $ANTLR start entryRuleJavaImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:445:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:445:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:446:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaImport_in_entryRuleJavaImport782);
            iv_ruleJavaImport=ruleJavaImport();
            _fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaImport792); 

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
    // $ANTLR end entryRuleJavaImport


    // $ANTLR start ruleJavaImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:453:1: ruleJavaImport returns [EObject current=null] : ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2_0=null;
        Token lv_path_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:458:6: ( ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:459:1: ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:459:1: ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:459:3: 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )*
            {
            match(input,15,FOLLOW_15_in_ruleJavaImport827); 

                    createLeafNode(grammarAccess.getJavaImportAccess().getImportKeyword_0(), null); 
                
            match(input,18,FOLLOW_18_in_ruleJavaImport837); 

                    createLeafNode(grammarAccess.getJavaImportAccess().getJavaKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:467:1: ( (lv_path_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:468:1: (lv_path_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:468:1: (lv_path_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:469:3: lv_path_2_0= RULE_ID
            {
            lv_path_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport854); 

            			createLeafNode(grammarAccess.getJavaImportAccess().getPathIDTerminalRuleCall_2_0(), "path"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"path",
            	        		lv_path_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:491:2: ( '.' ( (lv_path_4_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:491:4: '.' ( (lv_path_4_0= RULE_ID ) )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleJavaImport870); 

            	            createLeafNode(grammarAccess.getJavaImportAccess().getFullStopKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:495:1: ( (lv_path_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:496:1: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:496:1: (lv_path_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:497:3: lv_path_4_0= RULE_ID
            	    {
            	    lv_path_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport887); 

            	    			createLeafNode(grammarAccess.getJavaImportAccess().getPathIDTerminalRuleCall_3_1_0(), "path"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getJavaImportRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"path",
            	    	        		lv_path_4_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end ruleJavaImport


    // $ANTLR start entryRuleExtensionImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:526:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:526:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:527:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtensionImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport927);
            iv_ruleExtensionImport=ruleExtensionImport();
            _fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtensionImport937); 

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
    // $ANTLR end entryRuleExtensionImport


    // $ANTLR start ruleExtensionImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:534:1: ruleExtensionImport returns [EObject current=null] : ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2_0=null;
        Token lv_path_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:539:6: ( ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:540:1: ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:540:1: ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:540:3: 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )*
            {
            match(input,15,FOLLOW_15_in_ruleExtensionImport972); 

                    createLeafNode(grammarAccess.getExtensionImportAccess().getImportKeyword_0(), null); 
                
            match(input,20,FOLLOW_20_in_ruleExtensionImport982); 

                    createLeafNode(grammarAccess.getExtensionImportAccess().getExtensionKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:548:1: ( (lv_path_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:549:1: (lv_path_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:549:1: (lv_path_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:550:3: lv_path_2_0= RULE_ID
            {
            lv_path_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport999); 

            			createLeafNode(grammarAccess.getExtensionImportAccess().getPathIDTerminalRuleCall_2_0(), "path"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExtensionImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"path",
            	        		lv_path_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:572:2: ( '::' ( (lv_path_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:572:4: '::' ( (lv_path_4_0= RULE_ID ) )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleExtensionImport1015); 

            	            createLeafNode(grammarAccess.getExtensionImportAccess().getColonColonKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:576:1: ( (lv_path_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:577:1: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:577:1: (lv_path_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:3: lv_path_4_0= RULE_ID
            	    {
            	    lv_path_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1032); 

            	    			createLeafNode(grammarAccess.getExtensionImportAccess().getPathIDTerminalRuleCall_3_1_0(), "path"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getExtensionImportRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"path",
            	    	        		lv_path_4_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end ruleExtensionImport


    // $ANTLR start entryRuleNamedResource
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:607:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:607:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:608:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedResourceRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedResource_in_entryRuleNamedResource1072);
            iv_ruleNamedResource=ruleNamedResource();
            _fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResource1082); 

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
    // $ANTLR end entryRuleNamedResource


    // $ANTLR start ruleNamedResource
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:615:1: ruleNamedResource returns [EObject current=null] : ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_leftUri_5_0=null;
        Token lv_rightUri_10_0=null;
        EObject lv_leftRoot_6_0 = null;

        EObject lv_rightRoot_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:620:6: ( ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:621:1: ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:621:1: ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:621:3: 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}'
            {
            match(input,22,FOLLOW_22_in_ruleNamedResource1117); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getResourceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:625:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:626:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:626:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:627:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedResource1134); 

            			createLeafNode(grammarAccess.getNamedResourceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
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

            match(input,13,FOLLOW_13_in_ruleNamedResource1149); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            match(input,23,FOLLOW_23_in_ruleNamedResource1159); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getLeftKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:657:1: ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=34 && LA8_0<=35)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("657:1: ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:657:2: ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:657:2: ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:657:4: 'uri' ( (lv_leftUri_5_0= RULE_STRING ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1171); 

                            createLeafNode(grammarAccess.getNamedResourceAccess().getUriKeyword_4_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:661:1: ( (lv_leftUri_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:662:1: (lv_leftUri_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:662:1: (lv_leftUri_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:663:3: lv_leftUri_5_0= RULE_STRING
                    {
                    lv_leftUri_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1188); 

                    			createLeafNode(grammarAccess.getNamedResourceAccess().getLeftUriSTRINGTerminalRuleCall_4_0_1_0(), "leftUri"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"leftUri",
                    	        		lv_leftUri_5_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:686:6: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:686:6: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:687:1: (lv_leftRoot_6_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:687:1: (lv_leftRoot_6_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:688:3: lv_leftRoot_6_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedResourceAccess().getLeftRootCreatedObjectParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1221);
                    lv_leftRoot_6_0=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"leftRoot",
                    	        		lv_leftRoot_6_0, 
                    	        		"CreatedObject", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1232); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getSemicolonKeyword_5(), null); 
                
            match(input,25,FOLLOW_25_in_ruleNamedResource1242); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getRightKeyword_6(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:718:1: ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=34 && LA9_0<=35)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("718:1: ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:718:2: ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:718:2: ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:718:4: 'uri' ( (lv_rightUri_10_0= RULE_STRING ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1254); 

                            createLeafNode(grammarAccess.getNamedResourceAccess().getUriKeyword_7_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:722:1: ( (lv_rightUri_10_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:723:1: (lv_rightUri_10_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:723:1: (lv_rightUri_10_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:724:3: lv_rightUri_10_0= RULE_STRING
                    {
                    lv_rightUri_10_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1271); 

                    			createLeafNode(grammarAccess.getNamedResourceAccess().getRightUriSTRINGTerminalRuleCall_7_0_1_0(), "rightUri"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightUri",
                    	        		lv_rightUri_10_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:747:6: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:747:6: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:1: (lv_rightRoot_11_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:1: (lv_rightRoot_11_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:749:3: lv_rightRoot_11_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedResourceAccess().getRightRootCreatedObjectParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1304);
                    lv_rightRoot_11_0=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightRoot",
                    	        		lv_rightRoot_11_0, 
                    	        		"CreatedObject", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1315); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getSemicolonKeyword_8(), null); 
                
            match(input,14,FOLLOW_14_in_ruleNamedResource1325); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getRightCurlyBracketKeyword_9(), null); 
                

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
    // $ANTLR end ruleNamedResource


    // $ANTLR start entryRuleObjectRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:788:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:788:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:789:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectRef_in_entryRuleObjectRef1360);
            iv_ruleObjectRef=ruleObjectRef();
            _fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectRef1370); 

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
    // $ANTLR end entryRuleObjectRef


    // $ANTLR start ruleObjectRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:796:1: ruleObjectRef returns [EObject current=null] : ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? ) ;
    public final EObject ruleObjectRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_leftFrag_3_0=null;
        Token lv_leftFrag_6_0=null;
        Token lv_rightFrag_9_0=null;
        EObject lv_assignments_11_0 = null;

        EObject lv_assignments_12_0 = null;

        EObject lv_leftMig_14_0 = null;

        EObject lv_rightMig_16_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:6: ( ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:1: ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:1: ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:3: 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )?
            {
            match(input,26,FOLLOW_26_in_ruleObjectRef1405); 

                    createLeafNode(grammarAccess.getObjectRefAccess().getObjectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:806:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_ID||LA10_1==23) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:807:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:807:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:808:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1422); 

                    			createLeafNode(grammarAccess.getObjectRefAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
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
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:830:3: ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==23) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("830:3: ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:830:4: ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:830:4: ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:830:5: ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:830:5: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:831:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:831:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:832:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1448); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_0_0_0(), "leftRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:844:2: ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:845:1: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:845:1: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:846:3: lv_leftFrag_3_0= RULE_FRAGMENT
                    {
                    lv_leftFrag_3_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1465); 

                    			createLeafNode(grammarAccess.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_0_1_0(), "leftFrag"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"leftFrag",
                    	        		lv_leftFrag_3_0, 
                    	        		"FRAGMENT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:869:6: ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:869:6: ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:869:8: 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    {
                    match(input,23,FOLLOW_23_in_ruleObjectRef1488); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getLeftKeyword_2_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:873:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:874:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:874:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:875:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1506); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_1_1_0(), "leftRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:887:2: ( (lv_leftFrag_6_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:888:1: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:888:1: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:889:3: lv_leftFrag_6_0= RULE_FRAGMENT
                    {
                    lv_leftFrag_6_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1523); 

                    			createLeafNode(grammarAccess.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_1_2_0(), "leftFrag"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"leftFrag",
                    	        		lv_leftFrag_6_0, 
                    	        		"FRAGMENT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,25,FOLLOW_25_in_ruleObjectRef1538); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getRightKeyword_2_1_3(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:915:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:916:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:916:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:917:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1556); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getRightResNamedResourceCrossReference_2_1_4_0(), "rightRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:929:2: ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:1: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:1: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:931:3: lv_rightFrag_9_0= RULE_FRAGMENT
                    {
                    lv_rightFrag_9_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1573); 

                    			createLeafNode(grammarAccess.getObjectRefAccess().getRightFragFRAGMENTTerminalRuleCall_2_1_5_0(), "rightFrag"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightFrag",
                    	        		lv_rightFrag_9_0, 
                    	        		"FRAGMENT", 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:953:4: ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:953:6: '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}'
                    {
                    match(input,13,FOLLOW_13_in_ruleObjectRef1591); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getLeftCurlyBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:957:1: ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            int LA12_2 = input.LA(2);

                            if ( (LA12_2==27) ) {
                                int LA12_3 = input.LA(3);

                                if ( (LA12_3==29) ) {
                                    alt12=2;
                                }
                                else if ( ((LA12_3>=RULE_ID && LA12_3<=RULE_STRING)||(LA12_3>=33 && LA12_3<=35)) ) {
                                    alt12=1;
                                }


                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:957:2: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:957:2: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:958:1: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:958:1: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:959:3: lv_assignments_11_0= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1613);
                    	    lv_assignments_11_0=ruleBiSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"assignments",
                    	    	        		lv_assignments_11_0, 
                    	    	        		"BiSingleAssignment", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:982:6: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:982:6: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:983:1: (lv_assignments_12_0= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:983:1: (lv_assignments_12_0= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:984:3: lv_assignments_12_0= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiListAssignmentParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiListAssignment_in_ruleObjectRef1640);
                    	    lv_assignments_12_0=ruleBiListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"assignments",
                    	    	        		lv_assignments_12_0, 
                    	    	        		"BiListAssignment", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:4: ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:6: 'left' ( (lv_leftMig_14_0= ruleMigration ) )
                            {
                            match(input,23,FOLLOW_23_in_ruleObjectRef1653); 

                                    createLeafNode(grammarAccess.getObjectRefAccess().getLeftKeyword_3_2_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1010:1: ( (lv_leftMig_14_0= ruleMigration ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1011:1: (lv_leftMig_14_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1011:1: (lv_leftMig_14_0= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1012:3: lv_leftMig_14_0= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getLeftMigMigrationParserRuleCall_3_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef1674);
                            lv_leftMig_14_0=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"leftMig",
                            	        		lv_leftMig_14_0, 
                            	        		"Migration", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1034:4: ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1034:6: 'right' ( (lv_rightMig_16_0= ruleMigration ) )
                            {
                            match(input,25,FOLLOW_25_in_ruleObjectRef1687); 

                                    createLeafNode(grammarAccess.getObjectRefAccess().getRightKeyword_3_3_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1038:1: ( (lv_rightMig_16_0= ruleMigration ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1039:1: (lv_rightMig_16_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1039:1: (lv_rightMig_16_0= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1040:3: lv_rightMig_16_0= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getRightMigMigrationParserRuleCall_3_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef1708);
                            lv_rightMig_16_0=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"rightMig",
                            	        		lv_rightMig_16_0, 
                            	        		"Migration", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    match(input,14,FOLLOW_14_in_ruleObjectRef1720); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getRightCurlyBracketKeyword_3_4(), null); 
                        

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
    // $ANTLR end ruleObjectRef


    // $ANTLR start entryRuleBiSingleAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1075:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1075:60: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1076:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBiSingleAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment1757);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();
            _fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiSingleAssignment1767); 

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
    // $ANTLR end entryRuleBiSingleAssignment


    // $ANTLR start ruleBiSingleAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1083:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValue_2_0 = null;

        EObject lv_rightValue_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:2: ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1090:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1090:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1091:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiSingleAssignment1809); 

            			createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"feature",
            	        		lv_feature_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,27,FOLLOW_27_in_ruleBiSingleAssignment1824); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:1: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1118:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1118:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1119:3: lv_leftValue_2_0= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1845);
            lv_leftValue_2_0=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"leftValue",
            	        		lv_leftValue_2_0, 
            	        		"SingleAssignmentValue", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,28,FOLLOW_28_in_ruleBiSingleAssignment1855); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getVerticalLineKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1145:1: ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1146:1: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1146:1: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1147:3: lv_rightValue_4_0= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getRightValueSingleAssignmentValueParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1876);
            lv_rightValue_4_0=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rightValue",
            	        		lv_rightValue_4_0, 
            	        		"SingleAssignmentValue", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleBiSingleAssignment1886); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getSemicolonKeyword_5(), null); 
                

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
    // $ANTLR end ruleBiSingleAssignment


    // $ANTLR start entryRuleBiListAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1181:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBiListAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment1919);
            iv_ruleBiListAssignment=ruleBiListAssignment();
            _fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiListAssignment1929); 

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
    // $ANTLR end entryRuleBiListAssignment


    // $ANTLR start ruleBiListAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1188:1: ruleBiListAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValues_3_0 = null;

        EObject lv_leftValues_5_0 = null;

        EObject lv_rightValues_7_0 = null;

        EObject lv_rightValues_9_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1193:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1194:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1194:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1194:2: ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1194:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1195:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1195:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1196:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiListAssignment1971); 

            			createLeafNode(grammarAccess.getBiListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"feature",
            	        		lv_feature_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,27,FOLLOW_27_in_ruleBiListAssignment1986); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            match(input,29,FOLLOW_29_in_ruleBiListAssignment1996); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1226:1: ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1226:2: ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1226:2: ( (lv_leftValues_3_0= ruleListAssignmentValue ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1227:1: (lv_leftValues_3_0= ruleListAssignmentValue )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1227:1: (lv_leftValues_3_0= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1228:3: lv_leftValues_3_0= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2018);
                    lv_leftValues_3_0=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"leftValues",
                    	        		lv_leftValues_3_0, 
                    	        		"ListAssignmentValue", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1250:2: ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1250:4: ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2029); 

                    	            createLeafNode(grammarAccess.getBiListAssignmentAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1254:1: ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:1: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:1: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1256:3: lv_leftValues_5_0= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2050);
                    	    lv_leftValues_5_0=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"leftValues",
                    	    	        		lv_leftValues_5_0, 
                    	    	        		"ListAssignmentValue", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_ruleBiListAssignment2064); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getVerticalLineKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1282:1: ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1282:2: ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1282:2: ( (lv_rightValues_7_0= ruleListAssignmentValue ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1283:1: (lv_rightValues_7_0= ruleListAssignmentValue )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1283:1: (lv_rightValues_7_0= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1284:3: lv_rightValues_7_0= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2086);
                    lv_rightValues_7_0=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"rightValues",
                    	        		lv_rightValues_7_0, 
                    	        		"ListAssignmentValue", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1306:2: ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1306:4: ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2097); 

                    	            createLeafNode(grammarAccess.getBiListAssignmentAccess().getCommaKeyword_5_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1310:1: ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1311:1: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1311:1: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1312:3: lv_rightValues_9_0= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2118);
                    	    lv_rightValues_9_0=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightValues",
                    	    	        		lv_rightValues_9_0, 
                    	    	        		"ListAssignmentValue", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_ruleBiListAssignment2132); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getRightSquareBracketKeyword_6(), null); 
                
            match(input,24,FOLLOW_24_in_ruleBiListAssignment2142); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getSemicolonKeyword_7(), null); 
                

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
    // $ANTLR end ruleBiListAssignment


    // $ANTLR start entryRuleMonoSingleAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1349:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1349:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1350:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMonoSingleAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2175);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();
            _fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoSingleAssignment2185); 

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
    // $ANTLR end entryRuleMonoSingleAssignment


    // $ANTLR start ruleMonoSingleAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1357:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValue_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1362:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1363:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1363:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1363:2: ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1363:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1364:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1364:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1365:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2227); 

            			createLeafNode(grammarAccess.getMonoSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMonoSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"feature",
            	        		lv_feature_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,27,FOLLOW_27_in_ruleMonoSingleAssignment2242); 

                    createLeafNode(grammarAccess.getMonoSingleAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1391:1: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1392:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1392:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1393:3: lv_leftValue_2_0= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMonoSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2263);
            lv_leftValue_2_0=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMonoSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"leftValue",
            	        		lv_leftValue_2_0, 
            	        		"SingleAssignmentValue", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleMonoSingleAssignment2273); 

                    createLeafNode(grammarAccess.getMonoSingleAssignmentAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleMonoSingleAssignment


    // $ANTLR start entryRuleMonoListAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1426:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1426:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1427:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMonoListAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2306);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();
            _fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoListAssignment2316); 

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
    // $ANTLR end entryRuleMonoListAssignment


    // $ANTLR start ruleMonoListAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1434:1: ruleMonoListAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValues_3_0 = null;

        EObject lv_leftValues_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1439:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1440:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1440:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1440:2: ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1440:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1441:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1441:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1442:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoListAssignment2358); 

            			createLeafNode(grammarAccess.getMonoListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMonoListAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"feature",
            	        		lv_feature_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,27,FOLLOW_27_in_ruleMonoListAssignment2373); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            match(input,29,FOLLOW_29_in_ruleMonoListAssignment2383); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:1: ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:2: ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:2: ( (lv_leftValues_3_0= ruleAssignmentValue ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1473:1: (lv_leftValues_3_0= ruleAssignmentValue )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1473:1: (lv_leftValues_3_0= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1474:3: lv_leftValues_3_0= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2405);
                    lv_leftValues_3_0=ruleAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMonoListAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"leftValues",
                    	        		lv_leftValues_3_0, 
                    	        		"AssignmentValue", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1496:2: ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1496:4: ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleMonoListAssignment2416); 

                    	            createLeafNode(grammarAccess.getMonoListAssignmentAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1500:1: ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1501:1: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1501:1: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1502:3: lv_leftValues_5_0= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2437);
                    	    lv_leftValues_5_0=ruleAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMonoListAssignmentRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"leftValues",
                    	    	        		lv_leftValues_5_0, 
                    	    	        		"AssignmentValue", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_ruleMonoListAssignment2451); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getRightSquareBracketKeyword_4(), null); 
                
            match(input,24,FOLLOW_24_in_ruleMonoListAssignment2461); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getSemicolonKeyword_5(), null); 
                

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
    // $ANTLR end ruleMonoListAssignment


    // $ANTLR start entryRuleAssignmentValue
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1539:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1539:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1540:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2494);
            iv_ruleAssignmentValue=ruleAssignmentValue();
            _fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentValue2504); 

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
    // $ANTLR end entryRuleAssignmentValue


    // $ANTLR start ruleAssignmentValue
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1547:1: ruleAssignmentValue returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_refFeature_3_0=null;
        Token lv_refIndex_5_0=null;
        Token lv_impFrag_9_0=null;
        EObject lv_newObject_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1552:6: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1553:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1553:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt24=1;
                }
                break;
            case RULE_ID:
                {
                int LA24_2 = input.LA(2);

                if ( (LA24_2==RULE_FRAGMENT) ) {
                    alt24=4;
                }
                else if ( (LA24_2==EOF||LA24_2==19||(LA24_2>=30 && LA24_2<=31)) ) {
                    alt24=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1553:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )", 24, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 35:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1553:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1553:2: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1553:2: ( (lv_value_0_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1554:1: (lv_value_0_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1554:1: (lv_value_0_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1555:3: lv_value_0_0= RULE_STRING
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssignmentValue2546); 

                    			createLeafNode(grammarAccess.getAssignmentValueAccess().getValueSTRINGTerminalRuleCall_0_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_0_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1578:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1578:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1578:7: ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1578:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1579:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1579:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1580:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue2576); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getRefObjectNamedObjectCrossReference_1_0_0(), "refObject"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1592:2: ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1592:4: '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )?
                            {
                            match(input,19,FOLLOW_19_in_ruleAssignmentValue2587); 

                                    createLeafNode(grammarAccess.getAssignmentValueAccess().getFullStopKeyword_1_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1596:1: ( (lv_refFeature_3_0= RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1597:1: (lv_refFeature_3_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1597:1: (lv_refFeature_3_0= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:3: lv_refFeature_3_0= RULE_ID
                            {
                            lv_refFeature_3_0=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue2604); 

                            			createLeafNode(grammarAccess.getAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_1_1_1_0(), "refFeature"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"refFeature",
                            	        		lv_refFeature_3_0, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:2: ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:4: '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleAssignmentValue2620); 

                                            createLeafNode(grammarAccess.getAssignmentValueAccess().getLeftSquareBracketKeyword_1_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:1: ( (lv_refIndex_5_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1625:1: (lv_refIndex_5_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1625:1: (lv_refIndex_5_0= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1626:3: lv_refIndex_5_0= RULE_INT
                                    {
                                    lv_refIndex_5_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignmentValue2637); 

                                    			createLeafNode(grammarAccess.getAssignmentValueAccess().getRefIndexINTTerminalRuleCall_1_1_2_1_0(), "refIndex"); 
                                    		

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        try {
                                    	       		set(
                                    	       			current, 
                                    	       			"refIndex",
                                    	        		lv_refIndex_5_0, 
                                    	        		"INT", 
                                    	        		lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }

                                    match(input,31,FOLLOW_31_in_ruleAssignmentValue2652); 

                                            createLeafNode(grammarAccess.getAssignmentValueAccess().getRightSquareBracketKeyword_1_1_2_2(), null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:6: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:6: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1654:1: (lv_newObject_7_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1654:1: (lv_newObject_7_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1655:3: lv_newObject_7_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleAssignmentValue2684);
                    lv_newObject_7_0=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"newObject",
                    	        		lv_newObject_7_0, 
                    	        		"CreatedObject", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1678:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1678:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1678:7: ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1678:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1679:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1679:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1680:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue2709); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getImportImportCrossReference_3_0_0(), "import"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1692:2: ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1693:1: (lv_impFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1693:1: (lv_impFrag_9_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1694:3: lv_impFrag_9_0= RULE_FRAGMENT
                    {
                    lv_impFrag_9_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue2726); 

                    			createLeafNode(grammarAccess.getAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_3_1_0(), "impFrag"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"impFrag",
                    	        		lv_impFrag_9_0, 
                    	        		"FRAGMENT", 
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
    // $ANTLR end ruleAssignmentValue


    // $ANTLR start entryRuleListAssignmentValue
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1723:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1723:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1724:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListAssignmentValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue2765);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();
            _fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListAssignmentValue2775); 

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
    // $ANTLR end entryRuleListAssignmentValue


    // $ANTLR start ruleListAssignmentValue
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1731:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) ;
    public final EObject ruleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_index_0_0=null;
        Token lv_refIndex_3_0=null;
        Token lv_value_5_0=null;
        Token lv_refFeature_8_0=null;
        Token lv_refIndex_10_0=null;
        Token lv_impFrag_14_0=null;
        EObject lv_newObject_12_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1736:6: ( ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1737:1: ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1737:1: ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1737:2: ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1737:2: ( (lv_index_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1738:1: (lv_index_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1738:1: (lv_index_0_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1739:3: lv_index_0_0= RULE_INT
            {
            lv_index_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue2817); 

            			createLeafNode(grammarAccess.getListAssignmentValueAccess().getIndexINTTerminalRuleCall_0_0(), "index"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"index",
            	        		lv_index_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,32,FOLLOW_32_in_ruleListAssignmentValue2832); 

                    createLeafNode(grammarAccess.getListAssignmentValueAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:1: ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt27=1;
                }
                break;
            case RULE_STRING:
                {
                alt27=2;
                }
                break;
            case RULE_ID:
                {
                int LA27_3 = input.LA(2);

                if ( (LA27_3==RULE_FRAGMENT) ) {
                    alt27=5;
                }
                else if ( (LA27_3==EOF||LA27_3==19||LA27_3==28||(LA27_3>=30 && LA27_3<=31)) ) {
                    alt27=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1765:1: ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )", 27, 3, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 35:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1765:1: ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:2: ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:2: ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:4: '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']'
                    {
                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue2844); 

                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1769:1: ( (lv_refIndex_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1770:1: (lv_refIndex_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1770:1: (lv_refIndex_3_0= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1771:3: lv_refIndex_3_0= RULE_INT
                    {
                    lv_refIndex_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue2861); 

                    			createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_0_1_0(), "refIndex"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"refIndex",
                    	        		lv_refIndex_3_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue2876); 

                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1798:6: ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1798:6: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1799:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1799:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1800:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleListAssignmentValue2900); 

                    			createLeafNode(grammarAccess.getListAssignmentValueAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_5_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:7: ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1824:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1824:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1825:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue2930); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_2_0_0(), "refObject"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1837:2: ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1837:4: '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )?
                            {
                            match(input,19,FOLLOW_19_in_ruleListAssignmentValue2941); 

                                    createLeafNode(grammarAccess.getListAssignmentValueAccess().getFullStopKeyword_2_2_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1841:1: ( (lv_refFeature_8_0= RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1842:1: (lv_refFeature_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1842:1: (lv_refFeature_8_0= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1843:3: lv_refFeature_8_0= RULE_ID
                            {
                            lv_refFeature_8_0=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue2958); 

                            			createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_2_1_1_0(), "refFeature"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"refFeature",
                            	        		lv_refFeature_8_0, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1865:2: ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1865:4: '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue2974); 

                                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_2_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1869:1: ( (lv_refIndex_10_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1870:1: (lv_refIndex_10_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1870:1: (lv_refIndex_10_0= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1871:3: lv_refIndex_10_0= RULE_INT
                                    {
                                    lv_refIndex_10_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue2991); 

                                    			createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_2_1_2_1_0(), "refIndex"); 
                                    		

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        try {
                                    	       		set(
                                    	       			current, 
                                    	       			"refIndex",
                                    	        		lv_refIndex_10_0, 
                                    	        		"INT", 
                                    	        		lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }

                                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue3006); 

                                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_2_1_2_2(), null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1898:6: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1898:6: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1899:1: (lv_newObject_12_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1899:1: (lv_newObject_12_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:3: lv_newObject_12_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getListAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3038);
                    lv_newObject_12_0=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"newObject",
                    	        		lv_newObject_12_0, 
                    	        		"CreatedObject", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1923:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1923:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1923:7: ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1923:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1924:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1924:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1925:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3063); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getImportImportCrossReference_2_4_0_0(), "import"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1937:2: ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1938:1: (lv_impFrag_14_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1938:1: (lv_impFrag_14_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1939:3: lv_impFrag_14_0= RULE_FRAGMENT
                    {
                    lv_impFrag_14_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3080); 

                    			createLeafNode(grammarAccess.getListAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_2_4_1_0(), "impFrag"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"impFrag",
                    	        		lv_impFrag_14_0, 
                    	        		"FRAGMENT", 
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
    // $ANTLR end ruleListAssignmentValue


    // $ANTLR start entryRuleSingleAssignmentValue
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1968:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1968:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1969:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleAssignmentValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3120);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();
            _fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleAssignmentValue3130); 

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
    // $ANTLR end entryRuleSingleAssignmentValue


    // $ANTLR start ruleSingleAssignmentValue
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1976:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_value_1_0=null;
        Token lv_refFeature_4_0=null;
        Token lv_refIndex_6_0=null;
        Token lv_impFrag_10_0=null;
        EObject lv_newObject_8_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1981:6: ( ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1982:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1982:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            int alt30=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt30=1;
                }
                break;
            case RULE_STRING:
                {
                alt30=2;
                }
                break;
            case RULE_ID:
                {
                int LA30_3 = input.LA(2);

                if ( (LA30_3==RULE_FRAGMENT) ) {
                    alt30=5;
                }
                else if ( (LA30_3==EOF||LA30_3==19||LA30_3==24||LA30_3==28) ) {
                    alt30=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1982:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )", 30, 3, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 35:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1982:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1982:2: ( (lv_keyword_0_0= 'null' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1982:2: ( (lv_keyword_0_0= 'null' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1983:1: (lv_keyword_0_0= 'null' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1983:1: (lv_keyword_0_0= 'null' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1984:3: lv_keyword_0_0= 'null'
                    {
                    lv_keyword_0_0=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleSingleAssignmentValue3173); 

                            createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getKeywordNullKeyword_0_0(), "keyword"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "keyword", lv_keyword_0_0, "null", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2004:6: ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2004:6: ( (lv_value_1_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2005:1: (lv_value_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2005:1: (lv_value_1_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2006:3: lv_value_1_0= RULE_STRING
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3209); 

                    			createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getValueSTRINGTerminalRuleCall_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_1_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2029:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2029:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2029:7: ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2029:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2030:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2030:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2031:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3239); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_0_0(), "refObject"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2043:2: ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2043:4: '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )?
                            {
                            match(input,19,FOLLOW_19_in_ruleSingleAssignmentValue3250); 

                                    createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getFullStopKeyword_2_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:1: ( (lv_refFeature_4_0= RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2048:1: (lv_refFeature_4_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2048:1: (lv_refFeature_4_0= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:3: lv_refFeature_4_0= RULE_ID
                            {
                            lv_refFeature_4_0=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3267); 

                            			createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_1_1_0(), "refFeature"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"refFeature",
                            	        		lv_refFeature_4_0, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2071:2: ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2071:4: '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleSingleAssignmentValue3283); 

                                            createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getLeftSquareBracketKeyword_2_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2075:1: ( (lv_refIndex_6_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:1: (lv_refIndex_6_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:1: (lv_refIndex_6_0= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2077:3: lv_refIndex_6_0= RULE_INT
                                    {
                                    lv_refIndex_6_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3300); 

                                    			createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_1_2_1_0(), "refIndex"); 
                                    		

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        try {
                                    	       		set(
                                    	       			current, 
                                    	       			"refIndex",
                                    	        		lv_refIndex_6_0, 
                                    	        		"INT", 
                                    	        		lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }

                                    match(input,31,FOLLOW_31_in_ruleSingleAssignmentValue3315); 

                                            createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRightSquareBracketKeyword_2_1_2_2(), null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2104:6: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2104:6: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2105:1: (lv_newObject_8_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2105:1: (lv_newObject_8_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2106:3: lv_newObject_8_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3347);
                    lv_newObject_8_0=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"newObject",
                    	        		lv_newObject_8_0, 
                    	        		"CreatedObject", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2129:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2129:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2129:7: ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2129:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2130:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2130:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2131:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3372); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getImportImportCrossReference_4_0_0(), "import"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2143:2: ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2144:1: (lv_impFrag_10_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2144:1: (lv_impFrag_10_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2145:3: lv_impFrag_10_0= RULE_FRAGMENT
                    {
                    lv_impFrag_10_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue3389); 

                    			createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_4_1_0(), "impFrag"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"impFrag",
                    	        		lv_impFrag_10_0, 
                    	        		"FRAGMENT", 
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
    // $ANTLR end ruleSingleAssignmentValue


    // $ANTLR start entryRuleCreatedObject
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2174:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2174:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2175:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCreatedObjectRule(), currentNode); 
            pushFollow(FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject3428);
            iv_ruleCreatedObject=ruleCreatedObject();
            _fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreatedObject3438); 

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
    // $ANTLR end entryRuleCreatedObject


    // $ANTLR start ruleCreatedObject
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2182:1: ruleCreatedObject returns [EObject current=null] : ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? ) ;
    public final EObject ruleCreatedObject() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_ObjectNew_0 = null;

        EObject this_ObjectCopy_1 = null;

        EObject lv_assignments_4_0 = null;

        EObject lv_assignments_5_0 = null;

        EObject lv_leftMig_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2187:6: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2188:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2188:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2188:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2188:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            else if ( (LA31_0==35) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2188:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2189:5: this_ObjectNew_0= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectNewParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectNew_in_ruleCreatedObject3486);
                    this_ObjectNew_0=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2199:5: this_ObjectCopy_1= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectCopyParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectCopy_in_ruleCreatedObject3513);
                    this_ObjectCopy_1=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2207:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2209:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreatedObject3530); 

                    			createLeafNode(grammarAccess.getCreatedObjectAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
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
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2231:3: ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2231:5: '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}'
                    {
                    match(input,13,FOLLOW_13_in_ruleCreatedObject3547); 

                            createLeafNode(grammarAccess.getCreatedObjectAccess().getLeftCurlyBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2235:1: ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=3;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            int LA33_2 = input.LA(2);

                            if ( (LA33_2==27) ) {
                                int LA33_3 = input.LA(3);

                                if ( (LA33_3==29) ) {
                                    alt33=2;
                                }
                                else if ( ((LA33_3>=RULE_ID && LA33_3<=RULE_STRING)||(LA33_3>=33 && LA33_3<=35)) ) {
                                    alt33=1;
                                }


                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2235:2: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2235:2: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2236:1: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2236:1: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2237:3: lv_assignments_4_0= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject3569);
                    	    lv_assignments_4_0=ruleMonoSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"assignments",
                    	    	        		lv_assignments_4_0, 
                    	    	        		"MonoSingleAssignment", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2260:6: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2260:6: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2261:1: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2261:1: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2262:3: lv_assignments_5_0= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoListAssignmentParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject3596);
                    	    lv_assignments_5_0=ruleMonoListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"assignments",
                    	    	        		lv_assignments_5_0, 
                    	    	        		"MonoListAssignment", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2284:4: ( (lv_leftMig_6_0= ruleMigration ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2285:1: (lv_leftMig_6_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2285:1: (lv_leftMig_6_0= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2286:3: lv_leftMig_6_0= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getLeftMigMigrationParserRuleCall_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleCreatedObject3619);
                            lv_leftMig_6_0=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"leftMig",
                            	        		lv_leftMig_6_0, 
                            	        		"Migration", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,14,FOLLOW_14_in_ruleCreatedObject3630); 

                            createLeafNode(grammarAccess.getCreatedObjectAccess().getRightCurlyBracketKeyword_2_3(), null); 
                        

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
    // $ANTLR end ruleCreatedObject


    // $ANTLR start entryRuleObjectNew
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2319:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2319:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2320:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectNewRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectNew_in_entryRuleObjectNew3665);
            iv_ruleObjectNew=ruleObjectNew();
            _fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectNew3675); 

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
    // $ANTLR end entryRuleObjectNew


    // $ANTLR start ruleObjectNew
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2327:1: ruleObjectNew returns [EObject current=null] : ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2332:6: ( ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2333:1: ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2333:1: ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2333:3: 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            {
            match(input,34,FOLLOW_34_in_ruleObjectNew3710); 

                    createLeafNode(grammarAccess.getObjectNewAccess().getNewKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2337:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2338:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2338:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2339:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getObjectNewRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectNew3728); 

            		createLeafNode(grammarAccess.getObjectNewAccess().getImportImportCrossReference_1_0(), "import"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2351:2: ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2352:1: (lv_impFrag_2_0= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2352:1: (lv_impFrag_2_0= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2353:3: lv_impFrag_2_0= RULE_FRAGMENT
            {
            lv_impFrag_2_0=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectNew3745); 

            			createLeafNode(grammarAccess.getObjectNewAccess().getImpFragFRAGMENTTerminalRuleCall_2_0(), "impFrag"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getObjectNewRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"impFrag",
            	        		lv_impFrag_2_0, 
            	        		"FRAGMENT", 
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
    // $ANTLR end ruleObjectNew


    // $ANTLR start entryRuleObjectCopy
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2382:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2382:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2383:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectCopyRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy3783);
            iv_ruleObjectCopy=ruleObjectCopy();
            _fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectCopy3793); 

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
    // $ANTLR end entryRuleObjectCopy


    // $ANTLR start ruleObjectCopy
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2390:1: ruleObjectCopy returns [EObject current=null] : ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2395:6: ( ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2396:1: ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2396:1: ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2396:3: 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            {
            match(input,35,FOLLOW_35_in_ruleObjectCopy3828); 

                    createLeafNode(grammarAccess.getObjectCopyAccess().getCopyKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2400:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2401:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2401:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2402:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getObjectCopyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectCopy3846); 

            		createLeafNode(grammarAccess.getObjectCopyAccess().getResourceNamedResourceCrossReference_1_0(), "resource"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2414:2: ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2415:1: (lv_fragment_2_0= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2415:1: (lv_fragment_2_0= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2416:3: lv_fragment_2_0= RULE_FRAGMENT
            {
            lv_fragment_2_0=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy3863); 

            			createLeafNode(grammarAccess.getObjectCopyAccess().getFragmentFRAGMENTTerminalRuleCall_2_0(), "fragment"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getObjectCopyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"fragment",
            	        		lv_fragment_2_0, 
            	        		"FRAGMENT", 
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
    // $ANTLR end ruleObjectCopy


    // $ANTLR start entryRuleMigration
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2445:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2445:51: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2446:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMigrationRule(), currentNode); 
            pushFollow(FOLLOW_ruleMigration_in_entryRuleMigration3901);
            iv_ruleMigration=ruleMigration();
            _fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMigration3911); 

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
    // $ANTLR end entryRuleMigration


    // $ANTLR start ruleMigration
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2453:1: ruleMigration returns [EObject current=null] : ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_asOp_3_0 = null;

        EObject lv_eachOp_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2458:6: ( ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2459:1: ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2459:1: ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2459:3: 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';'
            {
            match(input,36,FOLLOW_36_in_ruleMigration3946); 

                    createLeafNode(grammarAccess.getMigrationAccess().getMigrateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2463:1: ( (lv_first_1_0= ruleExecutable ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2464:1: (lv_first_1_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2464:1: (lv_first_1_0= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2465:3: lv_first_1_0= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getFirstExecutableParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration3967);
                    lv_first_1_0=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMigrationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"first",
                    	        		lv_first_1_0, 
                    	        		"Executable", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2487:3: ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )?
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==37) ) {
                alt37=1;
            }
            else if ( (LA37_0==38) ) {
                alt37=2;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2487:4: ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2487:4: ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2487:6: 'as' ( (lv_asOp_3_0= ruleExecutable ) )
                    {
                    match(input,37,FOLLOW_37_in_ruleMigration3980); 

                            createLeafNode(grammarAccess.getMigrationAccess().getAsKeyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2491:1: ( (lv_asOp_3_0= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2492:1: (lv_asOp_3_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2492:1: (lv_asOp_3_0= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2493:3: lv_asOp_3_0= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getAsOpExecutableParserRuleCall_2_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4001);
                    lv_asOp_3_0=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMigrationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"asOp",
                    	        		lv_asOp_3_0, 
                    	        		"Executable", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2516:6: ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2516:6: ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2516:8: 'each' ( (lv_eachOp_5_0= ruleExecutable ) )
                    {
                    match(input,38,FOLLOW_38_in_ruleMigration4019); 

                            createLeafNode(grammarAccess.getMigrationAccess().getEachKeyword_2_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2520:1: ( (lv_eachOp_5_0= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2521:1: (lv_eachOp_5_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2521:1: (lv_eachOp_5_0= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2522:3: lv_eachOp_5_0= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getEachOpExecutableParserRuleCall_2_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4040);
                    lv_eachOp_5_0=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMigrationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"eachOp",
                    	        		lv_eachOp_5_0, 
                    	        		"Executable", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleMigration4053); 

                    createLeafNode(grammarAccess.getMigrationAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleMigration


    // $ANTLR start entryRuleExecutable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2555:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2555:52: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2556:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExecutableRule(), currentNode); 
            pushFollow(FOLLOW_ruleExecutable_in_entryRuleExecutable4086);
            iv_ruleExecutable=ruleExecutable();
            _fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutable4096); 

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
    // $ANTLR end entryRuleExecutable


    // $ANTLR start ruleExecutable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2563:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable_0 = null;

        EObject this_ExpressionExecutable_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2568:6: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2569:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2569:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==18) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_STRING) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2569:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2570:5: this_JavaExecutable_0= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExecutableAccess().getJavaExecutableParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaExecutable_in_ruleExecutable4143);
                    this_JavaExecutable_0=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2580:5: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExecutableAccess().getExpressionExecutableParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionExecutable_in_ruleExecutable4170);
                    this_ExpressionExecutable_1=ruleExpressionExecutable();
                    _fsp--;

                     
                            current = this_ExpressionExecutable_1; 
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
    // $ANTLR end ruleExecutable


    // $ANTLR start entryRuleJavaExecutable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2595:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2595:56: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2596:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaExecutableRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable4202);
            iv_ruleJavaExecutable=ruleJavaExecutable();
            _fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaExecutable4212); 

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
    // $ANTLR end entryRuleJavaExecutable


    // $ANTLR start ruleJavaExecutable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2603:1: ruleJavaExecutable returns [EObject current=null] : ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2608:6: ( ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2609:1: ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2609:1: ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2609:3: 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')'
            {
            match(input,18,FOLLOW_18_in_ruleJavaExecutable4247); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getJavaKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2613:1: ( (lv_method_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2614:1: (lv_method_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2614:1: (lv_method_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2615:3: lv_method_1_0= RULE_ID
            {
            lv_method_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaExecutable4264); 

            			createLeafNode(grammarAccess.getJavaExecutableAccess().getMethodIDTerminalRuleCall_1_0(), "method"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaExecutableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"method",
            	        		lv_method_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,39,FOLLOW_39_in_ruleJavaExecutable4279); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getLeftParenthesisKeyword_2(), null); 
                
            match(input,40,FOLLOW_40_in_ruleJavaExecutable4289); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getRightParenthesisKeyword_3(), null); 
                

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
    // $ANTLR end ruleJavaExecutable


    // $ANTLR start entryRuleExpressionExecutable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2652:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2652:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2653:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionExecutableRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable4322);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();
            _fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionExecutable4332); 

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
    // $ANTLR end entryRuleExpressionExecutable


    // $ANTLR start ruleExpressionExecutable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2660:1: ruleExpressionExecutable returns [EObject current=null] : ( (lv_exprstr_0_0= RULE_STRING ) ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2665:6: ( ( (lv_exprstr_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2666:1: ( (lv_exprstr_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2666:1: ( (lv_exprstr_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2667:1: (lv_exprstr_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2667:1: (lv_exprstr_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2668:3: lv_exprstr_0_0= RULE_STRING
            {
            lv_exprstr_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleExpressionExecutable4373); 

            			createLeafNode(grammarAccess.getExpressionExecutableAccess().getExprstrSTRINGTerminalRuleCall_0(), "exprstr"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionExecutableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"exprstr",
            	        		lv_exprstr_0_0, 
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
    // $ANTLR end ruleExpressionExecutable


 

    public static final BitSet FOLLOW_ruleEPatch_in_entryRuleEPatch73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPatch83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleEPatch118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch135 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEPatch150 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleEPatch171 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch193 = new BitSet(new long[]{0x0000000004404000L});
    public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch215 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleEPatch226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_ruleImport316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelImport412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleResourceImport563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport580 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResourceImport595 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEPackageImport695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport712 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageImport727 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJavaImport827 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaImport837 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport854 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleJavaImport870 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport887 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExtensionImport972 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExtensionImport982 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport999 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleExtensionImport1015 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1032 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNamedResource1117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1134 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamedResource1149 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedResource1159 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1171 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1188 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1221 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1232 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNamedResource1242 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1254 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1271 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1304 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1315 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedResource1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleObjectRef1405 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1422 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1448 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1465 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1488 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1506 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1523 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1538 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1556 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1573 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleObjectRef1591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1613 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1640 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1653 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1674 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1687 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1708 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleObjectRef1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment1757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment1809 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment1824 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1845 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment1855 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1876 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment1919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment1971 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiListAssignment1986 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleBiListAssignment1996 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2018 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2029 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2050 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleBiListAssignment2064 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2086 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2097 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2118 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleBiListAssignment2132 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiListAssignment2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2227 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2242 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2263 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2358 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2373 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2383 = new BitSet(new long[]{0x0000000C80000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2405 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleMonoListAssignment2416 = new BitSet(new long[]{0x0000000C00000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2437 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleMonoListAssignment2451 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoListAssignment2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2576 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentValue2587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2604 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignmentValue2620 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue2637 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentValue2652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2709 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue2765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue2817 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleListAssignmentValue2832 = new BitSet(new long[]{0x0000000C20000030L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue2844 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue2861 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue2930 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleListAssignmentValue2941 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue2958 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue2974 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue2991 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3063 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3239 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue3250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3267 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue3283 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3300 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3372 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject3428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject3486 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject3513 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject3530 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleCreatedObject3547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject3569 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject3596 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject3619 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCreatedObject3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew3665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleObjectNew3710 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew3728 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy3783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleObjectCopy3828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy3846 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy3863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration3901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMigration3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMigration3946 = new BitSet(new long[]{0x0000006001040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration3967 = new BitSet(new long[]{0x0000006001000000L});
    public static final BitSet FOLLOW_37_in_ruleMigration3980 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4001 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_38_in_ruleMigration4019 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4040 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMigration4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable4086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutable4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable4202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaExecutable4247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable4264 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleJavaExecutable4279 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleJavaExecutable4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable4322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable4332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable4373 = new BitSet(new long[]{0x0000000000000002L});

}
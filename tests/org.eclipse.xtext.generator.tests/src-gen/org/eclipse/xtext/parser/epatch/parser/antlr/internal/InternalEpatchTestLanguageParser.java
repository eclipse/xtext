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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:73:2: (iv_ruleEPatch= ruleEPatch EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:74:2: iv_ruleEPatch= ruleEPatch EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPatchRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEPatch_in_entryRuleEPatch75);
            iv_ruleEPatch=ruleEPatch();
            _fsp--;

             current =iv_ruleEPatch; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPatch85); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:1: ruleEPatch returns [EObject current=null] : ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_imports_3_0 = null;

        EObject lv_resources_4_0 = null;

        EObject lv_objects_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:6: ( ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:87:1: ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:87:1: ( 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:87:3: 'epatch' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* '}'
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleEPatch120); 

                    createLeafNode(grammarAccess.getEPatchAccess().getEpatchKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:91:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:92:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:92:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:93:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEPatch137); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleEPatch152); 

                    createLeafNode(grammarAccess.getEPatchAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:119:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:120:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:120:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:121:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getImportsImportParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleEPatch173);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:143:3: ( (lv_resources_4_0= ruleNamedResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:144:1: (lv_resources_4_0= ruleNamedResource )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:144:1: (lv_resources_4_0= ruleNamedResource )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:145:3: lv_resources_4_0= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getResourcesNamedResourceParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedResource_in_ruleEPatch195);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:167:3: ( (lv_objects_5_0= ruleObjectRef ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:168:1: (lv_objects_5_0= ruleObjectRef )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:168:1: (lv_objects_5_0= ruleObjectRef )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:169:3: lv_objects_5_0= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getObjectsObjectRefParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleObjectRef_in_ruleEPatch217);
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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleEPatch228); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:203:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:204:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:205:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport264);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport274); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:212:1: ruleImport returns [EObject current=null] : (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport_0 = null;

        EObject this_JavaImport_1 = null;

        EObject this_ExtensionImport_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:217:6: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:218:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:218:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
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
                        new NoViableAltException("218:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("218:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:219:5: this_ModelImport_0= ruleModelImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getModelImportParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModelImport_in_ruleImport321);
                    this_ModelImport_0=ruleModelImport();
                    _fsp--;

                     
                            current = this_ModelImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:229:5: this_JavaImport_1= ruleJavaImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getJavaImportParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleJavaImport_in_ruleImport348);
                    this_JavaImport_1=ruleJavaImport();
                    _fsp--;

                     
                            current = this_JavaImport_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:239:5: this_ExtensionImport_2= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getExtensionImportParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExtensionImport_in_ruleImport375);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:255:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:256:2: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:257:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModelImport_in_entryRuleModelImport410);
            iv_ruleModelImport=ruleModelImport();
            _fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelImport420); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:264:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport_0 = null;

        EObject this_EPackageImport_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:269:6: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:270:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:270:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
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
                            new NoViableAltException("270:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("270:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("270:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:271:5: this_ResourceImport_0= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelImportAccess().getResourceImportParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleResourceImport_in_ruleModelImport467);
                    this_ResourceImport_0=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:281:5: this_EPackageImport_1= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelImportAccess().getEPackageImportParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEPackageImport_in_ruleModelImport494);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:297:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:298:2: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:299:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleResourceImport_in_entryRuleResourceImport529);
            iv_ruleResourceImport=ruleResourceImport();
            _fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResourceImport539); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:306:1: ruleResourceImport returns [EObject current=null] : ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_uri_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:311:6: ( ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:312:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:312:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:312:3: 'import' ( (lv_name_1_0= RULE_ID ) ) 'uri' ( (lv_uri_3_0= RULE_STRING ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleResourceImport574); 

                    createLeafNode(grammarAccess.getResourceImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:316:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:317:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:317:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:318:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleResourceImport591); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleResourceImport606); 

                    createLeafNode(grammarAccess.getResourceImportAccess().getUriKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:344:1: ( (lv_uri_3_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:345:1: (lv_uri_3_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:345:1: (lv_uri_3_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:346:3: lv_uri_3_0= RULE_STRING
            {
            lv_uri_3_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceImport623); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:376:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:377:2: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:378:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPackageImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport664);
            iv_ruleEPackageImport=ruleEPackageImport();
            _fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPackageImport674); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:385:1: ruleEPackageImport returns [EObject current=null] : ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_nsURI_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:390:6: ( ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:391:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:391:1: ( 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:391:3: 'import' ( (lv_name_1_0= RULE_ID ) ) 'ns' ( (lv_nsURI_3_0= RULE_STRING ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleEPackageImport709); 

                    createLeafNode(grammarAccess.getEPackageImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:395:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:396:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:396:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:397:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEPackageImport726); 

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

            match(input,17,FollowSets000.FOLLOW_17_in_ruleEPackageImport741); 

                    createLeafNode(grammarAccess.getEPackageImportAccess().getNsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:423:1: ( (lv_nsURI_3_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:424:1: (lv_nsURI_3_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:424:1: (lv_nsURI_3_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:425:3: lv_nsURI_3_0= RULE_STRING
            {
            lv_nsURI_3_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEPackageImport758); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:455:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:456:2: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:457:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleJavaImport_in_entryRuleJavaImport799);
            iv_ruleJavaImport=ruleJavaImport();
            _fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJavaImport809); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:464:1: ruleJavaImport returns [EObject current=null] : ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2_0=null;
        Token lv_path_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:469:6: ( ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:470:1: ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:470:1: ( 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:470:3: 'import' 'java' ( (lv_path_2_0= RULE_ID ) ) ( '.' ( (lv_path_4_0= RULE_ID ) ) )*
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleJavaImport844); 

                    createLeafNode(grammarAccess.getJavaImportAccess().getImportKeyword_0(), null); 
                
            match(input,18,FollowSets000.FOLLOW_18_in_ruleJavaImport854); 

                    createLeafNode(grammarAccess.getJavaImportAccess().getJavaKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:478:1: ( (lv_path_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:479:1: (lv_path_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:479:1: (lv_path_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:480:3: lv_path_2_0= RULE_ID
            {
            lv_path_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaImport871); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:502:2: ( '.' ( (lv_path_4_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:502:4: '.' ( (lv_path_4_0= RULE_ID ) )
            	    {
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleJavaImport887); 

            	            createLeafNode(grammarAccess.getJavaImportAccess().getFullStopKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:1: ( (lv_path_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:507:1: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:507:1: (lv_path_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:508:3: lv_path_4_0= RULE_ID
            	    {
            	    lv_path_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaImport904); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:538:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:539:2: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:540:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtensionImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport947);
            iv_ruleExtensionImport=ruleExtensionImport();
            _fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtensionImport957); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:547:1: ruleExtensionImport returns [EObject current=null] : ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2_0=null;
        Token lv_path_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:552:6: ( ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:553:1: ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:553:1: ( 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:553:3: 'import' 'extension' ( (lv_path_2_0= RULE_ID ) ) ( '::' ( (lv_path_4_0= RULE_ID ) ) )*
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleExtensionImport992); 

                    createLeafNode(grammarAccess.getExtensionImportAccess().getImportKeyword_0(), null); 
                
            match(input,20,FollowSets000.FOLLOW_20_in_ruleExtensionImport1002); 

                    createLeafNode(grammarAccess.getExtensionImportAccess().getExtensionKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:561:1: ( (lv_path_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:562:1: (lv_path_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:562:1: (lv_path_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:563:3: lv_path_2_0= RULE_ID
            {
            lv_path_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtensionImport1019); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:585:2: ( '::' ( (lv_path_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:585:4: '::' ( (lv_path_4_0= RULE_ID ) )
            	    {
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleExtensionImport1035); 

            	            createLeafNode(grammarAccess.getExtensionImportAccess().getColonColonKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:589:1: ( (lv_path_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:590:1: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:590:1: (lv_path_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:591:3: lv_path_4_0= RULE_ID
            	    {
            	    lv_path_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtensionImport1052); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:621:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:622:2: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:623:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedResourceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedResource_in_entryRuleNamedResource1095);
            iv_ruleNamedResource=ruleNamedResource();
            _fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedResource1105); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:630:1: ruleNamedResource returns [EObject current=null] : ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_leftUri_5_0=null;
        Token lv_rightUri_10_0=null;
        EObject lv_leftRoot_6_0 = null;

        EObject lv_rightRoot_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:635:6: ( ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:636:1: ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:636:1: ( 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:636:3: 'resource' ( (lv_name_1_0= RULE_ID ) ) '{' 'left' ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) ';' 'right' ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) ';' '}'
            {
            match(input,22,FollowSets000.FOLLOW_22_in_ruleNamedResource1140); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getResourceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:640:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:641:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:641:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:642:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedResource1157); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleNamedResource1172); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            match(input,23,FollowSets000.FOLLOW_23_in_ruleNamedResource1182); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getLeftKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:672:1: ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )
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
                    new NoViableAltException("672:1: ( ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:672:2: ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:672:2: ( 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:672:4: 'uri' ( (lv_leftUri_5_0= RULE_STRING ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleNamedResource1194); 

                            createLeafNode(grammarAccess.getNamedResourceAccess().getUriKeyword_4_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:676:1: ( (lv_leftUri_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:677:1: (lv_leftUri_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:677:1: (lv_leftUri_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:678:3: lv_leftUri_5_0= RULE_STRING
                    {
                    lv_leftUri_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNamedResource1211); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:701:6: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:701:6: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:702:1: (lv_leftRoot_6_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:702:1: (lv_leftRoot_6_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:703:3: lv_leftRoot_6_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedResourceAccess().getLeftRootCreatedObjectParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleNamedResource1244);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedResource1255); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getSemicolonKeyword_5(), null); 
                
            match(input,25,FollowSets000.FOLLOW_25_in_ruleNamedResource1265); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getRightKeyword_6(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:733:1: ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )
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
                    new NoViableAltException("733:1: ( ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:733:2: ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:733:2: ( 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:733:4: 'uri' ( (lv_rightUri_10_0= RULE_STRING ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleNamedResource1277); 

                            createLeafNode(grammarAccess.getNamedResourceAccess().getUriKeyword_7_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:737:1: ( (lv_rightUri_10_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:738:1: (lv_rightUri_10_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:738:1: (lv_rightUri_10_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:3: lv_rightUri_10_0= RULE_STRING
                    {
                    lv_rightUri_10_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNamedResource1294); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:762:6: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:762:6: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:1: (lv_rightRoot_11_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:1: (lv_rightRoot_11_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:764:3: lv_rightRoot_11_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedResourceAccess().getRightRootCreatedObjectParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleNamedResource1327);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedResource1338); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getSemicolonKeyword_8(), null); 
                
            match(input,14,FollowSets000.FOLLOW_14_in_ruleNamedResource1348); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:805:2: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:806:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectRefRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectRef_in_entryRuleObjectRef1386);
            iv_ruleObjectRef=ruleObjectRef();
            _fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectRef1396); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:813:1: ruleObjectRef returns [EObject current=null] : ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:818:6: ( ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:819:1: ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:819:1: ( 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:819:3: 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )?
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleObjectRef1431); 

                    createLeafNode(grammarAccess.getObjectRefAccess().getObjectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:823:1: ( (lv_name_1_0= RULE_ID ) )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:824:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:824:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:825:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1448); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:847:3: ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                    new NoViableAltException("847:3: ( ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:847:4: ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:847:4: ( ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:847:5: ( ( RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:847:5: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:848:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:848:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:849:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1474); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_0_0_0(), "leftRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:861:2: ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:862:1: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:862:1: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:863:3: lv_leftFrag_3_0= RULE_FRAGMENT
                    {
                    lv_leftFrag_3_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1491); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:6: ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:6: ( 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:8: 'left' ( ( RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) 'right' ( ( RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleObjectRef1514); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getLeftKeyword_2_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:890:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:891:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:891:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:892:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1532); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_1_1_0(), "leftRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:904:2: ( (lv_leftFrag_6_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:905:1: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:905:1: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:906:3: lv_leftFrag_6_0= RULE_FRAGMENT
                    {
                    lv_leftFrag_6_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1549); 

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

                    match(input,25,FollowSets000.FOLLOW_25_in_ruleObjectRef1564); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getRightKeyword_2_1_3(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:932:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:933:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:933:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:934:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1582); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getRightResNamedResourceCrossReference_2_1_4_0(), "rightRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:946:2: ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:947:1: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:947:1: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:948:3: lv_rightFrag_9_0= RULE_FRAGMENT
                    {
                    lv_rightFrag_9_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1599); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:970:4: ( '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:970:6: '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? '}'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleObjectRef1617); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getLeftCurlyBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:974:1: ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:974:2: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:974:2: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:975:1: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:975:1: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:976:3: lv_assignments_11_0= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1639);
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:999:6: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:999:6: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1000:1: (lv_assignments_12_0= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1000:1: (lv_assignments_12_0= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1001:3: lv_assignments_12_0= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiListAssignmentParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBiListAssignment_in_ruleObjectRef1666);
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1023:4: ( 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1023:6: 'left' ( (lv_leftMig_14_0= ruleMigration ) )
                            {
                            match(input,23,FollowSets000.FOLLOW_23_in_ruleObjectRef1679); 

                                    createLeafNode(grammarAccess.getObjectRefAccess().getLeftKeyword_3_2_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1027:1: ( (lv_leftMig_14_0= ruleMigration ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1028:1: (lv_leftMig_14_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1028:1: (lv_leftMig_14_0= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1029:3: lv_leftMig_14_0= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getLeftMigMigrationParserRuleCall_3_2_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleObjectRef1700);
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1051:4: ( 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1051:6: 'right' ( (lv_rightMig_16_0= ruleMigration ) )
                            {
                            match(input,25,FollowSets000.FOLLOW_25_in_ruleObjectRef1713); 

                                    createLeafNode(grammarAccess.getObjectRefAccess().getRightKeyword_3_3_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1055:1: ( (lv_rightMig_16_0= ruleMigration ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1056:1: (lv_rightMig_16_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1056:1: (lv_rightMig_16_0= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1057:3: lv_rightMig_16_0= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getRightMigMigrationParserRuleCall_3_3_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleObjectRef1734);
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

                    match(input,14,FollowSets000.FOLLOW_14_in_ruleObjectRef1746); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1093:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1094:2: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1095:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBiSingleAssignmentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment1786);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();
            _fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBiSingleAssignment1796); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValue_2_0 = null;

        EObject lv_rightValue_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1107:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1108:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1108:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1108:2: ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1108:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1109:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1109:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1110:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBiSingleAssignment1838); 

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

            match(input,27,FollowSets000.FOLLOW_27_in_ruleBiSingleAssignment1853); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1136:1: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1137:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1137:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1138:3: lv_leftValue_2_0= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1874);
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

            match(input,28,FollowSets000.FOLLOW_28_in_ruleBiSingleAssignment1884); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getVerticalLineKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1164:1: ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1165:1: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1165:1: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1166:3: lv_rightValue_4_0= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getRightValueSingleAssignmentValueParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1905);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleBiSingleAssignment1915); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1200:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1201:2: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1202:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBiListAssignmentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment1951);
            iv_ruleBiListAssignment=ruleBiListAssignment();
            _fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBiListAssignment1961); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1209:1: ruleBiListAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValues_3_0 = null;

        EObject lv_leftValues_5_0 = null;

        EObject lv_rightValues_7_0 = null;

        EObject lv_rightValues_9_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1214:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1215:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1215:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1215:2: ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? ']' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1215:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1216:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1216:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1217:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBiListAssignment2003); 

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

            match(input,27,FollowSets000.FOLLOW_27_in_ruleBiListAssignment2018); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            match(input,29,FollowSets000.FOLLOW_29_in_ruleBiListAssignment2028); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1247:1: ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1247:2: ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1247:2: ( (lv_leftValues_3_0= ruleListAssignmentValue ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1248:1: (lv_leftValues_3_0= ruleListAssignmentValue )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1248:1: (lv_leftValues_3_0= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1249:3: lv_leftValues_3_0= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2050);
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1271:2: ( ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1271:4: ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    {
                    	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBiListAssignment2061); 

                    	            createLeafNode(grammarAccess.getBiListAssignmentAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1275:1: ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1276:1: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1276:1: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1277:3: lv_leftValues_5_0= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2082);
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

            match(input,28,FollowSets000.FOLLOW_28_in_ruleBiListAssignment2096); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getVerticalLineKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1303:1: ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1303:2: ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1303:2: ( (lv_rightValues_7_0= ruleListAssignmentValue ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1304:1: (lv_rightValues_7_0= ruleListAssignmentValue )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1304:1: (lv_rightValues_7_0= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1305:3: lv_rightValues_7_0= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2118);
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1327:2: ( ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1327:4: ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    {
                    	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBiListAssignment2129); 

                    	            createLeafNode(grammarAccess.getBiListAssignmentAccess().getCommaKeyword_5_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1331:1: ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1332:1: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1332:1: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1333:3: lv_rightValues_9_0= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2150);
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

            match(input,31,FollowSets000.FOLLOW_31_in_ruleBiListAssignment2164); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getRightSquareBracketKeyword_6(), null); 
                
            match(input,24,FollowSets000.FOLLOW_24_in_ruleBiListAssignment2174); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1371:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1372:2: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1373:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMonoSingleAssignmentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2210);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();
            _fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMonoSingleAssignment2220); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1380:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValue_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1385:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1386:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1386:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1386:2: ( (lv_feature_0_0= RULE_ID ) ) '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1386:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1387:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1387:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1388:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2262); 

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

            match(input,27,FollowSets000.FOLLOW_27_in_ruleMonoSingleAssignment2277); 

                    createLeafNode(grammarAccess.getMonoSingleAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1414:1: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1415:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1415:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1416:3: lv_leftValue_2_0= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMonoSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2298);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleMonoSingleAssignment2308); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1450:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1451:2: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1452:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMonoListAssignmentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2344);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();
            _fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMonoListAssignment2354); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1459:1: ruleMonoListAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        EObject lv_leftValues_3_0 = null;

        EObject lv_leftValues_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1464:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1465:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1465:1: ( ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1465:2: ( (lv_feature_0_0= RULE_ID ) ) '=' '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? ']' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1465:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1467:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMonoListAssignment2396); 

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

            match(input,27,FollowSets000.FOLLOW_27_in_ruleMonoListAssignment2411); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            match(input,29,FollowSets000.FOLLOW_29_in_ruleMonoListAssignment2421); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1497:1: ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1497:2: ( (lv_leftValues_3_0= ruleAssignmentValue ) ) ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1497:2: ( (lv_leftValues_3_0= ruleAssignmentValue ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1498:1: (lv_leftValues_3_0= ruleAssignmentValue )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1498:1: (lv_leftValues_3_0= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1499:3: lv_leftValues_3_0= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2443);
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1521:2: ( ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1521:4: ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    {
                    	    match(input,30,FollowSets000.FOLLOW_30_in_ruleMonoListAssignment2454); 

                    	            createLeafNode(grammarAccess.getMonoListAssignmentAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1525:1: ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1526:1: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1526:1: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1527:3: lv_leftValues_5_0= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2475);
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

            match(input,31,FollowSets000.FOLLOW_31_in_ruleMonoListAssignment2489); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getRightSquareBracketKeyword_4(), null); 
                
            match(input,24,FollowSets000.FOLLOW_24_in_ruleMonoListAssignment2499); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1565:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1566:2: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1567:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentValueRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2535);
            iv_ruleAssignmentValue=ruleAssignmentValue();
            _fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentValue2545); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1574:1: ruleAssignmentValue returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_refFeature_3_0=null;
        Token lv_refIndex_5_0=null;
        Token lv_impFrag_9_0=null;
        EObject lv_newObject_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1579:6: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1580:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1580:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                        new NoViableAltException("1580:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )", 24, 2, input);

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
                    new NoViableAltException("1580:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1580:2: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1580:2: ( (lv_value_0_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1581:1: (lv_value_0_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1581:1: (lv_value_0_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1582:3: lv_value_0_0= RULE_STRING
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAssignmentValue2587); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1605:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1605:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1605:7: ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1605:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1606:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1606:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1607:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue2617); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getRefObjectNamedObjectCrossReference_1_0_0(), "refObject"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1619:2: ( '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1619:4: '.' ( (lv_refFeature_3_0= RULE_ID ) ) ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )?
                            {
                            match(input,19,FollowSets000.FOLLOW_19_in_ruleAssignmentValue2628); 

                                    createLeafNode(grammarAccess.getAssignmentValueAccess().getFullStopKeyword_1_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:1: ( (lv_refFeature_3_0= RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:1: (lv_refFeature_3_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:1: (lv_refFeature_3_0= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1625:3: lv_refFeature_3_0= RULE_ID
                            {
                            lv_refFeature_3_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue2645); 

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

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1647:2: ( '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1647:4: '[' ( (lv_refIndex_5_0= RULE_INT ) ) ']'
                                    {
                                    match(input,29,FollowSets000.FOLLOW_29_in_ruleAssignmentValue2661); 

                                            createLeafNode(grammarAccess.getAssignmentValueAccess().getLeftSquareBracketKeyword_1_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1651:1: ( (lv_refIndex_5_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1652:1: (lv_refIndex_5_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1652:1: (lv_refIndex_5_0= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:3: lv_refIndex_5_0= RULE_INT
                                    {
                                    lv_refIndex_5_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssignmentValue2678); 

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

                                    match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignmentValue2693); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1680:6: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1680:6: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1681:1: (lv_newObject_7_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1681:1: (lv_newObject_7_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1682:3: lv_newObject_7_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleAssignmentValue2725);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1705:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1705:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1705:7: ( ( RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1705:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1706:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1706:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1707:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue2750); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getImportImportCrossReference_3_0_0(), "import"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1719:2: ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1720:1: (lv_impFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1720:1: (lv_impFrag_9_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1721:3: lv_impFrag_9_0= RULE_FRAGMENT
                    {
                    lv_impFrag_9_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue2767); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1751:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1752:2: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1753:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListAssignmentValueRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue2809);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();
            _fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListAssignmentValue2819); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1760:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:6: ( ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:1: ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:1: ( ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:2: ( (lv_index_0_0= RULE_INT ) ) ':' ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:2: ( (lv_index_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1767:1: (lv_index_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1767:1: (lv_index_0_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1768:3: lv_index_0_0= RULE_INT
            {
            lv_index_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue2861); 

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

            match(input,32,FollowSets000.FOLLOW_32_in_ruleListAssignmentValue2876); 

                    createLeafNode(grammarAccess.getListAssignmentValueAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1794:1: ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
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
                        new NoViableAltException("1794:1: ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )", 27, 3, input);

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
                    new NoViableAltException("1794:1: ( ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1794:2: ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1794:2: ( '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1794:4: '[' ( (lv_refIndex_3_0= RULE_INT ) ) ']'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_ruleListAssignmentValue2888); 

                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1798:1: ( (lv_refIndex_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1799:1: (lv_refIndex_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1799:1: (lv_refIndex_3_0= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1800:3: lv_refIndex_3_0= RULE_INT
                    {
                    lv_refIndex_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue2905); 

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

                    match(input,31,FollowSets000.FOLLOW_31_in_ruleListAssignmentValue2920); 

                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1827:6: ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1827:6: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1828:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1828:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1829:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleListAssignmentValue2944); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1852:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1852:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1852:7: ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1852:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1853:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1853:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1854:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue2974); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_2_0_0(), "refObject"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:2: ( '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:4: '.' ( (lv_refFeature_8_0= RULE_ID ) ) ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )?
                            {
                            match(input,19,FollowSets000.FOLLOW_19_in_ruleListAssignmentValue2985); 

                                    createLeafNode(grammarAccess.getListAssignmentValueAccess().getFullStopKeyword_2_2_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1870:1: ( (lv_refFeature_8_0= RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1871:1: (lv_refFeature_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1871:1: (lv_refFeature_8_0= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1872:3: lv_refFeature_8_0= RULE_ID
                            {
                            lv_refFeature_8_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue3002); 

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

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1894:2: ( '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1894:4: '[' ( (lv_refIndex_10_0= RULE_INT ) ) ']'
                                    {
                                    match(input,29,FollowSets000.FOLLOW_29_in_ruleListAssignmentValue3018); 

                                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_2_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1898:1: ( (lv_refIndex_10_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1899:1: (lv_refIndex_10_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1899:1: (lv_refIndex_10_0= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:3: lv_refIndex_10_0= RULE_INT
                                    {
                                    lv_refIndex_10_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue3035); 

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

                                    match(input,31,FollowSets000.FOLLOW_31_in_ruleListAssignmentValue3050); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1927:6: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1927:6: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1928:1: (lv_newObject_12_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1928:1: (lv_newObject_12_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1929:3: lv_newObject_12_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getListAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3082);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1952:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1952:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1952:7: ( ( RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1952:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1954:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue3107); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getImportImportCrossReference_2_4_0_0(), "import"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1966:2: ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1967:1: (lv_impFrag_14_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1967:1: (lv_impFrag_14_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1968:3: lv_impFrag_14_0= RULE_FRAGMENT
                    {
                    lv_impFrag_14_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3124); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1998:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1999:2: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2000:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleAssignmentValueRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3167);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();
            _fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleAssignmentValue3177); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2007:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2012:6: ( ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2013:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2013:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
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
                        new NoViableAltException("2013:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )", 30, 3, input);

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
                    new NoViableAltException("2013:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2013:2: ( (lv_keyword_0_0= 'null' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2013:2: ( (lv_keyword_0_0= 'null' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2014:1: (lv_keyword_0_0= 'null' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2014:1: (lv_keyword_0_0= 'null' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2015:3: lv_keyword_0_0= 'null'
                    {
                    lv_keyword_0_0=(Token)input.LT(1);
                    match(input,33,FollowSets000.FOLLOW_33_in_ruleSingleAssignmentValue3220); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2035:6: ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2035:6: ( (lv_value_1_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2036:1: (lv_value_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2036:1: (lv_value_1_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:3: lv_value_1_0= RULE_STRING
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3256); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2060:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2060:6: ( ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2060:7: ( ( RULE_ID ) ) ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2060:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2061:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2061:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2062:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3286); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_0_0(), "refObject"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2074:2: ( '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2074:4: '.' ( (lv_refFeature_4_0= RULE_ID ) ) ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )?
                            {
                            match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleAssignmentValue3297); 

                                    createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getFullStopKeyword_2_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2078:1: ( (lv_refFeature_4_0= RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2079:1: (lv_refFeature_4_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2079:1: (lv_refFeature_4_0= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2080:3: lv_refFeature_4_0= RULE_ID
                            {
                            lv_refFeature_4_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3314); 

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

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2102:2: ( '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2102:4: '[' ( (lv_refIndex_6_0= RULE_INT ) ) ']'
                                    {
                                    match(input,29,FollowSets000.FOLLOW_29_in_ruleSingleAssignmentValue3330); 

                                            createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getLeftSquareBracketKeyword_2_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2106:1: ( (lv_refIndex_6_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2107:1: (lv_refIndex_6_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2107:1: (lv_refIndex_6_0= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2108:3: lv_refIndex_6_0= RULE_INT
                                    {
                                    lv_refIndex_6_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3347); 

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

                                    match(input,31,FollowSets000.FOLLOW_31_in_ruleSingleAssignmentValue3362); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2135:6: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2135:6: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2136:1: (lv_newObject_8_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2136:1: (lv_newObject_8_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2137:3: lv_newObject_8_0= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3394);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2160:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2160:6: ( ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2160:7: ( ( RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2160:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2161:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2161:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2162:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3419); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getImportImportCrossReference_4_0_0(), "import"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2174:2: ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2175:1: (lv_impFrag_10_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2175:1: (lv_impFrag_10_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2176:3: lv_impFrag_10_0= RULE_FRAGMENT
                    {
                    lv_impFrag_10_0=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue3436); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2206:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2207:2: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCreatedObjectRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject3478);
            iv_ruleCreatedObject=ruleCreatedObject();
            _fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreatedObject3488); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2215:1: ruleCreatedObject returns [EObject current=null] : ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2220:6: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2221:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2221:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2221:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2221:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
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
                    new NoViableAltException("2221:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2222:5: this_ObjectNew_0= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectNewParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleObjectNew_in_ruleCreatedObject3536);
                    this_ObjectNew_0=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2232:5: this_ObjectCopy_1= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectCopyParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleObjectCopy_in_ruleCreatedObject3563);
                    this_ObjectCopy_1=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2240:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2241:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2241:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2242:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreatedObject3580); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2264:3: ( '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2264:5: '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? '}'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCreatedObject3597); 

                            createLeafNode(grammarAccess.getCreatedObjectAccess().getLeftCurlyBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:1: ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:2: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:2: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2269:1: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2269:1: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2270:3: lv_assignments_4_0= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject3619);
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2293:6: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2293:6: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2294:1: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2294:1: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2295:3: lv_assignments_5_0= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoListAssignmentParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject3646);
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2317:4: ( (lv_leftMig_6_0= ruleMigration ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2318:1: (lv_leftMig_6_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2318:1: (lv_leftMig_6_0= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2319:3: lv_leftMig_6_0= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getLeftMigMigrationParserRuleCall_2_2_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleCreatedObject3669);
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

                    match(input,14,FollowSets000.FOLLOW_14_in_ruleCreatedObject3680); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2353:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2354:2: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2355:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectNewRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectNew_in_entryRuleObjectNew3718);
            iv_ruleObjectNew=ruleObjectNew();
            _fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectNew3728); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2362:1: ruleObjectNew returns [EObject current=null] : ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2367:6: ( ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2368:1: ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2368:1: ( 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2368:3: 'new' ( ( RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            {
            match(input,34,FollowSets000.FOLLOW_34_in_ruleObjectNew3763); 

                    createLeafNode(grammarAccess.getObjectNewAccess().getNewKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2372:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2373:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2373:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2374:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getObjectNewRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectNew3781); 

            		createLeafNode(grammarAccess.getObjectNewAccess().getImportImportCrossReference_1_0(), "import"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2386:2: ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2387:1: (lv_impFrag_2_0= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2387:1: (lv_impFrag_2_0= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2388:3: lv_impFrag_2_0= RULE_FRAGMENT
            {
            lv_impFrag_2_0=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectNew3798); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2418:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2419:2: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2420:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectCopyRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy3839);
            iv_ruleObjectCopy=ruleObjectCopy();
            _fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectCopy3849); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2427:1: ruleObjectCopy returns [EObject current=null] : ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2432:6: ( ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2433:1: ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2433:1: ( 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2433:3: 'copy' ( ( RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleObjectCopy3884); 

                    createLeafNode(grammarAccess.getObjectCopyAccess().getCopyKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2437:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2438:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2438:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2439:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getObjectCopyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectCopy3902); 

            		createLeafNode(grammarAccess.getObjectCopyAccess().getResourceNamedResourceCrossReference_1_0(), "resource"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2451:2: ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2452:1: (lv_fragment_2_0= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2452:1: (lv_fragment_2_0= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2453:3: lv_fragment_2_0= RULE_FRAGMENT
            {
            lv_fragment_2_0=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy3919); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2483:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2484:2: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2485:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMigrationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_entryRuleMigration3960);
            iv_ruleMigration=ruleMigration();
            _fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMigration3970); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2492:1: ruleMigration returns [EObject current=null] : ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_asOp_3_0 = null;

        EObject lv_eachOp_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2497:6: ( ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2498:1: ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2498:1: ( 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2498:3: 'migrate' ( (lv_first_1_0= ruleExecutable ) )? ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )? ';'
            {
            match(input,36,FollowSets000.FOLLOW_36_in_ruleMigration4005); 

                    createLeafNode(grammarAccess.getMigrationAccess().getMigrateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2502:1: ( (lv_first_1_0= ruleExecutable ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2503:1: (lv_first_1_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2503:1: (lv_first_1_0= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2504:3: lv_first_1_0= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getFirstExecutableParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration4026);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2526:3: ( ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) ) | ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) ) )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2526:4: ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2526:4: ( 'as' ( (lv_asOp_3_0= ruleExecutable ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2526:6: 'as' ( (lv_asOp_3_0= ruleExecutable ) )
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_ruleMigration4039); 

                            createLeafNode(grammarAccess.getMigrationAccess().getAsKeyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2530:1: ( (lv_asOp_3_0= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2531:1: (lv_asOp_3_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2531:1: (lv_asOp_3_0= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2532:3: lv_asOp_3_0= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getAsOpExecutableParserRuleCall_2_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration4060);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2555:6: ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2555:6: ( 'each' ( (lv_eachOp_5_0= ruleExecutable ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2555:8: 'each' ( (lv_eachOp_5_0= ruleExecutable ) )
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_ruleMigration4078); 

                            createLeafNode(grammarAccess.getMigrationAccess().getEachKeyword_2_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2559:1: ( (lv_eachOp_5_0= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2560:1: (lv_eachOp_5_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2560:1: (lv_eachOp_5_0= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2561:3: lv_eachOp_5_0= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getEachOpExecutableParserRuleCall_2_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration4099);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleMigration4112); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2595:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2596:2: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2597:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExecutableRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_entryRuleExecutable4148);
            iv_ruleExecutable=ruleExecutable();
            _fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExecutable4158); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2604:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable_0 = null;

        EObject this_ExpressionExecutable_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2609:6: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2610:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2610:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
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
                    new NoViableAltException("2610:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2611:5: this_JavaExecutable_0= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExecutableAccess().getJavaExecutableParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleJavaExecutable_in_ruleExecutable4205);
                    this_JavaExecutable_0=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2621:5: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExecutableAccess().getExpressionExecutableParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpressionExecutable_in_ruleExecutable4232);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2637:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2638:2: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2639:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaExecutableRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable4267);
            iv_ruleJavaExecutable=ruleJavaExecutable();
            _fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJavaExecutable4277); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2646:1: ruleJavaExecutable returns [EObject current=null] : ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2651:6: ( ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2652:1: ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2652:1: ( 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2652:3: 'java' ( (lv_method_1_0= RULE_ID ) ) '(' ')'
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleJavaExecutable4312); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getJavaKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2656:1: ( (lv_method_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2657:1: (lv_method_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2657:1: (lv_method_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2658:3: lv_method_1_0= RULE_ID
            {
            lv_method_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaExecutable4329); 

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

            match(input,39,FollowSets000.FOLLOW_39_in_ruleJavaExecutable4344); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getLeftParenthesisKeyword_2(), null); 
                
            match(input,40,FollowSets000.FOLLOW_40_in_ruleJavaExecutable4354); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2696:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2697:2: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2698:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionExecutableRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable4390);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();
            _fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpressionExecutable4400); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2705:1: ruleExpressionExecutable returns [EObject current=null] : ( (lv_exprstr_0_0= RULE_STRING ) ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2710:6: ( ( (lv_exprstr_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2711:1: ( (lv_exprstr_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2711:1: ( (lv_exprstr_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2712:1: (lv_exprstr_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2712:1: (lv_exprstr_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2713:3: lv_exprstr_0_0= RULE_STRING
            {
            lv_exprstr_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleExpressionExecutable4441); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEPatch_in_entryRuleEPatch75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPatch85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleEPatch120 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch137 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleEPatch152 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_ruleImport_in_ruleEPatch173 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch195 = new BitSet(new long[]{0x0000000004404000L});
        public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch217 = new BitSet(new long[]{0x0000000004004000L});
        public static final BitSet FOLLOW_14_in_ruleEPatch228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport264 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelImport_in_ruleImport321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport410 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelImport420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport529 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleResourceImport574 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport591 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleResourceImport606 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport664 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEPackageImport709 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport726 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEPackageImport741 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleJavaImport844 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJavaImport854 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport871 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleJavaImport887 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport904 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport947 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleExtensionImport992 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleExtensionImport1002 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1019 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleExtensionImport1035 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1052 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1095 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNamedResource1140 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1157 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleNamedResource1172 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNamedResource1182 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_16_in_ruleNamedResource1194 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1211 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1244 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedResource1255 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleNamedResource1265 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_16_in_ruleNamedResource1277 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1294 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1327 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedResource1338 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleNamedResource1348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1386 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleObjectRef1431 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1448 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1474 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1491 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_23_in_ruleObjectRef1514 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1532 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1549 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleObjectRef1564 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1582 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1599 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleObjectRef1617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1639 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1666 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_23_in_ruleObjectRef1679 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1700 = new BitSet(new long[]{0x0000000002004000L});
        public static final BitSet FOLLOW_25_in_ruleObjectRef1713 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1734 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObjectRef1746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment1786 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment1796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment1838 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment1853 = new BitSet(new long[]{0x0000000E00000030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1874 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment1884 = new BitSet(new long[]{0x0000000E00000030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1905 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment1915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment1951 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment1961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2003 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBiListAssignment2018 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleBiListAssignment2028 = new BitSet(new long[]{0x0000000010000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2050 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_30_in_ruleBiListAssignment2061 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2082 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_28_in_ruleBiListAssignment2096 = new BitSet(new long[]{0x0000000080000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2118 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleBiListAssignment2129 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2150 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_31_in_ruleBiListAssignment2164 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleBiListAssignment2174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2210 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2262 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2277 = new BitSet(new long[]{0x0000000E00000030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2298 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2396 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2411 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2421 = new BitSet(new long[]{0x0000000C80000030L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2443 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleMonoListAssignment2454 = new BitSet(new long[]{0x0000000C00000030L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2475 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_31_in_ruleMonoListAssignment2489 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMonoListAssignment2499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue2545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue2587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2617 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAssignmentValue2628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2645 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAssignmentValue2661 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue2678 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleAssignmentValue2693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue2725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2750 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue2767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue2809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue2819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue2861 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleListAssignmentValue2876 = new BitSet(new long[]{0x0000000C20000030L});
        public static final BitSet FOLLOW_29_in_ruleListAssignmentValue2888 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue2905 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleListAssignmentValue2920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue2944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue2974 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleListAssignmentValue2985 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3002 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3018 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3035 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3107 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3286 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue3297 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3314 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue3330 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3347 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue3362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3419 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue3436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject3478 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject3488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject3536 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject3563 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject3580 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCreatedObject3597 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject3619 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject3646 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject3669 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCreatedObject3680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew3718 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew3728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleObjectNew3763 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew3781 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew3798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy3839 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy3849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleObjectCopy3884 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy3902 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy3919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration3960 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMigration3970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMigration4005 = new BitSet(new long[]{0x0000006001040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4026 = new BitSet(new long[]{0x0000006001000000L});
        public static final BitSet FOLLOW_37_in_ruleMigration4039 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4060 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_38_in_ruleMigration4078 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4099 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMigration4112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable4148 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExecutable4158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable4205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable4232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable4267 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable4277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleJavaExecutable4312 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable4329 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleJavaExecutable4344 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleJavaExecutable4354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable4390 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable4400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable4441 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:80:1: ruleEPatch returns [EObject current=null] : ( 'epatch' (lv_name_1= RULE_ID ) '{' (lv_imports_3= ruleImport )* (lv_resources_4= ruleNamedResource )* (lv_objects_5= ruleObjectRef )* '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_imports_3 = null;

        EObject lv_resources_4 = null;

        EObject lv_objects_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:85:6: ( ( 'epatch' (lv_name_1= RULE_ID ) '{' (lv_imports_3= ruleImport )* (lv_resources_4= ruleNamedResource )* (lv_objects_5= ruleObjectRef )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:1: ( 'epatch' (lv_name_1= RULE_ID ) '{' (lv_imports_3= ruleImport )* (lv_resources_4= ruleNamedResource )* (lv_objects_5= ruleObjectRef )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:1: ( 'epatch' (lv_name_1= RULE_ID ) '{' (lv_imports_3= ruleImport )* (lv_resources_4= ruleNamedResource )* (lv_objects_5= ruleObjectRef )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:2: 'epatch' (lv_name_1= RULE_ID ) '{' (lv_imports_3= ruleImport )* (lv_resources_4= ruleNamedResource )* (lv_objects_5= ruleObjectRef )* '}'
            {
            match(input,12,FOLLOW_12_in_ruleEPatch117); 

                    createLeafNode(grammarAccess.getEPatchAccess().getEpatchKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:90:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:92:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPatch139); 

            		createLeafNode(grammarAccess.getEPatchAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,13,FOLLOW_13_in_ruleEPatch156); 

                    createLeafNode(grammarAccess.getEPatchAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:114:1: (lv_imports_3= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:117:6: lv_imports_3= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getImportsImportParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleEPatch190);
            	    lv_imports_3=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "imports", lv_imports_3, "Import", currentNode);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:135:3: (lv_resources_4= ruleNamedResource )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:138:6: lv_resources_4= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getResourcesNamedResourceParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResource_in_ruleEPatch229);
            	    lv_resources_4=ruleNamedResource();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "resources", lv_resources_4, "NamedResource", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:156:3: (lv_objects_5= ruleObjectRef )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:159:6: lv_objects_5= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPatchAccess().getObjectsObjectRefParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleObjectRef_in_ruleEPatch268);
            	    lv_objects_5=ruleObjectRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPatchRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "objects", lv_objects_5, "ObjectRef", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleEPatch282); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:188:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:188:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:189:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport315);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport325); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:196:1: ruleImport returns [EObject current=null] : (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport_0 = null;

        EObject this_JavaImport_1 = null;

        EObject this_ExtensionImport_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:6: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                switch ( input.LA(2) ) {
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
                case RULE_ID:
                    {
                    alt4=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("202:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("202:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:203:5: this_ModelImport_0= ruleModelImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getModelImportParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleModelImport_in_ruleImport372);
                    this_ModelImport_0=ruleModelImport();
                    _fsp--;

                     
                            current = this_ModelImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:213:5: this_JavaImport_1= ruleJavaImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getJavaImportParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaImport_in_ruleImport399);
                    this_JavaImport_1=ruleJavaImport();
                    _fsp--;

                     
                            current = this_JavaImport_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:223:5: this_ExtensionImport_2= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getImportAccess().getExtensionImportParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExtensionImport_in_ruleImport426);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:238:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:238:53: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:239:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelImport_in_entryRuleModelImport458);
            iv_ruleModelImport=ruleModelImport();
            _fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelImport468); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:246:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport_0 = null;

        EObject this_EPackageImport_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:251:6: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:252:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:252:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
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
                            new NoViableAltException("252:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("252:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("252:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:253:5: this_ResourceImport_0= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelImportAccess().getResourceImportParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceImport_in_ruleModelImport515);
                    this_ResourceImport_0=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:263:5: this_EPackageImport_1= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelImportAccess().getEPackageImportParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEPackageImport_in_ruleModelImport542);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:278:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:278:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:279:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceImport_in_entryRuleResourceImport574);
            iv_ruleResourceImport=ruleResourceImport();
            _fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceImport584); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:286:1: ruleResourceImport returns [EObject current=null] : ( 'import' (lv_name_1= RULE_ID ) 'uri' (lv_uri_3= RULE_STRING ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_uri_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:291:6: ( ( 'import' (lv_name_1= RULE_ID ) 'uri' (lv_uri_3= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:1: ( 'import' (lv_name_1= RULE_ID ) 'uri' (lv_uri_3= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:1: ( 'import' (lv_name_1= RULE_ID ) 'uri' (lv_uri_3= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:2: 'import' (lv_name_1= RULE_ID ) 'uri' (lv_uri_3= RULE_STRING )
            {
            match(input,15,FOLLOW_15_in_ruleResourceImport618); 

                    createLeafNode(grammarAccess.getResourceImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:298:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceImport640); 

            		createLeafNode(grammarAccess.getResourceImportAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleResourceImport657); 

                    createLeafNode(grammarAccess.getResourceImportAccess().getUriKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:320:1: (lv_uri_3= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:322:6: lv_uri_3= RULE_STRING
            {
            lv_uri_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceImport679); 

            		createLeafNode(grammarAccess.getResourceImportAccess().getUriSTRINGTerminalRuleCall_3_0(), "uri"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "uri", lv_uri_3, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleResourceImport


    // $ANTLR start entryRuleEPackageImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:347:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:347:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:348:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPackageImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport720);
            iv_ruleEPackageImport=ruleEPackageImport();
            _fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageImport730); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:355:1: ruleEPackageImport returns [EObject current=null] : ( 'import' (lv_name_1= RULE_ID ) 'ns' (lv_nsURI_3= RULE_STRING ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_nsURI_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:6: ( ( 'import' (lv_name_1= RULE_ID ) 'ns' (lv_nsURI_3= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:361:1: ( 'import' (lv_name_1= RULE_ID ) 'ns' (lv_nsURI_3= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:361:1: ( 'import' (lv_name_1= RULE_ID ) 'ns' (lv_nsURI_3= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:361:2: 'import' (lv_name_1= RULE_ID ) 'ns' (lv_nsURI_3= RULE_STRING )
            {
            match(input,15,FOLLOW_15_in_ruleEPackageImport764); 

                    createLeafNode(grammarAccess.getEPackageImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:365:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPackageImport786); 

            		createLeafNode(grammarAccess.getEPackageImportAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,17,FOLLOW_17_in_ruleEPackageImport803); 

                    createLeafNode(grammarAccess.getEPackageImportAccess().getNsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:389:1: (lv_nsURI_3= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:391:6: lv_nsURI_3= RULE_STRING
            {
            lv_nsURI_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageImport825); 

            		createLeafNode(grammarAccess.getEPackageImportAccess().getNsURISTRINGTerminalRuleCall_3_0(), "nsURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "nsURI", lv_nsURI_3, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleEPackageImport


    // $ANTLR start entryRuleJavaImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:416:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:416:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:417:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaImport_in_entryRuleJavaImport866);
            iv_ruleJavaImport=ruleJavaImport();
            _fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaImport876); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:424:1: ruleJavaImport returns [EObject current=null] : ( 'import' 'java' (lv_path_2= RULE_ID ) ( '.' (lv_path_4= RULE_ID ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2=null;
        Token lv_path_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:429:6: ( ( 'import' 'java' (lv_path_2= RULE_ID ) ( '.' (lv_path_4= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:1: ( 'import' 'java' (lv_path_2= RULE_ID ) ( '.' (lv_path_4= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:1: ( 'import' 'java' (lv_path_2= RULE_ID ) ( '.' (lv_path_4= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:2: 'import' 'java' (lv_path_2= RULE_ID ) ( '.' (lv_path_4= RULE_ID ) )*
            {
            match(input,15,FOLLOW_15_in_ruleJavaImport910); 

                    createLeafNode(grammarAccess.getJavaImportAccess().getImportKeyword_0(), null); 
                
            match(input,18,FOLLOW_18_in_ruleJavaImport919); 

                    createLeafNode(grammarAccess.getJavaImportAccess().getJavaKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:1: (lv_path_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:440:6: lv_path_2= RULE_ID
            {
            lv_path_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport941); 

            		createLeafNode(grammarAccess.getJavaImportAccess().getPathIDTerminalRuleCall_2_0(), "path"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "path", lv_path_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:458:2: ( '.' (lv_path_4= RULE_ID ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:458:3: '.' (lv_path_4= RULE_ID )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleJavaImport959); 

            	            createLeafNode(grammarAccess.getJavaImportAccess().getFullStopKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:462:1: (lv_path_4= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:464:6: lv_path_4= RULE_ID
            	    {
            	    lv_path_4=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport981); 

            	    		createLeafNode(grammarAccess.getJavaImportAccess().getPathIDTerminalRuleCall_3_1_0(), "path"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getJavaImportRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "path", lv_path_4, "ID", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:489:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:489:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:490:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtensionImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1024);
            iv_ruleExtensionImport=ruleExtensionImport();
            _fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtensionImport1034); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:497:1: ruleExtensionImport returns [EObject current=null] : ( 'import' 'extension' (lv_path_2= RULE_ID ) ( '::' (lv_path_4= RULE_ID ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2=null;
        Token lv_path_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:502:6: ( ( 'import' 'extension' (lv_path_2= RULE_ID ) ( '::' (lv_path_4= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:503:1: ( 'import' 'extension' (lv_path_2= RULE_ID ) ( '::' (lv_path_4= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:503:1: ( 'import' 'extension' (lv_path_2= RULE_ID ) ( '::' (lv_path_4= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:503:2: 'import' 'extension' (lv_path_2= RULE_ID ) ( '::' (lv_path_4= RULE_ID ) )*
            {
            match(input,15,FOLLOW_15_in_ruleExtensionImport1068); 

                    createLeafNode(grammarAccess.getExtensionImportAccess().getImportKeyword_0(), null); 
                
            match(input,20,FOLLOW_20_in_ruleExtensionImport1077); 

                    createLeafNode(grammarAccess.getExtensionImportAccess().getExtensionKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:511:1: (lv_path_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:6: lv_path_2= RULE_ID
            {
            lv_path_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1099); 

            		createLeafNode(grammarAccess.getExtensionImportAccess().getPathIDTerminalRuleCall_2_0(), "path"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExtensionImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "path", lv_path_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:531:2: ( '::' (lv_path_4= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:531:3: '::' (lv_path_4= RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleExtensionImport1117); 

            	            createLeafNode(grammarAccess.getExtensionImportAccess().getColonColonKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:535:1: (lv_path_4= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:537:6: lv_path_4= RULE_ID
            	    {
            	    lv_path_4=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1139); 

            	    		createLeafNode(grammarAccess.getExtensionImportAccess().getPathIDTerminalRuleCall_3_1_0(), "path"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getExtensionImportRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "path", lv_path_4, "ID", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:562:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:562:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:563:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedResourceRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedResource_in_entryRuleNamedResource1182);
            iv_ruleNamedResource=ruleNamedResource();
            _fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResource1192); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:570:1: ruleNamedResource returns [EObject current=null] : ( 'resource' (lv_name_1= RULE_ID ) '{' 'left' ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ';' 'right' ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ';' '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_leftUri_5=null;
        Token lv_rightUri_10=null;
        EObject lv_leftRoot_6 = null;

        EObject lv_rightRoot_11 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:575:6: ( ( 'resource' (lv_name_1= RULE_ID ) '{' 'left' ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ';' 'right' ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ';' '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:576:1: ( 'resource' (lv_name_1= RULE_ID ) '{' 'left' ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ';' 'right' ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ';' '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:576:1: ( 'resource' (lv_name_1= RULE_ID ) '{' 'left' ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ';' 'right' ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ';' '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:576:2: 'resource' (lv_name_1= RULE_ID ) '{' 'left' ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ';' 'right' ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ';' '}'
            {
            match(input,22,FOLLOW_22_in_ruleNamedResource1226); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getResourceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:582:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedResource1248); 

            		createLeafNode(grammarAccess.getNamedResourceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,13,FOLLOW_13_in_ruleNamedResource1265); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            match(input,23,FOLLOW_23_in_ruleNamedResource1274); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getLeftKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:608:1: ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )
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
                    new NoViableAltException("608:1: ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:608:2: ( 'uri' (lv_leftUri_5= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:608:2: ( 'uri' (lv_leftUri_5= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:608:3: 'uri' (lv_leftUri_5= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1285); 

                            createLeafNode(grammarAccess.getNamedResourceAccess().getUriKeyword_4_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:612:1: (lv_leftUri_5= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:614:6: lv_leftUri_5= RULE_STRING
                    {
                    lv_leftUri_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1307); 

                    		createLeafNode(grammarAccess.getNamedResourceAccess().getLeftUriSTRINGTerminalRuleCall_4_0_1_0(), "leftUri"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "leftUri", lv_leftUri_5, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:633:6: (lv_leftRoot_6= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:633:6: (lv_leftRoot_6= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:636:6: lv_leftRoot_6= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedResourceAccess().getLeftRootCreatedObjectParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1356);
                    lv_leftRoot_6=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "leftRoot", lv_leftRoot_6, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1370); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getSemicolonKeyword_5(), null); 
                
            match(input,25,FOLLOW_25_in_ruleNamedResource1379); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getRightKeyword_6(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:662:1: ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )
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
                    new NoViableAltException("662:1: ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:662:2: ( 'uri' (lv_rightUri_10= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:662:2: ( 'uri' (lv_rightUri_10= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:662:3: 'uri' (lv_rightUri_10= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1390); 

                            createLeafNode(grammarAccess.getNamedResourceAccess().getUriKeyword_7_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:666:1: (lv_rightUri_10= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:668:6: lv_rightUri_10= RULE_STRING
                    {
                    lv_rightUri_10=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1412); 

                    		createLeafNode(grammarAccess.getNamedResourceAccess().getRightUriSTRINGTerminalRuleCall_7_0_1_0(), "rightUri"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "rightUri", lv_rightUri_10, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:687:6: (lv_rightRoot_11= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:687:6: (lv_rightRoot_11= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:690:6: lv_rightRoot_11= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedResourceAccess().getRightRootCreatedObjectParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1461);
                    lv_rightRoot_11=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedResourceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "rightRoot", lv_rightRoot_11, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1475); 

                    createLeafNode(grammarAccess.getNamedResourceAccess().getSemicolonKeyword_8(), null); 
                
            match(input,14,FOLLOW_14_in_ruleNamedResource1484); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:725:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:725:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:726:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectRef_in_entryRuleObjectRef1519);
            iv_ruleObjectRef=ruleObjectRef();
            _fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectRef1529); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:733:1: ruleObjectRef returns [EObject current=null] : ( 'object' (lv_name_1= RULE_ID )? ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}' )? ) ;
    public final EObject ruleObjectRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_leftFrag_3=null;
        Token lv_leftFrag_6=null;
        Token lv_rightFrag_9=null;
        EObject lv_assignments_11 = null;

        EObject lv_assignments_12 = null;

        EObject lv_leftMig_14 = null;

        EObject lv_rightMig_16 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:738:6: ( ( 'object' (lv_name_1= RULE_ID )? ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:1: ( 'object' (lv_name_1= RULE_ID )? ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:1: ( 'object' (lv_name_1= RULE_ID )? ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:2: 'object' (lv_name_1= RULE_ID )? ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}' )?
            {
            match(input,26,FOLLOW_26_in_ruleObjectRef1563); 

                    createLeafNode(grammarAccess.getObjectRefAccess().getObjectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:743:1: (lv_name_1= RULE_ID )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:745:6: lv_name_1= RULE_ID
                    {
                    lv_name_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1585); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:3: ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )
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
                    new NoViableAltException("763:3: ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:4: ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:4: ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:5: ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:763:5: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1618); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_0_0_0(), "leftRes"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:780:2: (lv_leftFrag_3= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:782:6: lv_leftFrag_3= RULE_FRAGMENT
                    {
                    lv_leftFrag_3=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1647); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_0_1_0(), "leftFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "leftFrag", lv_leftFrag_3, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:6: ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:6: ( 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:7: 'left' ( RULE_ID ) (lv_leftFrag_6= RULE_FRAGMENT ) 'right' ( RULE_ID ) (lv_rightFrag_9= RULE_FRAGMENT )
                    {
                    match(input,23,FOLLOW_23_in_ruleObjectRef1672); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getLeftKeyword_2_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:805:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:808:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1694); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_1_1_0(), "leftRes"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:822:2: (lv_leftFrag_6= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:824:6: lv_leftFrag_6= RULE_FRAGMENT
                    {
                    lv_leftFrag_6=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1723); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_1_2_0(), "leftFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "leftFrag", lv_leftFrag_6, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,25,FOLLOW_25_in_ruleObjectRef1740); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getRightKeyword_2_1_3(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:846:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:849:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1762); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getRightResNamedResourceCrossReference_2_1_4_0(), "rightRes"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:863:2: (lv_rightFrag_9= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:865:6: lv_rightFrag_9= RULE_FRAGMENT
                    {
                    lv_rightFrag_9=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1791); 

                    		createLeafNode(grammarAccess.getObjectRefAccess().getRightFragFRAGMENTTerminalRuleCall_2_1_5_0(), "rightFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "rightFrag", lv_rightFrag_9, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:883:4: ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:883:5: '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ( 'left' (lv_leftMig_14= ruleMigration ) )? ( 'right' (lv_rightMig_16= ruleMigration ) )? '}'
                    {
                    match(input,13,FOLLOW_13_in_ruleObjectRef1811); 

                            createLeafNode(grammarAccess.getObjectRefAccess().getLeftCurlyBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:887:1: ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:887:2: (lv_assignments_11= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:887:2: (lv_assignments_11= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:890:6: lv_assignments_11= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1846);
                    	    lv_assignments_11=ruleBiSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "assignments", lv_assignments_11, "BiSingleAssignment", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:909:6: (lv_assignments_12= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:909:6: (lv_assignments_12= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:912:6: lv_assignments_12= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiListAssignmentParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiListAssignment_in_ruleObjectRef1890);
                    	    lv_assignments_12=ruleBiListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "assignments", lv_assignments_12, "BiListAssignment", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:4: ( 'left' (lv_leftMig_14= ruleMigration ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:5: 'left' (lv_leftMig_14= ruleMigration )
                            {
                            match(input,23,FOLLOW_23_in_ruleObjectRef1906); 

                                    createLeafNode(grammarAccess.getObjectRefAccess().getLeftKeyword_3_2_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:934:1: (lv_leftMig_14= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:937:6: lv_leftMig_14= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getLeftMigMigrationParserRuleCall_3_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef1940);
                            lv_leftMig_14=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "leftMig", lv_leftMig_14, "Migration", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:955:4: ( 'right' (lv_rightMig_16= ruleMigration ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:955:5: 'right' (lv_rightMig_16= ruleMigration )
                            {
                            match(input,25,FOLLOW_25_in_ruleObjectRef1956); 

                                    createLeafNode(grammarAccess.getObjectRefAccess().getRightKeyword_3_3_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:959:1: (lv_rightMig_16= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:962:6: lv_rightMig_16= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getObjectRefAccess().getRightMigMigrationParserRuleCall_3_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef1990);
                            lv_rightMig_16=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getObjectRefRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "rightMig", lv_rightMig_16, "Migration", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,14,FOLLOW_14_in_ruleObjectRef2005); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:993:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:993:60: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:994:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBiSingleAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2042);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();
            _fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiSingleAssignment2052); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1001:1: ruleBiSingleAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) '|' (lv_rightValue_4= ruleSingleAssignmentValue ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValue_2 = null;

        EObject lv_rightValue_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:6: ( ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) '|' (lv_rightValue_4= ruleSingleAssignmentValue ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:1: ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) '|' (lv_rightValue_4= ruleSingleAssignmentValue ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:1: ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) '|' (lv_rightValue_4= ruleSingleAssignmentValue ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) '|' (lv_rightValue_4= ruleSingleAssignmentValue ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1009:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiSingleAssignment2099); 

            		createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleBiSingleAssignment2116); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1031:1: (lv_leftValue_2= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1034:6: lv_leftValue_2= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2150);
            lv_leftValue_2=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "leftValue", lv_leftValue_2, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,28,FOLLOW_28_in_ruleBiSingleAssignment2163); 

                    createLeafNode(grammarAccess.getBiSingleAssignmentAccess().getVerticalLineKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1056:1: (lv_rightValue_4= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1059:6: lv_rightValue_4= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getRightValueSingleAssignmentValueParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2197);
            lv_rightValue_4=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "rightValue", lv_rightValue_4, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,24,FOLLOW_24_in_ruleBiSingleAssignment2210); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBiListAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2243);
            iv_ruleBiListAssignment=ruleBiListAssignment();
            _fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiListAssignment2253); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1096:1: ruleBiListAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? '|' ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ']' ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValues_3 = null;

        EObject lv_leftValues_5 = null;

        EObject lv_rightValues_7 = null;

        EObject lv_rightValues_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:6: ( ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? '|' ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ']' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:1: ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? '|' ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ']' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:1: ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? '|' ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ']' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:2: (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? '|' ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ']' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1104:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiListAssignment2300); 

            		createLeafNode(grammarAccess.getBiListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleBiListAssignment2317); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            match(input,29,FOLLOW_29_in_ruleBiListAssignment2326); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1130:1: ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1130:2: (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1130:2: (lv_leftValues_3= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1133:6: lv_leftValues_3= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2361);
                    lv_leftValues_3=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "leftValues", lv_leftValues_3, "ListAssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1151:2: ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1151:3: ',' (lv_leftValues_5= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2375); 

                    	            createLeafNode(grammarAccess.getBiListAssignmentAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1155:1: (lv_leftValues_5= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1158:6: lv_leftValues_5= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2409);
                    	    lv_leftValues_5=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "leftValues", lv_leftValues_5, "ListAssignmentValue", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            match(input,28,FOLLOW_28_in_ruleBiListAssignment2426); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getVerticalLineKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:1: ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:2: (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:2: (lv_rightValues_7= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1183:6: lv_rightValues_7= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2461);
                    lv_rightValues_7=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "rightValues", lv_rightValues_7, "ListAssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1201:2: ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1201:3: ',' (lv_rightValues_9= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2475); 

                    	            createLeafNode(grammarAccess.getBiListAssignmentAccess().getCommaKeyword_5_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1205:1: (lv_rightValues_9= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1208:6: lv_rightValues_9= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2509);
                    	    lv_rightValues_9=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBiListAssignmentRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "rightValues", lv_rightValues_9, "ListAssignmentValue", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            match(input,31,FOLLOW_31_in_ruleBiListAssignment2526); 

                    createLeafNode(grammarAccess.getBiListAssignmentAccess().getRightSquareBracketKeyword_6(), null); 
                
            match(input,24,FOLLOW_24_in_ruleBiListAssignment2535); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1241:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1241:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1242:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMonoSingleAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2568);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();
            _fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoSingleAssignment2578); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1249:1: ruleMonoSingleAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValue_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1254:6: ( ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:1: ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:1: ( (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:2: (lv_feature_0= RULE_ID ) '=' (lv_leftValue_2= ruleSingleAssignmentValue ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2625); 

            		createLeafNode(grammarAccess.getMonoSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMonoSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleMonoSingleAssignment2642); 

                    createLeafNode(grammarAccess.getMonoSingleAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1279:1: (lv_leftValue_2= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1282:6: lv_leftValue_2= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMonoSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2676);
            lv_leftValue_2=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMonoSingleAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "leftValue", lv_leftValue_2, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,24,FOLLOW_24_in_ruleMonoSingleAssignment2689); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1311:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1311:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1312:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMonoListAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2722);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();
            _fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoListAssignment2732); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1319:1: ruleMonoListAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ']' ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValues_3 = null;

        EObject lv_leftValues_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1324:6: ( ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ']' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1325:1: ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ']' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1325:1: ( (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ']' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1325:2: (lv_feature_0= RULE_ID ) '=' '[' ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ']' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1325:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1327:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoListAssignment2779); 

            		createLeafNode(grammarAccess.getMonoListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMonoListAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleMonoListAssignment2796); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getEqualsSignKeyword_1(), null); 
                
            match(input,29,FOLLOW_29_in_ruleMonoListAssignment2805); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1353:1: ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1353:2: (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1353:2: (lv_leftValues_3= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1356:6: lv_leftValues_3= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2840);
                    lv_leftValues_3=ruleAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMonoListAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "leftValues", lv_leftValues_3, "AssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1374:2: ( ',' (lv_leftValues_5= ruleAssignmentValue ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1374:3: ',' (lv_leftValues_5= ruleAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleMonoListAssignment2854); 

                    	            createLeafNode(grammarAccess.getMonoListAssignmentAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1378:1: (lv_leftValues_5= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1381:6: lv_leftValues_5= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2888);
                    	    lv_leftValues_5=ruleAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMonoListAssignmentRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "leftValues", lv_leftValues_5, "AssignmentValue", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            match(input,31,FOLLOW_31_in_ruleMonoListAssignment2905); 

                    createLeafNode(grammarAccess.getMonoListAssignmentAccess().getRightSquareBracketKeyword_4(), null); 
                
            match(input,24,FOLLOW_24_in_ruleMonoListAssignment2914); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1414:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1414:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1415:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2947);
            iv_ruleAssignmentValue=ruleAssignmentValue();
            _fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentValue2957); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1422:1: ruleAssignmentValue returns [EObject current=null] : ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? ) | (lv_newObject_7= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;
        Token lv_refFeature_3=null;
        Token lv_refIndex_5=null;
        Token lv_impFrag_9=null;
        EObject lv_newObject_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1427:6: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? ) | (lv_newObject_7= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1428:1: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? ) | (lv_newObject_7= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1428:1: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? ) | (lv_newObject_7= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1428:1: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? ) | (lv_newObject_7= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )", 24, 2, input);

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
                    new NoViableAltException("1428:1: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? ) | (lv_newObject_7= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1428:2: (lv_value_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1428:2: (lv_value_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:6: lv_value_0= RULE_STRING
                    {
                    lv_value_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssignmentValue3004); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getValueSTRINGTerminalRuleCall_0_0(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_0, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:6: ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:6: ( ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:7: ( RULE_ID ) ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1452:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3041); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getRefObjectNamedObjectCrossReference_1_0_0(), "refObject"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:2: ( '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:3: '.' (lv_refFeature_3= RULE_ID ) ( '[' (lv_refIndex_5= RULE_INT ) ']' )?
                            {
                            match(input,19,FOLLOW_19_in_ruleAssignmentValue3058); 

                                    createLeafNode(grammarAccess.getAssignmentValueAccess().getFullStopKeyword_1_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:1: (lv_refFeature_3= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:6: lv_refFeature_3= RULE_ID
                            {
                            lv_refFeature_3=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3080); 

                            		createLeafNode(grammarAccess.getAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_1_1_1_0(), "refFeature"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "refFeature", lv_refFeature_3, "ID", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:2: ( '[' (lv_refIndex_5= RULE_INT ) ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:3: '[' (lv_refIndex_5= RULE_INT ) ']'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleAssignmentValue3098); 

                                            createLeafNode(grammarAccess.getAssignmentValueAccess().getLeftSquareBracketKeyword_1_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1494:1: (lv_refIndex_5= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1496:6: lv_refIndex_5= RULE_INT
                                    {
                                    lv_refIndex_5=(Token)input.LT(1);
                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignmentValue3120); 

                                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getRefIndexINTTerminalRuleCall_1_1_2_1_0(), "refIndex"); 
                                    	

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "refIndex", lv_refIndex_5, "INT", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }

                                    match(input,31,FOLLOW_31_in_ruleAssignmentValue3137); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:6: (lv_newObject_7= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:6: (lv_newObject_7= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1522:6: lv_newObject_7= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3182);
                    lv_newObject_7=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "newObject", lv_newObject_7, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:6: ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:6: ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:7: ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1544:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3215); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getImportImportCrossReference_3_0_0(), "import"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1558:2: (lv_impFrag_9= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1560:6: lv_impFrag_9= RULE_FRAGMENT
                    {
                    lv_impFrag_9=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3244); 

                    		createLeafNode(grammarAccess.getAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_3_1_0(), "impFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "impFrag", lv_impFrag_9, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1585:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1585:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1586:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListAssignmentValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3286);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();
            _fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListAssignmentValue3296); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1593:1: ruleListAssignmentValue returns [EObject current=null] : ( (lv_index_0= RULE_INT ) ':' ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_index_0=null;
        Token lv_refIndex_3=null;
        Token lv_value_5=null;
        Token lv_refFeature_8=null;
        Token lv_refIndex_10=null;
        Token lv_impFrag_14=null;
        EObject lv_newObject_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:6: ( ( (lv_index_0= RULE_INT ) ':' ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:1: ( (lv_index_0= RULE_INT ) ':' ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:1: ( (lv_index_0= RULE_INT ) ':' ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:2: (lv_index_0= RULE_INT ) ':' ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:2: (lv_index_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1601:6: lv_index_0= RULE_INT
            {
            lv_index_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3343); 

            		createLeafNode(grammarAccess.getListAssignmentValueAccess().getIndexINTTerminalRuleCall_0_0(), "index"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "index", lv_index_0, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,32,FOLLOW_32_in_ruleListAssignmentValue3360); 

                    createLeafNode(grammarAccess.getListAssignmentValueAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:1: ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1623:1: ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )", 27, 3, input);

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
                    new NoViableAltException("1623:1: ( ( '[' (lv_refIndex_3= RULE_INT ) ']' ) | (lv_value_5= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? ) | (lv_newObject_12= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:2: ( '[' (lv_refIndex_3= RULE_INT ) ']' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:2: ( '[' (lv_refIndex_3= RULE_INT ) ']' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:3: '[' (lv_refIndex_3= RULE_INT ) ']'
                    {
                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue3371); 

                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1627:1: (lv_refIndex_3= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1629:6: lv_refIndex_3= RULE_INT
                    {
                    lv_refIndex_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3393); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_0_1_0(), "refIndex"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "refIndex", lv_refIndex_3, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue3410); 

                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1652:6: (lv_value_5= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1652:6: (lv_value_5= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1654:6: lv_value_5= RULE_STRING
                    {
                    lv_value_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleListAssignmentValue3439); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_5, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1673:6: ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1673:6: ( ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1673:7: ( RULE_ID ) ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1673:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1676:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3476); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_2_0_0(), "refObject"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1690:2: ( '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1690:3: '.' (lv_refFeature_8= RULE_ID ) ( '[' (lv_refIndex_10= RULE_INT ) ']' )?
                            {
                            match(input,19,FOLLOW_19_in_ruleListAssignmentValue3493); 

                                    createLeafNode(grammarAccess.getListAssignmentValueAccess().getFullStopKeyword_2_2_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1694:1: (lv_refFeature_8= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1696:6: lv_refFeature_8= RULE_ID
                            {
                            lv_refFeature_8=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3515); 

                            		createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_2_1_1_0(), "refFeature"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "refFeature", lv_refFeature_8, "ID", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1714:2: ( '[' (lv_refIndex_10= RULE_INT ) ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1714:3: '[' (lv_refIndex_10= RULE_INT ) ']'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue3533); 

                                            createLeafNode(grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_2_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1718:1: (lv_refIndex_10= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1720:6: lv_refIndex_10= RULE_INT
                                    {
                                    lv_refIndex_10=(Token)input.LT(1);
                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3555); 

                                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_2_1_2_1_0(), "refIndex"); 
                                    	

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "refIndex", lv_refIndex_10, "INT", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }

                                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue3572); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1743:6: (lv_newObject_12= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1743:6: (lv_newObject_12= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1746:6: lv_newObject_12= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getListAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3617);
                    lv_newObject_12=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "newObject", lv_newObject_12, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:6: ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:6: ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:7: ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1768:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3650); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getImportImportCrossReference_2_4_0_0(), "import"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1782:2: (lv_impFrag_14= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1784:6: lv_impFrag_14= RULE_FRAGMENT
                    {
                    lv_impFrag_14=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3679); 

                    		createLeafNode(grammarAccess.getListAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_2_4_1_0(), "impFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getListAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "impFrag", lv_impFrag_14, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1809:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1809:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1810:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleAssignmentValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3722);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();
            _fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleAssignmentValue3732); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1817:1: ruleSingleAssignmentValue returns [EObject current=null] : ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? ) | (lv_newObject_8= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0=null;
        Token lv_value_1=null;
        Token lv_refFeature_4=null;
        Token lv_refIndex_6=null;
        Token lv_impFrag_10=null;
        EObject lv_newObject_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1822:6: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? ) | (lv_newObject_8= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:1: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? ) | (lv_newObject_8= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:1: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? ) | (lv_newObject_8= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1823:1: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? ) | (lv_newObject_8= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )", 30, 3, input);

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
                    new NoViableAltException("1823:1: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) | ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? ) | (lv_newObject_8= ruleCreatedObject ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:2: (lv_keyword_0= 'null' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:2: (lv_keyword_0= 'null' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1825:6: lv_keyword_0= 'null'
                    {
                    lv_keyword_0=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleSingleAssignmentValue3778); 

                            createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getKeywordNullKeyword_0_0(), "keyword"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "keyword", /* lv_keyword_0 */ input.LT(-1), "null", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1845:6: (lv_value_1= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1845:6: (lv_value_1= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1847:6: lv_value_1= RULE_STRING
                    {
                    lv_value_1=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3819); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getValueSTRINGTerminalRuleCall_1_0(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_1, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:6: ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:6: ( ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:7: ( RULE_ID ) ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1869:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3856); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_0_0(), "refObject"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1883:2: ( '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1883:3: '.' (lv_refFeature_4= RULE_ID ) ( '[' (lv_refIndex_6= RULE_INT ) ']' )?
                            {
                            match(input,19,FOLLOW_19_in_ruleSingleAssignmentValue3873); 

                                    createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getFullStopKeyword_2_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1887:1: (lv_refFeature_4= RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1889:6: lv_refFeature_4= RULE_ID
                            {
                            lv_refFeature_4=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3895); 

                            		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_1_1_0(), "refFeature"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "refFeature", lv_refFeature_4, "ID", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1907:2: ( '[' (lv_refIndex_6= RULE_INT ) ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1907:3: '[' (lv_refIndex_6= RULE_INT ) ']'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleSingleAssignmentValue3913); 

                                            createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getLeftSquareBracketKeyword_2_1_2_0(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1911:1: (lv_refIndex_6= RULE_INT )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1913:6: lv_refIndex_6= RULE_INT
                                    {
                                    lv_refIndex_6=(Token)input.LT(1);
                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3935); 

                                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_1_2_1_0(), "refIndex"); 
                                    	

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "refIndex", lv_refIndex_6, "INT", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }

                                    match(input,31,FOLLOW_31_in_ruleSingleAssignmentValue3952); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1936:6: (lv_newObject_8= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1936:6: (lv_newObject_8= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1939:6: lv_newObject_8= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSingleAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3997);
                    lv_newObject_8=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "newObject", lv_newObject_8, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:6: ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:6: ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:7: ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1961:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4030); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getImportImportCrossReference_4_0_0(), "import"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1975:2: (lv_impFrag_10= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1977:6: lv_impFrag_10= RULE_FRAGMENT
                    {
                    lv_impFrag_10=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4059); 

                    		createLeafNode(grammarAccess.getSingleAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_4_1_0(), "impFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssignmentValueRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "impFrag", lv_impFrag_10, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2002:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2002:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2003:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCreatedObjectRule(), currentNode); 
            pushFollow(FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4101);
            iv_ruleCreatedObject=ruleCreatedObject();
            _fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreatedObject4111); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:1: ruleCreatedObject returns [EObject current=null] : ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}' )? ) ;
    public final EObject ruleCreatedObject() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject this_ObjectNew_0 = null;

        EObject this_ObjectCopy_1 = null;

        EObject lv_assignments_4 = null;

        EObject lv_assignments_5 = null;

        EObject lv_leftMig_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2015:6: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2016:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2016:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2016:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2016:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
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
                    new NoViableAltException("2016:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2017:5: this_ObjectNew_0= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectNewParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectNew_in_ruleCreatedObject4159);
                    this_ObjectNew_0=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2027:5: this_ObjectCopy_1= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectCopyParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectCopy_in_ruleCreatedObject4186);
                    this_ObjectCopy_1=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2035:2: (lv_name_2= RULE_ID )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreatedObject4208); 

                    		createLeafNode(grammarAccess.getCreatedObjectAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2055:3: ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2055:4: '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ (lv_leftMig_6= ruleMigration )? '}'
                    {
                    match(input,13,FOLLOW_13_in_ruleCreatedObject4227); 

                            createLeafNode(grammarAccess.getCreatedObjectAccess().getLeftCurlyBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2059:1: ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2059:2: (lv_assignments_4= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2059:2: (lv_assignments_4= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2062:6: lv_assignments_4= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4262);
                    	    lv_assignments_4=ruleMonoSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "assignments", lv_assignments_4, "MonoSingleAssignment", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2081:6: (lv_assignments_5= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2081:6: (lv_assignments_5= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2084:6: lv_assignments_5= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoListAssignmentParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4306);
                    	    lv_assignments_5=ruleMonoListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "assignments", lv_assignments_5, "MonoListAssignment", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2102:4: (lv_leftMig_6= ruleMigration )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2105:6: lv_leftMig_6= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getCreatedObjectAccess().getLeftMigMigrationParserRuleCall_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleCreatedObject4346);
                            lv_leftMig_6=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getCreatedObjectRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "leftMig", lv_leftMig_6, "Migration", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;

                    }

                    match(input,14,FOLLOW_14_in_ruleCreatedObject4360); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2134:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2134:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2135:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectNewRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectNew_in_entryRuleObjectNew4395);
            iv_ruleObjectNew=ruleObjectNew();
            _fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectNew4405); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:1: ruleObjectNew returns [EObject current=null] : ( 'new' ( RULE_ID ) (lv_impFrag_2= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2147:6: ( ( 'new' ( RULE_ID ) (lv_impFrag_2= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2148:1: ( 'new' ( RULE_ID ) (lv_impFrag_2= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2148:1: ( 'new' ( RULE_ID ) (lv_impFrag_2= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2148:2: 'new' ( RULE_ID ) (lv_impFrag_2= RULE_FRAGMENT )
            {
            match(input,34,FOLLOW_34_in_ruleObjectNew4439); 

                    createLeafNode(grammarAccess.getObjectNewAccess().getNewKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2152:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2155:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getObjectNewRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectNew4461); 

            		createLeafNode(grammarAccess.getObjectNewAccess().getImportImportCrossReference_1_0(), "import"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2169:2: (lv_impFrag_2= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2171:6: lv_impFrag_2= RULE_FRAGMENT
            {
            lv_impFrag_2=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4490); 

            		createLeafNode(grammarAccess.getObjectNewAccess().getImpFragFRAGMENTTerminalRuleCall_2_0(), "impFrag"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getObjectNewRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "impFrag", lv_impFrag_2, "FRAGMENT", lastConsumedNode);
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
    // $ANTLR end ruleObjectNew


    // $ANTLR start entryRuleObjectCopy
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2196:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2196:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2197:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectCopyRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4531);
            iv_ruleObjectCopy=ruleObjectCopy();
            _fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectCopy4541); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:1: ruleObjectCopy returns [EObject current=null] : ( 'copy' ( RULE_ID ) (lv_fragment_2= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2209:6: ( ( 'copy' ( RULE_ID ) (lv_fragment_2= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2210:1: ( 'copy' ( RULE_ID ) (lv_fragment_2= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2210:1: ( 'copy' ( RULE_ID ) (lv_fragment_2= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2210:2: 'copy' ( RULE_ID ) (lv_fragment_2= RULE_FRAGMENT )
            {
            match(input,35,FOLLOW_35_in_ruleObjectCopy4575); 

                    createLeafNode(grammarAccess.getObjectCopyAccess().getCopyKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2214:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2217:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getObjectCopyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectCopy4597); 

            		createLeafNode(grammarAccess.getObjectCopyAccess().getResourceNamedResourceCrossReference_1_0(), "resource"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2231:2: (lv_fragment_2= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2233:6: lv_fragment_2= RULE_FRAGMENT
            {
            lv_fragment_2=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4626); 

            		createLeafNode(grammarAccess.getObjectCopyAccess().getFragmentFRAGMENTTerminalRuleCall_2_0(), "fragment"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getObjectCopyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "fragment", lv_fragment_2, "FRAGMENT", lastConsumedNode);
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
    // $ANTLR end ruleObjectCopy


    // $ANTLR start entryRuleMigration
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2258:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2258:51: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2259:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMigrationRule(), currentNode); 
            pushFollow(FOLLOW_ruleMigration_in_entryRuleMigration4667);
            iv_ruleMigration=ruleMigration();
            _fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMigration4677); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2266:1: ruleMigration returns [EObject current=null] : ( 'migrate' (lv_first_1= ruleExecutable )? ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1 = null;

        EObject lv_asOp_3 = null;

        EObject lv_eachOp_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2271:6: ( ( 'migrate' (lv_first_1= ruleExecutable )? ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2272:1: ( 'migrate' (lv_first_1= ruleExecutable )? ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2272:1: ( 'migrate' (lv_first_1= ruleExecutable )? ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2272:2: 'migrate' (lv_first_1= ruleExecutable )? ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ';'
            {
            match(input,36,FOLLOW_36_in_ruleMigration4711); 

                    createLeafNode(grammarAccess.getMigrationAccess().getMigrateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2276:1: (lv_first_1= ruleExecutable )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2279:6: lv_first_1= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getFirstExecutableParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4745);
                    lv_first_1=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMigrationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "first", lv_first_1, "Executable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:3: ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:4: ( 'as' (lv_asOp_3= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:4: ( 'as' (lv_asOp_3= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:5: 'as' (lv_asOp_3= ruleExecutable )
                    {
                    match(input,37,FOLLOW_37_in_ruleMigration4761); 

                            createLeafNode(grammarAccess.getMigrationAccess().getAsKeyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2301:1: (lv_asOp_3= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2304:6: lv_asOp_3= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getAsOpExecutableParserRuleCall_2_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4795);
                    lv_asOp_3=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMigrationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "asOp", lv_asOp_3, "Executable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2323:6: ( 'each' (lv_eachOp_5= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2323:6: ( 'each' (lv_eachOp_5= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2323:7: 'each' (lv_eachOp_5= ruleExecutable )
                    {
                    match(input,38,FOLLOW_38_in_ruleMigration4816); 

                            createLeafNode(grammarAccess.getMigrationAccess().getEachKeyword_2_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2327:1: (lv_eachOp_5= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2330:6: lv_eachOp_5= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMigrationAccess().getEachOpExecutableParserRuleCall_2_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4850);
                    lv_eachOp_5=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMigrationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "eachOp", lv_eachOp_5, "Executable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleMigration4866); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2359:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2359:52: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2360:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExecutableRule(), currentNode); 
            pushFollow(FOLLOW_ruleExecutable_in_entryRuleExecutable4899);
            iv_ruleExecutable=ruleExecutable();
            _fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutable4909); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2367:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable_0 = null;

        EObject this_ExpressionExecutable_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2372:6: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2373:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2373:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
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
                    new NoViableAltException("2373:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2374:5: this_JavaExecutable_0= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExecutableAccess().getJavaExecutableParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaExecutable_in_ruleExecutable4956);
                    this_JavaExecutable_0=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2384:5: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExecutableAccess().getExpressionExecutableParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionExecutable_in_ruleExecutable4983);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2399:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2399:56: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2400:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaExecutableRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5015);
            iv_ruleJavaExecutable=ruleJavaExecutable();
            _fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaExecutable5025); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2407:1: ruleJavaExecutable returns [EObject current=null] : ( 'java' (lv_method_1= RULE_ID ) '(' ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2412:6: ( ( 'java' (lv_method_1= RULE_ID ) '(' ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:1: ( 'java' (lv_method_1= RULE_ID ) '(' ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:1: ( 'java' (lv_method_1= RULE_ID ) '(' ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:2: 'java' (lv_method_1= RULE_ID ) '(' ')'
            {
            match(input,18,FOLLOW_18_in_ruleJavaExecutable5059); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getJavaKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2417:1: (lv_method_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2419:6: lv_method_1= RULE_ID
            {
            lv_method_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaExecutable5081); 

            		createLeafNode(grammarAccess.getJavaExecutableAccess().getMethodIDTerminalRuleCall_1_0(), "method"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaExecutableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "method", lv_method_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,39,FOLLOW_39_in_ruleJavaExecutable5098); 

                    createLeafNode(grammarAccess.getJavaExecutableAccess().getLeftParenthesisKeyword_2(), null); 
                
            match(input,40,FOLLOW_40_in_ruleJavaExecutable5107); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2452:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2452:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2453:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionExecutableRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5140);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();
            _fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionExecutable5150); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2460:1: ruleExpressionExecutable returns [EObject current=null] : (lv_exprstr_0= RULE_STRING ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2465:6: ( (lv_exprstr_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2466:1: (lv_exprstr_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2466:1: (lv_exprstr_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2468:6: lv_exprstr_0= RULE_STRING
            {
            lv_exprstr_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleExpressionExecutable5196); 

            		createLeafNode(grammarAccess.getExpressionExecutableAccess().getExprstrSTRINGTerminalRuleCall_0(), "exprstr"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionExecutableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "exprstr", lv_exprstr_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    public static final BitSet FOLLOW_12_in_ruleEPatch117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch139 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEPatch156 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleEPatch190 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch229 = new BitSet(new long[]{0x0000000004404000L});
    public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch268 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleEPatch282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_ruleImport372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelImport468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleResourceImport618 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport640 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResourceImport657 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEPackageImport764 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport786 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageImport803 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJavaImport910 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaImport919 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport941 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleJavaImport959 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport981 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExtensionImport1068 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExtensionImport1077 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1099 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleExtensionImport1117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1139 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNamedResource1226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1248 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamedResource1265 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedResource1274 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1307 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1356 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1370 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNamedResource1379 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1412 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1461 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1475 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedResource1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleObjectRef1563 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1585 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1618 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1647 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1672 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1694 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1723 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1762 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1791 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleObjectRef1811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1846 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1890 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1906 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1940 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1956 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1990 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleObjectRef2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment2099 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment2116 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2150 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment2163 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2197 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2300 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiListAssignment2317 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleBiListAssignment2326 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2361 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2375 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2409 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleBiListAssignment2426 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2461 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2475 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2509 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleBiListAssignment2526 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiListAssignment2535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2625 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2642 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2676 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2779 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2796 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2805 = new BitSet(new long[]{0x0000000C80000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2840 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleMonoListAssignment2854 = new BitSet(new long[]{0x0000000C00000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2888 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleMonoListAssignment2905 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoListAssignment2914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3041 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentValue3058 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3080 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignmentValue3098 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue3120 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentValue3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3215 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3343 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleListAssignmentValue3360 = new BitSet(new long[]{0x0000000C20000030L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3371 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3393 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue3439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3476 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleListAssignmentValue3493 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3515 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3533 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3555 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3650 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3856 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue3873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3895 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue3913 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3935 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4030 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4101 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject4159 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject4186 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject4208 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleCreatedObject4227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4262 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4306 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject4346 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCreatedObject4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew4395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleObjectNew4439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew4461 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy4541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleObjectCopy4575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy4597 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration4667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMigration4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMigration4711 = new BitSet(new long[]{0x0000006001040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4745 = new BitSet(new long[]{0x0000006001000000L});
    public static final BitSet FOLLOW_37_in_ruleMigration4761 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4795 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_38_in_ruleMigration4816 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4850 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMigration4866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable4899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutable4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaExecutable5059 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable5081 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleJavaExecutable5098 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleJavaExecutable5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable5150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable5196 = new BitSet(new long[]{0x0000000000000002L});

}
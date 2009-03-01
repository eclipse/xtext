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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:70:1: entryRuleEPatch returns [EObject current=null] : iv_ruleEPatch= ruleEPatch EOF ;
    public final EObject entryRuleEPatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPatch = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:70:48: (iv_ruleEPatch= ruleEPatch EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:71:2: iv_ruleEPatch= ruleEPatch EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPatch().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPatch_in_entryRuleEPatch72);
            iv_ruleEPatch=ruleEPatch();
            _fsp--;

             current =iv_ruleEPatch; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPatch82); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:78:1: ruleEPatch returns [EObject current=null] : ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_imports_3 = null;

        EObject lv_resources_4 = null;

        EObject lv_objects_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:6: ( ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:1: ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:1: ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:2: ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:2: ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:3: ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:3: ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:4: ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:4: ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:5: ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:5: ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:6: ( 'epatch' (lv_name_1= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:6: ( 'epatch' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:7: 'epatch' (lv_name_1= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleEPatch121); 

                    createLeafNode(grammarAccess.prEPatch().ele000000KeywordEpatch(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:88:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:90:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPatch142); 

            		createLeafNode(grammarAccess.prEPatch().ele0000010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPatch().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEPatch159); 

                    createLeafNode(grammarAccess.prEPatch().ele00001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:111:2: (lv_imports_3= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:114:6: lv_imports_3= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele00010ParserRuleCallImport(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleEPatch194);
            	    lv_imports_3=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPatch().getRule().getType().getType());
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:132:4: (lv_resources_4= ruleNamedResource )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:135:6: lv_resources_4= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele0010ParserRuleCallNamedResource(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResource_in_ruleEPatch234);
            	    lv_resources_4=ruleNamedResource();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPatch().getRule().getType().getType());
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:153:4: (lv_objects_5= ruleObjectRef )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:156:6: lv_objects_5= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele010ParserRuleCallObjectRef(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleObjectRef_in_ruleEPatch274);
            	    lv_objects_5=ruleObjectRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPatch().getRule().getType().getType());
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


            }

            match(input,14,FOLLOW_14_in_ruleEPatch289); 

                    createLeafNode(grammarAccess.prEPatch().ele1KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:187:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:187:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:188:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport324);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport334); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:195:1: ruleImport returns [EObject current=null] : ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport_0 = null;

        EObject this_JavaImport_1 = null;

        EObject this_ExtensionImport_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:200:6: ( ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==20) ) {
                    alt5=2;
                }
                else if ( (LA5_1==RULE_ID||LA5_1==18) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("201:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("201:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==15) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==18) ) {
                            alt4=2;
                        }
                        else if ( (LA4_1==RULE_ID) ) {
                            alt4=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("201:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )", 4, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("201:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:5: this_ModelImport_0= ruleModelImport
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prImport().ele00ParserRuleCallModelImport(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleModelImport_in_ruleImport382);
                            this_ModelImport_0=ruleModelImport();
                            _fsp--;

                             
                                    current = this_ModelImport_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:212:5: this_JavaImport_1= ruleJavaImport
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prImport().ele01ParserRuleCallJavaImport(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleJavaImport_in_ruleImport409);
                            this_JavaImport_1=ruleJavaImport();
                            _fsp--;

                             
                                    current = this_JavaImport_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:222:5: this_ExtensionImport_2= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prImport().ele1ParserRuleCallExtensionImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExtensionImport_in_ruleImport437);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:239:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:239:53: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:240:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModelImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelImport_in_entryRuleModelImport471);
            iv_ruleModelImport=ruleModelImport();
            _fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelImport481); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:247:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport_0 = null;

        EObject this_EPackageImport_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:252:6: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:253:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:253:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_ID) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==16) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==17) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("253:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("253:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("253:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:254:5: this_ResourceImport_0= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModelImport().ele0ParserRuleCallResourceImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceImport_in_ruleModelImport528);
                    this_ResourceImport_0=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:264:5: this_EPackageImport_1= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModelImport().ele1ParserRuleCallEPackageImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEPackageImport_in_ruleModelImport555);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:281:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:281:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:282:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prResourceImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceImport_in_entryRuleResourceImport589);
            iv_ruleResourceImport=ruleResourceImport();
            _fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceImport599); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:289:1: ruleResourceImport returns [EObject current=null] : ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_uri_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:294:6: ( ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:3: ( 'import' (lv_name_1= RULE_ID ) ) 'uri'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:3: ( 'import' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:4: 'import' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleResourceImport635); 

                    createLeafNode(grammarAccess.prResourceImport().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:299:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:301:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceImport656); 

            		createLeafNode(grammarAccess.prResourceImport().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prResourceImport().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleResourceImport673); 

                    createLeafNode(grammarAccess.prResourceImport().ele01KeywordUri(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:322:2: (lv_uri_3= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:324:6: lv_uri_3= RULE_STRING
            {
            lv_uri_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceImport695); 

            		createLeafNode(grammarAccess.prResourceImport().ele10ParserRuleCallSTRING(), "uri"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prResourceImport().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:350:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:350:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:351:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport737);
            iv_ruleEPackageImport=ruleEPackageImport();
            _fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageImport747); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:358:1: ruleEPackageImport returns [EObject current=null] : ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_nsURI_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:363:6: ( ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:3: ( 'import' (lv_name_1= RULE_ID ) ) 'ns'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:3: ( 'import' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:4: 'import' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleEPackageImport783); 

                    createLeafNode(grammarAccess.prEPackageImport().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:368:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:370:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPackageImport804); 

            		createLeafNode(grammarAccess.prEPackageImport().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageImport().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEPackageImport821); 

                    createLeafNode(grammarAccess.prEPackageImport().ele01KeywordNs(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:391:2: (lv_nsURI_3= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:393:6: lv_nsURI_3= RULE_STRING
            {
            lv_nsURI_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageImport843); 

            		createLeafNode(grammarAccess.prEPackageImport().ele10ParserRuleCallSTRING(), "nsURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageImport().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:419:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:419:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:420:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prJavaImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaImport_in_entryRuleJavaImport885);
            iv_ruleJavaImport=ruleJavaImport();
            _fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaImport895); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:427:1: ruleJavaImport returns [EObject current=null] : ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2=null;
        Token lv_path_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:6: ( ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:1: ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:1: ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:2: ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:2: ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:3: ( 'import' 'java' ) (lv_path_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:3: ( 'import' 'java' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:433:4: 'import' 'java'
            {
            match(input,15,FOLLOW_15_in_ruleJavaImport931); 

                    createLeafNode(grammarAccess.prJavaImport().ele000KeywordImport(), null); 
                
            match(input,18,FOLLOW_18_in_ruleJavaImport940); 

                    createLeafNode(grammarAccess.prJavaImport().ele001KeywordJava(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:441:2: (lv_path_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:443:6: lv_path_2= RULE_ID
            {
            lv_path_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport962); 

            		createLeafNode(grammarAccess.prJavaImport().ele010ParserRuleCallID(), "path"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prJavaImport().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "path", lv_path_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:460:3: ( '.' (lv_path_4= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:460:4: '.' (lv_path_4= RULE_ID )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleJavaImport980); 

            	            createLeafNode(grammarAccess.prJavaImport().ele10KeywordFullStop(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:464:1: (lv_path_4= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:466:6: lv_path_4= RULE_ID
            	    {
            	    lv_path_4=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport1001); 

            	    		createLeafNode(grammarAccess.prJavaImport().ele110ParserRuleCallID(), "path"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prJavaImport().getRule().getType().getType());
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
    // $ANTLR end ruleJavaImport


    // $ANTLR start entryRuleExtensionImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:492:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:492:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:493:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExtensionImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1045);
            iv_ruleExtensionImport=ruleExtensionImport();
            _fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtensionImport1055); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:500:1: ruleExtensionImport returns [EObject current=null] : ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2=null;
        Token lv_path_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:505:6: ( ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:1: ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:1: ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:2: ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:2: ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:3: ( 'import' 'extension' ) (lv_path_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:3: ( 'import' 'extension' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:4: 'import' 'extension'
            {
            match(input,15,FOLLOW_15_in_ruleExtensionImport1091); 

                    createLeafNode(grammarAccess.prExtensionImport().ele000KeywordImport(), null); 
                
            match(input,20,FOLLOW_20_in_ruleExtensionImport1100); 

                    createLeafNode(grammarAccess.prExtensionImport().ele001KeywordExtension(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:514:2: (lv_path_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:516:6: lv_path_2= RULE_ID
            {
            lv_path_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1122); 

            		createLeafNode(grammarAccess.prExtensionImport().ele010ParserRuleCallID(), "path"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prExtensionImport().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "path", lv_path_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:533:3: ( '::' (lv_path_4= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:533:4: '::' (lv_path_4= RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleExtensionImport1140); 

            	            createLeafNode(grammarAccess.prExtensionImport().ele10KeywordColonColon(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:537:1: (lv_path_4= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:539:6: lv_path_4= RULE_ID
            	    {
            	    lv_path_4=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1161); 

            	    		createLeafNode(grammarAccess.prExtensionImport().ele110ParserRuleCallID(), "path"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prExtensionImport().getRule().getType().getType());
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
            	    break loop8;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:565:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:565:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:566:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNamedResource().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedResource_in_entryRuleNamedResource1205);
            iv_ruleNamedResource=ruleNamedResource();
            _fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResource1215); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:573:1: ruleNamedResource returns [EObject current=null] : ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_leftUri_5=null;
        Token lv_rightUri_10=null;
        EObject lv_leftRoot_6 = null;

        EObject lv_rightRoot_11 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:6: ( ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:2: ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:2: ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:3: ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:3: ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:4: ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:4: ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:5: ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:5: ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:6: ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:6: ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:7: ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:7: ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:8: ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:8: ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:9: ( 'resource' (lv_name_1= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:9: ( 'resource' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:10: 'resource' (lv_name_1= RULE_ID )
            {
            match(input,22,FOLLOW_22_in_ruleNamedResource1257); 

                    createLeafNode(grammarAccess.prNamedResource().ele000000000KeywordResource(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:583:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:585:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedResource1278); 

            		createLeafNode(grammarAccess.prNamedResource().ele0000000010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prNamedResource().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleNamedResource1295); 

                    createLeafNode(grammarAccess.prNamedResource().ele00000001KeywordLeftCurlyBracket(), null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleNamedResource1305); 

                    createLeafNode(grammarAccess.prNamedResource().ele0000001KeywordLeft(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:2: ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )
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
                    new NoViableAltException("610:2: ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:3: ( 'uri' (lv_leftUri_5= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:3: ( 'uri' (lv_leftUri_5= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:4: 'uri' (lv_leftUri_5= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1317); 

                            createLeafNode(grammarAccess.prNamedResource().ele00000100KeywordUri(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:614:1: (lv_leftUri_5= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:616:6: lv_leftUri_5= RULE_STRING
                    {
                    lv_leftUri_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1338); 

                    		createLeafNode(grammarAccess.prNamedResource().ele000001010ParserRuleCallSTRING(), "leftUri"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prNamedResource().getRule().getType().getType());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:634:6: (lv_leftRoot_6= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:634:6: (lv_leftRoot_6= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:637:6: lv_leftRoot_6= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00000110ParserRuleCallCreatedObject(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1386);
                    lv_leftRoot_6=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prNamedResource().getRule().getType().getType());
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


            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1401); 

                    createLeafNode(grammarAccess.prNamedResource().ele00001KeywordSemicolon(), null); 
                

            }

            match(input,25,FOLLOW_25_in_ruleNamedResource1411); 

                    createLeafNode(grammarAccess.prNamedResource().ele0001KeywordRight(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:663:2: ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=34 && LA10_0<=35)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("663:2: ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:663:3: ( 'uri' (lv_rightUri_10= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:663:3: ( 'uri' (lv_rightUri_10= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:663:4: 'uri' (lv_rightUri_10= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1423); 

                            createLeafNode(grammarAccess.prNamedResource().ele00100KeywordUri(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:667:1: (lv_rightUri_10= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:669:6: lv_rightUri_10= RULE_STRING
                    {
                    lv_rightUri_10=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1444); 

                    		createLeafNode(grammarAccess.prNamedResource().ele001010ParserRuleCallSTRING(), "rightUri"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prNamedResource().getRule().getType().getType());
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
                     
                    	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00110ParserRuleCallCreatedObject(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1492);
                    lv_rightRoot_11=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prNamedResource().getRule().getType().getType());
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


            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1507); 

                    createLeafNode(grammarAccess.prNamedResource().ele01KeywordSemicolon(), null); 
                

            }

            match(input,14,FOLLOW_14_in_ruleNamedResource1517); 

                    createLeafNode(grammarAccess.prNamedResource().ele1KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:727:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:727:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:728:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectRef_in_entryRuleObjectRef1554);
            iv_ruleObjectRef=ruleObjectRef();
            _fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectRef1564); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:735:1: ruleObjectRef returns [EObject current=null] : ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:740:6: ( ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:1: ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:1: ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:2: ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:2: ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:3: ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:3: ( 'object' (lv_name_1= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:4: 'object' (lv_name_1= RULE_ID )?
            {
            match(input,26,FOLLOW_26_in_ruleObjectRef1600); 

                    createLeafNode(grammarAccess.prObjectRef().ele000KeywordObject(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:745:1: (lv_name_1= RULE_ID )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_ID||LA11_1==23) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:747:6: lv_name_1= RULE_ID
                    {
                    lv_name_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1621); 

                    		createLeafNode(grammarAccess.prObjectRef().ele0010ParserRuleCallID(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:764:4: ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==23) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("764:4: ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:764:5: ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:764:5: ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:764:6: ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:764:6: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:767:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1654); 

                    		createLeafNode(grammarAccess.prObjectRef().ele01000CrossReferenceEStringNamedResource(), "leftRes"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:780:2: (lv_leftFrag_3= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:782:6: lv_leftFrag_3= RULE_FRAGMENT
                    {
                    lv_leftFrag_3=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1679); 

                    		createLeafNode(grammarAccess.prObjectRef().ele01010LexerRuleCallFRAGMENT(), "leftFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:6: ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:6: ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:7: ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:7: ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:8: ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:8: ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:9: ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:9: ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:10: ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:10: ( 'left' ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:11: 'left' ( RULE_ID )
                    {
                    match(input,23,FOLLOW_23_in_ruleObjectRef1708); 

                            createLeafNode(grammarAccess.prObjectRef().ele01100000KeywordLeft(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:805:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:808:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1730); 

                    		createLeafNode(grammarAccess.prObjectRef().ele011000010CrossReferenceEStringNamedResource(), "leftRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:821:3: (lv_leftFrag_6= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:823:6: lv_leftFrag_6= RULE_FRAGMENT
                    {
                    lv_leftFrag_6=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1756); 

                    		createLeafNode(grammarAccess.prObjectRef().ele01100010LexerRuleCallFRAGMENT(), "leftFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "leftFrag", lv_leftFrag_6, "FRAGMENT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,25,FOLLOW_25_in_ruleObjectRef1774); 

                            createLeafNode(grammarAccess.prObjectRef().ele011001KeywordRight(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:845:2: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:848:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1797); 

                    		createLeafNode(grammarAccess.prObjectRef().ele011010CrossReferenceEStringNamedResource(), "rightRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:861:3: (lv_rightFrag_9= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:863:6: lv_rightFrag_9= RULE_FRAGMENT
                    {
                    lv_rightFrag_9=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1823); 

                    		createLeafNode(grammarAccess.prObjectRef().ele01110LexerRuleCallFRAGMENT(), "rightFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:5: ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:6: ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:6: ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:7: ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:7: ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:8: ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:8: ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:9: '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleObjectRef1847); 

                            createLeafNode(grammarAccess.prObjectRef().ele10000KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:885:1: ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            int LA13_2 = input.LA(2);

                            if ( (LA13_2==27) ) {
                                int LA13_3 = input.LA(3);

                                if ( (LA13_3==29) ) {
                                    alt13=2;
                                }
                                else if ( ((LA13_3>=RULE_ID && LA13_3<=RULE_STRING)||(LA13_3>=33 && LA13_3<=35)) ) {
                                    alt13=1;
                                }


                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:885:2: (lv_assignments_11= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:885:2: (lv_assignments_11= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:888:6: lv_assignments_11= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000100ParserRuleCallBiSingleAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1882);
                    	    lv_assignments_11=ruleBiSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:907:6: (lv_assignments_12= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:907:6: (lv_assignments_12= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:910:6: lv_assignments_12= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000110ParserRuleCallBiListAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiListAssignment_in_ruleObjectRef1926);
                    	    lv_assignments_12=ruleBiListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:928:5: ( 'left' (lv_leftMig_14= ruleMigration ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==23) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:928:6: 'left' (lv_leftMig_14= ruleMigration )
                            {
                            match(input,23,FOLLOW_23_in_ruleObjectRef1943); 

                                    createLeafNode(grammarAccess.prObjectRef().ele10010KeywordLeft(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:932:1: (lv_leftMig_14= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:935:6: lv_leftMig_14= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele100110ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef1977);
                            lv_leftMig_14=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:953:5: ( 'right' (lv_rightMig_16= ruleMigration ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==25) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:953:6: 'right' (lv_rightMig_16= ruleMigration )
                            {
                            match(input,25,FOLLOW_25_in_ruleObjectRef1994); 

                                    createLeafNode(grammarAccess.prObjectRef().ele1010KeywordRight(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:957:1: (lv_rightMig_16= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:960:6: lv_rightMig_16= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele10110ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef2028);
                            lv_rightMig_16=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
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


                    }

                    match(input,14,FOLLOW_14_in_ruleObjectRef2044); 

                            createLeafNode(grammarAccess.prObjectRef().ele11KeywordRightCurlyBracket(), null); 
                        

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
             currentNode = createCompositeNode(grammarAccess.prBiSingleAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2083);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();
            _fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiSingleAssignment2093); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1001:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValue_2 = null;

        EObject lv_rightValue_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:6: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:4: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:4: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:5: ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:5: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:6: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:6: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1009:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiSingleAssignment2143); 

            		createLeafNode(grammarAccess.prBiSingleAssignment().ele000000ParserRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prBiSingleAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleBiSingleAssignment2159); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele00001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1030:2: (lv_leftValue_2= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1033:6: lv_leftValue_2= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele00010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2194);
            lv_leftValue_2=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prBiSingleAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "leftValue", lv_leftValue_2, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,28,FOLLOW_28_in_ruleBiSingleAssignment2208); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele001KeywordVerticalLine(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1055:2: (lv_rightValue_4= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1058:6: lv_rightValue_4= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2243);
            lv_rightValue_4=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prBiSingleAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "rightValue", lv_rightValue_4, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleBiSingleAssignment2257); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1090:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBiListAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2292);
            iv_ruleBiListAssignment=ruleBiListAssignment();
            _fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiListAssignment2302); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1097:1: ruleBiListAssignment returns [EObject current=null] : ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValues_3 = null;

        EObject lv_leftValues_5 = null;

        EObject lv_rightValues_7 = null;

        EObject lv_rightValues_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:6: ( ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:1: ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:1: ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:2: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:2: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:3: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:3: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:4: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:4: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:5: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:5: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:6: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:6: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:7: ( (lv_feature_0= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:7: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:8: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:8: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1105:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiListAssignment2354); 

            		createLeafNode(grammarAccess.prBiListAssignment().ele00000000ParserRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prBiListAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleBiListAssignment2370); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele0000001KeywordEqualsSign(), null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleBiListAssignment2380); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele000001KeywordLeftSquareBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1130:2: ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1130:3: (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1130:3: (lv_leftValues_3= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1133:6: lv_leftValues_3= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele0000100ParserRuleCallListAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2416);
                    lv_leftValues_3=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prBiListAssignment().getRule().getType().getType());
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
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==30) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1151:3: ',' (lv_leftValues_5= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2430); 

                    	            createLeafNode(grammarAccess.prBiListAssignment().ele0000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1155:1: (lv_leftValues_5= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1158:6: lv_leftValues_5= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00001110ParserRuleCallListAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2464);
                    	    lv_leftValues_5=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prBiListAssignment().getRule().getType().getType());
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
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,28,FOLLOW_28_in_ruleBiListAssignment2482); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele0001KeywordVerticalLine(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:2: ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:3: (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:3: (lv_rightValues_7= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1183:6: lv_rightValues_7= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00100ParserRuleCallListAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2518);
                    lv_rightValues_7=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prBiListAssignment().getRule().getType().getType());
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
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==30) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1201:3: ',' (lv_rightValues_9= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2532); 

                    	            createLeafNode(grammarAccess.prBiListAssignment().ele00110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1205:1: (lv_rightValues_9= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1208:6: lv_rightValues_9= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele001110ParserRuleCallListAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2566);
                    	    lv_rightValues_9=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prBiListAssignment().getRule().getType().getType());
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
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,31,FOLLOW_31_in_ruleBiListAssignment2584); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele01KeywordRightSquareBracket(), null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleBiListAssignment2594); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1243:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1243:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1244:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMonoSingleAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2629);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();
            _fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoSingleAssignment2639); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1251:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValue_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1256:6: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:1: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:1: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:2: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:2: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:3: ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:3: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:4: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:4: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1259:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2687); 

            		createLeafNode(grammarAccess.prMonoSingleAssignment().ele0000ParserRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMonoSingleAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleMonoSingleAssignment2703); 

                    createLeafNode(grammarAccess.prMonoSingleAssignment().ele001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1280:2: (lv_leftValue_2= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1283:6: lv_leftValue_2= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prMonoSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2738);
            lv_leftValue_2=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMonoSingleAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "leftValue", lv_leftValue_2, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleMonoSingleAssignment2752); 

                    createLeafNode(grammarAccess.prMonoSingleAssignment().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1314:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1314:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1315:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMonoListAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2787);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();
            _fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoListAssignment2797); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1322:1: ruleMonoListAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValues_3 = null;

        EObject lv_leftValues_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1327:6: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:4: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:4: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:5: ( (lv_feature_0= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:5: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:6: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:6: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1330:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoListAssignment2847); 

            		createLeafNode(grammarAccess.prMonoListAssignment().ele000000ParserRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMonoListAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleMonoListAssignment2863); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele00001KeywordEqualsSign(), null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleMonoListAssignment2873); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele0001KeywordLeftSquareBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1355:2: ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||(LA22_0>=34 && LA22_0<=35)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1355:3: (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1355:3: (lv_leftValues_3= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1358:6: lv_leftValues_3= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele00100ParserRuleCallAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2909);
                    lv_leftValues_3=ruleAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prMonoListAssignment().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "leftValues", lv_leftValues_3, "AssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1376:2: ( ',' (lv_leftValues_5= ruleAssignmentValue ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==30) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1376:3: ',' (lv_leftValues_5= ruleAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleMonoListAssignment2923); 

                    	            createLeafNode(grammarAccess.prMonoListAssignment().ele00110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1380:1: (lv_leftValues_5= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1383:6: lv_leftValues_5= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele001110ParserRuleCallAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2957);
                    	    lv_leftValues_5=ruleAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prMonoListAssignment().getRule().getType().getType());
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
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,31,FOLLOW_31_in_ruleMonoListAssignment2975); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele01KeywordRightSquareBracket(), null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleMonoListAssignment2985); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1418:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1418:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1419:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3020);
            iv_ruleAssignmentValue=ruleAssignmentValue();
            _fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentValue3030); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1426:1: ruleAssignmentValue returns [EObject current=null] : ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;
        Token lv_refFeature_3=null;
        Token lv_refIndex_5=null;
        Token lv_impFrag_9=null;
        EObject lv_newObject_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1431:6: ( ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_STRING||(LA27_0>=34 && LA27_0<=35)) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID) ) {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==RULE_FRAGMENT) ) {
                    alt27=2;
                }
                else if ( (LA27_2==EOF||LA27_2==19||(LA27_2>=30 && LA27_2<=31)) ) {
                    alt27=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1432:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )", 27, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1432:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:2: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:2: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
                        alt26=1;
                    }
                    else if ( ((LA26_0>=34 && LA26_0<=35)) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1432:2: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:3: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:3: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) )
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==RULE_STRING) ) {
                                alt25=1;
                            }
                            else if ( (LA25_0==RULE_ID) ) {
                                alt25=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1432:3: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) )", 25, 0, input);

                                throw nvae;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:4: (lv_value_0= RULE_STRING )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:4: (lv_value_0= RULE_STRING )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1434:6: lv_value_0= RULE_STRING
                                    {
                                    lv_value_0=(Token)input.LT(1);
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssignmentValue3078); 

                                    		createLeafNode(grammarAccess.prAssignmentValue().ele0000ParserRuleCallSTRING(), "value"); 
                                    	

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
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
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1452:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1452:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1452:7: ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1452:7: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1455:3: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3114); 

                                    		createLeafNode(grammarAccess.prAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
                                    	

                                    }

                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:2: ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )?
                                    int alt24=2;
                                    int LA24_0 = input.LA(1);

                                    if ( (LA24_0==19) ) {
                                        alt24=1;
                                    }
                                    switch (alt24) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:3: ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:3: ( '.' (lv_refFeature_3= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:4: '.' (lv_refFeature_3= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleAssignmentValue3128); 

                                                    createLeafNode(grammarAccess.prAssignmentValue().ele001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:1: (lv_refFeature_3= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1474:6: lv_refFeature_3= RULE_ID
                                            {
                                            lv_refFeature_3=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3149); 

                                            		createLeafNode(grammarAccess.prAssignmentValue().ele0011010ParserRuleCallID(), "refFeature"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	       		set(current, "refFeature", lv_refFeature_3, "ID", lastConsumedNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1491:3: ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )?
                                            int alt23=2;
                                            int LA23_0 = input.LA(1);

                                            if ( (LA23_0==29) ) {
                                                alt23=1;
                                            }
                                            switch (alt23) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1491:4: ( '[' (lv_refIndex_5= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1491:4: ( '[' (lv_refIndex_5= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1491:5: '[' (lv_refIndex_5= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleAssignmentValue3168); 

                                                            createLeafNode(grammarAccess.prAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1495:1: (lv_refIndex_5= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1497:6: lv_refIndex_5= RULE_INT
                                                    {
                                                    lv_refIndex_5=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignmentValue3189); 

                                                    		createLeafNode(grammarAccess.prAssignmentValue().ele00111010ParserRuleCallINT(), "refIndex"); 
                                                    	

                                                    	        if (current==null) {
                                                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	       		set(current, "refIndex", lv_refIndex_5, "INT", lastConsumedNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	    

                                                    }


                                                    }

                                                    match(input,31,FOLLOW_31_in_ruleAssignmentValue3206); 

                                                            createLeafNode(grammarAccess.prAssignmentValue().ele001111KeywordRightSquareBracket(), null); 
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:6: (lv_newObject_7= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:6: (lv_newObject_7= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1522:6: lv_newObject_7= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3252);
                            lv_newObject_7=ruleCreatedObject();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
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

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:6: ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:6: ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:7: ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1544:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3286); 

                    		createLeafNode(grammarAccess.prAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1557:2: (lv_impFrag_9= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1559:6: lv_impFrag_9= RULE_FRAGMENT
                    {
                    lv_impFrag_9=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3311); 

                    		createLeafNode(grammarAccess.prAssignmentValue().ele110LexerRuleCallFRAGMENT(), "impFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1586:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1586:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1587:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prListAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3355);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();
            _fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListAssignmentValue3365); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1594:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:6: ( ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:1: ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:1: ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:2: ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:2: ( (lv_index_0= RULE_INT ) ':' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:3: (lv_index_0= RULE_INT ) ':'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:3: (lv_index_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1602:6: lv_index_0= RULE_INT
            {
            lv_index_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3412); 

            		createLeafNode(grammarAccess.prListAssignmentValue().ele000ParserRuleCallINT(), "index"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "index", lv_index_0, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,32,FOLLOW_32_in_ruleListAssignmentValue3428); 

                    createLeafNode(grammarAccess.prListAssignmentValue().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:2: ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_STRING||LA33_0==29||(LA33_0>=34 && LA33_0<=35)) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID) ) {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==RULE_FRAGMENT) ) {
                    alt33=2;
                }
                else if ( (LA33_2==EOF||LA33_2==19||LA33_2==28||(LA33_2>=30 && LA33_2<=31)) ) {
                    alt33=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1623:2: ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )", 33, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1623:2: ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:3: ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:3: ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING)||LA32_0==29) ) {
                        alt32=1;
                    }
                    else if ( ((LA32_0>=34 && LA32_0<=35)) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1623:3: ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:4: ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:4: ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) )
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==RULE_STRING||LA31_0==29) ) {
                                alt31=1;
                            }
                            else if ( (LA31_0==RULE_ID) ) {
                                alt31=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1623:4: ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:5: ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:5: ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) )
                                    int alt28=2;
                                    int LA28_0 = input.LA(1);

                                    if ( (LA28_0==29) ) {
                                        alt28=1;
                                    }
                                    else if ( (LA28_0==RULE_STRING) ) {
                                        alt28=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1623:5: ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) )", 28, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt28) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:6: ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:6: ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:7: ( '[' (lv_refIndex_3= RULE_INT ) ) ']'
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:7: ( '[' (lv_refIndex_3= RULE_INT ) )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1623:8: '[' (lv_refIndex_3= RULE_INT )
                                            {
                                            match(input,29,FOLLOW_29_in_ruleListAssignmentValue3444); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele1000000KeywordLeftSquareBracket(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1627:1: (lv_refIndex_3= RULE_INT )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1629:6: lv_refIndex_3= RULE_INT
                                            {
                                            lv_refIndex_3=(Token)input.LT(1);
                                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3465); 

                                            		createLeafNode(grammarAccess.prListAssignmentValue().ele10000010ParserRuleCallINT(), "refIndex"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	       		set(current, "refIndex", lv_refIndex_3, "INT", lastConsumedNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            match(input,31,FOLLOW_31_in_ruleListAssignmentValue3482); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele100001KeywordRightSquareBracket(), null); 
                                                

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1651:6: (lv_value_5= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1651:6: (lv_value_5= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:6: lv_value_5= RULE_STRING
                                            {
                                            lv_value_5=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleListAssignmentValue3510); 

                                            		createLeafNode(grammarAccess.prListAssignmentValue().ele100010ParserRuleCallSTRING(), "value"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
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

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1671:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1671:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1671:7: ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1671:7: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1674:3: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3547); 

                                    		createLeafNode(grammarAccess.prListAssignmentValue().ele100100CrossReferenceEStringNamedObject(), "refObject"); 
                                    	

                                    }

                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:2: ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )?
                                    int alt30=2;
                                    int LA30_0 = input.LA(1);

                                    if ( (LA30_0==19) ) {
                                        alt30=1;
                                    }
                                    switch (alt30) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:3: ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:3: ( '.' (lv_refFeature_8= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:4: '.' (lv_refFeature_8= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleListAssignmentValue3561); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele1001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1691:1: (lv_refFeature_8= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1693:6: lv_refFeature_8= RULE_ID
                                            {
                                            lv_refFeature_8=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3582); 

                                            		createLeafNode(grammarAccess.prListAssignmentValue().ele10011010ParserRuleCallID(), "refFeature"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	       		set(current, "refFeature", lv_refFeature_8, "ID", lastConsumedNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:3: ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )?
                                            int alt29=2;
                                            int LA29_0 = input.LA(1);

                                            if ( (LA29_0==29) ) {
                                                alt29=1;
                                            }
                                            switch (alt29) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:4: ( '[' (lv_refIndex_10= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:4: ( '[' (lv_refIndex_10= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:5: '[' (lv_refIndex_10= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue3601); 

                                                            createLeafNode(grammarAccess.prListAssignmentValue().ele10011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1714:1: (lv_refIndex_10= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1716:6: lv_refIndex_10= RULE_INT
                                                    {
                                                    lv_refIndex_10=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3622); 

                                                    		createLeafNode(grammarAccess.prListAssignmentValue().ele100111010ParserRuleCallINT(), "refIndex"); 
                                                    	

                                                    	        if (current==null) {
                                                    	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	       		set(current, "refIndex", lv_refIndex_10, "INT", lastConsumedNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	    

                                                    }


                                                    }

                                                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue3639); 

                                                            createLeafNode(grammarAccess.prListAssignmentValue().ele1001111KeywordRightSquareBracket(), null); 
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1738:6: (lv_newObject_12= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1738:6: (lv_newObject_12= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1741:6: lv_newObject_12= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prListAssignmentValue().ele1010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3685);
                            lv_newObject_12=ruleCreatedObject();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
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

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1760:6: ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1760:6: ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1760:7: ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1760:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1763:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3719); 

                    		createLeafNode(grammarAccess.prListAssignmentValue().ele1100CrossReferenceEStringImport(), "import"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1776:2: (lv_impFrag_14= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1778:6: lv_impFrag_14= RULE_FRAGMENT
                    {
                    lv_impFrag_14=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3744); 

                    		createLeafNode(grammarAccess.prListAssignmentValue().ele1110LexerRuleCallFRAGMENT(), "impFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1805:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1805:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1806:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSingleAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3789);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();
            _fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleAssignmentValue3799); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1813:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1818:6: ( ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_STRING||(LA39_0>=33 && LA39_0<=35)) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID) ) {
                int LA39_2 = input.LA(2);

                if ( (LA39_2==RULE_FRAGMENT) ) {
                    alt39=2;
                }
                else if ( (LA39_2==EOF||LA39_2==19||LA39_2==24||LA39_2==28) ) {
                    alt39=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1819:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )", 39, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1819:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:2: ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:2: ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)||LA38_0==33) ) {
                        alt38=1;
                    }
                    else if ( ((LA38_0>=34 && LA38_0<=35)) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1819:2: ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) )", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:3: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:3: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) )
                            int alt37=2;
                            int LA37_0 = input.LA(1);

                            if ( (LA37_0==RULE_STRING||LA37_0==33) ) {
                                alt37=1;
                            }
                            else if ( (LA37_0==RULE_ID) ) {
                                alt37=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1819:3: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) )", 37, 0, input);

                                throw nvae;
                            }
                            switch (alt37) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:4: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:4: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) )
                                    int alt34=2;
                                    int LA34_0 = input.LA(1);

                                    if ( (LA34_0==33) ) {
                                        alt34=1;
                                    }
                                    else if ( (LA34_0==RULE_STRING) ) {
                                        alt34=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1819:4: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) )", 34, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt34) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:5: (lv_keyword_0= 'null' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:5: (lv_keyword_0= 'null' )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:6: lv_keyword_0= 'null'
                                            {
                                            lv_keyword_0=(Token)input.LT(1);
                                            match(input,33,FOLLOW_33_in_ruleSingleAssignmentValue3848); 

                                                    createLeafNode(grammarAccess.prSingleAssignmentValue().ele00000KeywordNull(), "keyword"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
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
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1841:6: (lv_value_1= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1841:6: (lv_value_1= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1843:6: lv_value_1= RULE_STRING
                                            {
                                            lv_value_1=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3888); 

                                            		createLeafNode(grammarAccess.prSingleAssignmentValue().ele00010ParserRuleCallSTRING(), "value"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
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

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:7: ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:7: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1864:3: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3925); 

                                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
                                    	

                                    }

                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1877:2: ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )?
                                    int alt36=2;
                                    int LA36_0 = input.LA(1);

                                    if ( (LA36_0==19) ) {
                                        alt36=1;
                                    }
                                    switch (alt36) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1877:3: ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1877:3: ( '.' (lv_refFeature_4= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1877:4: '.' (lv_refFeature_4= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleSingleAssignmentValue3939); 

                                                    createLeafNode(grammarAccess.prSingleAssignmentValue().ele001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1881:1: (lv_refFeature_4= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1883:6: lv_refFeature_4= RULE_ID
                                            {
                                            lv_refFeature_4=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3960); 

                                            		createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011010ParserRuleCallID(), "refFeature"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	       		set(current, "refFeature", lv_refFeature_4, "ID", lastConsumedNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:3: ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )?
                                            int alt35=2;
                                            int LA35_0 = input.LA(1);

                                            if ( (LA35_0==29) ) {
                                                alt35=1;
                                            }
                                            switch (alt35) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:4: ( '[' (lv_refIndex_6= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:4: ( '[' (lv_refIndex_6= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:5: '[' (lv_refIndex_6= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleSingleAssignmentValue3979); 

                                                            createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1904:1: (lv_refIndex_6= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1906:6: lv_refIndex_6= RULE_INT
                                                    {
                                                    lv_refIndex_6=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4000); 

                                                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele00111010ParserRuleCallINT(), "refIndex"); 
                                                    	

                                                    	        if (current==null) {
                                                    	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	       		set(current, "refIndex", lv_refIndex_6, "INT", lastConsumedNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	    

                                                    }


                                                    }

                                                    match(input,31,FOLLOW_31_in_ruleSingleAssignmentValue4017); 

                                                            createLeafNode(grammarAccess.prSingleAssignmentValue().ele001111KeywordRightSquareBracket(), null); 
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1928:6: (lv_newObject_8= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1928:6: (lv_newObject_8= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1931:6: lv_newObject_8= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prSingleAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4063);
                            lv_newObject_8=ruleCreatedObject();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
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

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1950:6: ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1950:6: ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1950:7: ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1950:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4097); 

                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1966:2: (lv_impFrag_10= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1968:6: lv_impFrag_10= RULE_FRAGMENT
                    {
                    lv_impFrag_10=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4122); 

                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele110LexerRuleCallFRAGMENT(), "impFrag"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1995:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1995:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1996:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCreatedObject().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4166);
            iv_ruleCreatedObject=ruleCreatedObject();
            _fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreatedObject4176); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2003:1: ruleCreatedObject returns [EObject current=null] : ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:6: ( ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:1: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:1: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:2: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:2: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==34) ) {
                alt40=1;
            }
            else if ( (LA40_0==35) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2009:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:5: this_ObjectNew_0= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele000ParserRuleCallObjectNew(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectNew_in_ruleCreatedObject4225);
                    this_ObjectNew_0=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2020:5: this_ObjectCopy_1= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele001ParserRuleCallObjectCopy(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectCopy_in_ruleCreatedObject4252);
                    this_ObjectCopy_1=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2028:2: (lv_name_2= RULE_ID )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2030:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreatedObject4273); 

                    		createLeafNode(grammarAccess.prCreatedObject().ele010ParserRuleCallID(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prCreatedObject().getRule().getType().getType());
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:4: ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==13) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:5: ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:5: ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:6: ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:6: ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:7: '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleCreatedObject4294); 

                            createLeafNode(grammarAccess.prCreatedObject().ele1000KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2051:1: ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=3;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            int LA42_2 = input.LA(2);

                            if ( (LA42_2==27) ) {
                                int LA42_3 = input.LA(3);

                                if ( (LA42_3==29) ) {
                                    alt42=2;
                                }
                                else if ( ((LA42_3>=RULE_ID && LA42_3<=RULE_STRING)||(LA42_3>=33 && LA42_3<=35)) ) {
                                    alt42=1;
                                }


                            }


                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2051:2: (lv_assignments_4= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2051:2: (lv_assignments_4= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2054:6: lv_assignments_4= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100100ParserRuleCallMonoSingleAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4329);
                    	    lv_assignments_4=ruleMonoSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prCreatedObject().getRule().getType().getType());
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2073:6: (lv_assignments_5= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2073:6: (lv_assignments_5= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:6: lv_assignments_5= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100110ParserRuleCallMonoListAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4373);
                    	    lv_assignments_5=ruleMonoListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prCreatedObject().getRule().getType().getType());
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
                    	    if ( cnt42 >= 1 ) break loop42;
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2094:5: (lv_leftMig_6= ruleMigration )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==36) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2097:6: lv_leftMig_6= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele1010ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleCreatedObject4414);
                            lv_leftMig_6=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prCreatedObject().getRule().getType().getType());
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


                    }

                    match(input,14,FOLLOW_14_in_ruleCreatedObject4429); 

                            createLeafNode(grammarAccess.prCreatedObject().ele11KeywordRightCurlyBracket(), null); 
                        

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2128:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2128:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2129:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectNew().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectNew_in_entryRuleObjectNew4466);
            iv_ruleObjectNew=ruleObjectNew();
            _fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectNew4476); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2136:1: ruleObjectNew returns [EObject current=null] : ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2141:6: ( ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:1: ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:1: ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:2: ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:2: ( 'new' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:3: 'new' ( RULE_ID )
            {
            match(input,34,FOLLOW_34_in_ruleObjectNew4511); 

                    createLeafNode(grammarAccess.prObjectNew().ele00KeywordNew(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2146:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2149:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prObjectNew().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectNew4533); 

            		createLeafNode(grammarAccess.prObjectNew().ele010CrossReferenceEStringImport(), "import"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2162:3: (lv_impFrag_2= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2164:6: lv_impFrag_2= RULE_FRAGMENT
            {
            lv_impFrag_2=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4559); 

            		createLeafNode(grammarAccess.prObjectNew().ele10LexerRuleCallFRAGMENT(), "impFrag"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prObjectNew().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2191:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2191:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2192:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectCopy().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4602);
            iv_ruleObjectCopy=ruleObjectCopy();
            _fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectCopy4612); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2199:1: ruleObjectCopy returns [EObject current=null] : ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:6: ( ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2205:1: ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2205:1: ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2205:2: ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2205:2: ( 'copy' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2205:3: 'copy' ( RULE_ID )
            {
            match(input,35,FOLLOW_35_in_ruleObjectCopy4647); 

                    createLeafNode(grammarAccess.prObjectCopy().ele00KeywordCopy(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2209:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2212:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prObjectCopy().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectCopy4669); 

            		createLeafNode(grammarAccess.prObjectCopy().ele010CrossReferenceEStringNamedResource(), "resource"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2225:3: (lv_fragment_2= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2227:6: lv_fragment_2= RULE_FRAGMENT
            {
            lv_fragment_2=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4695); 

            		createLeafNode(grammarAccess.prObjectCopy().ele10LexerRuleCallFRAGMENT(), "fragment"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prObjectCopy().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2254:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2254:51: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2255:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMigration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMigration_in_entryRuleMigration4738);
            iv_ruleMigration=ruleMigration();
            _fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMigration4748); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2262:1: ruleMigration returns [EObject current=null] : ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1 = null;

        EObject lv_asOp_3 = null;

        EObject lv_eachOp_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2267:6: ( ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:1: ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:1: ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:2: ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:2: ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:3: ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:3: ( 'migrate' (lv_first_1= ruleExecutable )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2268:4: 'migrate' (lv_first_1= ruleExecutable )?
            {
            match(input,36,FOLLOW_36_in_ruleMigration4784); 

                    createLeafNode(grammarAccess.prMigration().ele000KeywordMigrate(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2272:1: (lv_first_1= ruleExecutable )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_STRING||LA45_0==18) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2275:6: lv_first_1= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele0010ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4818);
                    lv_first_1=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prMigration().getRule().getType().getType());
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2293:4: ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )?
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==37) ) {
                alt46=1;
            }
            else if ( (LA46_0==38) ) {
                alt46=2;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2293:5: ( 'as' (lv_asOp_3= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2293:5: ( 'as' (lv_asOp_3= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2293:6: 'as' (lv_asOp_3= ruleExecutable )
                    {
                    match(input,37,FOLLOW_37_in_ruleMigration4835); 

                            createLeafNode(grammarAccess.prMigration().ele0100KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:1: (lv_asOp_3= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2300:6: lv_asOp_3= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01010ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4869);
                    lv_asOp_3=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prMigration().getRule().getType().getType());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2319:6: ( 'each' (lv_eachOp_5= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2319:6: ( 'each' (lv_eachOp_5= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2319:7: 'each' (lv_eachOp_5= ruleExecutable )
                    {
                    match(input,38,FOLLOW_38_in_ruleMigration4890); 

                            createLeafNode(grammarAccess.prMigration().ele0110KeywordEach(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2323:1: (lv_eachOp_5= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2326:6: lv_eachOp_5= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01110ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4924);
                    lv_eachOp_5=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prMigration().getRule().getType().getType());
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


            }

            match(input,24,FOLLOW_24_in_ruleMigration4941); 

                    createLeafNode(grammarAccess.prMigration().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2357:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2357:52: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2358:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExecutable_in_entryRuleExecutable4976);
            iv_ruleExecutable=ruleExecutable();
            _fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutable4986); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2365:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable_0 = null;

        EObject this_ExpressionExecutable_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2370:6: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2371:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2371:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==18) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_STRING) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2371:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2372:5: this_JavaExecutable_0= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExecutable().ele0ParserRuleCallJavaExecutable(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaExecutable_in_ruleExecutable5033);
                    this_JavaExecutable_0=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2382:5: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExecutable().ele1ParserRuleCallExpressionExecutable(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionExecutable_in_ruleExecutable5060);
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
             currentNode = createCompositeNode(grammarAccess.prJavaExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5094);
            iv_ruleJavaExecutable=ruleJavaExecutable();
            _fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaExecutable5104); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2407:1: ruleJavaExecutable returns [EObject current=null] : ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2412:6: ( ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:1: ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:1: ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:2: ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:2: ( ( 'java' (lv_method_1= RULE_ID ) ) '(' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:3: ( 'java' (lv_method_1= RULE_ID ) ) '('
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:3: ( 'java' (lv_method_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2413:4: 'java' (lv_method_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleJavaExecutable5140); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele000KeywordJava(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2417:1: (lv_method_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2419:6: lv_method_1= RULE_ID
            {
            lv_method_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaExecutable5161); 

            		createLeafNode(grammarAccess.prJavaExecutable().ele0010ParserRuleCallID(), "method"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prJavaExecutable().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "method", lv_method_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,39,FOLLOW_39_in_ruleJavaExecutable5178); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele01KeywordLeftParenthesis(), null); 
                

            }

            match(input,40,FOLLOW_40_in_ruleJavaExecutable5188); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele1KeywordRightParenthesis(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2453:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2453:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2454:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExpressionExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5223);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();
            _fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionExecutable5233); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2461:1: ruleExpressionExecutable returns [EObject current=null] : (lv_exprstr_0= RULE_STRING ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2466:6: ( (lv_exprstr_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2467:1: (lv_exprstr_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2467:1: (lv_exprstr_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2469:6: lv_exprstr_0= RULE_STRING
            {
            lv_exprstr_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleExpressionExecutable5278); 

            		createLeafNode(grammarAccess.prExpressionExecutable().ele0ParserRuleCallSTRING(), "exprstr"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prExpressionExecutable().getRule().getType().getType());
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


 

    public static final BitSet FOLLOW_ruleEPatch_in_entryRuleEPatch72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPatch82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleEPatch121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch142 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEPatch159 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleEPatch194 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch234 = new BitSet(new long[]{0x0000000004404000L});
    public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch274 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleEPatch289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_ruleImport382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelImport481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleResourceImport635 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport656 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResourceImport673 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEPackageImport783 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport804 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageImport821 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJavaImport931 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaImport940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport962 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleJavaImport980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport1001 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExtensionImport1091 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExtensionImport1100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1122 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleExtensionImport1140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1161 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNamedResource1257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1278 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamedResource1295 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedResource1305 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1317 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1338 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1386 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1401 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNamedResource1411 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1423 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1444 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1492 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1507 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedResource1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleObjectRef1600 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1621 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1654 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1679 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1708 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1730 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1756 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1774 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1797 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1823 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleObjectRef1847 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1882 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1926 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1943 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1977 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1994 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2028 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleObjectRef2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment2143 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment2159 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2194 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment2208 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2243 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2354 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiListAssignment2370 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleBiListAssignment2380 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2416 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2430 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2464 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleBiListAssignment2482 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2518 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2532 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2566 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleBiListAssignment2584 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiListAssignment2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2687 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2703 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2738 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2847 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2863 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2873 = new BitSet(new long[]{0x0000000C80000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2909 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleMonoListAssignment2923 = new BitSet(new long[]{0x0000000C00000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2957 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleMonoListAssignment2975 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoListAssignment2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3114 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentValue3128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3149 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignmentValue3168 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue3189 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentValue3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3286 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue3365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3412 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleListAssignmentValue3428 = new BitSet(new long[]{0x0000000C20000030L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3444 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3465 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3547 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleListAssignmentValue3561 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3582 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3601 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3622 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3719 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3925 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue3939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3960 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue3979 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4000 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4097 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject4225 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject4252 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject4273 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleCreatedObject4294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4329 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4373 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject4414 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCreatedObject4429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew4466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleObjectNew4511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew4533 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleObjectCopy4647 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy4669 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration4738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMigration4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMigration4784 = new BitSet(new long[]{0x0000006001040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4818 = new BitSet(new long[]{0x0000006001000000L});
    public static final BitSet FOLLOW_37_in_ruleMigration4835 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4869 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_38_in_ruleMigration4890 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4924 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMigration4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable4976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutable4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable5060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable5104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaExecutable5140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable5161 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleJavaExecutable5178 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleJavaExecutable5188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable5278 = new BitSet(new long[]{0x0000000000000002L});

}
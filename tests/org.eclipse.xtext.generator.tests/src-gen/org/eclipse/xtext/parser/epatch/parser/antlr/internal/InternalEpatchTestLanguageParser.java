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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:70:1: entryRuleEPatch returns [EObject current=null] : iv_ruleEPatch= ruleEPatch EOF ;
    public final EObject entryRuleEPatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPatch = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:70:48: (iv_ruleEPatch= ruleEPatch EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:71:2: iv_ruleEPatch= ruleEPatch EOF
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:78:1: ruleEPatch returns [EObject current=null] : ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_imports_3 = null;

        EObject lv_resources_4 = null;

        EObject lv_objects_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:6: ( ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:1: ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:1: ( ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:2: ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:2: ( ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:3: ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* ) (lv_objects_5= ruleObjectRef )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:3: ( ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:4: ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* ) (lv_resources_4= ruleNamedResource )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:4: ( ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:5: ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' ) (lv_imports_3= ruleImport )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:5: ( ( 'epatch' (lv_name_1= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:6: ( 'epatch' (lv_name_1= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:6: ( 'epatch' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:7: 'epatch' (lv_name_1= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleEPatch121); 

                    createLeafNode(grammarAccess.prEPatch().ele000000KeywordEpatch(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:88:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:90:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPatch143); 

            		createLeafNode(grammarAccess.prEPatch().ele0000010LexerRuleCallID(), "name"); 
            	

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

            match(input,13,FOLLOW_13_in_ruleEPatch161); 

                    createLeafNode(grammarAccess.prEPatch().ele00001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:112:2: (lv_imports_3= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:115:6: lv_imports_3= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele00010ParserRuleCallImport(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleEPatch196);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:133:4: (lv_resources_4= ruleNamedResource )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:136:6: lv_resources_4= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele0010ParserRuleCallNamedResource(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResource_in_ruleEPatch236);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:154:4: (lv_objects_5= ruleObjectRef )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:157:6: lv_objects_5= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele010ParserRuleCallObjectRef(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleObjectRef_in_ruleEPatch276);
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

            match(input,14,FOLLOW_14_in_ruleEPatch291); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:188:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:188:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:189:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport326);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport336); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:196:1: ruleImport returns [EObject current=null] : ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport_0 = null;

        EObject this_JavaImport_1 = null;

        EObject this_ExtensionImport_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:6: ( ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )
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
                        new NoViableAltException("202:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("202:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport ) | this_ExtensionImport_2= ruleExtensionImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:202:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )
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
                                new NoViableAltException("202:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )", 4, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("202:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:203:5: this_ModelImport_0= ruleModelImport
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prImport().ele00ParserRuleCallModelImport(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleModelImport_in_ruleImport384);
                            this_ModelImport_0=ruleModelImport();
                            _fsp--;

                             
                                    current = this_ModelImport_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:213:5: this_JavaImport_1= ruleJavaImport
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prImport().ele01ParserRuleCallJavaImport(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleJavaImport_in_ruleImport411);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:223:5: this_ExtensionImport_2= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prImport().ele1ParserRuleCallExtensionImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExtensionImport_in_ruleImport439);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:240:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:240:53: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:241:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModelImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelImport_in_entryRuleModelImport473);
            iv_ruleModelImport=ruleModelImport();
            _fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelImport483); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:248:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport_0 = null;

        EObject this_EPackageImport_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:253:6: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:254:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:254:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
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
                            new NoViableAltException("254:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("254:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("254:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:255:5: this_ResourceImport_0= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModelImport().ele0ParserRuleCallResourceImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceImport_in_ruleModelImport530);
                    this_ResourceImport_0=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:265:5: this_EPackageImport_1= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModelImport().ele1ParserRuleCallEPackageImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEPackageImport_in_ruleModelImport557);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:282:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:282:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:283:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prResourceImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceImport_in_entryRuleResourceImport591);
            iv_ruleResourceImport=ruleResourceImport();
            _fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceImport601); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:1: ruleResourceImport returns [EObject current=null] : ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_uri_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:295:6: ( ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' ) (lv_uri_3= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'uri' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:3: ( 'import' (lv_name_1= RULE_ID ) ) 'uri'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:3: ( 'import' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:4: 'import' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleResourceImport637); 

                    createLeafNode(grammarAccess.prResourceImport().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:300:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:302:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceImport659); 

            		createLeafNode(grammarAccess.prResourceImport().ele0010LexerRuleCallID(), "name"); 
            	

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

            match(input,16,FOLLOW_16_in_ruleResourceImport677); 

                    createLeafNode(grammarAccess.prResourceImport().ele01KeywordUri(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:324:2: (lv_uri_3= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:326:6: lv_uri_3= RULE_STRING
            {
            lv_uri_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceImport700); 

            		createLeafNode(grammarAccess.prResourceImport().ele10LexerRuleCallSTRING(), "uri"); 
            	

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:353:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:353:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:354:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport743);
            iv_ruleEPackageImport=ruleEPackageImport();
            _fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageImport753); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:361:1: ruleEPackageImport returns [EObject current=null] : ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_nsURI_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:366:6: ( ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:1: ( ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' ) (lv_nsURI_3= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:2: ( ( 'import' (lv_name_1= RULE_ID ) ) 'ns' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:3: ( 'import' (lv_name_1= RULE_ID ) ) 'ns'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:3: ( 'import' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:4: 'import' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleEPackageImport789); 

                    createLeafNode(grammarAccess.prEPackageImport().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:371:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:373:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPackageImport811); 

            		createLeafNode(grammarAccess.prEPackageImport().ele0010LexerRuleCallID(), "name"); 
            	

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

            match(input,17,FOLLOW_17_in_ruleEPackageImport829); 

                    createLeafNode(grammarAccess.prEPackageImport().ele01KeywordNs(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:395:2: (lv_nsURI_3= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:397:6: lv_nsURI_3= RULE_STRING
            {
            lv_nsURI_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageImport852); 

            		createLeafNode(grammarAccess.prEPackageImport().ele10LexerRuleCallSTRING(), "nsURI"); 
            	

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:424:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:424:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:425:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prJavaImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaImport_in_entryRuleJavaImport895);
            iv_ruleJavaImport=ruleJavaImport();
            _fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaImport905); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:1: ruleJavaImport returns [EObject current=null] : ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2=null;
        Token lv_path_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:437:6: ( ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:1: ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:1: ( ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:2: ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) ) ( '.' (lv_path_4= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:2: ( ( 'import' 'java' ) (lv_path_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:3: ( 'import' 'java' ) (lv_path_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:3: ( 'import' 'java' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:4: 'import' 'java'
            {
            match(input,15,FOLLOW_15_in_ruleJavaImport941); 

                    createLeafNode(grammarAccess.prJavaImport().ele000KeywordImport(), null); 
                
            match(input,18,FOLLOW_18_in_ruleJavaImport950); 

                    createLeafNode(grammarAccess.prJavaImport().ele001KeywordJava(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:446:2: (lv_path_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:448:6: lv_path_2= RULE_ID
            {
            lv_path_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport973); 

            		createLeafNode(grammarAccess.prJavaImport().ele010LexerRuleCallID(), "path"); 
            	

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:466:3: ( '.' (lv_path_4= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:466:4: '.' (lv_path_4= RULE_ID )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleJavaImport992); 

            	            createLeafNode(grammarAccess.prJavaImport().ele10KeywordFullStop(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:470:1: (lv_path_4= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:472:6: lv_path_4= RULE_ID
            	    {
            	    lv_path_4=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport1014); 

            	    		createLeafNode(grammarAccess.prJavaImport().ele110LexerRuleCallID(), "path"); 
            	    	

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:499:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:499:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:500:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExtensionImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1059);
            iv_ruleExtensionImport=ruleExtensionImport();
            _fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtensionImport1069); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:507:1: ruleExtensionImport returns [EObject current=null] : ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path_2=null;
        Token lv_path_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:512:6: ( ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:1: ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:1: ( ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:2: ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) ) ( '::' (lv_path_4= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:2: ( ( 'import' 'extension' ) (lv_path_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:3: ( 'import' 'extension' ) (lv_path_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:3: ( 'import' 'extension' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:513:4: 'import' 'extension'
            {
            match(input,15,FOLLOW_15_in_ruleExtensionImport1105); 

                    createLeafNode(grammarAccess.prExtensionImport().ele000KeywordImport(), null); 
                
            match(input,20,FOLLOW_20_in_ruleExtensionImport1114); 

                    createLeafNode(grammarAccess.prExtensionImport().ele001KeywordExtension(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:521:2: (lv_path_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:523:6: lv_path_2= RULE_ID
            {
            lv_path_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1137); 

            		createLeafNode(grammarAccess.prExtensionImport().ele010LexerRuleCallID(), "path"); 
            	

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:541:3: ( '::' (lv_path_4= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:541:4: '::' (lv_path_4= RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleExtensionImport1156); 

            	            createLeafNode(grammarAccess.prExtensionImport().ele10KeywordColonColon(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:545:1: (lv_path_4= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:547:6: lv_path_4= RULE_ID
            	    {
            	    lv_path_4=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1178); 

            	    		createLeafNode(grammarAccess.prExtensionImport().ele110LexerRuleCallID(), "path"); 
            	    	

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:574:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:574:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:575:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNamedResource().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedResource_in_entryRuleNamedResource1223);
            iv_ruleNamedResource=ruleNamedResource();
            _fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResource1233); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:582:1: ruleNamedResource returns [EObject current=null] : ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_leftUri_5=null;
        Token lv_rightUri_10=null;
        EObject lv_leftRoot_6 = null;

        EObject lv_rightRoot_11 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:587:6: ( ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:2: ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:2: ( ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:3: ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:3: ( ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:4: ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:4: ( ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:5: ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' ) 'right'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:5: ( ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:6: ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:6: ( ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:7: ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:7: ( ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:8: ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' ) 'left'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:8: ( ( 'resource' (lv_name_1= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:9: ( 'resource' (lv_name_1= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:9: ( 'resource' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:588:10: 'resource' (lv_name_1= RULE_ID )
            {
            match(input,22,FOLLOW_22_in_ruleNamedResource1275); 

                    createLeafNode(grammarAccess.prNamedResource().ele000000000KeywordResource(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:592:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:594:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedResource1297); 

            		createLeafNode(grammarAccess.prNamedResource().ele0000000010LexerRuleCallID(), "name"); 
            	

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

            match(input,13,FOLLOW_13_in_ruleNamedResource1315); 

                    createLeafNode(grammarAccess.prNamedResource().ele00000001KeywordLeftCurlyBracket(), null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleNamedResource1325); 

                    createLeafNode(grammarAccess.prNamedResource().ele0000001KeywordLeft(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:620:2: ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )
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
                    new NoViableAltException("620:2: ( ( 'uri' (lv_leftUri_5= RULE_STRING ) ) | (lv_leftRoot_6= ruleCreatedObject ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:620:3: ( 'uri' (lv_leftUri_5= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:620:3: ( 'uri' (lv_leftUri_5= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:620:4: 'uri' (lv_leftUri_5= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1337); 

                            createLeafNode(grammarAccess.prNamedResource().ele00000100KeywordUri(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:624:1: (lv_leftUri_5= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:626:6: lv_leftUri_5= RULE_STRING
                    {
                    lv_leftUri_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1359); 

                    		createLeafNode(grammarAccess.prNamedResource().ele000001010LexerRuleCallSTRING(), "leftUri"); 
                    	

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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:645:6: (lv_leftRoot_6= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:645:6: (lv_leftRoot_6= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:648:6: lv_leftRoot_6= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00000110ParserRuleCallCreatedObject(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1408);
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

            match(input,24,FOLLOW_24_in_ruleNamedResource1423); 

                    createLeafNode(grammarAccess.prNamedResource().ele00001KeywordSemicolon(), null); 
                

            }

            match(input,25,FOLLOW_25_in_ruleNamedResource1433); 

                    createLeafNode(grammarAccess.prNamedResource().ele0001KeywordRight(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:674:2: ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )
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
                    new NoViableAltException("674:2: ( ( 'uri' (lv_rightUri_10= RULE_STRING ) ) | (lv_rightRoot_11= ruleCreatedObject ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:674:3: ( 'uri' (lv_rightUri_10= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:674:3: ( 'uri' (lv_rightUri_10= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:674:4: 'uri' (lv_rightUri_10= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1445); 

                            createLeafNode(grammarAccess.prNamedResource().ele00100KeywordUri(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:678:1: (lv_rightUri_10= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:680:6: lv_rightUri_10= RULE_STRING
                    {
                    lv_rightUri_10=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1467); 

                    		createLeafNode(grammarAccess.prNamedResource().ele001010LexerRuleCallSTRING(), "rightUri"); 
                    	

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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:699:6: (lv_rightRoot_11= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:699:6: (lv_rightRoot_11= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:702:6: lv_rightRoot_11= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00110ParserRuleCallCreatedObject(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1516);
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

            match(input,24,FOLLOW_24_in_ruleNamedResource1531); 

                    createLeafNode(grammarAccess.prNamedResource().ele01KeywordSemicolon(), null); 
                

            }

            match(input,14,FOLLOW_14_in_ruleNamedResource1541); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:740:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectRef_in_entryRuleObjectRef1578);
            iv_ruleObjectRef=ruleObjectRef();
            _fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectRef1588); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:747:1: ruleObjectRef returns [EObject current=null] : ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:752:6: ( ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:1: ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:1: ( ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:2: ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:2: ( ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:3: ( 'object' (lv_name_1= RULE_ID )? ) ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:3: ( 'object' (lv_name_1= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:4: 'object' (lv_name_1= RULE_ID )?
            {
            match(input,26,FOLLOW_26_in_ruleObjectRef1624); 

                    createLeafNode(grammarAccess.prObjectRef().ele000KeywordObject(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:757:1: (lv_name_1= RULE_ID )?
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:759:6: lv_name_1= RULE_ID
                    {
                    lv_name_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1646); 

                    		createLeafNode(grammarAccess.prObjectRef().ele0010LexerRuleCallID(), "name"); 
                    	

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:777:4: ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )
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
                    new NoViableAltException("777:4: ( ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:777:5: ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:777:5: ( ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:777:6: ( RULE_ID ) (lv_leftFrag_3= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:777:6: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:780:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1680); 

                    		createLeafNode(grammarAccess.prObjectRef().ele01000CrossReferenceEStringNamedResource(), "leftRes"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:793:2: (lv_leftFrag_3= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:795:6: lv_leftFrag_3= RULE_FRAGMENT
                    {
                    lv_leftFrag_3=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1705); 

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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:6: ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:6: ( ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:7: ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) ) (lv_rightFrag_9= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:7: ( ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:8: ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' ) ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:8: ( ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right' )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:9: ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) ) 'right'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:9: ( ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:10: ( 'left' ( RULE_ID ) ) (lv_leftFrag_6= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:10: ( 'left' ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:814:11: 'left' ( RULE_ID )
                    {
                    match(input,23,FOLLOW_23_in_ruleObjectRef1734); 

                            createLeafNode(grammarAccess.prObjectRef().ele01100000KeywordLeft(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:818:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:821:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1756); 

                    		createLeafNode(grammarAccess.prObjectRef().ele011000010CrossReferenceEStringNamedResource(), "leftRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:834:3: (lv_leftFrag_6= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:836:6: lv_leftFrag_6= RULE_FRAGMENT
                    {
                    lv_leftFrag_6=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1782); 

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

                    match(input,25,FOLLOW_25_in_ruleObjectRef1800); 

                            createLeafNode(grammarAccess.prObjectRef().ele011001KeywordRight(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:858:2: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:861:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prObjectRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1823); 

                    		createLeafNode(grammarAccess.prObjectRef().ele011010CrossReferenceEStringNamedResource(), "rightRes"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:874:3: (lv_rightFrag_9= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:876:6: lv_rightFrag_9= RULE_FRAGMENT
                    {
                    lv_rightFrag_9=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1849); 

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:5: ( ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:6: ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:6: ( ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:7: ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? ) ( 'right' (lv_rightMig_16= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:7: ( ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:8: ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig_14= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:8: ( '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:894:9: '{' ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleObjectRef1873); 

                            createLeafNode(grammarAccess.prObjectRef().ele10000KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:898:1: ( (lv_assignments_11= ruleBiSingleAssignment ) | (lv_assignments_12= ruleBiListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:898:2: (lv_assignments_11= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:898:2: (lv_assignments_11= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:901:6: lv_assignments_11= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000100ParserRuleCallBiSingleAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1908);
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:920:6: (lv_assignments_12= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:920:6: (lv_assignments_12= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:923:6: lv_assignments_12= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000110ParserRuleCallBiListAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiListAssignment_in_ruleObjectRef1952);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:941:5: ( 'left' (lv_leftMig_14= ruleMigration ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==23) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:941:6: 'left' (lv_leftMig_14= ruleMigration )
                            {
                            match(input,23,FOLLOW_23_in_ruleObjectRef1969); 

                                    createLeafNode(grammarAccess.prObjectRef().ele10010KeywordLeft(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:945:1: (lv_leftMig_14= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:948:6: lv_leftMig_14= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele100110ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef2003);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:966:5: ( 'right' (lv_rightMig_16= ruleMigration ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==25) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:966:6: 'right' (lv_rightMig_16= ruleMigration )
                            {
                            match(input,25,FOLLOW_25_in_ruleObjectRef2020); 

                                    createLeafNode(grammarAccess.prObjectRef().ele1010KeywordRight(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:970:1: (lv_rightMig_16= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:973:6: lv_rightMig_16= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele10110ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef2054);
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

                    match(input,14,FOLLOW_14_in_ruleObjectRef2070); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:60: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBiSingleAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2109);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();
            _fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiSingleAssignment2119); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1014:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValue_2 = null;

        EObject lv_rightValue_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1019:6: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue_4= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:4: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) '|'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:4: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:5: ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:5: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:6: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1020:6: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1022:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiSingleAssignment2170); 

            		createLeafNode(grammarAccess.prBiSingleAssignment().ele000000LexerRuleCallID(), "feature"); 
            	

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

            match(input,27,FOLLOW_27_in_ruleBiSingleAssignment2187); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele00001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1044:2: (lv_leftValue_2= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1047:6: lv_leftValue_2= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele00010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2222);
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

            match(input,28,FOLLOW_28_in_ruleBiSingleAssignment2236); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele001KeywordVerticalLine(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1069:2: (lv_rightValue_4= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1072:6: lv_rightValue_4= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2271);
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

            match(input,24,FOLLOW_24_in_ruleBiSingleAssignment2285); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1104:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBiListAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2320);
            iv_ruleBiListAssignment=ruleBiListAssignment();
            _fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiListAssignment2330); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1111:1: ruleBiListAssignment returns [EObject current=null] : ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValues_3 = null;

        EObject lv_leftValues_5 = null;

        EObject lv_rightValues_7 = null;

        EObject lv_rightValues_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1116:6: ( ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:1: ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:1: ( ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:2: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:2: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:3: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:3: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:4: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:4: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:5: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? ) '|'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:5: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:6: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:6: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:7: ( (lv_feature_0= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:7: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:8: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1117:8: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1119:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiListAssignment2383); 

            		createLeafNode(grammarAccess.prBiListAssignment().ele00000000LexerRuleCallID(), "feature"); 
            	

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

            match(input,27,FOLLOW_27_in_ruleBiListAssignment2400); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele0000001KeywordEqualsSign(), null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleBiListAssignment2410); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele000001KeywordLeftSquareBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1145:2: ( (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1145:3: (lv_leftValues_3= ruleListAssignmentValue ) ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1145:3: (lv_leftValues_3= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1148:6: lv_leftValues_3= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele0000100ParserRuleCallListAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2446);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1166:2: ( ',' (lv_leftValues_5= ruleListAssignmentValue ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==30) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1166:3: ',' (lv_leftValues_5= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2460); 

                    	            createLeafNode(grammarAccess.prBiListAssignment().ele0000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1170:1: (lv_leftValues_5= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1173:6: lv_leftValues_5= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00001110ParserRuleCallListAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2494);
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

            match(input,28,FOLLOW_28_in_ruleBiListAssignment2512); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele0001KeywordVerticalLine(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1195:2: ( (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1195:3: (lv_rightValues_7= ruleListAssignmentValue ) ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1195:3: (lv_rightValues_7= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1198:6: lv_rightValues_7= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00100ParserRuleCallListAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2548);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1216:2: ( ',' (lv_rightValues_9= ruleListAssignmentValue ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==30) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1216:3: ',' (lv_rightValues_9= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2562); 

                    	            createLeafNode(grammarAccess.prBiListAssignment().ele00110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1220:1: (lv_rightValues_9= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1223:6: lv_rightValues_9= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele001110ParserRuleCallListAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2596);
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

            match(input,31,FOLLOW_31_in_ruleBiListAssignment2614); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele01KeywordRightSquareBracket(), null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleBiListAssignment2624); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1258:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1258:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1259:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMonoSingleAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2659);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();
            _fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoSingleAssignment2669); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1266:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValue_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1271:6: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:1: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:1: ( ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:2: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:2: ( ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:3: ( (lv_feature_0= RULE_ID ) '=' ) (lv_leftValue_2= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:3: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:4: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1272:4: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1274:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2718); 

            		createLeafNode(grammarAccess.prMonoSingleAssignment().ele0000LexerRuleCallID(), "feature"); 
            	

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

            match(input,27,FOLLOW_27_in_ruleMonoSingleAssignment2735); 

                    createLeafNode(grammarAccess.prMonoSingleAssignment().ele001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1296:2: (lv_leftValue_2= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1299:6: lv_leftValue_2= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prMonoSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2770);
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

            match(input,24,FOLLOW_24_in_ruleMonoSingleAssignment2784); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1330:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1330:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1331:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMonoListAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2819);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();
            _fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoListAssignment2829); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1338:1: ruleMonoListAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        EObject lv_leftValues_3 = null;

        EObject lv_leftValues_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1343:6: ( ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:1: ( ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:2: ( ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:3: ( ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:4: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' ) ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:4: ( ( (lv_feature_0= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:5: ( (lv_feature_0= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:5: ( (lv_feature_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:6: (lv_feature_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1344:6: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1346:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoListAssignment2880); 

            		createLeafNode(grammarAccess.prMonoListAssignment().ele000000LexerRuleCallID(), "feature"); 
            	

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

            match(input,27,FOLLOW_27_in_ruleMonoListAssignment2897); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele00001KeywordEqualsSign(), null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleMonoListAssignment2907); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele0001KeywordLeftSquareBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1372:2: ( (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||(LA22_0>=34 && LA22_0<=35)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1372:3: (lv_leftValues_3= ruleAssignmentValue ) ( ',' (lv_leftValues_5= ruleAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1372:3: (lv_leftValues_3= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1375:6: lv_leftValues_3= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele00100ParserRuleCallAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2943);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1393:2: ( ',' (lv_leftValues_5= ruleAssignmentValue ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==30) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1393:3: ',' (lv_leftValues_5= ruleAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleMonoListAssignment2957); 

                    	            createLeafNode(grammarAccess.prMonoListAssignment().ele00110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1397:1: (lv_leftValues_5= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1400:6: lv_leftValues_5= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele001110ParserRuleCallAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2991);
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

            match(input,31,FOLLOW_31_in_ruleMonoListAssignment3009); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele01KeywordRightSquareBracket(), null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleMonoListAssignment3019); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1435:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1435:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1436:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3054);
            iv_ruleAssignmentValue=ruleAssignmentValue();
            _fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentValue3064); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1443:1: ruleAssignmentValue returns [EObject current=null] : ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;
        Token lv_refFeature_3=null;
        Token lv_refIndex_5=null;
        Token lv_impFrag_9=null;
        EObject lv_newObject_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1448:6: ( ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1449:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )", 27, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1449:1: ( ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:2: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:2: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) )
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
                            new NoViableAltException("1449:2: ( ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_7= ruleCreatedObject ) )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:3: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:3: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1449:3: ( (lv_value_0= RULE_STRING ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? ) )", 25, 0, input);

                                throw nvae;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:4: (lv_value_0= RULE_STRING )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1449:4: (lv_value_0= RULE_STRING )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1451:6: lv_value_0= RULE_STRING
                                    {
                                    lv_value_0=(Token)input.LT(1);
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssignmentValue3113); 

                                    		createLeafNode(grammarAccess.prAssignmentValue().ele0000LexerRuleCallSTRING(), "value"); 
                                    	

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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:7: ( RULE_ID ) ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:7: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1473:3: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3150); 

                                    		createLeafNode(grammarAccess.prAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
                                    	

                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1486:2: ( ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )? )?
                                    int alt24=2;
                                    int LA24_0 = input.LA(1);

                                    if ( (LA24_0==19) ) {
                                        alt24=1;
                                    }
                                    switch (alt24) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1486:3: ( '.' (lv_refFeature_3= RULE_ID ) ) ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1486:3: ( '.' (lv_refFeature_3= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1486:4: '.' (lv_refFeature_3= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleAssignmentValue3164); 

                                                    createLeafNode(grammarAccess.prAssignmentValue().ele001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:1: (lv_refFeature_3= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1492:6: lv_refFeature_3= RULE_ID
                                            {
                                            lv_refFeature_3=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3186); 

                                            		createLeafNode(grammarAccess.prAssignmentValue().ele0011010LexerRuleCallID(), "refFeature"); 
                                            	

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

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1510:3: ( ( '[' (lv_refIndex_5= RULE_INT ) ) ']' )?
                                            int alt23=2;
                                            int LA23_0 = input.LA(1);

                                            if ( (LA23_0==29) ) {
                                                alt23=1;
                                            }
                                            switch (alt23) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1510:4: ( '[' (lv_refIndex_5= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1510:4: ( '[' (lv_refIndex_5= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1510:5: '[' (lv_refIndex_5= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleAssignmentValue3206); 

                                                            createLeafNode(grammarAccess.prAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1514:1: (lv_refIndex_5= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1516:6: lv_refIndex_5= RULE_INT
                                                    {
                                                    lv_refIndex_5=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignmentValue3228); 

                                                    		createLeafNode(grammarAccess.prAssignmentValue().ele00111010LexerRuleCallINT(), "refIndex"); 
                                                    	

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

                                                    match(input,31,FOLLOW_31_in_ruleAssignmentValue3246); 

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1539:6: (lv_newObject_7= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1539:6: (lv_newObject_7= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1542:6: lv_newObject_7= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3292);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1561:6: ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1561:6: ( ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1561:7: ( RULE_ID ) (lv_impFrag_9= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1561:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1564:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prAssignmentValue().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3326); 

                    		createLeafNode(grammarAccess.prAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1577:2: (lv_impFrag_9= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1579:6: lv_impFrag_9= RULE_FRAGMENT
                    {
                    lv_impFrag_9=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3351); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1606:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1606:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1607:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prListAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3395);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();
            _fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListAssignmentValue3405); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1614:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1619:6: ( ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:1: ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:1: ( ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:2: ( (lv_index_0= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:2: ( (lv_index_0= RULE_INT ) ':' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:3: (lv_index_0= RULE_INT ) ':'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1620:3: (lv_index_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:6: lv_index_0= RULE_INT
            {
            lv_index_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3453); 

            		createLeafNode(grammarAccess.prListAssignmentValue().ele000LexerRuleCallINT(), "index"); 
            	

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

            match(input,32,FOLLOW_32_in_ruleListAssignmentValue3470); 

                    createLeafNode(grammarAccess.prListAssignmentValue().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:2: ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1644:2: ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )", 33, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1644:2: ( ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) ) )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:3: ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:3: ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) )
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
                            new NoViableAltException("1644:3: ( ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_12= ruleCreatedObject ) )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:4: ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:4: ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1644:4: ( ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? ) )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:5: ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:5: ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) )
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
                                            new NoViableAltException("1644:5: ( ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' ) | (lv_value_5= RULE_STRING ) )", 28, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt28) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:6: ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:6: ( ( '[' (lv_refIndex_3= RULE_INT ) ) ']' )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:7: ( '[' (lv_refIndex_3= RULE_INT ) ) ']'
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:7: ( '[' (lv_refIndex_3= RULE_INT ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1644:8: '[' (lv_refIndex_3= RULE_INT )
                                            {
                                            match(input,29,FOLLOW_29_in_ruleListAssignmentValue3486); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele1000000KeywordLeftSquareBracket(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1648:1: (lv_refIndex_3= RULE_INT )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1650:6: lv_refIndex_3= RULE_INT
                                            {
                                            lv_refIndex_3=(Token)input.LT(1);
                                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3508); 

                                            		createLeafNode(grammarAccess.prListAssignmentValue().ele10000010LexerRuleCallINT(), "refIndex"); 
                                            	

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

                                            match(input,31,FOLLOW_31_in_ruleListAssignmentValue3526); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele100001KeywordRightSquareBracket(), null); 
                                                

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1673:6: (lv_value_5= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1673:6: (lv_value_5= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1675:6: lv_value_5= RULE_STRING
                                            {
                                            lv_value_5=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleListAssignmentValue3555); 

                                            		createLeafNode(grammarAccess.prListAssignmentValue().ele100010LexerRuleCallSTRING(), "value"); 
                                            	

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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1694:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1694:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1694:7: ( RULE_ID ) ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1694:7: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1697:3: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3593); 

                                    		createLeafNode(grammarAccess.prListAssignmentValue().ele100100CrossReferenceEStringNamedObject(), "refObject"); 
                                    	

                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:2: ( ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )? )?
                                    int alt30=2;
                                    int LA30_0 = input.LA(1);

                                    if ( (LA30_0==19) ) {
                                        alt30=1;
                                    }
                                    switch (alt30) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:3: ( '.' (lv_refFeature_8= RULE_ID ) ) ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:3: ( '.' (lv_refFeature_8= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1710:4: '.' (lv_refFeature_8= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleListAssignmentValue3607); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele1001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1714:1: (lv_refFeature_8= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1716:6: lv_refFeature_8= RULE_ID
                                            {
                                            lv_refFeature_8=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3629); 

                                            		createLeafNode(grammarAccess.prListAssignmentValue().ele10011010LexerRuleCallID(), "refFeature"); 
                                            	

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

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1734:3: ( ( '[' (lv_refIndex_10= RULE_INT ) ) ']' )?
                                            int alt29=2;
                                            int LA29_0 = input.LA(1);

                                            if ( (LA29_0==29) ) {
                                                alt29=1;
                                            }
                                            switch (alt29) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1734:4: ( '[' (lv_refIndex_10= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1734:4: ( '[' (lv_refIndex_10= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1734:5: '[' (lv_refIndex_10= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue3649); 

                                                            createLeafNode(grammarAccess.prListAssignmentValue().ele10011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1738:1: (lv_refIndex_10= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1740:6: lv_refIndex_10= RULE_INT
                                                    {
                                                    lv_refIndex_10=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3671); 

                                                    		createLeafNode(grammarAccess.prListAssignmentValue().ele100111010LexerRuleCallINT(), "refIndex"); 
                                                    	

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

                                                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue3689); 

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1763:6: (lv_newObject_12= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1763:6: (lv_newObject_12= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:6: lv_newObject_12= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prListAssignmentValue().ele1010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3735);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:6: ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:6: ( ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:7: ( RULE_ID ) (lv_impFrag_14= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1788:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prListAssignmentValue().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3769); 

                    		createLeafNode(grammarAccess.prListAssignmentValue().ele1100CrossReferenceEStringImport(), "import"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1801:2: (lv_impFrag_14= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1803:6: lv_impFrag_14= RULE_FRAGMENT
                    {
                    lv_impFrag_14=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3794); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1830:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1830:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1831:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSingleAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3839);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();
            _fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleAssignmentValue3849); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1838:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1843:6: ( ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1844:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )", 39, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1844:1: ( ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) ) | ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:2: ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:2: ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) )
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
                            new NoViableAltException("1844:2: ( ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject_8= ruleCreatedObject ) )", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:3: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:3: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1844:3: ( ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) ) | ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? ) )", 37, 0, input);

                                throw nvae;
                            }
                            switch (alt37) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:4: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:4: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) )
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
                                            new NoViableAltException("1844:4: ( (lv_keyword_0= 'null' ) | (lv_value_1= RULE_STRING ) )", 34, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt34) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:5: (lv_keyword_0= 'null' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:5: (lv_keyword_0= 'null' )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1846:6: lv_keyword_0= 'null'
                                            {
                                            lv_keyword_0=(Token)input.LT(1);
                                            match(input,33,FOLLOW_33_in_ruleSingleAssignmentValue3898); 

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
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:6: (lv_value_1= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:6: (lv_value_1= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1868:6: lv_value_1= RULE_STRING
                                            {
                                            lv_value_1=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3939); 

                                            		createLeafNode(grammarAccess.prSingleAssignmentValue().ele00010LexerRuleCallSTRING(), "value"); 
                                            	

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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1887:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1887:6: ( ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1887:7: ( RULE_ID ) ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1887:7: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1890:3: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3977); 

                                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
                                    	

                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1903:2: ( ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )? )?
                                    int alt36=2;
                                    int LA36_0 = input.LA(1);

                                    if ( (LA36_0==19) ) {
                                        alt36=1;
                                    }
                                    switch (alt36) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1903:3: ( '.' (lv_refFeature_4= RULE_ID ) ) ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1903:3: ( '.' (lv_refFeature_4= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1903:4: '.' (lv_refFeature_4= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleSingleAssignmentValue3991); 

                                                    createLeafNode(grammarAccess.prSingleAssignmentValue().ele001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1907:1: (lv_refFeature_4= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1909:6: lv_refFeature_4= RULE_ID
                                            {
                                            lv_refFeature_4=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4013); 

                                            		createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011010LexerRuleCallID(), "refFeature"); 
                                            	

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

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1927:3: ( ( '[' (lv_refIndex_6= RULE_INT ) ) ']' )?
                                            int alt35=2;
                                            int LA35_0 = input.LA(1);

                                            if ( (LA35_0==29) ) {
                                                alt35=1;
                                            }
                                            switch (alt35) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1927:4: ( '[' (lv_refIndex_6= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1927:4: ( '[' (lv_refIndex_6= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1927:5: '[' (lv_refIndex_6= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleSingleAssignmentValue4033); 

                                                            createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1931:1: (lv_refIndex_6= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1933:6: lv_refIndex_6= RULE_INT
                                                    {
                                                    lv_refIndex_6=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4055); 

                                                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele00111010LexerRuleCallINT(), "refIndex"); 
                                                    	

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

                                                    match(input,31,FOLLOW_31_in_ruleSingleAssignmentValue4073); 

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1956:6: (lv_newObject_8= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1956:6: (lv_newObject_8= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1959:6: lv_newObject_8= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prSingleAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4119);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1978:6: ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1978:6: ( ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1978:7: ( RULE_ID ) (lv_impFrag_10= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1978:7: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1981:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prSingleAssignmentValue().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4153); 

                    		createLeafNode(grammarAccess.prSingleAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
                    	

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1994:2: (lv_impFrag_10= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1996:6: lv_impFrag_10= RULE_FRAGMENT
                    {
                    lv_impFrag_10=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4178); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2023:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2023:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2024:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCreatedObject().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4222);
            iv_ruleCreatedObject=ruleCreatedObject();
            _fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreatedObject4232); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2031:1: ruleCreatedObject returns [EObject current=null] : ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2036:6: ( ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:1: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:1: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:2: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? ) ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:2: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) (lv_name_2= RULE_ID )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2037:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
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
                    new NoViableAltException("2037:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2038:5: this_ObjectNew_0= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele000ParserRuleCallObjectNew(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectNew_in_ruleCreatedObject4281);
                    this_ObjectNew_0=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2048:5: this_ObjectCopy_1= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele001ParserRuleCallObjectCopy(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectCopy_in_ruleCreatedObject4308);
                    this_ObjectCopy_1=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2056:2: (lv_name_2= RULE_ID )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2058:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreatedObject4330); 

                    		createLeafNode(grammarAccess.prCreatedObject().ele010LexerRuleCallID(), "name"); 
                    	

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:4: ( ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==13) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:5: ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:5: ( ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:6: ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ ) (lv_leftMig_6= ruleMigration )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:6: ( '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:7: '{' ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleCreatedObject4352); 

                            createLeafNode(grammarAccess.prCreatedObject().ele1000KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2080:1: ( (lv_assignments_4= ruleMonoSingleAssignment ) | (lv_assignments_5= ruleMonoListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2080:2: (lv_assignments_4= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2080:2: (lv_assignments_4= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2083:6: lv_assignments_4= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100100ParserRuleCallMonoSingleAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4387);
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2102:6: (lv_assignments_5= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2102:6: (lv_assignments_5= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2105:6: lv_assignments_5= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100110ParserRuleCallMonoListAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4431);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2123:5: (lv_leftMig_6= ruleMigration )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==36) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2126:6: lv_leftMig_6= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele1010ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleCreatedObject4472);
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

                    match(input,14,FOLLOW_14_in_ruleCreatedObject4487); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2157:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2157:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2158:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectNew().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectNew_in_entryRuleObjectNew4524);
            iv_ruleObjectNew=ruleObjectNew();
            _fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectNew4534); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2165:1: ruleObjectNew returns [EObject current=null] : ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2170:6: ( ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2171:1: ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2171:1: ( ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2171:2: ( 'new' ( RULE_ID ) ) (lv_impFrag_2= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2171:2: ( 'new' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2171:3: 'new' ( RULE_ID )
            {
            match(input,34,FOLLOW_34_in_ruleObjectNew4569); 

                    createLeafNode(grammarAccess.prObjectNew().ele00KeywordNew(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2175:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2178:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prObjectNew().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectNew4591); 

            		createLeafNode(grammarAccess.prObjectNew().ele010CrossReferenceEStringImport(), "import"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2191:3: (lv_impFrag_2= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2193:6: lv_impFrag_2= RULE_FRAGMENT
            {
            lv_impFrag_2=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4617); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2220:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2220:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2221:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectCopy().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4660);
            iv_ruleObjectCopy=ruleObjectCopy();
            _fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectCopy4670); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2228:1: ruleObjectCopy returns [EObject current=null] : ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2233:6: ( ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2234:1: ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2234:1: ( ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2234:2: ( 'copy' ( RULE_ID ) ) (lv_fragment_2= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2234:2: ( 'copy' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2234:3: 'copy' ( RULE_ID )
            {
            match(input,35,FOLLOW_35_in_ruleObjectCopy4705); 

                    createLeafNode(grammarAccess.prObjectCopy().ele00KeywordCopy(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2238:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2241:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prObjectCopy().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectCopy4727); 

            		createLeafNode(grammarAccess.prObjectCopy().ele010CrossReferenceEStringNamedResource(), "resource"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2254:3: (lv_fragment_2= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2256:6: lv_fragment_2= RULE_FRAGMENT
            {
            lv_fragment_2=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4753); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2283:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2283:51: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2284:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMigration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMigration_in_entryRuleMigration4796);
            iv_ruleMigration=ruleMigration();
            _fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMigration4806); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2291:1: ruleMigration returns [EObject current=null] : ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1 = null;

        EObject lv_asOp_3 = null;

        EObject lv_eachOp_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2296:6: ( ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:1: ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:1: ( ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:2: ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:2: ( ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:3: ( 'migrate' (lv_first_1= ruleExecutable )? ) ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:3: ( 'migrate' (lv_first_1= ruleExecutable )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:4: 'migrate' (lv_first_1= ruleExecutable )?
            {
            match(input,36,FOLLOW_36_in_ruleMigration4842); 

                    createLeafNode(grammarAccess.prMigration().ele000KeywordMigrate(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2301:1: (lv_first_1= ruleExecutable )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_STRING||LA45_0==18) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2304:6: lv_first_1= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele0010ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4876);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2322:4: ( ( 'as' (lv_asOp_3= ruleExecutable ) ) | ( 'each' (lv_eachOp_5= ruleExecutable ) ) )?
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2322:5: ( 'as' (lv_asOp_3= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2322:5: ( 'as' (lv_asOp_3= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2322:6: 'as' (lv_asOp_3= ruleExecutable )
                    {
                    match(input,37,FOLLOW_37_in_ruleMigration4893); 

                            createLeafNode(grammarAccess.prMigration().ele0100KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2326:1: (lv_asOp_3= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2329:6: lv_asOp_3= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01010ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4927);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2348:6: ( 'each' (lv_eachOp_5= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2348:6: ( 'each' (lv_eachOp_5= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2348:7: 'each' (lv_eachOp_5= ruleExecutable )
                    {
                    match(input,38,FOLLOW_38_in_ruleMigration4948); 

                            createLeafNode(grammarAccess.prMigration().ele0110KeywordEach(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2352:1: (lv_eachOp_5= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2355:6: lv_eachOp_5= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01110ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4982);
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

            match(input,24,FOLLOW_24_in_ruleMigration4999); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2386:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2386:52: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2387:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExecutable_in_entryRuleExecutable5034);
            iv_ruleExecutable=ruleExecutable();
            _fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutable5044); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2394:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable_0 = null;

        EObject this_ExpressionExecutable_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2399:6: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2400:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2400:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
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
                    new NoViableAltException("2400:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2401:5: this_JavaExecutable_0= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExecutable().ele0ParserRuleCallJavaExecutable(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaExecutable_in_ruleExecutable5091);
                    this_JavaExecutable_0=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2411:5: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExecutable().ele1ParserRuleCallExpressionExecutable(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionExecutable_in_ruleExecutable5118);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2428:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2428:56: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2429:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prJavaExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5152);
            iv_ruleJavaExecutable=ruleJavaExecutable();
            _fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaExecutable5162); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2436:1: ruleJavaExecutable returns [EObject current=null] : ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2441:6: ( ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:1: ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:1: ( ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:2: ( ( 'java' (lv_method_1= RULE_ID ) ) '(' ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:2: ( ( 'java' (lv_method_1= RULE_ID ) ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:3: ( 'java' (lv_method_1= RULE_ID ) ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:3: ( 'java' (lv_method_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2442:4: 'java' (lv_method_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleJavaExecutable5198); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele000KeywordJava(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2446:1: (lv_method_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2448:6: lv_method_1= RULE_ID
            {
            lv_method_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaExecutable5220); 

            		createLeafNode(grammarAccess.prJavaExecutable().ele0010LexerRuleCallID(), "method"); 
            	

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

            match(input,39,FOLLOW_39_in_ruleJavaExecutable5238); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele01KeywordLeftParenthesis(), null); 
                

            }

            match(input,40,FOLLOW_40_in_ruleJavaExecutable5248); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2483:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2483:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2484:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExpressionExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5283);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();
            _fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionExecutable5293); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2491:1: ruleExpressionExecutable returns [EObject current=null] : (lv_exprstr_0= RULE_STRING ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2496:6: ( (lv_exprstr_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2497:1: (lv_exprstr_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2497:1: (lv_exprstr_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2499:6: lv_exprstr_0= RULE_STRING
            {
            lv_exprstr_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleExpressionExecutable5339); 

            		createLeafNode(grammarAccess.prExpressionExecutable().ele0LexerRuleCallSTRING(), "exprstr"); 
            	

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
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch143 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEPatch161 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleEPatch196 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch236 = new BitSet(new long[]{0x0000000004404000L});
    public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch276 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleEPatch291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_ruleImport384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelImport483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleResourceImport637 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport659 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResourceImport677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEPackageImport789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport811 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageImport829 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJavaImport941 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaImport950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport973 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleJavaImport992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport1014 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExtensionImport1105 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExtensionImport1114 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1137 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleExtensionImport1156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1178 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNamedResource1275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1297 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamedResource1315 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedResource1325 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1337 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1359 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1408 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1423 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNamedResource1433 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1445 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1467 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1516 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1531 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedResource1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleObjectRef1624 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1646 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1680 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1705 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1734 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1756 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1782 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1823 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1849 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleObjectRef1873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1908 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1952 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1969 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2003 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef2020 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2054 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleObjectRef2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment2170 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment2187 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2222 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment2236 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2271 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2383 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiListAssignment2400 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleBiListAssignment2410 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2446 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2460 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2494 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleBiListAssignment2512 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2548 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2562 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2596 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleBiListAssignment2614 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiListAssignment2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2718 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2735 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2770 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2880 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2897 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2907 = new BitSet(new long[]{0x0000000C80000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2943 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleMonoListAssignment2957 = new BitSet(new long[]{0x0000000C00000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2991 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleMonoListAssignment3009 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoListAssignment3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3150 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentValue3164 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3186 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignmentValue3206 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue3228 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentValue3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3326 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3453 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleListAssignmentValue3470 = new BitSet(new long[]{0x0000000C20000030L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3486 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3508 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3593 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleListAssignmentValue3607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3629 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3649 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3671 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3769 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3977 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue3991 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4013 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue4033 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4055 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject4281 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject4308 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject4330 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleCreatedObject4352 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4387 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4431 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject4472 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCreatedObject4487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew4524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleObjectNew4569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew4591 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleObjectCopy4705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy4727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration4796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMigration4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMigration4842 = new BitSet(new long[]{0x0000006001040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4876 = new BitSet(new long[]{0x0000006001000000L});
    public static final BitSet FOLLOW_37_in_ruleMigration4893 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4927 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_38_in_ruleMigration4948 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4982 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMigration4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable5034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutable5044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable5091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable5118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaExecutable5198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable5220 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleJavaExecutable5238 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleJavaExecutable5248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable5339 = new BitSet(new long[]{0x0000000000000002L});

}
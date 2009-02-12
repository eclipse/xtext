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
        	ClassLoader classLoader = InternalEpatchTestLanguageParser.class.getClassLoader();
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:78:1: ruleEPatch returns [EObject current=null] : ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_imports = null;

        EObject lv_resources = null;

        EObject lv_objects = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:82:6: ( ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:1: ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:1: ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:2: ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:2: ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:3: ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:3: ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:4: ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:4: ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:5: ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:5: ( ( 'epatch' (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:6: ( 'epatch' (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:6: ( 'epatch' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:83:7: 'epatch' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleEPatch121); 

                    createLeafNode(grammarAccess.prEPatch().ele000000KeywordEpatch(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:87:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:89:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPatch142); 
             
                createLeafNode(grammarAccess.prEPatch().ele0000010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EPatch");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEPatch163); 

                    createLeafNode(grammarAccess.prEPatch().ele00001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:111:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:114:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele00010ParserRuleCallImport(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleEPatch198);
            	    lv_imports=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPatch");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "imports", lv_imports, "Import", currentNode);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:132:4: (lv_resources= ruleNamedResource )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:135:6: lv_resources= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele0010ParserRuleCallNamedResource(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResource_in_ruleEPatch238);
            	    lv_resources=ruleNamedResource();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPatch");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "resources", lv_resources, "NamedResource", currentNode);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:153:4: (lv_objects= ruleObjectRef )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:156:6: lv_objects= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele010ParserRuleCallObjectRef(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleObjectRef_in_ruleEPatch278);
            	    lv_objects=ruleObjectRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPatch");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "objects", lv_objects, "ObjectRef", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleEPatch293); 

                    createLeafNode(grammarAccess.prEPatch().ele1KeywordRightCurlyBracket(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:187:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:187:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:188:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport328);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport338); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:195:1: ruleImport returns [EObject current=null] : ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport = null;

        EObject this_JavaImport = null;

        EObject this_ExtensionImport = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:199:6: ( ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:200:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:200:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )
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
                        new NoViableAltException("200:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("200:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:200:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:200:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )
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
                                new NoViableAltException("200:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )", 4, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("200:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:201:5: this_ModelImport= ruleModelImport
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prImport().ele00ParserRuleCallModelImport(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleModelImport_in_ruleImport386);
                            this_ModelImport=ruleModelImport();
                            _fsp--;

                             
                                    current = this_ModelImport; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:211:5: this_JavaImport= ruleJavaImport
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prImport().ele01ParserRuleCallJavaImport(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleJavaImport_in_ruleImport413);
                            this_JavaImport=ruleJavaImport();
                            _fsp--;

                             
                                    current = this_JavaImport; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:221:5: this_ExtensionImport= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prImport().ele1ParserRuleCallExtensionImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExtensionImport_in_ruleImport441);
                    this_ExtensionImport=ruleExtensionImport();
                    _fsp--;

                     
                            current = this_ExtensionImport; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:238:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:238:53: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:239:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModelImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelImport_in_entryRuleModelImport475);
            iv_ruleModelImport=ruleModelImport();
            _fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelImport485); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:246:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport = null;

        EObject this_EPackageImport = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:250:6: ( (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:251:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:251:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )
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
                            new NoViableAltException("251:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("251:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("251:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:252:5: this_ResourceImport= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModelImport().ele0ParserRuleCallResourceImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceImport_in_ruleModelImport532);
                    this_ResourceImport=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:262:5: this_EPackageImport= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModelImport().ele1ParserRuleCallEPackageImport(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEPackageImport_in_ruleModelImport559);
                    this_EPackageImport=ruleEPackageImport();
                    _fsp--;

                     
                            current = this_EPackageImport; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:279:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:279:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:280:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prResourceImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceImport_in_entryRuleResourceImport593);
            iv_ruleResourceImport=ruleResourceImport();
            _fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceImport603); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:287:1: ruleResourceImport returns [EObject current=null] : ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_uri=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:291:6: ( ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:2: ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:2: ( ( 'import' (lv_name= RULE_ID ) ) 'uri' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:3: ( 'import' (lv_name= RULE_ID ) ) 'uri'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:3: ( 'import' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:292:4: 'import' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleResourceImport639); 

                    createLeafNode(grammarAccess.prResourceImport().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:298:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceImport660); 
             
                createLeafNode(grammarAccess.prResourceImport().ele0010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ResourceImport");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleResourceImport681); 

                    createLeafNode(grammarAccess.prResourceImport().ele01KeywordUri(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:320:2: (lv_uri= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:322:6: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceImport703); 
             
                createLeafNode(grammarAccess.prResourceImport().ele10LexerRuleCallSTRING(), "uri"); 
                

            	        if (current==null) {
            	            current = factory.create("ResourceImport");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "uri", lv_uri, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:349:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:349:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:350:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport749);
            iv_ruleEPackageImport=ruleEPackageImport();
            _fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageImport759); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:357:1: ruleEPackageImport returns [EObject current=null] : ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:361:6: ( ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:2: ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:2: ( ( 'import' (lv_name= RULE_ID ) ) 'ns' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:3: ( 'import' (lv_name= RULE_ID ) ) 'ns'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:3: ( 'import' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:362:4: 'import' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleEPackageImport795); 

                    createLeafNode(grammarAccess.prEPackageImport().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:366:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:368:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPackageImport816); 
             
                createLeafNode(grammarAccess.prEPackageImport().ele0010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EPackageImport");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEPackageImport837); 

                    createLeafNode(grammarAccess.prEPackageImport().ele01KeywordNs(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:390:2: (lv_nsURI= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:392:6: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageImport859); 
             
                createLeafNode(grammarAccess.prEPackageImport().ele10LexerRuleCallSTRING(), "nsURI"); 
                

            	        if (current==null) {
            	            current = factory.create("EPackageImport");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "nsURI", lv_nsURI, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:419:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:419:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:420:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prJavaImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaImport_in_entryRuleJavaImport905);
            iv_ruleJavaImport=ruleJavaImport();
            _fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaImport915); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:427:1: ruleJavaImport returns [EObject current=null] : ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:431:6: ( ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:1: ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:1: ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:2: ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:2: ( ( 'import' 'java' ) (lv_path= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:3: ( 'import' 'java' ) (lv_path= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:3: ( 'import' 'java' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:432:4: 'import' 'java'
            {
            match(input,15,FOLLOW_15_in_ruleJavaImport951); 

                    createLeafNode(grammarAccess.prJavaImport().ele000KeywordImport(), null); 
                
            match(input,18,FOLLOW_18_in_ruleJavaImport960); 

                    createLeafNode(grammarAccess.prJavaImport().ele001KeywordJava(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:440:2: (lv_path= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:442:6: lv_path= RULE_ID
            {
            lv_path=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport982); 
             
                createLeafNode(grammarAccess.prJavaImport().ele010LexerRuleCallID(), "path"); 
                

            	        if (current==null) {
            	            current = factory.create("JavaImport");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "path", lv_path, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:460:3: ( '.' (lv_path= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:460:4: '.' (lv_path= RULE_ID )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleJavaImport1004); 

            	            createLeafNode(grammarAccess.prJavaImport().ele10KeywordFullStop(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:464:1: (lv_path= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:466:6: lv_path= RULE_ID
            	    {
            	    lv_path=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport1025); 
            	     
            	        createLeafNode(grammarAccess.prJavaImport().ele110LexerRuleCallID(), "path"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("JavaImport");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "path", lv_path, "ID", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:493:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:493:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:494:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExtensionImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1073);
            iv_ruleExtensionImport=ruleExtensionImport();
            _fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtensionImport1083); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:501:1: ruleExtensionImport returns [EObject current=null] : ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:505:6: ( ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:1: ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:1: ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:2: ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:2: ( ( 'import' 'extension' ) (lv_path= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:3: ( 'import' 'extension' ) (lv_path= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:3: ( 'import' 'extension' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:4: 'import' 'extension'
            {
            match(input,15,FOLLOW_15_in_ruleExtensionImport1119); 

                    createLeafNode(grammarAccess.prExtensionImport().ele000KeywordImport(), null); 
                
            match(input,20,FOLLOW_20_in_ruleExtensionImport1128); 

                    createLeafNode(grammarAccess.prExtensionImport().ele001KeywordExtension(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:514:2: (lv_path= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:516:6: lv_path= RULE_ID
            {
            lv_path=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1150); 
             
                createLeafNode(grammarAccess.prExtensionImport().ele010LexerRuleCallID(), "path"); 
                

            	        if (current==null) {
            	            current = factory.create("ExtensionImport");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "path", lv_path, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:534:3: ( '::' (lv_path= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:534:4: '::' (lv_path= RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleExtensionImport1172); 

            	            createLeafNode(grammarAccess.prExtensionImport().ele10KeywordColonColon(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:538:1: (lv_path= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:540:6: lv_path= RULE_ID
            	    {
            	    lv_path=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1193); 
            	     
            	        createLeafNode(grammarAccess.prExtensionImport().ele110LexerRuleCallID(), "path"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("ExtensionImport");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "path", lv_path, "ID", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:567:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:567:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:568:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNamedResource().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedResource_in_entryRuleNamedResource1241);
            iv_ruleNamedResource=ruleNamedResource();
            _fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResource1251); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:575:1: ruleNamedResource returns [EObject current=null] : ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_leftUri=null;
        Token lv_rightUri=null;
        EObject lv_leftRoot = null;

        EObject lv_rightRoot = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:6: ( ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:2: ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:2: ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:3: ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:3: ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:4: ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:4: ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:5: ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:5: ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:6: ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:6: ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:7: ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:7: ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:8: ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:8: ( ( 'resource' (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:9: ( 'resource' (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:9: ( 'resource' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:580:10: 'resource' (lv_name= RULE_ID )
            {
            match(input,22,FOLLOW_22_in_ruleNamedResource1293); 

                    createLeafNode(grammarAccess.prNamedResource().ele000000000KeywordResource(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:584:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:586:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedResource1314); 
             
                createLeafNode(grammarAccess.prNamedResource().ele0000000010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("NamedResource");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleNamedResource1335); 

                    createLeafNode(grammarAccess.prNamedResource().ele00000001KeywordLeftCurlyBracket(), null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleNamedResource1345); 

                    createLeafNode(grammarAccess.prNamedResource().ele0000001KeywordLeft(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:612:2: ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) )
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
                    new NoViableAltException("612:2: ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:612:3: ( 'uri' (lv_leftUri= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:612:3: ( 'uri' (lv_leftUri= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:612:4: 'uri' (lv_leftUri= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1357); 

                            createLeafNode(grammarAccess.prNamedResource().ele00000100KeywordUri(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:616:1: (lv_leftUri= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:618:6: lv_leftUri= RULE_STRING
                    {
                    lv_leftUri=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1378); 
                     
                        createLeafNode(grammarAccess.prNamedResource().ele000001010LexerRuleCallSTRING(), "leftUri"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("NamedResource");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "leftUri", lv_leftUri, "STRING", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:637:6: (lv_leftRoot= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:637:6: (lv_leftRoot= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:640:6: lv_leftRoot= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00000110ParserRuleCallCreatedObject(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1430);
                    lv_leftRoot=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("NamedResource");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "leftRoot", lv_leftRoot, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1445); 

                    createLeafNode(grammarAccess.prNamedResource().ele00001KeywordSemicolon(), null); 
                

            }

            match(input,25,FOLLOW_25_in_ruleNamedResource1455); 

                    createLeafNode(grammarAccess.prNamedResource().ele0001KeywordRight(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:666:2: ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) )
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
                    new NoViableAltException("666:2: ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:666:3: ( 'uri' (lv_rightUri= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:666:3: ( 'uri' (lv_rightUri= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:666:4: 'uri' (lv_rightUri= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1467); 

                            createLeafNode(grammarAccess.prNamedResource().ele00100KeywordUri(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:670:1: (lv_rightUri= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:672:6: lv_rightUri= RULE_STRING
                    {
                    lv_rightUri=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1488); 
                     
                        createLeafNode(grammarAccess.prNamedResource().ele001010LexerRuleCallSTRING(), "rightUri"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("NamedResource");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "rightUri", lv_rightUri, "STRING", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:691:6: (lv_rightRoot= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:691:6: (lv_rightRoot= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:694:6: lv_rightRoot= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00110ParserRuleCallCreatedObject(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCreatedObject_in_ruleNamedResource1540);
                    lv_rightRoot=ruleCreatedObject();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("NamedResource");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "rightRoot", lv_rightRoot, "CreatedObject", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,24,FOLLOW_24_in_ruleNamedResource1555); 

                    createLeafNode(grammarAccess.prNamedResource().ele01KeywordSemicolon(), null); 
                

            }

            match(input,14,FOLLOW_14_in_ruleNamedResource1565); 

                    createLeafNode(grammarAccess.prNamedResource().ele1KeywordRightCurlyBracket(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:731:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:731:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:732:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectRef_in_entryRuleObjectRef1602);
            iv_ruleObjectRef=ruleObjectRef();
            _fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectRef1612); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:739:1: ruleObjectRef returns [EObject current=null] : ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? ) ;
    public final EObject ruleObjectRef() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_leftFrag=null;
        Token lv_rightFrag=null;
        EObject lv_assignments = null;

        EObject lv_leftMig = null;

        EObject lv_rightMig = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:743:6: ( ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:1: ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:1: ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:2: ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:2: ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:3: ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:3: ( 'object' (lv_name= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:744:4: 'object' (lv_name= RULE_ID )?
            {
            match(input,26,FOLLOW_26_in_ruleObjectRef1648); 

                    createLeafNode(grammarAccess.prObjectRef().ele000KeywordObject(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:1: (lv_name= RULE_ID )?
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:750:6: lv_name= RULE_ID
                    {
                    lv_name=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1669); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele0010LexerRuleCallID(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "name", lv_name, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:768:4: ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) )
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
                    new NoViableAltException("768:4: ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:768:5: ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:768:5: ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:768:6: ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:768:6: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:771:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:777:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:778:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1708); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele01000CrossReferenceEStringNamedResource(), "leftRes"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:783:2: (lv_leftFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:785:6: lv_leftFrag= RULE_FRAGMENT
                    {
                    lv_leftFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1733); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele01010LexerRuleCallFRAGMENT(), "leftFrag"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "leftFrag", lv_leftFrag, "FRAGMENT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:6: ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:6: ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:7: ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:7: ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:8: ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:8: ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:9: ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:9: ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:10: ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:10: ( 'left' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:804:11: 'left' ( ( RULE_ID ) )
                    {
                    match(input,23,FOLLOW_23_in_ruleObjectRef1765); 

                            createLeafNode(grammarAccess.prObjectRef().ele01100000KeywordLeft(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:808:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:811:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:817:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:818:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1789); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele011000010CrossReferenceEStringNamedResource(), "leftRes"); 
                        

                    }


                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:823:3: (lv_leftFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:825:6: lv_leftFrag= RULE_FRAGMENT
                    {
                    lv_leftFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1815); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele01100010LexerRuleCallFRAGMENT(), "leftFrag"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "leftFrag", lv_leftFrag, "FRAGMENT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,25,FOLLOW_25_in_ruleObjectRef1836); 

                            createLeafNode(grammarAccess.prObjectRef().ele011001KeywordRight(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:847:2: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:850:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:856:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:857:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1861); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele011010CrossReferenceEStringNamedResource(), "rightRes"); 
                        

                    }


                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:862:3: (lv_rightFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:864:6: lv_rightFrag= RULE_FRAGMENT
                    {
                    lv_rightFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1887); 
                     
                        createLeafNode(grammarAccess.prObjectRef().ele01110LexerRuleCallFRAGMENT(), "rightFrag"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "rightFrag", lv_rightFrag, "FRAGMENT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:5: ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:6: ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:6: ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:7: ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:7: ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:8: ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:8: ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:882:9: '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleObjectRef1914); 

                            createLeafNode(grammarAccess.prObjectRef().ele10000KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:1: ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:2: (lv_assignments= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:2: (lv_assignments= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:889:6: lv_assignments= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000100ParserRuleCallBiSingleAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1949);
                    	    lv_assignments=ruleBiSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("ObjectRef");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "assignments", lv_assignments, "BiSingleAssignment", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:908:6: (lv_assignments= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:908:6: (lv_assignments= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:911:6: lv_assignments= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000110ParserRuleCallBiListAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBiListAssignment_in_ruleObjectRef1993);
                    	    lv_assignments=ruleBiListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("ObjectRef");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "assignments", lv_assignments, "BiListAssignment", currentNode);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:929:5: ( 'left' (lv_leftMig= ruleMigration ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==23) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:929:6: 'left' (lv_leftMig= ruleMigration )
                            {
                            match(input,23,FOLLOW_23_in_ruleObjectRef2010); 

                                    createLeafNode(grammarAccess.prObjectRef().ele10010KeywordLeft(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:933:1: (lv_leftMig= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:936:6: lv_leftMig= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele100110ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef2044);
                            lv_leftMig=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("ObjectRef");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "leftMig", lv_leftMig, "Migration", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:954:5: ( 'right' (lv_rightMig= ruleMigration ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==25) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:954:6: 'right' (lv_rightMig= ruleMigration )
                            {
                            match(input,25,FOLLOW_25_in_ruleObjectRef2061); 

                                    createLeafNode(grammarAccess.prObjectRef().ele1010KeywordRight(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:958:1: (lv_rightMig= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:961:6: lv_rightMig= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele10110ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleObjectRef2095);
                            lv_rightMig=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("ObjectRef");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "rightMig", lv_rightMig, "Migration", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    match(input,14,FOLLOW_14_in_ruleObjectRef2111); 

                            createLeafNode(grammarAccess.prObjectRef().ele11KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:994:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:994:60: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:995:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBiSingleAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2150);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();
            _fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiSingleAssignment2160); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1002:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValue = null;

        EObject lv_rightValue = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:6: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:3: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:3: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:4: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:4: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:5: ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:5: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:6: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:6: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1009:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiSingleAssignment2210); 
             
                createLeafNode(grammarAccess.prBiSingleAssignment().ele000000LexerRuleCallID(), "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("SingleAssignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleBiSingleAssignment2230); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele00001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1031:2: (lv_leftValue= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1034:6: lv_leftValue= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele00010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2265);
            lv_leftValue=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("SingleAssignment");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "leftValue", lv_leftValue, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,28,FOLLOW_28_in_ruleBiSingleAssignment2279); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele001KeywordVerticalLine(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1056:2: (lv_rightValue= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1059:6: lv_rightValue= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2314);
            lv_rightValue=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("SingleAssignment");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "rightValue", lv_rightValue, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleBiSingleAssignment2328); 

                    createLeafNode(grammarAccess.prBiSingleAssignment().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1090:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1090:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1091:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBiListAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2363);
            iv_ruleBiListAssignment=ruleBiListAssignment();
            _fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBiListAssignment2373); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1098:1: ruleBiListAssignment returns [EObject current=null] : ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValues = null;

        EObject lv_rightValues = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1102:6: ( ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:1: ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:1: ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:2: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:2: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:3: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:3: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:4: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:4: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:5: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:5: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:6: ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:6: ( ( (lv_feature= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:7: ( (lv_feature= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:7: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:8: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:8: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1105:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiListAssignment2425); 
             
                createLeafNode(grammarAccess.prBiListAssignment().ele00000000LexerRuleCallID(), "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("ListAssignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleBiListAssignment2445); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele0000001KeywordEqualsSign(), null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleBiListAssignment2455); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele000001KeywordLeftSquareBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1131:2: ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1131:3: (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1131:3: (lv_leftValues= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1134:6: lv_leftValues= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele0000100ParserRuleCallListAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2491);
                    lv_leftValues=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ListAssignment");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "leftValues", lv_leftValues, "ListAssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1152:2: ( ',' (lv_leftValues= ruleListAssignmentValue ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==30) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1152:3: ',' (lv_leftValues= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2505); 

                    	            createLeafNode(grammarAccess.prBiListAssignment().ele0000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1156:1: (lv_leftValues= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1159:6: lv_leftValues= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00001110ParserRuleCallListAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2539);
                    	    lv_leftValues=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("ListAssignment");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "leftValues", lv_leftValues, "ListAssignmentValue", currentNode);
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

            match(input,28,FOLLOW_28_in_ruleBiListAssignment2557); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele0001KeywordVerticalLine(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1181:2: ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1181:3: (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1181:3: (lv_rightValues= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1184:6: lv_rightValues= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00100ParserRuleCallListAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2593);
                    lv_rightValues=ruleListAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ListAssignment");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "rightValues", lv_rightValues, "ListAssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1202:2: ( ',' (lv_rightValues= ruleListAssignmentValue ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==30) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1202:3: ',' (lv_rightValues= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2607); 

                    	            createLeafNode(grammarAccess.prBiListAssignment().ele00110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1206:1: (lv_rightValues= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1209:6: lv_rightValues= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele001110ParserRuleCallListAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2641);
                    	    lv_rightValues=ruleListAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("ListAssignment");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "rightValues", lv_rightValues, "ListAssignmentValue", currentNode);
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

            match(input,31,FOLLOW_31_in_ruleBiListAssignment2659); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele01KeywordRightSquareBracket(), null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleBiListAssignment2669); 

                    createLeafNode(grammarAccess.prBiListAssignment().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1244:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1244:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1245:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMonoSingleAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2704);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();
            _fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoSingleAssignment2714); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1252:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValue = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1256:6: ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:1: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:1: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:2: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:2: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:3: ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:3: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:4: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:4: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1259:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2762); 
             
                createLeafNode(grammarAccess.prMonoSingleAssignment().ele0000LexerRuleCallID(), "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("SingleAssignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleMonoSingleAssignment2782); 

                    createLeafNode(grammarAccess.prMonoSingleAssignment().ele001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1281:2: (lv_leftValue= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1284:6: lv_leftValue= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prMonoSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2817);
            lv_leftValue=ruleSingleAssignmentValue();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("SingleAssignment");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "leftValue", lv_leftValue, "SingleAssignmentValue", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleMonoSingleAssignment2831); 

                    createLeafNode(grammarAccess.prMonoSingleAssignment().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1315:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1315:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1316:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMonoListAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2866);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();
            _fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonoListAssignment2876); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1323:1: ruleMonoListAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValues = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1327:6: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:3: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:3: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:4: ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:4: ( ( (lv_feature= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:5: ( (lv_feature= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:5: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:6: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:6: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1330:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoListAssignment2926); 
             
                createLeafNode(grammarAccess.prMonoListAssignment().ele000000LexerRuleCallID(), "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("ListAssignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,27,FOLLOW_27_in_ruleMonoListAssignment2946); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele00001KeywordEqualsSign(), null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleMonoListAssignment2956); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele0001KeywordLeftSquareBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1356:2: ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||(LA22_0>=34 && LA22_0<=35)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1356:3: (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1356:3: (lv_leftValues= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1359:6: lv_leftValues= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele00100ParserRuleCallAssignmentValue(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2992);
                    lv_leftValues=ruleAssignmentValue();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ListAssignment");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "leftValues", lv_leftValues, "AssignmentValue", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1377:2: ( ',' (lv_leftValues= ruleAssignmentValue ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==30) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1377:3: ',' (lv_leftValues= ruleAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleMonoListAssignment3006); 

                    	            createLeafNode(grammarAccess.prMonoListAssignment().ele00110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1381:1: (lv_leftValues= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1384:6: lv_leftValues= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele001110ParserRuleCallAssignmentValue(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment3040);
                    	    lv_leftValues=ruleAssignmentValue();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("ListAssignment");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "leftValues", lv_leftValues, "AssignmentValue", currentNode);
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

            match(input,31,FOLLOW_31_in_ruleMonoListAssignment3058); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele01KeywordRightSquareBracket(), null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleMonoListAssignment3068); 

                    createLeafNode(grammarAccess.prMonoListAssignment().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1419:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1419:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1420:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3103);
            iv_ruleAssignmentValue=ruleAssignmentValue();
            _fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentValue3113); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1427:1: ruleAssignmentValue returns [EObject current=null] : ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;
        Token lv_refFeature=null;
        Token lv_refIndex=null;
        Token lv_impFrag=null;
        EObject lv_newObject = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1431:6: ( ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1432:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 27, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1432:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:2: ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:2: ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
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
                            new NoViableAltException("1432:2: ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:3: ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:3: ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1432:3: ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )", 25, 0, input);

                                throw nvae;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:4: (lv_value= RULE_STRING )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:4: (lv_value= RULE_STRING )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1434:6: lv_value= RULE_STRING
                                    {
                                    lv_value=(Token)input.LT(1);
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssignmentValue3161); 
                                     
                                        createLeafNode(grammarAccess.prAssignmentValue().ele0000LexerRuleCallSTRING(), "value"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	        	factory.set(current, "value", lv_value, "STRING", currentNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1453:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1453:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1453:7: ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1453:7: ( ( RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1456:3: ( RULE_ID )
                                    {

                                    			if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1462:1: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1463:2: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3203); 
                                     
                                        createLeafNode(grammarAccess.prAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
                                        

                                    }


                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:2: ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    int alt24=2;
                                    int LA24_0 = input.LA(1);

                                    if ( (LA24_0==19) ) {
                                        alt24=1;
                                    }
                                    switch (alt24) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:3: ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:3: ( '.' (lv_refFeature= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:4: '.' (lv_refFeature= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleAssignmentValue3218); 

                                                    createLeafNode(grammarAccess.prAssignmentValue().ele001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:1: (lv_refFeature= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1474:6: lv_refFeature= RULE_ID
                                            {
                                            lv_refFeature=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3239); 
                                             
                                                createLeafNode(grammarAccess.prAssignmentValue().ele0011010LexerRuleCallID(), "refFeature"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "refFeature", lv_refFeature, "ID", currentNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1492:3: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            int alt23=2;
                                            int LA23_0 = input.LA(1);

                                            if ( (LA23_0==29) ) {
                                                alt23=1;
                                            }
                                            switch (alt23) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1492:4: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1492:4: ( '[' (lv_refIndex= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1492:5: '[' (lv_refIndex= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleAssignmentValue3262); 

                                                            createLeafNode(grammarAccess.prAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1496:1: (lv_refIndex= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1498:6: lv_refIndex= RULE_INT
                                                    {
                                                    lv_refIndex=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignmentValue3283); 
                                                     
                                                        createLeafNode(grammarAccess.prAssignmentValue().ele00111010LexerRuleCallINT(), "refIndex"); 
                                                        

                                                    	        if (current==null) {
                                                    	            current = factory.create("AssignmentValue");
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	        	factory.set(current, "refIndex", lv_refIndex, "INT", currentNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	    

                                                    }


                                                    }

                                                    match(input,31,FOLLOW_31_in_ruleAssignmentValue3304); 

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1521:6: (lv_newObject= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1521:6: (lv_newObject= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1524:6: lv_newObject= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3350);
                            lv_newObject=ruleCreatedObject();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("AssignmentValue");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "newObject", lv_newObject, "CreatedObject", currentNode);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1543:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1543:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1543:7: ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1543:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1546:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1552:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1553:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3386); 
                     
                        createLeafNode(grammarAccess.prAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1558:2: (lv_impFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1560:6: lv_impFrag= RULE_FRAGMENT
                    {
                    lv_impFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3411); 
                     
                        createLeafNode(grammarAccess.prAssignmentValue().ele110LexerRuleCallFRAGMENT(), "impFrag"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1587:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1587:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1588:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prListAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3458);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();
            _fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListAssignmentValue3468); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1595:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_index=null;
        Token lv_refIndex=null;
        Token lv_value=null;
        Token lv_refFeature=null;
        Token lv_impFrag=null;
        EObject lv_newObject = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:6: ( ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:1: ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:1: ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:2: ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:2: ( (lv_index= RULE_INT ) ':' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:3: (lv_index= RULE_INT ) ':'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:3: (lv_index= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1602:6: lv_index= RULE_INT
            {
            lv_index=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3515); 
             
                createLeafNode(grammarAccess.prListAssignmentValue().ele000LexerRuleCallINT(), "index"); 
                

            	        if (current==null) {
            	            current = factory.create("AssignmentValue");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "index", lv_index, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,32,FOLLOW_32_in_ruleListAssignmentValue3535); 

                    createLeafNode(grammarAccess.prListAssignmentValue().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:2: ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1624:2: ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 33, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1624:2: ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:3: ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:3: ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
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
                            new NoViableAltException("1624:3: ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:4: ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:4: ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1624:4: ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:5: ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:5: ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) )
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
                                            new NoViableAltException("1624:5: ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) )", 28, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt28) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:6: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:6: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:7: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:7: ( '[' (lv_refIndex= RULE_INT ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1624:8: '[' (lv_refIndex= RULE_INT )
                                            {
                                            match(input,29,FOLLOW_29_in_ruleListAssignmentValue3551); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele1000000KeywordLeftSquareBracket(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1628:1: (lv_refIndex= RULE_INT )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1630:6: lv_refIndex= RULE_INT
                                            {
                                            lv_refIndex=(Token)input.LT(1);
                                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3572); 
                                             
                                                createLeafNode(grammarAccess.prListAssignmentValue().ele10000010LexerRuleCallINT(), "refIndex"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "refIndex", lv_refIndex, "INT", currentNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            match(input,31,FOLLOW_31_in_ruleListAssignmentValue3593); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele100001KeywordRightSquareBracket(), null); 
                                                

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:6: (lv_value= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:6: (lv_value= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1655:6: lv_value= RULE_STRING
                                            {
                                            lv_value=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleListAssignmentValue3621); 
                                             
                                                createLeafNode(grammarAccess.prListAssignmentValue().ele100010LexerRuleCallSTRING(), "value"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "value", lv_value, "STRING", currentNode);
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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1674:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1674:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1674:7: ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1674:7: ( ( RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1677:3: ( RULE_ID )
                                    {

                                    			if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1683:1: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1684:2: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3664); 
                                     
                                        createLeafNode(grammarAccess.prListAssignmentValue().ele100100CrossReferenceEStringNamedObject(), "refObject"); 
                                        

                                    }


                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1689:2: ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    int alt30=2;
                                    int LA30_0 = input.LA(1);

                                    if ( (LA30_0==19) ) {
                                        alt30=1;
                                    }
                                    switch (alt30) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1689:3: ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1689:3: ( '.' (lv_refFeature= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1689:4: '.' (lv_refFeature= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleListAssignmentValue3679); 

                                                    createLeafNode(grammarAccess.prListAssignmentValue().ele1001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1693:1: (lv_refFeature= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1695:6: lv_refFeature= RULE_ID
                                            {
                                            lv_refFeature=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3700); 
                                             
                                                createLeafNode(grammarAccess.prListAssignmentValue().ele10011010LexerRuleCallID(), "refFeature"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "refFeature", lv_refFeature, "ID", currentNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1713:3: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            int alt29=2;
                                            int LA29_0 = input.LA(1);

                                            if ( (LA29_0==29) ) {
                                                alt29=1;
                                            }
                                            switch (alt29) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1713:4: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1713:4: ( '[' (lv_refIndex= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1713:5: '[' (lv_refIndex= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue3723); 

                                                            createLeafNode(grammarAccess.prListAssignmentValue().ele10011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1717:1: (lv_refIndex= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1719:6: lv_refIndex= RULE_INT
                                                    {
                                                    lv_refIndex=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3744); 
                                                     
                                                        createLeafNode(grammarAccess.prListAssignmentValue().ele100111010LexerRuleCallINT(), "refIndex"); 
                                                        

                                                    	        if (current==null) {
                                                    	            current = factory.create("AssignmentValue");
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	        	factory.set(current, "refIndex", lv_refIndex, "INT", currentNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	    

                                                    }


                                                    }

                                                    match(input,31,FOLLOW_31_in_ruleListAssignmentValue3765); 

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1742:6: (lv_newObject= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1742:6: (lv_newObject= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1745:6: lv_newObject= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prListAssignmentValue().ele1010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3811);
                            lv_newObject=ruleCreatedObject();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("AssignmentValue");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "newObject", lv_newObject, "CreatedObject", currentNode);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1764:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1764:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1764:7: ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1764:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1767:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1773:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1774:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3847); 
                     
                        createLeafNode(grammarAccess.prListAssignmentValue().ele1100CrossReferenceEStringImport(), "import"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1779:2: (lv_impFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1781:6: lv_impFrag= RULE_FRAGMENT
                    {
                    lv_impFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3872); 
                     
                        createLeafNode(grammarAccess.prListAssignmentValue().ele1110LexerRuleCallFRAGMENT(), "impFrag"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1808:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1808:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1809:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSingleAssignmentValue().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3920);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();
            _fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleAssignmentValue3930); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1816:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_keyword=null;
        Token lv_value=null;
        Token lv_refFeature=null;
        Token lv_refIndex=null;
        Token lv_impFrag=null;
        EObject lv_newObject = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1820:6: ( ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1821:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 39, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1821:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:2: ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:2: ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
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
                            new NoViableAltException("1821:2: ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:3: ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:3: ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1821:3: ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )", 37, 0, input);

                                throw nvae;
                            }
                            switch (alt37) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:4: ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:4: ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) )
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
                                            new NoViableAltException("1821:4: ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) )", 34, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt34) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:5: (lv_keyword= 'null' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:5: (lv_keyword= 'null' )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1823:6: lv_keyword= 'null'
                                            {
                                            lv_keyword=(Token)input.LT(1);
                                            match(input,33,FOLLOW_33_in_ruleSingleAssignmentValue3979); 

                                                    createLeafNode(grammarAccess.prSingleAssignmentValue().ele00000KeywordNull(), "keyword"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "keyword", input.LT(-1), "null", currentNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1842:6: (lv_value= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1842:6: (lv_value= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1844:6: lv_value= RULE_STRING
                                            {
                                            lv_value=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue4018); 
                                             
                                                createLeafNode(grammarAccess.prSingleAssignmentValue().ele00010LexerRuleCallSTRING(), "value"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "value", lv_value, "STRING", currentNode);
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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1863:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1863:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1863:7: ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1863:7: ( ( RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1866:3: ( RULE_ID )
                                    {

                                    			if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1872:1: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1873:2: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4061); 
                                     
                                        createLeafNode(grammarAccess.prSingleAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
                                        

                                    }


                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:2: ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    int alt36=2;
                                    int LA36_0 = input.LA(1);

                                    if ( (LA36_0==19) ) {
                                        alt36=1;
                                    }
                                    switch (alt36) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:3: ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:3: ( '.' (lv_refFeature= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:4: '.' (lv_refFeature= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleSingleAssignmentValue4076); 

                                                    createLeafNode(grammarAccess.prSingleAssignmentValue().ele001100KeywordFullStop(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1882:1: (lv_refFeature= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1884:6: lv_refFeature= RULE_ID
                                            {
                                            lv_refFeature=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4097); 
                                             
                                                createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011010LexerRuleCallID(), "refFeature"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("AssignmentValue");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "refFeature", lv_refFeature, "ID", currentNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	    

                                            }


                                            }

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1902:3: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            int alt35=2;
                                            int LA35_0 = input.LA(1);

                                            if ( (LA35_0==29) ) {
                                                alt35=1;
                                            }
                                            switch (alt35) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1902:4: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1902:4: ( '[' (lv_refIndex= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1902:5: '[' (lv_refIndex= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleSingleAssignmentValue4120); 

                                                            createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1906:1: (lv_refIndex= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1908:6: lv_refIndex= RULE_INT
                                                    {
                                                    lv_refIndex=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4141); 
                                                     
                                                        createLeafNode(grammarAccess.prSingleAssignmentValue().ele00111010LexerRuleCallINT(), "refIndex"); 
                                                        

                                                    	        if (current==null) {
                                                    	            current = factory.create("AssignmentValue");
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	        	factory.set(current, "refIndex", lv_refIndex, "INT", currentNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	    

                                                    }


                                                    }

                                                    match(input,31,FOLLOW_31_in_ruleSingleAssignmentValue4162); 

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1931:6: (lv_newObject= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1931:6: (lv_newObject= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1934:6: lv_newObject= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prSingleAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4208);
                            lv_newObject=ruleCreatedObject();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("AssignmentValue");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "newObject", lv_newObject, "CreatedObject", currentNode);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:7: ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1953:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1956:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1962:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1963:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4244); 
                     
                        createLeafNode(grammarAccess.prSingleAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1968:2: (lv_impFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1970:6: lv_impFrag= RULE_FRAGMENT
                    {
                    lv_impFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4269); 
                     
                        createLeafNode(grammarAccess.prSingleAssignmentValue().ele110LexerRuleCallFRAGMENT(), "impFrag"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1997:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1997:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1998:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCreatedObject().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4316);
            iv_ruleCreatedObject=ruleCreatedObject();
            _fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreatedObject4326); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2005:1: ruleCreatedObject returns [EObject current=null] : ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? ) ;
    public final EObject ruleCreatedObject() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject this_ObjectNew = null;

        EObject this_ObjectCopy = null;

        EObject lv_assignments = null;

        EObject lv_leftMig = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:6: ( ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:1: ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:1: ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:2: ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:2: ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:3: (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:3: (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy )
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
                    new NoViableAltException("2010:3: (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2011:5: this_ObjectNew= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele000ParserRuleCallObjectNew(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectNew_in_ruleCreatedObject4375);
                    this_ObjectNew=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2021:5: this_ObjectCopy= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele001ParserRuleCallObjectCopy(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectCopy_in_ruleCreatedObject4402);
                    this_ObjectCopy=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2029:2: (lv_name= RULE_ID )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2031:6: lv_name= RULE_ID
                    {
                    lv_name=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreatedObject4423); 
                     
                        createLeafNode(grammarAccess.prCreatedObject().ele010LexerRuleCallID(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("CreatedObject");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "name", lv_name, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:4: ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==13) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:5: ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:5: ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:6: ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:6: ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2049:7: '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleCreatedObject4448); 

                            createLeafNode(grammarAccess.prCreatedObject().ele1000KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2053:1: ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2053:2: (lv_assignments= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2053:2: (lv_assignments= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2056:6: lv_assignments= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100100ParserRuleCallMonoSingleAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4483);
                    	    lv_assignments=ruleMonoSingleAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("CreatedObject");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "assignments", lv_assignments, "MonoSingleAssignment", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2075:6: (lv_assignments= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2075:6: (lv_assignments= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2078:6: lv_assignments= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100110ParserRuleCallMonoListAssignment(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4527);
                    	    lv_assignments=ruleMonoListAssignment();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("CreatedObject");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "assignments", lv_assignments, "MonoListAssignment", currentNode);
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2096:5: (lv_leftMig= ruleMigration )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==36) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2099:6: lv_leftMig= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele1010ParserRuleCallMigration(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleMigration_in_ruleCreatedObject4568);
                            lv_leftMig=ruleMigration();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("CreatedObject");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "leftMig", lv_leftMig, "Migration", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;

                    }


                    }

                    match(input,14,FOLLOW_14_in_ruleCreatedObject4583); 

                            createLeafNode(grammarAccess.prCreatedObject().ele11KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2130:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2130:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2131:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectNew().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectNew_in_entryRuleObjectNew4620);
            iv_ruleObjectNew=ruleObjectNew();
            _fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectNew4630); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2138:1: ruleObjectNew returns [EObject current=null] : ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2142:6: ( ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2143:1: ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2143:1: ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2143:2: ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2143:2: ( 'new' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2143:3: 'new' ( ( RULE_ID ) )
            {
            match(input,34,FOLLOW_34_in_ruleObjectNew4665); 

                    createLeafNode(grammarAccess.prObjectNew().ele00KeywordNew(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2147:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2150:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("ObjectNew");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2156:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2157:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectNew4689); 
             
                createLeafNode(grammarAccess.prObjectNew().ele010CrossReferenceEStringImport(), "import"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2162:3: (lv_impFrag= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2164:6: lv_impFrag= RULE_FRAGMENT
            {
            lv_impFrag=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4715); 
             
                createLeafNode(grammarAccess.prObjectNew().ele10LexerRuleCallFRAGMENT(), "impFrag"); 
                

            	        if (current==null) {
            	            current = factory.create("ObjectNew");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2191:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2191:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2192:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode(grammarAccess.prObjectCopy().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4761);
            iv_ruleObjectCopy=ruleObjectCopy();
            _fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectCopy4771); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2199:1: ruleObjectCopy returns [EObject current=null] : ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2203:6: ( ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:1: ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:1: ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:2: ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:2: ( 'copy' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:3: 'copy' ( ( RULE_ID ) )
            {
            match(input,35,FOLLOW_35_in_ruleObjectCopy4806); 

                    createLeafNode(grammarAccess.prObjectCopy().ele00KeywordCopy(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2211:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("ObjectCopy");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2217:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2218:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectCopy4830); 
             
                createLeafNode(grammarAccess.prObjectCopy().ele010CrossReferenceEStringNamedResource(), "resource"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2223:3: (lv_fragment= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2225:6: lv_fragment= RULE_FRAGMENT
            {
            lv_fragment=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4856); 
             
                createLeafNode(grammarAccess.prObjectCopy().ele10LexerRuleCallFRAGMENT(), "fragment"); 
                

            	        if (current==null) {
            	            current = factory.create("ObjectCopy");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "fragment", lv_fragment, "FRAGMENT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2252:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2252:51: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2253:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMigration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMigration_in_entryRuleMigration4902);
            iv_ruleMigration=ruleMigration();
            _fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMigration4912); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2260:1: ruleMigration returns [EObject current=null] : ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first = null;

        EObject lv_asOp = null;

        EObject lv_eachOp = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2264:6: ( ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:1: ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:1: ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:2: ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:2: ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:3: ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:3: ( 'migrate' (lv_first= ruleExecutable )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2265:4: 'migrate' (lv_first= ruleExecutable )?
            {
            match(input,36,FOLLOW_36_in_ruleMigration4948); 

                    createLeafNode(grammarAccess.prMigration().ele000KeywordMigrate(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2269:1: (lv_first= ruleExecutable )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_STRING||LA45_0==18) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2272:6: lv_first= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele0010ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration4982);
                    lv_first=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Migration");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "first", lv_first, "Executable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2290:4: ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )?
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2290:5: ( 'as' (lv_asOp= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2290:5: ( 'as' (lv_asOp= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2290:6: 'as' (lv_asOp= ruleExecutable )
                    {
                    match(input,37,FOLLOW_37_in_ruleMigration4999); 

                            createLeafNode(grammarAccess.prMigration().ele0100KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2294:1: (lv_asOp= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2297:6: lv_asOp= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01010ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration5033);
                    lv_asOp=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Migration");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "asOp", lv_asOp, "Executable", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2316:6: ( 'each' (lv_eachOp= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2316:6: ( 'each' (lv_eachOp= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2316:7: 'each' (lv_eachOp= ruleExecutable )
                    {
                    match(input,38,FOLLOW_38_in_ruleMigration5054); 

                            createLeafNode(grammarAccess.prMigration().ele0110KeywordEach(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2320:1: (lv_eachOp= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2323:6: lv_eachOp= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01110ParserRuleCallExecutable(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExecutable_in_ruleMigration5088);
                    lv_eachOp=ruleExecutable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Migration");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "eachOp", lv_eachOp, "Executable", currentNode);
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

            match(input,24,FOLLOW_24_in_ruleMigration5105); 

                    createLeafNode(grammarAccess.prMigration().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2354:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2354:52: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2355:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExecutable_in_entryRuleExecutable5140);
            iv_ruleExecutable=ruleExecutable();
            _fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutable5150); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2362:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable = null;

        EObject this_ExpressionExecutable = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2366:6: ( (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2367:1: (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2367:1: (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable )
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
                    new NoViableAltException("2367:1: (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2368:5: this_JavaExecutable= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExecutable().ele0ParserRuleCallJavaExecutable(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaExecutable_in_ruleExecutable5197);
                    this_JavaExecutable=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2378:5: this_ExpressionExecutable= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExecutable().ele1ParserRuleCallExpressionExecutable(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionExecutable_in_ruleExecutable5224);
                    this_ExpressionExecutable=ruleExpressionExecutable();
                    _fsp--;

                     
                            current = this_ExpressionExecutable; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2395:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2395:56: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2396:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prJavaExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5258);
            iv_ruleJavaExecutable=ruleJavaExecutable();
            _fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaExecutable5268); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2403:1: ruleJavaExecutable returns [EObject current=null] : ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2407:6: ( ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:1: ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:1: ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:2: ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:2: ( ( 'java' (lv_method= RULE_ID ) ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:3: ( 'java' (lv_method= RULE_ID ) ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:3: ( 'java' (lv_method= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2408:4: 'java' (lv_method= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleJavaExecutable5304); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele000KeywordJava(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2412:1: (lv_method= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2414:6: lv_method= RULE_ID
            {
            lv_method=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaExecutable5325); 
             
                createLeafNode(grammarAccess.prJavaExecutable().ele0010LexerRuleCallID(), "method"); 
                

            	        if (current==null) {
            	            current = factory.create("JavaExecutable");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "method", lv_method, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,39,FOLLOW_39_in_ruleJavaExecutable5346); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele01KeywordLeftParenthesis(), null); 
                

            }

            match(input,40,FOLLOW_40_in_ruleJavaExecutable5356); 

                    createLeafNode(grammarAccess.prJavaExecutable().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2449:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2449:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2450:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExpressionExecutable().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5391);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();
            _fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionExecutable5401); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2457:1: ruleExpressionExecutable returns [EObject current=null] : (lv_exprstr= RULE_STRING ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2461:6: ( (lv_exprstr= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2462:1: (lv_exprstr= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2462:1: (lv_exprstr= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2464:6: lv_exprstr= RULE_STRING
            {
            lv_exprstr=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleExpressionExecutable5446); 
             
                createLeafNode(grammarAccess.prExpressionExecutable().ele0LexerRuleCallSTRING(), "exprstr"); 
                

            	        if (current==null) {
            	            current = factory.create("ExpressionExecutable");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "exprstr", lv_exprstr, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                
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
    public static final BitSet FOLLOW_13_in_ruleEPatch163 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleEPatch198 = new BitSet(new long[]{0x000000000440C000L});
    public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch238 = new BitSet(new long[]{0x0000000004404000L});
    public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch278 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleEPatch293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_ruleImport386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelImport485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleResourceImport639 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport660 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResourceImport681 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEPackageImport795 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport816 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageImport837 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJavaImport951 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaImport960 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport982 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleJavaImport1004 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport1025 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport1073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExtensionImport1119 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExtensionImport1128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1150 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleExtensionImport1172 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1193 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNamedResource1293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1314 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamedResource1335 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedResource1345 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1378 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1430 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1445 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNamedResource1455 = new BitSet(new long[]{0x0000000C00010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedResource1467 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1488 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1540 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNamedResource1555 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedResource1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleObjectRef1648 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1669 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1708 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1733 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef1765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1789 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1815 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef1836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1861 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1887 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleObjectRef1914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1949 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1993 = new BitSet(new long[]{0x0000000002804010L});
    public static final BitSet FOLLOW_23_in_ruleObjectRef2010 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2044 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleObjectRef2061 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2095 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleObjectRef2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment2210 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment2230 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2265 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment2279 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2314 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2425 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleBiListAssignment2445 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleBiListAssignment2455 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2491 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2505 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2539 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleBiListAssignment2557 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2593 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBiListAssignment2607 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2641 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleBiListAssignment2659 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBiListAssignment2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2762 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2782 = new BitSet(new long[]{0x0000000E00000030L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2817 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2926 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2946 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2956 = new BitSet(new long[]{0x0000000C80000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2992 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleMonoListAssignment3006 = new BitSet(new long[]{0x0000000C00000030L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment3040 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleMonoListAssignment3058 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMonoListAssignment3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3203 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentValue3218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3239 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignmentValue3262 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue3283 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentValue3304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3386 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3515 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleListAssignmentValue3535 = new BitSet(new long[]{0x0000000C20000030L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3551 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3572 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3664 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleListAssignmentValue3679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3700 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3723 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3744 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3847 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue4018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4061 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue4076 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4097 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue4120 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4141 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4244 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject4316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject4326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject4375 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject4402 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject4423 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleCreatedObject4448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject4483 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject4527 = new BitSet(new long[]{0x0000001000004010L});
    public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject4568 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCreatedObject4583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew4620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew4630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleObjectNew4665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew4689 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy4761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleObjectCopy4806 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy4830 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration4902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMigration4912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMigration4948 = new BitSet(new long[]{0x0000006001040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4982 = new BitSet(new long[]{0x0000006001000000L});
    public static final BitSet FOLLOW_37_in_ruleMigration4999 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration5033 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_38_in_ruleMigration5054 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration5088 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMigration5105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable5140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutable5150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable5224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable5258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaExecutable5304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable5325 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleJavaExecutable5346 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleJavaExecutable5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable5391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable5446 = new BitSet(new long[]{0x0000000000000002L});

}
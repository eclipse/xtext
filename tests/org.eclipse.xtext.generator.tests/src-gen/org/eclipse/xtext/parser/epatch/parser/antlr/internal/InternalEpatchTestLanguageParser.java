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


     
        public InternalEpatchTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:68:1: entryRuleEPatch returns [EObject current=null] : iv_ruleEPatch= ruleEPatch EOF ;
    public final EObject entryRuleEPatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPatch = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:68:48: (iv_ruleEPatch= ruleEPatch EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:69:2: iv_ruleEPatch= ruleEPatch EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:76:1: ruleEPatch returns [EObject current=null] : ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_imports = null;

        EObject lv_resources = null;

        EObject lv_objects = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:80:6: ( ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:1: ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:1: ( ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:2: ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:2: ( ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:3: ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* ) (lv_objects= ruleObjectRef )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:3: ( ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:4: ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* ) (lv_resources= ruleNamedResource )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:4: ( ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:5: ( ( 'epatch' (lv_name= RULE_ID ) ) '{' ) (lv_imports= ruleImport )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:5: ( ( 'epatch' (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:6: ( 'epatch' (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:6: ( 'epatch' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:81:7: 'epatch' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleEPatch121); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:85:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:87:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPatch142); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:109:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:112:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:130:4: (lv_resources= ruleNamedResource )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:133:6: lv_resources= ruleNamedResource
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:151:4: (lv_objects= ruleObjectRef )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:154:6: lv_objects= ruleObjectRef
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:185:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:185:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:186:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:193:1: ruleImport returns [EObject current=null] : ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport = null;

        EObject this_JavaImport = null;

        EObject this_ExtensionImport = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:197:6: ( ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:198:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:198:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )
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
                        new NoViableAltException("198:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("198:1: ( (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport ) | this_ExtensionImport= ruleExtensionImport )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:198:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:198:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )
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
                                new NoViableAltException("198:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )", 4, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("198:2: (this_ModelImport= ruleModelImport | this_JavaImport= ruleJavaImport )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:199:5: this_ModelImport= ruleModelImport
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleModelImport_in_ruleImport386);
                            this_ModelImport=ruleModelImport();
                            _fsp--;

                             
                                    current = this_ModelImport; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:209:5: this_JavaImport= ruleJavaImport
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:219:5: this_ExtensionImport= ruleExtensionImport
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:236:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:236:53: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:237:2: iv_ruleModelImport= ruleModelImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:244:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport = null;

        EObject this_EPackageImport = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:248:6: ( (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:249:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:249:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )
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
                            new NoViableAltException("249:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("249:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("249:1: (this_ResourceImport= ruleResourceImport | this_EPackageImport= ruleEPackageImport )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:250:5: this_ResourceImport= ruleResourceImport
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceImport_in_ruleModelImport532);
                    this_ResourceImport=ruleResourceImport();
                    _fsp--;

                     
                            current = this_ResourceImport; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:260:5: this_EPackageImport= ruleEPackageImport
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:277:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:277:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:278:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:285:1: ruleResourceImport returns [EObject current=null] : ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_uri=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:289:6: ( ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:2: ( ( 'import' (lv_name= RULE_ID ) ) 'uri' ) (lv_uri= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:2: ( ( 'import' (lv_name= RULE_ID ) ) 'uri' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:3: ( 'import' (lv_name= RULE_ID ) ) 'uri'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:3: ( 'import' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:290:4: 'import' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleResourceImport639); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:294:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:296:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceImport660); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:318:2: (lv_uri= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:320:6: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceImport703); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "uri"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:347:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:347:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:348:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:355:1: ruleEPackageImport returns [EObject current=null] : ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:359:6: ( ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:1: ( ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:2: ( ( 'import' (lv_name= RULE_ID ) ) 'ns' ) (lv_nsURI= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:2: ( ( 'import' (lv_name= RULE_ID ) ) 'ns' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:3: ( 'import' (lv_name= RULE_ID ) ) 'ns'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:3: ( 'import' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:360:4: 'import' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleEPackageImport795); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:364:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:366:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEPackageImport816); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:388:2: (lv_nsURI= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:390:6: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageImport859); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "nsURI"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:417:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:417:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:418:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:425:1: ruleJavaImport returns [EObject current=null] : ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token lv_path=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:429:6: ( ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:1: ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:1: ( ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:2: ( ( 'import' 'java' ) (lv_path= RULE_ID ) ) ( '.' (lv_path= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:2: ( ( 'import' 'java' ) (lv_path= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:3: ( 'import' 'java' ) (lv_path= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:3: ( 'import' 'java' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:430:4: 'import' 'java'
            {
            match(input,15,FOLLOW_15_in_ruleJavaImport951); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,18,FOLLOW_18_in_ruleJavaImport960); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:438:2: (lv_path= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:440:6: lv_path= RULE_ID
            {
            lv_path=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport982); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
                

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:458:3: ( '.' (lv_path= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:458:4: '.' (lv_path= RULE_ID )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleJavaImport1004); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:462:1: (lv_path= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:464:6: lv_path= RULE_ID
            	    {
            	    lv_path=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaImport1025); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
            	        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:491:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:491:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:492:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:499:1: ruleExtensionImport returns [EObject current=null] : ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token lv_path=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:503:6: ( ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:1: ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:1: ( ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:2: ( ( 'import' 'extension' ) (lv_path= RULE_ID ) ) ( '::' (lv_path= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:2: ( ( 'import' 'extension' ) (lv_path= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:3: ( 'import' 'extension' ) (lv_path= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:3: ( 'import' 'extension' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:4: 'import' 'extension'
            {
            match(input,15,FOLLOW_15_in_ruleExtensionImport1119); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,20,FOLLOW_20_in_ruleExtensionImport1128); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:512:2: (lv_path= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:514:6: lv_path= RULE_ID
            {
            lv_path=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1150); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
                

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:532:3: ( '::' (lv_path= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:532:4: '::' (lv_path= RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleExtensionImport1172); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:536:1: (lv_path= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:538:6: lv_path= RULE_ID
            	    {
            	    lv_path=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtensionImport1193); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
            	        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:565:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:565:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:566:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:573:1: ruleNamedResource returns [EObject current=null] : ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_leftUri=null;
        Token lv_rightUri=null;
        EObject lv_leftRoot = null;

        EObject lv_rightRoot = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:577:6: ( ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:1: ( ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:2: ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:2: ( ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:3: ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:3: ( ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:4: ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' ) ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:4: ( ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:5: ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' ) 'right'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:5: ( ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:6: ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:6: ( ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:7: ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' ) ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:7: ( ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:8: ( ( 'resource' (lv_name= RULE_ID ) ) '{' ) 'left'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:8: ( ( 'resource' (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:9: ( 'resource' (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:9: ( 'resource' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:10: 'resource' (lv_name= RULE_ID )
            {
            match(input,22,FOLLOW_22_in_ruleNamedResource1293); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:582:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:584:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedResource1314); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleNamedResource1345); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:2: ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) )
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
                    new NoViableAltException("610:2: ( ( 'uri' (lv_leftUri= RULE_STRING ) ) | (lv_leftRoot= ruleCreatedObject ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:3: ( 'uri' (lv_leftUri= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:3: ( 'uri' (lv_leftUri= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:610:4: 'uri' (lv_leftUri= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1357); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:614:1: (lv_leftUri= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:616:6: lv_leftUri= RULE_STRING
                    {
                    lv_leftUri=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1378); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "leftUri"); 
                        

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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:635:6: (lv_leftRoot= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:635:6: (lv_leftRoot= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:638:6: lv_leftRoot= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,25,FOLLOW_25_in_ruleNamedResource1455); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:664:2: ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) )
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
                    new NoViableAltException("664:2: ( ( 'uri' (lv_rightUri= RULE_STRING ) ) | (lv_rightRoot= ruleCreatedObject ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:664:3: ( 'uri' (lv_rightUri= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:664:3: ( 'uri' (lv_rightUri= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:664:4: 'uri' (lv_rightUri= RULE_STRING )
                    {
                    match(input,16,FOLLOW_16_in_ruleNamedResource1467); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:668:1: (lv_rightUri= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:670:6: lv_rightUri= RULE_STRING
                    {
                    lv_rightUri=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedResource1488); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "rightUri"); 
                        

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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:689:6: (lv_rightRoot= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:689:6: (lv_rightRoot= ruleCreatedObject )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:692:6: lv_rightRoot= ruleCreatedObject
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,14,FOLLOW_14_in_ruleNamedResource1565); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:729:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:729:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:730:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:737:1: ruleObjectRef returns [EObject current=null] : ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:741:6: ( ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:1: ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:1: ( ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:2: ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) ) ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:2: ( ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:3: ( 'object' (lv_name= RULE_ID )? ) ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:3: ( 'object' (lv_name= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:742:4: 'object' (lv_name= RULE_ID )?
            {
            match(input,26,FOLLOW_26_in_ruleObjectRef1648); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:746:1: (lv_name= RULE_ID )?
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:6: lv_name= RULE_ID
                    {
                    lv_name=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1669); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                        

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:4: ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) )
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
                    new NoViableAltException("766:4: ( ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) ) | ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:5: ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:5: ( ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:6: ( ( RULE_ID ) ) (lv_leftFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:6: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:769:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:775:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:776:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1708); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "leftRes"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:781:2: (lv_leftFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:783:6: lv_leftFrag= RULE_FRAGMENT
                    {
                    lv_leftFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1733); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "leftFrag"); 
                        

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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:6: ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:6: ( ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:7: ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) ) (lv_rightFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:7: ( ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:8: ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' ) ( ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:8: ( ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right' )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:9: ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) ) 'right'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:9: ( ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:10: ( 'left' ( ( RULE_ID ) ) ) (lv_leftFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:10: ( 'left' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:11: 'left' ( ( RULE_ID ) )
                    {
                    match(input,23,FOLLOW_23_in_ruleObjectRef1765); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:806:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:809:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:815:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:816:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1789); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "leftRes"); 
                        

                    }


                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:821:3: (lv_leftFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:823:6: lv_leftFrag= RULE_FRAGMENT
                    {
                    lv_leftFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1815); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "leftFrag"); 
                        

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

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:845:2: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:848:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ObjectRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:854:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:855:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectRef1861); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "rightRes"); 
                        

                    }


                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:860:3: (lv_rightFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:862:6: lv_rightFrag= RULE_FRAGMENT
                    {
                    lv_rightFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1887); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "rightFrag"); 
                        

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:5: ( ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:6: ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:6: ( ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:7: ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? ) ( 'right' (lv_rightMig= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:7: ( ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:8: ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ ) ( 'left' (lv_leftMig= ruleMigration ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:8: ( '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:880:9: '{' ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleObjectRef1914); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:884:1: ( (lv_assignments= ruleBiSingleAssignment ) | (lv_assignments= ruleBiListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:884:2: (lv_assignments= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:884:2: (lv_assignments= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:887:6: lv_assignments= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:906:6: (lv_assignments= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:906:6: (lv_assignments= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:909:6: lv_assignments= ruleBiListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:927:5: ( 'left' (lv_leftMig= ruleMigration ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==23) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:927:6: 'left' (lv_leftMig= ruleMigration )
                            {
                            match(input,23,FOLLOW_23_in_ruleObjectRef2010); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:931:1: (lv_leftMig= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:934:6: lv_leftMig= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                            	    
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:952:5: ( 'right' (lv_rightMig= ruleMigration ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==25) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:952:6: 'right' (lv_rightMig= ruleMigration )
                            {
                            match(input,25,FOLLOW_25_in_ruleObjectRef2061); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:956:1: (lv_rightMig= ruleMigration )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:959:6: lv_rightMig= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                            	    
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

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:992:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:992:60: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:993:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1000:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValue = null;

        EObject lv_rightValue = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1004:6: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:3: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' ) (lv_rightValue= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:3: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:4: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) '|'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:4: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:5: ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:5: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:6: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:6: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1007:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiSingleAssignment2210); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1029:2: (lv_leftValue= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1032:6: lv_leftValue= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1054:2: (lv_rightValue= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1057:6: lv_rightValue= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1096:1: ruleBiListAssignment returns [EObject current=null] : ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValues = null;

        EObject lv_rightValues = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1100:6: ( ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:1: ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:1: ( ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:2: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:2: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:3: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:3: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:4: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' ) ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:4: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:5: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? ) '|'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:5: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:6: ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:6: ( ( (lv_feature= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:7: ( (lv_feature= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:7: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:8: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1101:8: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1103:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBiListAssignment2425); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleBiListAssignment2455); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1129:2: ( (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1129:3: (lv_leftValues= ruleListAssignmentValue ) ( ',' (lv_leftValues= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1129:3: (lv_leftValues= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1132:6: lv_leftValues= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1150:2: ( ',' (lv_leftValues= ruleListAssignmentValue ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==30) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1150:3: ',' (lv_leftValues= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2505); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1154:1: (lv_leftValues= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1157:6: lv_leftValues= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1179:2: ( (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1179:3: (lv_rightValues= ruleListAssignmentValue ) ( ',' (lv_rightValues= ruleListAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1179:3: (lv_rightValues= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1182:6: lv_rightValues= ruleListAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1200:2: ( ',' (lv_rightValues= ruleListAssignmentValue ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==30) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1200:3: ',' (lv_rightValues= ruleListAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleBiListAssignment2607); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1204:1: (lv_rightValues= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1207:6: lv_rightValues= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleBiListAssignment2669); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1242:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1242:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1243:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.13" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1250:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValue = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1254:6: ( ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:1: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:1: ( ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:2: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:2: ( ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:3: ( (lv_feature= RULE_ID ) '=' ) (lv_leftValue= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:3: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:4: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1255:4: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1257:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2762); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1279:2: (lv_leftValue= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1282:6: lv_leftValue= ruleSingleAssignmentValue
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1313:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1313:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1314:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1321:1: ruleMonoListAssignment returns [EObject current=null] : ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        EObject lv_leftValues = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1325:6: ( ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:1: ( ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:2: ( ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:3: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:3: ( ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:4: ( ( (lv_feature= RULE_ID ) '=' ) '[' ) ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:4: ( ( (lv_feature= RULE_ID ) '=' ) '[' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:5: ( (lv_feature= RULE_ID ) '=' ) '['
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:5: ( (lv_feature= RULE_ID ) '=' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:6: (lv_feature= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1326:6: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1328:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonoListAssignment2926); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,29,FOLLOW_29_in_ruleMonoListAssignment2956); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1354:2: ( (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||(LA22_0>=34 && LA22_0<=35)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1354:3: (lv_leftValues= ruleAssignmentValue ) ( ',' (lv_leftValues= ruleAssignmentValue ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1354:3: (lv_leftValues= ruleAssignmentValue )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1357:6: lv_leftValues= ruleAssignmentValue
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1375:2: ( ',' (lv_leftValues= ruleAssignmentValue ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==30) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1375:3: ',' (lv_leftValues= ruleAssignmentValue )
                    	    {
                    	    match(input,30,FOLLOW_30_in_ruleMonoListAssignment3006); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1379:1: (lv_leftValues= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1382:6: lv_leftValues= ruleAssignmentValue
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,24,FOLLOW_24_in_ruleMonoListAssignment3068); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1417:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1417:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1418:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1425:1: ruleAssignmentValue returns [EObject current=null] : ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;
        Token lv_refFeature=null;
        Token lv_refIndex=null;
        Token lv_impFrag=null;
        EObject lv_newObject = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1429:6: ( ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1430:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 27, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1430:1: ( ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:2: ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:2: ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
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
                            new NoViableAltException("1430:2: ( ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:3: ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:3: ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1430:3: ( (lv_value= RULE_STRING ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )", 25, 0, input);

                                throw nvae;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:4: (lv_value= RULE_STRING )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:4: (lv_value= RULE_STRING )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1432:6: lv_value= RULE_STRING
                                    {
                                    lv_value=(Token)input.LT(1);
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssignmentValue3161); 
                                     
                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, "value"); 
                                        

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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1451:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1451:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1451:7: ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1451:7: ( ( RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1454:3: ( RULE_ID )
                                    {

                                    			if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1460:1: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1461:2: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3203); 
                                     
                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "refObject"); 
                                        

                                    }


                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:2: ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    int alt24=2;
                                    int LA24_0 = input.LA(1);

                                    if ( (LA24_0==19) ) {
                                        alt24=1;
                                    }
                                    switch (alt24) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:3: ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:3: ( '.' (lv_refFeature= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1466:4: '.' (lv_refFeature= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleAssignmentValue3218); 

                                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:1: (lv_refFeature= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1472:6: lv_refFeature= RULE_ID
                                            {
                                            lv_refFeature=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3239); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refFeature"); 
                                                

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

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:3: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            int alt23=2;
                                            int LA23_0 = input.LA(1);

                                            if ( (LA23_0==29) ) {
                                                alt23=1;
                                            }
                                            switch (alt23) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:4: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:4: ( '[' (lv_refIndex= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:5: '[' (lv_refIndex= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleAssignmentValue3262); 

                                                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1494:1: (lv_refIndex= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1496:6: lv_refIndex= RULE_INT
                                                    {
                                                    lv_refIndex=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignmentValue3283); 
                                                     
                                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
                                                        

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

                                                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                                                        

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:6: (lv_newObject= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:6: (lv_newObject= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1522:6: lv_newObject= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                            	    
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:7: ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1541:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1544:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1550:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1551:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentValue3386); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "import"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1556:2: (lv_impFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1558:6: lv_impFrag= RULE_FRAGMENT
                    {
                    lv_impFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3411); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1585:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1585:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1586:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1593:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1597:6: ( ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:1: ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:1: ( ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:2: ( (lv_index= RULE_INT ) ':' ) ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:2: ( (lv_index= RULE_INT ) ':' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:3: (lv_index= RULE_INT ) ':'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:3: (lv_index= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:6: lv_index= RULE_INT
            {
            lv_index=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3515); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "index"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:2: ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1622:2: ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 33, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1622:2: ( ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:3: ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:3: ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
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
                            new NoViableAltException("1622:3: ( ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:4: ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:4: ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1622:4: ( ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:5: ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:5: ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) )
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
                                            new NoViableAltException("1622:5: ( ( ( '[' (lv_refIndex= RULE_INT ) ) ']' ) | (lv_value= RULE_STRING ) )", 28, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt28) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:6: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:6: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:7: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:7: ( '[' (lv_refIndex= RULE_INT ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1622:8: '[' (lv_refIndex= RULE_INT )
                                            {
                                            match(input,29,FOLLOW_29_in_ruleListAssignmentValue3551); 

                                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1626:1: (lv_refIndex= RULE_INT )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1628:6: lv_refIndex= RULE_INT
                                            {
                                            lv_refIndex=(Token)input.LT(1);
                                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3572); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
                                                

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

                                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                                                

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1651:6: (lv_value= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1651:6: (lv_value= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1653:6: lv_value= RULE_STRING
                                            {
                                            lv_value=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleListAssignmentValue3621); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "value"); 
                                                

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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1672:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1672:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1672:7: ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1672:7: ( ( RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1675:3: ( RULE_ID )
                                    {

                                    			if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1681:1: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1682:2: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3664); 
                                     
                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "refObject"); 
                                        

                                    }


                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:2: ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    int alt30=2;
                                    int LA30_0 = input.LA(1);

                                    if ( (LA30_0==19) ) {
                                        alt30=1;
                                    }
                                    switch (alt30) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:3: ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:3: ( '.' (lv_refFeature= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:4: '.' (lv_refFeature= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleListAssignmentValue3679); 

                                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1691:1: (lv_refFeature= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1693:6: lv_refFeature= RULE_ID
                                            {
                                            lv_refFeature=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3700); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refFeature"); 
                                                

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

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1711:3: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            int alt29=2;
                                            int LA29_0 = input.LA(1);

                                            if ( (LA29_0==29) ) {
                                                alt29=1;
                                            }
                                            switch (alt29) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1711:4: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1711:4: ( '[' (lv_refIndex= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1711:5: '[' (lv_refIndex= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleListAssignmentValue3723); 

                                                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1715:1: (lv_refIndex= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1717:6: lv_refIndex= RULE_INT
                                                    {
                                                    lv_refIndex=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleListAssignmentValue3744); 
                                                     
                                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
                                                        

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

                                                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                                                        

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1740:6: (lv_newObject= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1740:6: (lv_newObject= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1743:6: lv_newObject= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                            	    
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1762:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1762:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1762:7: ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1762:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1765:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1771:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1772:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleListAssignmentValue3847); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "import"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1777:2: (lv_impFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1779:6: lv_impFrag= RULE_FRAGMENT
                    {
                    lv_impFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3872); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1806:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1806:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1807:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1814:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1818:6: ( ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
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
                        new NoViableAltException("1819:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 39, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1819:1: ( ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) ) | ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:2: ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:2: ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )
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
                            new NoViableAltException("1819:2: ( ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) ) | (lv_newObject= ruleCreatedObject ) )", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:3: ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:3: ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )
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
                                    new NoViableAltException("1819:3: ( ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) ) | ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? ) )", 37, 0, input);

                                throw nvae;
                            }
                            switch (alt37) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:4: ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:4: ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) )
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
                                            new NoViableAltException("1819:4: ( (lv_keyword= 'null' ) | (lv_value= RULE_STRING ) )", 34, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt34) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:5: (lv_keyword= 'null' )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1819:5: (lv_keyword= 'null' )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1821:6: lv_keyword= 'null'
                                            {
                                            lv_keyword=(Token)input.LT(1);
                                            match(input,33,FOLLOW_33_in_ruleSingleAssignmentValue3979); 

                                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::Keyword */, "keyword"); 
                                                

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
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1840:6: (lv_value= RULE_STRING )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1840:6: (lv_value= RULE_STRING )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1842:6: lv_value= RULE_STRING
                                            {
                                            lv_value=(Token)input.LT(1);
                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue4018); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "value"); 
                                                

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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:6: ( ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )? )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:7: ( ( RULE_ID ) ) ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1861:7: ( ( RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1864:3: ( RULE_ID )
                                    {

                                    			if (current==null) {
                                    	            current = factory.create("AssignmentValue");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1870:1: ( RULE_ID )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1871:2: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4061); 
                                     
                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "refObject"); 
                                        

                                    }


                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1876:2: ( ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )? )?
                                    int alt36=2;
                                    int LA36_0 = input.LA(1);

                                    if ( (LA36_0==19) ) {
                                        alt36=1;
                                    }
                                    switch (alt36) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1876:3: ( '.' (lv_refFeature= RULE_ID ) ) ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1876:3: ( '.' (lv_refFeature= RULE_ID ) )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1876:4: '.' (lv_refFeature= RULE_ID )
                                            {
                                            match(input,19,FOLLOW_19_in_ruleSingleAssignmentValue4076); 

                                                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1880:1: (lv_refFeature= RULE_ID )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1882:6: lv_refFeature= RULE_ID
                                            {
                                            lv_refFeature=(Token)input.LT(1);
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4097); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refFeature"); 
                                                

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

                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:3: ( ( '[' (lv_refIndex= RULE_INT ) ) ']' )?
                                            int alt35=2;
                                            int LA35_0 = input.LA(1);

                                            if ( (LA35_0==29) ) {
                                                alt35=1;
                                            }
                                            switch (alt35) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:4: ( '[' (lv_refIndex= RULE_INT ) ) ']'
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:4: ( '[' (lv_refIndex= RULE_INT ) )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1900:5: '[' (lv_refIndex= RULE_INT )
                                                    {
                                                    match(input,29,FOLLOW_29_in_ruleSingleAssignmentValue4120); 

                                                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1904:1: (lv_refIndex= RULE_INT )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1906:6: lv_refIndex= RULE_INT
                                                    {
                                                    lv_refIndex=(Token)input.LT(1);
                                                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4141); 
                                                     
                                                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
                                                        

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

                                                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                                                        

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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1929:6: (lv_newObject= ruleCreatedObject )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1929:6: (lv_newObject= ruleCreatedObject )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1932:6: lv_newObject= ruleCreatedObject
                            {
                             
                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                            	    
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1951:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1951:6: ( ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1951:7: ( ( RULE_ID ) ) (lv_impFrag= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1951:7: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1954:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("AssignmentValue");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1960:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1961:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4244); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "import"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1966:2: (lv_impFrag= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1968:6: lv_impFrag= RULE_FRAGMENT
                    {
                    lv_impFrag=(Token)input.LT(1);
                    match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue4269); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.17/@alternatives/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1995:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1995:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1996:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2003:1: ruleCreatedObject returns [EObject current=null] : ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? ) ;
    public final EObject ruleCreatedObject() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject this_ObjectNew = null;

        EObject this_ObjectCopy = null;

        EObject lv_assignments = null;

        EObject lv_leftMig = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2007:6: ( ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:1: ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:1: ( ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:2: ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? ) ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:2: ( (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:3: (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy ) (lv_name= RULE_ID )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2008:3: (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy )
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
                    new NoViableAltException("2008:3: (this_ObjectNew= ruleObjectNew | this_ObjectCopy= ruleObjectCopy )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2009:5: this_ObjectNew= ruleObjectNew
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.0/@abstractTokens.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectNew_in_ruleCreatedObject4375);
                    this_ObjectNew=ruleObjectNew();
                    _fsp--;

                     
                            current = this_ObjectNew; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2019:5: this_ObjectCopy= ruleObjectCopy
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleObjectCopy_in_ruleCreatedObject4402);
                    this_ObjectCopy=ruleObjectCopy();
                    _fsp--;

                     
                            current = this_ObjectCopy; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2027:2: (lv_name= RULE_ID )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2029:6: lv_name= RULE_ID
                    {
                    lv_name=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreatedObject4423); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                        

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:4: ( ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==13) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:5: ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:5: ( ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:6: ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ ) (lv_leftMig= ruleMigration )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:6: ( '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2047:7: '{' ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+
                    {
                    match(input,13,FOLLOW_13_in_ruleCreatedObject4448); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2051:1: ( (lv_assignments= ruleMonoSingleAssignment ) | (lv_assignments= ruleMonoListAssignment ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2051:2: (lv_assignments= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2051:2: (lv_assignments= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2054:6: lv_assignments= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2073:6: (lv_assignments= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2073:6: (lv_assignments= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2076:6: lv_assignments= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
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

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2094:5: (lv_leftMig= ruleMigration )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==36) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2097:6: lv_leftMig= ruleMigration
                            {
                             
                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                            	    
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

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2128:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2128:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2129:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.19" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2136:1: ruleObjectNew returns [EObject current=null] : ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token lv_impFrag=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2140:6: ( ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2141:1: ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2141:1: ( ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2141:2: ( 'new' ( ( RULE_ID ) ) ) (lv_impFrag= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2141:2: ( 'new' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2141:3: 'new' ( ( RULE_ID ) )
            {
            match(input,34,FOLLOW_34_in_ruleObjectNew4665); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.19/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2145:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2148:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("ObjectNew");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2154:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2155:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectNew4689); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.19/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "import"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2160:3: (lv_impFrag= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2162:6: lv_impFrag= RULE_FRAGMENT
            {
            lv_impFrag=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectNew4715); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.19/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2189:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2189:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2190:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.20" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2197:1: ruleObjectCopy returns [EObject current=null] : ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token lv_fragment=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2201:6: ( ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2202:1: ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2202:1: ( ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2202:2: ( 'copy' ( ( RULE_ID ) ) ) (lv_fragment= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2202:2: ( 'copy' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2202:3: 'copy' ( ( RULE_ID ) )
            {
            match(input,35,FOLLOW_35_in_ruleObjectCopy4806); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2206:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2209:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("ObjectCopy");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2215:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2216:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectCopy4830); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "resource"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2221:3: (lv_fragment= RULE_FRAGMENT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2223:6: lv_fragment= RULE_FRAGMENT
            {
            lv_fragment=(Token)input.LT(1);
            match(input,RULE_FRAGMENT,FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4856); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "fragment"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2250:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2250:51: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2251:2: iv_ruleMigration= ruleMigration EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2258:1: ruleMigration returns [EObject current=null] : ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        EObject lv_first = null;

        EObject lv_asOp = null;

        EObject lv_eachOp = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2262:6: ( ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:1: ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:1: ( ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:2: ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:2: ( ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:3: ( 'migrate' (lv_first= ruleExecutable )? ) ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:3: ( 'migrate' (lv_first= ruleExecutable )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2263:4: 'migrate' (lv_first= ruleExecutable )?
            {
            match(input,36,FOLLOW_36_in_ruleMigration4948); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2267:1: (lv_first= ruleExecutable )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_STRING||LA45_0==18) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2270:6: lv_first= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2288:4: ( ( 'as' (lv_asOp= ruleExecutable ) ) | ( 'each' (lv_eachOp= ruleExecutable ) ) )?
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2288:5: ( 'as' (lv_asOp= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2288:5: ( 'as' (lv_asOp= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2288:6: 'as' (lv_asOp= ruleExecutable )
                    {
                    match(input,37,FOLLOW_37_in_ruleMigration4999); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2292:1: (lv_asOp= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2295:6: lv_asOp= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2314:6: ( 'each' (lv_eachOp= ruleExecutable ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2314:6: ( 'each' (lv_eachOp= ruleExecutable ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2314:7: 'each' (lv_eachOp= ruleExecutable )
                    {
                    match(input,38,FOLLOW_38_in_ruleMigration5054); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2318:1: (lv_eachOp= ruleExecutable )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2321:6: lv_eachOp= ruleExecutable
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.22/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2352:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2352:52: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2353:2: iv_ruleExecutable= ruleExecutable EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.23" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2360:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable = null;

        EObject this_ExpressionExecutable = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2364:6: ( (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2365:1: (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2365:1: (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable )
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
                    new NoViableAltException("2365:1: (this_JavaExecutable= ruleJavaExecutable | this_ExpressionExecutable= ruleExpressionExecutable )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2366:5: this_JavaExecutable= ruleJavaExecutable
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.23/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleJavaExecutable_in_ruleExecutable5197);
                    this_JavaExecutable=ruleJavaExecutable();
                    _fsp--;

                     
                            current = this_JavaExecutable; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2376:5: this_ExpressionExecutable= ruleExpressionExecutable
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.23/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2393:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2393:56: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2394:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.24" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2401:1: ruleJavaExecutable returns [EObject current=null] : ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_method=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2405:6: ( ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:1: ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:1: ( ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:2: ( ( 'java' (lv_method= RULE_ID ) ) '(' ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:2: ( ( 'java' (lv_method= RULE_ID ) ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:3: ( 'java' (lv_method= RULE_ID ) ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:3: ( 'java' (lv_method= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2406:4: 'java' (lv_method= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleJavaExecutable5304); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2410:1: (lv_method= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2412:6: lv_method= RULE_ID
            {
            lv_method=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaExecutable5325); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "method"); 
                

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

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,40,FOLLOW_40_in_ruleJavaExecutable5356); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2447:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2447:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2448:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.25" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2455:1: ruleExpressionExecutable returns [EObject current=null] : (lv_exprstr= RULE_STRING ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2459:6: ( (lv_exprstr= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2460:1: (lv_exprstr= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2460:1: (lv_exprstr= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2462:6: lv_exprstr= RULE_STRING
            {
            lv_exprstr=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleExpressionExecutable5446); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#//@rules.25/@alternatives/@terminal" /* xtext::RuleCall */, "exprstr"); 
                

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
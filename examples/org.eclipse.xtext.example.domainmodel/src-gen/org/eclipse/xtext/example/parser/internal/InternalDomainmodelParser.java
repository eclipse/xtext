// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g 2009-01-06 12:26:45

package org.eclipse.xtext.example.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDomainmodelParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'{'", "'}'", "'datatype'", "'entity'", "'extends'", "'attr'", "':'", "'ref'", "'opposite'", "'op'", "'('", "','", "')'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalDomainmodelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g"; }


     
        public InternalDomainmodelParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalDomainmodelParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/internal/InternalDomainmodel.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:66:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:66:46: (iv_ruleFile= ruleFile EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:67:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile71);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile81); 

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
    // $ANTLR end entryRuleFile


    // $ANTLR start ruleFile
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:74:1: ruleFile returns [EObject current=null] : ( (lv_imports= ruleImport )* (lv_namedElements= ruleNamedElement )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports = null;

        EObject lv_namedElements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:76:33: ( ( (lv_imports= ruleImport )* (lv_namedElements= ruleNamedElement )* ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:77:1: ( (lv_imports= ruleImport )* (lv_namedElements= ruleNamedElement )* )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:77:1: ( (lv_imports= ruleImport )* (lv_namedElements= ruleNamedElement )* )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:77:2: (lv_imports= ruleImport )* (lv_namedElements= ruleNamedElement )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:77:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:80:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleFile140);
            	    lv_imports=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("File");
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

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:98:3: (lv_namedElements= ruleNamedElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||(LA2_0>=15 && LA2_0<=16)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:101:6: lv_namedElements= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_ruleFile179);
            	    lv_namedElements=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("File");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "namedElements", lv_namedElements, "NamedElement", currentNode);
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleImport
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:126:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:126:48: (iv_ruleImport= ruleImport EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:127:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport217);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport227); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:134:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:136:33: ( ( 'import' (lv_importURI= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:137:1: ( 'import' (lv_importURI= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:137:1: ( 'import' (lv_importURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:137:2: 'import' (lv_importURI= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport261); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:141:1: (lv_importURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:143:6: lv_importURI= RULE_STRING
            {
            lv_importURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport282); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "importURI"); 
                

            	        if (current==null) {
            	            current = factory.create("Import");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "importURI", lv_importURI, "STRING", currentNode);
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleNamedElement
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:168:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:168:54: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:169:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNamedElement_in_entryRuleNamedElement326);
            iv_ruleNamedElement=ruleNamedElement();
            _fsp--;

             current =iv_ruleNamedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedElement336); 

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
    // $ANTLR end entryRuleNamedElement


    // $ANTLR start ruleNamedElement
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:176:1: ruleNamedElement returns [EObject current=null] : (this_Package= rulePackage | this_Type= ruleType ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Package = null;

        EObject this_Type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:178:33: ( (this_Package= rulePackage | this_Type= ruleType ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:179:1: (this_Package= rulePackage | this_Type= ruleType )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:179:1: (this_Package= rulePackage | this_Type= ruleType )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("179:1: (this_Package= rulePackage | this_Type= ruleType )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:180:5: this_Package= rulePackage
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_rulePackage_in_ruleNamedElement383);
                    this_Package=rulePackage();
                    _fsp--;

                     
                            current = this_Package; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:190:5: this_Type= ruleType
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleNamedElement410);
                    this_Type=ruleType();
                    _fsp--;

                     
                            current = this_Type; 
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
    // $ANTLR end ruleNamedElement


    // $ANTLR start entryRulePackage
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:205:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:205:49: (iv_rulePackage= rulePackage EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:206:2: iv_rulePackage= rulePackage EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_rulePackage_in_entryRulePackage442);
            iv_rulePackage=rulePackage();
            _fsp--;

             current =iv_rulePackage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackage452); 

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
    // $ANTLR end entryRulePackage


    // $ANTLR start rulePackage
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:213:1: rulePackage returns [EObject current=null] : ( ( ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )* ) '}' ) ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_namedElements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:215:33: ( ( ( ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:1: ( ( ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:1: ( ( ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )* ) '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:2: ( ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:2: ( ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )* )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:3: ( ( 'package' (lv_name= RULE_ID ) ) '{' ) (lv_namedElements= ruleNamedElement )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:3: ( ( 'package' (lv_name= RULE_ID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:4: ( 'package' (lv_name= RULE_ID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:4: ( 'package' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:216:5: 'package' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_rulePackage489); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:220:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:222:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePackage510); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Package");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_rulePackage531); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:244:2: (lv_namedElements= ruleNamedElement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12||(LA4_0>=15 && LA4_0<=16)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:247:6: lv_namedElements= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_rulePackage566);
            	    lv_namedElements=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Package");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "namedElements", lv_namedElements, "NamedElement", currentNode);
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


            }

            match(input,14,FOLLOW_14_in_rulePackage581); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end rulePackage


    // $ANTLR start entryRuleType
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:276:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:276:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:277:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType614);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType624); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:284:1: ruleType returns [EObject current=null] : (this_Entity= ruleEntity | this_DataType= ruleDataType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity = null;

        EObject this_DataType = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:286:33: ( (this_Entity= ruleEntity | this_DataType= ruleDataType ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:287:1: (this_Entity= ruleEntity | this_DataType= ruleDataType )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:287:1: (this_Entity= ruleEntity | this_DataType= ruleDataType )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("287:1: (this_Entity= ruleEntity | this_DataType= ruleDataType )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:288:5: this_Entity= ruleEntity
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.4/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType671);
                    this_Entity=ruleEntity();
                    _fsp--;

                     
                            current = this_Entity; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:298:5: this_DataType= ruleDataType
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.4/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataType_in_ruleType698);
                    this_DataType=ruleDataType();
                    _fsp--;

                     
                            current = this_DataType; 
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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleDataType
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:313:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:313:50: (iv_ruleDataType= ruleDataType EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:314:2: iv_ruleDataType= ruleDataType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType730);
            iv_ruleDataType=ruleDataType();
            _fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType740); 

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
    // $ANTLR end entryRuleDataType


    // $ANTLR start ruleDataType
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:321:1: ruleDataType returns [EObject current=null] : ( 'datatype' (lv_name= RULE_ID ) ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:323:33: ( ( 'datatype' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:324:1: ( 'datatype' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:324:1: ( 'datatype' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:324:2: 'datatype' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleDataType774); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.5/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:328:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:330:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType795); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("DataType");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
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
    // $ANTLR end ruleDataType


    // $ANTLR start entryRuleEntity
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:355:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:355:48: (iv_ruleEntity= ruleEntity EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:356:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity839);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity849); 

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
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:363:1: ruleEntity returns [EObject current=null] : ( ( ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )* ) '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_features = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:365:33: ( ( ( ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:1: ( ( ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:1: ( ( ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )* ) '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:2: ( ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:2: ( ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )* )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:3: ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' ) (lv_features= ruleFeature )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:3: ( ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:4: ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? ) '{'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:4: ( ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:5: ( 'entity' (lv_name= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:5: ( 'entity' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:366:6: 'entity' (lv_name= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleEntity887); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:370:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:372:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity908); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Entity");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:390:3: ( 'extends' ( ( RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:390:4: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleEntity930); 

                            createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:394:1: ( ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:397:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("Entity");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:403:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:404:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity954); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "superType"); 
                        

                    }


                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEntity970); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:413:2: (lv_features= ruleFeature )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==20||LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:416:6: lv_features= ruleFeature
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeature_in_ruleEntity1005);
            	    lv_features=ruleFeature();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Entity");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "features", lv_features, "Feature", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleEntity1020); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleFeature
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:445:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:445:49: (iv_ruleFeature= ruleFeature EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:446:2: iv_ruleFeature= ruleFeature EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature1053);
            iv_ruleFeature=ruleFeature();
            _fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature1063); 

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
    // $ANTLR end entryRuleFeature


    // $ANTLR start ruleFeature
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:453:1: ruleFeature returns [EObject current=null] : (this_StructuralFeature= ruleStructuralFeature | this_Operation= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_StructuralFeature = null;

        EObject this_Operation = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:455:33: ( (this_StructuralFeature= ruleStructuralFeature | this_Operation= ruleOperation ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:456:1: (this_StructuralFeature= ruleStructuralFeature | this_Operation= ruleOperation )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:456:1: (this_StructuralFeature= ruleStructuralFeature | this_Operation= ruleOperation )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("456:1: (this_StructuralFeature= ruleStructuralFeature | this_Operation= ruleOperation )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:457:5: this_StructuralFeature= ruleStructuralFeature
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.7/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleStructuralFeature_in_ruleFeature1110);
                    this_StructuralFeature=ruleStructuralFeature();
                    _fsp--;

                     
                            current = this_StructuralFeature; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:467:5: this_Operation= ruleOperation
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.7/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperation_in_ruleFeature1137);
                    this_Operation=ruleOperation();
                    _fsp--;

                     
                            current = this_Operation; 
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
    // $ANTLR end ruleFeature


    // $ANTLR start entryRuleStructuralFeature
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:482:1: entryRuleStructuralFeature returns [EObject current=null] : iv_ruleStructuralFeature= ruleStructuralFeature EOF ;
    public final EObject entryRuleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuralFeature = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:482:59: (iv_ruleStructuralFeature= ruleStructuralFeature EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:483:2: iv_ruleStructuralFeature= ruleStructuralFeature EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1169);
            iv_ruleStructuralFeature=ruleStructuralFeature();
            _fsp--;

             current =iv_ruleStructuralFeature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructuralFeature1179); 

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
    // $ANTLR end entryRuleStructuralFeature


    // $ANTLR start ruleStructuralFeature
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:490:1: ruleStructuralFeature returns [EObject current=null] : (this_Attribute= ruleAttribute | this_Reference= ruleReference ) ;
    public final EObject ruleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute = null;

        EObject this_Reference = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:492:33: ( (this_Attribute= ruleAttribute | this_Reference= ruleReference ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:493:1: (this_Attribute= ruleAttribute | this_Reference= ruleReference )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:493:1: (this_Attribute= ruleAttribute | this_Reference= ruleReference )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("493:1: (this_Attribute= ruleAttribute | this_Reference= ruleReference )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:494:5: this_Attribute= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.8/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleStructuralFeature1226);
                    this_Attribute=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:504:5: this_Reference= ruleReference
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.8/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleStructuralFeature1253);
                    this_Reference=ruleReference();
                    _fsp--;

                     
                            current = this_Reference; 
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
    // $ANTLR end ruleStructuralFeature


    // $ANTLR start entryRuleAttribute
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:519:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:519:51: (iv_ruleAttribute= ruleAttribute EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:520:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1285);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1295); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:527:1: ruleAttribute returns [EObject current=null] : ( ( ( 'attr' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:529:33: ( ( ( ( 'attr' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:1: ( ( ( 'attr' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:1: ( ( ( 'attr' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:2: ( ( 'attr' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:2: ( ( 'attr' (lv_name= RULE_ID ) ) ':' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:3: ( 'attr' (lv_name= RULE_ID ) ) ':'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:3: ( 'attr' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:530:4: 'attr' (lv_name= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleAttribute1331); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:534:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:536:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1352); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Attribute");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleAttribute1373); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:558:2: (lv_type= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:561:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAttribute1408);
            lv_type=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Attribute");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleReference
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:586:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:586:51: (iv_ruleReference= ruleReference EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:587:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1445);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1455); 

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
    // $ANTLR end entryRuleReference


    // $ANTLR start ruleReference
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:594:1: ruleReference returns [EObject current=null] : ( ( ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:596:33: ( ( ( ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:1: ( ( ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:1: ( ( ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:2: ( ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:2: ( ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:3: ( ( 'ref' (lv_name= RULE_ID ) ) ':' ) (lv_type= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:3: ( ( 'ref' (lv_name= RULE_ID ) ) ':' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:4: ( 'ref' (lv_name= RULE_ID ) ) ':'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:4: ( 'ref' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:597:5: 'ref' (lv_name= RULE_ID )
            {
            match(input,20,FOLLOW_20_in_ruleReference1492); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:601:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:603:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1513); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Reference");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleReference1534); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:625:2: (lv_type= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:628:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleReference1569);
            lv_type=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Reference");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:646:3: ( 'opposite' ( ( RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:646:4: 'opposite' ( ( RULE_ID ) )
                    {
                    match(input,21,FOLLOW_21_in_ruleReference1584); 

                            createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:650:1: ( ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:653:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("Reference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:659:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:660:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1608); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "opposite"); 
                        

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
    // $ANTLR end ruleReference


    // $ANTLR start entryRuleOperation
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:672:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:672:51: (iv_ruleOperation= ruleOperation EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:673:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation1647);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1657); 

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
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:680:1: ruleOperation returns [EObject current=null] : ( ( ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type= ruleTypeRef ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_params = null;

        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:682:33: ( ( ( ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type= ruleTypeRef ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:1: ( ( ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type= ruleTypeRef ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:1: ( ( ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:2: ( ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:2: ( ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:3: ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' ) ':'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:3: ( ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:4: ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? ) ')'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:4: ( ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )? )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:5: ( ( 'op' (lv_name= RULE_ID ) ) '(' ) ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:5: ( ( 'op' (lv_name= RULE_ID ) ) '(' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:6: ( 'op' (lv_name= RULE_ID ) ) '('
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:6: ( 'op' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:683:7: 'op' (lv_name= RULE_ID )
            {
            match(input,22,FOLLOW_22_in_ruleOperation1696); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:687:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:689:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation1717); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Operation");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,23,FOLLOW_23_in_ruleOperation1738); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:711:2: ( (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:711:3: (lv_params= ruleParameter ) ( ',' (lv_params= ruleParameter ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:711:3: (lv_params= ruleParameter )
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:714:6: lv_params= ruleParameter
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1774);
                    lv_params=ruleParameter();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Operation");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "params", lv_params, "Parameter", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:732:2: ( ',' (lv_params= ruleParameter ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==24) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:732:3: ',' (lv_params= ruleParameter )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleOperation1788); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:736:1: (lv_params= ruleParameter )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:739:6: lv_params= ruleParameter
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1822);
                    	    lv_params=ruleParameter();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("Operation");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "params", lv_params, "Parameter", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleOperation1840); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleOperation1850); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:765:2: (lv_type= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:768:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleOperation1885);
            lv_type=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Operation");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleParameter
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:793:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:793:51: (iv_ruleParameter= ruleParameter EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:794:2: iv_ruleParameter= ruleParameter EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1922);
            iv_ruleParameter=ruleParameter();
            _fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1932); 

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
    // $ANTLR end entryRuleParameter


    // $ANTLR start ruleParameter
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:801:1: ruleParameter returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_type= ruleTypeRef ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:803:33: ( ( (lv_name= RULE_ID ) (lv_type= ruleTypeRef ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:804:1: ( (lv_name= RULE_ID ) (lv_type= ruleTypeRef ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:804:1: ( (lv_name= RULE_ID ) (lv_type= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:804:2: (lv_name= RULE_ID ) (lv_type= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:804:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:806:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1978); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.12/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Parameter");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:824:2: (lv_type= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:827:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.12/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleParameter2023);
            lv_type=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Parameter");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleParameter


    // $ANTLR start entryRuleTypeRef
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:854:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:854:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:855:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef2062);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef2072); 

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:862:1: ruleTypeRef returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:864:33: ( ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:865:1: ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:865:1: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:868:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("TypeRef");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:874:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:875:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2120); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.14/@alternatives/@terminal" /* xtext::CrossReference */, "referenced"); 
                

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
    // $ANTLR end ruleTypeRef


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile140 = new BitSet(new long[]{0x0000000000019802L});
    public static final BitSet FOLLOW_ruleNamedElement_in_ruleFile179 = new BitSet(new long[]{0x0000000000019002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackage_in_ruleNamedElement383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleNamedElement410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackage_in_entryRulePackage442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackage452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackage489 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePackage510 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackage531 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_ruleNamedElement_in_rulePackage566 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_14_in_rulePackage581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleType698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDataType774 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity887 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity908 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleEntity930 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity954 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity970 = new BitSet(new long[]{0x0000000000544000L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleEntity1005 = new BitSet(new long[]{0x0000000000544000L});
    public static final BitSet FOLLOW_14_in_ruleEntity1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_ruleFeature1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleFeature1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeature1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleStructuralFeature1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_ruleStructuralFeature1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1331 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1352 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1373 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAttribute1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReference1492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1513 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReference1534 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleReference1569 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleReference1584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation1647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOperation1696 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation1717 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOperation1738 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1774 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleOperation1788 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1822 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleOperation1840 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOperation1850 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleOperation1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1978 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParameter2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2120 = new BitSet(new long[]{0x0000000000000002L});

}
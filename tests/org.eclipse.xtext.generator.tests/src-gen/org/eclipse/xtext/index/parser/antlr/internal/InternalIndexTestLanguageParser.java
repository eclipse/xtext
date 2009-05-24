package org.eclipse.xtext.index.parser.antlr.internal; 

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
import org.eclipse.xtext.index.services.IndexTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalIndexTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'.'", "'{'", "'}'", "'entity'", "'datatype'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalIndexTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g"; }


     
     	private IndexTestLanguageGrammarAccess grammarAccess;
     	
        public InternalIndexTestLanguageParser(TokenStream input, IAstFactory factory, IndexTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:70:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:70:46: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:71:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileRule(), currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile73);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:78:1: ruleFile returns [EObject current=null] : ( (lv_imports_0= ruleImport )* (lv_nameSpaces_1= ruleNamespace )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_nameSpaces_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:83:6: ( ( (lv_imports_0= ruleImport )* (lv_nameSpaces_1= ruleNamespace )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:84:1: ( (lv_imports_0= ruleImport )* (lv_nameSpaces_1= ruleNamespace )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:84:1: ( (lv_imports_0= ruleImport )* (lv_nameSpaces_1= ruleNamespace )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:84:2: (lv_imports_0= ruleImport )* (lv_nameSpaces_1= ruleNamespace )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:84:2: (lv_imports_0= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:87:6: lv_imports_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleFile142);
            	    lv_imports_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "imports", lv_imports_0, "Import", currentNode);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:105:3: (lv_nameSpaces_1= ruleNamespace )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:108:6: lv_nameSpaces_1= ruleNamespace
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getNameSpacesNamespaceParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamespace_in_ruleFile181);
            	    lv_nameSpaces_1=ruleNamespace();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "nameSpaces", lv_nameSpaces_1, "Namespace", currentNode);
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:133:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:133:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:134:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport219);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport229); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:141:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importedNamespace_1= ruleQualifiedName ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:146:6: ( ( 'import' (lv_importedNamespace_1= ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:147:1: ( 'import' (lv_importedNamespace_1= ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:147:1: ( 'import' (lv_importedNamespace_1= ruleQualifiedName ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:147:2: 'import' (lv_importedNamespace_1= ruleQualifiedName )
            {
            match(input,11,FOLLOW_11_in_ruleImport263); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:151:1: (lv_importedNamespace_1= ruleQualifiedName )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:154:6: lv_importedNamespace_1= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleImport297);
            lv_importedNamespace_1=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "importedNamespace", lv_importedNamespace_1, "QualifiedName", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:179:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:179:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:180:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName335);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName346); 

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:187:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:193:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:194:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:194:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:194:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName386); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:201:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:202:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,12,FOLLOW_12_in_ruleQualifiedName405); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName420); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleNamespace
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:222:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:222:51: (iv_ruleNamespace= ruleNamespace EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:223:2: iv_ruleNamespace= ruleNamespace EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace465);
            iv_ruleNamespace=ruleNamespace();
            _fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace475); 

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
    // $ANTLR end entryRuleNamespace


    // $ANTLR start ruleNamespace
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:230:1: ruleNamespace returns [EObject current=null] : ( (lv_name_0= ruleQualifiedName ) '{' (lv_namedElements_2= ruleNamedElement )* '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0 = null;

        EObject lv_namedElements_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:235:6: ( ( (lv_name_0= ruleQualifiedName ) '{' (lv_namedElements_2= ruleNamedElement )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:236:1: ( (lv_name_0= ruleQualifiedName ) '{' (lv_namedElements_2= ruleNamedElement )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:236:1: ( (lv_name_0= ruleQualifiedName ) '{' (lv_namedElements_2= ruleNamedElement )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:236:2: (lv_name_0= ruleQualifiedName ) '{' (lv_namedElements_2= ruleNamedElement )* '}'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:236:2: (lv_name_0= ruleQualifiedName )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:239:6: lv_name_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamespace534);
            lv_name_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "QualifiedName", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,13,FOLLOW_13_in_ruleNamespace547); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:261:1: (lv_namedElements_2= ruleNamedElement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||(LA4_0>=15 && LA4_0<=16)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:264:6: lv_namedElements_2= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getNamedElementsNamedElementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_ruleNamespace581);
            	    lv_namedElements_2=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "namedElements", lv_namedElements_2, "NamedElement", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleNamespace595); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleNamespace


    // $ANTLR start entryRuleNamedElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:293:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:293:54: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:294:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedElement_in_entryRuleNamedElement628);
            iv_ruleNamedElement=ruleNamedElement();
            _fsp--;

             current =iv_ruleNamedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedElement638); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:301:1: ruleNamedElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Type_1= ruleType ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:306:6: ( (this_Namespace_0= ruleNamespace | this_Type_1= ruleType ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:307:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:307:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=15 && LA5_0<=16)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("307:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:308:5: this_Namespace_0= ruleNamespace
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamespace_in_ruleNamedElement685);
                    this_Namespace_0=ruleNamespace();
                    _fsp--;

                     
                            current = this_Namespace_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:318:5: this_Type_1= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getTypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleNamedElement712);
                    this_Type_1=ruleType();
                    _fsp--;

                     
                            current = this_Type_1; 
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
    // $ANTLR end ruleNamedElement


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:333:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:333:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:334:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType744);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType754); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:341:1: ruleType returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Datatype_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:346:6: ( (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:347:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:347:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("347:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:348:5: this_Entity_0= ruleEntity
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType801);
                    this_Entity_0=ruleEntity();
                    _fsp--;

                     
                            current = this_Entity_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:358:5: this_Datatype_1= ruleDatatype
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatype_in_ruleType828);
                    this_Datatype_1=ruleDatatype();
                    _fsp--;

                     
                            current = this_Datatype_1; 
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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:373:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:373:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:374:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity860);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity870); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:381:1: ruleEntity returns [EObject current=null] : ( 'entity' (lv_name_1= RULE_ID ) '{' (lv_properties_3= ruleProperty )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_properties_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:386:6: ( ( 'entity' (lv_name_1= RULE_ID ) '{' (lv_properties_3= ruleProperty )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:387:1: ( 'entity' (lv_name_1= RULE_ID ) '{' (lv_properties_3= ruleProperty )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:387:1: ( 'entity' (lv_name_1= RULE_ID ) '{' (lv_properties_3= ruleProperty )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:387:2: 'entity' (lv_name_1= RULE_ID ) '{' (lv_properties_3= ruleProperty )* '}'
            {
            match(input,15,FOLLOW_15_in_ruleEntity904); 

                    createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:391:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:393:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity926); 

            		createLeafNode(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,13,FOLLOW_13_in_ruleEntity943); 

                    createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:415:1: (lv_properties_3= ruleProperty )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:418:6: lv_properties_3= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity977);
            	    lv_properties_3=ruleProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "properties", lv_properties_3, "Property", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleEntity991); 

                    createLeafNode(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:447:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:447:50: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:448:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype1024);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype1034); 

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
    // $ANTLR end entryRuleDatatype


    // $ANTLR start ruleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:455:1: ruleDatatype returns [EObject current=null] : ( 'datatype' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:460:6: ( ( 'datatype' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:461:1: ( 'datatype' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:461:1: ( 'datatype' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:461:2: 'datatype' (lv_name_1= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleDatatype1068); 

                    createLeafNode(grammarAccess.getDatatypeAccess().getDatatypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:465:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:467:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype1090); 

            		createLeafNode(grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:492:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:492:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:493:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty1131);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty1141); 

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
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:500:1: ruleProperty returns [EObject current=null] : ( ( RULE_ID ) (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:505:6: ( ( ( RULE_ID ) (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:506:1: ( ( RULE_ID ) (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:506:1: ( ( RULE_ID ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:506:2: ( RULE_ID ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:506:2: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:509:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty1188); 

            		createLeafNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), "type"); 
            	

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:522:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:524:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty1213); 

            		createLeafNode(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleProperty


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile142 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleFile181 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleImport297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName386 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedName405 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName420 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace534 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamespace547 = new BitSet(new long[]{0x000000000001C010L});
    public static final BitSet FOLLOW_ruleNamedElement_in_ruleNamespace581 = new BitSet(new long[]{0x000000000001C010L});
    public static final BitSet FOLLOW_14_in_ruleNamespace595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleNamedElement685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleNamedElement712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleType828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEntity904 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity926 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity943 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity977 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleEntity991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype1024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDatatype1068 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty1131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty1188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty1213 = new BitSet(new long[]{0x0000000000000002L});

}
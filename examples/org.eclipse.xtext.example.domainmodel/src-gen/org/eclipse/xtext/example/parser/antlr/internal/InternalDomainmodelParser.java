package org.eclipse.xtext.example.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDomainmodelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'{'", "'}'", "'datatype'", "'entity'", "'extends'", "'attr'", "':'", "'ref'", "'opposite'", "'op'", "'('", "','", "')'", "'.'", "'#'", "'-'", "'!'", "'+'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDomainmodelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g"; }


     
     	private DomainmodelGrammarAccess grammarAccess;
     	
        public InternalDomainmodelParser(TokenStream input, IAstFactory factory, DomainmodelGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:71:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:71:46: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:72:2: iv_ruleFile= ruleFile EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:79:1: ruleFile returns [EObject current=null] : ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_namedElements_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:84:6: ( ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:85:1: ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:85:1: ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:85:2: (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:85:2: (lv_imports_0= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:88:6: lv_imports_0= ruleImport
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:106:3: (lv_namedElements_1= ruleNamedElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||(LA2_0>=15 && LA2_0<=16)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:109:6: lv_namedElements_1= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getNamedElementsNamedElementParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_ruleFile181);
            	    lv_namedElements_1=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "namedElements", lv_namedElements_1, "NamedElement", currentNode);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:134:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:134:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:135:2: iv_ruleImport= ruleImport EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:142:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI_1= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:147:6: ( ( 'import' (lv_importURI_1= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:148:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:148:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:148:2: 'import' (lv_importURI_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport263); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:152:1: (lv_importURI_1= RULE_STRING )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:154:6: lv_importURI_1= RULE_STRING
            {
            lv_importURI_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport285); 

            		createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "importURI", lv_importURI_1, "STRING", lastConsumedNode);
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


    // $ANTLR start entryRuleNamedElement
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:179:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:179:54: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:180:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedElementRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:187:1: ruleNamedElement returns [EObject current=null] : (this_Package_0= rulePackage | this_Type_1= ruleType ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Package_0 = null;

        EObject this_Type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:192:6: ( (this_Package_0= rulePackage | this_Type_1= ruleType ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:193:1: (this_Package_0= rulePackage | this_Type_1= ruleType )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:193:1: (this_Package_0= rulePackage | this_Type_1= ruleType )
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
                    new NoViableAltException("193:1: (this_Package_0= rulePackage | this_Type_1= ruleType )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:194:5: this_Package_0= rulePackage
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getPackageParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePackage_in_ruleNamedElement383);
                    this_Package_0=rulePackage();
                    _fsp--;

                     
                            current = this_Package_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:204:5: this_Type_1= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getTypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleNamedElement410);
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


    // $ANTLR start entryRulePackage
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:219:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:219:49: (iv_rulePackage= rulePackage EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:220:2: iv_rulePackage= rulePackage EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:227:1: rulePackage returns [EObject current=null] : ( 'package' (lv_name_1= ruleQualifiedName ) '{' (lv_namedElements_3= ruleNamedElement )* '}' ) ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1 = null;

        EObject lv_namedElements_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:232:6: ( ( 'package' (lv_name_1= ruleQualifiedName ) '{' (lv_namedElements_3= ruleNamedElement )* '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:233:1: ( 'package' (lv_name_1= ruleQualifiedName ) '{' (lv_namedElements_3= ruleNamedElement )* '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:233:1: ( 'package' (lv_name_1= ruleQualifiedName ) '{' (lv_namedElements_3= ruleNamedElement )* '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:233:2: 'package' (lv_name_1= ruleQualifiedName ) '{' (lv_namedElements_3= ruleNamedElement )* '}'
            {
            match(input,12,FOLLOW_12_in_rulePackage486); 

                    createLeafNode(grammarAccess.getPackageAccess().getPackageKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:1: (lv_name_1= ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:240:6: lv_name_1= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPackageAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackage520);
            lv_name_1=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPackageRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "QualifiedName", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,13,FOLLOW_13_in_rulePackage533); 

                    createLeafNode(grammarAccess.getPackageAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:262:1: (lv_namedElements_3= ruleNamedElement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12||(LA4_0>=15 && LA4_0<=16)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:265:6: lv_namedElements_3= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPackageAccess().getNamedElementsNamedElementParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_rulePackage567);
            	    lv_namedElements_3=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPackageRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "namedElements", lv_namedElements_3, "NamedElement", currentNode);
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

            match(input,14,FOLLOW_14_in_rulePackage581); 

                    createLeafNode(grammarAccess.getPackageAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end rulePackage


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:294:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:294:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:295:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:302:1: ruleType returns [EObject current=null] : (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_DataType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:307:6: ( (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:308:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:308:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )
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
                    new NoViableAltException("308:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:309:5: this_Entity_0= ruleEntity
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType671);
                    this_Entity_0=ruleEntity();
                    _fsp--;

                     
                            current = this_Entity_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:319:5: this_DataType_1= ruleDataType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataType_in_ruleType698);
                    this_DataType_1=ruleDataType();
                    _fsp--;

                     
                            current = this_DataType_1; 
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


    // $ANTLR start entryRuleDataType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:334:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:334:50: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:335:2: iv_ruleDataType= ruleDataType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:342:1: ruleDataType returns [EObject current=null] : ( 'datatype' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:347:6: ( ( 'datatype' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:348:1: ( 'datatype' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:348:1: ( 'datatype' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:348:2: 'datatype' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleDataType774); 

                    createLeafNode(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:352:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:354:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType796); 

            		createLeafNode(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDataTypeRule().getType().getClassifier());
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
    // $ANTLR end ruleDataType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:379:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:379:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:380:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity837);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity847); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:387:1: ruleEntity returns [EObject current=null] : ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_features_5= ruleFeature )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_features_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:392:6: ( ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_features_5= ruleFeature )* '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:393:1: ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_features_5= ruleFeature )* '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:393:1: ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_features_5= ruleFeature )* '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:393:2: 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_features_5= ruleFeature )* '}'
            {
            match(input,16,FOLLOW_16_in_ruleEntity881); 

                    createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:397:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:399:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity903); 

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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:417:2: ( 'extends' ( RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:417:3: 'extends' ( RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleEntity921); 

                            createLeafNode(grammarAccess.getEntityAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:421:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:424:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity943); 

                    		createLeafNode(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0(), "superType"); 
                    	

                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleEntity957); 

                    createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:441:1: (lv_features_5= ruleFeature )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==20||LA7_0==22||(LA7_0>=27 && LA7_0<=30)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:444:6: lv_features_5= ruleFeature
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeature_in_ruleEntity991);
            	    lv_features_5=ruleFeature();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "features", lv_features_5, "Feature", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleEntity1005); 

                    createLeafNode(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5(), null); 
                

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


    // $ANTLR start entryRuleFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:473:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:473:49: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:474:2: iv_ruleFeature= ruleFeature EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature1038);
            iv_ruleFeature=ruleFeature();
            _fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature1048); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:481:1: ruleFeature returns [EObject current=null] : (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_StructuralFeature_0 = null;

        EObject this_Operation_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:486:6: ( (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:487:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:487:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==22||(LA8_0>=27 && LA8_0<=30)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("487:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:488:5: this_StructuralFeature_0= ruleStructuralFeature
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getStructuralFeatureParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStructuralFeature_in_ruleFeature1095);
                    this_StructuralFeature_0=ruleStructuralFeature();
                    _fsp--;

                     
                            current = this_StructuralFeature_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:498:5: this_Operation_1= ruleOperation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getOperationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperation_in_ruleFeature1122);
                    this_Operation_1=ruleOperation();
                    _fsp--;

                     
                            current = this_Operation_1; 
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
    // $ANTLR end ruleFeature


    // $ANTLR start entryRuleStructuralFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:513:1: entryRuleStructuralFeature returns [EObject current=null] : iv_ruleStructuralFeature= ruleStructuralFeature EOF ;
    public final EObject entryRuleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuralFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:513:59: (iv_ruleStructuralFeature= ruleStructuralFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:514:2: iv_ruleStructuralFeature= ruleStructuralFeature EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStructuralFeatureRule(), currentNode); 
            pushFollow(FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1154);
            iv_ruleStructuralFeature=ruleStructuralFeature();
            _fsp--;

             current =iv_ruleStructuralFeature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructuralFeature1164); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:521:1: ruleStructuralFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:526:6: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:527:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:527:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
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
                    new NoViableAltException("527:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:528:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStructuralFeatureAccess().getAttributeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleStructuralFeature1211);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:538:5: this_Reference_1= ruleReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStructuralFeatureAccess().getReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleStructuralFeature1238);
                    this_Reference_1=ruleReference();
                    _fsp--;

                     
                            current = this_Reference_1; 
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
    // $ANTLR end ruleStructuralFeature


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:553:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:553:51: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:554:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1270);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1280); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:561:1: ruleAttribute returns [EObject current=null] : ( 'attr' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:566:6: ( ( 'attr' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:567:1: ( 'attr' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:567:1: ( 'attr' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:567:2: 'attr' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef )
            {
            match(input,18,FOLLOW_18_in_ruleAttribute1314); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttrKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:571:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:573:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1336); 

            		createLeafNode(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,19,FOLLOW_19_in_ruleAttribute1353); 

                    createLeafNode(grammarAccess.getAttributeAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:595:1: (lv_type_3= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:598:6: lv_type_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeRefParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAttribute1387);
            lv_type_3=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_3, "TypeRef", currentNode);
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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:623:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:623:51: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:624:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1424);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1434); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:631:1: ruleReference returns [EObject current=null] : ( 'ref' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ( 'opposite' ( RULE_ID ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:636:6: ( ( 'ref' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ( 'opposite' ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:637:1: ( 'ref' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ( 'opposite' ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:637:1: ( 'ref' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ( 'opposite' ( RULE_ID ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:637:2: 'ref' (lv_name_1= RULE_ID ) ':' (lv_type_3= ruleTypeRef ) ( 'opposite' ( RULE_ID ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReference1468); 

                    createLeafNode(grammarAccess.getReferenceAccess().getRefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:641:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:643:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1490); 

            		createLeafNode(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,19,FOLLOW_19_in_ruleReference1507); 

                    createLeafNode(grammarAccess.getReferenceAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:665:1: (lv_type_3= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:668:6: lv_type_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReferenceAccess().getTypeTypeRefParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleReference1541);
            lv_type_3=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_3, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:686:2: ( 'opposite' ( RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:686:3: 'opposite' ( RULE_ID )
                    {
                    match(input,21,FOLLOW_21_in_ruleReference1555); 

                            createLeafNode(grammarAccess.getReferenceAccess().getOppositeKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:690:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:693:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1577); 

                    		createLeafNode(grammarAccess.getReferenceAccess().getOppositeReferenceCrossReference_4_1_0(), "opposite"); 
                    	

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
    // $ANTLR end ruleReference


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:713:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:713:51: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:714:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation1615);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1625); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:721:1: ruleOperation returns [EObject current=null] : ( (lv_visibility_0= ruleVisibility )? 'op' (lv_name_2= RULE_ID ) '(' ( (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )* )? ')' ':' (lv_type_9= ruleTypeRef ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Enumerator lv_visibility_0 = null;

        EObject lv_params_4 = null;

        EObject lv_params_6 = null;

        EObject lv_type_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:726:6: ( ( (lv_visibility_0= ruleVisibility )? 'op' (lv_name_2= RULE_ID ) '(' ( (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )* )? ')' ':' (lv_type_9= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:727:1: ( (lv_visibility_0= ruleVisibility )? 'op' (lv_name_2= RULE_ID ) '(' ( (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )* )? ')' ':' (lv_type_9= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:727:1: ( (lv_visibility_0= ruleVisibility )? 'op' (lv_name_2= RULE_ID ) '(' ( (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )* )? ')' ':' (lv_type_9= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:727:2: (lv_visibility_0= ruleVisibility )? 'op' (lv_name_2= RULE_ID ) '(' ( (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )* )? ')' ':' (lv_type_9= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:727:2: (lv_visibility_0= ruleVisibility )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=27 && LA11_0<=30)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:730:6: lv_visibility_0= ruleVisibility
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVisibility_in_ruleOperation1684);
                    lv_visibility_0=ruleVisibility();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "visibility", lv_visibility_0, "Visibility", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleOperation1698); 

                    createLeafNode(grammarAccess.getOperationAccess().getOpKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:752:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:754:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation1720); 

            		createLeafNode(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,23,FOLLOW_23_in_ruleOperation1737); 

                    createLeafNode(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:776:1: ( (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:776:2: (lv_params_4= ruleParameter ) ( ',' (lv_params_6= ruleParameter ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:776:2: (lv_params_4= ruleParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:779:6: lv_params_4= ruleParameter
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1772);
                    lv_params_4=ruleParameter();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "params", lv_params_4, "Parameter", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:797:2: ( ',' (lv_params_6= ruleParameter ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==24) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:797:3: ',' (lv_params_6= ruleParameter )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleOperation1786); 

                    	            createLeafNode(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:801:1: (lv_params_6= ruleParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:804:6: lv_params_6= ruleParameter
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1820);
                    	    lv_params_6=ruleParameter();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "params", lv_params_6, "Parameter", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_ruleOperation1837); 

                    createLeafNode(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5(), null); 
                
            match(input,19,FOLLOW_19_in_ruleOperation1846); 

                    createLeafNode(grammarAccess.getOperationAccess().getColonKeyword_6(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:830:1: (lv_type_9= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:833:6: lv_type_9= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getTypeTypeRefParserRuleCall_7_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleOperation1880);
            lv_type_9=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_9, "TypeRef", currentNode);
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
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleParameter
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:858:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:858:51: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:859:2: iv_ruleParameter= ruleParameter EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1917);
            iv_ruleParameter=ruleParameter();
            _fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1927); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:866:1: ruleParameter returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:871:6: ( ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:872:1: ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:872:1: ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:872:2: (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:872:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:874:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1974); 

            		createLeafNode(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:892:2: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:895:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleParameter2016);
            lv_type_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_1, "TypeRef", currentNode);
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
    // $ANTLR end ruleParameter


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:922:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:922:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:923:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef2055);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef2065); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:930:1: ruleTypeRef returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:935:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:936:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:936:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:939:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2111); 

            		createLeafNode(grammarAccess.getTypeRefAccess().getReferencedTypeCrossReference_0(), "referenced"); 
            	

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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:959:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:959:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:960:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2147);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2158); 

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:967:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:973:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:974:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:974:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:974:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2198); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:981:1: (kw= '.' this_ID_2= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:982:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,26,FOLLOW_26_in_ruleQualifiedName2217); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2232); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
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


    // $ANTLR start ruleVisibility
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1002:1: ruleVisibility returns [Enumerator current=null] : ( ( '#' ) | ( '-' ) | ( '!' ) | ( '+' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1006:6: ( ( ( '#' ) | ( '-' ) | ( '!' ) | ( '+' ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1007:1: ( ( '#' ) | ( '-' ) | ( '!' ) | ( '+' ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1007:1: ( ( '#' ) | ( '-' ) | ( '!' ) | ( '+' ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt15=1;
                }
                break;
            case 28:
                {
                alt15=2;
                }
                break;
            case 29:
                {
                alt15=3;
                }
                break;
            case 30:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1007:1: ( ( '#' ) | ( '-' ) | ( '!' ) | ( '+' ) )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1007:2: ( '#' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1007:2: ( '#' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1007:4: '#'
                    {
                    match(input,27,FOLLOW_27_in_ruleVisibility2291); 

                            current = grammarAccess.getVisibilityAccess().getPackageEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPackageEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1013:6: ( '-' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1013:6: ( '-' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1013:8: '-'
                    {
                    match(input,28,FOLLOW_28_in_ruleVisibility2306); 

                            current = grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1019:6: ( '!' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1019:6: ( '!' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1019:8: '!'
                    {
                    match(input,29,FOLLOW_29_in_ruleVisibility2321); 

                            current = grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1025:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1025:6: ( '+' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1025:8: '+'
                    {
                    match(input,30,FOLLOW_30_in_ruleVisibility2336); 

                            current = grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end ruleVisibility


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile142 = new BitSet(new long[]{0x0000000000019802L});
    public static final BitSet FOLLOW_ruleNamedElement_in_ruleFile181 = new BitSet(new long[]{0x0000000000019002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackage_in_ruleNamedElement383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleNamedElement410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackage_in_entryRulePackage442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackage452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackage486 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackage520 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackage533 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_ruleNamedElement_in_rulePackage567 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_14_in_rulePackage581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleType698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDataType774 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity881 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity903 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleEntity921 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity943 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity957 = new BitSet(new long[]{0x0000000078544000L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleEntity991 = new BitSet(new long[]{0x0000000078544000L});
    public static final BitSet FOLLOW_14_in_ruleEntity1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_ruleFeature1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleFeature1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeature1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleStructuralFeature1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_ruleStructuralFeature1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1314 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1336 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1353 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAttribute1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReference1468 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1490 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReference1507 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleReference1541 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleReference1555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation1615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibility_in_ruleOperation1684 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOperation1698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation1720 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOperation1737 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1772 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleOperation1786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1820 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleOperation1837 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOperation1846 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleOperation1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1974 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParameter2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2055 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2198 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleQualifiedName2217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2232 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_27_in_ruleVisibility2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVisibility2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVisibility2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVisibility2336 = new BitSet(new long[]{0x0000000000000002L});

}
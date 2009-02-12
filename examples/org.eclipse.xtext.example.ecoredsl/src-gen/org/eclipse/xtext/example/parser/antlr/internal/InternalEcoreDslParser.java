package org.eclipse.xtext.example.parser.antlr.internal; 

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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEcoreDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'='", "';'", "'package'", "'nsURI'", "'nsPrefix'", "'{'", "'}'", "'!serializable'", "'datatype'", "':'", "'@'", "'('", "','", "')'", "'abstract'", "'interface'", "'class'", "'<'", "'>'", "'extends'", "'ID'", "'bag'", "'random'", "'readonly'", "'volatile'", "'transient'", "'unsettable'", "'derived'", "'attr'", "'['", "'..'", "']'", "'local'", "'val'", "'ref'", "'#'", "'enum'", "'?'", "'super'", "'op'", "'void'", "'throws'", "'.'", "'$'", "'-'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEcoreDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g"; }


     
     	private EcoreDslGrammarAccess grammarAccess;
     	
        public InternalEcoreDslParser(TokenStream input, IAstFactory factory, EcoreDslGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalEcoreDslParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EcoreDsl";	
       	} 



    // $ANTLR start entryRuleEcoreDsl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:70:1: entryRuleEcoreDsl returns [EObject current=null] : iv_ruleEcoreDsl= ruleEcoreDsl EOF ;
    public final EObject entryRuleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEcoreDsl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:70:50: (iv_ruleEcoreDsl= ruleEcoreDsl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:71:2: iv_ruleEcoreDsl= ruleEcoreDsl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEcoreDsl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl72);
            iv_ruleEcoreDsl=ruleEcoreDsl();
            _fsp--;

             current =iv_ruleEcoreDsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEcoreDsl82); 

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
    // $ANTLR end entryRuleEcoreDsl


    // $ANTLR start ruleEcoreDsl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:78:1: ruleEcoreDsl returns [EObject current=null] : ( (lv_imports= ruleImportStatementDecl )* (lv_package= ruleEPackageDecl ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_imports = null;

        EObject lv_package = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:82:6: ( ( (lv_imports= ruleImportStatementDecl )* (lv_package= ruleEPackageDecl ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:1: ( (lv_imports= ruleImportStatementDecl )* (lv_package= ruleEPackageDecl ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:1: ( (lv_imports= ruleImportStatementDecl )* (lv_package= ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:2: (lv_imports= ruleImportStatementDecl )* (lv_package= ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:2: (lv_imports= ruleImportStatementDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:6: lv_imports= ruleImportStatementDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele00ParserRuleCallImportStatementDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImportStatementDecl_in_ruleEcoreDsl141);
            	    lv_imports=ruleImportStatementDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EcoreDsl");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "imports", lv_imports, "ImportStatementDecl", currentNode);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:104:3: (lv_package= ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:107:6: lv_package= ruleEPackageDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele10ParserRuleCallEPackageDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl180);
            lv_package=ruleEPackageDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EcoreDsl");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "package", lv_package, "EPackageDecl", currentNode);
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
    // $ANTLR end ruleEcoreDsl


    // $ANTLR start entryRuleImportStatementDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:134:1: entryRuleImportStatementDecl returns [EObject current=null] : iv_ruleImportStatementDecl= ruleImportStatementDecl EOF ;
    public final EObject entryRuleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatementDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:134:61: (iv_ruleImportStatementDecl= ruleImportStatementDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:2: iv_ruleImportStatementDecl= ruleImportStatementDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImportStatementDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImportStatementDecl_in_entryRuleImportStatementDecl219);
            iv_ruleImportStatementDecl=ruleImportStatementDecl();
            _fsp--;

             current =iv_ruleImportStatementDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportStatementDecl229); 

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
    // $ANTLR end entryRuleImportStatementDecl


    // $ANTLR start ruleImportStatementDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:142:1: ruleImportStatementDecl returns [EObject current=null] : ( ( ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING ) ) ';' ) ;
    public final EObject ruleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_importURI=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:146:6: ( ( ( ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:1: ( ( ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:1: ( ( ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:2: ( ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:2: ( ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:3: ( 'import' ( (lv_alias= RULE_ID ) '=' )? ) (lv_importURI= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:3: ( 'import' ( (lv_alias= RULE_ID ) '=' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:147:4: 'import' ( (lv_alias= RULE_ID ) '=' )?
            {
            match(input,11,FOLLOW_11_in_ruleImportStatementDecl265); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:151:1: ( (lv_alias= RULE_ID ) '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:151:2: (lv_alias= RULE_ID ) '='
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:151:2: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImportStatementDecl287); 
                     
                        createLeafNode(grammarAccess.prImportStatementDecl().ele00100LexerRuleCallID(), "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ImportStatementDecl");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,12,FOLLOW_12_in_ruleImportStatementDecl307); 

                            createLeafNode(grammarAccess.prImportStatementDecl().ele0011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:175:4: (lv_importURI= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:177:6: lv_importURI= RULE_STRING
            {
            lv_importURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImportStatementDecl331); 
             
                createLeafNode(grammarAccess.prImportStatementDecl().ele010LexerRuleCallSTRING(), "importURI"); 
                

            	        if (current==null) {
            	            current = factory.create("ImportStatementDecl");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "importURI", lv_importURI, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleImportStatementDecl352); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleImportStatementDecl


    // $ANTLR start entryRuleEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:208:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:208:54: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:209:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl387);
            iv_ruleEPackageDecl=ruleEPackageDecl();
            _fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageDecl397); 

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
    // $ANTLR end entryRuleEPackageDecl


    // $ANTLR start ruleEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:216:1: ruleEPackageDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' ) ;
    public final EObject ruleEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_nsURI=null;
        EObject lv_eAnnotations = null;

        AntlrDatatypeRuleToken lv_name = null;

        AntlrDatatypeRuleToken lv_nsPrefix = null;

        EObject lv_eSubpackages = null;

        EObject lv_eClassifiers = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:220:6: ( ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:1: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:1: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:2: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:2: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:3: ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:3: ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:4: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:4: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:5: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:5: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:6: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' ) '='
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:6: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:7: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) ) 'nsPrefix'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:7: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:8: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:8: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:9: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' ) '='
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:9: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:10: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) ) 'nsURI'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:10: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:11: ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:11: ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:12: (lv_eAnnotations= ruleEAnnotationDecl )* 'package'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:12: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele000000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl466);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPackage");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleEPackageDecl480); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00000000001KeywordPackage(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:246:2: (lv_name= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:249:6: lv_name= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00000000010ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl515);
            lv_name=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EPackage");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleEPackageDecl529); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele000000001KeywordNsURI(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleEPackageDecl539); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00000001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:275:2: (lv_nsURI= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:277:6: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageDecl561); 
             
                createLeafNode(grammarAccess.prEPackageDecl().ele00000010LexerRuleCallSTRING(), "nsURI"); 
                

            	        if (current==null) {
            	            current = factory.create("EPackage");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "nsURI", lv_nsURI, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleEPackageDecl582); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele000001KeywordNsPrefix(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleEPackageDecl592); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:303:2: (lv_nsPrefix= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:306:6: lv_nsPrefix= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00010ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl627);
            lv_nsPrefix=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EPackage");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "nsPrefix", lv_nsPrefix, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEPackageDecl641); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:2: ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:3: (lv_eSubpackages= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:3: (lv_eSubpackages= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:331:6: lv_eSubpackages= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl677);
            	    lv_eSubpackages=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPackage");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eSubpackages", lv_eSubpackages, "SubEPackageDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:350:6: (lv_eClassifiers= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:350:6: (lv_eClassifiers= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:353:6: lv_eClassifiers= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl721);
            	    lv_eClassifiers=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPackage");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eClassifiers", lv_eClassifiers, "EClassifierDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            match(input,18,FOLLOW_18_in_ruleEPackageDecl737); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleEPackageDecl


    // $ANTLR start entryRuleSubEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:384:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:384:57: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:385:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl772);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();
            _fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubEPackageDecl782); 

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
    // $ANTLR end entryRuleSubEPackageDecl


    // $ANTLR start ruleSubEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:392:1: ruleSubEPackageDecl returns [EObject current=null] : ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_eAnnotations = null;

        EObject lv_eSubpackages = null;

        EObject lv_eClassifiers = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:396:6: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:1: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:1: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:2: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:2: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:3: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' ) ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:3: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:4: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:4: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:5: ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:5: ( (lv_eAnnotations= ruleEAnnotationDecl )* 'package' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:6: (lv_eAnnotations= ruleEAnnotationDecl )* 'package'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:6: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:400:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl845);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPackage");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleSubEPackageDecl859); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele00001KeywordPackage(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:422:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:424:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubEPackageDecl881); 
             
                createLeafNode(grammarAccess.prSubEPackageDecl().ele00010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EPackage");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleSubEPackageDecl902); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:2: ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:3: (lv_eSubpackages= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:3: (lv_eSubpackages= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:449:6: lv_eSubpackages= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl938);
            	    lv_eSubpackages=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPackage");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eSubpackages", lv_eSubpackages, "SubEPackageDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:6: (lv_eClassifiers= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:6: (lv_eClassifiers= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:471:6: lv_eClassifiers= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl982);
            	    lv_eClassifiers=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EPackage");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eClassifiers", lv_eClassifiers, "EClassifierDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            match(input,18,FOLLOW_18_in_ruleSubEPackageDecl998); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleSubEPackageDecl


    // $ANTLR start entryRuleEClassifierDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:502:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:502:57: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:503:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassifierDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl1033);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();
            _fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassifierDecl1043); 

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
    // $ANTLR end entryRuleEClassifierDecl


    // $ANTLR start ruleEClassifierDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:510:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl= ruleEClassDecl | this_EDataTypeDecl= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl = null;

        EObject this_EDataTypeDecl = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:514:6: ( (this_EClassDecl= ruleEClassDecl | this_EDataTypeDecl= ruleEDataTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:515:1: (this_EClassDecl= ruleEClassDecl | this_EDataTypeDecl= ruleEDataTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:515:1: (this_EClassDecl= ruleEClassDecl | this_EDataTypeDecl= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:516:5: this_EClassDecl= ruleEClassDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele0ParserRuleCallEClassDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1090);
                    this_EClassDecl=ruleEClassDecl();
                    _fsp--;

                     
                            current = this_EClassDecl; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:526:5: this_EDataTypeDecl= ruleEDataTypeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1117);
                    this_EDataTypeDecl=ruleEDataTypeDecl();
                    _fsp--;

                     
                            current = this_EDataTypeDecl; 
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
    // $ANTLR end ruleEClassifierDecl


    // $ANTLR start entryRuleEDataTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:543:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:543:55: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEDataTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1151);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();
            _fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEDataTypeDecl1161); 

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
    // $ANTLR end entryRuleEDataTypeDecl


    // $ANTLR start ruleEDataTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:551:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable=null;
        Token lv_name=null;
        EObject lv_eAnnotations = null;

        AntlrDatatypeRuleToken lv_instanceClassName = null;

        EObject this_EEnumDecl = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:555:6: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl= ruleEEnumDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:1: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl= ruleEEnumDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:1: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:2: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:2: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:3: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:3: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:4: (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:4: (lv_eAnnotations= ruleEAnnotationDecl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:6: lv_eAnnotations= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele0000ParserRuleCallEAnnotationDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1222);
                    	    lv_eAnnotations=ruleEAnnotationDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("EDataType");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:577:3: (lv_serializable= '!serializable' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==19) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:579:6: lv_serializable= '!serializable'
                            {
                            lv_serializable=(Token)input.LT(1);
                            match(input,19,FOLLOW_19_in_ruleEDataTypeDecl1248); 

                                    createLeafNode(grammarAccess.prEDataTypeDecl().ele0010KeywordSerializable(), "serializable"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("EDataType");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "serializable", true, "!serializable", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:4: ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:5: ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:5: ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:6: ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:6: ( ( 'datatype' (lv_name= RULE_ID ) ) ':' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:7: ( 'datatype' (lv_name= RULE_ID ) ) ':'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:7: ( 'datatype' (lv_name= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:8: 'datatype' (lv_name= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleEDataTypeDecl1275); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele010000KeywordDatatype(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:601:1: (lv_name= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:603:6: lv_name= RULE_ID
                    {
                    lv_name=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEDataTypeDecl1296); 
                     
                        createLeafNode(grammarAccess.prEDataTypeDecl().ele0100010LexerRuleCallID(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EDataType");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "name", lv_name, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,21,FOLLOW_21_in_ruleEDataTypeDecl1317); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele01001KeywordColon(), null); 
                        

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:625:2: (lv_instanceClassName= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:628:6: lv_instanceClassName= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele01010ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1352);
                    lv_instanceClassName=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EDataType");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "instanceClassName", lv_instanceClassName, "STRING_OR_QID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,13,FOLLOW_13_in_ruleEDataTypeDecl1366); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele011KeywordSemicolon(), null); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:652:5: this_EEnumDecl= ruleEEnumDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1396);
                    this_EEnumDecl=ruleEEnumDecl();
                    _fsp--;

                     
                            current = this_EEnumDecl; 
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
    // $ANTLR end ruleEDataTypeDecl


    // $ANTLR start entryRuleEAnnotationDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:669:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:669:57: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:670:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAnnotationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1430);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();
            _fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAnnotationDecl1440); 

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
    // $ANTLR end entryRuleEAnnotationDecl


    // $ANTLR start ruleEAnnotationDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:677:1: ruleEAnnotationDecl returns [EObject current=null] : ( ( ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )* ) ')' ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_source=null;
        EObject lv_contents = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:681:6: ( ( ( ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )* ) ')' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:1: ( ( ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )* ) ')' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:1: ( ( ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )* ) ')' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:2: ( ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )* ) ')'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:2: ( ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:3: ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) ) ( ',' (lv_contents= ruleMapEntrySuper ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:3: ( ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:4: ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' ) (lv_contents= ruleMapEntrySuper )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:4: ( ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '(' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:5: ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? ) '('
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:5: ( ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:6: ( '@' (lv_source= RULE_STRING ) ) ( ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:6: ( '@' (lv_source= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:7: '@' (lv_source= RULE_STRING )
            {
            match(input,22,FOLLOW_22_in_ruleEAnnotationDecl1479); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele000000KeywordCommercialAt(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:686:1: (lv_source= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:688:6: lv_source= RULE_STRING
            {
            lv_source=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAnnotationDecl1500); 
             
                createLeafNode(grammarAccess.prEAnnotationDecl().ele0000010LexerRuleCallSTRING(), "source"); 
                

            	        if (current==null) {
            	            current = factory.create("EAnnotation");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "source", lv_source, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:706:3: ( ( RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:709:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("EAnnotation");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:715:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:716:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAnnotationDecl1536); 
                     
                        createLeafNode(grammarAccess.prEAnnotationDecl().ele000010CrossReferenceEStringEModelElement(), "eModelElement"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,23,FOLLOW_23_in_ruleEAnnotationDecl1551); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:725:2: (lv_contents= ruleMapEntrySuper )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:728:6: lv_contents= ruleMapEntrySuper
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0010ParserRuleCallMapEntrySuper(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1586);
            lv_contents=ruleMapEntrySuper();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EAnnotation");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "contents", lv_contents, "MapEntrySuper", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:746:3: ( ',' (lv_contents= ruleMapEntrySuper ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:746:4: ',' (lv_contents= ruleMapEntrySuper )
            	    {
            	    match(input,24,FOLLOW_24_in_ruleEAnnotationDecl1601); 

            	            createLeafNode(grammarAccess.prEAnnotationDecl().ele010KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:750:1: (lv_contents= ruleMapEntrySuper )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:753:6: lv_contents= ruleMapEntrySuper
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0110ParserRuleCallMapEntrySuper(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1635);
            	    lv_contents=ruleMapEntrySuper();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EAnnotation");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "contents", lv_contents, "MapEntrySuper", currentNode);
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

            match(input,25,FOLLOW_25_in_ruleEAnnotationDecl1651); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleEAnnotationDecl


    // $ANTLR start entryRuleEClassDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:784:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:784:52: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:785:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1686);
            iv_ruleEClassDecl=ruleEClassDecl();
            _fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassDecl1696); 

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
    // $ANTLR end entryRuleEClassDecl


    // $ANTLR start ruleEClassDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:792:1: ruleEClassDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )* ) '}' ) ;
    public final EObject ruleEClassDecl() throws RecognitionException {
        EObject current = null;

        Token lv_abstract=null;
        Token lv_interface=null;
        Token lv_name=null;
        EObject lv_eAnnotations = null;

        EObject lv_eTypeParameters = null;

        EObject lv_eGenericSuperTypes = null;

        AntlrDatatypeRuleToken lv_instanceClassName = null;

        EObject lv_eStructuralFeatures = null;

        EObject lv_eOperations = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:796:6: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )* ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:1: ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )* ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:1: ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )* ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:2: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )* ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:2: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:3: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:3: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:4: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:4: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:5: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:5: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:6: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:6: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:7: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:7: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:8: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:8: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:9: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? ) ( (lv_interface= 'interface' ) | 'class' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:9: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:10: (lv_eAnnotations= ruleEAnnotationDecl )* (lv_abstract= 'abstract' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:797:10: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:800:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1763);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EClass");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:818:3: (lv_abstract= 'abstract' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:820:6: lv_abstract= 'abstract'
                    {
                    lv_abstract=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleEClassDecl1789); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000000010KeywordAbstract(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EClass");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "abstract", true, "abstract", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:4: ( (lv_interface= 'interface' ) | 'class' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("838:4: ( (lv_interface= 'interface' ) | 'class' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:5: (lv_interface= 'interface' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:5: (lv_interface= 'interface' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:840:6: lv_interface= 'interface'
                    {
                    lv_interface=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleEClassDecl1825); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000000100KeywordInterface(), "interface"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EClass");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "interface", true, "interface", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:859:6: 'class'
                    {
                    match(input,28,FOLLOW_28_in_ruleEClassDecl1852); 

                            createLeafNode(grammarAccess.prEClassDecl().ele000000011KeywordClass(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:863:3: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:865:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEClassDecl1875); 
             
                createLeafNode(grammarAccess.prEClassDecl().ele00000010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EClass");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:3: ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:4: ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:4: ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:5: ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:5: ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:6: '<' (lv_eTypeParameters= ruleETypeParameterDecl )
                    {
                    match(input,29,FOLLOW_29_in_ruleEClassDecl1899); 

                            createLeafNode(grammarAccess.prEClassDecl().ele000001000KeywordLessThanSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:887:1: (lv_eTypeParameters= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:890:6: lv_eTypeParameters= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1933);
                    lv_eTypeParameters=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EClass");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:908:3: ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==24) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:908:4: ',' (lv_eTypeParameters= ruleETypeParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEClassDecl1948); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele000001010KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:912:1: (lv_eTypeParameters= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:915:6: lv_eTypeParameters= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1982);
                    	    lv_eTypeParameters=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("EClass");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
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

                    match(input,30,FOLLOW_30_in_ruleEClassDecl1998); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000011KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:937:4: ( ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:937:5: ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:937:5: ( 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:937:6: 'extends' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl )
                    {
                    match(input,31,FOLLOW_31_in_ruleEClassDecl2012); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000100KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:941:1: (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:944:6: lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2046);
                    lv_eGenericSuperTypes=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EClass");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "eGenericSuperTypes", lv_eGenericSuperTypes, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:962:3: ( ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:962:4: ',' (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEClassDecl2061); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele0000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:966:1: (lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:969:6: lv_eGenericSuperTypes= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2095);
                    	    lv_eGenericSuperTypes=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("EClass");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "eGenericSuperTypes", lv_eGenericSuperTypes, "EGenericTypeReferenceDecl", currentNode);
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


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:987:7: ( ':' (lv_instanceClassName= ruleSTRING_OR_QID ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:987:8: ':' (lv_instanceClassName= ruleSTRING_OR_QID )
                    {
                    match(input,21,FOLLOW_21_in_ruleEClassDecl2114); 

                            createLeafNode(grammarAccess.prEClassDecl().ele00010KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:991:1: (lv_instanceClassName= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:994:6: lv_instanceClassName= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele000110ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2148);
                    lv_instanceClassName=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EClass");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "instanceClassName", lv_instanceClassName, "STRING_OR_QID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,17,FOLLOW_17_in_ruleEClassDecl2164); 

                    createLeafNode(grammarAccess.prEClassDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1016:2: ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1016:3: (lv_eStructuralFeatures= ruleEStructuralFeatureDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1016:3: (lv_eStructuralFeatures= ruleEStructuralFeatureDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1019:6: lv_eStructuralFeatures= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0100ParserRuleCallEStructuralFeatureDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2200);
            	    lv_eStructuralFeatures=ruleEStructuralFeatureDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EClass");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eStructuralFeatures", lv_eStructuralFeatures, "EStructuralFeatureDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1038:6: (lv_eOperations= ruleEOperationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1038:6: (lv_eOperations= ruleEOperationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1041:6: lv_eOperations= ruleEOperationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0110ParserRuleCallEOperationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2244);
            	    lv_eOperations=ruleEOperationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EClass");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eOperations", lv_eOperations, "EOperationDecl", currentNode);
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

            match(input,18,FOLLOW_18_in_ruleEClassDecl2260); 

                    createLeafNode(grammarAccess.prEClassDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleEClassDecl


    // $ANTLR start entryRuleEStructuralFeatureDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1072:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1072:64: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1073:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEStructuralFeatureDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2295);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();
            _fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2305); 

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
    // $ANTLR end entryRuleEStructuralFeatureDecl


    // $ANTLR start ruleEStructuralFeatureDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1080:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl= ruleEAttributeDecl | this_EReferenceDecl= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl = null;

        EObject this_EReferenceDecl = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1084:6: ( (this_EAttributeDecl= ruleEAttributeDecl | this_EReferenceDecl= ruleEReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1085:1: (this_EAttributeDecl= ruleEAttributeDecl | this_EReferenceDecl= ruleEReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1085:1: (this_EAttributeDecl= ruleEAttributeDecl | this_EReferenceDecl= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1086:5: this_EAttributeDecl= ruleEAttributeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2352);
                    this_EAttributeDecl=ruleEAttributeDecl();
                    _fsp--;

                     
                            current = this_EAttributeDecl; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1096:5: this_EReferenceDecl= ruleEReferenceDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2379);
                    this_EReferenceDecl=ruleEReferenceDecl();
                    _fsp--;

                     
                            current = this_EReferenceDecl; 
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
    // $ANTLR end ruleEStructuralFeatureDecl


    // $ANTLR start entryRuleEAttributeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1113:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1113:56: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1114:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAttributeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2413);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();
            _fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAttributeDecl2423); 

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
    // $ANTLR end entryRuleEAttributeDecl


    // $ANTLR start ruleEAttributeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1121:1: ruleEAttributeDecl returns [EObject current=null] : ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )? ) ';' ) ;
    public final EObject ruleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_iD=null;
        Token lv_unique=null;
        Token lv_ordered=null;
        Token lv_changeable=null;
        Token lv_volatile=null;
        Token lv_transient=null;
        Token lv_unsettable=null;
        Token lv_derived=null;
        Token lv_lowerBound=null;
        Token lv_name=null;
        Token lv_defaultValueLiteral=null;
        EObject lv_eAnnotations = null;

        EObject lv_eGenericType = null;

        AntlrDatatypeRuleToken lv_upperBound = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:6: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )? ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:1: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )? ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:1: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )? ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:2: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )? ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:2: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:3: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) ) ( '=' (lv_defaultValueLiteral= RULE_STRING ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:3: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:4: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:4: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:5: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:5: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:6: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' ) (lv_eGenericType= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:6: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:7: ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) 'attr'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:7: ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:8: (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:8: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==22) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1129:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2488);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EAttribute");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:3: ( ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=32 && LA30_0<=38)) ) {
                    alt30=1;
                }
                else if ( (LA30_0==39) ) {
                    alt30=2;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:4: ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:4: ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) )
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( ((LA29_0>=32 && LA29_0<=37)) ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0==38) ) {
            	        alt29=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1147:4: ( ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) )", 29, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:5: ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:5: ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) )
            	            int alt28=2;
            	            int LA28_0 = input.LA(1);

            	            if ( ((LA28_0>=32 && LA28_0<=36)) ) {
            	                alt28=1;
            	            }
            	            else if ( (LA28_0==37) ) {
            	                alt28=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("1147:5: ( ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) )", 28, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:6: ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:6: ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) )
            	                    int alt27=2;
            	                    int LA27_0 = input.LA(1);

            	                    if ( ((LA27_0>=32 && LA27_0<=35)) ) {
            	                        alt27=1;
            	                    }
            	                    else if ( (LA27_0==36) ) {
            	                        alt27=2;
            	                    }
            	                    else {
            	                        NoViableAltException nvae =
            	                            new NoViableAltException("1147:6: ( ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) )", 27, 0, input);

            	                        throw nvae;
            	                    }
            	                    switch (alt27) {
            	                        case 1 :
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:7: ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:7: ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) )
            	                            int alt26=2;
            	                            int LA26_0 = input.LA(1);

            	                            if ( ((LA26_0>=32 && LA26_0<=34)) ) {
            	                                alt26=1;
            	                            }
            	                            else if ( (LA26_0==35) ) {
            	                                alt26=2;
            	                            }
            	                            else {
            	                                NoViableAltException nvae =
            	                                    new NoViableAltException("1147:7: ( ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) )", 26, 0, input);

            	                                throw nvae;
            	                            }
            	                            switch (alt26) {
            	                                case 1 :
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:8: ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:8: ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) )
            	                                    int alt25=2;
            	                                    int LA25_0 = input.LA(1);

            	                                    if ( ((LA25_0>=32 && LA25_0<=33)) ) {
            	                                        alt25=1;
            	                                    }
            	                                    else if ( (LA25_0==34) ) {
            	                                        alt25=2;
            	                                    }
            	                                    else {
            	                                        NoViableAltException nvae =
            	                                            new NoViableAltException("1147:8: ( ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) )", 25, 0, input);

            	                                        throw nvae;
            	                                    }
            	                                    switch (alt25) {
            	                                        case 1 :
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:9: ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:9: ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) )
            	                                            int alt24=2;
            	                                            int LA24_0 = input.LA(1);

            	                                            if ( (LA24_0==32) ) {
            	                                                alt24=1;
            	                                            }
            	                                            else if ( (LA24_0==33) ) {
            	                                                alt24=2;
            	                                            }
            	                                            else {
            	                                                NoViableAltException nvae =
            	                                                    new NoViableAltException("1147:9: ( (lv_iD= 'ID' ) | (lv_unique= 'bag' ) )", 24, 0, input);

            	                                                throw nvae;
            	                                            }
            	                                            switch (alt24) {
            	                                                case 1 :
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:10: (lv_iD= 'ID' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:10: (lv_iD= 'ID' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1149:6: lv_iD= 'ID'
            	                                                    {
            	                                                    lv_iD=(Token)input.LT(1);
            	                                                    match(input,32,FOLLOW_32_in_ruleEAttributeDecl2521); 

            	                                                            createLeafNode(grammarAccess.prEAttributeDecl().ele000000100000000KeywordID(), "iD"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create("EAttribute");
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	        	factory.set(current, "iD", true, "ID", currentNode);
            	                                                    	        } catch (ValueConverterException vce) {
            	                                                    				handleValueConverterException(vce);
            	                                                    	        }
            	                                                    	    

            	                                                    }


            	                                                    }
            	                                                    break;
            	                                                case 2 :
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1168:6: (lv_unique= 'bag' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1168:6: (lv_unique= 'bag' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1170:6: lv_unique= 'bag'
            	                                                    {
            	                                                    lv_unique=(Token)input.LT(1);
            	                                                    match(input,33,FOLLOW_33_in_ruleEAttributeDecl2560); 

            	                                                            createLeafNode(grammarAccess.prEAttributeDecl().ele000000100000010KeywordBag(), "unique"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create("EAttribute");
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	        	factory.set(current, "unique", true, "bag", currentNode);
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
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:6: (lv_ordered= 'random' )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:6: (lv_ordered= 'random' )
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1191:6: lv_ordered= 'random'
            	                                            {
            	                                            lv_ordered=(Token)input.LT(1);
            	                                            match(input,34,FOLLOW_34_in_ruleEAttributeDecl2600); 

            	                                                    createLeafNode(grammarAccess.prEAttributeDecl().ele00000010000010KeywordRandom(), "ordered"); 
            	                                                

            	                                            	        if (current==null) {
            	                                            	            current = factory.create("EAttribute");
            	                                            	            associateNodeWithAstElement(currentNode, current);
            	                                            	        }
            	                                            	        
            	                                            	        try {
            	                                            	        	factory.set(current, "ordered", true, "random", currentNode);
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
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1210:6: (lv_changeable= 'readonly' )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1210:6: (lv_changeable= 'readonly' )
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1212:6: lv_changeable= 'readonly'
            	                                    {
            	                                    lv_changeable=(Token)input.LT(1);
            	                                    match(input,35,FOLLOW_35_in_ruleEAttributeDecl2640); 

            	                                            createLeafNode(grammarAccess.prEAttributeDecl().ele0000001000010KeywordReadonly(), "changeable"); 
            	                                        

            	                                    	        if (current==null) {
            	                                    	            current = factory.create("EAttribute");
            	                                    	            associateNodeWithAstElement(currentNode, current);
            	                                    	        }
            	                                    	        
            	                                    	        try {
            	                                    	        	factory.set(current, "changeable", true, "readonly", currentNode);
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
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1231:6: (lv_volatile= 'volatile' )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1231:6: (lv_volatile= 'volatile' )
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1233:6: lv_volatile= 'volatile'
            	                            {
            	                            lv_volatile=(Token)input.LT(1);
            	                            match(input,36,FOLLOW_36_in_ruleEAttributeDecl2680); 

            	                                    createLeafNode(grammarAccess.prEAttributeDecl().ele000000100010KeywordVolatile(), "volatile"); 
            	                                

            	                            	        if (current==null) {
            	                            	            current = factory.create("EAttribute");
            	                            	            associateNodeWithAstElement(currentNode, current);
            	                            	        }
            	                            	        
            	                            	        try {
            	                            	        	factory.set(current, "volatile", true, "volatile", currentNode);
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
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1252:6: (lv_transient= 'transient' )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1252:6: (lv_transient= 'transient' )
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1254:6: lv_transient= 'transient'
            	                    {
            	                    lv_transient=(Token)input.LT(1);
            	                    match(input,37,FOLLOW_37_in_ruleEAttributeDecl2720); 

            	                            createLeafNode(grammarAccess.prEAttributeDecl().ele00000010010KeywordTransient(), "transient"); 
            	                        

            	                    	        if (current==null) {
            	                    	            current = factory.create("EAttribute");
            	                    	            associateNodeWithAstElement(currentNode, current);
            	                    	        }
            	                    	        
            	                    	        try {
            	                    	        	factory.set(current, "transient", true, "transient", currentNode);
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
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1273:6: (lv_unsettable= 'unsettable' )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1273:6: (lv_unsettable= 'unsettable' )
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1275:6: lv_unsettable= 'unsettable'
            	            {
            	            lv_unsettable=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleEAttributeDecl2760); 

            	                    createLeafNode(grammarAccess.prEAttributeDecl().ele0000001010KeywordUnsettable(), "unsettable"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create("EAttribute");
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	        	factory.set(current, "unsettable", true, "unsettable", currentNode);
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1294:6: (lv_derived= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1294:6: (lv_derived= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1296:6: lv_derived= 'derived'
            	    {
            	    lv_derived=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEAttributeDecl2800); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele000000110KeywordDerived(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("EAttribute");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.set(current, "derived", true, "derived", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            match(input,40,FOLLOW_40_in_ruleEAttributeDecl2824); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele000001KeywordAttr(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1318:2: (lv_eGenericType= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1321:6: lv_eGenericType= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2859);
            lv_eGenericType=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EAttribute");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:3: ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==41) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:4: ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:4: ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:5: ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:5: ( '[' (lv_lowerBound= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:6: '[' (lv_lowerBound= RULE_INT )
                    {
                    match(input,41,FOLLOW_41_in_ruleEAttributeDecl2876); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele0001000KeywordLeftSquareBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1343:1: (lv_lowerBound= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1345:6: lv_lowerBound= RULE_INT
                    {
                    lv_lowerBound=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEAttributeDecl2897); 
                     
                        createLeafNode(grammarAccess.prEAttributeDecl().ele00010010LexerRuleCallINT(), "lowerBound"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EAttribute");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "lowerBound", lv_lowerBound, "INT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1363:3: ( '..' (lv_upperBound= ruleSINT ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==42) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1363:4: '..' (lv_upperBound= ruleSINT )
                            {
                            match(input,42,FOLLOW_42_in_ruleEAttributeDecl2919); 

                                    createLeafNode(grammarAccess.prEAttributeDecl().ele0001010KeywordFullStopFullStop(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1367:1: (lv_upperBound= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1370:6: lv_upperBound= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00010110ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEAttributeDecl2953);
                            lv_upperBound=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("EAttribute");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "upperBound", lv_upperBound, "SINT", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    match(input,43,FOLLOW_43_in_ruleEAttributeDecl2969); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele00011KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1392:4: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1394:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAttributeDecl2993); 
             
                createLeafNode(grammarAccess.prEAttributeDecl().ele0010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EAttribute");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1412:3: ( '=' (lv_defaultValueLiteral= RULE_STRING ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==12) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1412:4: '=' (lv_defaultValueLiteral= RULE_STRING )
                    {
                    match(input,12,FOLLOW_12_in_ruleEAttributeDecl3015); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele010KeywordEqualsSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1416:1: (lv_defaultValueLiteral= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1418:6: lv_defaultValueLiteral= RULE_STRING
                    {
                    lv_defaultValueLiteral=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAttributeDecl3036); 
                     
                        createLeafNode(grammarAccess.prEAttributeDecl().ele0110LexerRuleCallSTRING(), "defaultValueLiteral"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EAttribute");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "defaultValueLiteral", lv_defaultValueLiteral, "STRING", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEAttributeDecl3059); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEAttributeDecl


    // $ANTLR start entryRuleEReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1449:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1449:56: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1450:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl3094);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();
            _fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEReferenceDecl3104); 

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
    // $ANTLR end entryRuleEReferenceDecl


    // $ANTLR start ruleEReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1457:1: ruleEReferenceDecl returns [EObject current=null] : ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID ) ) ';' ) ;
    public final EObject ruleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        Token lv_resolveProxies=null;
        Token lv_unique=null;
        Token lv_ordered=null;
        Token lv_changeable=null;
        Token lv_volatile=null;
        Token lv_transient=null;
        Token lv_unsettable=null;
        Token lv_derived=null;
        Token lv_containment=null;
        Token lv_lowerBound=null;
        Token lv_name=null;
        EObject lv_eAnnotations = null;

        EObject lv_eGenericType = null;

        AntlrDatatypeRuleToken lv_upperBound = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1461:6: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:1: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:1: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:2: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:2: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:3: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:3: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:4: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? ) ( '#' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:4: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:5: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:5: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:6: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) ) (lv_eGenericType= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:6: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:7: ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* ) ( (lv_containment= 'val' ) | 'ref' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:7: ( (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:8: (lv_eAnnotations= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:8: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==22) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3169);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EReference");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:3: ( ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) ) | (lv_derived= 'derived' ) )*
            loop41:
            do {
                int alt41=3;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=33 && LA41_0<=38)||LA41_0==44) ) {
                    alt41=1;
                }
                else if ( (LA41_0==39) ) {
                    alt41=2;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:4: ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:4: ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) )
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( ((LA40_0>=33 && LA40_0<=37)||LA40_0==44) ) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==38) ) {
            	        alt40=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1483:4: ( ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) ) | (lv_unsettable= 'unsettable' ) )", 40, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:5: ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:5: ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) )
            	            int alt39=2;
            	            int LA39_0 = input.LA(1);

            	            if ( ((LA39_0>=33 && LA39_0<=36)||LA39_0==44) ) {
            	                alt39=1;
            	            }
            	            else if ( (LA39_0==37) ) {
            	                alt39=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("1483:5: ( ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) ) | (lv_transient= 'transient' ) )", 39, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt39) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:6: ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:6: ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) )
            	                    int alt38=2;
            	                    int LA38_0 = input.LA(1);

            	                    if ( ((LA38_0>=33 && LA38_0<=35)||LA38_0==44) ) {
            	                        alt38=1;
            	                    }
            	                    else if ( (LA38_0==36) ) {
            	                        alt38=2;
            	                    }
            	                    else {
            	                        NoViableAltException nvae =
            	                            new NoViableAltException("1483:6: ( ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) ) | (lv_volatile= 'volatile' ) )", 38, 0, input);

            	                        throw nvae;
            	                    }
            	                    switch (alt38) {
            	                        case 1 :
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:7: ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:7: ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) )
            	                            int alt37=2;
            	                            int LA37_0 = input.LA(1);

            	                            if ( ((LA37_0>=33 && LA37_0<=34)||LA37_0==44) ) {
            	                                alt37=1;
            	                            }
            	                            else if ( (LA37_0==35) ) {
            	                                alt37=2;
            	                            }
            	                            else {
            	                                NoViableAltException nvae =
            	                                    new NoViableAltException("1483:7: ( ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) ) | (lv_changeable= 'readonly' ) )", 37, 0, input);

            	                                throw nvae;
            	                            }
            	                            switch (alt37) {
            	                                case 1 :
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:8: ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:8: ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) )
            	                                    int alt36=2;
            	                                    int LA36_0 = input.LA(1);

            	                                    if ( (LA36_0==33||LA36_0==44) ) {
            	                                        alt36=1;
            	                                    }
            	                                    else if ( (LA36_0==34) ) {
            	                                        alt36=2;
            	                                    }
            	                                    else {
            	                                        NoViableAltException nvae =
            	                                            new NoViableAltException("1483:8: ( ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) ) | (lv_ordered= 'random' ) )", 36, 0, input);

            	                                        throw nvae;
            	                                    }
            	                                    switch (alt36) {
            	                                        case 1 :
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:9: ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:9: ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) )
            	                                            int alt35=2;
            	                                            int LA35_0 = input.LA(1);

            	                                            if ( (LA35_0==44) ) {
            	                                                alt35=1;
            	                                            }
            	                                            else if ( (LA35_0==33) ) {
            	                                                alt35=2;
            	                                            }
            	                                            else {
            	                                                NoViableAltException nvae =
            	                                                    new NoViableAltException("1483:9: ( (lv_resolveProxies= 'local' ) | (lv_unique= 'bag' ) )", 35, 0, input);

            	                                                throw nvae;
            	                                            }
            	                                            switch (alt35) {
            	                                                case 1 :
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:10: (lv_resolveProxies= 'local' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1483:10: (lv_resolveProxies= 'local' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:6: lv_resolveProxies= 'local'
            	                                                    {
            	                                                    lv_resolveProxies=(Token)input.LT(1);
            	                                                    match(input,44,FOLLOW_44_in_ruleEReferenceDecl3202); 

            	                                                            createLeafNode(grammarAccess.prEReferenceDecl().ele000000100000000KeywordLocal(), "resolveProxies"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create("EReference");
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	        	factory.set(current, "resolveProxies", true, "local", currentNode);
            	                                                    	        } catch (ValueConverterException vce) {
            	                                                    				handleValueConverterException(vce);
            	                                                    	        }
            	                                                    	    

            	                                                    }


            	                                                    }
            	                                                    break;
            	                                                case 2 :
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1504:6: (lv_unique= 'bag' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1504:6: (lv_unique= 'bag' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:6: lv_unique= 'bag'
            	                                                    {
            	                                                    lv_unique=(Token)input.LT(1);
            	                                                    match(input,33,FOLLOW_33_in_ruleEReferenceDecl3241); 

            	                                                            createLeafNode(grammarAccess.prEReferenceDecl().ele000000100000010KeywordBag(), "unique"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create("EReference");
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	        	factory.set(current, "unique", true, "bag", currentNode);
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
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1525:6: (lv_ordered= 'random' )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1525:6: (lv_ordered= 'random' )
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1527:6: lv_ordered= 'random'
            	                                            {
            	                                            lv_ordered=(Token)input.LT(1);
            	                                            match(input,34,FOLLOW_34_in_ruleEReferenceDecl3281); 

            	                                                    createLeafNode(grammarAccess.prEReferenceDecl().ele00000010000010KeywordRandom(), "ordered"); 
            	                                                

            	                                            	        if (current==null) {
            	                                            	            current = factory.create("EReference");
            	                                            	            associateNodeWithAstElement(currentNode, current);
            	                                            	        }
            	                                            	        
            	                                            	        try {
            	                                            	        	factory.set(current, "ordered", true, "random", currentNode);
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
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1546:6: (lv_changeable= 'readonly' )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1546:6: (lv_changeable= 'readonly' )
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1548:6: lv_changeable= 'readonly'
            	                                    {
            	                                    lv_changeable=(Token)input.LT(1);
            	                                    match(input,35,FOLLOW_35_in_ruleEReferenceDecl3321); 

            	                                            createLeafNode(grammarAccess.prEReferenceDecl().ele0000001000010KeywordReadonly(), "changeable"); 
            	                                        

            	                                    	        if (current==null) {
            	                                    	            current = factory.create("EReference");
            	                                    	            associateNodeWithAstElement(currentNode, current);
            	                                    	        }
            	                                    	        
            	                                    	        try {
            	                                    	        	factory.set(current, "changeable", true, "readonly", currentNode);
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
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1567:6: (lv_volatile= 'volatile' )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1567:6: (lv_volatile= 'volatile' )
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1569:6: lv_volatile= 'volatile'
            	                            {
            	                            lv_volatile=(Token)input.LT(1);
            	                            match(input,36,FOLLOW_36_in_ruleEReferenceDecl3361); 

            	                                    createLeafNode(grammarAccess.prEReferenceDecl().ele000000100010KeywordVolatile(), "volatile"); 
            	                                

            	                            	        if (current==null) {
            	                            	            current = factory.create("EReference");
            	                            	            associateNodeWithAstElement(currentNode, current);
            	                            	        }
            	                            	        
            	                            	        try {
            	                            	        	factory.set(current, "volatile", true, "volatile", currentNode);
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
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1588:6: (lv_transient= 'transient' )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1588:6: (lv_transient= 'transient' )
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1590:6: lv_transient= 'transient'
            	                    {
            	                    lv_transient=(Token)input.LT(1);
            	                    match(input,37,FOLLOW_37_in_ruleEReferenceDecl3401); 

            	                            createLeafNode(grammarAccess.prEReferenceDecl().ele00000010010KeywordTransient(), "transient"); 
            	                        

            	                    	        if (current==null) {
            	                    	            current = factory.create("EReference");
            	                    	            associateNodeWithAstElement(currentNode, current);
            	                    	        }
            	                    	        
            	                    	        try {
            	                    	        	factory.set(current, "transient", true, "transient", currentNode);
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
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1609:6: (lv_unsettable= 'unsettable' )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1609:6: (lv_unsettable= 'unsettable' )
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1611:6: lv_unsettable= 'unsettable'
            	            {
            	            lv_unsettable=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleEReferenceDecl3441); 

            	                    createLeafNode(grammarAccess.prEReferenceDecl().ele0000001010KeywordUnsettable(), "unsettable"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create("EReference");
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	        	factory.set(current, "unsettable", true, "unsettable", currentNode);
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1630:6: (lv_derived= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1630:6: (lv_derived= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1632:6: lv_derived= 'derived'
            	    {
            	    lv_derived=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEReferenceDecl3481); 

            	            createLeafNode(grammarAccess.prEReferenceDecl().ele000000110KeywordDerived(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("EReference");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.set(current, "derived", true, "derived", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1650:5: ( (lv_containment= 'val' ) | 'ref' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==45) ) {
                alt42=1;
            }
            else if ( (LA42_0==46) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1650:5: ( (lv_containment= 'val' ) | 'ref' )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1650:6: (lv_containment= 'val' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1650:6: (lv_containment= 'val' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1652:6: lv_containment= 'val'
                    {
                    lv_containment=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleEReferenceDecl3518); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele00000100KeywordVal(), "containment"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "containment", true, "val", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1671:6: 'ref'
                    {
                    match(input,46,FOLLOW_46_in_ruleEReferenceDecl3545); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0000011KeywordRef(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1675:3: (lv_eGenericType= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1678:6: lv_eGenericType= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3581);
            lv_eGenericType=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EReference");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1696:3: ( ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==41) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1696:4: ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? ) ']'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1696:4: ( ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1696:5: ( '[' (lv_lowerBound= RULE_INT ) ) ( '..' (lv_upperBound= ruleSINT ) )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1696:5: ( '[' (lv_lowerBound= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1696:6: '[' (lv_lowerBound= RULE_INT )
                    {
                    match(input,41,FOLLOW_41_in_ruleEReferenceDecl3598); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0001000KeywordLeftSquareBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1700:1: (lv_lowerBound= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1702:6: lv_lowerBound= RULE_INT
                    {
                    lv_lowerBound=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEReferenceDecl3619); 
                     
                        createLeafNode(grammarAccess.prEReferenceDecl().ele00010010LexerRuleCallINT(), "lowerBound"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "lowerBound", lv_lowerBound, "INT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1720:3: ( '..' (lv_upperBound= ruleSINT ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==42) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1720:4: '..' (lv_upperBound= ruleSINT )
                            {
                            match(input,42,FOLLOW_42_in_ruleEReferenceDecl3641); 

                                    createLeafNode(grammarAccess.prEReferenceDecl().ele0001010KeywordFullStopFullStop(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1724:1: (lv_upperBound= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1727:6: lv_upperBound= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00010110ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEReferenceDecl3675);
                            lv_upperBound=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("EReference");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "upperBound", lv_upperBound, "SINT", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    match(input,43,FOLLOW_43_in_ruleEReferenceDecl3691); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele00011KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1749:4: ( '#' ( ( RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1749:5: '#' ( ( RULE_ID ) )
                    {
                    match(input,47,FOLLOW_47_in_ruleEReferenceDecl3704); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0010KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1753:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1756:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("EReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1762:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1763:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3728); 
                     
                        createLeafNode(grammarAccess.prEReferenceDecl().ele00110CrossReferenceEStringEReference(), "eOpposite"); 
                        

                    }


                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1768:5: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1770:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3756); 
             
                createLeafNode(grammarAccess.prEReferenceDecl().ele010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EReference");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEReferenceDecl3777); 

                    createLeafNode(grammarAccess.prEReferenceDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEReferenceDecl


    // $ANTLR start entryRuleEEnumDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:51: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1802:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3812);
            iv_ruleEEnumDecl=ruleEEnumDecl();
            _fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumDecl3822); 

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
    // $ANTLR end entryRuleEEnumDecl


    // $ANTLR start ruleEEnumDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1809:1: ruleEEnumDecl returns [EObject current=null] : ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+ ) '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_eAnnotations = null;

        EObject lv_eLiterals = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1813:6: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+ ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:1: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+ ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:1: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+ ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:2: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+ ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:2: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+ )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:3: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' ) (lv_eLiterals= ruleEEnumLiteralDecl )+
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:3: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:4: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:4: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:5: ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:5: ( (lv_eAnnotations= ruleEAnnotationDecl )* 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:6: (lv_eAnnotations= ruleEAnnotationDecl )* 'enum'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1814:6: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==22) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1817:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3885);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EEnum");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            match(input,48,FOLLOW_48_in_ruleEEnumDecl3899); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele00001KeywordEnum(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1839:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1841:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumDecl3921); 
             
                createLeafNode(grammarAccess.prEEnumDecl().ele00010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EEnum");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEEnumDecl3942); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1863:2: (lv_eLiterals= ruleEEnumLiteralDecl )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID||LA47_0==22) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1866:6: lv_eLiterals= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele010ParserRuleCallEEnumLiteralDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3977);
            	    lv_eLiterals=ruleEEnumLiteralDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EEnum");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eLiterals", lv_eLiterals, "EEnumLiteralDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);


            }

            match(input,18,FOLLOW_18_in_ruleEEnumDecl3992); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleEEnumDecl


    // $ANTLR start entryRuleEEnumLiteralDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1897:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1897:58: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1898:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumLiteralDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl4027);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();
            _fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumLiteralDecl4037); 

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
    // $ANTLR end entryRuleEEnumLiteralDecl


    // $ANTLR start ruleEEnumLiteralDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1905:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )? ) ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_value=null;
        Token lv_literal=null;
        EObject lv_eAnnotations = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1909:6: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )? ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:1: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )? ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:1: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )? ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:2: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )? ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:2: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:3: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? ) (lv_literal= RULE_STRING )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:3: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:4: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) ) ( '=' (lv_value= RULE_INT ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:4: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:5: (lv_eAnnotations= ruleEAnnotationDecl )* (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1910:5: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==22) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1913:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumLiteralDecl().ele00000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl4099);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EEnumLiteral");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1931:3: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1933:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl4125); 
             
                createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EEnumLiteral");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1951:3: ( '=' (lv_value= RULE_INT ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==12) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1951:4: '=' (lv_value= RULE_INT )
                    {
                    match(input,12,FOLLOW_12_in_ruleEEnumLiteralDecl4147); 

                            createLeafNode(grammarAccess.prEEnumLiteralDecl().ele0010KeywordEqualsSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1955:1: (lv_value= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1957:6: lv_value= RULE_INT
                    {
                    lv_value=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl4168); 
                     
                        createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00110LexerRuleCallINT(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EEnumLiteral");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "value", lv_value, "INT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1975:5: (lv_literal= RULE_STRING )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_STRING) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1977:6: lv_literal= RULE_STRING
                    {
                    lv_literal=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4203); 
                     
                        createLeafNode(grammarAccess.prEEnumLiteralDecl().ele010LexerRuleCallSTRING(), "literal"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("EEnumLiteral");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "literal", lv_literal, "STRING", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEEnumLiteralDecl4225); 

                    createLeafNode(grammarAccess.prEEnumLiteralDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEEnumLiteralDecl


    // $ANTLR start entryRuleETypeParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2008:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2008:60: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2009:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prETypeParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4260);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();
            _fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleETypeParameterDecl4270); 

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
    // $ANTLR end entryRuleETypeParameterDecl


    // $ANTLR start ruleETypeParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2016:1: ruleETypeParameterDecl returns [EObject current=null] : ( (lv_name= RULE_ID ) ( 'extends' (lv_eBounds= ruleEGenericTypeDecl ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_eBounds = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2020:6: ( ( (lv_name= RULE_ID ) ( 'extends' (lv_eBounds= ruleEGenericTypeDecl ) )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2021:1: ( (lv_name= RULE_ID ) ( 'extends' (lv_eBounds= ruleEGenericTypeDecl ) )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2021:1: ( (lv_name= RULE_ID ) ( 'extends' (lv_eBounds= ruleEGenericTypeDecl ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2021:2: (lv_name= RULE_ID ) ( 'extends' (lv_eBounds= ruleEGenericTypeDecl ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2021:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2023:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleETypeParameterDecl4316); 
             
                createLeafNode(grammarAccess.prETypeParameterDecl().ele00LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ETypeParameter");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2041:2: ( 'extends' (lv_eBounds= ruleEGenericTypeDecl ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==31) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2041:3: 'extends' (lv_eBounds= ruleEGenericTypeDecl )
                    {
                    match(input,31,FOLLOW_31_in_ruleETypeParameterDecl4337); 

                            createLeafNode(grammarAccess.prETypeParameterDecl().ele10KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2045:1: (lv_eBounds= ruleEGenericTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2048:6: lv_eBounds= ruleEGenericTypeDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prETypeParameterDecl().ele110ParserRuleCallEGenericTypeDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4371);
                    lv_eBounds=ruleEGenericTypeDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ETypeParameter");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "eBounds", lv_eBounds, "EGenericTypeDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleETypeParameterDecl


    // $ANTLR start entryRuleEGenericTypeReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2075:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2075:67: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2076:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4412);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();
            _fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4422); 

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
    // $ANTLR end entryRuleEGenericTypeReferenceDecl


    // $ANTLR start ruleEGenericTypeReferenceDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2083:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2087:6: ( ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:1: ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:1: ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==47) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2088:1: ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:2: ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:2: ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:3: ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2091:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("EGenericType");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2097:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2098:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4472); 
                     
                        createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele000CrossReferenceEStringEClassifier(), "eClassifier"); 
                        

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2103:2: ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==29) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2103:3: ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>'
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2103:3: ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2103:4: ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )*
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2103:4: ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2103:5: '<' (lv_eTypeArguments= ruleEGenericTypeDecl )
                            {
                            match(input,29,FOLLOW_29_in_ruleEGenericTypeReferenceDecl4488); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01000KeywordLessThanSign(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2107:1: (lv_eTypeArguments= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2110:6: lv_eTypeArguments= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4522);
                            lv_eTypeArguments=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("EGenericType");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.add(current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2128:3: ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==24) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2128:4: ',' (lv_eTypeArguments= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,24,FOLLOW_24_in_ruleEGenericTypeReferenceDecl4537); 

                            	            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01010KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2132:1: (lv_eTypeArguments= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2135:6: lv_eTypeArguments= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4571);
                            	    lv_eTypeArguments=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create("EGenericType");
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        
                            	    	        try {
                            	    	        	factory.add(current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop52;
                                }
                            } while (true);


                            }

                            match(input,30,FOLLOW_30_in_ruleEGenericTypeReferenceDecl4587); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele011KeywordGreaterThanSign(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2158:6: ( '#' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2158:6: ( '#' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2158:7: '#' ( ( RULE_ID ) )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeReferenceDecl4606); 

                            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele10KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2162:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2165:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("EGenericType");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2171:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2172:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4630); 
                     
                        createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
                        

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
    // $ANTLR end ruleEGenericTypeReferenceDecl


    // $ANTLR start entryRuleEGenericTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:58: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2187:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4670);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();
            _fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeDecl4680); 

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
    // $ANTLR end entryRuleEGenericTypeDecl


    // $ANTLR start ruleEGenericTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2194:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments = null;

        EObject lv_eUpperBound = null;

        EObject lv_eLowerBound = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2198:6: ( ( ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:1: ( ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:1: ( ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID||LA59_0==47) ) {
                alt59=1;
            }
            else if ( (LA59_0==49) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2199:1: ( ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) ) )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:2: ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:2: ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==RULE_ID) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==47) ) {
                        alt57=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("2199:2: ( ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )", 57, 0, input);

                        throw nvae;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:3: ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:3: ( ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )? )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:4: ( ( RULE_ID ) ) ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )?
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:4: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2202:3: ( RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("EGenericType");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2208:1: ( RULE_ID )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2209:2: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4731); 
                             
                                createLeafNode(grammarAccess.prEGenericTypeDecl().ele0000CrossReferenceEStringEClassifier(), "eClassifier"); 
                                

                            }


                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:2: ( ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>' )?
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==29) ) {
                                alt56=1;
                            }
                            switch (alt56) {
                                case 1 :
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:3: ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* ) '>'
                                    {
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:3: ( ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )* )
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:4: ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )*
                                    {
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:4: ( '<' (lv_eTypeArguments= ruleEGenericTypeDecl ) )
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:5: '<' (lv_eTypeArguments= ruleEGenericTypeDecl )
                                    {
                                    match(input,29,FOLLOW_29_in_ruleEGenericTypeDecl4747); 

                                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele001000KeywordLessThanSign(), null); 
                                        
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2218:1: (lv_eTypeArguments= ruleEGenericTypeDecl )
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2221:6: lv_eTypeArguments= ruleEGenericTypeDecl
                                    {
                                     
                                    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010010ParserRuleCallEGenericTypeDecl(), currentNode); 
                                    	    
                                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4781);
                                    lv_eTypeArguments=ruleEGenericTypeDecl();
                                    _fsp--;


                                    	        if (current==null) {
                                    	            current = factory.create("EGenericType");
                                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	        }
                                    	        
                                    	        try {
                                    	        	factory.add(current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	        currentNode = currentNode.getParent();
                                    	    

                                    }


                                    }

                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:3: ( ',' (lv_eTypeArguments= ruleEGenericTypeDecl ) )*
                                    loop55:
                                    do {
                                        int alt55=2;
                                        int LA55_0 = input.LA(1);

                                        if ( (LA55_0==24) ) {
                                            alt55=1;
                                        }


                                        switch (alt55) {
                                    	case 1 :
                                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:4: ',' (lv_eTypeArguments= ruleEGenericTypeDecl )
                                    	    {
                                    	    match(input,24,FOLLOW_24_in_ruleEGenericTypeDecl4796); 

                                    	            createLeafNode(grammarAccess.prEGenericTypeDecl().ele001010KeywordComma(), null); 
                                    	        
                                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2243:1: (lv_eTypeArguments= ruleEGenericTypeDecl )
                                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2246:6: lv_eTypeArguments= ruleEGenericTypeDecl
                                    	    {
                                    	     
                                    	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010110ParserRuleCallEGenericTypeDecl(), currentNode); 
                                    	    	    
                                    	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4830);
                                    	    lv_eTypeArguments=ruleEGenericTypeDecl();
                                    	    _fsp--;


                                    	    	        if (current==null) {
                                    	    	            current = factory.create("EGenericType");
                                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	    	        }
                                    	    	        
                                    	    	        try {
                                    	    	        	factory.add(current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
                                    	    	        } catch (ValueConverterException vce) {
                                    	    				handleValueConverterException(vce);
                                    	    	        }
                                    	    	        currentNode = currentNode.getParent();
                                    	    	    

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop55;
                                        }
                                    } while (true);


                                    }

                                    match(input,30,FOLLOW_30_in_ruleEGenericTypeDecl4846); 

                                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele0011KeywordGreaterThanSign(), null); 
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2269:6: ( '#' ( ( RULE_ID ) ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2269:6: ( '#' ( ( RULE_ID ) ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2269:7: '#' ( ( RULE_ID ) )
                            {
                            match(input,47,FOLLOW_47_in_ruleEGenericTypeDecl4865); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele010KeywordNumberSign(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2273:1: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:3: ( RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("EGenericType");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2282:1: ( RULE_ID )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2283:2: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4889); 
                             
                                createLeafNode(grammarAccess.prEGenericTypeDecl().ele0110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
                                

                            }


                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2289:6: ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2289:6: ( '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2289:7: '?' ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleEGenericTypeDecl4911); 

                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele10KeywordQuestionMark(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:1: ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==31) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==50) ) {
                        alt58=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("2293:1: ( ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) ) )", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:2: ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:2: ( 'extends' (lv_eUpperBound= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:3: 'extends' (lv_eUpperBound= ruleEGenericTypeDecl )
                            {
                            match(input,31,FOLLOW_31_in_ruleEGenericTypeDecl4922); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele1100KeywordExtends(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:1: (lv_eUpperBound= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2300:6: lv_eUpperBound= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4956);
                            lv_eUpperBound=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("EGenericType");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "eUpperBound", lv_eUpperBound, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2319:6: ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2319:6: ( 'super' (lv_eLowerBound= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2319:7: 'super' (lv_eLowerBound= ruleEGenericTypeDecl )
                            {
                            match(input,50,FOLLOW_50_in_ruleEGenericTypeDecl4977); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele1110KeywordSuper(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2323:1: (lv_eLowerBound= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2326:6: lv_eLowerBound= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl5011);
                            lv_eLowerBound=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("EGenericType");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "eLowerBound", lv_eLowerBound, "EGenericTypeDecl", currentNode);
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
    // $ANTLR end ruleEGenericTypeDecl


    // $ANTLR start entryRuleEOperationDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2353:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2353:56: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2354:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEOperationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl5053);
            iv_ruleEOperationDecl=ruleEOperationDecl();
            _fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEOperationDecl5063); 

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
    // $ANTLR end entryRuleEOperationDecl


    // $ANTLR start ruleEOperationDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:1: ruleEOperationDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )? ) ';' ) ;
    public final EObject ruleEOperationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_unique=null;
        Token lv_ordered=null;
        Token lv_name=null;
        EObject lv_eAnnotations = null;

        EObject lv_eGenericType = null;

        EObject lv_eTypeParameters = null;

        EObject lv_eParameters = null;

        EObject lv_eGenericExceptions = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2365:6: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )? ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:1: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )? ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:1: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )? ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:2: ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )? ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:2: ( ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:3: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:3: ( ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:4: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? ) ')'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:4: ( ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:5: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:5: ( ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '(' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:6: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? ) '('
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:6: ( ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:7: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:7: ( ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:8: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:8: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:9: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' ) ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:9: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:10: ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* ) 'op'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:10: ( (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:11: (lv_eAnnotations= ruleEAnnotationDecl )* ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2366:11: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==22) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2369:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele00000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl5131);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EOperation");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2387:3: ( (lv_unique= 'bag' ) | (lv_ordered= 'random' ) )*
            loop61:
            do {
                int alt61=3;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==33) ) {
                    alt61=1;
                }
                else if ( (LA61_0==34) ) {
                    alt61=2;
                }


                switch (alt61) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2387:4: (lv_unique= 'bag' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2387:4: (lv_unique= 'bag' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2389:6: lv_unique= 'bag'
            	    {
            	    lv_unique=(Token)input.LT(1);
            	    match(input,33,FOLLOW_33_in_ruleEOperationDecl5158); 

            	            createLeafNode(grammarAccess.prEOperationDecl().ele000000000100KeywordBag(), "unique"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("EOperation");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.set(current, "unique", true, "bag", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2408:6: (lv_ordered= 'random' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2408:6: (lv_ordered= 'random' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2410:6: lv_ordered= 'random'
            	    {
            	    lv_ordered=(Token)input.LT(1);
            	    match(input,34,FOLLOW_34_in_ruleEOperationDecl5197); 

            	            createLeafNode(grammarAccess.prEOperationDecl().ele000000000110KeywordRandom(), "ordered"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("EOperation");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.set(current, "ordered", true, "random", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

            match(input,51,FOLLOW_51_in_ruleEOperationDecl5221); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele000000001KeywordOp(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2432:2: ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID||LA62_0==47) ) {
                alt62=1;
            }
            else if ( (LA62_0==52) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2432:2: ( (lv_eGenericType= ruleEGenericTypeReferenceDecl ) | 'void' )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2432:3: (lv_eGenericType= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2432:3: (lv_eGenericType= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2435:6: lv_eGenericType= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000000100ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5257);
                    lv_eGenericType=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EOperation");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2454:6: 'void'
                    {
                    match(input,52,FOLLOW_52_in_ruleEOperationDecl5276); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele000000011KeywordVoid(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2458:3: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2460:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEOperationDecl5299); 
             
                createLeafNode(grammarAccess.prEOperationDecl().ele00000010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EOperation");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2478:3: ( ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2478:4: ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* ) '>'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2478:4: ( ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )* )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2478:5: ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2478:5: ( '<' (lv_eTypeParameters= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2478:6: '<' (lv_eTypeParameters= ruleETypeParameterDecl )
                    {
                    match(input,29,FOLLOW_29_in_ruleEOperationDecl5323); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele000001000KeywordLessThanSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2482:1: (lv_eTypeParameters= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2485:6: lv_eTypeParameters= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5357);
                    lv_eTypeParameters=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EOperation");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2503:3: ( ',' (lv_eTypeParameters= ruleETypeParameterDecl ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==24) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2503:4: ',' (lv_eTypeParameters= ruleETypeParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5372); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele000001010KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2507:1: (lv_eTypeParameters= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2510:6: lv_eTypeParameters= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5406);
                    	    lv_eTypeParameters=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("EOperation");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }

                    match(input,30,FOLLOW_30_in_ruleEOperationDecl5422); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele0000011KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }


            }

            match(input,23,FOLLOW_23_in_ruleEOperationDecl5434); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele00001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2536:2: ( (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID||LA66_0==22||LA66_0==47) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2536:3: (lv_eParameters= ruleEParameterDecl ) ( ',' (lv_eParameters= ruleEParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2536:3: (lv_eParameters= ruleEParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2539:6: lv_eParameters= ruleEParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele000100ParserRuleCallEParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5470);
                    lv_eParameters=ruleEParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EOperation");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "eParameters", lv_eParameters, "EParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2557:2: ( ',' (lv_eParameters= ruleEParameterDecl ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==24) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2557:3: ',' (lv_eParameters= ruleEParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5484); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2561:1: (lv_eParameters= ruleEParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2564:6: lv_eParameters= ruleEParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0001110ParserRuleCallEParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5518);
                    	    lv_eParameters=ruleEParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("EOperation");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "eParameters", lv_eParameters, "EParameterDecl", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleEOperationDecl5536); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele001KeywordRightParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2586:2: ( ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==53) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2586:3: ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2586:3: ( 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2586:4: 'throws' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl )
                    {
                    match(input,53,FOLLOW_53_in_ruleEOperationDecl5548); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele0100KeywordThrows(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2590:1: (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2593:6: lv_eGenericExceptions= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5582);
                    lv_eGenericExceptions=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("EOperation");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "eGenericExceptions", lv_eGenericExceptions, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2611:3: ( ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==24) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2611:4: ',' (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5597); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele0110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2615:1: (lv_eGenericExceptions= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2618:6: lv_eGenericExceptions= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5631);
                    	    lv_eGenericExceptions=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("EOperation");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "eGenericExceptions", lv_eGenericExceptions, "EGenericTypeReferenceDecl", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEOperationDecl5649); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEOperationDecl


    // $ANTLR start entryRuleEParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2649:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2649:56: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2650:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5684);
            iv_ruleEParameterDecl=ruleEParameterDecl();
            _fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEParameterDecl5694); 

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
    // $ANTLR end entryRuleEParameterDecl


    // $ANTLR start ruleEParameterDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2657:1: ruleEParameterDecl returns [EObject current=null] : ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) (lv_name= RULE_ID ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_eAnnotations = null;

        EObject lv_eGenericType = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2661:6: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) (lv_name= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2662:1: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) (lv_name= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2662:1: ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2662:2: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl ) ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2662:2: ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2662:3: (lv_eAnnotations= ruleEAnnotationDecl )* (lv_eGenericType= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2662:3: (lv_eAnnotations= ruleEAnnotationDecl )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==22) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2665:6: lv_eAnnotations= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5754);
            	    lv_eAnnotations=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("EParameter");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2683:3: (lv_eGenericType= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2686:6: lv_eGenericType= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5793);
            lv_eGenericType=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("EParameter");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2704:3: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2706:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEParameterDecl5819); 
             
                createLeafNode(grammarAccess.prEParameterDecl().ele10LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("EParameter");
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
    // $ANTLR end ruleEParameterDecl


    // $ANTLR start entryRuleMapEntrySuper
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2733:1: entryRuleMapEntrySuper returns [EObject current=null] : iv_ruleMapEntrySuper= ruleMapEntrySuper EOF ;
    public final EObject entryRuleMapEntrySuper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntrySuper = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2733:55: (iv_ruleMapEntrySuper= ruleMapEntrySuper EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2734:2: iv_ruleMapEntrySuper= ruleMapEntrySuper EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntrySuper().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntrySuper_in_entryRuleMapEntrySuper5865);
            iv_ruleMapEntrySuper=ruleMapEntrySuper();
            _fsp--;

             current =iv_ruleMapEntrySuper; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntrySuper5875); 

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
    // $ANTLR end entryRuleMapEntrySuper


    // $ANTLR start ruleMapEntrySuper
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2741:1: ruleMapEntrySuper returns [EObject current=null] : this_MapEntry= ruleMapEntry ;
    public final EObject ruleMapEntrySuper() throws RecognitionException {
        EObject current = null;

        EObject this_MapEntry = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2745:6: (this_MapEntry= ruleMapEntry )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2747:5: this_MapEntry= ruleMapEntry
            {
             
                    currentNode=createCompositeNode(grammarAccess.prMapEntrySuper().eleParserRuleCallMapEntry(), currentNode); 
                
            pushFollow(FOLLOW_ruleMapEntry_in_ruleMapEntrySuper5921);
            this_MapEntry=ruleMapEntry();
            _fsp--;

             
                    current = this_MapEntry; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleMapEntrySuper


    // $ANTLR start entryRuleMapEntry
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2764:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2764:50: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2765:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntry().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntry_in_entryRuleMapEntry5954);
            iv_ruleMapEntry=ruleMapEntry();
            _fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntry5964); 

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
    // $ANTLR end entryRuleMapEntry


    // $ANTLR start ruleMapEntry
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2772:1: ruleMapEntry returns [EObject current=null] : ( ( (lv_detailKey= RULE_ID ) '=' ) (lv_detailValue= RULE_STRING ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_detailKey=null;
        Token lv_detailValue=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2776:6: ( ( ( (lv_detailKey= RULE_ID ) '=' ) (lv_detailValue= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:1: ( ( (lv_detailKey= RULE_ID ) '=' ) (lv_detailValue= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:1: ( ( (lv_detailKey= RULE_ID ) '=' ) (lv_detailValue= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:2: ( (lv_detailKey= RULE_ID ) '=' ) (lv_detailValue= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:2: ( (lv_detailKey= RULE_ID ) '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:3: (lv_detailKey= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:3: (lv_detailKey= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2779:6: lv_detailKey= RULE_ID
            {
            lv_detailKey=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMapEntry6011); 
             
                createLeafNode(grammarAccess.prMapEntry().ele000LexerRuleCallID(), "detailKey"); 
                

            	        if (current==null) {
            	            current = factory.create("MapEntry");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "detailKey", lv_detailKey, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,12,FOLLOW_12_in_ruleMapEntry6031); 

                    createLeafNode(grammarAccess.prMapEntry().ele01KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2801:2: (lv_detailValue= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2803:6: lv_detailValue= RULE_STRING
            {
            lv_detailValue=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMapEntry6053); 
             
                createLeafNode(grammarAccess.prMapEntry().ele10LexerRuleCallSTRING(), "detailValue"); 
                

            	        if (current==null) {
            	            current = factory.create("MapEntry");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "detailValue", lv_detailValue, "STRING", currentNode);
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
    // $ANTLR end ruleMapEntry


    // $ANTLR start entryRuleQID
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2832:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2832:44: (iv_ruleQID= ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2833:2: iv_ruleQID= ruleQID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prQID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID6102);
            iv_ruleQID=ruleQID();
            _fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID6113); 

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
    // $ANTLR end entryRuleQID


    // $ANTLR start ruleQID
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2840:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID= RULE_ID ( (kw= '.' | kw= '$' ) this_ID= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2844:6: ( (this_ID= RULE_ID ( (kw= '.' | kw= '$' ) this_ID= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2845:1: (this_ID= RULE_ID ( (kw= '.' | kw= '$' ) this_ID= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2845:1: (this_ID= RULE_ID ( (kw= '.' | kw= '$' ) this_ID= RULE_ID )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2845:6: this_ID= RULE_ID ( (kw= '.' | kw= '$' ) this_ID= RULE_ID )*
            {
            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID6153); 

            		current.merge(this_ID);
                
             
                createLeafNode(grammarAccess.prQID().ele0LexerRuleCallID(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2852:1: ( (kw= '.' | kw= '$' ) this_ID= RULE_ID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=54 && LA71_0<=55)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2852:2: (kw= '.' | kw= '$' ) this_ID= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2852:2: (kw= '.' | kw= '$' )
            	    int alt70=2;
            	    int LA70_0 = input.LA(1);

            	    if ( (LA70_0==54) ) {
            	        alt70=1;
            	    }
            	    else if ( (LA70_0==55) ) {
            	        alt70=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("2852:2: (kw= '.' | kw= '$' )", 70, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2853:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,54,FOLLOW_54_in_ruleQID6173); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele100KeywordFullStop(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2860:2: kw= '$'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,55,FOLLOW_55_in_ruleQID6192); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele101Keyword$(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID6208); 

            	    		current.merge(this_ID);
            	        
            	     
            	        createLeafNode(grammarAccess.prQID().ele11LexerRuleCallID(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop71;
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
    // $ANTLR end ruleQID


    // $ANTLR start entryRuleSTRING_OR_QID
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2882:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2882:54: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2883:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSTRING_OR_QID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID6256);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();
            _fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_OR_QID6267); 

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
    // $ANTLR end entryRuleSTRING_OR_QID


    // $ANTLR start ruleSTRING_OR_QID
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2890:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING= RULE_STRING | this_QID= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING=null;
        AntlrDatatypeRuleToken this_QID = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2894:6: ( (this_STRING= RULE_STRING | this_QID= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2895:1: (this_STRING= RULE_STRING | this_QID= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2895:1: (this_STRING= RULE_STRING | this_QID= ruleQID )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_STRING) ) {
                alt72=1;
            }
            else if ( (LA72_0==RULE_ID) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2895:1: (this_STRING= RULE_STRING | this_QID= ruleQID )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2895:6: this_STRING= RULE_STRING
                    {
                    this_STRING=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID6307); 

                    		current.merge(this_STRING);
                        
                     
                        createLeafNode(grammarAccess.prSTRING_OR_QID().ele0LexerRuleCallSTRING(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2904:5: this_QID= ruleQID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prSTRING_OR_QID().ele1ParserRuleCallQID(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQID_in_ruleSTRING_OR_QID6340);
                    this_QID=ruleQID();
                    _fsp--;


                    		current.merge(this_QID);
                        
                     
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
    // $ANTLR end ruleSTRING_OR_QID


    // $ANTLR start entryRuleSINT
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2924:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2924:45: (iv_ruleSINT= ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2925:2: iv_ruleSINT= ruleSINT EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSINT().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSINT_in_entryRuleSINT6386);
            iv_ruleSINT=ruleSINT();
            _fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSINT6397); 

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
    // $ANTLR end entryRuleSINT


    // $ANTLR start ruleSINT
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2932:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2936:6: ( ( (kw= '-' )? this_INT= RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2937:1: ( (kw= '-' )? this_INT= RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2937:1: ( (kw= '-' )? this_INT= RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2937:2: (kw= '-' )? this_INT= RULE_INT
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2937:2: (kw= '-' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==56) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2938:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleSINT6436); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prSINT().ele0KeywordHyphenMinus(), null); 
                        

                    }
                    break;

            }

            this_INT=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSINT6453); 

            		current.merge(this_INT);
                
             
                createLeafNode(grammarAccess.prSINT().ele1LexerRuleCallINT(), null); 
                

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
    // $ANTLR end ruleSINT


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA4_eotS =
        "\20\uffff";
    static final String DFA4_eofS =
        "\20\uffff";
    static final String DFA4_minS =
        "\1\16\1\uffff\1\5\2\uffff\1\4\1\27\1\4\1\14\1\5\1\30\1\4\1\16\1"+
        "\14\1\5\1\30";
    static final String DFA4_maxS =
        "\1\60\1\uffff\1\5\2\uffff\2\27\1\4\1\14\1\5\1\31\1\4\1\60\1\14\1"+
        "\5\1\31";
    static final String DFA4_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\2\13\uffff";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\3\uffff\1\1\2\4\1\uffff\1\2\3\uffff\3\4\23\uffff\1\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6\22\uffff\1\7",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13\1\14",
            "\1\15",
            "\1\3\4\uffff\2\4\1\uffff\1\2\3\uffff\3\4\23\uffff\1\4",
            "\1\16",
            "\1\17",
            "\1\13\1\14"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 328:2: ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )*";
        }
    }
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\20\uffff";
    static final String DFA6_minS =
        "\1\16\1\uffff\1\5\2\uffff\1\4\1\27\1\4\1\14\1\5\1\30\1\4\1\16\1"+
        "\14\1\5\1\30";
    static final String DFA6_maxS =
        "\1\60\1\uffff\1\5\2\uffff\2\27\1\4\1\14\1\5\1\31\1\4\1\60\1\14\1"+
        "\5\1\31";
    static final String DFA6_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\2\13\uffff";
    static final String DFA6_specialS =
        "\20\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\3\uffff\1\1\2\4\1\uffff\1\2\3\uffff\3\4\23\uffff\1\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6\22\uffff\1\7",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13\1\14",
            "\1\15",
            "\1\3\4\uffff\2\4\1\uffff\1\2\3\uffff\3\4\23\uffff\1\4",
            "\1\16",
            "\1\17",
            "\1\13\1\14"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 446:2: ( (lv_eSubpackages= ruleSubEPackageDecl ) | (lv_eClassifiers= ruleEClassifierDecl ) )*";
        }
    }
    static final String DFA7_eotS =
        "\17\uffff";
    static final String DFA7_eofS =
        "\17\uffff";
    static final String DFA7_minS =
        "\1\23\1\5\2\uffff\1\4\1\27\1\4\1\14\1\5\1\30\1\4\1\23\1\14\1\5\1"+
        "\30";
    static final String DFA7_maxS =
        "\1\60\1\5\2\uffff\2\27\1\4\1\14\1\5\1\31\1\4\1\60\1\14\1\5\1\31";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\1\2\13\uffff";
    static final String DFA7_specialS =
        "\17\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\3\1\uffff\1\1\3\uffff\3\2\23\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5\22\uffff\1\6",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12\1\13",
            "\1\14",
            "\2\3\1\uffff\1\1\3\uffff\3\2\23\uffff\1\3",
            "\1\15",
            "\1\16",
            "\1\12\1\13"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "515:1: (this_EClassDecl= ruleEClassDecl | this_EDataTypeDecl= ruleEDataTypeDecl )";
        }
    }
    static final String DFA10_eotS =
        "\17\uffff";
    static final String DFA10_eofS =
        "\17\uffff";
    static final String DFA10_minS =
        "\1\23\1\5\2\uffff\1\4\1\27\1\4\1\14\1\5\1\30\1\4\1\23\1\14\1\5\1"+
        "\30";
    static final String DFA10_maxS =
        "\1\60\1\5\2\uffff\2\27\1\4\1\14\1\5\1\31\1\4\1\60\1\14\1\5\1\31";
    static final String DFA10_acceptS =
        "\2\uffff\1\1\1\2\13\uffff";
    static final String DFA10_specialS =
        "\17\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\2\1\uffff\1\1\31\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5\22\uffff\1\6",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12\1\13",
            "\1\14",
            "\2\2\1\uffff\1\1\31\uffff\1\3",
            "\1\15",
            "\1\16",
            "\1\12\1\13"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "556:1: ( ( ( (lv_eAnnotations= ruleEAnnotationDecl )* (lv_serializable= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name= RULE_ID ) ) ':' ) (lv_instanceClassName= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl= ruleEEnumDecl )";
        }
    }
    static final String DFA21_eotS =
        "\22\uffff";
    static final String DFA21_eofS =
        "\22\uffff";
    static final String DFA21_minS =
        "\1\22\1\uffff\1\5\1\uffff\2\40\1\uffff\1\4\1\27\1\4\1\14\1\5\1\30"+
        "\1\4\1\26\1\14\1\5\1\30";
    static final String DFA21_maxS =
        "\1\63\1\uffff\1\5\1\uffff\2\63\1\uffff\2\27\1\4\1\14\1\5\1\31\1"+
        "\4\1\63\1\14\1\5\1\31";
    static final String DFA21_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\2\uffff\1\2\13\uffff";
    static final String DFA21_specialS =
        "\22\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\3\uffff\1\2\11\uffff\1\3\1\4\1\5\6\3\3\uffff\3\3\4\uffff"+
            "\1\6",
            "",
            "\1\7",
            "",
            "\1\3\1\4\1\5\6\3\3\uffff\3\3\4\uffff\1\6",
            "\1\3\1\4\1\5\6\3\3\uffff\3\3\4\uffff\1\6",
            "",
            "\1\10\22\uffff\1\11",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15\1\16",
            "\1\17",
            "\1\2\11\uffff\1\3\1\4\1\5\6\3\3\uffff\3\3\4\uffff\1\6",
            "\1\20",
            "\1\21",
            "\1\15\1\16"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 1016:2: ( (lv_eStructuralFeatures= ruleEStructuralFeatureDecl ) | (lv_eOperations= ruleEOperationDecl ) )*";
        }
    }
    static final String DFA22_eotS =
        "\26\uffff";
    static final String DFA22_eofS =
        "\26\uffff";
    static final String DFA22_minS =
        "\1\26\1\5\1\uffff\7\40\1\uffff\1\4\1\27\1\4\1\14\1\5\1\30\1\4\1"+
        "\26\1\14\1\5\1\30";
    static final String DFA22_maxS =
        "\1\56\1\5\1\uffff\7\56\1\uffff\2\27\1\4\1\14\1\5\1\31\1\4\1\56\1"+
        "\14\1\5\1\31";
    static final String DFA22_acceptS =
        "\2\uffff\1\1\7\uffff\1\2\13\uffff";
    static final String DFA22_specialS =
        "\26\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\11\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff"+
            "\3\12",
            "\1\13",
            "",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff\3\12",
            "",
            "\1\14\22\uffff\1\15",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21\1\22",
            "\1\23",
            "\1\1\11\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\3\uffff"+
            "\3\12",
            "\1\24",
            "\1\25",
            "\1\21\1\22"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1085:1: (this_EAttributeDecl= ruleEAttributeDecl | this_EReferenceDecl= ruleEReferenceDecl )";
        }
    }
 

    public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatementDecl_in_ruleEcoreDsl141 = new BitSet(new long[]{0x0000000000404800L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatementDecl_in_entryRuleImportStatementDecl219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStatementDecl229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImportStatementDecl265 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImportStatementDecl287 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleImportStatementDecl307 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImportStatementDecl331 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleImportStatementDecl352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl466 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleEPackageDecl480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl515 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEPackageDecl529 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEPackageDecl539 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl561 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEPackageDecl582 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEPackageDecl592 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl627 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl641 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl677 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl721 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_18_in_ruleEPackageDecl737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl845 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleSubEPackageDecl859 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl881 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSubEPackageDecl902 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl938 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl982 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_18_in_ruleSubEPackageDecl998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl1033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1222 = new BitSet(new long[]{0x0000000000580000L});
    public static final BitSet FOLLOW_19_in_ruleEDataTypeDecl1248 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEDataTypeDecl1275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1296 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEDataTypeDecl1317 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1352 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEDataTypeDecl1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleEAnnotationDecl1479 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAnnotationDecl1500 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAnnotationDecl1536 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEAnnotationDecl1551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1586 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleEAnnotationDecl1601 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1635 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleEAnnotationDecl1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1763 = new BitSet(new long[]{0x000000001C400000L});
    public static final BitSet FOLLOW_26_in_ruleEClassDecl1789 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleEClassDecl1825 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1852 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1875 = new BitSet(new long[]{0x00000000A0220000L});
    public static final BitSet FOLLOW_29_in_ruleEClassDecl1899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1933 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEClassDecl1948 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1982 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEClassDecl1998 = new BitSet(new long[]{0x0000000080220000L});
    public static final BitSet FOLLOW_31_in_ruleEClassDecl2012 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2046 = new BitSet(new long[]{0x0000000001220000L});
    public static final BitSet FOLLOW_24_in_ruleEClassDecl2061 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2095 = new BitSet(new long[]{0x0000000001220000L});
    public static final BitSet FOLLOW_21_in_ruleEClassDecl2114 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2148 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEClassDecl2164 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2200 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2244 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_18_in_ruleEClassDecl2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl2423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2488 = new BitSet(new long[]{0x000001FF00400000L});
    public static final BitSet FOLLOW_32_in_ruleEAttributeDecl2521 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_33_in_ruleEAttributeDecl2560 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_34_in_ruleEAttributeDecl2600 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_35_in_ruleEAttributeDecl2640 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_36_in_ruleEAttributeDecl2680 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2720 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2760 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2800 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2824 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2859 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2876 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2897 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2919 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2953 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2969 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2993 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleEAttributeDecl3015 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl3036 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEAttributeDecl3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl3094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3169 = new BitSet(new long[]{0x000070FE00400000L});
    public static final BitSet FOLLOW_44_in_ruleEReferenceDecl3202 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_33_in_ruleEReferenceDecl3241 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_34_in_ruleEReferenceDecl3281 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_35_in_ruleEReferenceDecl3321 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_36_in_ruleEReferenceDecl3361 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_37_in_ruleEReferenceDecl3401 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_38_in_ruleEReferenceDecl3441 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_39_in_ruleEReferenceDecl3481 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_45_in_ruleEReferenceDecl3518 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_46_in_ruleEReferenceDecl3545 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3581 = new BitSet(new long[]{0x0000820000000010L});
    public static final BitSet FOLLOW_41_in_ruleEReferenceDecl3598 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl3619 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleEReferenceDecl3641 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl3675 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEReferenceDecl3691 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_47_in_ruleEReferenceDecl3704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3728 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3756 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEReferenceDecl3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3885 = new BitSet(new long[]{0x0001000000400000L});
    public static final BitSet FOLLOW_48_in_ruleEEnumDecl3899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3921 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEEnumDecl3942 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3977 = new BitSet(new long[]{0x0000000000440010L});
    public static final BitSet FOLLOW_18_in_ruleEEnumDecl3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl4027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl4099 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl4125 = new BitSet(new long[]{0x0000000000003020L});
    public static final BitSet FOLLOW_12_in_ruleEEnumLiteralDecl4147 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl4168 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEEnumLiteralDecl4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl4270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl4316 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleETypeParameterDecl4337 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4472 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleEGenericTypeReferenceDecl4488 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4522 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEGenericTypeReferenceDecl4537 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4571 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEGenericTypeReferenceDecl4587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl4606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl4680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4731 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleEGenericTypeDecl4747 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4781 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEGenericTypeDecl4796 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4830 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEGenericTypeDecl4846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl4865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl4911 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEGenericTypeDecl4922 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl4977 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl5053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl5131 = new BitSet(new long[]{0x0008000600400000L});
    public static final BitSet FOLLOW_33_in_ruleEOperationDecl5158 = new BitSet(new long[]{0x0008000600000000L});
    public static final BitSet FOLLOW_34_in_ruleEOperationDecl5197 = new BitSet(new long[]{0x0008000600000000L});
    public static final BitSet FOLLOW_51_in_ruleEOperationDecl5221 = new BitSet(new long[]{0x0010800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52_in_ruleEOperationDecl5276 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl5299 = new BitSet(new long[]{0x0000000020800000L});
    public static final BitSet FOLLOW_29_in_ruleEOperationDecl5323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5357 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5406 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEOperationDecl5422 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEOperationDecl5434 = new BitSet(new long[]{0x0000800002400010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5470 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5484 = new BitSet(new long[]{0x0000800000400010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5518 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleEOperationDecl5536 = new BitSet(new long[]{0x0020000000002000L});
    public static final BitSet FOLLOW_53_in_ruleEOperationDecl5548 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5582 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5597 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5631 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_13_in_ruleEOperationDecl5649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5754 = new BitSet(new long[]{0x0000800000400010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5793 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_entryRuleMapEntrySuper5865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntrySuper5875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleMapEntrySuper5921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry5954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry5964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry6011 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMapEntry6031 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry6053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID6102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID6153 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleQID6173 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleQID6192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID6208 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID6256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID6267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID6307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID6340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT6386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSINT6397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSINT6436 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSINT6453 = new BitSet(new long[]{0x0000000000000002L});

}
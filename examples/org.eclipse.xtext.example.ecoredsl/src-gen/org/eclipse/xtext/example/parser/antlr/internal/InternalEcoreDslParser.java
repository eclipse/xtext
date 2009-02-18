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
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEcoreDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g"; }


     
     	private EcoreDslGrammarAccess grammarAccess;
     	
        public InternalEcoreDslParser(TokenStream input, IAstFactory factory, EcoreDslGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EcoreDsl";	
       	} 



    // $ANTLR start entryRuleEcoreDsl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:70:1: entryRuleEcoreDsl returns [EObject current=null] : iv_ruleEcoreDsl= ruleEcoreDsl EOF ;
    public final EObject entryRuleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEcoreDsl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:70:50: (iv_ruleEcoreDsl= ruleEcoreDsl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:71:2: iv_ruleEcoreDsl= ruleEcoreDsl EOF
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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:78:1: ruleEcoreDsl returns [EObject current=null] : ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_package_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:6: ( ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:1: ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:1: ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:2: (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:2: (lv_imports_0= ruleImportStatementDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:87:6: lv_imports_0= ruleImportStatementDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele00ParserRuleCallImportStatementDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImportStatementDecl_in_ruleEcoreDsl141);
            	    lv_imports_0=ruleImportStatementDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEcoreDsl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "imports", lv_imports_0, "ImportStatementDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:105:3: (lv_package_1= ruleEPackageDecl )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:108:6: lv_package_1= ruleEPackageDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele10ParserRuleCallEPackageDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl180);
            lv_package_1=ruleEPackageDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEcoreDsl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "package", lv_package_1, "EPackageDecl", currentNode);
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
    // $ANTLR end ruleEcoreDsl


    // $ANTLR start entryRuleImportStatementDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:1: entryRuleImportStatementDecl returns [EObject current=null] : iv_ruleImportStatementDecl= ruleImportStatementDecl EOF ;
    public final EObject entryRuleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatementDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:61: (iv_ruleImportStatementDecl= ruleImportStatementDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:136:2: iv_ruleImportStatementDecl= ruleImportStatementDecl EOF
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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:143:1: ruleImportStatementDecl returns [EObject current=null] : ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' ) ;
    public final EObject ruleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        Token lv_alias_1=null;
        Token lv_importURI_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:148:6: ( ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:2: ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:2: ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:3: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:3: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:4: 'import' ( (lv_alias_1= RULE_ID ) '=' )?
            {
            match(input,11,FOLLOW_11_in_ruleImportStatementDecl265); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele000KeywordImport(), null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:1: ( (lv_alias_1= RULE_ID ) '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:2: (lv_alias_1= RULE_ID ) '='
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:2: (lv_alias_1= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:155:6: lv_alias_1= RULE_ID
                    {
                    lv_alias_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImportStatementDecl288); 

                    		createLeafNode(grammarAccess.prImportStatementDecl().ele00100LexerRuleCallID(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prImportStatementDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_1, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,12,FOLLOW_12_in_ruleImportStatementDecl305); 

                            createLeafNode(grammarAccess.prImportStatementDecl().ele0011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:177:4: (lv_importURI_3= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:179:6: lv_importURI_3= RULE_STRING
            {
            lv_importURI_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImportStatementDecl330); 

            		createLeafNode(grammarAccess.prImportStatementDecl().ele010LexerRuleCallSTRING(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prImportStatementDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "importURI", lv_importURI_3, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleImportStatementDecl348); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleImportStatementDecl


    // $ANTLR start entryRuleEPackageDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:210:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:210:54: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:211:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl383);
            iv_ruleEPackageDecl=ruleEPackageDecl();
            _fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageDecl393); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:218:1: ruleEPackageDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' ) ;
    public final EObject ruleEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_nsURI_5=null;
        EObject lv_eAnnotations_0 = null;

        AntlrDatatypeRuleToken lv_name_2 = null;

        AntlrDatatypeRuleToken lv_nsPrefix_8 = null;

        EObject lv_eSubpackages_10 = null;

        EObject lv_eClassifiers_11 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:223:6: ( ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:1: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:1: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:2: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:2: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:3: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:3: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:4: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:4: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:5: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:5: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '='
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:7: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:7: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:8: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:8: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:9: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '='
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:9: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:10: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:10: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:11: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:11: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:12: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:224:12: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:227:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele000000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl462);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleEPackageDecl476); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00000000001KeywordPackage(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:249:2: (lv_name_2= ruleQID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:252:6: lv_name_2= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00000000010ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl511);
            lv_name_2=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleEPackageDecl525); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele000000001KeywordNsURI(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleEPackageDecl535); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00000001KeywordEqualsSign(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:278:2: (lv_nsURI_5= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:280:6: lv_nsURI_5= RULE_STRING
            {
            lv_nsURI_5=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageDecl558); 

            		createLeafNode(grammarAccess.prEPackageDecl().ele00000010LexerRuleCallSTRING(), "nsURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "nsURI", lv_nsURI_5, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleEPackageDecl576); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele000001KeywordNsPrefix(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleEPackageDecl586); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00001KeywordEqualsSign(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:306:2: (lv_nsPrefix_8= ruleQID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:309:6: lv_nsPrefix_8= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00010ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl621);
            lv_nsPrefix_8=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "nsPrefix", lv_nsPrefix_8, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEPackageDecl635); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:331:2: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:331:3: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:331:3: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:334:6: lv_eSubpackages_10= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl671);
            	    lv_eSubpackages_10=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eSubpackages", lv_eSubpackages_10, "SubEPackageDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:353:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:353:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:356:6: lv_eClassifiers_11= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl715);
            	    lv_eClassifiers_11=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eClassifiers", lv_eClassifiers_11, "EClassifierDecl", currentNode);
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

            match(input,18,FOLLOW_18_in_ruleEPackageDecl731); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleEPackageDecl


    // $ANTLR start entryRuleSubEPackageDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:387:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:387:57: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:388:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl766);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();
            _fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubEPackageDecl776); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:395:1: ruleSubEPackageDecl returns [EObject current=null] : ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eSubpackages_4 = null;

        EObject lv_eClassifiers_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:400:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:6: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:6: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:404:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl839);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleSubEPackageDecl853); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele00001KeywordPackage(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:426:2: (lv_name_2= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:428:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubEPackageDecl876); 

            		createLeafNode(grammarAccess.prSubEPackageDecl().ele00010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleSubEPackageDecl894); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:450:2: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:450:3: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:450:3: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:453:6: lv_eSubpackages_4= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl930);
            	    lv_eSubpackages_4=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eSubpackages", lv_eSubpackages_4, "SubEPackageDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:472:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:472:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:475:6: lv_eClassifiers_5= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl974);
            	    lv_eClassifiers_5=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eClassifiers", lv_eClassifiers_5, "EClassifierDecl", currentNode);
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

            match(input,18,FOLLOW_18_in_ruleSubEPackageDecl990); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleSubEPackageDecl


    // $ANTLR start entryRuleEClassifierDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:506:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:506:57: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:507:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassifierDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl1025);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();
            _fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassifierDecl1035); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:514:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl_0 = null;

        EObject this_EDataTypeDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:519:6: ( (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:520:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:520:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:521:5: this_EClassDecl_0= ruleEClassDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele0ParserRuleCallEClassDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1082);
                    this_EClassDecl_0=ruleEClassDecl();
                    _fsp--;

                     
                            current = this_EClassDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:531:5: this_EDataTypeDecl_1= ruleEDataTypeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1109);
                    this_EDataTypeDecl_1=ruleEDataTypeDecl();
                    _fsp--;

                     
                            current = this_EDataTypeDecl_1; 
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
    // $ANTLR end ruleEClassifierDecl


    // $ANTLR start entryRuleEDataTypeDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:548:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:548:55: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:549:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEDataTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1143);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();
            _fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEDataTypeDecl1153); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:556:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable_1=null;
        Token lv_name_3=null;
        EObject lv_eAnnotations_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5 = null;

        EObject this_EEnumDecl_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:561:6: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:1: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:1: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:2: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:2: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:3: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:3: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:4: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )?
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:4: (lv_eAnnotations_0= ruleEAnnotationDecl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:565:6: lv_eAnnotations_0= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele0000ParserRuleCallEAnnotationDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1214);
                    	    lv_eAnnotations_0=ruleEAnnotationDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:583:3: (lv_serializable_1= '!serializable' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==19) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:585:6: lv_serializable_1= '!serializable'
                            {
                            lv_serializable_1=(Token)input.LT(1);
                            match(input,19,FOLLOW_19_in_ruleEDataTypeDecl1240); 

                                    createLeafNode(grammarAccess.prEDataTypeDecl().ele0010KeywordSerializable(), "serializable"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "serializable", true, "!serializable", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:4: ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:5: ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:5: ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:6: ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:6: ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:7: ( 'datatype' (lv_name_3= RULE_ID ) ) ':'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:7: ( 'datatype' (lv_name_3= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:8: 'datatype' (lv_name_3= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleEDataTypeDecl1268); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele010000KeywordDatatype(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:608:1: (lv_name_3= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:610:6: lv_name_3= RULE_ID
                    {
                    lv_name_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEDataTypeDecl1290); 

                    		createLeafNode(grammarAccess.prEDataTypeDecl().ele0100010LexerRuleCallID(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,21,FOLLOW_21_in_ruleEDataTypeDecl1308); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele01001KeywordColon(), null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:632:2: (lv_instanceClassName_5= ruleSTRING_OR_QID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:635:6: lv_instanceClassName_5= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele01010ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1343);
                    lv_instanceClassName_5=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "instanceClassName", lv_instanceClassName_5, "STRING_OR_QID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,13,FOLLOW_13_in_ruleEDataTypeDecl1357); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele011KeywordSemicolon(), null); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:659:5: this_EEnumDecl_7= ruleEEnumDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1387);
                    this_EEnumDecl_7=ruleEEnumDecl();
                    _fsp--;

                     
                            current = this_EEnumDecl_7; 
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
    // $ANTLR end ruleEDataTypeDecl


    // $ANTLR start entryRuleEAnnotationDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:676:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:676:57: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:677:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAnnotationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1421);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();
            _fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAnnotationDecl1431); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:684:1: ruleEAnnotationDecl returns [EObject current=null] : ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_source_1=null;
        EObject lv_contents_4 = null;

        EObject lv_contents_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:689:6: ( ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:1: ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:1: ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:2: ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:2: ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:3: ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:3: ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:4: ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:4: ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:5: ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '('
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:5: ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:6: ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:6: ( '@' (lv_source_1= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:690:7: '@' (lv_source_1= RULE_STRING )
            {
            match(input,22,FOLLOW_22_in_ruleEAnnotationDecl1470); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele000000KeywordCommercialAt(), null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:694:1: (lv_source_1= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:696:6: lv_source_1= RULE_STRING
            {
            lv_source_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAnnotationDecl1492); 

            		createLeafNode(grammarAccess.prEAnnotationDecl().ele0000010LexerRuleCallSTRING(), "source"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "source", lv_source_1, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:714:3: ( RULE_ID )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:717:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAnnotationDecl1523); 

                    		createLeafNode(grammarAccess.prEAnnotationDecl().ele000010CrossReferenceEStringEModelElement(), "eModelElement"); 
                    	

                    }
                    break;

            }


            }

            match(input,23,FOLLOW_23_in_ruleEAnnotationDecl1537); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:734:2: (lv_contents_4= ruleMapEntrySuper )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:737:6: lv_contents_4= ruleMapEntrySuper
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0010ParserRuleCallMapEntrySuper(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1572);
            lv_contents_4=ruleMapEntrySuper();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "contents", lv_contents_4, "MapEntrySuper", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:755:3: ( ',' (lv_contents_6= ruleMapEntrySuper ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:755:4: ',' (lv_contents_6= ruleMapEntrySuper )
            	    {
            	    match(input,24,FOLLOW_24_in_ruleEAnnotationDecl1587); 

            	            createLeafNode(grammarAccess.prEAnnotationDecl().ele010KeywordComma(), null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:759:1: (lv_contents_6= ruleMapEntrySuper )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:762:6: lv_contents_6= ruleMapEntrySuper
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0110ParserRuleCallMapEntrySuper(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1621);
            	    lv_contents_6=ruleMapEntrySuper();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "contents", lv_contents_6, "MapEntrySuper", currentNode);
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

            match(input,25,FOLLOW_25_in_ruleEAnnotationDecl1637); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleEAnnotationDecl


    // $ANTLR start entryRuleEClassDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:793:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:793:52: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:794:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1672);
            iv_ruleEClassDecl=ruleEClassDecl();
            _fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassDecl1682); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:1: ruleEClassDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' ) ;
    public final EObject ruleEClassDecl() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1=null;
        Token lv_interface_2=null;
        Token lv_name_4=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eTypeParameters_6 = null;

        EObject lv_eTypeParameters_8 = null;

        EObject lv_eGenericSuperTypes_11 = null;

        EObject lv_eGenericSuperTypes_13 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_15 = null;

        EObject lv_eStructuralFeatures_17 = null;

        EObject lv_eOperations_18 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:806:6: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:1: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:1: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:2: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:2: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:3: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:3: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:4: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:4: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:5: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:5: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:6: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:6: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:7: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:7: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:8: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:8: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:9: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:9: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:10: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:10: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:810:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1749);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:828:3: (lv_abstract_1= 'abstract' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:830:6: lv_abstract_1= 'abstract'
                    {
                    lv_abstract_1=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleEClassDecl1775); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000000010KeywordAbstract(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:849:4: ( (lv_interface_2= 'interface' ) | 'class' )
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
                    new NoViableAltException("849:4: ( (lv_interface_2= 'interface' ) | 'class' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:849:5: (lv_interface_2= 'interface' )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:849:5: (lv_interface_2= 'interface' )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:851:6: lv_interface_2= 'interface'
                    {
                    lv_interface_2=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleEClassDecl1812); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000000100KeywordInterface(), "interface"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "interface", true, "interface", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:871:6: 'class'
                    {
                    match(input,28,FOLLOW_28_in_ruleEClassDecl1840); 

                            createLeafNode(grammarAccess.prEClassDecl().ele000000011KeywordClass(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:875:3: (lv_name_4= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:877:6: lv_name_4= RULE_ID
            {
            lv_name_4=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEClassDecl1864); 

            		createLeafNode(grammarAccess.prEClassDecl().ele00000010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_4, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:3: ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:4: ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:4: ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:5: ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:5: ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:6: '<' (lv_eTypeParameters_6= ruleETypeParameterDecl )
                    {
                    match(input,29,FOLLOW_29_in_ruleEClassDecl1885); 

                            createLeafNode(grammarAccess.prEClassDecl().ele000001000KeywordLessThanSign(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:899:1: (lv_eTypeParameters_6= ruleETypeParameterDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:902:6: lv_eTypeParameters_6= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1919);
                    lv_eTypeParameters_6=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eTypeParameters", lv_eTypeParameters_6, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:920:3: ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==24) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:920:4: ',' (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEClassDecl1934); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele000001010KeywordComma(), null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:924:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:927:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1968);
                    	    lv_eTypeParameters_8=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "eTypeParameters", lv_eTypeParameters_8, "ETypeParameterDecl", currentNode);
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

                    match(input,30,FOLLOW_30_in_ruleEClassDecl1984); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000011KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:949:4: ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:949:5: ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:949:5: ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:949:6: 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl )
                    {
                    match(input,31,FOLLOW_31_in_ruleEClassDecl1998); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000100KeywordExtends(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:953:1: (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:956:6: lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2032);
                    lv_eGenericSuperTypes_11=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eGenericSuperTypes", lv_eGenericSuperTypes_11, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:974:3: ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:974:4: ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEClassDecl2047); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele0000110KeywordComma(), null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:978:1: (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:981:6: lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2081);
                    	    lv_eGenericSuperTypes_13=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "eGenericSuperTypes", lv_eGenericSuperTypes_13, "EGenericTypeReferenceDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:999:7: ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:999:8: ':' (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    {
                    match(input,21,FOLLOW_21_in_ruleEClassDecl2100); 

                            createLeafNode(grammarAccess.prEClassDecl().ele00010KeywordColon(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1003:1: (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1006:6: lv_instanceClassName_15= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele000110ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2134);
                    lv_instanceClassName_15=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "instanceClassName", lv_instanceClassName_15, "STRING_OR_QID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,17,FOLLOW_17_in_ruleEClassDecl2150); 

                    createLeafNode(grammarAccess.prEClassDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1028:2: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1028:3: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1028:3: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1031:6: lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0100ParserRuleCallEStructuralFeatureDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2186);
            	    lv_eStructuralFeatures_17=ruleEStructuralFeatureDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eStructuralFeatures", lv_eStructuralFeatures_17, "EStructuralFeatureDecl", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1050:6: (lv_eOperations_18= ruleEOperationDecl )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1050:6: (lv_eOperations_18= ruleEOperationDecl )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1053:6: lv_eOperations_18= ruleEOperationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0110ParserRuleCallEOperationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2230);
            	    lv_eOperations_18=ruleEOperationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eOperations", lv_eOperations_18, "EOperationDecl", currentNode);
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

            match(input,18,FOLLOW_18_in_ruleEClassDecl2246); 

                    createLeafNode(grammarAccess.prEClassDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleEClassDecl


    // $ANTLR start entryRuleEStructuralFeatureDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1084:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1084:64: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1085:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEStructuralFeatureDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2281);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();
            _fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2291); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1092:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl_0 = null;

        EObject this_EReferenceDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1097:6: ( (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1098:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1098:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1099:5: this_EAttributeDecl_0= ruleEAttributeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2338);
                    this_EAttributeDecl_0=ruleEAttributeDecl();
                    _fsp--;

                     
                            current = this_EAttributeDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1109:5: this_EReferenceDecl_1= ruleEReferenceDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2365);
                    this_EReferenceDecl_1=ruleEReferenceDecl();
                    _fsp--;

                     
                            current = this_EReferenceDecl_1; 
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
    // $ANTLR end ruleEStructuralFeatureDecl


    // $ANTLR start entryRuleEAttributeDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1126:56: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1127:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAttributeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2399);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();
            _fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAttributeDecl2409); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1134:1: ruleEAttributeDecl returns [EObject current=null] : ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' ) ;
    public final EObject ruleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_iD_1=null;
        Token lv_unique_2=null;
        Token lv_ordered_3=null;
        Token lv_changeable_4=null;
        Token lv_volatile_5=null;
        Token lv_transient_6=null;
        Token lv_unsettable_7=null;
        Token lv_derived_8=null;
        Token lv_lowerBound_12=null;
        Token lv_name_16=null;
        Token lv_defaultValueLiteral_18=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_10 = null;

        AntlrDatatypeRuleToken lv_upperBound_14 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1139:6: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:8: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1140:8: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==22) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1143:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2474);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:3: ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
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
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:4: ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:4: ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
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
            	            new NoViableAltException("1161:4: ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )", 29, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:5: ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
            	            {
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:5: ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
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
            	                    new NoViableAltException("1161:5: ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )", 28, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:6: ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
            	                    {
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:6: ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
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
            	                            new NoViableAltException("1161:6: ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )", 27, 0, input);

            	                        throw nvae;
            	                    }
            	                    switch (alt27) {
            	                        case 1 :
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:7: ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
            	                            {
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:7: ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
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
            	                                    new NoViableAltException("1161:7: ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )", 26, 0, input);

            	                                throw nvae;
            	                            }
            	                            switch (alt26) {
            	                                case 1 :
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:8: ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
            	                                    {
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:8: ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
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
            	                                            new NoViableAltException("1161:8: ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )", 25, 0, input);

            	                                        throw nvae;
            	                                    }
            	                                    switch (alt25) {
            	                                        case 1 :
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:9: ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) )
            	                                            {
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:9: ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) )
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
            	                                                    new NoViableAltException("1161:9: ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) )", 24, 0, input);

            	                                                throw nvae;
            	                                            }
            	                                            switch (alt24) {
            	                                                case 1 :
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:10: (lv_iD_1= 'ID' )
            	                                                    {
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1161:10: (lv_iD_1= 'ID' )
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1163:6: lv_iD_1= 'ID'
            	                                                    {
            	                                                    lv_iD_1=(Token)input.LT(1);
            	                                                    match(input,32,FOLLOW_32_in_ruleEAttributeDecl2507); 

            	                                                            createLeafNode(grammarAccess.prEAttributeDecl().ele000000100000000KeywordID(), "iD"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	       		set(current, "iD", true, "ID", lastConsumedNode);
            	                                                    	        } catch (ValueConverterException vce) {
            	                                                    				handleValueConverterException(vce);
            	                                                    	        }
            	                                                    	    

            	                                                    }


            	                                                    }
            	                                                    break;
            	                                                case 2 :
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1183:6: (lv_unique_2= 'bag' )
            	                                                    {
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1183:6: (lv_unique_2= 'bag' )
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1185:6: lv_unique_2= 'bag'
            	                                                    {
            	                                                    lv_unique_2=(Token)input.LT(1);
            	                                                    match(input,33,FOLLOW_33_in_ruleEAttributeDecl2547); 

            	                                                            createLeafNode(grammarAccess.prEAttributeDecl().ele000000100000010KeywordBag(), "unique"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	       		set(current, "unique", true, "bag", lastConsumedNode);
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
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1205:6: (lv_ordered_3= 'random' )
            	                                            {
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1205:6: (lv_ordered_3= 'random' )
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1207:6: lv_ordered_3= 'random'
            	                                            {
            	                                            lv_ordered_3=(Token)input.LT(1);
            	                                            match(input,34,FOLLOW_34_in_ruleEAttributeDecl2588); 

            	                                                    createLeafNode(grammarAccess.prEAttributeDecl().ele00000010000010KeywordRandom(), "ordered"); 
            	                                                

            	                                            	        if (current==null) {
            	                                            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	                                            	            associateNodeWithAstElement(currentNode, current);
            	                                            	        }
            	                                            	        
            	                                            	        try {
            	                                            	       		set(current, "ordered", true, "random", lastConsumedNode);
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
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1227:6: (lv_changeable_4= 'readonly' )
            	                                    {
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1227:6: (lv_changeable_4= 'readonly' )
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1229:6: lv_changeable_4= 'readonly'
            	                                    {
            	                                    lv_changeable_4=(Token)input.LT(1);
            	                                    match(input,35,FOLLOW_35_in_ruleEAttributeDecl2629); 

            	                                            createLeafNode(grammarAccess.prEAttributeDecl().ele0000001000010KeywordReadonly(), "changeable"); 
            	                                        

            	                                    	        if (current==null) {
            	                                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	                                    	            associateNodeWithAstElement(currentNode, current);
            	                                    	        }
            	                                    	        
            	                                    	        try {
            	                                    	       		set(current, "changeable", true, "readonly", lastConsumedNode);
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
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1249:6: (lv_volatile_5= 'volatile' )
            	                            {
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1249:6: (lv_volatile_5= 'volatile' )
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1251:6: lv_volatile_5= 'volatile'
            	                            {
            	                            lv_volatile_5=(Token)input.LT(1);
            	                            match(input,36,FOLLOW_36_in_ruleEAttributeDecl2670); 

            	                                    createLeafNode(grammarAccess.prEAttributeDecl().ele000000100010KeywordVolatile(), "volatile"); 
            	                                

            	                            	        if (current==null) {
            	                            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	                            	            associateNodeWithAstElement(currentNode, current);
            	                            	        }
            	                            	        
            	                            	        try {
            	                            	       		set(current, "volatile", true, "volatile", lastConsumedNode);
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
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1271:6: (lv_transient_6= 'transient' )
            	                    {
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1271:6: (lv_transient_6= 'transient' )
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1273:6: lv_transient_6= 'transient'
            	                    {
            	                    lv_transient_6=(Token)input.LT(1);
            	                    match(input,37,FOLLOW_37_in_ruleEAttributeDecl2711); 

            	                            createLeafNode(grammarAccess.prEAttributeDecl().ele00000010010KeywordTransient(), "transient"); 
            	                        

            	                    	        if (current==null) {
            	                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	                    	            associateNodeWithAstElement(currentNode, current);
            	                    	        }
            	                    	        
            	                    	        try {
            	                    	       		set(current, "transient", true, "transient", lastConsumedNode);
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
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1293:6: (lv_unsettable_7= 'unsettable' )
            	            {
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1293:6: (lv_unsettable_7= 'unsettable' )
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1295:6: lv_unsettable_7= 'unsettable'
            	            {
            	            lv_unsettable_7=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleEAttributeDecl2752); 

            	                    createLeafNode(grammarAccess.prEAttributeDecl().ele0000001010KeywordUnsettable(), "unsettable"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "unsettable", true, "unsettable", lastConsumedNode);
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
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1315:6: (lv_derived_8= 'derived' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1315:6: (lv_derived_8= 'derived' )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1317:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEAttributeDecl2793); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele000000110KeywordDerived(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "derived", true, "derived", lastConsumedNode);
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

            match(input,40,FOLLOW_40_in_ruleEAttributeDecl2818); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele000001KeywordAttr(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1340:2: (lv_eGenericType_10= ruleEGenericTypeReferenceDecl )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1343:6: lv_eGenericType_10= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2853);
            lv_eGenericType_10=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_10, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:3: ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==41) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:4: ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:4: ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:5: ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )?
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:5: ( '[' (lv_lowerBound_12= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:6: '[' (lv_lowerBound_12= RULE_INT )
                    {
                    match(input,41,FOLLOW_41_in_ruleEAttributeDecl2870); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele0001000KeywordLeftSquareBracket(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1365:1: (lv_lowerBound_12= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1367:6: lv_lowerBound_12= RULE_INT
                    {
                    lv_lowerBound_12=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEAttributeDecl2892); 

                    		createLeafNode(grammarAccess.prEAttributeDecl().ele00010010LexerRuleCallINT(), "lowerBound"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "lowerBound", lv_lowerBound_12, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1385:3: ( '..' (lv_upperBound_14= ruleSINT ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==42) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1385:4: '..' (lv_upperBound_14= ruleSINT )
                            {
                            match(input,42,FOLLOW_42_in_ruleEAttributeDecl2911); 

                                    createLeafNode(grammarAccess.prEAttributeDecl().ele0001010KeywordFullStopFullStop(), null); 
                                
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1389:1: (lv_upperBound_14= ruleSINT )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1392:6: lv_upperBound_14= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00010110ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEAttributeDecl2945);
                            lv_upperBound_14=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "upperBound", lv_upperBound_14, "SINT", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    match(input,43,FOLLOW_43_in_ruleEAttributeDecl2961); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele00011KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1414:4: (lv_name_16= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1416:6: lv_name_16= RULE_ID
            {
            lv_name_16=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAttributeDecl2986); 

            		createLeafNode(grammarAccess.prEAttributeDecl().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_16, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1434:3: ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==12) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1434:4: '=' (lv_defaultValueLiteral_18= RULE_STRING )
                    {
                    match(input,12,FOLLOW_12_in_ruleEAttributeDecl3005); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele010KeywordEqualsSign(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1438:1: (lv_defaultValueLiteral_18= RULE_STRING )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1440:6: lv_defaultValueLiteral_18= RULE_STRING
                    {
                    lv_defaultValueLiteral_18=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAttributeDecl3027); 

                    		createLeafNode(grammarAccess.prEAttributeDecl().ele0110LexerRuleCallSTRING(), "defaultValueLiteral"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "defaultValueLiteral", lv_defaultValueLiteral_18, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEAttributeDecl3047); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEAttributeDecl


    // $ANTLR start entryRuleEReferenceDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1471:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1471:56: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1472:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl3082);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();
            _fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEReferenceDecl3092); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1479:1: ruleEReferenceDecl returns [EObject current=null] : ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' ) ;
    public final EObject ruleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        Token lv_resolveProxies_1=null;
        Token lv_unique_2=null;
        Token lv_ordered_3=null;
        Token lv_changeable_4=null;
        Token lv_volatile_5=null;
        Token lv_transient_6=null;
        Token lv_unsettable_7=null;
        Token lv_derived_8=null;
        Token lv_containment_9=null;
        Token lv_lowerBound_13=null;
        Token lv_name_19=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_11 = null;

        AntlrDatatypeRuleToken lv_upperBound_15 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1484:6: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:8: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1485:8: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==22) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1488:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3157);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:3: ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
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
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:4: ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:4: ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
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
            	            new NoViableAltException("1506:4: ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )", 40, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:5: ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
            	            {
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:5: ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
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
            	                    new NoViableAltException("1506:5: ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )", 39, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt39) {
            	                case 1 :
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:6: ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
            	                    {
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:6: ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
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
            	                            new NoViableAltException("1506:6: ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )", 38, 0, input);

            	                        throw nvae;
            	                    }
            	                    switch (alt38) {
            	                        case 1 :
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:7: ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
            	                            {
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:7: ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
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
            	                                    new NoViableAltException("1506:7: ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )", 37, 0, input);

            	                                throw nvae;
            	                            }
            	                            switch (alt37) {
            	                                case 1 :
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:8: ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
            	                                    {
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:8: ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
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
            	                                            new NoViableAltException("1506:8: ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )", 36, 0, input);

            	                                        throw nvae;
            	                                    }
            	                                    switch (alt36) {
            	                                        case 1 :
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:9: ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) )
            	                                            {
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:9: ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) )
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
            	                                                    new NoViableAltException("1506:9: ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) )", 35, 0, input);

            	                                                throw nvae;
            	                                            }
            	                                            switch (alt35) {
            	                                                case 1 :
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:10: (lv_resolveProxies_1= 'local' )
            	                                                    {
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1506:10: (lv_resolveProxies_1= 'local' )
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1508:6: lv_resolveProxies_1= 'local'
            	                                                    {
            	                                                    lv_resolveProxies_1=(Token)input.LT(1);
            	                                                    match(input,44,FOLLOW_44_in_ruleEReferenceDecl3190); 

            	                                                            createLeafNode(grammarAccess.prEReferenceDecl().ele000000100000000KeywordLocal(), "resolveProxies"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	       		set(current, "resolveProxies", true, "local", lastConsumedNode);
            	                                                    	        } catch (ValueConverterException vce) {
            	                                                    				handleValueConverterException(vce);
            	                                                    	        }
            	                                                    	    

            	                                                    }


            	                                                    }
            	                                                    break;
            	                                                case 2 :
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1528:6: (lv_unique_2= 'bag' )
            	                                                    {
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1528:6: (lv_unique_2= 'bag' )
            	                                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1530:6: lv_unique_2= 'bag'
            	                                                    {
            	                                                    lv_unique_2=(Token)input.LT(1);
            	                                                    match(input,33,FOLLOW_33_in_ruleEReferenceDecl3230); 

            	                                                            createLeafNode(grammarAccess.prEReferenceDecl().ele000000100000010KeywordBag(), "unique"); 
            	                                                        

            	                                                    	        if (current==null) {
            	                                                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	                                                    	            associateNodeWithAstElement(currentNode, current);
            	                                                    	        }
            	                                                    	        
            	                                                    	        try {
            	                                                    	       		set(current, "unique", true, "bag", lastConsumedNode);
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
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1550:6: (lv_ordered_3= 'random' )
            	                                            {
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1550:6: (lv_ordered_3= 'random' )
            	                                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1552:6: lv_ordered_3= 'random'
            	                                            {
            	                                            lv_ordered_3=(Token)input.LT(1);
            	                                            match(input,34,FOLLOW_34_in_ruleEReferenceDecl3271); 

            	                                                    createLeafNode(grammarAccess.prEReferenceDecl().ele00000010000010KeywordRandom(), "ordered"); 
            	                                                

            	                                            	        if (current==null) {
            	                                            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	                                            	            associateNodeWithAstElement(currentNode, current);
            	                                            	        }
            	                                            	        
            	                                            	        try {
            	                                            	       		set(current, "ordered", true, "random", lastConsumedNode);
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
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1572:6: (lv_changeable_4= 'readonly' )
            	                                    {
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1572:6: (lv_changeable_4= 'readonly' )
            	                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1574:6: lv_changeable_4= 'readonly'
            	                                    {
            	                                    lv_changeable_4=(Token)input.LT(1);
            	                                    match(input,35,FOLLOW_35_in_ruleEReferenceDecl3312); 

            	                                            createLeafNode(grammarAccess.prEReferenceDecl().ele0000001000010KeywordReadonly(), "changeable"); 
            	                                        

            	                                    	        if (current==null) {
            	                                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	                                    	            associateNodeWithAstElement(currentNode, current);
            	                                    	        }
            	                                    	        
            	                                    	        try {
            	                                    	       		set(current, "changeable", true, "readonly", lastConsumedNode);
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
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1594:6: (lv_volatile_5= 'volatile' )
            	                            {
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1594:6: (lv_volatile_5= 'volatile' )
            	                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1596:6: lv_volatile_5= 'volatile'
            	                            {
            	                            lv_volatile_5=(Token)input.LT(1);
            	                            match(input,36,FOLLOW_36_in_ruleEReferenceDecl3353); 

            	                                    createLeafNode(grammarAccess.prEReferenceDecl().ele000000100010KeywordVolatile(), "volatile"); 
            	                                

            	                            	        if (current==null) {
            	                            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	                            	            associateNodeWithAstElement(currentNode, current);
            	                            	        }
            	                            	        
            	                            	        try {
            	                            	       		set(current, "volatile", true, "volatile", lastConsumedNode);
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
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1616:6: (lv_transient_6= 'transient' )
            	                    {
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1616:6: (lv_transient_6= 'transient' )
            	                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1618:6: lv_transient_6= 'transient'
            	                    {
            	                    lv_transient_6=(Token)input.LT(1);
            	                    match(input,37,FOLLOW_37_in_ruleEReferenceDecl3394); 

            	                            createLeafNode(grammarAccess.prEReferenceDecl().ele00000010010KeywordTransient(), "transient"); 
            	                        

            	                    	        if (current==null) {
            	                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	                    	            associateNodeWithAstElement(currentNode, current);
            	                    	        }
            	                    	        
            	                    	        try {
            	                    	       		set(current, "transient", true, "transient", lastConsumedNode);
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
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1638:6: (lv_unsettable_7= 'unsettable' )
            	            {
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1638:6: (lv_unsettable_7= 'unsettable' )
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1640:6: lv_unsettable_7= 'unsettable'
            	            {
            	            lv_unsettable_7=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleEReferenceDecl3435); 

            	                    createLeafNode(grammarAccess.prEReferenceDecl().ele0000001010KeywordUnsettable(), "unsettable"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "unsettable", true, "unsettable", lastConsumedNode);
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
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1660:6: (lv_derived_8= 'derived' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1660:6: (lv_derived_8= 'derived' )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1662:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEReferenceDecl3476); 

            	            createLeafNode(grammarAccess.prEReferenceDecl().ele000000110KeywordDerived(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "derived", true, "derived", lastConsumedNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1681:5: ( (lv_containment_9= 'val' ) | 'ref' )
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
                    new NoViableAltException("1681:5: ( (lv_containment_9= 'val' ) | 'ref' )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1681:6: (lv_containment_9= 'val' )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1681:6: (lv_containment_9= 'val' )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1683:6: lv_containment_9= 'val'
                    {
                    lv_containment_9=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleEReferenceDecl3514); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele00000100KeywordVal(), "containment"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "containment", true, "val", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1703:6: 'ref'
                    {
                    match(input,46,FOLLOW_46_in_ruleEReferenceDecl3542); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0000011KeywordRef(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1707:3: (lv_eGenericType_11= ruleEGenericTypeReferenceDecl )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1710:6: lv_eGenericType_11= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3578);
            lv_eGenericType_11=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_11, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:3: ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==41) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:4: ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:4: ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:5: ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )?
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:5: ( '[' (lv_lowerBound_13= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:6: '[' (lv_lowerBound_13= RULE_INT )
                    {
                    match(input,41,FOLLOW_41_in_ruleEReferenceDecl3595); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0001000KeywordLeftSquareBracket(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1732:1: (lv_lowerBound_13= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1734:6: lv_lowerBound_13= RULE_INT
                    {
                    lv_lowerBound_13=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEReferenceDecl3617); 

                    		createLeafNode(grammarAccess.prEReferenceDecl().ele00010010LexerRuleCallINT(), "lowerBound"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "lowerBound", lv_lowerBound_13, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1752:3: ( '..' (lv_upperBound_15= ruleSINT ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==42) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1752:4: '..' (lv_upperBound_15= ruleSINT )
                            {
                            match(input,42,FOLLOW_42_in_ruleEReferenceDecl3636); 

                                    createLeafNode(grammarAccess.prEReferenceDecl().ele0001010KeywordFullStopFullStop(), null); 
                                
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1756:1: (lv_upperBound_15= ruleSINT )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1759:6: lv_upperBound_15= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00010110ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEReferenceDecl3670);
                            lv_upperBound_15=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "upperBound", lv_upperBound_15, "SINT", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    match(input,43,FOLLOW_43_in_ruleEReferenceDecl3686); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele00011KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1781:4: ( '#' ( RULE_ID ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1781:5: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEReferenceDecl3699); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0010KeywordNumberSign(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1785:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1788:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3721); 

                    		createLeafNode(grammarAccess.prEReferenceDecl().ele00110CrossReferenceEStringEReference(), "eOpposite"); 
                    	

                    }


                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:5: (lv_name_19= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1803:6: lv_name_19= RULE_ID
            {
            lv_name_19=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3749); 

            		createLeafNode(grammarAccess.prEReferenceDecl().ele010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_19, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEReferenceDecl3767); 

                    createLeafNode(grammarAccess.prEReferenceDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEReferenceDecl


    // $ANTLR start entryRuleEEnumDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1834:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1834:51: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1835:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3802);
            iv_ruleEEnumDecl=ruleEEnumDecl();
            _fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumDecl3812); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1842:1: ruleEEnumDecl returns [EObject current=null] : ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eLiterals_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1847:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:6: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:6: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==22) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1851:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3875);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEEnumDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            match(input,48,FOLLOW_48_in_ruleEEnumDecl3889); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele00001KeywordEnum(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1873:2: (lv_name_2= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1875:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumDecl3912); 

            		createLeafNode(grammarAccess.prEEnumDecl().ele00010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEEnumDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEEnumDecl3930); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1897:2: (lv_eLiterals_4= ruleEEnumLiteralDecl )+
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
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1900:6: lv_eLiterals_4= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele010ParserRuleCallEEnumLiteralDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3965);
            	    lv_eLiterals_4=ruleEEnumLiteralDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEEnumDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eLiterals", lv_eLiterals_4, "EEnumLiteralDecl", currentNode);
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

            match(input,18,FOLLOW_18_in_ruleEEnumDecl3980); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleEEnumDecl


    // $ANTLR start entryRuleEEnumLiteralDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1931:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1931:58: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumLiteralDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl4015);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();
            _fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumLiteralDecl4025); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1939:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_value_3=null;
        Token lv_literal_4=null;
        EObject lv_eAnnotations_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1944:6: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:1: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:1: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:2: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:2: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:3: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:3: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:4: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:4: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:5: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:5: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==22) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1948:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumLiteralDecl().ele00000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl4087);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1966:3: (lv_name_1= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1968:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl4114); 

            		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1986:3: ( '=' (lv_value_3= RULE_INT ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==12) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1986:4: '=' (lv_value_3= RULE_INT )
                    {
                    match(input,12,FOLLOW_12_in_ruleEEnumLiteralDecl4133); 

                            createLeafNode(grammarAccess.prEEnumLiteralDecl().ele0010KeywordEqualsSign(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1990:1: (lv_value_3= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1992:6: lv_value_3= RULE_INT
                    {
                    lv_value_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl4155); 

                    		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00110LexerRuleCallINT(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_3, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2010:5: (lv_literal_4= RULE_STRING )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_STRING) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2012:6: lv_literal_4= RULE_STRING
                    {
                    lv_literal_4=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4188); 

                    		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele010LexerRuleCallSTRING(), "literal"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "literal", lv_literal_4, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEEnumLiteralDecl4207); 

                    createLeafNode(grammarAccess.prEEnumLiteralDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEEnumLiteralDecl


    // $ANTLR start entryRuleETypeParameterDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2043:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2043:60: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2044:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prETypeParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4242);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();
            _fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleETypeParameterDecl4252); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2051:1: ruleETypeParameterDecl returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_eBounds_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2056:6: ( ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2057:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2057:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2057:2: (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2057:2: (lv_name_0= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2059:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleETypeParameterDecl4299); 

            		createLeafNode(grammarAccess.prETypeParameterDecl().ele00LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prETypeParameterDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2077:2: ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==31) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2077:3: 'extends' (lv_eBounds_2= ruleEGenericTypeDecl )
                    {
                    match(input,31,FOLLOW_31_in_ruleETypeParameterDecl4317); 

                            createLeafNode(grammarAccess.prETypeParameterDecl().ele10KeywordExtends(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2081:1: (lv_eBounds_2= ruleEGenericTypeDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2084:6: lv_eBounds_2= ruleEGenericTypeDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prETypeParameterDecl().ele110ParserRuleCallEGenericTypeDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4351);
                    lv_eBounds_2=ruleEGenericTypeDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prETypeParameterDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eBounds", lv_eBounds_2, "EGenericTypeDecl", currentNode);
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
    // $ANTLR end ruleETypeParameterDecl


    // $ANTLR start entryRuleEGenericTypeReferenceDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2111:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2111:67: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2112:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4392);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();
            _fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4402); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2119:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:6: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2125:1: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2125:1: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
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
                    new NoViableAltException("2125:1: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2125:2: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2125:2: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2125:3: ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2125:3: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2128:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4450); 

                    		createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele000CrossReferenceEStringEClassifier(), "eClassifier"); 
                    	

                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:2: ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==29) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>'
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:5: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            {
                            match(input,29,FOLLOW_29_in_ruleEGenericTypeReferenceDecl4465); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01000KeywordLessThanSign(), null); 
                                
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2145:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2148:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4499);
                            lv_eTypeArguments_2=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "eTypeArguments", lv_eTypeArguments_2, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2166:3: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==24) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2166:4: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,24,FOLLOW_24_in_ruleEGenericTypeReferenceDecl4514); 

                            	            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01010KeywordComma(), null); 
                            	        
                            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2170:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2173:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4548);
                            	    lv_eTypeArguments_4=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        
                            	    	        try {
                            	    	       		add(current, "eTypeArguments", lv_eTypeArguments_4, "EGenericTypeDecl", currentNode);
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

                            match(input,30,FOLLOW_30_in_ruleEGenericTypeReferenceDecl4564); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele011KeywordGreaterThanSign(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2196:6: ( '#' ( RULE_ID ) )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2196:6: ( '#' ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2196:7: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeReferenceDecl4583); 

                            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele10KeywordNumberSign(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2200:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2203:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4605); 

                    		createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
                    	

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
    // $ANTLR end ruleEGenericTypeReferenceDecl


    // $ANTLR start entryRuleEGenericTypeDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2225:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2225:58: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2226:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4644);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();
            _fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeDecl4654); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2233:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;

        EObject lv_eUpperBound_10 = null;

        EObject lv_eLowerBound_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:6: ( ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:1: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:1: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
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
                    new NoViableAltException("2239:1: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:2: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:2: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
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
                            new NoViableAltException("2239:2: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )", 57, 0, input);

                        throw nvae;
                    }
                    switch (alt57) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:3: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:3: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:4: ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2239:4: ( RULE_ID )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2242:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4703); 

                            		createLeafNode(grammarAccess.prEGenericTypeDecl().ele0000CrossReferenceEStringEClassifier(), "eClassifier"); 
                            	

                            }

                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:2: ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==29) ) {
                                alt56=1;
                            }
                            switch (alt56) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>'
                                    {
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* )
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                                    {
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) )
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:5: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                                    {
                                    match(input,29,FOLLOW_29_in_ruleEGenericTypeDecl4718); 

                                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele001000KeywordLessThanSign(), null); 
                                        
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2262:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                                    {
                                     
                                    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010010ParserRuleCallEGenericTypeDecl(), currentNode); 
                                    	    
                                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4752);
                                    lv_eTypeArguments_2=ruleEGenericTypeDecl();
                                    _fsp--;


                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		add(current, "eTypeArguments", lv_eTypeArguments_2, "EGenericTypeDecl", currentNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	        currentNode = currentNode.getParent();
                                    	    

                                    }


                                    }

                                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:3: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                                    loop55:
                                    do {
                                        int alt55=2;
                                        int LA55_0 = input.LA(1);

                                        if ( (LA55_0==24) ) {
                                            alt55=1;
                                        }


                                        switch (alt55) {
                                    	case 1 :
                                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:4: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                                    	    {
                                    	    match(input,24,FOLLOW_24_in_ruleEGenericTypeDecl4767); 

                                    	            createLeafNode(grammarAccess.prEGenericTypeDecl().ele001010KeywordComma(), null); 
                                    	        
                                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2284:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2287:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                                    	    {
                                    	     
                                    	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010110ParserRuleCallEGenericTypeDecl(), currentNode); 
                                    	    	    
                                    	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4801);
                                    	    lv_eTypeArguments_4=ruleEGenericTypeDecl();
                                    	    _fsp--;


                                    	    	        if (current==null) {
                                    	    	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	    	        }
                                    	    	        
                                    	    	        try {
                                    	    	       		add(current, "eTypeArguments", lv_eTypeArguments_4, "EGenericTypeDecl", currentNode);
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

                                    match(input,30,FOLLOW_30_in_ruleEGenericTypeDecl4817); 

                                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele0011KeywordGreaterThanSign(), null); 
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2310:6: ( '#' ( RULE_ID ) )
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2310:6: ( '#' ( RULE_ID ) )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2310:7: '#' ( RULE_ID )
                            {
                            match(input,47,FOLLOW_47_in_ruleEGenericTypeDecl4836); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele010KeywordNumberSign(), null); 
                                
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2314:1: ( RULE_ID )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2317:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4858); 

                            		createLeafNode(grammarAccess.prEGenericTypeDecl().ele0110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2331:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2331:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2331:7: '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleEGenericTypeDecl4879); 

                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele10KeywordQuestionMark(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2335:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
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
                            new NoViableAltException("2335:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2335:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2335:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2335:3: 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            {
                            match(input,31,FOLLOW_31_in_ruleEGenericTypeDecl4890); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele1100KeywordExtends(), null); 
                                
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2339:1: (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2342:6: lv_eUpperBound_10= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4924);
                            lv_eUpperBound_10=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "eUpperBound", lv_eUpperBound_10, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            {
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:7: 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            {
                            match(input,50,FOLLOW_50_in_ruleEGenericTypeDecl4945); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele1110KeywordSuper(), null); 
                                
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2365:1: (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2368:6: lv_eLowerBound_12= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4979);
                            lv_eLowerBound_12=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "eLowerBound", lv_eLowerBound_12, "EGenericTypeDecl", currentNode);
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
    // $ANTLR end ruleEGenericTypeDecl


    // $ANTLR start entryRuleEOperationDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2395:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2395:56: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2396:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEOperationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl5021);
            iv_ruleEOperationDecl=ruleEOperationDecl();
            _fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEOperationDecl5031); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2403:1: ruleEOperationDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' ) ;
    public final EObject ruleEOperationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_unique_1=null;
        Token lv_ordered_2=null;
        Token lv_name_6=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_4 = null;

        EObject lv_eTypeParameters_8 = null;

        EObject lv_eTypeParameters_10 = null;

        EObject lv_eParameters_13 = null;

        EObject lv_eParameters_15 = null;

        EObject lv_eGenericExceptions_18 = null;

        EObject lv_eGenericExceptions_20 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2408:6: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:1: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:1: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:2: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:2: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:3: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:3: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:4: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:4: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:5: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:5: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:6: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '('
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:6: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:7: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:7: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:8: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:8: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:9: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:9: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:10: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:10: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:11: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2409:11: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==22) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2412:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele00000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl5099);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2430:3: ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )*
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
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2430:4: (lv_unique_1= 'bag' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2430:4: (lv_unique_1= 'bag' )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2432:6: lv_unique_1= 'bag'
            	    {
            	    lv_unique_1=(Token)input.LT(1);
            	    match(input,33,FOLLOW_33_in_ruleEOperationDecl5126); 

            	            createLeafNode(grammarAccess.prEOperationDecl().ele000000000100KeywordBag(), "unique"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "unique", true, "bag", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2452:6: (lv_ordered_2= 'random' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2452:6: (lv_ordered_2= 'random' )
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2454:6: lv_ordered_2= 'random'
            	    {
            	    lv_ordered_2=(Token)input.LT(1);
            	    match(input,34,FOLLOW_34_in_ruleEOperationDecl5166); 

            	            createLeafNode(grammarAccess.prEOperationDecl().ele000000000110KeywordRandom(), "ordered"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "ordered", true, "random", lastConsumedNode);
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

            match(input,51,FOLLOW_51_in_ruleEOperationDecl5191); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele000000001KeywordOp(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2477:2: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )
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
                    new NoViableAltException("2477:2: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2477:3: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2477:3: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2480:6: lv_eGenericType_4= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000000100ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5227);
                    lv_eGenericType_4=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "eGenericType", lv_eGenericType_4, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2499:6: 'void'
                    {
                    match(input,52,FOLLOW_52_in_ruleEOperationDecl5246); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele000000011KeywordVoid(), null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2503:3: (lv_name_6= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:6: lv_name_6= RULE_ID
            {
            lv_name_6=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEOperationDecl5270); 

            		createLeafNode(grammarAccess.prEOperationDecl().ele00000010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_6, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2523:3: ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2523:4: ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2523:4: ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2523:5: ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2523:5: ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2523:6: '<' (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    {
                    match(input,29,FOLLOW_29_in_ruleEOperationDecl5291); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele000001000KeywordLessThanSign(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2527:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2530:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5325);
                    lv_eTypeParameters_8=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eTypeParameters", lv_eTypeParameters_8, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2548:3: ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==24) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2548:4: ',' (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5340); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele000001010KeywordComma(), null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2552:1: (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2555:6: lv_eTypeParameters_10= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5374);
                    	    lv_eTypeParameters_10=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "eTypeParameters", lv_eTypeParameters_10, "ETypeParameterDecl", currentNode);
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

                    match(input,30,FOLLOW_30_in_ruleEOperationDecl5390); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele0000011KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }


            }

            match(input,23,FOLLOW_23_in_ruleEOperationDecl5402); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele00001KeywordLeftParenthesis(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2581:2: ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID||LA66_0==22||LA66_0==47) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2581:3: (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2581:3: (lv_eParameters_13= ruleEParameterDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2584:6: lv_eParameters_13= ruleEParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele000100ParserRuleCallEParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5438);
                    lv_eParameters_13=ruleEParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eParameters", lv_eParameters_13, "EParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2602:2: ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==24) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2602:3: ',' (lv_eParameters_15= ruleEParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5452); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele000110KeywordComma(), null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2606:1: (lv_eParameters_15= ruleEParameterDecl )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2609:6: lv_eParameters_15= ruleEParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0001110ParserRuleCallEParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5486);
                    	    lv_eParameters_15=ruleEParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "eParameters", lv_eParameters_15, "EParameterDecl", currentNode);
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

            match(input,25,FOLLOW_25_in_ruleEOperationDecl5504); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele001KeywordRightParenthesis(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2631:2: ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==53) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2631:3: ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2631:3: ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2631:4: 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl )
                    {
                    match(input,53,FOLLOW_53_in_ruleEOperationDecl5516); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele0100KeywordThrows(), null); 
                        
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2635:1: (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2638:6: lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5550);
                    lv_eGenericExceptions_18=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eGenericExceptions", lv_eGenericExceptions_18, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2656:3: ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==24) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2656:4: ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5565); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele0110KeywordComma(), null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2660:1: (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2663:6: lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5599);
                    	    lv_eGenericExceptions_20=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "eGenericExceptions", lv_eGenericExceptions_20, "EGenericTypeReferenceDecl", currentNode);
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

            match(input,13,FOLLOW_13_in_ruleEOperationDecl5617); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleEOperationDecl


    // $ANTLR start entryRuleEParameterDecl
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2694:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2694:56: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2695:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5652);
            iv_ruleEParameterDecl=ruleEParameterDecl();
            _fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEParameterDecl5662); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2702:1: ruleEParameterDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2707:6: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2708:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2708:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2708:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2708:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2708:3: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2708:3: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==22) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2711:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5722);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEParameterDecl().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "eAnnotations", lv_eAnnotations_0, "EAnnotationDecl", currentNode);
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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2729:3: (lv_eGenericType_1= ruleEGenericTypeReferenceDecl )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2732:6: lv_eGenericType_1= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5761);
            lv_eGenericType_1=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEParameterDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_1, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2750:3: (lv_name_2= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2752:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEParameterDecl5788); 

            		createLeafNode(grammarAccess.prEParameterDecl().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEParameterDecl().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
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
    // $ANTLR end ruleEParameterDecl


    // $ANTLR start entryRuleMapEntrySuper
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2779:1: entryRuleMapEntrySuper returns [EObject current=null] : iv_ruleMapEntrySuper= ruleMapEntrySuper EOF ;
    public final EObject entryRuleMapEntrySuper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntrySuper = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2779:55: (iv_ruleMapEntrySuper= ruleMapEntrySuper EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2780:2: iv_ruleMapEntrySuper= ruleMapEntrySuper EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntrySuper().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntrySuper_in_entryRuleMapEntrySuper5831);
            iv_ruleMapEntrySuper=ruleMapEntrySuper();
            _fsp--;

             current =iv_ruleMapEntrySuper; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntrySuper5841); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2787:1: ruleMapEntrySuper returns [EObject current=null] : this_MapEntry_0= ruleMapEntry ;
    public final EObject ruleMapEntrySuper() throws RecognitionException {
        EObject current = null;

        EObject this_MapEntry_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2792:6: (this_MapEntry_0= ruleMapEntry )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2794:5: this_MapEntry_0= ruleMapEntry
            {
             
                    currentNode=createCompositeNode(grammarAccess.prMapEntrySuper().eleParserRuleCallMapEntry(), currentNode); 
                
            pushFollow(FOLLOW_ruleMapEntry_in_ruleMapEntrySuper5887);
            this_MapEntry_0=ruleMapEntry();
            _fsp--;

             
                    current = this_MapEntry_0; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleMapEntrySuper


    // $ANTLR start entryRuleMapEntry
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2811:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2811:50: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2812:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntry().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntry_in_entryRuleMapEntry5920);
            iv_ruleMapEntry=ruleMapEntry();
            _fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntry5930); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2819:1: ruleMapEntry returns [EObject current=null] : ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_detailKey_0=null;
        Token lv_detailValue_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2824:6: ( ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2825:1: ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2825:1: ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2825:2: ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2825:2: ( (lv_detailKey_0= RULE_ID ) '=' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2825:3: (lv_detailKey_0= RULE_ID ) '='
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2825:3: (lv_detailKey_0= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2827:6: lv_detailKey_0= RULE_ID
            {
            lv_detailKey_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMapEntry5978); 

            		createLeafNode(grammarAccess.prMapEntry().ele000LexerRuleCallID(), "detailKey"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMapEntry().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "detailKey", lv_detailKey_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,12,FOLLOW_12_in_ruleMapEntry5995); 

                    createLeafNode(grammarAccess.prMapEntry().ele01KeywordEqualsSign(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2849:2: (lv_detailValue_2= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2851:6: lv_detailValue_2= RULE_STRING
            {
            lv_detailValue_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMapEntry6018); 

            		createLeafNode(grammarAccess.prMapEntry().ele10LexerRuleCallSTRING(), "detailValue"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMapEntry().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "detailValue", lv_detailValue_2, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleMapEntry


    // $ANTLR start entryRuleQID
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2880:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2880:44: (iv_ruleQID= ruleQID EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2881:2: iv_ruleQID= ruleQID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prQID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID6064);
            iv_ruleQID=ruleQID();
            _fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID6075); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2888:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2894:6: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2895:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2895:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2895:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID6115); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prQID().ele0LexerRuleCallID(), null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2902:1: ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=54 && LA71_0<=55)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2902:2: (kw= '.' | kw= '$' ) this_ID_3= RULE_ID
            	    {
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2902:2: (kw= '.' | kw= '$' )
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
            	            new NoViableAltException("2902:2: (kw= '.' | kw= '$' )", 70, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2903:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,54,FOLLOW_54_in_ruleQID6135); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele100KeywordFullStop(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2910:2: kw= '$'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,55,FOLLOW_55_in_ruleQID6154); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele101Keyword$(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID6170); 

            	    		current.merge(this_ID_3);
            	        
            	     
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
    // $ANTLR end ruleQID


    // $ANTLR start entryRuleSTRING_OR_QID
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2932:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2932:54: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2933:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSTRING_OR_QID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID6218);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();
            _fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_OR_QID6229); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2940:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_QID_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2946:6: ( (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2947:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2947:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
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
                    new NoViableAltException("2947:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2947:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID6269); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.prSTRING_OR_QID().ele0LexerRuleCallSTRING(), null); 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2956:5: this_QID_1= ruleQID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prSTRING_OR_QID().ele1ParserRuleCallQID(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQID_in_ruleSTRING_OR_QID6302);
                    this_QID_1=ruleQID();
                    _fsp--;


                    		current.merge(this_QID_1);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleSTRING_OR_QID


    // $ANTLR start entryRuleSINT
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2976:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2976:45: (iv_ruleSINT= ruleSINT EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2977:2: iv_ruleSINT= ruleSINT EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSINT().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSINT_in_entryRuleSINT6348);
            iv_ruleSINT=ruleSINT();
            _fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSINT6359); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2984:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2990:6: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2991:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2991:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2991:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2991:2: (kw= '-' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==56) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2992:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleSINT6398); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prSINT().ele0KeywordHyphenMinus(), null); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSINT6415); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.prSINT().ele1LexerRuleCallINT(), null); 
                

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
            return "()* loopback of 331:2: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*";
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
            return "()* loopback of 450:2: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*";
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
            return "520:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )";
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
            return "562:1: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )";
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
            return "()* loopback of 1028:2: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*";
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
            return "1098:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )";
        }
    }
 

    public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatementDecl_in_ruleEcoreDsl141 = new BitSet(new long[]{0x0000000000404800L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatementDecl_in_entryRuleImportStatementDecl219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStatementDecl229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImportStatementDecl265 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImportStatementDecl288 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleImportStatementDecl305 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImportStatementDecl330 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleImportStatementDecl348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl462 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleEPackageDecl476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl511 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEPackageDecl525 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEPackageDecl535 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl558 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEPackageDecl576 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEPackageDecl586 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl621 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl635 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl671 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl715 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_18_in_ruleEPackageDecl731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl839 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleSubEPackageDecl853 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl876 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSubEPackageDecl894 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl930 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl974 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_18_in_ruleSubEPackageDecl990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl1025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1214 = new BitSet(new long[]{0x0000000000580000L});
    public static final BitSet FOLLOW_19_in_ruleEDataTypeDecl1240 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEDataTypeDecl1268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1290 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEDataTypeDecl1308 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1343 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEDataTypeDecl1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleEAnnotationDecl1470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAnnotationDecl1492 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAnnotationDecl1523 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEAnnotationDecl1537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1572 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleEAnnotationDecl1587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1621 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleEAnnotationDecl1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1749 = new BitSet(new long[]{0x000000001C400000L});
    public static final BitSet FOLLOW_26_in_ruleEClassDecl1775 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleEClassDecl1812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1840 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1864 = new BitSet(new long[]{0x00000000A0220000L});
    public static final BitSet FOLLOW_29_in_ruleEClassDecl1885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1919 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEClassDecl1934 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1968 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEClassDecl1984 = new BitSet(new long[]{0x0000000080220000L});
    public static final BitSet FOLLOW_31_in_ruleEClassDecl1998 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2032 = new BitSet(new long[]{0x0000000001220000L});
    public static final BitSet FOLLOW_24_in_ruleEClassDecl2047 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2081 = new BitSet(new long[]{0x0000000001220000L});
    public static final BitSet FOLLOW_21_in_ruleEClassDecl2100 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2134 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEClassDecl2150 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2186 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2230 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_18_in_ruleEClassDecl2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2474 = new BitSet(new long[]{0x000001FF00400000L});
    public static final BitSet FOLLOW_32_in_ruleEAttributeDecl2507 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_33_in_ruleEAttributeDecl2547 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_34_in_ruleEAttributeDecl2588 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_35_in_ruleEAttributeDecl2629 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_36_in_ruleEAttributeDecl2670 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2711 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2752 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2793 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2818 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2853 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2870 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2892 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2911 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2945 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2961 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2986 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleEAttributeDecl3005 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl3027 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEAttributeDecl3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl3082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3157 = new BitSet(new long[]{0x000070FE00400000L});
    public static final BitSet FOLLOW_44_in_ruleEReferenceDecl3190 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_33_in_ruleEReferenceDecl3230 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_34_in_ruleEReferenceDecl3271 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_35_in_ruleEReferenceDecl3312 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_36_in_ruleEReferenceDecl3353 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_37_in_ruleEReferenceDecl3394 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_38_in_ruleEReferenceDecl3435 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_39_in_ruleEReferenceDecl3476 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_45_in_ruleEReferenceDecl3514 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_46_in_ruleEReferenceDecl3542 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3578 = new BitSet(new long[]{0x0000820000000010L});
    public static final BitSet FOLLOW_41_in_ruleEReferenceDecl3595 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl3617 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleEReferenceDecl3636 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl3670 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEReferenceDecl3686 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_47_in_ruleEReferenceDecl3699 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3721 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3749 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEReferenceDecl3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3875 = new BitSet(new long[]{0x0001000000400000L});
    public static final BitSet FOLLOW_48_in_ruleEEnumDecl3889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3912 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEEnumDecl3930 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3965 = new BitSet(new long[]{0x0000000000440010L});
    public static final BitSet FOLLOW_18_in_ruleEEnumDecl3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl4015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl4087 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl4114 = new BitSet(new long[]{0x0000000000003020L});
    public static final BitSet FOLLOW_12_in_ruleEEnumLiteralDecl4133 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl4155 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4188 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEEnumLiteralDecl4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl4299 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleETypeParameterDecl4317 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4450 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleEGenericTypeReferenceDecl4465 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4499 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEGenericTypeReferenceDecl4514 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4548 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEGenericTypeReferenceDecl4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl4583 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl4654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4703 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleEGenericTypeDecl4718 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4752 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEGenericTypeDecl4767 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4801 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEGenericTypeDecl4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl4836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl4879 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEGenericTypeDecl4890 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl4945 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl5021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl5031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl5099 = new BitSet(new long[]{0x0008000600400000L});
    public static final BitSet FOLLOW_33_in_ruleEOperationDecl5126 = new BitSet(new long[]{0x0008000600000000L});
    public static final BitSet FOLLOW_34_in_ruleEOperationDecl5166 = new BitSet(new long[]{0x0008000600000000L});
    public static final BitSet FOLLOW_51_in_ruleEOperationDecl5191 = new BitSet(new long[]{0x0010800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52_in_ruleEOperationDecl5246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl5270 = new BitSet(new long[]{0x0000000020800000L});
    public static final BitSet FOLLOW_29_in_ruleEOperationDecl5291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5325 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5340 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5374 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEOperationDecl5390 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEOperationDecl5402 = new BitSet(new long[]{0x0000800002400010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5438 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5452 = new BitSet(new long[]{0x0000800000400010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5486 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleEOperationDecl5504 = new BitSet(new long[]{0x0020000000002000L});
    public static final BitSet FOLLOW_53_in_ruleEOperationDecl5516 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5550 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5565 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5599 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_13_in_ruleEOperationDecl5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl5662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5722 = new BitSet(new long[]{0x0000800000400010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl5788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_entryRuleMapEntrySuper5831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntrySuper5841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleMapEntrySuper5887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry5920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry5930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry5978 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMapEntry5995 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry6018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID6064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID6075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID6115 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleQID6135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleQID6154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID6170 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID6218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID6229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID6269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID6302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT6348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSINT6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSINT6398 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSINT6415 = new BitSet(new long[]{0x0000000000000002L});

}
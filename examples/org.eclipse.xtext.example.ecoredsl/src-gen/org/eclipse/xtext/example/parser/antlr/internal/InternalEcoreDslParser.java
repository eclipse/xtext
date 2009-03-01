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
        	ClassLoader classLoader = getClass().getClassLoader();
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:78:1: ruleEcoreDsl returns [EObject current=null] : ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_package_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:6: ( ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:1: ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:1: ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:2: (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:2: (lv_imports_0= ruleImportStatementDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:87:6: lv_imports_0= ruleImportStatementDecl
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:105:3: (lv_package_1= ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:108:6: lv_package_1= ruleEPackageDecl
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:1: entryRuleImportStatementDecl returns [EObject current=null] : iv_ruleImportStatementDecl= ruleImportStatementDecl EOF ;
    public final EObject entryRuleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatementDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:61: (iv_ruleImportStatementDecl= ruleImportStatementDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:136:2: iv_ruleImportStatementDecl= ruleImportStatementDecl EOF
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:143:1: ruleImportStatementDecl returns [EObject current=null] : ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' ) ;
    public final EObject ruleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        Token lv_alias_1=null;
        Token lv_importURI_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:148:6: ( ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ( ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:2: ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:2: ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:3: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ) (lv_importURI_3= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:3: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:4: 'import' ( (lv_alias_1= RULE_ID ) '=' )?
            {
            match(input,11,FOLLOW_11_in_ruleImportStatementDecl265); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele000KeywordImport(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:1: ( (lv_alias_1= RULE_ID ) '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:2: (lv_alias_1= RULE_ID ) '='
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:153:2: (lv_alias_1= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:155:6: lv_alias_1= RULE_ID
                    {
                    lv_alias_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImportStatementDecl287); 

                    		createLeafNode(grammarAccess.prImportStatementDecl().ele00100ParserRuleCallID(), "alias"); 
                    	

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

                    match(input,12,FOLLOW_12_in_ruleImportStatementDecl303); 

                            createLeafNode(grammarAccess.prImportStatementDecl().ele0011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:176:4: (lv_importURI_3= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:178:6: lv_importURI_3= RULE_STRING
            {
            lv_importURI_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImportStatementDecl327); 

            		createLeafNode(grammarAccess.prImportStatementDecl().ele010ParserRuleCallSTRING(), "importURI"); 
            	

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

            match(input,13,FOLLOW_13_in_ruleImportStatementDecl344); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:208:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:208:54: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:209:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl379);
            iv_ruleEPackageDecl=ruleEPackageDecl();
            _fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageDecl389); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:216:1: ruleEPackageDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:6: ( ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:1: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:1: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:2: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:2: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:3: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' ) ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:3: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:4: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:4: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:5: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' ) (lv_nsPrefix_8= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:5: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' ) '='
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:7: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) ) 'nsPrefix'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:7: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:8: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' ) (lv_nsURI_5= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:8: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:9: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' ) '='
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:9: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:10: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) ) 'nsURI'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:10: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:11: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:11: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:12: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:12: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:225:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele000000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl458);
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

            match(input,14,FOLLOW_14_in_ruleEPackageDecl472); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00000000001KeywordPackage(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:247:2: (lv_name_2= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:250:6: lv_name_2= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00000000010ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl507);
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

            match(input,15,FOLLOW_15_in_ruleEPackageDecl521); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele000000001KeywordNsURI(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleEPackageDecl531); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00000001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:276:2: (lv_nsURI_5= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:278:6: lv_nsURI_5= RULE_STRING
            {
            lv_nsURI_5=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageDecl553); 

            		createLeafNode(grammarAccess.prEPackageDecl().ele00000010ParserRuleCallSTRING(), "nsURI"); 
            	

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

            match(input,16,FOLLOW_16_in_ruleEPackageDecl570); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele000001KeywordNsPrefix(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleEPackageDecl580); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele00001KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:303:2: (lv_nsPrefix_8= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:306:6: lv_nsPrefix_8= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00010ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl615);
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

            match(input,17,FOLLOW_17_in_ruleEPackageDecl629); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:2: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:3: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:3: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:331:6: lv_eSubpackages_10= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl665);
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:350:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:350:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:353:6: lv_eClassifiers_11= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl709);
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

            match(input,18,FOLLOW_18_in_ruleEPackageDecl725); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:384:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:384:57: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:385:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl760);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();
            _fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubEPackageDecl770); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:392:1: ruleSubEPackageDecl returns [EObject current=null] : ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eSubpackages_4 = null;

        EObject lv_eClassifiers_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' ) ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:6: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:398:6: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:401:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl833);
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

            match(input,14,FOLLOW_14_in_ruleSubEPackageDecl847); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele00001KeywordPackage(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:423:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:425:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubEPackageDecl869); 

            		createLeafNode(grammarAccess.prSubEPackageDecl().ele00010ParserRuleCallID(), "name"); 
            	

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

            match(input,17,FOLLOW_17_in_ruleSubEPackageDecl886); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:2: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:3: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:3: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:449:6: lv_eSubpackages_4= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl922);
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:471:6: lv_eClassifiers_5= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl966);
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

            match(input,18,FOLLOW_18_in_ruleSubEPackageDecl982); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:502:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:502:57: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:503:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassifierDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl1017);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();
            _fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassifierDecl1027); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:510:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl_0 = null;

        EObject this_EDataTypeDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:515:6: ( (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:516:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:516:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:517:5: this_EClassDecl_0= ruleEClassDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele0ParserRuleCallEClassDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1074);
                    this_EClassDecl_0=ruleEClassDecl();
                    _fsp--;

                     
                            current = this_EClassDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:527:5: this_EDataTypeDecl_1= ruleEDataTypeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1101);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:55: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:545:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEDataTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1135);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();
            _fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEDataTypeDecl1145); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:552:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable_1=null;
        Token lv_name_3=null;
        EObject lv_eAnnotations_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5 = null;

        EObject this_EEnumDecl_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:557:6: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:1: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:1: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:2: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:2: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:3: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:3: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:4: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:4: (lv_eAnnotations_0= ruleEAnnotationDecl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:561:6: lv_eAnnotations_0= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele0000ParserRuleCallEAnnotationDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1206);
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:579:3: (lv_serializable_1= '!serializable' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==19) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:581:6: lv_serializable_1= '!serializable'
                            {
                            lv_serializable_1=(Token)input.LT(1);
                            match(input,19,FOLLOW_19_in_ruleEDataTypeDecl1232); 

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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:4: ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:5: ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:5: ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:6: ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:6: ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:7: ( 'datatype' (lv_name_3= RULE_ID ) ) ':'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:7: ( 'datatype' (lv_name_3= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:8: 'datatype' (lv_name_3= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleEDataTypeDecl1260); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele010000KeywordDatatype(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:1: (lv_name_3= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:606:6: lv_name_3= RULE_ID
                    {
                    lv_name_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEDataTypeDecl1281); 

                    		createLeafNode(grammarAccess.prEDataTypeDecl().ele0100010ParserRuleCallID(), "name"); 
                    	

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

                    match(input,21,FOLLOW_21_in_ruleEDataTypeDecl1298); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele01001KeywordColon(), null); 
                        

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:627:2: (lv_instanceClassName_5= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:630:6: lv_instanceClassName_5= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele01010ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1333);
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

                    match(input,13,FOLLOW_13_in_ruleEDataTypeDecl1347); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele011KeywordSemicolon(), null); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:654:5: this_EEnumDecl_7= ruleEEnumDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1377);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:671:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:671:57: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:672:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAnnotationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1411);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();
            _fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAnnotationDecl1421); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:679:1: ruleEAnnotationDecl returns [EObject current=null] : ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_source_1=null;
        EObject lv_contents_4 = null;

        EObject lv_contents_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:684:6: ( ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:1: ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:1: ( ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:2: ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* ) ')'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:2: ( ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:3: ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) ) ( ',' (lv_contents_6= ruleMapEntrySuper ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:3: ( ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:4: ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' ) (lv_contents_4= ruleMapEntrySuper )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:4: ( ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '(' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:5: ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? ) '('
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:5: ( ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:6: ( '@' (lv_source_1= RULE_STRING ) ) ( RULE_ID )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:6: ( '@' (lv_source_1= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:685:7: '@' (lv_source_1= RULE_STRING )
            {
            match(input,22,FOLLOW_22_in_ruleEAnnotationDecl1460); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele000000KeywordCommercialAt(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:689:1: (lv_source_1= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:691:6: lv_source_1= RULE_STRING
            {
            lv_source_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAnnotationDecl1481); 

            		createLeafNode(grammarAccess.prEAnnotationDecl().ele0000010ParserRuleCallSTRING(), "source"); 
            	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:708:3: ( RULE_ID )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:711:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAnnotationDecl1511); 

                    		createLeafNode(grammarAccess.prEAnnotationDecl().ele000010CrossReferenceEStringEModelElement(), "eModelElement"); 
                    	

                    }
                    break;

            }


            }

            match(input,23,FOLLOW_23_in_ruleEAnnotationDecl1525); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:728:2: (lv_contents_4= ruleMapEntrySuper )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:731:6: lv_contents_4= ruleMapEntrySuper
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0010ParserRuleCallMapEntrySuper(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1560);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:749:3: ( ',' (lv_contents_6= ruleMapEntrySuper ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:749:4: ',' (lv_contents_6= ruleMapEntrySuper )
            	    {
            	    match(input,24,FOLLOW_24_in_ruleEAnnotationDecl1575); 

            	            createLeafNode(grammarAccess.prEAnnotationDecl().ele010KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:753:1: (lv_contents_6= ruleMapEntrySuper )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:756:6: lv_contents_6= ruleMapEntrySuper
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0110ParserRuleCallMapEntrySuper(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1609);
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

            match(input,25,FOLLOW_25_in_ruleEAnnotationDecl1625); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:787:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:787:52: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:788:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1660);
            iv_ruleEClassDecl=ruleEClassDecl();
            _fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassDecl1670); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:795:1: ruleEClassDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:800:6: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:1: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:1: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:2: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:2: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:3: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' ) ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:3: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:4: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:4: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:5: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ) ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:5: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:6: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? ) ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:6: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:7: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:7: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:8: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) ) (lv_name_4= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:8: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:9: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ) ( (lv_interface_2= 'interface' ) | 'class' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:9: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:10: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:801:10: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:804:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1737);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:822:3: (lv_abstract_1= 'abstract' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:824:6: lv_abstract_1= 'abstract'
                    {
                    lv_abstract_1=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleEClassDecl1763); 

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:843:4: ( (lv_interface_2= 'interface' ) | 'class' )
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
                    new NoViableAltException("843:4: ( (lv_interface_2= 'interface' ) | 'class' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:843:5: (lv_interface_2= 'interface' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:843:5: (lv_interface_2= 'interface' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:845:6: lv_interface_2= 'interface'
                    {
                    lv_interface_2=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleEClassDecl1800); 

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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:865:6: 'class'
                    {
                    match(input,28,FOLLOW_28_in_ruleEClassDecl1828); 

                            createLeafNode(grammarAccess.prEClassDecl().ele000000011KeywordClass(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:869:3: (lv_name_4= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:871:6: lv_name_4= RULE_ID
            {
            lv_name_4=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEClassDecl1851); 

            		createLeafNode(grammarAccess.prEClassDecl().ele00000010ParserRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:3: ( ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:4: ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* ) '>'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:4: ( ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:5: ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:5: ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:6: '<' (lv_eTypeParameters_6= ruleETypeParameterDecl )
                    {
                    match(input,29,FOLLOW_29_in_ruleEClassDecl1871); 

                            createLeafNode(grammarAccess.prEClassDecl().ele000001000KeywordLessThanSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:892:1: (lv_eTypeParameters_6= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:6: lv_eTypeParameters_6= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1905);
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:913:3: ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==24) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:913:4: ',' (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEClassDecl1920); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele000001010KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:917:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:920:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1954);
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

                    match(input,30,FOLLOW_30_in_ruleEClassDecl1970); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000011KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:942:4: ( ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:942:5: ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:942:5: ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:942:6: 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl )
                    {
                    match(input,31,FOLLOW_31_in_ruleEClassDecl1984); 

                            createLeafNode(grammarAccess.prEClassDecl().ele0000100KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:946:1: (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:949:6: lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2018);
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:967:3: ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:967:4: ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEClassDecl2033); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele0000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:971:1: (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:974:6: lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2067);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:992:7: ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:992:8: ':' (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    {
                    match(input,21,FOLLOW_21_in_ruleEClassDecl2086); 

                            createLeafNode(grammarAccess.prEClassDecl().ele00010KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:996:1: (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:999:6: lv_instanceClassName_15= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele000110ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2120);
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

            match(input,17,FOLLOW_17_in_ruleEClassDecl2136); 

                    createLeafNode(grammarAccess.prEClassDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1021:2: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1021:3: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1021:3: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1024:6: lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0100ParserRuleCallEStructuralFeatureDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2172);
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1043:6: (lv_eOperations_18= ruleEOperationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1043:6: (lv_eOperations_18= ruleEOperationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1046:6: lv_eOperations_18= ruleEOperationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0110ParserRuleCallEOperationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2216);
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

            match(input,18,FOLLOW_18_in_ruleEClassDecl2232); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1077:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1077:64: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1078:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEStructuralFeatureDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2267);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();
            _fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2277); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1085:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl_0 = null;

        EObject this_EReferenceDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1090:6: ( (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1091:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1091:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1092:5: this_EAttributeDecl_0= ruleEAttributeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2324);
                    this_EAttributeDecl_0=ruleEAttributeDecl();
                    _fsp--;

                     
                            current = this_EAttributeDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1102:5: this_EReferenceDecl_1= ruleEReferenceDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2351);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1119:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1119:56: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1120:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAttributeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2385);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();
            _fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAttributeDecl2395); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1127:1: ruleEAttributeDecl returns [EObject current=null] : ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1132:6: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? ) (lv_name_16= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' ) (lv_eGenericType_10= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) 'attr'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:8: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1133:8: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==22) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1136:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2460);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:3: ( ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:4: ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:4: ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
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
            	            new NoViableAltException("1154:4: ( ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )", 29, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:5: ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:5: ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
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
            	                    new NoViableAltException("1154:5: ( ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )", 28, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:6: ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:6: ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
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
            	                            new NoViableAltException("1154:6: ( ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )", 27, 0, input);

            	                        throw nvae;
            	                    }
            	                    switch (alt27) {
            	                        case 1 :
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:7: ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:7: ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
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
            	                                    new NoViableAltException("1154:7: ( ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )", 26, 0, input);

            	                                throw nvae;
            	                            }
            	                            switch (alt26) {
            	                                case 1 :
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:8: ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:8: ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
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
            	                                            new NoViableAltException("1154:8: ( ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )", 25, 0, input);

            	                                        throw nvae;
            	                                    }
            	                                    switch (alt25) {
            	                                        case 1 :
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:9: ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:9: ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) )
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
            	                                                    new NoViableAltException("1154:9: ( (lv_iD_1= 'ID' ) | (lv_unique_2= 'bag' ) )", 24, 0, input);

            	                                                throw nvae;
            	                                            }
            	                                            switch (alt24) {
            	                                                case 1 :
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:10: (lv_iD_1= 'ID' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:10: (lv_iD_1= 'ID' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1156:6: lv_iD_1= 'ID'
            	                                                    {
            	                                                    lv_iD_1=(Token)input.LT(1);
            	                                                    match(input,32,FOLLOW_32_in_ruleEAttributeDecl2493); 

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
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1176:6: (lv_unique_2= 'bag' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1176:6: (lv_unique_2= 'bag' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1178:6: lv_unique_2= 'bag'
            	                                                    {
            	                                                    lv_unique_2=(Token)input.LT(1);
            	                                                    match(input,33,FOLLOW_33_in_ruleEAttributeDecl2533); 

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
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1198:6: (lv_ordered_3= 'random' )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1198:6: (lv_ordered_3= 'random' )
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1200:6: lv_ordered_3= 'random'
            	                                            {
            	                                            lv_ordered_3=(Token)input.LT(1);
            	                                            match(input,34,FOLLOW_34_in_ruleEAttributeDecl2574); 

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
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1220:6: (lv_changeable_4= 'readonly' )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1220:6: (lv_changeable_4= 'readonly' )
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1222:6: lv_changeable_4= 'readonly'
            	                                    {
            	                                    lv_changeable_4=(Token)input.LT(1);
            	                                    match(input,35,FOLLOW_35_in_ruleEAttributeDecl2615); 

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
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1242:6: (lv_volatile_5= 'volatile' )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1242:6: (lv_volatile_5= 'volatile' )
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1244:6: lv_volatile_5= 'volatile'
            	                            {
            	                            lv_volatile_5=(Token)input.LT(1);
            	                            match(input,36,FOLLOW_36_in_ruleEAttributeDecl2656); 

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
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1264:6: (lv_transient_6= 'transient' )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1264:6: (lv_transient_6= 'transient' )
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1266:6: lv_transient_6= 'transient'
            	                    {
            	                    lv_transient_6=(Token)input.LT(1);
            	                    match(input,37,FOLLOW_37_in_ruleEAttributeDecl2697); 

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
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1286:6: (lv_unsettable_7= 'unsettable' )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1286:6: (lv_unsettable_7= 'unsettable' )
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1288:6: lv_unsettable_7= 'unsettable'
            	            {
            	            lv_unsettable_7=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleEAttributeDecl2738); 

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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1308:6: (lv_derived_8= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1308:6: (lv_derived_8= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1310:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEAttributeDecl2779); 

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

            match(input,40,FOLLOW_40_in_ruleEAttributeDecl2804); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele000001KeywordAttr(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1333:2: (lv_eGenericType_10= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1336:6: lv_eGenericType_10= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2839);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1354:3: ( ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==41) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1354:4: ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? ) ']'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1354:4: ( ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1354:5: ( '[' (lv_lowerBound_12= RULE_INT ) ) ( '..' (lv_upperBound_14= ruleSINT ) )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1354:5: ( '[' (lv_lowerBound_12= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1354:6: '[' (lv_lowerBound_12= RULE_INT )
                    {
                    match(input,41,FOLLOW_41_in_ruleEAttributeDecl2856); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele0001000KeywordLeftSquareBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1358:1: (lv_lowerBound_12= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1360:6: lv_lowerBound_12= RULE_INT
                    {
                    lv_lowerBound_12=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEAttributeDecl2877); 

                    		createLeafNode(grammarAccess.prEAttributeDecl().ele00010010ParserRuleCallINT(), "lowerBound"); 
                    	

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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1377:3: ( '..' (lv_upperBound_14= ruleSINT ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==42) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1377:4: '..' (lv_upperBound_14= ruleSINT )
                            {
                            match(input,42,FOLLOW_42_in_ruleEAttributeDecl2895); 

                                    createLeafNode(grammarAccess.prEAttributeDecl().ele0001010KeywordFullStopFullStop(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1381:1: (lv_upperBound_14= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1384:6: lv_upperBound_14= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00010110ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEAttributeDecl2929);
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

                    match(input,43,FOLLOW_43_in_ruleEAttributeDecl2945); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele00011KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1406:4: (lv_name_16= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1408:6: lv_name_16= RULE_ID
            {
            lv_name_16=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAttributeDecl2969); 

            		createLeafNode(grammarAccess.prEAttributeDecl().ele0010ParserRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1425:3: ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==12) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1425:4: '=' (lv_defaultValueLiteral_18= RULE_STRING )
                    {
                    match(input,12,FOLLOW_12_in_ruleEAttributeDecl2987); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele010KeywordEqualsSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1429:1: (lv_defaultValueLiteral_18= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1431:6: lv_defaultValueLiteral_18= RULE_STRING
                    {
                    lv_defaultValueLiteral_18=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAttributeDecl3008); 

                    		createLeafNode(grammarAccess.prEAttributeDecl().ele0110ParserRuleCallSTRING(), "defaultValueLiteral"); 
                    	

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

            match(input,13,FOLLOW_13_in_ruleEAttributeDecl3027); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1461:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1461:56: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1462:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl3062);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();
            _fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEReferenceDecl3072); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1469:1: ruleEReferenceDecl returns [EObject current=null] : ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1474:6: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:1: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:2: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? ) (lv_name_19= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:3: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? ) ( '#' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:4: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ) ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:5: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* ) ( (lv_containment_9= 'val' ) | 'ref' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:7: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:8: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1475:8: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==22) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1478:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3137);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:3: ( ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) ) | (lv_derived_8= 'derived' ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:4: ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:4: ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )
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
            	            new NoViableAltException("1496:4: ( ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) ) | (lv_unsettable_7= 'unsettable' ) )", 40, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:5: ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:5: ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )
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
            	                    new NoViableAltException("1496:5: ( ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) ) | (lv_transient_6= 'transient' ) )", 39, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt39) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:6: ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:6: ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )
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
            	                            new NoViableAltException("1496:6: ( ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) ) | (lv_volatile_5= 'volatile' ) )", 38, 0, input);

            	                        throw nvae;
            	                    }
            	                    switch (alt38) {
            	                        case 1 :
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:7: ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:7: ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )
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
            	                                    new NoViableAltException("1496:7: ( ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) ) | (lv_changeable_4= 'readonly' ) )", 37, 0, input);

            	                                throw nvae;
            	                            }
            	                            switch (alt37) {
            	                                case 1 :
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:8: ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:8: ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )
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
            	                                            new NoViableAltException("1496:8: ( ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) ) | (lv_ordered_3= 'random' ) )", 36, 0, input);

            	                                        throw nvae;
            	                                    }
            	                                    switch (alt36) {
            	                                        case 1 :
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:9: ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:9: ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) )
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
            	                                                    new NoViableAltException("1496:9: ( (lv_resolveProxies_1= 'local' ) | (lv_unique_2= 'bag' ) )", 35, 0, input);

            	                                                throw nvae;
            	                                            }
            	                                            switch (alt35) {
            	                                                case 1 :
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:10: (lv_resolveProxies_1= 'local' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1496:10: (lv_resolveProxies_1= 'local' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1498:6: lv_resolveProxies_1= 'local'
            	                                                    {
            	                                                    lv_resolveProxies_1=(Token)input.LT(1);
            	                                                    match(input,44,FOLLOW_44_in_ruleEReferenceDecl3170); 

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
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1518:6: (lv_unique_2= 'bag' )
            	                                                    {
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1518:6: (lv_unique_2= 'bag' )
            	                                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1520:6: lv_unique_2= 'bag'
            	                                                    {
            	                                                    lv_unique_2=(Token)input.LT(1);
            	                                                    match(input,33,FOLLOW_33_in_ruleEReferenceDecl3210); 

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
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1540:6: (lv_ordered_3= 'random' )
            	                                            {
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1540:6: (lv_ordered_3= 'random' )
            	                                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1542:6: lv_ordered_3= 'random'
            	                                            {
            	                                            lv_ordered_3=(Token)input.LT(1);
            	                                            match(input,34,FOLLOW_34_in_ruleEReferenceDecl3251); 

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
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1562:6: (lv_changeable_4= 'readonly' )
            	                                    {
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1562:6: (lv_changeable_4= 'readonly' )
            	                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1564:6: lv_changeable_4= 'readonly'
            	                                    {
            	                                    lv_changeable_4=(Token)input.LT(1);
            	                                    match(input,35,FOLLOW_35_in_ruleEReferenceDecl3292); 

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
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1584:6: (lv_volatile_5= 'volatile' )
            	                            {
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1584:6: (lv_volatile_5= 'volatile' )
            	                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1586:6: lv_volatile_5= 'volatile'
            	                            {
            	                            lv_volatile_5=(Token)input.LT(1);
            	                            match(input,36,FOLLOW_36_in_ruleEReferenceDecl3333); 

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
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1606:6: (lv_transient_6= 'transient' )
            	                    {
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1606:6: (lv_transient_6= 'transient' )
            	                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1608:6: lv_transient_6= 'transient'
            	                    {
            	                    lv_transient_6=(Token)input.LT(1);
            	                    match(input,37,FOLLOW_37_in_ruleEReferenceDecl3374); 

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
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1628:6: (lv_unsettable_7= 'unsettable' )
            	            {
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1628:6: (lv_unsettable_7= 'unsettable' )
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1630:6: lv_unsettable_7= 'unsettable'
            	            {
            	            lv_unsettable_7=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleEReferenceDecl3415); 

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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1650:6: (lv_derived_8= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1650:6: (lv_derived_8= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1652:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEReferenceDecl3456); 

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1671:5: ( (lv_containment_9= 'val' ) | 'ref' )
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
                    new NoViableAltException("1671:5: ( (lv_containment_9= 'val' ) | 'ref' )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1671:6: (lv_containment_9= 'val' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1671:6: (lv_containment_9= 'val' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1673:6: lv_containment_9= 'val'
                    {
                    lv_containment_9=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleEReferenceDecl3494); 

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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1693:6: 'ref'
                    {
                    match(input,46,FOLLOW_46_in_ruleEReferenceDecl3522); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0000011KeywordRef(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1697:3: (lv_eGenericType_11= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1700:6: lv_eGenericType_11= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3558);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1718:3: ( ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==41) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1718:4: ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? ) ']'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1718:4: ( ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1718:5: ( '[' (lv_lowerBound_13= RULE_INT ) ) ( '..' (lv_upperBound_15= ruleSINT ) )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1718:5: ( '[' (lv_lowerBound_13= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1718:6: '[' (lv_lowerBound_13= RULE_INT )
                    {
                    match(input,41,FOLLOW_41_in_ruleEReferenceDecl3575); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0001000KeywordLeftSquareBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1722:1: (lv_lowerBound_13= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1724:6: lv_lowerBound_13= RULE_INT
                    {
                    lv_lowerBound_13=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEReferenceDecl3596); 

                    		createLeafNode(grammarAccess.prEReferenceDecl().ele00010010ParserRuleCallINT(), "lowerBound"); 
                    	

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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1741:3: ( '..' (lv_upperBound_15= ruleSINT ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==42) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1741:4: '..' (lv_upperBound_15= ruleSINT )
                            {
                            match(input,42,FOLLOW_42_in_ruleEReferenceDecl3614); 

                                    createLeafNode(grammarAccess.prEReferenceDecl().ele0001010KeywordFullStopFullStop(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1745:1: (lv_upperBound_15= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1748:6: lv_upperBound_15= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00010110ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEReferenceDecl3648);
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

                    match(input,43,FOLLOW_43_in_ruleEReferenceDecl3664); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele00011KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1770:4: ( '#' ( RULE_ID ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1770:5: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEReferenceDecl3677); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele0010KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1774:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1777:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3699); 

                    		createLeafNode(grammarAccess.prEReferenceDecl().ele00110CrossReferenceEStringEReference(), "eOpposite"); 
                    	

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1790:5: (lv_name_19= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1792:6: lv_name_19= RULE_ID
            {
            lv_name_19=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3726); 

            		createLeafNode(grammarAccess.prEReferenceDecl().ele010ParserRuleCallID(), "name"); 
            	

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

            match(input,13,FOLLOW_13_in_ruleEReferenceDecl3743); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1822:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1822:51: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1823:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3778);
            iv_ruleEEnumDecl=ruleEEnumDecl();
            _fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumDecl3788); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1830:1: ruleEEnumDecl returns [EObject current=null] : ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eLiterals_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1835:6: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:1: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ ) '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:2: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+ )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' ) (lv_eLiterals_4= ruleEEnumLiteralDecl )+
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:3: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:4: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:5: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:6: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1836:6: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==22) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1839:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3851);
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

            match(input,48,FOLLOW_48_in_ruleEEnumDecl3865); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele00001KeywordEnum(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1861:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1863:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumDecl3887); 

            		createLeafNode(grammarAccess.prEEnumDecl().ele00010ParserRuleCallID(), "name"); 
            	

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

            match(input,17,FOLLOW_17_in_ruleEEnumDecl3904); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1884:2: (lv_eLiterals_4= ruleEEnumLiteralDecl )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1887:6: lv_eLiterals_4= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele010ParserRuleCallEEnumLiteralDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3939);
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

            match(input,18,FOLLOW_18_in_ruleEEnumDecl3954); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1918:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1918:58: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1919:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumLiteralDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3989);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();
            _fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3999); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1926:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_value_3=null;
        Token lv_literal_4=null;
        EObject lv_eAnnotations_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1931:6: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:1: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:1: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:2: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:2: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:3: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? ) (lv_literal_4= RULE_STRING )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:3: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:4: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ) ( '=' (lv_value_3= RULE_INT ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:4: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:5: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1932:5: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==22) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1935:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumLiteralDecl().ele00000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl4061);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1953:3: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1955:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl4087); 

            		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00010ParserRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1972:3: ( '=' (lv_value_3= RULE_INT ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==12) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1972:4: '=' (lv_value_3= RULE_INT )
                    {
                    match(input,12,FOLLOW_12_in_ruleEEnumLiteralDecl4105); 

                            createLeafNode(grammarAccess.prEEnumLiteralDecl().ele0010KeywordEqualsSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1976:1: (lv_value_3= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1978:6: lv_value_3= RULE_INT
                    {
                    lv_value_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl4126); 

                    		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00110ParserRuleCallINT(), "value"); 
                    	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1995:5: (lv_literal_4= RULE_STRING )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_STRING) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1997:6: lv_literal_4= RULE_STRING
                    {
                    lv_literal_4=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4157); 

                    		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele010ParserRuleCallSTRING(), "literal"); 
                    	

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

            match(input,13,FOLLOW_13_in_ruleEEnumLiteralDecl4175); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2027:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2027:60: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2028:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prETypeParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4210);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();
            _fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleETypeParameterDecl4220); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2035:1: ruleETypeParameterDecl returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_eBounds_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2040:6: ( ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2041:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2041:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2041:2: (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2041:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2043:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleETypeParameterDecl4266); 

            		createLeafNode(grammarAccess.prETypeParameterDecl().ele00ParserRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2060:2: ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==31) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2060:3: 'extends' (lv_eBounds_2= ruleEGenericTypeDecl )
                    {
                    match(input,31,FOLLOW_31_in_ruleETypeParameterDecl4283); 

                            createLeafNode(grammarAccess.prETypeParameterDecl().ele10KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2064:1: (lv_eBounds_2= ruleEGenericTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2067:6: lv_eBounds_2= ruleEGenericTypeDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prETypeParameterDecl().ele110ParserRuleCallEGenericTypeDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4317);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2094:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2094:67: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2095:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4358);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();
            _fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4368); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2102:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2107:6: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2108:1: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2108:1: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
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
                    new NoViableAltException("2108:1: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2108:2: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2108:2: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2108:3: ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2108:3: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2111:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4416); 

                    		createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele000CrossReferenceEStringEClassifier(), "eClassifier"); 
                    	

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:2: ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==29) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>'
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2124:5: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            {
                            match(input,29,FOLLOW_29_in_ruleEGenericTypeReferenceDecl4431); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01000KeywordLessThanSign(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2128:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2131:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4465);
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

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2149:3: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==24) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2149:4: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,24,FOLLOW_24_in_ruleEGenericTypeReferenceDecl4480); 

                            	            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01010KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2153:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2156:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4514);
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

                            match(input,30,FOLLOW_30_in_ruleEGenericTypeReferenceDecl4530); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele011KeywordGreaterThanSign(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2179:6: ( '#' ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2179:6: ( '#' ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2179:7: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeReferenceDecl4549); 

                            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele10KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2183:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4571); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2208:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2208:58: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2209:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4610);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();
            _fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeDecl4620); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2216:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;

        EObject lv_eUpperBound_10 = null;

        EObject lv_eLowerBound_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2221:6: ( ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:1: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:1: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
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
                    new NoViableAltException("2222:1: ( ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:2: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:2: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )
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
                            new NoViableAltException("2222:2: ( ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? ) | ( '#' ( RULE_ID ) ) )", 57, 0, input);

                        throw nvae;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:3: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:3: ( ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )? )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:4: ( RULE_ID ) ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:4: ( RULE_ID )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2225:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4669); 

                            		createLeafNode(grammarAccess.prEGenericTypeDecl().ele0000CrossReferenceEStringEClassifier(), "eClassifier"); 
                            	

                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:2: ( ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>' )?
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==29) ) {
                                alt56=1;
                            }
                            switch (alt56) {
                                case 1 :
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* ) '>'
                                    {
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:3: ( ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* )
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                                    {
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:4: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) )
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2238:5: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                                    {
                                    match(input,29,FOLLOW_29_in_ruleEGenericTypeDecl4684); 

                                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele001000KeywordLessThanSign(), null); 
                                        
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2242:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2245:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                                    {
                                     
                                    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010010ParserRuleCallEGenericTypeDecl(), currentNode); 
                                    	    
                                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4718);
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

                                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2263:3: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                                    loop55:
                                    do {
                                        int alt55=2;
                                        int LA55_0 = input.LA(1);

                                        if ( (LA55_0==24) ) {
                                            alt55=1;
                                        }


                                        switch (alt55) {
                                    	case 1 :
                                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2263:4: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                                    	    {
                                    	    match(input,24,FOLLOW_24_in_ruleEGenericTypeDecl4733); 

                                    	            createLeafNode(grammarAccess.prEGenericTypeDecl().ele001010KeywordComma(), null); 
                                    	        
                                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2267:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2270:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                                    	    {
                                    	     
                                    	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010110ParserRuleCallEGenericTypeDecl(), currentNode); 
                                    	    	    
                                    	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4767);
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

                                    match(input,30,FOLLOW_30_in_ruleEGenericTypeDecl4783); 

                                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele0011KeywordGreaterThanSign(), null); 
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:6: ( '#' ( RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:6: ( '#' ( RULE_ID ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2293:7: '#' ( RULE_ID )
                            {
                            match(input,47,FOLLOW_47_in_ruleEGenericTypeDecl4802); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele010KeywordNumberSign(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:1: ( RULE_ID )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2300:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4824); 

                            		createLeafNode(grammarAccess.prEGenericTypeDecl().ele0110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2314:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2314:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2314:7: '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleEGenericTypeDecl4845); 

                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele10KeywordQuestionMark(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2318:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
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
                            new NoViableAltException("2318:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2318:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2318:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2318:3: 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            {
                            match(input,31,FOLLOW_31_in_ruleEGenericTypeDecl4856); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele1100KeywordExtends(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2322:1: (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2325:6: lv_eUpperBound_10= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4890);
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
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2344:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2344:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2344:7: 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            {
                            match(input,50,FOLLOW_50_in_ruleEGenericTypeDecl4911); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele1110KeywordSuper(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2348:1: (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2351:6: lv_eLowerBound_12= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4945);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2378:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2378:56: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2379:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEOperationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4987);
            iv_ruleEOperationDecl=ruleEOperationDecl();
            _fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEOperationDecl4997); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2386:1: ruleEOperationDecl returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2391:6: ( ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:1: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:1: ( ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:2: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:2: ( ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:3: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' ) ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:3: ( ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:4: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ) ')'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:4: ( ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:5: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' ) ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:5: ( ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '(' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:6: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? ) '('
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:6: ( ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:7: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) ) ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:7: ( ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:8: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) ) (lv_name_6= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:8: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:9: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' ) ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:9: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:10: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* ) 'op'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:10: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:11: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:11: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==22) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2395:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele00000000000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl5065);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2413:3: ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2413:4: (lv_unique_1= 'bag' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2413:4: (lv_unique_1= 'bag' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2415:6: lv_unique_1= 'bag'
            	    {
            	    lv_unique_1=(Token)input.LT(1);
            	    match(input,33,FOLLOW_33_in_ruleEOperationDecl5092); 

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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2435:6: (lv_ordered_2= 'random' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2435:6: (lv_ordered_2= 'random' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2437:6: lv_ordered_2= 'random'
            	    {
            	    lv_ordered_2=(Token)input.LT(1);
            	    match(input,34,FOLLOW_34_in_ruleEOperationDecl5132); 

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

            match(input,51,FOLLOW_51_in_ruleEOperationDecl5157); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele000000001KeywordOp(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2460:2: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )
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
                    new NoViableAltException("2460:2: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2460:3: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2460:3: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2463:6: lv_eGenericType_4= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000000100ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5193);
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2482:6: 'void'
                    {
                    match(input,52,FOLLOW_52_in_ruleEOperationDecl5212); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele000000011KeywordVoid(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2486:3: (lv_name_6= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2488:6: lv_name_6= RULE_ID
            {
            lv_name_6=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEOperationDecl5235); 

            		createLeafNode(grammarAccess.prEOperationDecl().ele00000010ParserRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:3: ( ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:4: ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* ) '>'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:4: ( ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:5: ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:5: ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:6: '<' (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    {
                    match(input,29,FOLLOW_29_in_ruleEOperationDecl5255); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele000001000KeywordLessThanSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2509:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2512:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5289);
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2530:3: ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==24) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2530:4: ',' (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5304); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele000001010KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2534:1: (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2537:6: lv_eTypeParameters_10= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5338);
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

                    match(input,30,FOLLOW_30_in_ruleEOperationDecl5354); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele0000011KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }


            }

            match(input,23,FOLLOW_23_in_ruleEOperationDecl5366); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele00001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2563:2: ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID||LA66_0==22||LA66_0==47) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2563:3: (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2563:3: (lv_eParameters_13= ruleEParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2566:6: lv_eParameters_13= ruleEParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele000100ParserRuleCallEParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5402);
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2584:2: ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==24) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2584:3: ',' (lv_eParameters_15= ruleEParameterDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5416); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2588:1: (lv_eParameters_15= ruleEParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2591:6: lv_eParameters_15= ruleEParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0001110ParserRuleCallEParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5450);
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

            match(input,25,FOLLOW_25_in_ruleEOperationDecl5468); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele001KeywordRightParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2613:2: ( ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==53) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2613:3: ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2613:3: ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2613:4: 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl )
                    {
                    match(input,53,FOLLOW_53_in_ruleEOperationDecl5480); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele0100KeywordThrows(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2617:1: (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:6: lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5514);
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2638:3: ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==24) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2638:4: ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleEOperationDecl5529); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele0110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2642:1: (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2645:6: lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5563);
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

            match(input,13,FOLLOW_13_in_ruleEOperationDecl5581); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2676:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2676:56: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2677:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5616);
            iv_ruleEParameterDecl=ruleEParameterDecl();
            _fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEParameterDecl5626); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2684:1: ruleEParameterDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2689:6: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2690:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2690:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2690:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2690:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2690:3: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2690:3: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==22) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2693:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele000ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5686);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2711:3: (lv_eGenericType_1= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2714:6: lv_eGenericType_1= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5725);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2732:3: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2734:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEParameterDecl5751); 

            		createLeafNode(grammarAccess.prEParameterDecl().ele10ParserRuleCallID(), "name"); 
            	

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2760:1: entryRuleMapEntrySuper returns [EObject current=null] : iv_ruleMapEntrySuper= ruleMapEntrySuper EOF ;
    public final EObject entryRuleMapEntrySuper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntrySuper = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2760:55: (iv_ruleMapEntrySuper= ruleMapEntrySuper EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2761:2: iv_ruleMapEntrySuper= ruleMapEntrySuper EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntrySuper().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntrySuper_in_entryRuleMapEntrySuper5793);
            iv_ruleMapEntrySuper=ruleMapEntrySuper();
            _fsp--;

             current =iv_ruleMapEntrySuper; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntrySuper5803); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2768:1: ruleMapEntrySuper returns [EObject current=null] : this_MapEntry_0= ruleMapEntry ;
    public final EObject ruleMapEntrySuper() throws RecognitionException {
        EObject current = null;

        EObject this_MapEntry_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2773:6: (this_MapEntry_0= ruleMapEntry )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2775:5: this_MapEntry_0= ruleMapEntry
            {
             
                    currentNode=createCompositeNode(grammarAccess.prMapEntrySuper().eleParserRuleCallMapEntry(), currentNode); 
                
            pushFollow(FOLLOW_ruleMapEntry_in_ruleMapEntrySuper5849);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2792:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2792:50: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2793:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntry().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntry_in_entryRuleMapEntry5882);
            iv_ruleMapEntry=ruleMapEntry();
            _fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntry5892); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2800:1: ruleMapEntry returns [EObject current=null] : ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_detailKey_0=null;
        Token lv_detailValue_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2805:6: ( ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:1: ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:1: ( ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:2: ( (lv_detailKey_0= RULE_ID ) '=' ) (lv_detailValue_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:2: ( (lv_detailKey_0= RULE_ID ) '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:3: (lv_detailKey_0= RULE_ID ) '='
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:3: (lv_detailKey_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2808:6: lv_detailKey_0= RULE_ID
            {
            lv_detailKey_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMapEntry5939); 

            		createLeafNode(grammarAccess.prMapEntry().ele000ParserRuleCallID(), "detailKey"); 
            	

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

            match(input,12,FOLLOW_12_in_ruleMapEntry5955); 

                    createLeafNode(grammarAccess.prMapEntry().ele01KeywordEqualsSign(), null); 
                

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2829:2: (lv_detailValue_2= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2831:6: lv_detailValue_2= RULE_STRING
            {
            lv_detailValue_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMapEntry5977); 

            		createLeafNode(grammarAccess.prMapEntry().ele10ParserRuleCallSTRING(), "detailValue"); 
            	

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2859:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2859:44: (iv_ruleQID= ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2860:2: iv_ruleQID= ruleQID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prQID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID6022);
            iv_ruleQID=ruleQID();
            _fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID6033); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2867:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2873:6: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2874:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2874:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2874:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID6073); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prQID().ele0ParserRuleCallID(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2881:1: ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=54 && LA71_0<=55)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2881:2: (kw= '.' | kw= '$' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2881:2: (kw= '.' | kw= '$' )
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
            	            new NoViableAltException("2881:2: (kw= '.' | kw= '$' )", 70, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2882:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,54,FOLLOW_54_in_ruleQID6093); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele100KeywordFullStop(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2889:2: kw= '$'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,55,FOLLOW_55_in_ruleQID6112); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele101Keyword$(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID6128); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        createLeafNode(grammarAccess.prQID().ele11ParserRuleCallID(), null); 
            	        

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2911:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2911:54: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2912:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSTRING_OR_QID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID6176);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();
            _fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_OR_QID6187); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2919:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_QID_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2925:6: ( (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2926:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2926:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
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
                    new NoViableAltException("2926:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2926:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID6227); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.prSTRING_OR_QID().ele0ParserRuleCallSTRING(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2935:5: this_QID_1= ruleQID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prSTRING_OR_QID().ele1ParserRuleCallQID(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQID_in_ruleSTRING_OR_QID6260);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2955:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2955:45: (iv_ruleSINT= ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2956:2: iv_ruleSINT= ruleSINT EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSINT().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSINT_in_entryRuleSINT6306);
            iv_ruleSINT=ruleSINT();
            _fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSINT6317); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2963:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2969:6: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2970:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2970:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2970:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2970:2: (kw= '-' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==56) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2971:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleSINT6356); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prSINT().ele0KeywordHyphenMinus(), null); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSINT6373); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.prSINT().ele1ParserRuleCallINT(), null); 
                

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
            return "()* loopback of 328:2: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*";
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
            return "()* loopback of 446:2: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*";
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
            return "516:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )";
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
            return "558:1: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= '!serializable' )? ) ( ( ( ( 'datatype' (lv_name_3= RULE_ID ) ) ':' ) (lv_instanceClassName_5= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )";
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
            return "()* loopback of 1021:2: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*";
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
            return "1091:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )";
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
    public static final BitSet FOLLOW_12_in_ruleImportStatementDecl303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImportStatementDecl327 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleImportStatementDecl344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl458 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleEPackageDecl472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl507 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEPackageDecl521 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEPackageDecl531 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl553 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEPackageDecl570 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEPackageDecl580 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl615 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl629 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl665 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl709 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_18_in_ruleEPackageDecl725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl833 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleSubEPackageDecl847 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl869 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSubEPackageDecl886 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl922 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl966 = new BitSet(new long[]{0x000100001C5C4000L});
    public static final BitSet FOLLOW_18_in_ruleSubEPackageDecl982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl1017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1206 = new BitSet(new long[]{0x0000000000580000L});
    public static final BitSet FOLLOW_19_in_ruleEDataTypeDecl1232 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEDataTypeDecl1260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1281 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEDataTypeDecl1298 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1333 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEDataTypeDecl1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1411 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleEAnnotationDecl1460 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAnnotationDecl1481 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAnnotationDecl1511 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEAnnotationDecl1525 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1560 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleEAnnotationDecl1575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_ruleEAnnotationDecl1609 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleEAnnotationDecl1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1737 = new BitSet(new long[]{0x000000001C400000L});
    public static final BitSet FOLLOW_26_in_ruleEClassDecl1763 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleEClassDecl1800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1851 = new BitSet(new long[]{0x00000000A0220000L});
    public static final BitSet FOLLOW_29_in_ruleEClassDecl1871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1905 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEClassDecl1920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1954 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEClassDecl1970 = new BitSet(new long[]{0x0000000080220000L});
    public static final BitSet FOLLOW_31_in_ruleEClassDecl1984 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2018 = new BitSet(new long[]{0x0000000001220000L});
    public static final BitSet FOLLOW_24_in_ruleEClassDecl2033 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2067 = new BitSet(new long[]{0x0000000001220000L});
    public static final BitSet FOLLOW_21_in_ruleEClassDecl2086 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2120 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEClassDecl2136 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2172 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2216 = new BitSet(new long[]{0x000871FF00440000L});
    public static final BitSet FOLLOW_18_in_ruleEClassDecl2232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl2395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2460 = new BitSet(new long[]{0x000001FF00400000L});
    public static final BitSet FOLLOW_32_in_ruleEAttributeDecl2493 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_33_in_ruleEAttributeDecl2533 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_34_in_ruleEAttributeDecl2574 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_35_in_ruleEAttributeDecl2615 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_36_in_ruleEAttributeDecl2656 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2697 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2738 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2779 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2804 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2839 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2856 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2877 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2895 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2929 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2945 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2969 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleEAttributeDecl2987 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl3008 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEAttributeDecl3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl3062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3137 = new BitSet(new long[]{0x000070FE00400000L});
    public static final BitSet FOLLOW_44_in_ruleEReferenceDecl3170 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_33_in_ruleEReferenceDecl3210 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_34_in_ruleEReferenceDecl3251 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_35_in_ruleEReferenceDecl3292 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_36_in_ruleEReferenceDecl3333 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_37_in_ruleEReferenceDecl3374 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_38_in_ruleEReferenceDecl3415 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_39_in_ruleEReferenceDecl3456 = new BitSet(new long[]{0x000070FE00000000L});
    public static final BitSet FOLLOW_45_in_ruleEReferenceDecl3494 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_46_in_ruleEReferenceDecl3522 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3558 = new BitSet(new long[]{0x0000820000000010L});
    public static final BitSet FOLLOW_41_in_ruleEReferenceDecl3575 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl3596 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleEReferenceDecl3614 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl3648 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEReferenceDecl3664 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_47_in_ruleEReferenceDecl3677 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3699 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3726 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEReferenceDecl3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3851 = new BitSet(new long[]{0x0001000000400000L});
    public static final BitSet FOLLOW_48_in_ruleEEnumDecl3865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3887 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEEnumDecl3904 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3939 = new BitSet(new long[]{0x0000000000440010L});
    public static final BitSet FOLLOW_18_in_ruleEEnumDecl3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl4061 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl4087 = new BitSet(new long[]{0x0000000000003020L});
    public static final BitSet FOLLOW_12_in_ruleEEnumLiteralDecl4105 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl4126 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4157 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEEnumLiteralDecl4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl4266 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleETypeParameterDecl4283 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4416 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleEGenericTypeReferenceDecl4431 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4465 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEGenericTypeReferenceDecl4480 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4514 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEGenericTypeReferenceDecl4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl4549 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl4620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4669 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleEGenericTypeDecl4684 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4718 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEGenericTypeDecl4733 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4767 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEGenericTypeDecl4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl4802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl4845 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEGenericTypeDecl4856 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl4911 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl5065 = new BitSet(new long[]{0x0008000600400000L});
    public static final BitSet FOLLOW_33_in_ruleEOperationDecl5092 = new BitSet(new long[]{0x0008000600000000L});
    public static final BitSet FOLLOW_34_in_ruleEOperationDecl5132 = new BitSet(new long[]{0x0008000600000000L});
    public static final BitSet FOLLOW_51_in_ruleEOperationDecl5157 = new BitSet(new long[]{0x0010800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52_in_ruleEOperationDecl5212 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl5235 = new BitSet(new long[]{0x0000000020800000L});
    public static final BitSet FOLLOW_29_in_ruleEOperationDecl5255 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5289 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5338 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30_in_ruleEOperationDecl5354 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEOperationDecl5366 = new BitSet(new long[]{0x0000800002400010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5402 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5416 = new BitSet(new long[]{0x0000800000400010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5450 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleEOperationDecl5468 = new BitSet(new long[]{0x0020000000002000L});
    public static final BitSet FOLLOW_53_in_ruleEOperationDecl5480 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5514 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleEOperationDecl5529 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5563 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_13_in_ruleEOperationDecl5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5686 = new BitSet(new long[]{0x0000800000400010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5725 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl5751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntrySuper_in_entryRuleMapEntrySuper5793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntrySuper5803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleMapEntrySuper5849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry5882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry5892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry5939 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMapEntry5955 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry5977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID6022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID6073 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleQID6093 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleQID6112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID6128 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID6176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID6187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID6227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID6260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT6306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSINT6317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSINT6356 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSINT6373 = new BitSet(new long[]{0x0000000000000002L});

}
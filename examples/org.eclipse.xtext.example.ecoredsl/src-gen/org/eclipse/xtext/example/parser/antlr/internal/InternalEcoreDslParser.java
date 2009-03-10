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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_SERIALIZABLE", "RULE_BAG", "RULE_RANDOM", "RULE_READONLY", "RULE_INT", "RULE_LOCAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'='", "';'", "'package'", "'nsURI'", "'nsPrefix'", "'{'", "'}'", "'datatype'", "':'", "'@'", "'('", "','", "')'", "'abstract'", "'interface'", "'class'", "'<'", "'>'", "'extends'", "'ID'", "'volatile'", "'transient'", "'unsettable'", "'derived'", "'attr'", "'['", "'..'", "']'", "'val'", "'ref'", "'#'", "'enum'", "'?'", "'super'", "'op'", "'void'", "'throws'", "'.'", "'$'", "'-'"
    };
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=14;
    public static final int RULE_INT=10;
    public static final int EOF=-1;
    public static final int RULE_LOCAL=11;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_RANDOM=8;
    public static final int RULE_SERIALIZABLE=6;
    public static final int RULE_BAG=7;
    public static final int RULE_READONLY=9;
    public static final int RULE_SL_COMMENT=13;

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:69:1: entryRuleEcoreDsl returns [EObject current=null] : iv_ruleEcoreDsl= ruleEcoreDsl EOF ;
    public final EObject entryRuleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEcoreDsl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:69:50: (iv_ruleEcoreDsl= ruleEcoreDsl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:70:2: iv_ruleEcoreDsl= ruleEcoreDsl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEcoreDsl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl71);
            iv_ruleEcoreDsl=ruleEcoreDsl();
            _fsp--;

             current =iv_ruleEcoreDsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEcoreDsl81); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:77:1: ruleEcoreDsl returns [EObject current=null] : ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_package_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:82:6: ( ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:1: ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:1: ( (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:2: (lv_imports_0= ruleImportStatementDecl )* (lv_package_1= ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:2: (lv_imports_0= ruleImportStatementDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:6: lv_imports_0= ruleImportStatementDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele00ParserRuleCallImportStatementDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImportStatementDecl_in_ruleEcoreDsl140);
            	    lv_imports_0=ruleImportStatementDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEcoreDsl().getRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:104:3: (lv_package_1= ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:107:6: lv_package_1= ruleEPackageDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele10ParserRuleCallEPackageDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl179);
            lv_package_1=ruleEPackageDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEcoreDsl().getRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:132:1: entryRuleImportStatementDecl returns [EObject current=null] : iv_ruleImportStatementDecl= ruleImportStatementDecl EOF ;
    public final EObject entryRuleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatementDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:132:61: (iv_ruleImportStatementDecl= ruleImportStatementDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:133:2: iv_ruleImportStatementDecl= ruleImportStatementDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImportStatementDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImportStatementDecl_in_entryRuleImportStatementDecl216);
            iv_ruleImportStatementDecl=ruleImportStatementDecl();
            _fsp--;

             current =iv_ruleImportStatementDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportStatementDecl226); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:140:1: ruleImportStatementDecl returns [EObject current=null] : ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? (lv_importURI_3= RULE_STRING ) ';' ) ;
    public final EObject ruleImportStatementDecl() throws RecognitionException {
        EObject current = null;

        Token lv_alias_1=null;
        Token lv_importURI_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:145:6: ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? (lv_importURI_3= RULE_STRING ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:146:1: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? (lv_importURI_3= RULE_STRING ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:146:1: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? (lv_importURI_3= RULE_STRING ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:146:2: 'import' ( (lv_alias_1= RULE_ID ) '=' )? (lv_importURI_3= RULE_STRING ) ';'
            {
            match(input,16,FOLLOW_16_in_ruleImportStatementDecl260); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele0KeywordImport(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:150:1: ( (lv_alias_1= RULE_ID ) '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:150:2: (lv_alias_1= RULE_ID ) '='
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:150:2: (lv_alias_1= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:152:6: lv_alias_1= RULE_ID
                    {
                    lv_alias_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImportStatementDecl283); 

                    		createLeafNode(grammarAccess.prImportStatementDecl().ele100TerminalRuleCallID(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prImportStatementDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_1, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,17,FOLLOW_17_in_ruleImportStatementDecl300); 

                            createLeafNode(grammarAccess.prImportStatementDecl().ele11KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:174:3: (lv_importURI_3= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:176:6: lv_importURI_3= RULE_STRING
            {
            lv_importURI_3=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImportStatementDecl324); 

            		createLeafNode(grammarAccess.prImportStatementDecl().ele20TerminalRuleCallSTRING(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prImportStatementDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "importURI", lv_importURI_3, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,18,FOLLOW_18_in_ruleImportStatementDecl341); 

                    createLeafNode(grammarAccess.prImportStatementDecl().ele3KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:205:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:205:54: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:206:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl374);
            iv_ruleEPackageDecl=ruleEPackageDecl();
            _fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageDecl384); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:213:1: ruleEPackageDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:218:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:219:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:219:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:219:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:219:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:222:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl443);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getClassifier());
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

            match(input,19,FOLLOW_19_in_ruleEPackageDecl457); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele1KeywordPackage(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:244:1: (lv_name_2= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:247:6: lv_name_2= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele20ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl491);
            lv_name_2=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,20,FOLLOW_20_in_ruleEPackageDecl504); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele3KeywordNsURI(), null); 
                
            match(input,17,FOLLOW_17_in_ruleEPackageDecl513); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele4KeywordEqualsSign(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:273:1: (lv_nsURI_5= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:275:6: lv_nsURI_5= RULE_STRING
            {
            lv_nsURI_5=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageDecl535); 

            		createLeafNode(grammarAccess.prEPackageDecl().ele50TerminalRuleCallSTRING(), "nsURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "nsURI", lv_nsURI_5, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,21,FOLLOW_21_in_ruleEPackageDecl552); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele6KeywordNsPrefix(), null); 
                
            match(input,17,FOLLOW_17_in_ruleEPackageDecl561); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele7KeywordEqualsSign(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:301:1: (lv_nsPrefix_8= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:304:6: lv_nsPrefix_8= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele80ParserRuleCallQID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl595);
            lv_nsPrefix_8=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "nsPrefix", lv_nsPrefix_8, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,22,FOLLOW_22_in_ruleEPackageDecl608); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele9KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:326:1: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:326:2: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:326:2: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:329:6: lv_eSubpackages_10= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele1000ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl643);
            	    lv_eSubpackages_10=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:348:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:348:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:351:6: lv_eClassifiers_11= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele1010ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl687);
            	    lv_eClassifiers_11=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEPackageDecl().getRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleEPackageDecl702); 

                    createLeafNode(grammarAccess.prEPackageDecl().ele11KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:380:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:380:57: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:381:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubEPackageDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl735);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();
            _fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubEPackageDecl745); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:388:1: ruleSubEPackageDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eSubpackages_4 = null;

        EObject lv_eClassifiers_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:393:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:394:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:394:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:394:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:394:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:397:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl804);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getClassifier());
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

            match(input,19,FOLLOW_19_in_ruleSubEPackageDecl818); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele1KeywordPackage(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:419:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:421:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubEPackageDecl840); 

            		createLeafNode(grammarAccess.prSubEPackageDecl().ele20TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,22,FOLLOW_22_in_ruleSubEPackageDecl857); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele3KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:443:1: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:443:2: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:443:2: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:446:6: lv_eSubpackages_4= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele400ParserRuleCallSubEPackageDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl892);
            	    lv_eSubpackages_4=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:465:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:465:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:6: lv_eClassifiers_5= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele410ParserRuleCallEClassifierDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl936);
            	    lv_eClassifiers_5=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSubEPackageDecl().getRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleSubEPackageDecl951); 

                    createLeafNode(grammarAccess.prSubEPackageDecl().ele5KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:497:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:497:57: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:498:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassifierDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl984);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();
            _fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassifierDecl994); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:505:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl_0 = null;

        EObject this_EDataTypeDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:510:6: ( (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:511:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:511:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:512:5: this_EClassDecl_0= ruleEClassDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele0ParserRuleCallEClassDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1041);
                    this_EClassDecl_0=ruleEClassDecl();
                    _fsp--;

                     
                            current = this_EClassDecl_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prEClassifierDecl().ele0ParserRuleCallEClassDecl(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:526:5: this_EDataTypeDecl_1= ruleEDataTypeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1075);
                    this_EDataTypeDecl_1=ruleEDataTypeDecl();
                    _fsp--;

                     
                            current = this_EDataTypeDecl_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl(), null); 
                        

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:545:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:545:55: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:546:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEDataTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1114);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();
            _fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEDataTypeDecl1124); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:553:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable_1=null;
        Token lv_name_3=null;
        EObject lv_eAnnotations_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5 = null;

        EObject this_EEnumDecl_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:558:6: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:3: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:559:3: (lv_eAnnotations_0= ruleEAnnotationDecl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:562:6: lv_eAnnotations_0= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele000ParserRuleCallEAnnotationDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1184);
                    	    lv_eAnnotations_0=ruleEAnnotationDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getClassifier());
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:580:3: (lv_serializable_1= RULE_SERIALIZABLE )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_SERIALIZABLE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:582:6: lv_serializable_1= RULE_SERIALIZABLE
                            {
                            lv_serializable_1=(Token)input.LT(1);
                            match(input,RULE_SERIALIZABLE,FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl1211); 

                            		createLeafNode(grammarAccess.prEDataTypeDecl().ele010TerminalRuleCallSerializable(), "serializable"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "serializable", lv_serializable_1, "Serializable", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:3: ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:600:4: 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';'
                    {
                    match(input,24,FOLLOW_24_in_ruleEDataTypeDecl1230); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele020KeywordDatatype(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:604:1: (lv_name_3= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:606:6: lv_name_3= RULE_ID
                    {
                    lv_name_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEDataTypeDecl1252); 

                    		createLeafNode(grammarAccess.prEDataTypeDecl().ele0210TerminalRuleCallID(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,25,FOLLOW_25_in_ruleEDataTypeDecl1269); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele022KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:628:1: (lv_instanceClassName_5= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:631:6: lv_instanceClassName_5= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele0230ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1303);
                    lv_instanceClassName_5=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEDataTypeDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "instanceClassName", lv_instanceClassName_5, "STRING_OR_QID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    match(input,18,FOLLOW_18_in_ruleEDataTypeDecl1316); 

                            createLeafNode(grammarAccess.prEDataTypeDecl().ele024KeywordSemicolon(), null); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:655:5: this_EEnumDecl_7= ruleEEnumDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1346);
                    this_EEnumDecl_7=ruleEEnumDecl();
                    _fsp--;

                     
                            current = this_EEnumDecl_7; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl(), null); 
                        

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:674:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:674:57: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:675:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAnnotationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1385);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();
            _fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAnnotationDecl1395); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:1: ruleEAnnotationDecl returns [EObject current=null] : ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_source_1 = null;

        EObject lv_details_3 = null;

        EObject lv_details_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:687:6: ( ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:688:1: ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:688:1: ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:688:2: '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )?
            {
            match(input,26,FOLLOW_26_in_ruleEAnnotationDecl1429); 

                    createLeafNode(grammarAccess.prEAnnotationDecl().ele0KeywordCommercialAt(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:692:1: (lv_source_1= ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:695:6: lv_source_1= ruleSTRING_OR_QID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele10ParserRuleCallSTRING_OR_QID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1463);
            lv_source_1=ruleSTRING_OR_QID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "source", lv_source_1, "STRING_OR_QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:713:2: ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:713:3: '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')'
                    {
                    match(input,27,FOLLOW_27_in_ruleEAnnotationDecl1477); 

                            createLeafNode(grammarAccess.prEAnnotationDecl().ele20KeywordLeftParenthesis(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:717:1: (lv_details_3= ruleMapEntry )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:720:6: lv_details_3= ruleMapEntry
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele210ParserRuleCallMapEntry(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1511);
                    lv_details_3=ruleMapEntry();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "details", lv_details_3, "MapEntry", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:738:2: ( ',' (lv_details_5= ruleMapEntry ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:738:3: ',' (lv_details_5= ruleMapEntry )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEAnnotationDecl1525); 

                    	            createLeafNode(grammarAccess.prEAnnotationDecl().ele220KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:742:1: (lv_details_5= ruleMapEntry )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:745:6: lv_details_5= ruleMapEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele2210ParserRuleCallMapEntry(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1559);
                    	    lv_details_5=ruleMapEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEAnnotationDecl().getRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "details", lv_details_5, "MapEntry", currentNode);
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

                    match(input,29,FOLLOW_29_in_ruleEAnnotationDecl1574); 

                            createLeafNode(grammarAccess.prEAnnotationDecl().ele23KeywordRightParenthesis(), null); 
                        

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
    // $ANTLR end ruleEAnnotationDecl


    // $ANTLR start entryRuleEClassDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:774:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:774:52: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:775:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEClassDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1609);
            iv_ruleEClassDecl=ruleEClassDecl();
            _fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassDecl1619); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:782:1: ruleEClassDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:787:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:788:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:788:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:788:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:788:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:791:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1678);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:809:3: (lv_abstract_1= 'abstract' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:811:6: lv_abstract_1= 'abstract'
                    {
                    lv_abstract_1=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleEClassDecl1704); 

                            createLeafNode(grammarAccess.prEClassDecl().ele10KeywordAbstract(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:830:3: ( (lv_interface_2= 'interface' ) | 'class' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("830:3: ( (lv_interface_2= 'interface' ) | 'class' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:830:4: (lv_interface_2= 'interface' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:830:4: (lv_interface_2= 'interface' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:832:6: lv_interface_2= 'interface'
                    {
                    lv_interface_2=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleEClassDecl1740); 

                            createLeafNode(grammarAccess.prEClassDecl().ele200KeywordInterface(), "interface"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:852:6: 'class'
                    {
                    match(input,32,FOLLOW_32_in_ruleEClassDecl1768); 

                            createLeafNode(grammarAccess.prEClassDecl().ele21KeywordClass(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:856:2: (lv_name_4= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:858:6: lv_name_4= RULE_ID
            {
            lv_name_4=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEClassDecl1791); 

            		createLeafNode(grammarAccess.prEClassDecl().ele30TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_4, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:876:2: ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:876:3: '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>'
                    {
                    match(input,33,FOLLOW_33_in_ruleEClassDecl1809); 

                            createLeafNode(grammarAccess.prEClassDecl().ele40KeywordLessThanSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:880:1: (lv_eTypeParameters_6= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:6: lv_eTypeParameters_6= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele410ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1843);
                    lv_eTypeParameters_6=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eTypeParameters", lv_eTypeParameters_6, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:901:2: ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==28) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:901:3: ',' (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEClassDecl1857); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele420KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:905:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:908:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele4210ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1891);
                    	    lv_eTypeParameters_8=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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

                    match(input,34,FOLLOW_34_in_ruleEClassDecl1906); 

                            createLeafNode(grammarAccess.prEClassDecl().ele43KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:930:3: ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:930:4: 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    {
                    match(input,35,FOLLOW_35_in_ruleEClassDecl1918); 

                            createLeafNode(grammarAccess.prEClassDecl().ele50KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:934:1: (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:937:6: lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele510ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1952);
                    lv_eGenericSuperTypes_11=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eGenericSuperTypes", lv_eGenericSuperTypes_11, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:955:2: ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==28) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:955:3: ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEClassDecl1966); 

                    	            createLeafNode(grammarAccess.prEClassDecl().ele520KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:959:1: (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:962:6: lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele5210ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2000);
                    	    lv_eGenericSuperTypes_13=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:980:6: ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:980:7: ':' (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    {
                    match(input,25,FOLLOW_25_in_ruleEClassDecl2018); 

                            createLeafNode(grammarAccess.prEClassDecl().ele60KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:984:1: (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:987:6: lv_instanceClassName_15= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele610ParserRuleCallSTRING_OR_QID(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2052);
                    lv_instanceClassName_15=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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

            match(input,22,FOLLOW_22_in_ruleEClassDecl2067); 

                    createLeafNode(grammarAccess.prEClassDecl().ele7KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1009:1: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1009:2: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1009:2: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1012:6: lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele800ParserRuleCallEStructuralFeatureDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2102);
            	    lv_eStructuralFeatures_17=ruleEStructuralFeatureDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1031:6: (lv_eOperations_18= ruleEOperationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1031:6: (lv_eOperations_18= ruleEOperationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1034:6: lv_eOperations_18= ruleEOperationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele810ParserRuleCallEOperationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2146);
            	    lv_eOperations_18=ruleEOperationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEClassDecl().getRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleEClassDecl2161); 

                    createLeafNode(grammarAccess.prEClassDecl().ele9KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1063:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1063:64: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1064:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEStructuralFeatureDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2194);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();
            _fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2204); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1071:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl_0 = null;

        EObject this_EReferenceDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1076:6: ( (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1077:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1077:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1078:5: this_EAttributeDecl_0= ruleEAttributeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2251);
                    this_EAttributeDecl_0=ruleEAttributeDecl();
                    _fsp--;

                     
                            current = this_EAttributeDecl_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1092:5: this_EReferenceDecl_1= ruleEReferenceDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2285);
                    this_EReferenceDecl_1=ruleEReferenceDecl();
                    _fsp--;

                     
                            current = this_EReferenceDecl_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl(), null); 
                        

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1111:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1111:56: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1112:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEAttributeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2324);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();
            _fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAttributeDecl2334); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1119:1: ruleEAttributeDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1124:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1128:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2393);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1146:3: ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )*
            loop24:
            do {
                int alt24=9;
                switch ( input.LA(1) ) {
                case 36:
                    {
                    alt24=1;
                    }
                    break;
                case RULE_BAG:
                    {
                    alt24=2;
                    }
                    break;
                case RULE_RANDOM:
                    {
                    alt24=3;
                    }
                    break;
                case RULE_READONLY:
                    {
                    alt24=4;
                    }
                    break;
                case 37:
                    {
                    alt24=5;
                    }
                    break;
                case 38:
                    {
                    alt24=6;
                    }
                    break;
                case 39:
                    {
                    alt24=7;
                    }
                    break;
                case 40:
                    {
                    alt24=8;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1146:4: (lv_iD_1= 'ID' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1146:4: (lv_iD_1= 'ID' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1148:6: lv_iD_1= 'ID'
            	    {
            	    lv_iD_1=(Token)input.LT(1);
            	    match(input,36,FOLLOW_36_in_ruleEAttributeDecl2420); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele100KeywordID(), "iD"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1168:6: (lv_unique_2= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1168:6: (lv_unique_2= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1170:6: lv_unique_2= RULE_BAG
            	    {
            	    lv_unique_2=(Token)input.LT(1);
            	    match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEAttributeDecl2461); 

            	    		createLeafNode(grammarAccess.prEAttributeDecl().ele110TerminalRuleCallBag(), "unique"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "unique", lv_unique_2, "Bag", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:6: (lv_ordered_3= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:6: (lv_ordered_3= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1191:6: lv_ordered_3= RULE_RANDOM
            	    {
            	    lv_ordered_3=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2497); 

            	    		createLeafNode(grammarAccess.prEAttributeDecl().ele120TerminalRuleCallRandom(), "ordered"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "ordered", lv_ordered_3, "Random", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1210:6: (lv_changeable_4= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1210:6: (lv_changeable_4= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1212:6: lv_changeable_4= RULE_READONLY
            	    {
            	    lv_changeable_4=(Token)input.LT(1);
            	    match(input,RULE_READONLY,FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2533); 

            	    		createLeafNode(grammarAccess.prEAttributeDecl().ele130TerminalRuleCallReadonly(), "changeable"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "changeable", lv_changeable_4, "Readonly", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1231:6: (lv_volatile_5= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1231:6: (lv_volatile_5= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1233:6: lv_volatile_5= 'volatile'
            	    {
            	    lv_volatile_5=(Token)input.LT(1);
            	    match(input,37,FOLLOW_37_in_ruleEAttributeDecl2568); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele140KeywordVolatile(), "volatile"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1253:6: (lv_transient_6= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1253:6: (lv_transient_6= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1255:6: lv_transient_6= 'transient'
            	    {
            	    lv_transient_6=(Token)input.LT(1);
            	    match(input,38,FOLLOW_38_in_ruleEAttributeDecl2608); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele150KeywordTransient(), "transient"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1275:6: (lv_unsettable_7= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1275:6: (lv_unsettable_7= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1277:6: lv_unsettable_7= 'unsettable'
            	    {
            	    lv_unsettable_7=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEAttributeDecl2648); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele160KeywordUnsettable(), "unsettable"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1297:6: (lv_derived_8= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1297:6: (lv_derived_8= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1299:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,40,FOLLOW_40_in_ruleEAttributeDecl2688); 

            	            createLeafNode(grammarAccess.prEAttributeDecl().ele170KeywordDerived(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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
            	    break loop24;
                }
            } while (true);

            match(input,41,FOLLOW_41_in_ruleEAttributeDecl2712); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele2KeywordAttr(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1322:1: (lv_eGenericType_10= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1325:6: lv_eGenericType_10= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele30ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2746);
            lv_eGenericType_10=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_10, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1343:2: ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1343:3: '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']'
                    {
                    match(input,42,FOLLOW_42_in_ruleEAttributeDecl2760); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele40KeywordLeftSquareBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1347:1: (lv_lowerBound_12= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1349:6: lv_lowerBound_12= RULE_INT
                    {
                    lv_lowerBound_12=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEAttributeDecl2782); 

                    		createLeafNode(grammarAccess.prEAttributeDecl().ele410TerminalRuleCallINT(), "lowerBound"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "lowerBound", lv_lowerBound_12, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1367:2: ( '..' (lv_upperBound_14= ruleSINT ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==43) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1367:3: '..' (lv_upperBound_14= ruleSINT )
                            {
                            match(input,43,FOLLOW_43_in_ruleEAttributeDecl2800); 

                                    createLeafNode(grammarAccess.prEAttributeDecl().ele420KeywordFullStopFullStop(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1371:1: (lv_upperBound_14= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1374:6: lv_upperBound_14= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele4210ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEAttributeDecl2834);
                            lv_upperBound_14=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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

                    match(input,44,FOLLOW_44_in_ruleEAttributeDecl2849); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele43KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1396:3: (lv_name_16= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1398:6: lv_name_16= RULE_ID
            {
            lv_name_16=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAttributeDecl2873); 

            		createLeafNode(grammarAccess.prEAttributeDecl().ele50TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_16, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1416:2: ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1416:3: '=' (lv_defaultValueLiteral_18= RULE_STRING )
                    {
                    match(input,17,FOLLOW_17_in_ruleEAttributeDecl2891); 

                            createLeafNode(grammarAccess.prEAttributeDecl().ele60KeywordEqualsSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1420:1: (lv_defaultValueLiteral_18= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1422:6: lv_defaultValueLiteral_18= RULE_STRING
                    {
                    lv_defaultValueLiteral_18=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAttributeDecl2913); 

                    		createLeafNode(grammarAccess.prEAttributeDecl().ele610TerminalRuleCallSTRING(), "defaultValueLiteral"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEAttributeDecl().getRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleEAttributeDecl2932); 

                    createLeafNode(grammarAccess.prEAttributeDecl().ele7KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1451:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1451:56: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1452:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2965);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();
            _fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEReferenceDecl2975); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1459:1: ruleEReferenceDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1464:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==26) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1468:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3034);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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
            	    break loop28;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1486:3: ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )*
            loop29:
            do {
                int alt29=9;
                switch ( input.LA(1) ) {
                case RULE_LOCAL:
                    {
                    alt29=1;
                    }
                    break;
                case RULE_BAG:
                    {
                    alt29=2;
                    }
                    break;
                case RULE_RANDOM:
                    {
                    alt29=3;
                    }
                    break;
                case RULE_READONLY:
                    {
                    alt29=4;
                    }
                    break;
                case 37:
                    {
                    alt29=5;
                    }
                    break;
                case 38:
                    {
                    alt29=6;
                    }
                    break;
                case 39:
                    {
                    alt29=7;
                    }
                    break;
                case 40:
                    {
                    alt29=8;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1486:4: (lv_resolveProxies_1= RULE_LOCAL )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1486:4: (lv_resolveProxies_1= RULE_LOCAL )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1488:6: lv_resolveProxies_1= RULE_LOCAL
            	    {
            	    lv_resolveProxies_1=(Token)input.LT(1);
            	    match(input,RULE_LOCAL,FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl3062); 

            	    		createLeafNode(grammarAccess.prEReferenceDecl().ele100TerminalRuleCallLocal(), "resolveProxies"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "resolveProxies", lv_resolveProxies_1, "Local", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1507:6: (lv_unique_2= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1507:6: (lv_unique_2= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1509:6: lv_unique_2= RULE_BAG
            	    {
            	    lv_unique_2=(Token)input.LT(1);
            	    match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEReferenceDecl3098); 

            	    		createLeafNode(grammarAccess.prEReferenceDecl().ele110TerminalRuleCallBag(), "unique"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "unique", lv_unique_2, "Bag", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1528:6: (lv_ordered_3= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1528:6: (lv_ordered_3= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1530:6: lv_ordered_3= RULE_RANDOM
            	    {
            	    lv_ordered_3=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl3134); 

            	    		createLeafNode(grammarAccess.prEReferenceDecl().ele120TerminalRuleCallRandom(), "ordered"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "ordered", lv_ordered_3, "Random", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1549:6: (lv_changeable_4= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1549:6: (lv_changeable_4= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1551:6: lv_changeable_4= RULE_READONLY
            	    {
            	    lv_changeable_4=(Token)input.LT(1);
            	    match(input,RULE_READONLY,FOLLOW_RULE_READONLY_in_ruleEReferenceDecl3170); 

            	    		createLeafNode(grammarAccess.prEReferenceDecl().ele130TerminalRuleCallReadonly(), "changeable"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "changeable", lv_changeable_4, "Readonly", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1570:6: (lv_volatile_5= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1570:6: (lv_volatile_5= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1572:6: lv_volatile_5= 'volatile'
            	    {
            	    lv_volatile_5=(Token)input.LT(1);
            	    match(input,37,FOLLOW_37_in_ruleEReferenceDecl3205); 

            	            createLeafNode(grammarAccess.prEReferenceDecl().ele140KeywordVolatile(), "volatile"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1592:6: (lv_transient_6= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1592:6: (lv_transient_6= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1594:6: lv_transient_6= 'transient'
            	    {
            	    lv_transient_6=(Token)input.LT(1);
            	    match(input,38,FOLLOW_38_in_ruleEReferenceDecl3245); 

            	            createLeafNode(grammarAccess.prEReferenceDecl().ele150KeywordTransient(), "transient"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1614:6: (lv_unsettable_7= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1614:6: (lv_unsettable_7= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1616:6: lv_unsettable_7= 'unsettable'
            	    {
            	    lv_unsettable_7=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEReferenceDecl3285); 

            	            createLeafNode(grammarAccess.prEReferenceDecl().ele160KeywordUnsettable(), "unsettable"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1636:6: (lv_derived_8= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1636:6: (lv_derived_8= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1638:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,40,FOLLOW_40_in_ruleEReferenceDecl3325); 

            	            createLeafNode(grammarAccess.prEReferenceDecl().ele170KeywordDerived(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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
            	    break loop29;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1657:4: ( (lv_containment_9= 'val' ) | 'ref' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            else if ( (LA30_0==46) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1657:4: ( (lv_containment_9= 'val' ) | 'ref' )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1657:5: (lv_containment_9= 'val' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1657:5: (lv_containment_9= 'val' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1659:6: lv_containment_9= 'val'
                    {
                    lv_containment_9=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleEReferenceDecl3362); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele200KeywordVal(), "containment"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1679:6: 'ref'
                    {
                    match(input,46,FOLLOW_46_in_ruleEReferenceDecl3390); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele21KeywordRef(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1683:2: (lv_eGenericType_11= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1686:6: lv_eGenericType_11= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele30ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3425);
            lv_eGenericType_11=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_11, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1704:2: ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1704:3: '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']'
                    {
                    match(input,42,FOLLOW_42_in_ruleEReferenceDecl3439); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele40KeywordLeftSquareBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1708:1: (lv_lowerBound_13= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1710:6: lv_lowerBound_13= RULE_INT
                    {
                    lv_lowerBound_13=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEReferenceDecl3461); 

                    		createLeafNode(grammarAccess.prEReferenceDecl().ele410TerminalRuleCallINT(), "lowerBound"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "lowerBound", lv_lowerBound_13, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:2: ( '..' (lv_upperBound_15= ruleSINT ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==43) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1728:3: '..' (lv_upperBound_15= ruleSINT )
                            {
                            match(input,43,FOLLOW_43_in_ruleEReferenceDecl3479); 

                                    createLeafNode(grammarAccess.prEReferenceDecl().ele420KeywordFullStopFullStop(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1732:1: (lv_upperBound_15= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1735:6: lv_upperBound_15= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele4210ParserRuleCallSINT(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEReferenceDecl3513);
                            lv_upperBound_15=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
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

                    match(input,44,FOLLOW_44_in_ruleEReferenceDecl3528); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele43KeywordRightSquareBracket(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1757:3: ( '#' ( RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1757:4: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEReferenceDecl3540); 

                            createLeafNode(grammarAccess.prEReferenceDecl().ele50KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1761:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1764:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3562); 

                    		createLeafNode(grammarAccess.prEReferenceDecl().ele510CrossReferenceIDEReference(), "eOpposite"); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1777:4: (lv_name_19= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1779:6: lv_name_19= RULE_ID
            {
            lv_name_19=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3589); 

            		createLeafNode(grammarAccess.prEReferenceDecl().ele60TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEReferenceDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_19, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,18,FOLLOW_18_in_ruleEReferenceDecl3606); 

                    createLeafNode(grammarAccess.prEReferenceDecl().ele7KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1808:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1808:51: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1809:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3639);
            iv_ruleEEnumDecl=ruleEEnumDecl();
            _fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumDecl3649); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1816:1: ruleEEnumDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eLiterals_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1821:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1822:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1822:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1822:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1822:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==26) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1825:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3708);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEEnumDecl().getRule().getType().getClassifier());
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

            match(input,48,FOLLOW_48_in_ruleEEnumDecl3722); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele1KeywordEnum(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1847:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1849:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumDecl3744); 

            		createLeafNode(grammarAccess.prEEnumDecl().ele20TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEEnumDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,22,FOLLOW_22_in_ruleEEnumDecl3761); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele3KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1871:1: (lv_eLiterals_4= ruleEEnumLiteralDecl )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID||LA35_0==26) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1874:6: lv_eLiterals_4= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele40ParserRuleCallEEnumLiteralDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3795);
            	    lv_eLiterals_4=ruleEEnumLiteralDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEEnumDecl().getRule().getType().getClassifier());
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
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            match(input,23,FOLLOW_23_in_ruleEEnumDecl3809); 

                    createLeafNode(grammarAccess.prEEnumDecl().ele5KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1903:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1903:58: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1904:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEEnumLiteralDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3842);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();
            _fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3852); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1911:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_value_3=null;
        Token lv_literal_4=null;
        EObject lv_eAnnotations_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1916:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1917:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1917:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1917:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1917:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==26) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1920:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEEnumLiteralDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3911);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getClassifier());
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
            	    break loop36;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1938:3: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1940:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3938); 

            		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele10TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1958:2: ( '=' (lv_value_3= RULE_INT ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1958:3: '=' (lv_value_3= RULE_INT )
                    {
                    match(input,17,FOLLOW_17_in_ruleEEnumLiteralDecl3956); 

                            createLeafNode(grammarAccess.prEEnumLiteralDecl().ele20KeywordEqualsSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1962:1: (lv_value_3= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1964:6: lv_value_3= RULE_INT
                    {
                    lv_value_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3978); 

                    		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele210TerminalRuleCallINT(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1982:4: (lv_literal_4= RULE_STRING )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1984:6: lv_literal_4= RULE_STRING
                    {
                    lv_literal_4=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4010); 

                    		createLeafNode(grammarAccess.prEEnumLiteralDecl().ele30TerminalRuleCallSTRING(), "literal"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEEnumLiteralDecl().getRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleEEnumLiteralDecl4028); 

                    createLeafNode(grammarAccess.prEEnumLiteralDecl().ele4KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2013:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2013:60: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2014:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prETypeParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4061);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();
            _fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleETypeParameterDecl4071); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2021:1: ruleETypeParameterDecl returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_eBounds_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2026:6: ( ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2027:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2027:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2027:2: (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2027:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2029:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleETypeParameterDecl4118); 

            		createLeafNode(grammarAccess.prETypeParameterDecl().ele00TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prETypeParameterDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2047:2: ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2047:3: 'extends' (lv_eBounds_2= ruleEGenericTypeDecl )
                    {
                    match(input,35,FOLLOW_35_in_ruleETypeParameterDecl4136); 

                            createLeafNode(grammarAccess.prETypeParameterDecl().ele10KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2051:1: (lv_eBounds_2= ruleEGenericTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2054:6: lv_eBounds_2= ruleEGenericTypeDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prETypeParameterDecl().ele110ParserRuleCallEGenericTypeDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4170);
                    lv_eBounds_2=ruleEGenericTypeDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prETypeParameterDecl().getRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2079:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2079:67: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2080:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4209);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();
            _fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4219); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2087:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2092:6: ( ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2093:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2093:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                alt42=1;
            }
            else if ( (LA42_0==47) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2093:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2093:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2093:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2093:3: ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2093:3: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2096:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4267); 

                    		createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele000CrossReferenceIDEClassifier(), "eClassifier"); 
                    	

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2109:2: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==33) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2109:3: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>'
                            {
                            match(input,33,FOLLOW_33_in_ruleEGenericTypeReferenceDecl4280); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele010KeywordLessThanSign(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2113:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2116:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele0110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4314);
                            lv_eTypeArguments_2=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "eTypeArguments", lv_eTypeArguments_2, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2134:2: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==28) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2134:3: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,28,FOLLOW_28_in_ruleEGenericTypeReferenceDecl4328); 

                            	            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele0120KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2138:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2141:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele01210ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4362);
                            	    lv_eTypeArguments_4=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getClassifier());
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
                            	    break loop40;
                                }
                            } while (true);

                            match(input,34,FOLLOW_34_in_ruleEGenericTypeReferenceDecl4377); 

                                    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele013KeywordGreaterThanSign(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2164:6: ( '#' ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2164:6: ( '#' ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2164:7: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeReferenceDecl4396); 

                            createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele10KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2168:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2171:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeReferenceDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4418); 

                    		createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele110CrossReferenceIDETypeParameter(), "eTypeParameter"); 
                    	

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2191:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2191:58: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2192:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEGenericTypeDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4455);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();
            _fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeDecl4465); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2199:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;

        EObject lv_eUpperBound_10 = null;

        EObject lv_eLowerBound_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2204:6: ( ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2205:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2205:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
            int alt46=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt46=1;
                }
                break;
            case 47:
                {
                alt46=2;
                }
                break;
            case 49:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2205:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2205:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2205:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2205:3: ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2205:3: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2208:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4513); 

                    		createLeafNode(grammarAccess.prEGenericTypeDecl().ele000CrossReferenceIDEClassifier(), "eClassifier"); 
                    	

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2221:2: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==33) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2221:3: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>'
                            {
                            match(input,33,FOLLOW_33_in_ruleEGenericTypeDecl4526); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele010KeywordLessThanSign(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2225:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2228:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4560);
                            lv_eTypeArguments_2=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "eTypeArguments", lv_eTypeArguments_2, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2246:2: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==28) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2246:3: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,28,FOLLOW_28_in_ruleEGenericTypeDecl4574); 

                            	            createLeafNode(grammarAccess.prEGenericTypeDecl().ele0120KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2250:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2253:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele01210ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4608);
                            	    lv_eTypeArguments_4=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getClassifier());
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
                            	    break loop43;
                                }
                            } while (true);

                            match(input,34,FOLLOW_34_in_ruleEGenericTypeDecl4623); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele013KeywordGreaterThanSign(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:6: ( '#' ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:6: ( '#' ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:7: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeDecl4642); 

                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele10KeywordNumberSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2283:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4664); 

                    		createLeafNode(grammarAccess.prEGenericTypeDecl().ele110CrossReferenceIDETypeParameter(), "eTypeParameter"); 
                    	

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:7: '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleEGenericTypeDecl4684); 

                            createLeafNode(grammarAccess.prEGenericTypeDecl().ele20KeywordQuestionMark(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2301:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==35) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==50) ) {
                        alt45=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("2301:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2301:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2301:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2301:3: 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            {
                            match(input,35,FOLLOW_35_in_ruleEGenericTypeDecl4695); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele2100KeywordExtends(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2305:1: (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2308:6: lv_eUpperBound_10= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele21010ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4729);
                            lv_eUpperBound_10=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getClassifier());
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
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2327:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2327:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2327:7: 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            {
                            match(input,50,FOLLOW_50_in_ruleEGenericTypeDecl4750); 

                                    createLeafNode(grammarAccess.prEGenericTypeDecl().ele2110KeywordSuper(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2331:1: (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2334:6: lv_eLowerBound_12= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele21110ParserRuleCallEGenericTypeDecl(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4784);
                            lv_eLowerBound_12=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prEGenericTypeDecl().getRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2359:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2359:56: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2360:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEOperationDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4824);
            iv_ruleEOperationDecl=ruleEOperationDecl();
            _fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEOperationDecl4834); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2367:1: ruleEOperationDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2372:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==26) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2376:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl4893);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
            	    break loop47;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2394:3: ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )*
            loop48:
            do {
                int alt48=3;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_BAG) ) {
                    alt48=1;
                }
                else if ( (LA48_0==RULE_RANDOM) ) {
                    alt48=2;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2394:4: (lv_unique_1= 'bag' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2394:4: (lv_unique_1= 'bag' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2396:6: lv_unique_1= 'bag'
            	    {
            	    lv_unique_1=(Token)input.LT(1);
            	    match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEOperationDecl4920); 

            	            createLeafNode(grammarAccess.prEOperationDecl().ele100KeywordBag(), "unique"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2416:6: (lv_ordered_2= 'random' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2416:6: (lv_ordered_2= 'random' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2418:6: lv_ordered_2= 'random'
            	    {
            	    lv_ordered_2=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4960); 

            	            createLeafNode(grammarAccess.prEOperationDecl().ele110KeywordRandom(), "ordered"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
            	    break loop48;
                }
            } while (true);

            match(input,51,FOLLOW_51_in_ruleEOperationDecl4984); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele2KeywordOp(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2441:1: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID||LA49_0==47) ) {
                alt49=1;
            }
            else if ( (LA49_0==52) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2441:1: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2441:2: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2441:2: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2444:6: lv_eGenericType_4= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele300ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5019);
                    lv_eGenericType_4=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2463:6: 'void'
                    {
                    match(input,52,FOLLOW_52_in_ruleEOperationDecl5038); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele31KeywordVoid(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2467:2: (lv_name_6= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2469:6: lv_name_6= RULE_ID
            {
            lv_name_6=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEOperationDecl5061); 

            		createLeafNode(grammarAccess.prEOperationDecl().ele40TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_6, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2487:2: ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==33) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2487:3: '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>'
                    {
                    match(input,33,FOLLOW_33_in_ruleEOperationDecl5079); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele50KeywordLessThanSign(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2491:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2494:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele510ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5113);
                    lv_eTypeParameters_8=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eTypeParameters", lv_eTypeParameters_8, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2512:2: ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==28) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2512:3: ',' (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEOperationDecl5127); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele520KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2516:1: (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2519:6: lv_eTypeParameters_10= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele5210ParserRuleCallETypeParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5161);
                    	    lv_eTypeParameters_10=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
                    	    break loop50;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleEOperationDecl5176); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele53KeywordGreaterThanSign(), null); 
                        

                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_ruleEOperationDecl5187); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele6KeywordLeftParenthesis(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:1: ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID||LA53_0==26||LA53_0==47) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:2: (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:2: (lv_eParameters_13= ruleEParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2548:6: lv_eParameters_13= ruleEParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele700ParserRuleCallEParameterDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5222);
                    lv_eParameters_13=ruleEParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eParameters", lv_eParameters_13, "EParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2566:2: ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==28) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2566:3: ',' (lv_eParameters_15= ruleEParameterDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEOperationDecl5236); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele710KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2570:1: (lv_eParameters_15= ruleEParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2573:6: lv_eParameters_15= ruleEParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele7110ParserRuleCallEParameterDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5270);
                    	    lv_eParameters_15=ruleEParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_ruleEOperationDecl5287); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele8KeywordRightParenthesis(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2595:1: ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==53) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2595:2: 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    {
                    match(input,53,FOLLOW_53_in_ruleEOperationDecl5297); 

                            createLeafNode(grammarAccess.prEOperationDecl().ele90KeywordThrows(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2599:1: (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2602:6: lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele910ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5331);
                    lv_eGenericExceptions_18=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eGenericExceptions", lv_eGenericExceptions_18, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:2: ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==28) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:3: ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEOperationDecl5345); 

                    	            createLeafNode(grammarAccess.prEOperationDecl().ele920KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2624:1: (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2627:6: lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele9210ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5379);
                    	    lv_eGenericExceptions_20=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prEOperationDecl().getRule().getType().getClassifier());
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
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleEOperationDecl5396); 

                    createLeafNode(grammarAccess.prEOperationDecl().ele10KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2656:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2656:56: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2657:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEParameterDecl().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5429);
            iv_ruleEParameterDecl=ruleEParameterDecl();
            _fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEParameterDecl5439); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2664:1: ruleEParameterDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2669:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2670:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2670:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2670:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2670:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==26) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2673:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele00ParserRuleCallEAnnotationDecl(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5498);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEParameterDecl().getRule().getType().getClassifier());
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
            	    break loop56;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2691:3: (lv_eGenericType_1= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2694:6: lv_eGenericType_1= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele10ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5537);
            lv_eGenericType_1=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEParameterDecl().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_1, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2712:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2714:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEParameterDecl5563); 

            		createLeafNode(grammarAccess.prEParameterDecl().ele20TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEParameterDecl().getRule().getType().getClassifier());
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


    // $ANTLR start entryRuleMapEntry
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2739:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2739:50: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2740:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMapEntry().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntry_in_entryRuleMapEntry5604);
            iv_ruleMapEntry=ruleMapEntry();
            _fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntry5614); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2747:1: ruleMapEntry returns [EObject current=null] : ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_key_0=null;
        Token lv_value_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2752:6: ( ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2753:1: ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2753:1: ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2753:2: (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2753:2: (lv_key_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2755:6: lv_key_0= RULE_ID
            {
            lv_key_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMapEntry5661); 

            		createLeafNode(grammarAccess.prMapEntry().ele00TerminalRuleCallID(), "key"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMapEntry().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "key", lv_key_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,17,FOLLOW_17_in_ruleMapEntry5678); 

                    createLeafNode(grammarAccess.prMapEntry().ele1KeywordEqualsSign(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2777:1: (lv_value_2= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2779:6: lv_value_2= RULE_STRING
            {
            lv_value_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMapEntry5700); 

            		createLeafNode(grammarAccess.prMapEntry().ele20TerminalRuleCallSTRING(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prMapEntry().getRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_2, "STRING", lastConsumedNode);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2804:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2804:44: (iv_ruleQID= ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2805:2: iv_ruleQID= ruleQID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prQID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID5742);
            iv_ruleQID=ruleQID();
            _fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID5753); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2812:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2818:6: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2819:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2819:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2819:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID5793); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prQID().ele0TerminalRuleCallID(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2826:1: ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=54 && LA58_0<=55)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2826:2: (kw= '.' | kw= '$' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2826:2: (kw= '.' | kw= '$' )
            	    int alt57=2;
            	    int LA57_0 = input.LA(1);

            	    if ( (LA57_0==54) ) {
            	        alt57=1;
            	    }
            	    else if ( (LA57_0==55) ) {
            	        alt57=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("2826:2: (kw= '.' | kw= '$' )", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2827:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,54,FOLLOW_54_in_ruleQID5813); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele100KeywordFullStop(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2834:2: kw= '$'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,55,FOLLOW_55_in_ruleQID5832); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.prQID().ele101Keyword$(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID5848); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        createLeafNode(grammarAccess.prQID().ele11TerminalRuleCallID(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop58;
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2854:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2854:54: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2855:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSTRING_OR_QID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID5894);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();
            _fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_OR_QID5905); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2862:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_QID_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2868:6: ( (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2869:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2869:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_STRING) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2869:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2869:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID5945); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.prSTRING_OR_QID().ele0TerminalRuleCallSTRING(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2878:5: this_QID_1= ruleQID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prSTRING_OR_QID().ele1ParserRuleCallQID(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQID_in_ruleSTRING_OR_QID5978);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2896:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2896:45: (iv_ruleSINT= ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2897:2: iv_ruleSINT= ruleSINT EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSINT().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSINT_in_entryRuleSINT6022);
            iv_ruleSINT=ruleSINT();
            _fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSINT6033); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2904:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2910:6: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2911:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2911:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2911:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2911:2: (kw= '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2912:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleSINT6072); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.prSINT().ele0KeywordHyphenMinus(), null); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSINT6089); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.prSINT().ele1TerminalRuleCallINT(), null); 
                

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
        "\23\uffff";
    static final String DFA4_eofS =
        "\23\uffff";
    static final String DFA4_minS =
        "\1\6\1\uffff\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21"+
        "\1\5\1\34";
    static final String DFA4_maxS =
        "\1\60\1\uffff\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1"+
        "\60\1\21\1\5\1\35";
    static final String DFA4_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\2\16\uffff";
    static final String DFA4_specialS =
        "\23\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\4\14\uffff\1\3\3\uffff\1\1\1\4\1\uffff\1\2\3\uffff\3\4\17"+
            "\uffff\1\4",
            "",
            "\1\6\1\5",
            "",
            "",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\12",
            "\1\13",
            "\1\13",
            "\1\14",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\15",
            "\1\16\1\17",
            "\1\20",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\3\uffff\3\4\17\uffff"+
            "\1\4",
            "\1\21",
            "\1\22",
            "\1\16\1\17"
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
            return "()* loopback of 326:1: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*";
        }
    }
    static final String DFA6_eotS =
        "\23\uffff";
    static final String DFA6_eofS =
        "\23\uffff";
    static final String DFA6_minS =
        "\1\6\1\uffff\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21"+
        "\1\5\1\34";
    static final String DFA6_maxS =
        "\1\60\1\uffff\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1"+
        "\60\1\21\1\5\1\35";
    static final String DFA6_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\2\16\uffff";
    static final String DFA6_specialS =
        "\23\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\4\14\uffff\1\3\3\uffff\1\1\1\4\1\uffff\1\2\3\uffff\3\4\17"+
            "\uffff\1\4",
            "",
            "\1\6\1\5",
            "",
            "",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\12",
            "\1\13",
            "\1\13",
            "\1\14",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\15",
            "\1\16\1\17",
            "\1\20",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\3\uffff\3\4\17\uffff"+
            "\1\4",
            "\1\21",
            "\1\22",
            "\1\16\1\17"
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
            return "()* loopback of 443:1: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*";
        }
    }
    static final String DFA7_eotS =
        "\22\uffff";
    static final String DFA7_eofS =
        "\22\uffff";
    static final String DFA7_minS =
        "\1\6\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21\1\5\1\34";
    static final String DFA7_maxS =
        "\1\60\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1\60\1\21"+
        "\1\5\1\35";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA7_specialS =
        "\22\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\21\uffff\1\3\1\uffff\1\1\3\uffff\3\2\17\uffff\1\3",
            "\1\5\1\4",
            "",
            "",
            "\1\3\21\uffff\1\3\1\uffff\1\1\1\6\2\uffff\3\2\17\uffff\1\3",
            "\1\3\21\uffff\1\3\1\uffff\1\1\1\6\2\uffff\3\2\17\uffff\1\3\5"+
            "\uffff\1\7\1\10",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\3\21\uffff\1\3\1\uffff\1\1\1\6\2\uffff\3\2\17\uffff\1\3\5"+
            "\uffff\1\7\1\10",
            "\1\14",
            "\1\15\1\16",
            "\1\17",
            "\1\3\21\uffff\1\3\1\uffff\1\1\3\uffff\3\2\17\uffff\1\3",
            "\1\20",
            "\1\21",
            "\1\15\1\16"
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
            return "511:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )";
        }
    }
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\22\uffff";
    static final String DFA10_minS =
        "\1\6\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21\1\5\1\34";
    static final String DFA10_maxS =
        "\1\60\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1\60\1\21"+
        "\1\5\1\35";
    static final String DFA10_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA10_specialS =
        "\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\21\uffff\1\2\1\uffff\1\1\25\uffff\1\3",
            "\1\5\1\4",
            "",
            "",
            "\1\2\21\uffff\1\2\1\uffff\1\1\1\6\24\uffff\1\3",
            "\1\2\21\uffff\1\2\1\uffff\1\1\1\6\24\uffff\1\3\5\uffff\1\7\1"+
            "\10",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\2\21\uffff\1\2\1\uffff\1\1\1\6\24\uffff\1\3\5\uffff\1\7\1"+
            "\10",
            "\1\14",
            "\1\15\1\16",
            "\1\17",
            "\1\2\21\uffff\1\2\1\uffff\1\1\25\uffff\1\3",
            "\1\20",
            "\1\21",
            "\1\15\1\16"
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
            return "559:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )";
        }
    }
    static final String DFA21_eotS =
        "\25\uffff";
    static final String DFA21_eofS =
        "\25\uffff";
    static final String DFA21_minS =
        "\1\7\1\uffff\1\4\1\uffff\2\7\1\uffff\2\7\3\4\1\21\1\7\1\5\1\34\1"+
        "\4\1\7\1\21\1\5\1\34";
    static final String DFA21_maxS =
        "\1\63\1\uffff\1\5\1\uffff\2\63\1\uffff\1\63\1\67\3\4\1\21\1\67\1"+
        "\5\1\35\1\4\1\63\1\21\1\5\1\35";
    static final String DFA21_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\2\uffff\1\2\16\uffff";
    static final String DFA21_specialS =
        "\25\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\4\1\5\1\3\1\uffff\1\3\13\uffff\1\1\2\uffff\1\2\11\uffff\6"+
            "\3\3\uffff\2\3\4\uffff\1\6",
            "",
            "\1\10\1\7",
            "",
            "\1\4\1\5\1\3\1\uffff\1\3\30\uffff\6\3\3\uffff\2\3\4\uffff\1"+
            "\6",
            "\1\4\1\5\1\3\1\uffff\1\3\30\uffff\6\3\3\uffff\2\3\4\uffff\1"+
            "\6",
            "",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\1\11\10\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\1\11\10\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6\2\uffff\1\12\1\13",
            "\1\14",
            "\1\15",
            "\1\15",
            "\1\16",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\1\11\10\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6\2\uffff\1\12\1\13",
            "\1\17",
            "\1\20\1\21",
            "\1\22",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\11\uffff\6\3\3\uffff\2"+
            "\3\4\uffff\1\6",
            "\1\23",
            "\1\24",
            "\1\20\1\21"
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
            return "()* loopback of 1009:1: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*";
        }
    }
    static final String DFA22_eotS =
        "\31\uffff";
    static final String DFA22_eofS =
        "\31\uffff";
    static final String DFA22_minS =
        "\1\7\1\4\1\uffff\7\7\1\uffff\2\7\3\4\1\21\1\7\1\5\1\34\1\4\1\7\1"+
        "\21\1\5\1\34";
    static final String DFA22_maxS =
        "\1\56\1\5\1\uffff\7\56\1\uffff\1\56\1\67\3\4\1\21\1\67\1\5\1\35"+
        "\1\4\1\56\1\21\1\5\1\35";
    static final String DFA22_acceptS =
        "\2\uffff\1\1\7\uffff\1\2\16\uffff";
    static final String DFA22_specialS =
        "\31\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\11\uffff\1\2\1\6\1\7"+
            "\1\10\1\11\1\2\3\uffff\2\12",
            "\1\14\1\13",
            "",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1\2"+
            "\3\uffff\2\12",
            "",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\1\15\10\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\1\15\10\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\2\3\uffff\2\12\7\uffff\1\16\1\17",
            "\1\20",
            "\1\21",
            "\1\21",
            "\1\22",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\1\15\10\uffff\1\2\1\6"+
            "\1\7\1\10\1\11\1\2\3\uffff\2\12\7\uffff\1\16\1\17",
            "\1\23",
            "\1\24\1\25",
            "\1\26",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\11\uffff\1\2\1\6\1\7"+
            "\1\10\1\11\1\2\3\uffff\2\12",
            "\1\27",
            "\1\30",
            "\1\24\1\25"
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
            return "1077:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )";
        }
    }
 

    public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatementDecl_in_ruleEcoreDsl140 = new BitSet(new long[]{0x0000000004090000L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatementDecl_in_entryRuleImportStatementDecl216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStatementDecl226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleImportStatementDecl260 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImportStatementDecl283 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleImportStatementDecl300 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImportStatementDecl324 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleImportStatementDecl341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl443 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_19_in_ruleEPackageDecl457 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl491 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEPackageDecl504 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl513 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl535 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEPackageDecl552 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl561 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl595 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEPackageDecl608 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl643 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl687 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_23_in_ruleEPackageDecl702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl804 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_19_in_ruleSubEPackageDecl818 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl840 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSubEPackageDecl857 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl892 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl936 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_23_in_ruleSubEPackageDecl951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1184 = new BitSet(new long[]{0x0000000005000040L});
    public static final BitSet FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl1211 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleEDataTypeDecl1230 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1252 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEDataTypeDecl1269 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1303 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEDataTypeDecl1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleEAnnotationDecl1429 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1463 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleEAnnotationDecl1477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1511 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleEAnnotationDecl1525 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1559 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleEAnnotationDecl1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1678 = new BitSet(new long[]{0x00000001C4000000L});
    public static final BitSet FOLLOW_30_in_ruleEClassDecl1704 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_31_in_ruleEClassDecl1740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_32_in_ruleEClassDecl1768 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1791 = new BitSet(new long[]{0x0000000A02400000L});
    public static final BitSet FOLLOW_33_in_ruleEClassDecl1809 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1843 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1891 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEClassDecl1906 = new BitSet(new long[]{0x0000000802400000L});
    public static final BitSet FOLLOW_35_in_ruleEClassDecl1918 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1952 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1966 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl2000 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_25_in_ruleEClassDecl2018 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2052 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEClassDecl2067 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2102 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2146 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_23_in_ruleEClassDecl2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2393 = new BitSet(new long[]{0x000003F004000380L});
    public static final BitSet FOLLOW_36_in_ruleEAttributeDecl2420 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEAttributeDecl2461 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2497 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2533 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2568 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2608 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2648 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2688 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2712 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2746 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2760 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2782 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2800 = new BitSet(new long[]{0x0100000000000400L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2834 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleEAttributeDecl2849 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2873 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleEAttributeDecl2891 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl2913 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEAttributeDecl2932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl3034 = new BitSet(new long[]{0x000061E004000B80L});
    public static final BitSet FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl3062 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEReferenceDecl3098 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl3134 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_READONLY_in_ruleEReferenceDecl3170 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_37_in_ruleEReferenceDecl3205 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_38_in_ruleEReferenceDecl3245 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_39_in_ruleEReferenceDecl3285 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_40_in_ruleEReferenceDecl3325 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_45_in_ruleEReferenceDecl3362 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_46_in_ruleEReferenceDecl3390 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3425 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_42_in_ruleEReferenceDecl3439 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl3461 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleEReferenceDecl3479 = new BitSet(new long[]{0x0100000000000400L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl3513 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleEReferenceDecl3528 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_47_in_ruleEReferenceDecl3540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3589 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEReferenceDecl3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl3649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3708 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_48_in_ruleEEnumDecl3722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3744 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEEnumDecl3761 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3795 = new BitSet(new long[]{0x0000000004800010L});
    public static final BitSet FOLLOW_23_in_ruleEEnumDecl3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3911 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3938 = new BitSet(new long[]{0x0000000000060020L});
    public static final BitSet FOLLOW_17_in_ruleEEnumLiteralDecl3956 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3978 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl4010 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEEnumLiteralDecl4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl4118 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleETypeParameterDecl4136 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4267 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleEGenericTypeReferenceDecl4280 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4314 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEGenericTypeReferenceDecl4328 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4362 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEGenericTypeReferenceDecl4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl4396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4513 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleEGenericTypeDecl4526 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4560 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEGenericTypeDecl4574 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4608 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEGenericTypeDecl4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl4642 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl4684 = new BitSet(new long[]{0x0004000800000000L});
    public static final BitSet FOLLOW_35_in_ruleEGenericTypeDecl4695 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl4750 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl4893 = new BitSet(new long[]{0x0008000004000180L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEOperationDecl4920 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4960 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_51_in_ruleEOperationDecl4984 = new BitSet(new long[]{0x0010800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52_in_ruleEOperationDecl5038 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl5061 = new BitSet(new long[]{0x0000000208000000L});
    public static final BitSet FOLLOW_33_in_ruleEOperationDecl5079 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5113 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl5127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5161 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEOperationDecl5176 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleEOperationDecl5187 = new BitSet(new long[]{0x0000800024000010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5222 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl5236 = new BitSet(new long[]{0x0000800004000010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5270 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleEOperationDecl5287 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_53_in_ruleEOperationDecl5297 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5331 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl5345 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5379 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleEOperationDecl5396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5498 = new BitSet(new long[]{0x0000800004000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl5563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry5604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry5614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry5661 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMapEntry5678 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry5700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID5742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID5793 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleQID5813 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleQID5832 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID5848 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID5894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID5905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID5945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID5978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT6022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSINT6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSINT6072 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSINT6089 = new BitSet(new long[]{0x0000000000000002L});

}
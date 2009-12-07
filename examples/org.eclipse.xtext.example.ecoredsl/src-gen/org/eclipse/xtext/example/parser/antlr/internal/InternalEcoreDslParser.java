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
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:72:1: entryRuleEcoreDsl returns [EObject current=null] : iv_ruleEcoreDsl= ruleEcoreDsl EOF ;
    public final EObject entryRuleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEcoreDsl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:72:50: (iv_ruleEcoreDsl= ruleEcoreDsl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:73:2: iv_ruleEcoreDsl= ruleEcoreDsl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEcoreDslRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl73);
            iv_ruleEcoreDsl=ruleEcoreDsl();
            _fsp--;

             current =iv_ruleEcoreDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEcoreDsl83); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:80:1: ruleEcoreDsl returns [EObject current=null] : ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations_0_0 = null;

        EObject lv_package_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:85:6: ( ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:1: ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:1: ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:2: ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:2: ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:87:1: (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:87:1: (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:88:3: lv_metamodelDeclarations_0_0= ruleReferencedMetamodel
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsReferencedMetamodelParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleEcoreDsl129);
            	    lv_metamodelDeclarations_0_0=ruleReferencedMetamodel();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEcoreDslRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"metamodelDeclarations",
            	    	        		lv_metamodelDeclarations_0_0, 
            	    	        		"ReferencedMetamodel", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:110:3: ( (lv_package_1_0= ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:111:1: (lv_package_1_0= ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:111:1: (lv_package_1_0= ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:112:3: lv_package_1_0= ruleEPackageDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEcoreDslAccess().getPackageEPackageDeclParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl151);
            lv_package_1_0=ruleEPackageDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEcoreDslRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"package",
            	        		lv_package_1_0, 
            	        		"EPackageDecl", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleEcoreDsl


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:141:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:141:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:142:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel184);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel194); 

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
    // $ANTLR end entryRuleReferencedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( ( (lv_alias_1_0= RULE_ID ) ) '=' )? ( ( RULE_STRING ) ) ';' ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:154:6: ( ( 'import' ( ( (lv_alias_1_0= RULE_ID ) ) '=' )? ( ( RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:155:1: ( 'import' ( ( (lv_alias_1_0= RULE_ID ) ) '=' )? ( ( RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:155:1: ( 'import' ( ( (lv_alias_1_0= RULE_ID ) ) '=' )? ( ( RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:155:3: 'import' ( ( (lv_alias_1_0= RULE_ID ) ) '=' )? ( ( RULE_STRING ) ) ';'
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleReferencedMetamodel229); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:159:1: ( ( (lv_alias_1_0= RULE_ID ) ) '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:159:2: ( (lv_alias_1_0= RULE_ID ) ) '='
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:159:2: ( (lv_alias_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:160:1: (lv_alias_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:160:1: (lv_alias_1_0= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:161:3: lv_alias_1_0= RULE_ID
                    {
                    lv_alias_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferencedMetamodel247); 

                    			createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_1_0_0(), "alias"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"alias",
                    	        		lv_alias_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,17,FollowSets000.FOLLOW_17_in_ruleReferencedMetamodel262); 

                            createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEqualsSignKeyword_1_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:187:3: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:188:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:188:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:189:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel282); 

            		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	

            }


            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleReferencedMetamodel292); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleEPackageDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:212:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:212:54: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:213:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPackageDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl325);
            iv_ruleEPackageDecl=ruleEPackageDecl();
            _fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPackageDecl335); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:220:1: ruleEPackageDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= ruleQID ) ) 'nsURI' '=' ( (lv_nsURI_5_0= RULE_STRING ) ) 'nsPrefix' '=' ( (lv_nsPrefix_8_0= ruleQID ) ) '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* '}' ) ;
    public final EObject ruleEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_nsURI_5_0=null;
        EObject lv_eAnnotations_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_nsPrefix_8_0 = null;

        EObject lv_eSubpackages_10_0 = null;

        EObject lv_eClassifiers_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:225:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= ruleQID ) ) 'nsURI' '=' ( (lv_nsURI_5_0= RULE_STRING ) ) 'nsPrefix' '=' ( (lv_nsPrefix_8_0= ruleQID ) ) '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:226:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= ruleQID ) ) 'nsURI' '=' ( (lv_nsURI_5_0= RULE_STRING ) ) 'nsPrefix' '=' ( (lv_nsPrefix_8_0= ruleQID ) ) '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:226:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= ruleQID ) ) 'nsURI' '=' ( (lv_nsURI_5_0= RULE_STRING ) ) 'nsPrefix' '=' ( (lv_nsPrefix_8_0= ruleQID ) ) '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:226:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= ruleQID ) ) 'nsURI' '=' ( (lv_nsURI_5_0= RULE_STRING ) ) 'nsPrefix' '=' ( (lv_nsPrefix_8_0= ruleQID ) ) '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:226:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:227:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:227:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:228:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl381);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,19,FollowSets000.FOLLOW_19_in_ruleEPackageDecl392); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:254:1: ( (lv_name_2_0= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:255:1: (lv_name_2_0= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:255:1: (lv_name_2_0= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:256:3: lv_name_2_0= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getNameQIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_ruleEPackageDecl413);
            lv_name_2_0=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"QID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,20,FollowSets000.FOLLOW_20_in_ruleEPackageDecl423); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getNsURIKeyword_3(), null); 
                
            match(input,17,FollowSets000.FOLLOW_17_in_ruleEPackageDecl433); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_4(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:286:1: ( (lv_nsURI_5_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:287:1: (lv_nsURI_5_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:287:1: (lv_nsURI_5_0= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:288:3: lv_nsURI_5_0= RULE_STRING
            {
            lv_nsURI_5_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEPackageDecl450); 

            			createLeafNode(grammarAccess.getEPackageDeclAccess().getNsURISTRINGTerminalRuleCall_5_0(), "nsURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"nsURI",
            	        		lv_nsURI_5_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,21,FollowSets000.FOLLOW_21_in_ruleEPackageDecl465); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getNsPrefixKeyword_6(), null); 
                
            match(input,17,FollowSets000.FOLLOW_17_in_ruleEPackageDecl475); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_7(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:318:1: ( (lv_nsPrefix_8_0= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:319:1: (lv_nsPrefix_8_0= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:319:1: (lv_nsPrefix_8_0= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:320:3: lv_nsPrefix_8_0= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getNsPrefixQIDParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_ruleEPackageDecl496);
            lv_nsPrefix_8_0=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"nsPrefix",
            	        		lv_nsPrefix_8_0, 
            	        		"QID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleEPackageDecl506); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getLeftCurlyBracketKeyword_9(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:346:1: ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:346:2: ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:346:2: ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:347:1: (lv_eSubpackages_10_0= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:347:1: (lv_eSubpackages_10_0= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:348:3: lv_eSubpackages_10_0= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_10_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl528);
            	    lv_eSubpackages_10_0=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eSubpackages",
            	    	        		lv_eSubpackages_10_0, 
            	    	        		"SubEPackageDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:371:6: ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:371:6: ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:372:1: (lv_eClassifiers_11_0= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:372:1: (lv_eClassifiers_11_0= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:373:3: lv_eClassifiers_11_0= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_10_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl555);
            	    lv_eClassifiers_11_0=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eClassifiers",
            	    	        		lv_eClassifiers_11_0, 
            	    	        		"EClassifierDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleEPackageDecl567); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getRightCurlyBracketKeyword_11(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:406:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:406:57: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:407:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubEPackageDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl600);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();
            _fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubEPackageDecl610); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:414:1: ruleSubEPackageDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= RULE_ID ) ) '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eSubpackages_4_0 = null;

        EObject lv_eClassifiers_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:419:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= RULE_ID ) ) '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:420:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= RULE_ID ) ) '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:420:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= RULE_ID ) ) '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:420:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'package' ( (lv_name_2_0= RULE_ID ) ) '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:420:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:421:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:421:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:422:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl656);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,19,FollowSets000.FOLLOW_19_in_ruleSubEPackageDecl667); 

                    createLeafNode(grammarAccess.getSubEPackageDeclAccess().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:448:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:449:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:449:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:450:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubEPackageDecl684); 

            			createLeafNode(grammarAccess.getSubEPackageDeclAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleSubEPackageDecl699); 

                    createLeafNode(grammarAccess.getSubEPackageDeclAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:476:1: ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:476:2: ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:476:2: ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:477:1: (lv_eSubpackages_4_0= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:477:1: (lv_eSubpackages_4_0= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:478:3: lv_eSubpackages_4_0= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_4_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl721);
            	    lv_eSubpackages_4_0=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eSubpackages",
            	    	        		lv_eSubpackages_4_0, 
            	    	        		"SubEPackageDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:501:6: ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:501:6: ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:502:1: (lv_eClassifiers_5_0= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:502:1: (lv_eClassifiers_5_0= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:503:3: lv_eClassifiers_5_0= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_4_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl748);
            	    lv_eClassifiers_5_0=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eClassifiers",
            	    	        		lv_eClassifiers_5_0, 
            	    	        		"EClassifierDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleSubEPackageDecl760); 

                    createLeafNode(grammarAccess.getSubEPackageDeclAccess().getRightCurlyBracketKeyword_5(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:536:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:536:57: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:537:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEClassifierDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl793);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();
            _fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassifierDecl803); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl_0 = null;

        EObject this_EDataTypeDecl_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:549:6: ( (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:551:5: this_EClassDecl_0= ruleEClassDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEClassifierDeclAccess().getEClassDeclParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl850);
                    this_EClassDecl_0=ruleEClassDecl();
                    _fsp--;

                     
                            current = this_EClassDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:561:5: this_EDataTypeDecl_1= ruleEDataTypeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEClassifierDeclAccess().getEDataTypeDeclParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl877);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:576:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:576:55: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:577:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEDataTypeDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl909);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();
            _fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDataTypeDecl919); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:584:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable_1_0=null;
        Token lv_name_3_0=null;
        EObject lv_eAnnotations_0_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5_0 = null;

        EObject this_EEnumDecl_7 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:589:6: ( ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:590:1: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:590:1: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:590:2: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:590:2: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:590:3: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:590:3: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:591:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:591:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:592:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl966);
                    	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"eAnnotations",
                    	    	        		lv_eAnnotations_0_0, 
                    	    	        		"EAnnotationDecl", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:614:3: ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_SERIALIZABLE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:615:1: (lv_serializable_1_0= RULE_SERIALIZABLE )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:615:1: (lv_serializable_1_0= RULE_SERIALIZABLE )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:616:3: lv_serializable_1_0= RULE_SERIALIZABLE
                            {
                            lv_serializable_1_0=(Token)input.LT(1);
                            match(input,RULE_SERIALIZABLE,FollowSets000.FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl984); 

                            			createLeafNode(grammarAccess.getEDataTypeDeclAccess().getSerializableSerializableTerminalRuleCall_0_1_0(), "serializable"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"serializable",
                            	        		lv_serializable_1_0, 
                            	        		"Serializable", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:638:3: ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:638:5: 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleEDataTypeDecl1001); 

                            createLeafNode(grammarAccess.getEDataTypeDeclAccess().getDatatypeKeyword_0_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:642:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:643:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:643:1: (lv_name_3_0= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:644:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEDataTypeDecl1018); 

                    			createLeafNode(grammarAccess.getEDataTypeDeclAccess().getNameIDTerminalRuleCall_0_2_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,25,FollowSets000.FOLLOW_25_in_ruleEDataTypeDecl1033); 

                            createLeafNode(grammarAccess.getEDataTypeDeclAccess().getColonKeyword_0_2_2(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:670:1: ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:671:1: (lv_instanceClassName_5_0= ruleSTRING_OR_QID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:671:1: (lv_instanceClassName_5_0= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:672:3: lv_instanceClassName_5_0= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_0_2_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1054);
                    lv_instanceClassName_5_0=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"instanceClassName",
                    	        		lv_instanceClassName_5_0, 
                    	        		"STRING_OR_QID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleEDataTypeDecl1064); 

                            createLeafNode(grammarAccess.getEDataTypeDeclAccess().getSemicolonKeyword_0_2_4(), null); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:700:5: this_EEnumDecl_7= ruleEEnumDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEDataTypeDeclAccess().getEEnumDeclParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1094);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:715:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:715:57: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:716:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEAnnotationDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1126);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();
            _fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAnnotationDecl1136); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:723:1: ruleEAnnotationDecl returns [EObject current=null] : ( '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) ( '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')' )? ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_source_1_0 = null;

        EObject lv_details_3_0 = null;

        EObject lv_details_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:728:6: ( ( '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) ( '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')' )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:729:1: ( '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) ( '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')' )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:729:1: ( '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) ( '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:729:3: '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) ( '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')' )?
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleEAnnotationDecl1171); 

                    createLeafNode(grammarAccess.getEAnnotationDeclAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:733:1: ( (lv_source_1_0= ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:734:1: (lv_source_1_0= ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:734:1: (lv_source_1_0= ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:735:3: lv_source_1_0= ruleSTRING_OR_QID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEAnnotationDeclAccess().getSourceSTRING_OR_QIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1192);
            lv_source_1_0=ruleSTRING_OR_QID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEAnnotationDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"source",
            	        		lv_source_1_0, 
            	        		"STRING_OR_QID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:757:2: ( '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:757:4: '(' ( (lv_details_3_0= ruleMapEntry ) ) ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )* ')'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_ruleEAnnotationDecl1203); 

                            createLeafNode(grammarAccess.getEAnnotationDeclAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:761:1: ( (lv_details_3_0= ruleMapEntry ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:762:1: (lv_details_3_0= ruleMapEntry )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:762:1: (lv_details_3_0= ruleMapEntry )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:763:3: lv_details_3_0= ruleMapEntry
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1224);
                    lv_details_3_0=ruleMapEntry();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEAnnotationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"details",
                    	        		lv_details_3_0, 
                    	        		"MapEntry", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:785:2: ( ',' ( (lv_details_5_0= ruleMapEntry ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:785:4: ',' ( (lv_details_5_0= ruleMapEntry ) )
                    	    {
                    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEAnnotationDecl1235); 

                    	            createLeafNode(grammarAccess.getEAnnotationDeclAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:789:1: ( (lv_details_5_0= ruleMapEntry ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:790:1: (lv_details_5_0= ruleMapEntry )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:790:1: (lv_details_5_0= ruleMapEntry )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:791:3: lv_details_5_0= ruleMapEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1256);
                    	    lv_details_5_0=ruleMapEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEAnnotationDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"details",
                    	    	        		lv_details_5_0, 
                    	    	        		"MapEntry", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match(input,29,FollowSets000.FOLLOW_29_in_ruleEAnnotationDecl1268); 

                            createLeafNode(grammarAccess.getEAnnotationDeclAccess().getRightParenthesisKeyword_2_3(), null); 
                        

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:824:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:824:52: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:825:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEClassDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1303);
            iv_ruleEClassDecl=ruleEClassDecl();
            _fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassDecl1313); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:832:1: ruleEClassDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | 'class' ) ( (lv_name_4_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>' )? ( 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? ( ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* '}' ) ;
    public final EObject ruleEClassDecl() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token lv_interface_2_0=null;
        Token lv_name_4_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eTypeParameters_6_0 = null;

        EObject lv_eTypeParameters_8_0 = null;

        EObject lv_eGenericSuperTypes_11_0 = null;

        EObject lv_eGenericSuperTypes_13_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_15_0 = null;

        EObject lv_eStructuralFeatures_17_0 = null;

        EObject lv_eOperations_18_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:837:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | 'class' ) ( (lv_name_4_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>' )? ( 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? ( ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | 'class' ) ( (lv_name_4_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>' )? ( 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? ( ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | 'class' ) ( (lv_name_4_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>' )? ( 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? ( ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | 'class' ) ( (lv_name_4_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>' )? ( 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? ( ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:839:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:839:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:840:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1359);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:862:3: ( (lv_abstract_1_0= 'abstract' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:863:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:863:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:864:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)input.LT(1);
                    match(input,30,FollowSets000.FOLLOW_30_in_ruleEClassDecl1378); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:3: ( ( (lv_interface_2_0= 'interface' ) ) | 'class' )
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
                    new NoViableAltException("883:3: ( ( (lv_interface_2_0= 'interface' ) ) | 'class' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:4: ( (lv_interface_2_0= 'interface' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:4: ( (lv_interface_2_0= 'interface' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:884:1: (lv_interface_2_0= 'interface' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:884:1: (lv_interface_2_0= 'interface' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:885:3: lv_interface_2_0= 'interface'
                    {
                    lv_interface_2_0=(Token)input.LT(1);
                    match(input,31,FollowSets000.FOLLOW_31_in_ruleEClassDecl1411); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0(), "interface"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "interface", true, "interface", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:905:7: 'class'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_ruleEClassDecl1440); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getClassKeyword_2_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:909:2: ( (lv_name_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:910:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:910:1: (lv_name_4_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:911:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEClassDecl1458); 

            			createLeafNode(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:933:2: ( '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:933:4: '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* '>'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_ruleEClassDecl1474); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getLessThanSignKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:937:1: ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:938:1: (lv_eTypeParameters_6_0= ruleETypeParameterDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:938:1: (lv_eTypeParameters_6_0= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:939:3: lv_eTypeParameters_6_0= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1495);
                    lv_eTypeParameters_6_0=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"eTypeParameters",
                    	        		lv_eTypeParameters_6_0, 
                    	        		"ETypeParameterDecl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:961:2: ( ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==28) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:961:4: ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) )
                    	    {
                    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEClassDecl1506); 

                    	            createLeafNode(grammarAccess.getEClassDeclAccess().getCommaKeyword_4_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:965:1: ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:966:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:966:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:967:3: lv_eTypeParameters_8_0= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1527);
                    	    lv_eTypeParameters_8_0=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"eTypeParameters",
                    	    	        		lv_eTypeParameters_8_0, 
                    	    	        		"ETypeParameterDecl", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match(input,34,FollowSets000.FOLLOW_34_in_ruleEClassDecl1539); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getGreaterThanSignKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:993:3: ( 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:993:5: 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )*
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_ruleEClassDecl1552); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getExtendsKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:997:1: ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:998:1: (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:998:1: (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:999:3: lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1573);
                    lv_eGenericSuperTypes_11_0=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"eGenericSuperTypes",
                    	        		lv_eGenericSuperTypes_11_0, 
                    	        		"EGenericTypeReferenceDecl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1021:2: ( ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==28) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1021:4: ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) )
                    	    {
                    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEClassDecl1584); 

                    	            createLeafNode(grammarAccess.getEClassDeclAccess().getCommaKeyword_5_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1025:1: ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1026:1: (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1026:1: (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1027:3: lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1605);
                    	    lv_eGenericSuperTypes_13_0=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"eGenericSuperTypes",
                    	    	        		lv_eGenericSuperTypes_13_0, 
                    	    	        		"EGenericTypeReferenceDecl", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1049:6: ( ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1049:8: ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) )
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleEClassDecl1620); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getColonKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1053:1: ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1054:1: (lv_instanceClassName_15_0= ruleSTRING_OR_QID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1054:1: (lv_instanceClassName_15_0= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1055:3: lv_instanceClassName_15_0= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl1641);
                    lv_instanceClassName_15_0=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"instanceClassName",
                    	        		lv_instanceClassName_15_0, 
                    	        		"STRING_OR_QID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleEClassDecl1653); 

                    createLeafNode(grammarAccess.getEClassDeclAccess().getLeftCurlyBracketKeyword_7(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1081:1: ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1081:2: ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1081:2: ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1082:1: (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1082:1: (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1083:3: lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesEStructuralFeatureDeclParserRuleCall_8_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl1675);
            	    lv_eStructuralFeatures_17_0=ruleEStructuralFeatureDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eStructuralFeatures",
            	    	        		lv_eStructuralFeatures_17_0, 
            	    	        		"EStructuralFeatureDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1106:6: ( (lv_eOperations_18_0= ruleEOperationDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1106:6: ( (lv_eOperations_18_0= ruleEOperationDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1107:1: (lv_eOperations_18_0= ruleEOperationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1107:1: (lv_eOperations_18_0= ruleEOperationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1108:3: lv_eOperations_18_0= ruleEOperationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEOperationsEOperationDeclParserRuleCall_8_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEOperationDecl_in_ruleEClassDecl1702);
            	    lv_eOperations_18_0=ruleEOperationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eOperations",
            	    	        		lv_eOperations_18_0, 
            	    	        		"EOperationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleEClassDecl1714); 

                    createLeafNode(grammarAccess.getEClassDeclAccess().getRightCurlyBracketKeyword_9(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1141:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1141:64: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1142:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEStructuralFeatureDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl1747);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();
            _fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl1757); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1149:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl_0 = null;

        EObject this_EReferenceDecl_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1154:6: ( (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1155:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1155:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1156:5: this_EAttributeDecl_0= ruleEAttributeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEStructuralFeatureDeclAccess().getEAttributeDeclParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl1804);
                    this_EAttributeDecl_0=ruleEAttributeDecl();
                    _fsp--;

                     
                            current = this_EAttributeDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1166:5: this_EReferenceDecl_1= ruleEReferenceDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEStructuralFeatureDeclAccess().getEReferenceDeclParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl1831);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1181:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1181:56: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1182:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEAttributeDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl1863);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();
            _fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttributeDecl1873); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:1: ruleEAttributeDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']' )? ( (lv_name_16_0= RULE_ID ) ) ( '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? ';' ) ;
    public final EObject ruleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_iD_1_0=null;
        Token lv_unique_2_0=null;
        Token lv_ordered_3_0=null;
        Token lv_changeable_4_0=null;
        Token lv_volatile_5_0=null;
        Token lv_transient_6_0=null;
        Token lv_unsettable_7_0=null;
        Token lv_derived_8_0=null;
        Token lv_lowerBound_12_0=null;
        Token lv_name_16_0=null;
        Token lv_defaultValueLiteral_18_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_10_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_14_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1194:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']' )? ( (lv_name_16_0= RULE_ID ) ) ( '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1195:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']' )? ( (lv_name_16_0= RULE_ID ) ) ( '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1195:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']' )? ( (lv_name_16_0= RULE_ID ) ) ( '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1195:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']' )? ( (lv_name_16_0= RULE_ID ) ) ( '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1195:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1196:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1196:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1197:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEAttributeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl1919);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1219:3: ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1219:4: ( (lv_iD_1_0= 'ID' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1219:4: ( (lv_iD_1_0= 'ID' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1220:1: (lv_iD_1_0= 'ID' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1220:1: (lv_iD_1_0= 'ID' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1221:3: lv_iD_1_0= 'ID'
            	    {
            	    lv_iD_1_0=(Token)input.LT(1);
            	    match(input,36,FollowSets000.FOLLOW_36_in_ruleEAttributeDecl1939); 

            	            createLeafNode(grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0(), "iD"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "iD", true, "ID", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1241:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1241:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1242:1: (lv_unique_2_0= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1242:1: (lv_unique_2_0= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1243:3: lv_unique_2_0= RULE_BAG
            	    {
            	    lv_unique_2_0=(Token)input.LT(1);
            	    match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_ruleEAttributeDecl1975); 

            	    			createLeafNode(grammarAccess.getEAttributeDeclAccess().getUniqueBagTerminalRuleCall_1_1_0(), "unique"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"unique",
            	    	        		lv_unique_2_0, 
            	    	        		"Bag", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1266:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1266:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1267:1: (lv_ordered_3_0= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1267:1: (lv_ordered_3_0= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1268:3: lv_ordered_3_0= RULE_RANDOM
            	    {
            	    lv_ordered_3_0=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2003); 

            	    			createLeafNode(grammarAccess.getEAttributeDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0(), "ordered"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"ordered",
            	    	        		lv_ordered_3_0, 
            	    	        		"Random", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1291:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1291:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1292:1: (lv_changeable_4_0= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1292:1: (lv_changeable_4_0= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1293:3: lv_changeable_4_0= RULE_READONLY
            	    {
            	    lv_changeable_4_0=(Token)input.LT(1);
            	    match(input,RULE_READONLY,FollowSets000.FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2031); 

            	    			createLeafNode(grammarAccess.getEAttributeDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0(), "changeable"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"changeable",
            	    	        		lv_changeable_4_0, 
            	    	        		"Readonly", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1316:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1316:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1317:1: (lv_volatile_5_0= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1317:1: (lv_volatile_5_0= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1318:3: lv_volatile_5_0= 'volatile'
            	    {
            	    lv_volatile_5_0=(Token)input.LT(1);
            	    match(input,37,FollowSets000.FOLLOW_37_in_ruleEAttributeDecl2060); 

            	            createLeafNode(grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0(), "volatile"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "volatile", true, "volatile", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1338:6: ( (lv_transient_6_0= 'transient' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1338:6: ( (lv_transient_6_0= 'transient' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:1: (lv_transient_6_0= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1339:1: (lv_transient_6_0= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1340:3: lv_transient_6_0= 'transient'
            	    {
            	    lv_transient_6_0=(Token)input.LT(1);
            	    match(input,38,FollowSets000.FOLLOW_38_in_ruleEAttributeDecl2097); 

            	            createLeafNode(grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0(), "transient"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "transient", true, "transient", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1360:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1360:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:1: (lv_unsettable_7_0= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1361:1: (lv_unsettable_7_0= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1362:3: lv_unsettable_7_0= 'unsettable'
            	    {
            	    lv_unsettable_7_0=(Token)input.LT(1);
            	    match(input,39,FollowSets000.FOLLOW_39_in_ruleEAttributeDecl2134); 

            	            createLeafNode(grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0(), "unsettable"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "unsettable", true, "unsettable", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1382:6: ( (lv_derived_8_0= 'derived' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1382:6: ( (lv_derived_8_0= 'derived' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1383:1: (lv_derived_8_0= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1383:1: (lv_derived_8_0= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1384:3: lv_derived_8_0= 'derived'
            	    {
            	    lv_derived_8_0=(Token)input.LT(1);
            	    match(input,40,FollowSets000.FOLLOW_40_in_ruleEAttributeDecl2171); 

            	            createLeafNode(grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "derived", true, "derived", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            match(input,41,FollowSets000.FOLLOW_41_in_ruleEAttributeDecl2196); 

                    createLeafNode(grammarAccess.getEAttributeDeclAccess().getAttrKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1407:1: ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1408:1: (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1408:1: (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1409:3: lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEAttributeDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2217);
            lv_eGenericType_10_0=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"eGenericType",
            	        		lv_eGenericType_10_0, 
            	        		"EGenericTypeReferenceDecl", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1431:2: ( '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1431:4: '[' ( (lv_lowerBound_12_0= RULE_INT ) ) ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? ']'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_ruleEAttributeDecl2228); 

                            createLeafNode(grammarAccess.getEAttributeDeclAccess().getLeftSquareBracketKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1435:1: ( (lv_lowerBound_12_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1436:1: (lv_lowerBound_12_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1436:1: (lv_lowerBound_12_0= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1437:3: lv_lowerBound_12_0= RULE_INT
                    {
                    lv_lowerBound_12_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEAttributeDecl2245); 

                    			createLeafNode(grammarAccess.getEAttributeDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0(), "lowerBound"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"lowerBound",
                    	        		lv_lowerBound_12_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1459:2: ( '..' ( (lv_upperBound_14_0= ruleSINT ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==43) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1459:4: '..' ( (lv_upperBound_14_0= ruleSINT ) )
                            {
                            match(input,43,FollowSets000.FOLLOW_43_in_ruleEAttributeDecl2261); 

                                    createLeafNode(grammarAccess.getEAttributeDeclAccess().getFullStopFullStopKeyword_4_2_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1463:1: ( (lv_upperBound_14_0= ruleSINT ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1464:1: (lv_upperBound_14_0= ruleSINT )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1464:1: (lv_upperBound_14_0= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:3: lv_upperBound_14_0= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEAttributeDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_ruleEAttributeDecl2282);
                            lv_upperBound_14_0=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"upperBound",
                            	        		lv_upperBound_14_0, 
                            	        		"SINT", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    match(input,44,FollowSets000.FOLLOW_44_in_ruleEAttributeDecl2294); 

                            createLeafNode(grammarAccess.getEAttributeDeclAccess().getRightSquareBracketKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1491:3: ( (lv_name_16_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1492:1: (lv_name_16_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1492:1: (lv_name_16_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1493:3: lv_name_16_0= RULE_ID
            {
            lv_name_16_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEAttributeDecl2313); 

            			createLeafNode(grammarAccess.getEAttributeDeclAccess().getNameIDTerminalRuleCall_5_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_16_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1515:2: ( '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1515:4: '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleEAttributeDecl2329); 

                            createLeafNode(grammarAccess.getEAttributeDeclAccess().getEqualsSignKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1519:1: ( (lv_defaultValueLiteral_18_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1520:1: (lv_defaultValueLiteral_18_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1520:1: (lv_defaultValueLiteral_18_0= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1521:3: lv_defaultValueLiteral_18_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_18_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEAttributeDecl2346); 

                    			createLeafNode(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0(), "defaultValueLiteral"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"defaultValueLiteral",
                    	        		lv_defaultValueLiteral_18_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleEAttributeDecl2363); 

                    createLeafNode(grammarAccess.getEAttributeDeclAccess().getSemicolonKeyword_7(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1554:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1554:56: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1555:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEReferenceDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2396);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();
            _fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEReferenceDecl2406); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1562:1: ruleEReferenceDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']' )? ( '#' ( ( RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        Token lv_resolveProxies_1_0=null;
        Token lv_unique_2_0=null;
        Token lv_ordered_3_0=null;
        Token lv_changeable_4_0=null;
        Token lv_volatile_5_0=null;
        Token lv_transient_6_0=null;
        Token lv_unsettable_7_0=null;
        Token lv_derived_8_0=null;
        Token lv_containment_9_0=null;
        Token lv_lowerBound_13_0=null;
        Token lv_name_19_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_11_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_15_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1567:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']' )? ( '#' ( ( RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1568:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']' )? ( '#' ( ( RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1568:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']' )? ( '#' ( ( RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1568:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) ( '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']' )? ( '#' ( ( RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1568:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==26) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1569:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1569:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1570:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEReferenceDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl2452);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1592:3: ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1592:4: ( (lv_resolveProxies_1_0= RULE_LOCAL ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1592:4: ( (lv_resolveProxies_1_0= RULE_LOCAL ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1593:1: (lv_resolveProxies_1_0= RULE_LOCAL )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1593:1: (lv_resolveProxies_1_0= RULE_LOCAL )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1594:3: lv_resolveProxies_1_0= RULE_LOCAL
            	    {
            	    lv_resolveProxies_1_0=(Token)input.LT(1);
            	    match(input,RULE_LOCAL,FollowSets000.FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl2471); 

            	    			createLeafNode(grammarAccess.getEReferenceDeclAccess().getResolveProxiesLocalTerminalRuleCall_1_0_0(), "resolveProxies"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"resolveProxies",
            	    	        		lv_resolveProxies_1_0, 
            	    	        		"Local", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1617:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1617:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1618:1: (lv_unique_2_0= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1618:1: (lv_unique_2_0= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1619:3: lv_unique_2_0= RULE_BAG
            	    {
            	    lv_unique_2_0=(Token)input.LT(1);
            	    match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_ruleEReferenceDecl2499); 

            	    			createLeafNode(grammarAccess.getEReferenceDeclAccess().getUniqueBagTerminalRuleCall_1_1_0(), "unique"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"unique",
            	    	        		lv_unique_2_0, 
            	    	        		"Bag", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1642:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1642:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1643:1: (lv_ordered_3_0= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1643:1: (lv_ordered_3_0= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1644:3: lv_ordered_3_0= RULE_RANDOM
            	    {
            	    lv_ordered_3_0=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl2527); 

            	    			createLeafNode(grammarAccess.getEReferenceDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0(), "ordered"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"ordered",
            	    	        		lv_ordered_3_0, 
            	    	        		"Random", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1667:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1667:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1668:1: (lv_changeable_4_0= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1668:1: (lv_changeable_4_0= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1669:3: lv_changeable_4_0= RULE_READONLY
            	    {
            	    lv_changeable_4_0=(Token)input.LT(1);
            	    match(input,RULE_READONLY,FollowSets000.FOLLOW_RULE_READONLY_in_ruleEReferenceDecl2555); 

            	    			createLeafNode(grammarAccess.getEReferenceDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0(), "changeable"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"changeable",
            	    	        		lv_changeable_4_0, 
            	    	        		"Readonly", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1692:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1692:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1693:1: (lv_volatile_5_0= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1693:1: (lv_volatile_5_0= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1694:3: lv_volatile_5_0= 'volatile'
            	    {
            	    lv_volatile_5_0=(Token)input.LT(1);
            	    match(input,37,FollowSets000.FOLLOW_37_in_ruleEReferenceDecl2584); 

            	            createLeafNode(grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0(), "volatile"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "volatile", true, "volatile", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1714:6: ( (lv_transient_6_0= 'transient' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1714:6: ( (lv_transient_6_0= 'transient' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1715:1: (lv_transient_6_0= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1715:1: (lv_transient_6_0= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1716:3: lv_transient_6_0= 'transient'
            	    {
            	    lv_transient_6_0=(Token)input.LT(1);
            	    match(input,38,FollowSets000.FOLLOW_38_in_ruleEReferenceDecl2621); 

            	            createLeafNode(grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0(), "transient"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "transient", true, "transient", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1736:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1736:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1737:1: (lv_unsettable_7_0= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1737:1: (lv_unsettable_7_0= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1738:3: lv_unsettable_7_0= 'unsettable'
            	    {
            	    lv_unsettable_7_0=(Token)input.LT(1);
            	    match(input,39,FollowSets000.FOLLOW_39_in_ruleEReferenceDecl2658); 

            	            createLeafNode(grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0(), "unsettable"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "unsettable", true, "unsettable", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1758:6: ( (lv_derived_8_0= 'derived' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1758:6: ( (lv_derived_8_0= 'derived' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1759:1: (lv_derived_8_0= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1759:1: (lv_derived_8_0= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1760:3: lv_derived_8_0= 'derived'
            	    {
            	    lv_derived_8_0=(Token)input.LT(1);
            	    match(input,40,FollowSets000.FOLLOW_40_in_ruleEReferenceDecl2695); 

            	            createLeafNode(grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0(), "derived"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "derived", true, "derived", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1779:4: ( ( (lv_containment_9_0= 'val' ) ) | 'ref' )
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
                    new NoViableAltException("1779:4: ( ( (lv_containment_9_0= 'val' ) ) | 'ref' )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1779:5: ( (lv_containment_9_0= 'val' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1779:5: ( (lv_containment_9_0= 'val' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1780:1: (lv_containment_9_0= 'val' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1780:1: (lv_containment_9_0= 'val' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1781:3: lv_containment_9_0= 'val'
                    {
                    lv_containment_9_0=(Token)input.LT(1);
                    match(input,45,FollowSets000.FOLLOW_45_in_ruleEReferenceDecl2729); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0(), "containment"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "containment", true, "val", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:7: 'ref'
                    {
                    match(input,46,FollowSets000.FOLLOW_46_in_ruleEReferenceDecl2758); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getRefKeyword_2_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1805:2: ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1806:1: (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1806:1: (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1807:3: lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEReferenceDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl2780);
            lv_eGenericType_11_0=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"eGenericType",
            	        		lv_eGenericType_11_0, 
            	        		"EGenericTypeReferenceDecl", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1829:2: ( '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1829:4: '[' ( (lv_lowerBound_13_0= RULE_INT ) ) ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? ']'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_ruleEReferenceDecl2791); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getLeftSquareBracketKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1833:1: ( (lv_lowerBound_13_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1834:1: (lv_lowerBound_13_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1834:1: (lv_lowerBound_13_0= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1835:3: lv_lowerBound_13_0= RULE_INT
                    {
                    lv_lowerBound_13_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEReferenceDecl2808); 

                    			createLeafNode(grammarAccess.getEReferenceDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0(), "lowerBound"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"lowerBound",
                    	        		lv_lowerBound_13_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1857:2: ( '..' ( (lv_upperBound_15_0= ruleSINT ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==43) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1857:4: '..' ( (lv_upperBound_15_0= ruleSINT ) )
                            {
                            match(input,43,FollowSets000.FOLLOW_43_in_ruleEReferenceDecl2824); 

                                    createLeafNode(grammarAccess.getEReferenceDeclAccess().getFullStopFullStopKeyword_4_2_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1861:1: ( (lv_upperBound_15_0= ruleSINT ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1862:1: (lv_upperBound_15_0= ruleSINT )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1862:1: (lv_upperBound_15_0= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1863:3: lv_upperBound_15_0= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEReferenceDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_ruleEReferenceDecl2845);
                            lv_upperBound_15_0=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"upperBound",
                            	        		lv_upperBound_15_0, 
                            	        		"SINT", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    match(input,44,FollowSets000.FOLLOW_44_in_ruleEReferenceDecl2857); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getRightSquareBracketKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1889:3: ( '#' ( ( RULE_ID ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1889:5: '#' ( ( RULE_ID ) )
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_ruleEReferenceDecl2870); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getNumberSignKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1893:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1894:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1894:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1895:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEReferenceDecl2888); 

                    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceCrossReference_5_1_0(), "eOpposite"); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1907:4: ( (lv_name_19_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1908:1: (lv_name_19_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1908:1: (lv_name_19_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1909:3: lv_name_19_0= RULE_ID
            {
            lv_name_19_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEReferenceDecl2907); 

            			createLeafNode(grammarAccess.getEReferenceDeclAccess().getNameIDTerminalRuleCall_6_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_19_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleEReferenceDecl2922); 

                    createLeafNode(grammarAccess.getEReferenceDeclAccess().getSemicolonKeyword_7(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1942:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1942:51: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1943:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEEnumDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl2955);
            iv_ruleEEnumDecl=ruleEEnumDecl();
            _fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumDecl2965); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1950:1: ruleEEnumDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'enum' ( (lv_name_2_0= RULE_ID ) ) '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eLiterals_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1955:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'enum' ( (lv_name_2_0= RULE_ID ) ) '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1956:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'enum' ( (lv_name_2_0= RULE_ID ) ) '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1956:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'enum' ( (lv_name_2_0= RULE_ID ) ) '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1956:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* 'enum' ( (lv_name_2_0= RULE_ID ) ) '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1956:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==26) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1957:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1957:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1958:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEEnumDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3011);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEEnumDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            match(input,48,FollowSets000.FOLLOW_48_in_ruleEEnumDecl3022); 

                    createLeafNode(grammarAccess.getEEnumDeclAccess().getEnumKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1984:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1985:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1985:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1986:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEEnumDecl3039); 

            			createLeafNode(grammarAccess.getEEnumDeclAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEEnumDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleEEnumDecl3054); 

                    createLeafNode(grammarAccess.getEEnumDeclAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2012:1: ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2013:1: (lv_eLiterals_4_0= ruleEEnumLiteralDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2013:1: (lv_eLiterals_4_0= ruleEEnumLiteralDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2014:3: lv_eLiterals_4_0= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEEnumDeclAccess().getELiteralsEEnumLiteralDeclParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3075);
            	    lv_eLiterals_4_0=ruleEEnumLiteralDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEEnumDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eLiterals",
            	    	        		lv_eLiterals_4_0, 
            	    	        		"EEnumLiteralDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleEEnumDecl3086); 

                    createLeafNode(grammarAccess.getEEnumDeclAccess().getRightCurlyBracketKeyword_5(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2047:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2047:58: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2048:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEEnumLiteralDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3119);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();
            _fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3129); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2055:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) ( '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_value_3_0=null;
        Token lv_literal_4_0=null;
        EObject lv_eAnnotations_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2060:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) ( '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2061:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) ( '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2061:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) ( '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2061:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) ( '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2061:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==26) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2062:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2062:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2063:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3175);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2085:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2086:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2086:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2087:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3193); 

            			createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2109:2: ( '=' ( (lv_value_3_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2109:4: '=' ( (lv_value_3_0= RULE_INT ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleEEnumLiteralDecl3209); 

                            createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getEqualsSignKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2113:1: ( (lv_value_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2114:1: (lv_value_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2114:1: (lv_value_3_0= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2115:3: lv_value_3_0= RULE_INT
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3226); 

                    			createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getValueINTTerminalRuleCall_2_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_3_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2137:4: ( (lv_literal_4_0= RULE_STRING ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2138:1: (lv_literal_4_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2138:1: (lv_literal_4_0= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2139:3: lv_literal_4_0= RULE_STRING
                    {
                    lv_literal_4_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl3250); 

                    			createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getLiteralSTRINGTerminalRuleCall_3_0(), "literal"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"literal",
                    	        		lv_literal_4_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleEEnumLiteralDecl3266); 

                    createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getSemicolonKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2172:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2172:60: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2173:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getETypeParameterDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl3299);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();
            _fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleETypeParameterDecl3309); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2180:1: ruleETypeParameterDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_eBounds_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2185:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:1: ( ( (lv_name_0_0= RULE_ID ) ) ( 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:1: ( ( (lv_name_0_0= RULE_ID ) ) ( 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:2: ( (lv_name_0_0= RULE_ID ) ) ( 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2186:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2187:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2187:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2188:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleETypeParameterDecl3351); 

            			createLeafNode(grammarAccess.getETypeParameterDeclAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getETypeParameterDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2210:2: ( 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2210:4: 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) )
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_ruleETypeParameterDecl3367); 

                            createLeafNode(grammarAccess.getETypeParameterDeclAccess().getExtendsKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2214:1: ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2215:1: (lv_eBounds_2_0= ruleEGenericTypeDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2215:1: (lv_eBounds_2_0= ruleEGenericTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2216:3: lv_eBounds_2_0= ruleEGenericTypeDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getETypeParameterDeclAccess().getEBoundsEGenericTypeDeclParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl3388);
                    lv_eBounds_2_0=ruleEGenericTypeDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getETypeParameterDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"eBounds",
                    	        		lv_eBounds_2_0, 
                    	        		"EGenericTypeDecl", 
                    	        		currentNode);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2245:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2245:67: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2246:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEGenericTypeReferenceDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl3423);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();
            _fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl3433); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2253:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2_0 = null;

        EObject lv_eTypeArguments_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2258:6: ( ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:1: ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:1: ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )
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
                    new NoViableAltException("2259:1: ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:2: ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:2: ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:3: ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2260:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2260:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2261:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3477); 

                    		createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierCrossReference_0_0_0(), "eClassifier"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2273:2: ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==33) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2273:4: '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>'
                            {
                            match(input,33,FollowSets000.FOLLOW_33_in_ruleEGenericTypeReferenceDecl3488); 

                                    createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getLessThanSignKeyword_0_1_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2277:1: ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2278:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2278:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2279:3: lv_eTypeArguments_2_0= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3509);
                            lv_eTypeArguments_2_0=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"eTypeArguments",
                            	        		lv_eTypeArguments_2_0, 
                            	        		"EGenericTypeDecl", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2301:2: ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==28) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2301:4: ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    {
                            	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEGenericTypeReferenceDecl3520); 

                            	            createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getCommaKeyword_0_1_2_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2305:1: ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2306:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    {
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2306:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2307:3: lv_eTypeArguments_4_0= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3541);
                            	    lv_eTypeArguments_4_0=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"eTypeArguments",
                            	    	        		lv_eTypeArguments_4_0, 
                            	    	        		"EGenericTypeDecl", 
                            	    	        		currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop40;
                                }
                            } while (true);

                            match(input,34,FollowSets000.FOLLOW_34_in_ruleEGenericTypeReferenceDecl3553); 

                                    createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getGreaterThanSignKeyword_0_1_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2334:6: ( '#' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2334:6: ( '#' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2334:8: '#' ( ( RULE_ID ) )
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_ruleEGenericTypeReferenceDecl3573); 

                            createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getNumberSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2338:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2339:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2339:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2340:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3591); 

                    		createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0(), "eTypeParameter"); 
                    	

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
    // $ANTLR end ruleEGenericTypeReferenceDecl


    // $ANTLR start entryRuleEGenericTypeDecl
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2359:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2359:58: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2360:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEGenericTypeDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl3625);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();
            _fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericTypeDecl3635); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2367:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) | ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2_0 = null;

        EObject lv_eTypeArguments_4_0 = null;

        EObject lv_eUpperBound_10_0 = null;

        EObject lv_eLowerBound_12_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2372:6: ( ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) | ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:1: ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) | ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:1: ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) | ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) )
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
                    new NoViableAltException("2373:1: ( ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? ) | ( '#' ( ( RULE_ID ) ) ) | ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) )", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:2: ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:2: ( ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:3: ( ( RULE_ID ) ) ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2374:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2374:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2375:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3679); 

                    		createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierCrossReference_0_0_0(), "eClassifier"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2387:2: ( '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==33) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2387:4: '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* '>'
                            {
                            match(input,33,FollowSets000.FOLLOW_33_in_ruleEGenericTypeDecl3690); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getLessThanSignKeyword_0_1_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2391:1: ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2392:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2393:3: lv_eTypeArguments_2_0= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3711);
                            lv_eTypeArguments_2_0=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"eTypeArguments",
                            	        		lv_eTypeArguments_2_0, 
                            	        		"EGenericTypeDecl", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2415:2: ( ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==28) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2415:4: ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    {
                            	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEGenericTypeDecl3722); 

                            	            createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getCommaKeyword_0_1_2_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2419:1: ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2420:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    {
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2420:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2421:3: lv_eTypeArguments_4_0= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3743);
                            	    lv_eTypeArguments_4_0=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"eTypeArguments",
                            	    	        		lv_eTypeArguments_4_0, 
                            	    	        		"EGenericTypeDecl", 
                            	    	        		currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop43;
                                }
                            } while (true);

                            match(input,34,FollowSets000.FOLLOW_34_in_ruleEGenericTypeDecl3755); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getGreaterThanSignKeyword_0_1_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2448:6: ( '#' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2448:6: ( '#' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2448:8: '#' ( ( RULE_ID ) )
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_ruleEGenericTypeDecl3775); 

                            createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getNumberSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2452:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2453:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2453:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2454:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3793); 

                    		createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0(), "eTypeParameter"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2467:6: ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2467:6: ( '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2467:8: '?' ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) )
                    {
                    match(input,49,FollowSets000.FOLLOW_49_in_ruleEGenericTypeDecl3811); 

                            createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getQuestionMarkKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2471:1: ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) )
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
                            new NoViableAltException("2471:1: ( ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) )", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2471:2: ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2471:2: ( 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2471:4: 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) )
                            {
                            match(input,35,FollowSets000.FOLLOW_35_in_ruleEGenericTypeDecl3823); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getExtendsKeyword_2_1_0_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2475:1: ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2476:1: (lv_eUpperBound_10_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2476:1: (lv_eUpperBound_10_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2477:3: lv_eUpperBound_10_0= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundEGenericTypeDeclParserRuleCall_2_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3844);
                            lv_eUpperBound_10_0=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"eUpperBound",
                            	        		lv_eUpperBound_10_0, 
                            	        		"EGenericTypeDecl", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2500:6: ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2500:6: ( 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2500:8: 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) )
                            {
                            match(input,50,FollowSets000.FOLLOW_50_in_ruleEGenericTypeDecl3862); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getSuperKeyword_2_1_1_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2504:1: ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:1: (lv_eLowerBound_12_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:1: (lv_eLowerBound_12_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2506:3: lv_eLowerBound_12_0= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundEGenericTypeDeclParserRuleCall_2_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3883);
                            lv_eLowerBound_12_0=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"eLowerBound",
                            	        		lv_eLowerBound_12_0, 
                            	        		"EGenericTypeDecl", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2535:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2535:56: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2536:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEOperationDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl3919);
            iv_ruleEOperationDecl=ruleEOperationDecl();
            _fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOperationDecl3929); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2543:1: ruleEOperationDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' ) ( (lv_name_6_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>' )? '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? ')' ( 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? ';' ) ;
    public final EObject ruleEOperationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_unique_1_0=null;
        Token lv_ordered_2_0=null;
        Token lv_name_6_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_4_0 = null;

        EObject lv_eTypeParameters_8_0 = null;

        EObject lv_eTypeParameters_10_0 = null;

        EObject lv_eParameters_13_0 = null;

        EObject lv_eParameters_15_0 = null;

        EObject lv_eGenericExceptions_18_0 = null;

        EObject lv_eGenericExceptions_20_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2548:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' ) ( (lv_name_6_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>' )? '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? ')' ( 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2549:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' ) ( (lv_name_6_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>' )? '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? ')' ( 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2549:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' ) ( (lv_name_6_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>' )? '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? ')' ( 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2549:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' ) ( (lv_name_6_0= RULE_ID ) ) ( '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>' )? '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? ')' ( 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2549:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==26) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2550:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2550:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2551:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl3975);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2573:3: ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2573:4: ( (lv_unique_1_0= RULE_BAG ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2573:4: ( (lv_unique_1_0= RULE_BAG ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2574:1: (lv_unique_1_0= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2574:1: (lv_unique_1_0= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2575:3: lv_unique_1_0= RULE_BAG
            	    {
            	    lv_unique_1_0=(Token)input.LT(1);
            	    match(input,RULE_BAG,FollowSets000.FOLLOW_RULE_BAG_in_ruleEOperationDecl3994); 

            	    			createLeafNode(grammarAccess.getEOperationDeclAccess().getUniqueBagTerminalRuleCall_1_0_0(), "unique"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"unique",
            	    	        		true, 
            	    	        		"Bag", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2598:6: ( (lv_ordered_2_0= RULE_RANDOM ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2598:6: ( (lv_ordered_2_0= RULE_RANDOM ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2599:1: (lv_ordered_2_0= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2599:1: (lv_ordered_2_0= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2600:3: lv_ordered_2_0= RULE_RANDOM
            	    {
            	    lv_ordered_2_0=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FollowSets000.FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4022); 

            	    			createLeafNode(grammarAccess.getEOperationDeclAccess().getOrderedRandomTerminalRuleCall_1_1_0(), "ordered"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"ordered",
            	    	        		true, 
            	    	        		"Random", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            match(input,51,FollowSets000.FOLLOW_51_in_ruleEOperationDecl4039); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getOpKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2626:1: ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' )
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
                    new NoViableAltException("2626:1: ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | 'void' )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2626:2: ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2626:2: ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2627:1: (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2627:1: (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2628:3: lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4061);
                    lv_eGenericType_4_0=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"eGenericType",
                    	        		lv_eGenericType_4_0, 
                    	        		"EGenericTypeReferenceDecl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2651:7: 'void'
                    {
                    match(input,52,FollowSets000.FOLLOW_52_in_ruleEOperationDecl4077); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getVoidKeyword_3_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2655:2: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2656:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2656:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2657:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEOperationDecl4095); 

            			createLeafNode(grammarAccess.getEOperationDeclAccess().getNameIDTerminalRuleCall_4_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_6_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2679:2: ( '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==33) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2679:4: '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* '>'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_ruleEOperationDecl4111); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getLessThanSignKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2683:1: ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2684:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2684:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2685:3: lv_eTypeParameters_8_0= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4132);
                    lv_eTypeParameters_8_0=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"eTypeParameters",
                    	        		lv_eTypeParameters_8_0, 
                    	        		"ETypeParameterDecl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2707:2: ( ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==28) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2707:4: ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) )
                    	    {
                    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEOperationDecl4143); 

                    	            createLeafNode(grammarAccess.getEOperationDeclAccess().getCommaKeyword_5_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2711:1: ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2712:1: (lv_eTypeParameters_10_0= ruleETypeParameterDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2712:1: (lv_eTypeParameters_10_0= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2713:3: lv_eTypeParameters_10_0= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4164);
                    	    lv_eTypeParameters_10_0=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"eTypeParameters",
                    	    	        		lv_eTypeParameters_10_0, 
                    	    	        		"ETypeParameterDecl", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    match(input,34,FollowSets000.FOLLOW_34_in_ruleEOperationDecl4176); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getGreaterThanSignKeyword_5_3(), null); 
                        

                    }
                    break;

            }

            match(input,27,FollowSets000.FOLLOW_27_in_ruleEOperationDecl4188); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getLeftParenthesisKeyword_6(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2743:1: ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID||LA53_0==26||LA53_0==47) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2743:2: ( (lv_eParameters_13_0= ruleEParameterDecl ) ) ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2743:2: ( (lv_eParameters_13_0= ruleEParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2744:1: (lv_eParameters_13_0= ruleEParameterDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2744:1: (lv_eParameters_13_0= ruleEParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2745:3: lv_eParameters_13_0= ruleEParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4210);
                    lv_eParameters_13_0=ruleEParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"eParameters",
                    	        		lv_eParameters_13_0, 
                    	        		"EParameterDecl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2767:2: ( ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==28) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2767:4: ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) )
                    	    {
                    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEOperationDecl4221); 

                    	            createLeafNode(grammarAccess.getEOperationDeclAccess().getCommaKeyword_7_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2771:1: ( (lv_eParameters_15_0= ruleEParameterDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2772:1: (lv_eParameters_15_0= ruleEParameterDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2772:1: (lv_eParameters_15_0= ruleEParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2773:3: lv_eParameters_15_0= ruleEParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4242);
                    	    lv_eParameters_15_0=ruleEParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"eParameters",
                    	    	        		lv_eParameters_15_0, 
                    	    	        		"EParameterDecl", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


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

            match(input,29,FollowSets000.FOLLOW_29_in_ruleEOperationDecl4256); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getRightParenthesisKeyword_8(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2799:1: ( 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==53) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2799:3: 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )*
                    {
                    match(input,53,FollowSets000.FOLLOW_53_in_ruleEOperationDecl4267); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getThrowsKeyword_9_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2803:1: ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2804:1: (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2804:1: (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2805:3: lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4288);
                    lv_eGenericExceptions_18_0=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"eGenericExceptions",
                    	        		lv_eGenericExceptions_18_0, 
                    	        		"EGenericTypeReferenceDecl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2827:2: ( ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==28) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2827:4: ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) )
                    	    {
                    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleEOperationDecl4299); 

                    	            createLeafNode(grammarAccess.getEOperationDeclAccess().getCommaKeyword_9_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2831:1: ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2832:1: (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2832:1: (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2833:3: lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4320);
                    	    lv_eGenericExceptions_20_0=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"eGenericExceptions",
                    	    	        		lv_eGenericExceptions_20_0, 
                    	    	        		"EGenericTypeReferenceDecl", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleEOperationDecl4334); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getSemicolonKeyword_10(), null); 
                

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2866:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2866:56: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2867:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEParameterDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl4367);
            iv_ruleEParameterDecl=ruleEParameterDecl();
            _fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEParameterDecl4377); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2874:1: ruleEParameterDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2879:6: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2880:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2880:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2880:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2880:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==26) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2881:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2881:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2882:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEParameterDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl4423);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEParameterDeclRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"eAnnotations",
            	    	        		lv_eAnnotations_0_0, 
            	    	        		"EAnnotationDecl", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2904:3: ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2905:1: (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2905:1: (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2906:3: lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEParameterDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl4445);
            lv_eGenericType_1_0=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEParameterDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"eGenericType",
            	        		lv_eGenericType_1_0, 
            	        		"EGenericTypeReferenceDecl", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2928:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2929:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2929:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2930:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEParameterDecl4462); 

            			createLeafNode(grammarAccess.getEParameterDeclAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEParameterDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2959:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2959:50: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2960:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMapEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMapEntry_in_entryRuleMapEntry4500);
            iv_ruleMapEntry=ruleMapEntry();
            _fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapEntry4510); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2967:1: ruleMapEntry returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token lv_value_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2972:6: ( ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2973:1: ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2973:1: ( ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2973:2: ( (lv_key_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2973:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2974:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2974:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2975:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMapEntry4552); 

            			createLeafNode(grammarAccess.getMapEntryAccess().getKeyIDTerminalRuleCall_0_0(), "key"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMapEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"key",
            	        		lv_key_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleMapEntry4567); 

                    createLeafNode(grammarAccess.getMapEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3001:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3002:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3002:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3003:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMapEntry4584); 

            			createLeafNode(grammarAccess.getMapEntryAccess().getValueSTRINGTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMapEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3032:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3032:44: (iv_ruleQID= ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3033:2: iv_ruleQID= ruleQID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQIDRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleQID_in_entryRuleQID4623);
            iv_ruleQID=ruleQID();
            _fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQID4634); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3040:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3045:6: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3046:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3046:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3046:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQID4674); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3053:1: ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=54 && LA58_0<=55)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3053:2: (kw= '.' | kw= '$' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3053:2: (kw= '.' | kw= '$' )
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
            	            new NoViableAltException("3053:2: (kw= '.' | kw= '$' )", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3054:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,54,FollowSets000.FOLLOW_54_in_ruleQID4694); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3061:2: kw= '$'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,55,FollowSets000.FOLLOW_55_in_ruleQID4713); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.getQIDAccess().getDollarSignKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQID4729); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        createLeafNode(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3081:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3081:54: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3082:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSTRING_OR_QIDRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID4775);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();
            _fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSTRING_OR_QID4786); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3089:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_QID_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3094:6: ( (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3095:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3095:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
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
                    new NoViableAltException("3095:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3095:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID4826); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3104:5: this_QID_1= ruleQID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSTRING_OR_QIDAccess().getQIDParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleQID_in_ruleSTRING_OR_QID4859);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3122:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3122:45: (iv_ruleSINT= ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3123:2: iv_ruleSINT= ruleSINT EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSINTRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSINT_in_entryRuleSINT4903);
            iv_ruleSINT=ruleSINT();
            _fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSINT4914); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3130:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3135:6: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3136:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3136:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3136:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3136:2: (kw= '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3137:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FollowSets000.FOLLOW_56_in_ruleSINT4953); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getSINTAccess().getHyphenMinusKeyword_0(), null); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSINT4970); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.getSINTAccess().getINTTerminalRuleCall_1(), null); 
                

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
            return "()* loopback of 346:1: ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )*";
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
            return "()* loopback of 476:1: ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )*";
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
            return "550:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )";
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
            return "590:1: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? ( 'datatype' ( (lv_name_3_0= RULE_ID ) ) ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )";
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
            return "()* loopback of 1081:1: ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )*";
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
            return "1155:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleEcoreDsl129 = new BitSet(new long[]{0x0000000004090000L});
        public static final BitSet FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel229 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel247 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleReferencedMetamodel262 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel282 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleReferencedMetamodel292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl381 = new BitSet(new long[]{0x0000000004080000L});
        public static final BitSet FOLLOW_19_in_ruleEPackageDecl392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl413 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleEPackageDecl423 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEPackageDecl433 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl450 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEPackageDecl465 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEPackageDecl475 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl496 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEPackageDecl506 = new BitSet(new long[]{0x00010001C5880040L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl528 = new BitSet(new long[]{0x00010001C5880040L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl555 = new BitSet(new long[]{0x00010001C5880040L});
        public static final BitSet FOLLOW_23_in_ruleEPackageDecl567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl656 = new BitSet(new long[]{0x0000000004080000L});
        public static final BitSet FOLLOW_19_in_ruleSubEPackageDecl667 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl684 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleSubEPackageDecl699 = new BitSet(new long[]{0x00010001C5880040L});
        public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl721 = new BitSet(new long[]{0x00010001C5880040L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl748 = new BitSet(new long[]{0x00010001C5880040L});
        public static final BitSet FOLLOW_23_in_ruleSubEPackageDecl760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl966 = new BitSet(new long[]{0x0000000005000040L});
        public static final BitSet FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl984 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleEDataTypeDecl1001 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1018 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleEDataTypeDecl1033 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1054 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEDataTypeDecl1064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleEAnnotationDecl1171 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1192 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleEAnnotationDecl1203 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1224 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_28_in_ruleEAnnotationDecl1235 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1256 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_29_in_ruleEAnnotationDecl1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1359 = new BitSet(new long[]{0x00000001C4000000L});
        public static final BitSet FOLLOW_30_in_ruleEClassDecl1378 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleEClassDecl1411 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_32_in_ruleEClassDecl1440 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1458 = new BitSet(new long[]{0x0000000A02400000L});
        public static final BitSet FOLLOW_33_in_ruleEClassDecl1474 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1495 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_28_in_ruleEClassDecl1506 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1527 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_34_in_ruleEClassDecl1539 = new BitSet(new long[]{0x0000000802400000L});
        public static final BitSet FOLLOW_35_in_ruleEClassDecl1552 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1573 = new BitSet(new long[]{0x0000000012400000L});
        public static final BitSet FOLLOW_28_in_ruleEClassDecl1584 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1605 = new BitSet(new long[]{0x0000000012400000L});
        public static final BitSet FOLLOW_25_in_ruleEClassDecl1620 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl1641 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEClassDecl1653 = new BitSet(new long[]{0x000863F004800B80L});
        public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl1675 = new BitSet(new long[]{0x000863F004800B80L});
        public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl1702 = new BitSet(new long[]{0x000863F004800B80L});
        public static final BitSet FOLLOW_23_in_ruleEClassDecl1714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl1747 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl1757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl1804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl1831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl1863 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl1873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl1919 = new BitSet(new long[]{0x000003F004000380L});
        public static final BitSet FOLLOW_36_in_ruleEAttributeDecl1939 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_RULE_BAG_in_ruleEAttributeDecl1975 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2003 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2031 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2060 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2097 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2134 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2171 = new BitSet(new long[]{0x000003F000000380L});
        public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2196 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2217 = new BitSet(new long[]{0x0000040000000010L});
        public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2228 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2245 = new BitSet(new long[]{0x0000180000000000L});
        public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2261 = new BitSet(new long[]{0x0100000000000400L});
        public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2282 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleEAttributeDecl2294 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2313 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleEAttributeDecl2329 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl2346 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEAttributeDecl2363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2396 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl2406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl2452 = new BitSet(new long[]{0x000061E004000B80L});
        public static final BitSet FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl2471 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_RULE_BAG_in_ruleEReferenceDecl2499 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl2527 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_RULE_READONLY_in_ruleEReferenceDecl2555 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_37_in_ruleEReferenceDecl2584 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_38_in_ruleEReferenceDecl2621 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_39_in_ruleEReferenceDecl2658 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_40_in_ruleEReferenceDecl2695 = new BitSet(new long[]{0x000061E000000B80L});
        public static final BitSet FOLLOW_45_in_ruleEReferenceDecl2729 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_46_in_ruleEReferenceDecl2758 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl2780 = new BitSet(new long[]{0x0000840000000010L});
        public static final BitSet FOLLOW_42_in_ruleEReferenceDecl2791 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl2808 = new BitSet(new long[]{0x0000180000000000L});
        public static final BitSet FOLLOW_43_in_ruleEReferenceDecl2824 = new BitSet(new long[]{0x0100000000000400L});
        public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl2845 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleEReferenceDecl2857 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_47_in_ruleEReferenceDecl2870 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl2888 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl2907 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEReferenceDecl2922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl2955 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl2965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3011 = new BitSet(new long[]{0x0001000004000000L});
        public static final BitSet FOLLOW_48_in_ruleEEnumDecl3022 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3039 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEEnumDecl3054 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3075 = new BitSet(new long[]{0x0000000004800010L});
        public static final BitSet FOLLOW_23_in_ruleEEnumDecl3086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3119 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3175 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3193 = new BitSet(new long[]{0x0000000000060020L});
        public static final BitSet FOLLOW_17_in_ruleEEnumLiteralDecl3209 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3226 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl3250 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEEnumLiteralDecl3266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl3299 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl3309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl3351 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_35_in_ruleETypeParameterDecl3367 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl3388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl3423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl3433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3477 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleEGenericTypeReferenceDecl3488 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3509 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_28_in_ruleEGenericTypeReferenceDecl3520 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3541 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_34_in_ruleEGenericTypeReferenceDecl3553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl3573 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl3625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl3635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3679 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleEGenericTypeDecl3690 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3711 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_28_in_ruleEGenericTypeDecl3722 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3743 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_34_in_ruleEGenericTypeDecl3755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl3775 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl3811 = new BitSet(new long[]{0x0004000800000000L});
        public static final BitSet FOLLOW_35_in_ruleEGenericTypeDecl3823 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl3862 = new BitSet(new long[]{0x0002800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl3919 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl3929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl3975 = new BitSet(new long[]{0x0008000004000180L});
        public static final BitSet FOLLOW_RULE_BAG_in_ruleEOperationDecl3994 = new BitSet(new long[]{0x0008000000000180L});
        public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4022 = new BitSet(new long[]{0x0008000000000180L});
        public static final BitSet FOLLOW_51_in_ruleEOperationDecl4039 = new BitSet(new long[]{0x0010800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4061 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_52_in_ruleEOperationDecl4077 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl4095 = new BitSet(new long[]{0x0000000208000000L});
        public static final BitSet FOLLOW_33_in_ruleEOperationDecl4111 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4132 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_28_in_ruleEOperationDecl4143 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4164 = new BitSet(new long[]{0x0000000410000000L});
        public static final BitSet FOLLOW_34_in_ruleEOperationDecl4176 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleEOperationDecl4188 = new BitSet(new long[]{0x0000800024000010L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4210 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_28_in_ruleEOperationDecl4221 = new BitSet(new long[]{0x0000800004000010L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4242 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_29_in_ruleEOperationDecl4256 = new BitSet(new long[]{0x0020000000040000L});
        public static final BitSet FOLLOW_53_in_ruleEOperationDecl4267 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4288 = new BitSet(new long[]{0x0000000010040000L});
        public static final BitSet FOLLOW_28_in_ruleEOperationDecl4299 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4320 = new BitSet(new long[]{0x0000000010040000L});
        public static final BitSet FOLLOW_18_in_ruleEOperationDecl4334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl4367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl4377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl4423 = new BitSet(new long[]{0x0000800004000010L});
        public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl4445 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl4462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry4500 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry4510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry4552 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMapEntry4567 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry4584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_entryRuleQID4623 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQID4634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQID4674 = new BitSet(new long[]{0x00C0000000000002L});
        public static final BitSet FOLLOW_54_in_ruleQID4694 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_55_in_ruleQID4713 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQID4729 = new BitSet(new long[]{0x00C0000000000002L});
        public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID4775 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID4786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID4826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID4859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT4903 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSINT4914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleSINT4953 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSINT4970 = new BitSet(new long[]{0x0000000000000002L});
    }


}
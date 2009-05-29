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
            pushFollow(FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl73);
            iv_ruleEcoreDsl=ruleEcoreDsl();
            _fsp--;

             current =iv_ruleEcoreDsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEcoreDsl83); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:80:1: ruleEcoreDsl returns [EObject current=null] : ( (lv_metamodelDeclarations_0= ruleReferencedMetamodel )* (lv_package_1= ruleEPackageDecl ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations_0 = null;

        EObject lv_package_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:85:6: ( ( (lv_metamodelDeclarations_0= ruleReferencedMetamodel )* (lv_package_1= ruleEPackageDecl ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:1: ( (lv_metamodelDeclarations_0= ruleReferencedMetamodel )* (lv_package_1= ruleEPackageDecl ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:1: ( (lv_metamodelDeclarations_0= ruleReferencedMetamodel )* (lv_package_1= ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:2: (lv_metamodelDeclarations_0= ruleReferencedMetamodel )* (lv_package_1= ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:86:2: (lv_metamodelDeclarations_0= ruleReferencedMetamodel )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:89:6: lv_metamodelDeclarations_0= ruleReferencedMetamodel
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsReferencedMetamodelParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleEcoreDsl142);
            	    lv_metamodelDeclarations_0=ruleReferencedMetamodel();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEcoreDslRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "metamodelDeclarations", lv_metamodelDeclarations_0, "ReferencedMetamodel", currentNode);
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:107:3: (lv_package_1= ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:110:6: lv_package_1= ruleEPackageDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEcoreDslAccess().getPackageEPackageDeclParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl181);
            lv_package_1=ruleEPackageDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEcoreDslRule().getType().getClassifier());
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


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:135:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:136:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel218);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel228); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:143:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ( RULE_STRING ) ';' ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:148:6: ( ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ( RULE_STRING ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ( RULE_STRING ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:1: ( 'import' ( (lv_alias_1= RULE_ID ) '=' )? ( RULE_STRING ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:149:2: 'import' ( (lv_alias_1= RULE_ID ) '=' )? ( RULE_STRING ) ';'
            {
            match(input,16,FOLLOW_16_in_ruleReferencedMetamodel262); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null); 
                
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
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel285); 

                    		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_1_0_0(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_1, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,17,FOLLOW_17_in_ruleReferencedMetamodel302); 

                            createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEqualsSignKeyword_1_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:177:3: ( RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:180:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel326); 

            		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	

            }

            match(input,18,FOLLOW_18_in_ruleReferencedMetamodel338); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:204:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:204:54: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:205:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEPackageDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl371);
            iv_ruleEPackageDecl=ruleEPackageDecl();
            _fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageDecl381); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:212:1: ruleEPackageDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:217:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:218:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:218:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:218:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= ruleQID ) 'nsURI' '=' (lv_nsURI_5= RULE_STRING ) 'nsPrefix' '=' (lv_nsPrefix_8= ruleQID ) '{' ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:218:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:221:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl440);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
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

            match(input,19,FOLLOW_19_in_ruleEPackageDecl454); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:243:1: (lv_name_2= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:246:6: lv_name_2= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getNameQIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl488);
            lv_name_2=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,20,FOLLOW_20_in_ruleEPackageDecl501); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getNsURIKeyword_3(), null); 
                
            match(input,17,FOLLOW_17_in_ruleEPackageDecl510); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_4(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:272:1: (lv_nsURI_5= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:274:6: lv_nsURI_5= RULE_STRING
            {
            lv_nsURI_5=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageDecl532); 

            		createLeafNode(grammarAccess.getEPackageDeclAccess().getNsURISTRINGTerminalRuleCall_5_0(), "nsURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "nsURI", lv_nsURI_5, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,21,FOLLOW_21_in_ruleEPackageDecl549); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getNsPrefixKeyword_6(), null); 
                
            match(input,17,FOLLOW_17_in_ruleEPackageDecl558); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_7(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:300:1: (lv_nsPrefix_8= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:303:6: lv_nsPrefix_8= ruleQID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getNsPrefixQIDParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl592);
            lv_nsPrefix_8=ruleQID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "nsPrefix", lv_nsPrefix_8, "QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,22,FOLLOW_22_in_ruleEPackageDecl605); 

                    createLeafNode(grammarAccess.getEPackageDeclAccess().getLeftCurlyBracketKeyword_9(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:325:1: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:325:2: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:325:2: (lv_eSubpackages_10= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:328:6: lv_eSubpackages_10= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_10_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl640);
            	    lv_eSubpackages_10=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:347:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:347:6: (lv_eClassifiers_11= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:350:6: lv_eClassifiers_11= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_10_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl684);
            	    lv_eClassifiers_11=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEPackageDeclRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleEPackageDecl699); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:379:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:379:57: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:380:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubEPackageDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl732);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();
            _fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubEPackageDecl742); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:387:1: ruleSubEPackageDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eSubpackages_4 = null;

        EObject lv_eClassifiers_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:392:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:393:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:393:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:393:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'package' (lv_name_2= RULE_ID ) '{' ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:393:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:396:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl801);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
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

            match(input,19,FOLLOW_19_in_ruleSubEPackageDecl815); 

                    createLeafNode(grammarAccess.getSubEPackageDeclAccess().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:418:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:420:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubEPackageDecl837); 

            		createLeafNode(grammarAccess.getSubEPackageDeclAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,22,FOLLOW_22_in_ruleSubEPackageDecl854); 

                    createLeafNode(grammarAccess.getSubEPackageDeclAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:442:1: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:442:2: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:442:2: (lv_eSubpackages_4= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:445:6: lv_eSubpackages_4= ruleSubEPackageDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_4_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl889);
            	    lv_eSubpackages_4=ruleSubEPackageDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:464:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:464:6: (lv_eClassifiers_5= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:467:6: lv_eClassifiers_5= ruleEClassifierDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_4_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl933);
            	    lv_eClassifiers_5=ruleEClassifierDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubEPackageDeclRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleSubEPackageDecl948); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:496:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:496:57: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:497:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEClassifierDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl981);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();
            _fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassifierDecl991); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:504:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl_0 = null;

        EObject this_EDataTypeDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:509:6: ( (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:510:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:510:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:511:5: this_EClassDecl_0= ruleEClassDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEClassifierDeclAccess().getEClassDeclParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1038);
                    this_EClassDecl_0=ruleEClassDecl();
                    _fsp--;

                     
                            current = this_EClassDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:521:5: this_EDataTypeDecl_1= ruleEDataTypeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEClassifierDeclAccess().getEDataTypeDeclParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1065);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:536:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:536:55: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:537:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEDataTypeDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1097);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();
            _fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEDataTypeDecl1107); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable_1=null;
        Token lv_name_3=null;
        EObject lv_eAnnotations_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5 = null;

        EObject this_EEnumDecl_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:549:6: ( ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:2: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:3: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:3: (lv_eAnnotations_0= ruleEAnnotationDecl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:553:6: lv_eAnnotations_0= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1167);
                    	    lv_eAnnotations_0=ruleEAnnotationDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:571:3: (lv_serializable_1= RULE_SERIALIZABLE )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_SERIALIZABLE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:573:6: lv_serializable_1= RULE_SERIALIZABLE
                            {
                            lv_serializable_1=(Token)input.LT(1);
                            match(input,RULE_SERIALIZABLE,FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl1194); 

                            		createLeafNode(grammarAccess.getEDataTypeDeclAccess().getSerializableSerializableTerminalRuleCall_0_1_0(), "serializable"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
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

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:591:3: ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:591:4: 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';'
                    {
                    match(input,24,FOLLOW_24_in_ruleEDataTypeDecl1213); 

                            createLeafNode(grammarAccess.getEDataTypeDeclAccess().getDatatypeKeyword_0_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:595:1: (lv_name_3= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:597:6: lv_name_3= RULE_ID
                    {
                    lv_name_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEDataTypeDecl1235); 

                    		createLeafNode(grammarAccess.getEDataTypeDeclAccess().getNameIDTerminalRuleCall_0_2_1_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,25,FOLLOW_25_in_ruleEDataTypeDecl1252); 

                            createLeafNode(grammarAccess.getEDataTypeDeclAccess().getColonKeyword_0_2_2(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:619:1: (lv_instanceClassName_5= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:622:6: lv_instanceClassName_5= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_0_2_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1286);
                    lv_instanceClassName_5=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEDataTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "instanceClassName", lv_instanceClassName_5, "STRING_OR_QID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    match(input,18,FOLLOW_18_in_ruleEDataTypeDecl1299); 

                            createLeafNode(grammarAccess.getEDataTypeDeclAccess().getSemicolonKeyword_0_2_4(), null); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:646:5: this_EEnumDecl_7= ruleEEnumDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEDataTypeDeclAccess().getEEnumDeclParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1329);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:661:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:661:57: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:662:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEAnnotationDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1361);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();
            _fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAnnotationDecl1371); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:669:1: ruleEAnnotationDecl returns [EObject current=null] : ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_source_1 = null;

        EObject lv_details_3 = null;

        EObject lv_details_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:674:6: ( ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:675:1: ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:675:1: ( '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:675:2: '@' (lv_source_1= ruleSTRING_OR_QID ) ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )?
            {
            match(input,26,FOLLOW_26_in_ruleEAnnotationDecl1405); 

                    createLeafNode(grammarAccess.getEAnnotationDeclAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:679:1: (lv_source_1= ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:682:6: lv_source_1= ruleSTRING_OR_QID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEAnnotationDeclAccess().getSourceSTRING_OR_QIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1439);
            lv_source_1=ruleSTRING_OR_QID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEAnnotationDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "source", lv_source_1, "STRING_OR_QID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:700:2: ( '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:700:3: '(' (lv_details_3= ruleMapEntry ) ( ',' (lv_details_5= ruleMapEntry ) )* ')'
                    {
                    match(input,27,FOLLOW_27_in_ruleEAnnotationDecl1453); 

                            createLeafNode(grammarAccess.getEAnnotationDeclAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:704:1: (lv_details_3= ruleMapEntry )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:707:6: lv_details_3= ruleMapEntry
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1487);
                    lv_details_3=ruleMapEntry();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEAnnotationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "details", lv_details_3, "MapEntry", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:725:2: ( ',' (lv_details_5= ruleMapEntry ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:725:3: ',' (lv_details_5= ruleMapEntry )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEAnnotationDecl1501); 

                    	            createLeafNode(grammarAccess.getEAnnotationDeclAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:729:1: (lv_details_5= ruleMapEntry )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:732:6: lv_details_5= ruleMapEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1535);
                    	    lv_details_5=ruleMapEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEAnnotationDeclRule().getType().getClassifier());
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

                    match(input,29,FOLLOW_29_in_ruleEAnnotationDecl1550); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:761:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:761:52: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:762:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEClassDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1585);
            iv_ruleEClassDecl=ruleEClassDecl();
            _fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassDecl1595); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:769:1: ruleEClassDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:774:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:775:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:775:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:775:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_abstract_1= 'abstract' )? ( (lv_interface_2= 'interface' ) | 'class' ) (lv_name_4= RULE_ID ) ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )? ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )? ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )? '{' ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )* '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:775:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:778:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1654);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:796:3: (lv_abstract_1= 'abstract' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:798:6: lv_abstract_1= 'abstract'
                    {
                    lv_abstract_1=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleEClassDecl1680); 

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
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:817:3: ( (lv_interface_2= 'interface' ) | 'class' )
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
                    new NoViableAltException("817:3: ( (lv_interface_2= 'interface' ) | 'class' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:817:4: (lv_interface_2= 'interface' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:817:4: (lv_interface_2= 'interface' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:819:6: lv_interface_2= 'interface'
                    {
                    lv_interface_2=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleEClassDecl1716); 

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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:839:6: 'class'
                    {
                    match(input,32,FOLLOW_32_in_ruleEClassDecl1744); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getClassKeyword_2_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:843:2: (lv_name_4= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:845:6: lv_name_4= RULE_ID
            {
            lv_name_4=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEClassDecl1767); 

            		createLeafNode(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_4, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:863:2: ( '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:863:3: '<' (lv_eTypeParameters_6= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )* '>'
                    {
                    match(input,33,FOLLOW_33_in_ruleEClassDecl1785); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getLessThanSignKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:867:1: (lv_eTypeParameters_6= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:870:6: lv_eTypeParameters_6= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1819);
                    lv_eTypeParameters_6=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eTypeParameters", lv_eTypeParameters_6, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:2: ( ',' (lv_eTypeParameters_8= ruleETypeParameterDecl ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==28) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:888:3: ',' (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEClassDecl1833); 

                    	            createLeafNode(grammarAccess.getEClassDeclAccess().getCommaKeyword_4_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:892:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:895:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1867);
                    	    lv_eTypeParameters_8=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
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

                    match(input,34,FOLLOW_34_in_ruleEClassDecl1882); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getGreaterThanSignKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:917:3: ( 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:917:4: 'extends' (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    {
                    match(input,35,FOLLOW_35_in_ruleEClassDecl1894); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getExtendsKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:921:1: (lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:924:6: lv_eGenericSuperTypes_11= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1928);
                    lv_eGenericSuperTypes_11=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eGenericSuperTypes", lv_eGenericSuperTypes_11, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:942:2: ( ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==28) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:942:3: ',' (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEClassDecl1942); 

                    	            createLeafNode(grammarAccess.getEClassDeclAccess().getCommaKeyword_5_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:946:1: (lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:949:6: lv_eGenericSuperTypes_13= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1976);
                    	    lv_eGenericSuperTypes_13=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:967:6: ( ':' (lv_instanceClassName_15= ruleSTRING_OR_QID ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:967:7: ':' (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    {
                    match(input,25,FOLLOW_25_in_ruleEClassDecl1994); 

                            createLeafNode(grammarAccess.getEClassDeclAccess().getColonKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:971:1: (lv_instanceClassName_15= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:974:6: lv_instanceClassName_15= ruleSTRING_OR_QID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2028);
                    lv_instanceClassName_15=ruleSTRING_OR_QID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
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

            match(input,22,FOLLOW_22_in_ruleEClassDecl2043); 

                    createLeafNode(grammarAccess.getEClassDeclAccess().getLeftCurlyBracketKeyword_7(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:996:1: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:996:2: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:996:2: (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:999:6: lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesEStructuralFeatureDeclParserRuleCall_8_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2078);
            	    lv_eStructuralFeatures_17=ruleEStructuralFeatureDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1018:6: (lv_eOperations_18= ruleEOperationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1018:6: (lv_eOperations_18= ruleEOperationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1021:6: lv_eOperations_18= ruleEOperationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEClassDeclAccess().getEOperationsEOperationDeclParserRuleCall_8_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2122);
            	    lv_eOperations_18=ruleEOperationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEClassDeclRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleEClassDecl2137); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1050:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1050:64: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1051:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEStructuralFeatureDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2170);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();
            _fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2180); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1058:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl_0 = null;

        EObject this_EReferenceDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1063:6: ( (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1064:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1064:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1065:5: this_EAttributeDecl_0= ruleEAttributeDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEStructuralFeatureDeclAccess().getEAttributeDeclParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2227);
                    this_EAttributeDecl_0=ruleEAttributeDecl();
                    _fsp--;

                     
                            current = this_EAttributeDecl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1075:5: this_EReferenceDecl_1= ruleEReferenceDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEStructuralFeatureDeclAccess().getEReferenceDeclParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2254);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1090:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1090:56: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1091:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEAttributeDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2286);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();
            _fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAttributeDecl2296); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1098:1: ruleEAttributeDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1103:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1104:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1104:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1104:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* 'attr' (lv_eGenericType_10= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )? (lv_name_16= RULE_ID ) ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1104:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1107:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEAttributeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2355);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:3: ( (lv_iD_1= 'ID' ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:4: (lv_iD_1= 'ID' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1125:4: (lv_iD_1= 'ID' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1127:6: lv_iD_1= 'ID'
            	    {
            	    lv_iD_1=(Token)input.LT(1);
            	    match(input,36,FOLLOW_36_in_ruleEAttributeDecl2382); 

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
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:6: (lv_unique_2= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1147:6: (lv_unique_2= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1149:6: lv_unique_2= RULE_BAG
            	    {
            	    lv_unique_2=(Token)input.LT(1);
            	    match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEAttributeDecl2423); 

            	    		createLeafNode(grammarAccess.getEAttributeDeclAccess().getUniqueBagTerminalRuleCall_1_1_0(), "unique"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1168:6: (lv_ordered_3= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1168:6: (lv_ordered_3= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1170:6: lv_ordered_3= RULE_RANDOM
            	    {
            	    lv_ordered_3=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2459); 

            	    		createLeafNode(grammarAccess.getEAttributeDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0(), "ordered"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:6: (lv_changeable_4= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1189:6: (lv_changeable_4= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1191:6: lv_changeable_4= RULE_READONLY
            	    {
            	    lv_changeable_4=(Token)input.LT(1);
            	    match(input,RULE_READONLY,FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2495); 

            	    		createLeafNode(grammarAccess.getEAttributeDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0(), "changeable"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1210:6: (lv_volatile_5= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1210:6: (lv_volatile_5= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1212:6: lv_volatile_5= 'volatile'
            	    {
            	    lv_volatile_5=(Token)input.LT(1);
            	    match(input,37,FOLLOW_37_in_ruleEAttributeDecl2530); 

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
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1232:6: (lv_transient_6= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1232:6: (lv_transient_6= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1234:6: lv_transient_6= 'transient'
            	    {
            	    lv_transient_6=(Token)input.LT(1);
            	    match(input,38,FOLLOW_38_in_ruleEAttributeDecl2570); 

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
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1254:6: (lv_unsettable_7= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1254:6: (lv_unsettable_7= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1256:6: lv_unsettable_7= 'unsettable'
            	    {
            	    lv_unsettable_7=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEAttributeDecl2610); 

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
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1276:6: (lv_derived_8= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1276:6: (lv_derived_8= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1278:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,40,FOLLOW_40_in_ruleEAttributeDecl2650); 

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
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            match(input,41,FOLLOW_41_in_ruleEAttributeDecl2674); 

                    createLeafNode(grammarAccess.getEAttributeDeclAccess().getAttrKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1301:1: (lv_eGenericType_10= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1304:6: lv_eGenericType_10= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEAttributeDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2708);
            lv_eGenericType_10=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_10, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1322:2: ( '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1322:3: '[' (lv_lowerBound_12= RULE_INT ) ( '..' (lv_upperBound_14= ruleSINT ) )? ']'
                    {
                    match(input,42,FOLLOW_42_in_ruleEAttributeDecl2722); 

                            createLeafNode(grammarAccess.getEAttributeDeclAccess().getLeftSquareBracketKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1326:1: (lv_lowerBound_12= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1328:6: lv_lowerBound_12= RULE_INT
                    {
                    lv_lowerBound_12=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEAttributeDecl2744); 

                    		createLeafNode(grammarAccess.getEAttributeDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0(), "lowerBound"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "lowerBound", lv_lowerBound_12, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1346:2: ( '..' (lv_upperBound_14= ruleSINT ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==43) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1346:3: '..' (lv_upperBound_14= ruleSINT )
                            {
                            match(input,43,FOLLOW_43_in_ruleEAttributeDecl2762); 

                                    createLeafNode(grammarAccess.getEAttributeDeclAccess().getFullStopFullStopKeyword_4_2_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1350:1: (lv_upperBound_14= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1353:6: lv_upperBound_14= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEAttributeDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEAttributeDecl2796);
                            lv_upperBound_14=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
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

                    match(input,44,FOLLOW_44_in_ruleEAttributeDecl2811); 

                            createLeafNode(grammarAccess.getEAttributeDeclAccess().getRightSquareBracketKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1375:3: (lv_name_16= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1377:6: lv_name_16= RULE_ID
            {
            lv_name_16=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAttributeDecl2835); 

            		createLeafNode(grammarAccess.getEAttributeDeclAccess().getNameIDTerminalRuleCall_5_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_16, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1395:2: ( '=' (lv_defaultValueLiteral_18= RULE_STRING ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1395:3: '=' (lv_defaultValueLiteral_18= RULE_STRING )
                    {
                    match(input,17,FOLLOW_17_in_ruleEAttributeDecl2853); 

                            createLeafNode(grammarAccess.getEAttributeDeclAccess().getEqualsSignKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1399:1: (lv_defaultValueLiteral_18= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1401:6: lv_defaultValueLiteral_18= RULE_STRING
                    {
                    lv_defaultValueLiteral_18=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAttributeDecl2875); 

                    		createLeafNode(grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0(), "defaultValueLiteral"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEAttributeDeclRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleEAttributeDecl2894); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1430:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1430:56: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1431:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEReferenceDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2927);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();
            _fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEReferenceDecl2937); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1438:1: ruleEReferenceDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1443:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1444:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1444:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1444:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )* ( (lv_containment_9= 'val' ) | 'ref' ) (lv_eGenericType_11= ruleEGenericTypeReferenceDecl ) ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )? ( '#' ( RULE_ID ) )? (lv_name_19= RULE_ID ) ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1444:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==26) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1447:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEReferenceDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl2996);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:3: ( (lv_resolveProxies_1= RULE_LOCAL ) | (lv_unique_2= RULE_BAG ) | (lv_ordered_3= RULE_RANDOM ) | (lv_changeable_4= RULE_READONLY ) | (lv_volatile_5= 'volatile' ) | (lv_transient_6= 'transient' ) | (lv_unsettable_7= 'unsettable' ) | (lv_derived_8= 'derived' ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:4: (lv_resolveProxies_1= RULE_LOCAL )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1465:4: (lv_resolveProxies_1= RULE_LOCAL )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1467:6: lv_resolveProxies_1= RULE_LOCAL
            	    {
            	    lv_resolveProxies_1=(Token)input.LT(1);
            	    match(input,RULE_LOCAL,FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl3024); 

            	    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getResolveProxiesLocalTerminalRuleCall_1_0_0(), "resolveProxies"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1486:6: (lv_unique_2= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1486:6: (lv_unique_2= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1488:6: lv_unique_2= RULE_BAG
            	    {
            	    lv_unique_2=(Token)input.LT(1);
            	    match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEReferenceDecl3060); 

            	    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getUniqueBagTerminalRuleCall_1_1_0(), "unique"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1507:6: (lv_ordered_3= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1507:6: (lv_ordered_3= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1509:6: lv_ordered_3= RULE_RANDOM
            	    {
            	    lv_ordered_3=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl3096); 

            	    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0(), "ordered"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1528:6: (lv_changeable_4= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1528:6: (lv_changeable_4= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1530:6: lv_changeable_4= RULE_READONLY
            	    {
            	    lv_changeable_4=(Token)input.LT(1);
            	    match(input,RULE_READONLY,FOLLOW_RULE_READONLY_in_ruleEReferenceDecl3132); 

            	    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0(), "changeable"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1549:6: (lv_volatile_5= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1549:6: (lv_volatile_5= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1551:6: lv_volatile_5= 'volatile'
            	    {
            	    lv_volatile_5=(Token)input.LT(1);
            	    match(input,37,FOLLOW_37_in_ruleEReferenceDecl3167); 

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
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1571:6: (lv_transient_6= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1571:6: (lv_transient_6= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1573:6: lv_transient_6= 'transient'
            	    {
            	    lv_transient_6=(Token)input.LT(1);
            	    match(input,38,FOLLOW_38_in_ruleEReferenceDecl3207); 

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
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1593:6: (lv_unsettable_7= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1593:6: (lv_unsettable_7= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1595:6: lv_unsettable_7= 'unsettable'
            	    {
            	    lv_unsettable_7=(Token)input.LT(1);
            	    match(input,39,FOLLOW_39_in_ruleEReferenceDecl3247); 

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
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1615:6: (lv_derived_8= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1615:6: (lv_derived_8= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1617:6: lv_derived_8= 'derived'
            	    {
            	    lv_derived_8=(Token)input.LT(1);
            	    match(input,40,FOLLOW_40_in_ruleEReferenceDecl3287); 

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
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1636:4: ( (lv_containment_9= 'val' ) | 'ref' )
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
                    new NoViableAltException("1636:4: ( (lv_containment_9= 'val' ) | 'ref' )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1636:5: (lv_containment_9= 'val' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1636:5: (lv_containment_9= 'val' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1638:6: lv_containment_9= 'val'
                    {
                    lv_containment_9=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleEReferenceDecl3324); 

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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1658:6: 'ref'
                    {
                    match(input,46,FOLLOW_46_in_ruleEReferenceDecl3352); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getRefKeyword_2_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1662:2: (lv_eGenericType_11= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1665:6: lv_eGenericType_11= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEReferenceDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3387);
            lv_eGenericType_11=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_11, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1683:2: ( '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1683:3: '[' (lv_lowerBound_13= RULE_INT ) ( '..' (lv_upperBound_15= ruleSINT ) )? ']'
                    {
                    match(input,42,FOLLOW_42_in_ruleEReferenceDecl3401); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getLeftSquareBracketKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1687:1: (lv_lowerBound_13= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1689:6: lv_lowerBound_13= RULE_INT
                    {
                    lv_lowerBound_13=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEReferenceDecl3423); 

                    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0(), "lowerBound"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "lowerBound", lv_lowerBound_13, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1707:2: ( '..' (lv_upperBound_15= ruleSINT ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==43) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1707:3: '..' (lv_upperBound_15= ruleSINT )
                            {
                            match(input,43,FOLLOW_43_in_ruleEReferenceDecl3441); 

                                    createLeafNode(grammarAccess.getEReferenceDeclAccess().getFullStopFullStopKeyword_4_2_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1711:1: (lv_upperBound_15= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1714:6: lv_upperBound_15= ruleSINT
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEReferenceDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEReferenceDecl3475);
                            lv_upperBound_15=ruleSINT();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
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

                    match(input,44,FOLLOW_44_in_ruleEReferenceDecl3490); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getRightSquareBracketKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1736:3: ( '#' ( RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1736:4: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEReferenceDecl3502); 

                            createLeafNode(grammarAccess.getEReferenceDeclAccess().getNumberSignKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1740:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1743:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3524); 

                    		createLeafNode(grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceCrossReference_5_1_0(), "eOpposite"); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1756:4: (lv_name_19= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1758:6: lv_name_19= RULE_ID
            {
            lv_name_19=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3551); 

            		createLeafNode(grammarAccess.getEReferenceDeclAccess().getNameIDTerminalRuleCall_6_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEReferenceDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_19, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,18,FOLLOW_18_in_ruleEReferenceDecl3568); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1787:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1787:51: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1788:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEEnumDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3601);
            iv_ruleEEnumDecl=ruleEEnumDecl();
            _fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumDecl3611); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1795:1: ruleEEnumDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eLiterals_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1800:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* 'enum' (lv_name_2= RULE_ID ) '{' (lv_eLiterals_4= ruleEEnumLiteralDecl )+ '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1801:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==26) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1804:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEEnumDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3670);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEEnumDeclRule().getType().getClassifier());
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

            match(input,48,FOLLOW_48_in_ruleEEnumDecl3684); 

                    createLeafNode(grammarAccess.getEEnumDeclAccess().getEnumKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1826:1: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1828:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumDecl3706); 

            		createLeafNode(grammarAccess.getEEnumDeclAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEEnumDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,22,FOLLOW_22_in_ruleEEnumDecl3723); 

                    createLeafNode(grammarAccess.getEEnumDeclAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1850:1: (lv_eLiterals_4= ruleEEnumLiteralDecl )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1853:6: lv_eLiterals_4= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEEnumDeclAccess().getELiteralsEEnumLiteralDeclParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3757);
            	    lv_eLiterals_4=ruleEEnumLiteralDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEEnumDeclRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleEEnumDecl3771); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1882:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1882:58: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1883:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEEnumLiteralDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3804);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();
            _fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3814); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1890:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_value_3=null;
        Token lv_literal_4=null;
        EObject lv_eAnnotations_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1895:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1896:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1896:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1896:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_name_1= RULE_ID ) ( '=' (lv_value_3= RULE_INT ) )? (lv_literal_4= RULE_STRING )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1896:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==26) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1899:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3873);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1917:3: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1919:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3900); 

            		createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1937:2: ( '=' (lv_value_3= RULE_INT ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1937:3: '=' (lv_value_3= RULE_INT )
                    {
                    match(input,17,FOLLOW_17_in_ruleEEnumLiteralDecl3918); 

                            createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getEqualsSignKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1941:1: (lv_value_3= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1943:6: lv_value_3= RULE_INT
                    {
                    lv_value_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3940); 

                    		createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getValueINTTerminalRuleCall_2_1_0(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1961:4: (lv_literal_4= RULE_STRING )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1963:6: lv_literal_4= RULE_STRING
                    {
                    lv_literal_4=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl3972); 

                    		createLeafNode(grammarAccess.getEEnumLiteralDeclAccess().getLiteralSTRINGTerminalRuleCall_3_0(), "literal"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEEnumLiteralDeclRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleEEnumLiteralDecl3990); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1992:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1992:60: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1993:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getETypeParameterDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4023);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();
            _fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleETypeParameterDecl4033); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2000:1: ruleETypeParameterDecl returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_eBounds_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2005:6: ( ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2006:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2006:1: ( (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2006:2: (lv_name_0= RULE_ID ) ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2006:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2008:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleETypeParameterDecl4080); 

            		createLeafNode(grammarAccess.getETypeParameterDeclAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getETypeParameterDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2026:2: ( 'extends' (lv_eBounds_2= ruleEGenericTypeDecl ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2026:3: 'extends' (lv_eBounds_2= ruleEGenericTypeDecl )
                    {
                    match(input,35,FOLLOW_35_in_ruleETypeParameterDecl4098); 

                            createLeafNode(grammarAccess.getETypeParameterDeclAccess().getExtendsKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2030:1: (lv_eBounds_2= ruleEGenericTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2033:6: lv_eBounds_2= ruleEGenericTypeDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getETypeParameterDeclAccess().getEBoundsEGenericTypeDeclParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4132);
                    lv_eBounds_2=ruleEGenericTypeDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getETypeParameterDeclRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2058:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2058:67: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2059:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEGenericTypeReferenceDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4171);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();
            _fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4181); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2066:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2071:6: ( ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2072:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2072:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) )
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
                    new NoViableAltException("2072:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2072:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2072:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2072:3: ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2072:3: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2075:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4229); 

                    		createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierCrossReference_0_0_0(), "eClassifier"); 
                    	

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:2: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==33) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2088:3: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>'
                            {
                            match(input,33,FOLLOW_33_in_ruleEGenericTypeReferenceDecl4242); 

                                    createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getLessThanSignKeyword_0_1_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2092:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2095:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4276);
                            lv_eTypeArguments_2=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "eTypeArguments", lv_eTypeArguments_2, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2113:2: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==28) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2113:3: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,28,FOLLOW_28_in_ruleEGenericTypeReferenceDecl4290); 

                            	            createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getCommaKeyword_0_1_2_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2117:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2120:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4324);
                            	    lv_eTypeArguments_4=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
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

                            match(input,34,FOLLOW_34_in_ruleEGenericTypeReferenceDecl4339); 

                                    createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getGreaterThanSignKeyword_0_1_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2143:6: ( '#' ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2143:6: ( '#' ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2143:7: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeReferenceDecl4358); 

                            createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getNumberSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2147:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2150:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeReferenceDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4380); 

                    		createLeafNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0(), "eTypeParameter"); 
                    	

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2170:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2170:58: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2171:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEGenericTypeDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4417);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();
            _fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeDecl4427); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2178:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_eTypeArguments_2 = null;

        EObject lv_eTypeArguments_4 = null;

        EObject lv_eUpperBound_10 = null;

        EObject lv_eLowerBound_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2183:6: ( ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2184:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2184:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )
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
                    new NoViableAltException("2184:1: ( ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? ) | ( '#' ( RULE_ID ) ) | ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) ) )", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2184:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2184:2: ( ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2184:3: ( RULE_ID ) ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2184:3: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2187:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4475); 

                    		createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierCrossReference_0_0_0(), "eClassifier"); 
                    	

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2200:2: ( '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==33) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2200:3: '<' (lv_eTypeArguments_2= ruleEGenericTypeDecl ) ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )* '>'
                            {
                            match(input,33,FOLLOW_33_in_ruleEGenericTypeDecl4488); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getLessThanSignKeyword_0_1_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2204:1: (lv_eTypeArguments_2= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2207:6: lv_eTypeArguments_2= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4522);
                            lv_eTypeArguments_2=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "eTypeArguments", lv_eTypeArguments_2, "EGenericTypeDecl", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2225:2: ( ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==28) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2225:3: ',' (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    {
                            	    match(input,28,FOLLOW_28_in_ruleEGenericTypeDecl4536); 

                            	            createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getCommaKeyword_0_1_2_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2229:1: (lv_eTypeArguments_4= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2232:6: lv_eTypeArguments_4= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4570);
                            	    lv_eTypeArguments_4=ruleEGenericTypeDecl();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
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

                            match(input,34,FOLLOW_34_in_ruleEGenericTypeDecl4585); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getGreaterThanSignKeyword_0_1_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:6: ( '#' ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:6: ( '#' ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2255:7: '#' ( RULE_ID )
                    {
                    match(input,47,FOLLOW_47_in_ruleEGenericTypeDecl4604); 

                            createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getNumberSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2259:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2262:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4626); 

                    		createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0(), "eTypeParameter"); 
                    	

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:6: ( '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2276:7: '?' ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleEGenericTypeDecl4646); 

                            createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getQuestionMarkKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )
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
                            new NoViableAltException("2280:1: ( ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) ) | ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) ) )", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:2: ( 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2280:3: 'extends' (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            {
                            match(input,35,FOLLOW_35_in_ruleEGenericTypeDecl4657); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getExtendsKeyword_2_1_0_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2284:1: (lv_eUpperBound_10= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2287:6: lv_eUpperBound_10= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundEGenericTypeDeclParserRuleCall_2_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4691);
                            lv_eUpperBound_10=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
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
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2306:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2306:6: ( 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2306:7: 'super' (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            {
                            match(input,50,FOLLOW_50_in_ruleEGenericTypeDecl4712); 

                                    createLeafNode(grammarAccess.getEGenericTypeDeclAccess().getSuperKeyword_2_1_1_0(), null); 
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2310:1: (lv_eLowerBound_12= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2313:6: lv_eLowerBound_12= ruleEGenericTypeDecl
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundEGenericTypeDeclParserRuleCall_2_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4746);
                            lv_eLowerBound_12=ruleEGenericTypeDecl();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getEGenericTypeDeclRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2338:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2338:56: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2339:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEOperationDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4786);
            iv_ruleEOperationDecl=ruleEOperationDecl();
            _fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEOperationDecl4796); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2346:1: ruleEOperationDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' ) ;
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2351:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2352:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2352:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2352:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )* 'op' ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' ) (lv_name_6= RULE_ID ) ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )? '(' ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )? ')' ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )? ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2352:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==26) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2355:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl4855);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:3: ( (lv_unique_1= 'bag' ) | (lv_ordered_2= 'random' ) )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:4: (lv_unique_1= 'bag' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2373:4: (lv_unique_1= 'bag' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2375:6: lv_unique_1= 'bag'
            	    {
            	    lv_unique_1=(Token)input.LT(1);
            	    match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEOperationDecl4882); 

            	            createLeafNode(grammarAccess.getEOperationDeclAccess().getUniqueBagKeyword_1_0_0(), "unique"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2395:6: (lv_ordered_2= 'random' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2395:6: (lv_ordered_2= 'random' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2397:6: lv_ordered_2= 'random'
            	    {
            	    lv_ordered_2=(Token)input.LT(1);
            	    match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4922); 

            	            createLeafNode(grammarAccess.getEOperationDeclAccess().getOrderedRandomKeyword_1_1_0(), "ordered"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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

            match(input,51,FOLLOW_51_in_ruleEOperationDecl4946); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getOpKeyword_2(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2420:1: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )
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
                    new NoViableAltException("2420:1: ( (lv_eGenericType_4= ruleEGenericTypeReferenceDecl ) | 'void' )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2420:2: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2420:2: (lv_eGenericType_4= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2423:6: lv_eGenericType_4= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4981);
                    lv_eGenericType_4=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2442:6: 'void'
                    {
                    match(input,52,FOLLOW_52_in_ruleEOperationDecl5000); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getVoidKeyword_3_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2446:2: (lv_name_6= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2448:6: lv_name_6= RULE_ID
            {
            lv_name_6=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEOperationDecl5023); 

            		createLeafNode(grammarAccess.getEOperationDeclAccess().getNameIDTerminalRuleCall_4_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_6, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2466:2: ( '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==33) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2466:3: '<' (lv_eTypeParameters_8= ruleETypeParameterDecl ) ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )* '>'
                    {
                    match(input,33,FOLLOW_33_in_ruleEOperationDecl5041); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getLessThanSignKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2470:1: (lv_eTypeParameters_8= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2473:6: lv_eTypeParameters_8= ruleETypeParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5075);
                    lv_eTypeParameters_8=ruleETypeParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eTypeParameters", lv_eTypeParameters_8, "ETypeParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2491:2: ( ',' (lv_eTypeParameters_10= ruleETypeParameterDecl ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==28) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2491:3: ',' (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEOperationDecl5089); 

                    	            createLeafNode(grammarAccess.getEOperationDeclAccess().getCommaKeyword_5_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2495:1: (lv_eTypeParameters_10= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2498:6: lv_eTypeParameters_10= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5123);
                    	    lv_eTypeParameters_10=ruleETypeParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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

                    match(input,34,FOLLOW_34_in_ruleEOperationDecl5138); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getGreaterThanSignKeyword_5_3(), null); 
                        

                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_ruleEOperationDecl5149); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getLeftParenthesisKeyword_6(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2524:1: ( (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID||LA53_0==26||LA53_0==47) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2524:2: (lv_eParameters_13= ruleEParameterDecl ) ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2524:2: (lv_eParameters_13= ruleEParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2527:6: lv_eParameters_13= ruleEParameterDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5184);
                    lv_eParameters_13=ruleEParameterDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eParameters", lv_eParameters_13, "EParameterDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:2: ( ',' (lv_eParameters_15= ruleEParameterDecl ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==28) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:3: ',' (lv_eParameters_15= ruleEParameterDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEOperationDecl5198); 

                    	            createLeafNode(grammarAccess.getEOperationDeclAccess().getCommaKeyword_7_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2549:1: (lv_eParameters_15= ruleEParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2552:6: lv_eParameters_15= ruleEParameterDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5232);
                    	    lv_eParameters_15=ruleEParameterDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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

            match(input,29,FOLLOW_29_in_ruleEOperationDecl5249); 

                    createLeafNode(grammarAccess.getEOperationDeclAccess().getRightParenthesisKeyword_8(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2574:1: ( 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==53) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2574:2: 'throws' (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl ) ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    {
                    match(input,53,FOLLOW_53_in_ruleEOperationDecl5259); 

                            createLeafNode(grammarAccess.getEOperationDeclAccess().getThrowsKeyword_9_0(), null); 
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2578:1: (lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2581:6: lv_eGenericExceptions_18= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5293);
                    lv_eGenericExceptions_18=ruleEGenericTypeReferenceDecl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "eGenericExceptions", lv_eGenericExceptions_18, "EGenericTypeReferenceDecl", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2599:2: ( ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==28) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2599:3: ',' (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleEOperationDecl5307); 

                    	            createLeafNode(grammarAccess.getEOperationDeclAccess().getCommaKeyword_9_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2603:1: (lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2606:6: lv_eGenericExceptions_20= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5341);
                    	    lv_eGenericExceptions_20=ruleEGenericTypeReferenceDecl();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEOperationDeclRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleEOperationDecl5358); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2635:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2635:56: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2636:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEParameterDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5391);
            iv_ruleEParameterDecl=ruleEParameterDecl();
            _fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEParameterDecl5401); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2643:1: ruleEParameterDecl returns [EObject current=null] : ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_eAnnotations_0 = null;

        EObject lv_eGenericType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2648:6: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2649:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2649:1: ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2649:2: (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_eGenericType_1= ruleEGenericTypeReferenceDecl ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2649:2: (lv_eAnnotations_0= ruleEAnnotationDecl )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==26) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2652:6: lv_eAnnotations_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEParameterDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5460);
            	    lv_eAnnotations_0=ruleEAnnotationDecl();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEParameterDeclRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2670:3: (lv_eGenericType_1= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2673:6: lv_eGenericType_1= ruleEGenericTypeReferenceDecl
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEParameterDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5499);
            lv_eGenericType_1=ruleEGenericTypeReferenceDecl();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEParameterDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "eGenericType", lv_eGenericType_1, "EGenericTypeReferenceDecl", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2691:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2693:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEParameterDecl5525); 

            		createLeafNode(grammarAccess.getEParameterDeclAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEParameterDeclRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2718:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2718:50: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2719:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMapEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleMapEntry_in_entryRuleMapEntry5566);
            iv_ruleMapEntry=ruleMapEntry();
            _fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntry5576); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2726:1: ruleMapEntry returns [EObject current=null] : ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_key_0=null;
        Token lv_value_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2731:6: ( ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2732:1: ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2732:1: ( (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2732:2: (lv_key_0= RULE_ID ) '=' (lv_value_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2732:2: (lv_key_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2734:6: lv_key_0= RULE_ID
            {
            lv_key_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMapEntry5623); 

            		createLeafNode(grammarAccess.getMapEntryAccess().getKeyIDTerminalRuleCall_0_0(), "key"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMapEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "key", lv_key_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,17,FOLLOW_17_in_ruleMapEntry5640); 

                    createLeafNode(grammarAccess.getMapEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2756:1: (lv_value_2= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2758:6: lv_value_2= RULE_STRING
            {
            lv_value_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMapEntry5662); 

            		createLeafNode(grammarAccess.getMapEntryAccess().getValueSTRINGTerminalRuleCall_2_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMapEntryRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2783:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2783:44: (iv_ruleQID= ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2784:2: iv_ruleQID= ruleQID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID5704);
            iv_ruleQID=ruleQID();
            _fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID5715); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2791:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2797:6: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2798:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2798:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2798:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID5755); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2805:1: ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=54 && LA58_0<=55)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2805:2: (kw= '.' | kw= '$' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2805:2: (kw= '.' | kw= '$' )
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
            	            new NoViableAltException("2805:2: (kw= '.' | kw= '$' )", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2806:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,54,FOLLOW_54_in_ruleQID5775); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2813:2: kw= '$'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,55,FOLLOW_55_in_ruleQID5794); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.getQIDAccess().getDollarSignKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID5810); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2833:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2833:54: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2834:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSTRING_OR_QIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID5856);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();
            _fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_OR_QID5867); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2841:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_QID_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2847:6: ( (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2848:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2848:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
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
                    new NoViableAltException("2848:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2848:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID5907); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2857:5: this_QID_1= ruleQID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSTRING_OR_QIDAccess().getQIDParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQID_in_ruleSTRING_OR_QID5940);
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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2875:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2875:45: (iv_ruleSINT= ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2876:2: iv_ruleSINT= ruleSINT EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSINTRule(), currentNode); 
            pushFollow(FOLLOW_ruleSINT_in_entryRuleSINT5984);
            iv_ruleSINT=ruleSINT();
            _fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSINT5995); 

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
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2883:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2889:6: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2890:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2890:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2890:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2890:2: (kw= '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2891:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleSINT6034); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getSINTAccess().getHyphenMinusKeyword_0(), null); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSINT6051); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.getSINTAccess().getINTTerminalRuleCall_1(), null); 
                

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
            return "()* loopback of 325:1: ( (lv_eSubpackages_10= ruleSubEPackageDecl ) | (lv_eClassifiers_11= ruleEClassifierDecl ) )*";
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
            return "()* loopback of 442:1: ( (lv_eSubpackages_4= ruleSubEPackageDecl ) | (lv_eClassifiers_5= ruleEClassifierDecl ) )*";
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
            return "510:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )";
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
            return "550:1: ( ( (lv_eAnnotations_0= ruleEAnnotationDecl )* (lv_serializable_1= RULE_SERIALIZABLE )? ( 'datatype' (lv_name_3= RULE_ID ) ':' (lv_instanceClassName_5= ruleSTRING_OR_QID ) ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )";
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
            return "()* loopback of 996:1: ( (lv_eStructuralFeatures_17= ruleEStructuralFeatureDecl ) | (lv_eOperations_18= ruleEOperationDecl ) )*";
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
            return "1064:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )";
        }
    }
 

    public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleEcoreDsl142 = new BitSet(new long[]{0x0000000004090000L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel262 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel285 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleReferencedMetamodel302 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel326 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReferencedMetamodel338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl440 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_19_in_ruleEPackageDecl454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl488 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEPackageDecl501 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl510 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl532 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEPackageDecl549 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl558 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl592 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEPackageDecl605 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl640 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl684 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_23_in_ruleEPackageDecl699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl801 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_19_in_ruleSubEPackageDecl815 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl837 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSubEPackageDecl854 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl889 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl933 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_23_in_ruleSubEPackageDecl948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl1097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1167 = new BitSet(new long[]{0x0000000005000040L});
    public static final BitSet FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl1194 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleEDataTypeDecl1213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1235 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEDataTypeDecl1252 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1286 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEDataTypeDecl1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleEAnnotationDecl1405 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1439 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleEAnnotationDecl1453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1487 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleEAnnotationDecl1501 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1535 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleEAnnotationDecl1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1654 = new BitSet(new long[]{0x00000001C4000000L});
    public static final BitSet FOLLOW_30_in_ruleEClassDecl1680 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_31_in_ruleEClassDecl1716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_32_in_ruleEClassDecl1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1767 = new BitSet(new long[]{0x0000000A02400000L});
    public static final BitSet FOLLOW_33_in_ruleEClassDecl1785 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1819 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1833 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1867 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEClassDecl1882 = new BitSet(new long[]{0x0000000802400000L});
    public static final BitSet FOLLOW_35_in_ruleEClassDecl1894 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1928 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1942 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1976 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_25_in_ruleEClassDecl1994 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl2028 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEClassDecl2043 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl2078 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl2122 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_23_in_ruleEClassDecl2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl2170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl2286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl2296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2355 = new BitSet(new long[]{0x000003F004000380L});
    public static final BitSet FOLLOW_36_in_ruleEAttributeDecl2382 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEAttributeDecl2423 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2459 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2495 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2530 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2570 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2610 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2650 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2674 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2708 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2722 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2744 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2762 = new BitSet(new long[]{0x0100000000000400L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2796 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleEAttributeDecl2811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2835 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleEAttributeDecl2853 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl2875 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEAttributeDecl2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl2996 = new BitSet(new long[]{0x000061E004000B80L});
    public static final BitSet FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl3024 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEReferenceDecl3060 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl3096 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_READONLY_in_ruleEReferenceDecl3132 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_37_in_ruleEReferenceDecl3167 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_38_in_ruleEReferenceDecl3207 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_39_in_ruleEReferenceDecl3247 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_40_in_ruleEReferenceDecl3287 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_45_in_ruleEReferenceDecl3324 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_46_in_ruleEReferenceDecl3352 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl3387 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_42_in_ruleEReferenceDecl3401 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl3423 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleEReferenceDecl3441 = new BitSet(new long[]{0x0100000000000400L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl3475 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleEReferenceDecl3490 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_47_in_ruleEReferenceDecl3502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3524 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3551 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEReferenceDecl3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3670 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_48_in_ruleEEnumDecl3684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3706 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEEnumDecl3723 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3757 = new BitSet(new long[]{0x0000000004800010L});
    public static final BitSet FOLLOW_23_in_ruleEEnumDecl3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3873 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3900 = new BitSet(new long[]{0x0000000000060020L});
    public static final BitSet FOLLOW_17_in_ruleEEnumLiteralDecl3918 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3940 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl3972 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEEnumLiteralDecl3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl4023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl4033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl4080 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleETypeParameterDecl4098 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl4132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl4171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4229 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleEGenericTypeReferenceDecl4242 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4276 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEGenericTypeReferenceDecl4290 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl4324 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEGenericTypeReferenceDecl4339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl4358 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl4380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl4417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl4427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4475 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleEGenericTypeDecl4488 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4522 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEGenericTypeDecl4536 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4570 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEGenericTypeDecl4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl4604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl4646 = new BitSet(new long[]{0x0004000800000000L});
    public static final BitSet FOLLOW_35_in_ruleEGenericTypeDecl4657 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl4712 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl4855 = new BitSet(new long[]{0x0008000004000180L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEOperationDecl4882 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4922 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_51_in_ruleEOperationDecl4946 = new BitSet(new long[]{0x0010800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4981 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52_in_ruleEOperationDecl5000 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl5023 = new BitSet(new long[]{0x0000000208000000L});
    public static final BitSet FOLLOW_33_in_ruleEOperationDecl5041 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5075 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl5089 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl5123 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEOperationDecl5138 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleEOperationDecl5149 = new BitSet(new long[]{0x0000800024000010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5184 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl5198 = new BitSet(new long[]{0x0000800004000010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl5232 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleEOperationDecl5249 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_53_in_ruleEOperationDecl5259 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5293 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl5307 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl5341 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleEOperationDecl5358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl5391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl5460 = new BitSet(new long[]{0x0000800004000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl5499 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry5566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry5623 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMapEntry5640 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry5662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID5704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID5715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID5755 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleQID5775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleQID5794 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID5810 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID5856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID5867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID5907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID5940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT5984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSINT5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSINT6034 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSINT6051 = new BitSet(new long[]{0x0000000000000002L});

}
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
import java.util.Map;
import java.util.HashMap;
public class InternalDomainmodelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'{'", "'}'", "'datatype'", "'entity'", "'extends'", "'attr'", "':'", "'ref'", "'opposite'", "'op'", "'('", "','", "')'", "'.*'", "'.'", "'public'", "'private'", "'protected'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDomainmodelParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[50+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g"; }


     
     	private DomainmodelGrammarAccess grammarAccess;
     	
        public InternalDomainmodelParser(TokenStream input, IAstFactory factory, DomainmodelGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:74:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:74:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:75:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel79);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel89); if (failed) return current;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:82:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:87:6: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:88:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:88:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)||(LA1_0>=15 && LA1_0<=16)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:89:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:89:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:90:3: lv_elements_0_0= ruleAbstractElement
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractElement_in_ruleModel134);
            	    lv_elements_0_0=ruleAbstractElement();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"elements",
            	      	        		lv_elements_0_0, 
            	      	        		"AbstractElement", 
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
            	    break loop1;
                }
            } while (true);


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAbstractElement
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:119:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:119:57: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:120:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAbstractElementRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement167);
            iv_ruleAbstractElement=ruleAbstractElement();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAbstractElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractElement177); if (failed) return current;

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
    // $ANTLR end entryRuleAbstractElement


    // $ANTLR start ruleAbstractElement
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:127:1: ruleAbstractElement returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_Type_1 = null;

        EObject this_Import_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:132:6: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:133:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:133:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt2=1;
                }
                break;
            case 15:
            case 16:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("133:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:134:5: this_PackageDeclaration_0= rulePackageDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulePackageDeclaration_in_ruleAbstractElement224);
                    this_PackageDeclaration_0=rulePackageDeclaration();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_PackageDeclaration_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:144:5: this_Type_1= ruleType
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAbstractElementAccess().getTypeParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleAbstractElement251);
                    this_Type_1=ruleType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Type_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:154:5: this_Import_2= ruleImport
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleImport_in_ruleAbstractElement278);
                    this_Import_2=ruleImport();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Import_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleAbstractElement


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:169:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:169:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:170:2: iv_ruleImport= ruleImport EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport310);
            iv_ruleImport=ruleImport();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport320); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:177:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:182:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:183:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:183:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:183:2: 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            match(input,11,FOLLOW_11_in_ruleImport354); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:187:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:188:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:188:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:189:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport375);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"importedNamespace",
              	        		lv_importedNamespace_1_0, 
              	        		"QualifiedNameWithWildCard", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRulePackageDeclaration
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:218:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:218:60: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:219:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPackageDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration408);
            iv_rulePackageDeclaration=rulePackageDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePackageDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration418); if (failed) return current;

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
    // $ANTLR end entryRulePackageDeclaration


    // $ANTLR start rulePackageDeclaration
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:226:1: rulePackageDeclaration returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= ruleAbstractElement ) )* '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:231:6: ( ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= ruleAbstractElement ) )* '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:232:1: ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= ruleAbstractElement ) )* '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:232:1: ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= ruleAbstractElement ) )* '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:232:2: 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= ruleAbstractElement ) )* '}'
            {
            match(input,12,FOLLOW_12_in_rulePackageDeclaration452); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:236:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:238:3: lv_name_1_0= ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDeclaration473);
            lv_name_1_0=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPackageDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"QualifiedName", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,13,FOLLOW_13_in_rulePackageDeclaration482); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:264:1: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)||(LA3_0>=15 && LA3_0<=16)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:265:1: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:265:1: (lv_elements_3_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:266:3: lv_elements_3_0= ruleAbstractElement
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractElement_in_rulePackageDeclaration503);
            	    lv_elements_3_0=ruleAbstractElement();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getPackageDeclarationRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"elements",
            	      	        		lv_elements_3_0, 
            	      	        		"AbstractElement", 
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
            	    break loop3;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_rulePackageDeclaration513); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulePackageDeclaration


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:299:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:299:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:300:2: iv_ruleType= ruleType EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType546);
            iv_ruleType=ruleType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType556); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:307:1: ruleType returns [EObject current=null] : (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_DataType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:312:6: ( (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:313:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:313:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("313:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:314:5: this_Entity_0= ruleEntity
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntity_in_ruleType603);
                    this_Entity_0=ruleEntity();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Entity_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:324:5: this_DataType_1= ruleDataType
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataType_in_ruleType630);
                    this_DataType_1=ruleDataType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_DataType_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleDataType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:339:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:339:50: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:340:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypeRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType662);
            iv_ruleDataType=ruleDataType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType672); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:347:1: ruleDataType returns [EObject current=null] : ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:352:6: ( ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:353:1: ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:353:1: ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:353:2: 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,15,FOLLOW_15_in_ruleDataType706); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:357:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:358:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:358:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:359:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType723); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDataTypeRule().getType().getClassifier());
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


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleDataType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:388:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:388:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:389:2: iv_ruleEntity= ruleEntity EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity761);
            iv_ruleEntity=ruleEntity();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEntity; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity771); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:396:1: ruleEntity returns [EObject current=null] : ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleQualifiedName ) ) )? '{' ( (lv_features_5_0= ruleFeature ) )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_features_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:401:6: ( ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleQualifiedName ) ) )? '{' ( (lv_features_5_0= ruleFeature ) )* '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleQualifiedName ) ) )? '{' ( (lv_features_5_0= ruleFeature ) )* '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleQualifiedName ) ) )? '{' ( (lv_features_5_0= ruleFeature ) )* '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:2: 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleQualifiedName ) ) )? '{' ( (lv_features_5_0= ruleFeature ) )* '}'
            {
            match(input,16,FOLLOW_16_in_ruleEntity805); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:406:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:407:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:407:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:408:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity822); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
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


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:430:2: ( 'extends' ( ( ruleQualifiedName ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:430:3: 'extends' ( ( ruleQualifiedName ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleEntity837); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getEntityAccess().getExtendsKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:434:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:435:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:435:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:436:3: ruleQualifiedName
                    {
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleEntity860);
                    ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleEntity871); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:454:1: ( (lv_features_5_0= ruleFeature ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20||LA6_0==22||(LA6_0>=28 && LA6_0<=30)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:455:1: (lv_features_5_0= ruleFeature )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:455:1: (lv_features_5_0= ruleFeature )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:456:3: lv_features_5_0= ruleFeature
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFeature_in_ruleEntity892);
            	    lv_features_5_0=ruleFeature();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"features",
            	      	        		lv_features_5_0, 
            	      	        		"Feature", 
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

            match(input,14,FOLLOW_14_in_ruleEntity902); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:489:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:489:49: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:490:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature935);
            iv_ruleFeature=ruleFeature();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature945); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:497:1: ruleFeature returns [EObject current=null] : (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_StructuralFeature_0 = null;

        EObject this_Operation_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:502:6: ( (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:503:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:503:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18||LA7_0==20) ) {
                alt7=1;
            }
            else if ( (LA7_0==22||(LA7_0>=28 && LA7_0<=30)) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("503:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:504:5: this_StructuralFeature_0= ruleStructuralFeature
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getStructuralFeatureParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStructuralFeature_in_ruleFeature992);
                    this_StructuralFeature_0=ruleStructuralFeature();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_StructuralFeature_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:514:5: this_Operation_1= ruleOperation
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getOperationParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperation_in_ruleFeature1019);
                    this_Operation_1=ruleOperation();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Operation_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleFeature


    // $ANTLR start entryRuleStructuralFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:529:1: entryRuleStructuralFeature returns [EObject current=null] : iv_ruleStructuralFeature= ruleStructuralFeature EOF ;
    public final EObject entryRuleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuralFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:529:59: (iv_ruleStructuralFeature= ruleStructuralFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:530:2: iv_ruleStructuralFeature= ruleStructuralFeature EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStructuralFeatureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1051);
            iv_ruleStructuralFeature=ruleStructuralFeature();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStructuralFeature; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructuralFeature1061); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:537:1: ruleStructuralFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:542:6: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:543:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:543:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("543:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:544:5: this_Attribute_0= ruleAttribute
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getStructuralFeatureAccess().getAttributeParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleAttribute_in_ruleStructuralFeature1108);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Attribute_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:554:5: this_Reference_1= ruleReference
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getStructuralFeatureAccess().getReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleReference_in_ruleStructuralFeature1135);
                    this_Reference_1=ruleReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Reference_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleStructuralFeature


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:569:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:569:51: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:570:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1167);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1177); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:577:1: ruleAttribute returns [EObject current=null] : ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:582:6: ( ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:583:1: ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:583:1: ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:583:2: 'attr' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) )
            {
            match(input,18,FOLLOW_18_in_ruleAttribute1211); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAttributeAccess().getAttrKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:587:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:588:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:588:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:589:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1228); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
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


            }

            match(input,19,FOLLOW_19_in_ruleAttribute1242); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAttributeAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:615:1: ( (lv_type_3_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:616:1: (lv_type_3_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:616:1: (lv_type_3_0= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:617:3: lv_type_3_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeRefParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAttribute1263);
            lv_type_3_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_3_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:646:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:646:51: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:647:2: iv_ruleReference= ruleReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1296);
            iv_ruleReference=ruleReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1306); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:654:1: ruleReference returns [EObject current=null] : ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:659:6: ( ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:660:1: ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:660:1: ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:660:2: 'ref' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_type_3_0= ruleTypeRef ) ) ( 'opposite' ( ( RULE_ID ) ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReference1340); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getReferenceAccess().getRefKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:664:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:665:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:665:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:666:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1357); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
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


            }

            match(input,19,FOLLOW_19_in_ruleReference1371); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getReferenceAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:692:1: ( (lv_type_3_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:693:1: (lv_type_3_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:693:1: (lv_type_3_0= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:694:3: lv_type_3_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getReferenceAccess().getTypeTypeRefParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleReference1392);
            lv_type_3_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_3_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:716:2: ( 'opposite' ( ( RULE_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:716:3: 'opposite' ( ( RULE_ID ) )
                    {
                    match(input,21,FOLLOW_21_in_ruleReference1402); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getReferenceAccess().getOppositeKeyword_4_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:720:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:721:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:721:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:722:3: RULE_ID
                    {
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1420); if (failed) return current;
                    if ( backtracking==0 ) {

                      		createLeafNode(grammarAccess.getReferenceAccess().getOppositeReferenceCrossReference_4_1_0(), "opposite"); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleReference


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:741:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:741:51: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:742:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation1455);
            iv_ruleOperation=ruleOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1465); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:749:1: ruleOperation returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? 'op' ( (lv_name_2_0= RULE_ID ) ) '(' ( ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )* )? ')' ':' ( (lv_type_9_0= ruleTypeRef ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_params_4_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_type_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:754:6: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? 'op' ( (lv_name_2_0= RULE_ID ) ) '(' ( ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )* )? ')' ':' ( (lv_type_9_0= ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:755:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? 'op' ( (lv_name_2_0= RULE_ID ) ) '(' ( ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )* )? ')' ':' ( (lv_type_9_0= ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:755:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? 'op' ( (lv_name_2_0= RULE_ID ) ) '(' ( ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )* )? ')' ':' ( (lv_type_9_0= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:755:2: ( (lv_visibility_0_0= ruleVisibility ) )? 'op' ( (lv_name_2_0= RULE_ID ) ) '(' ( ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )* )? ')' ':' ( (lv_type_9_0= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:755:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=28 && LA10_0<=30)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:756:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:756:1: (lv_visibility_0_0= ruleVisibility )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:757:3: lv_visibility_0_0= ruleVisibility
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVisibility_in_ruleOperation1511);
                    lv_visibility_0_0=ruleVisibility();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"visibility",
                      	        		lv_visibility_0_0, 
                      	        		"Visibility", 
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

            match(input,22,FOLLOW_22_in_ruleOperation1521); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationAccess().getOpKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:783:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:784:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:784:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:785:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation1538); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
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

            match(input,23,FOLLOW_23_in_ruleOperation1552); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:811:1: ( ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:811:2: ( (lv_params_4_0= ruleParameter ) ) ( ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:811:2: ( (lv_params_4_0= ruleParameter ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:812:1: (lv_params_4_0= ruleParameter )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:812:1: (lv_params_4_0= ruleParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:813:3: lv_params_4_0= ruleParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1574);
                    lv_params_4_0=ruleParameter();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_4_0, 
                      	        		"Parameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:835:2: ( ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==24) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:835:3: ',' ( (lv_params_6_0= ruleParameter ) )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleOperation1584); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:839:1: ( (lv_params_6_0= ruleParameter ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:840:1: (lv_params_6_0= ruleParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:840:1: (lv_params_6_0= ruleParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:841:3: lv_params_6_0= ruleParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1605);
                    	    lv_params_6_0=ruleParameter();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"params",
                    	      	        		lv_params_6_0, 
                    	      	        		"Parameter", 
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

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_ruleOperation1618); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5(), null); 
                  
            }
            match(input,19,FOLLOW_19_in_ruleOperation1627); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationAccess().getColonKeyword_6(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:871:1: ( (lv_type_9_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:872:1: (lv_type_9_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:872:1: (lv_type_9_0= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:873:3: lv_type_9_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getTypeTypeRefParserRuleCall_7_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleOperation1648);
            lv_type_9_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_9_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleParameter
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:902:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:902:51: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:903:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1681);
            iv_ruleParameter=ruleParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1691); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:910:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleTypeRef ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:915:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:916:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:916:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:916:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:916:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:917:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:917:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:918:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1733); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getParameterRule().getType().getClassifier());
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


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:940:2: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:941:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:941:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:942:3: lv_type_1_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getParameterAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleParameter1759);
            lv_type_1_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getParameterRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleParameter


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:973:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:973:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:974:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1794);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1804); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:981:1: ruleTypeRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:986:6: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:987:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:987:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:988:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:988:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:989:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getReferencedTypeCrossReference_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRef1851);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1010:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1010:66: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1011:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1884);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1895); if (failed) return current;

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
    // $ANTLR end entryRuleQualifiedNameWithWildCard


    // $ANTLR start ruleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1018:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1023:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1024:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1024:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1025:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1942);
            this_QualifiedName_0=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1035:1: (kw= '.*' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1036:2: kw= '.*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleQualifiedNameWithWildCard1961); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleQualifiedNameWithWildCard


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1049:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1049:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1050:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2002);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2013); if (failed) return current;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1057:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1062:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1063:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1063:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1063:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2053); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1070:1: (kw= '.' this_ID_2= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==27) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1071:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,27,FOLLOW_27_in_ruleQualifiedName2072); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2087); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleQualifiedName


    // $ANTLR start ruleVisibility
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1091:1: ruleVisibility returns [Enumerator current=null] : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1095:6: ( ( ( 'public' ) | ( 'private' ) | ( 'protected' ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1096:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1096:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt15=1;
                }
                break;
            case 29:
                {
                alt15=2;
                }
                break;
            case 30:
                {
                alt15=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1096:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1096:2: ( 'public' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1096:2: ( 'public' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1096:4: 'public'
                    {
                    match(input,28,FOLLOW_28_in_ruleVisibility2146); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1102:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1102:6: ( 'private' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1102:8: 'private'
                    {
                    match(input,29,FOLLOW_29_in_ruleVisibility2161); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1108:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1108:6: ( 'protected' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:1108:8: 'protected'
                    {
                    match(input,30,FOLLOW_30_in_ruleVisibility2176); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleVisibility


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_ruleModel134 = new BitSet(new long[]{0x0000000000019802L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_ruleAbstractElement224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleAbstractElement251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleAbstractElement278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport354 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackageDeclaration452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDeclaration473 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackageDeclaration482 = new BitSet(new long[]{0x000000000001D800L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_rulePackageDeclaration503 = new BitSet(new long[]{0x000000000001D800L});
    public static final BitSet FOLLOW_14_in_rulePackageDeclaration513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleType630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDataType706 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity822 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleEntity837 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEntity860 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity871 = new BitSet(new long[]{0x0000000070544000L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleEntity892 = new BitSet(new long[]{0x0000000070544000L});
    public static final BitSet FOLLOW_14_in_ruleEntity902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_ruleFeature992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleFeature1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeature1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleStructuralFeature1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_ruleStructuralFeature1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1228 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAttribute1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReference1340 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1357 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReference1371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleReference1392 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleReference1402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation1455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibility_in_ruleOperation1511 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOperation1521 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation1538 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOperation1552 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1574 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleOperation1584 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1605 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleOperation1618 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOperation1627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleOperation1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParameter1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRef1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1942 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleQualifiedNameWithWildCard1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2053 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleQualifiedName2072 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2087 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_28_in_ruleVisibility2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVisibility2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVisibility2176 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.builder.tests.parser.antlr.internal; 

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
import org.eclipse.xtext.builder.tests.services.BuilderTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBuilderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'namespace'", "'{'", "'}'", "'import'", "'object'", "'references'", "'otherRefs'", "','", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBuilderTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g"; }



     	private BuilderTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBuilderTestLanguageParser(TokenStream input, IAstFactory factory, BuilderTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "NamedElement";	
       	} 



    // $ANTLR start entryRuleNamedElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:72:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:73:2: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:74:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_entryRuleNamedElement75);
            iv_ruleNamedElement=ruleNamedElement();
            _fsp--;

             current =iv_ruleNamedElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedElement85); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:81:1: ruleNamedElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Element_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:86:6: ( (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:87:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:87:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("87:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:88:5: this_Namespace_0= ruleNamespace
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_ruleNamedElement132);
                    this_Namespace_0=ruleNamespace();
                    _fsp--;

                     
                            current = this_Namespace_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:98:5: this_Element_1= ruleElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleNamedElement159);
                    this_Element_1=ruleElement();
                    _fsp--;

                     
                            current = this_Element_1; 
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


    // $ANTLR start entryRuleNamespace
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:114:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:115:2: (iv_ruleNamespace= ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:116:2: iv_ruleNamespace= ruleNamespace EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_entryRuleNamespace194);
            iv_ruleNamespace=ruleNamespace();
            _fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamespace204); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:123:1: ruleNamespace returns [EObject current=null] : ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_elements_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:128:6: ( ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:129:1: ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:129:1: ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:129:3: 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* '}'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleNamespace239); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:133:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:134:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:134:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:135:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleNamespace260);
            lv_name_1_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleNamespace270); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:161:1: ( (lv_imports_3_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:162:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:162:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:163:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleNamespace291);
            	    lv_imports_3_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_3_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:185:3: ( (lv_elements_4_0= ruleNamedElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:186:1: (lv_elements_4_0= ruleNamedElement )
            	    {
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:186:1: (lv_elements_4_0= ruleNamedElement )
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:187:3: lv_elements_4_0= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_ruleNamespace313);
            	    lv_elements_4_0=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_4_0, 
            	    	        		"NamedElement", 
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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleNamespace324); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5(), null); 
                

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


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:221:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:222:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:223:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport360);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport370); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:230:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:235:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:236:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:236:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:236:3: 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleImport405); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:240:1: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:241:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:241:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:242:3: lv_importedNamespace_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleImport426);
            lv_importedNamespace_1_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importedNamespace",
            	        		lv_importedNamespace_1_0, 
            	        		"QualifiedName", 
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:272:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:273:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:274:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement462);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement472); 

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:281:1: ruleElement returns [EObject current=null] : ( 'object' ( (lv_name_1_0= RULE_ID ) ) ( 'references' ( ( ruleQualifiedName ) ) )? ( 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:286:6: ( ( 'object' ( (lv_name_1_0= RULE_ID ) ) ( 'references' ( ( ruleQualifiedName ) ) )? ( 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:287:1: ( 'object' ( (lv_name_1_0= RULE_ID ) ) ( 'references' ( ( ruleQualifiedName ) ) )? ( 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:287:1: ( 'object' ( (lv_name_1_0= RULE_ID ) ) ( 'references' ( ( ruleQualifiedName ) ) )? ( 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:287:3: 'object' ( (lv_name_1_0= RULE_ID ) ) ( 'references' ( ( ruleQualifiedName ) ) )? ( 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* )?
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleElement507); 

                    createLeafNode(grammarAccess.getElementAccess().getObjectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:291:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:292:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:292:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:293:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement524); 

            			createLeafNode(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:315:2: ( 'references' ( ( ruleQualifiedName ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:315:4: 'references' ( ( ruleQualifiedName ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleElement540); 

                            createLeafNode(grammarAccess.getElementAccess().getReferencesKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:319:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:320:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:320:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:321:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement563);
                    ruleQualifiedName();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:335:4: ( 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:335:6: 'otherRefs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )*
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleElement576); 

                            createLeafNode(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:339:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:340:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:340:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:341:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement599);
                    ruleQualifiedName();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:355:2: ( ',' ( ( ruleQualifiedName ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:355:4: ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    match(input,18,FollowSets000.FOLLOW_18_in_ruleElement610); 

                    	            createLeafNode(grammarAccess.getElementAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:359:1: ( ( ruleQualifiedName ) )
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:360:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:360:1: ( ruleQualifiedName )
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:361:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement633);
                    	    ruleQualifiedName();
                    	    _fsp--;

                    	     
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


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
    // $ANTLR end ruleElement


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:383:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:384:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:385:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName674);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName685); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:392:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:397:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:398:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:398:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:398:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName725); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:405:1: (kw= '.' this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:406:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleQualifiedName744); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName759); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end ruleQualifiedName


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_ruleNamedElement132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleNamedElement159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamespace204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleNamespace239 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace260 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNamespace270 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_ruleImport_in_ruleNamespace291 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_ruleNamedElement_in_ruleNamespace313 = new BitSet(new long[]{0x000000000000A800L});
        public static final BitSet FOLLOW_13_in_ruleNamespace324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleImport405 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleImport426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleElement507 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement524 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleElement540 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement563 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleElement576 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement599 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleElement610 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement633 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName674 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName725 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleQualifiedName744 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName759 = new BitSet(new long[]{0x0000000000080002L});
    }


}
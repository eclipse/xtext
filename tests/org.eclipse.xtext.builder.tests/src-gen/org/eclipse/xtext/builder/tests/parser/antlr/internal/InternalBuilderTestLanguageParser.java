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

@SuppressWarnings("all")
public class InternalBuilderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'namespace'", "'{'", "'}'", "'import'", "'object'", "'references'", "'otherRefs'", "','", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBuilderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBuilderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBuilderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g"; }



     	private BuilderTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBuilderTestLanguageParser(TokenStream input, IAstFactory factory, BuilderTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "NamedElement";	
       	}
       	
       	@Override
       	protected BuilderTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleNamedElement"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:71:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:72:2: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:73:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_entryRuleNamedElement75);
            iv_ruleNamedElement=ruleNamedElement();

            state._fsp--;

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
    // $ANTLR end "entryRuleNamedElement"


    // $ANTLR start "ruleNamedElement"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:80:1: ruleNamedElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Element_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:85:6: ( (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:86:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:86:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:87:5: this_Namespace_0= ruleNamespace
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_ruleNamedElement132);
                    this_Namespace_0=ruleNamespace();

                    state._fsp--;

                     
                            current = this_Namespace_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:97:5: this_Element_1= ruleElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleNamedElement159);
                    this_Element_1=ruleElement();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleNamedElement"


    // $ANTLR start "entryRuleNamespace"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:113:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:114:2: (iv_ruleNamespace= ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:115:2: iv_ruleNamespace= ruleNamespace EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_entryRuleNamespace194);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

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
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:122:1: ruleNamespace returns [EObject current=null] : (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_elements_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:127:6: ( (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:128:1: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:128:1: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:128:3: otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleNamespace241); 

                	createLeafNode(otherlv_0, grammarAccess.getNamespaceAccess().getNamespaceKeyword_0(), null);
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:132:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:133:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:133:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:134:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleNamespace262);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNamespace274); 

                	createLeafNode(otherlv_2, grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2(), null);
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:160:1: ( (lv_imports_3_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:161:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:161:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:162:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleNamespace295);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


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

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:184:3: ( (lv_elements_4_0= ruleNamedElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:185:1: (lv_elements_4_0= ruleNamedElement )
            	    {
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:185:1: (lv_elements_4_0= ruleNamedElement )
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:186:3: lv_elements_4_0= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_ruleNamespace317);
            	    lv_elements_4_0=ruleNamedElement();

            	    state._fsp--;


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

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNamespace330); 

                	createLeafNode(otherlv_5, grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5(), null);
                

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
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:220:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:221:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:222:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport366);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport376); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:229:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:234:6: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:235:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:235:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:235:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleImport413); 

                	createLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0(), null);
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:239:1: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:240:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:240:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:241:3: lv_importedNamespace_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleImport434);
            lv_importedNamespace_1_0=ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:271:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:272:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:273:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement470);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement480); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:280:1: ruleElement returns [EObject current=null] : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:285:6: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:286:1: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:286:1: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:286:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )?
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleElement517); 

                	createLeafNode(otherlv_0, grammarAccess.getElementAccess().getObjectKeyword_0(), null);
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:290:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:291:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:291:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:292:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement534); 

            			createLeafNode(lv_name_1_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:314:2: (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:314:4: otherlv_2= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleElement552); 

                        	createLeafNode(otherlv_2, grammarAccess.getElementAccess().getReferencesKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:318:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:319:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:319:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:320:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement575);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:334:4: (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:334:6: otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleElement590); 

                        	createLeafNode(otherlv_4, grammarAccess.getElementAccess().getOtherRefsKeyword_3_0(), null);
                        
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:338:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:339:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:339:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:340:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement613);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:354:2: (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:354:4: otherlv_6= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleElement626); 

                    	        	createLeafNode(otherlv_6, grammarAccess.getElementAccess().getCommaKeyword_3_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:358:1: ( ( ruleQualifiedName ) )
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:359:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:359:1: ( ruleQualifiedName )
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:360:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement649);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:382:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:383:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:384:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName690);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName701); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:391:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:396:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:397:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:397:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:397:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName741); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:404:1: (kw= '.' this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:405:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQualifiedName760); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName775); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_ruleNamedElement132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleNamedElement159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamespace204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleNamespace241 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace262 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNamespace274 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_ruleImport_in_ruleNamespace295 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_ruleNamedElement_in_ruleNamespace317 = new BitSet(new long[]{0x000000000000A800L});
        public static final BitSet FOLLOW_13_in_ruleNamespace330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleImport413 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleImport434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement470 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleElement517 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement534 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleElement552 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement575 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleElement590 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement613 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleElement626 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement649 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName741 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleQualifiedName760 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName775 = new BitSet(new long[]{0x0000000000080002L});
    }


}
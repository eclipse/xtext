package org.eclipse.xtext.builder.tests.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
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
            this.semanticModelBuilder = factory;
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:70:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:71:2: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:72:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             newCompositeNode(grammarAccess.getNamedElementRule()); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:79:1: ruleNamedElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Element_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:82:28: ( (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:83:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:83:1: (this_Namespace_0= ruleNamespace | this_Element_1= ruleElement )
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
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:84:5: this_Namespace_0= ruleNamespace
                    {
                     
                            newCompositeNode(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_ruleNamedElement132);
                    this_Namespace_0=ruleNamespace();

                    state._fsp--;

                     
                            current = this_Namespace_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:94:5: this_Element_1= ruleElement
                    {
                     
                            newCompositeNode(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleNamedElement159);
                    this_Element_1=ruleElement();

                    state._fsp--;

                     
                            current = this_Element_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:110:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:111:2: (iv_ruleNamespace= ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:112:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:119:1: ruleNamespace returns [EObject current=null] : (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:122:28: ( (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:123:1: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:123:1: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:123:3: otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_elements_4_0= ruleNamedElement ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleNamespace241); 

                	newLeafNode(otherlv_0, grammarAccess.getNamespaceAccess().getNamespaceKeyword_0());
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:127:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:128:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:128:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:129:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleNamespace262);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNamespace274); 

                	newLeafNode(otherlv_2, grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:149:1: ( (lv_imports_3_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:150:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:150:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:151:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleNamespace295);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_3_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:167:3: ( (lv_elements_4_0= ruleNamedElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:168:1: (lv_elements_4_0= ruleNamedElement )
            	    {
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:168:1: (lv_elements_4_0= ruleNamedElement )
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:169:3: lv_elements_4_0= ruleNamedElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_ruleNamespace317);
            	    lv_elements_4_0=ruleNamedElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_4_0, 
            	            		"NamedElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNamespace330); 

                	newLeafNode(otherlv_5, grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:197:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:198:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:199:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:206:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:209:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:210:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:210:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:210:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleImport413); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:214:1: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:215:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:215:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:216:3: lv_importedNamespace_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleImport434);
            lv_importedNamespace_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:240:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:241:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:242:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:249:1: ruleElement returns [EObject current=null] : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:252:28: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:253:1: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:253:1: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:253:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )?
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleElement517); 

                	newLeafNode(otherlv_0, grammarAccess.getElementAccess().getObjectKeyword_0());
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:257:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:258:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:258:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:259:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement534); 

            			newLeafNode(lv_name_1_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:275:2: (otherlv_2= 'references' ( ( ruleQualifiedName ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:275:4: otherlv_2= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleElement552); 

                        	newLeafNode(otherlv_2, grammarAccess.getElementAccess().getReferencesKeyword_2_0());
                        
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:279:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:280:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:280:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:281:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement575);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:294:4: (otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:294:6: otherlv_4= 'otherRefs' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleElement590); 

                        	newLeafNode(otherlv_4, grammarAccess.getElementAccess().getOtherRefsKeyword_3_0());
                        
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:298:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:299:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:299:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:300:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement613);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:313:2: (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:313:4: otherlv_6= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleElement626); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getElementAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:317:1: ( ( ruleQualifiedName ) )
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:318:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:318:1: ( ruleQualifiedName )
                    	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:319:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getElementRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement649);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

             leaveRule(); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:340:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:341:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:342:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:349:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:352:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:353:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:353:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:353:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName741); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:360:1: (kw= '.' this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/parser/antlr/internal/InternalBuilderTestLanguage.g:361:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQualifiedName760); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName775); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
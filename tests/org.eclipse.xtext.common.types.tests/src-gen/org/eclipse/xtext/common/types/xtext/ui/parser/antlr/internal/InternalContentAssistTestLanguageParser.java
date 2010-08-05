package org.eclipse.xtext.common.types.xtext.ui.parser.antlr.internal; 

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
import org.eclipse.xtext.common.types.xtext.ui.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'default'", "'custom'", "'subtype'", "'import'", "'.*'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g"; }



     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, ContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ContentAssistTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_referenceHolder_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:91:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:92:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:92:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:92:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:92:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:93:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:93:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:94:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel131);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_0_0, 
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
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:116:3: ( (lv_referenceHolder_1_0= ruleReferenceHolder ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:117:1: (lv_referenceHolder_1_0= ruleReferenceHolder )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:117:1: (lv_referenceHolder_1_0= ruleReferenceHolder )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:118:3: lv_referenceHolder_1_0= ruleReferenceHolder
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_ruleModel153);
            lv_referenceHolder_1_0=ruleReferenceHolder();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"referenceHolder",
            	        		lv_referenceHolder_1_0, 
            	        		"ReferenceHolder", 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleReferenceHolder
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:148:1: entryRuleReferenceHolder returns [EObject current=null] : iv_ruleReferenceHolder= ruleReferenceHolder EOF ;
    public final EObject entryRuleReferenceHolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceHolder = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:149:2: (iv_ruleReferenceHolder= ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:150:2: iv_ruleReferenceHolder= ruleReferenceHolder EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceHolderRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder189);
            iv_ruleReferenceHolder=ruleReferenceHolder();
            _fsp--;

             current =iv_ruleReferenceHolder; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceHolder199); 

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
    // $ANTLR end entryRuleReferenceHolder


    // $ANTLR start ruleReferenceHolder
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:157:1: ruleReferenceHolder returns [EObject current=null] : ( ( 'default' ( ( ruleFQN ) ) ) | ( 'custom' ( ( ruleFQN ) ) ) | ( 'subtype' ( ( ruleFQN ) ) ) ) ;
    public final EObject ruleReferenceHolder() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:162:6: ( ( ( 'default' ( ( ruleFQN ) ) ) | ( 'custom' ( ( ruleFQN ) ) ) | ( 'subtype' ( ( ruleFQN ) ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:1: ( ( 'default' ( ( ruleFQN ) ) ) | ( 'custom' ( ( ruleFQN ) ) ) | ( 'subtype' ( ( ruleFQN ) ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:1: ( ( 'default' ( ( ruleFQN ) ) ) | ( 'custom' ( ( ruleFQN ) ) ) | ( 'subtype' ( ( ruleFQN ) ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("163:1: ( ( 'default' ( ( ruleFQN ) ) ) | ( 'custom' ( ( ruleFQN ) ) ) | ( 'subtype' ( ( ruleFQN ) ) ) )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:2: ( 'default' ( ( ruleFQN ) ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:2: ( 'default' ( ( ruleFQN ) ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:4: 'default' ( ( ruleFQN ) )
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleReferenceHolder235); 

                            createLeafNode(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:167:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:168:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:168:1: ( ruleFQN )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:169:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceHolderRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder258);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:184:6: ( 'custom' ( ( ruleFQN ) ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:184:6: ( 'custom' ( ( ruleFQN ) ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:184:8: 'custom' ( ( ruleFQN ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleReferenceHolder276); 

                            createLeafNode(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:188:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:189:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:189:1: ( ruleFQN )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:190:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceHolderRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder299);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:205:6: ( 'subtype' ( ( ruleFQN ) ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:205:6: ( 'subtype' ( ( ruleFQN ) ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:205:8: 'subtype' ( ( ruleFQN ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleReferenceHolder317); 

                            createLeafNode(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:209:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:210:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:210:1: ( ruleFQN )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:211:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceHolderRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder340);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleReferenceHolder


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:233:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:234:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:235:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport377);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport387); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:242:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:247:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:248:1: ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:248:1: ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:248:3: 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleImport422); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:252:1: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:254:3: lv_importedNamespace_1_0= ruleImportedFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_ruleImport443);
            lv_importedNamespace_1_0=ruleImportedFQN();
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
            	        		"ImportedFQN", 
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


    // $ANTLR start entryRuleImportedFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:284:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:285:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:286:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportedFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN480);
            iv_ruleImportedFQN=ruleImportedFQN();
            _fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportedFQN491); 

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
    // $ANTLR end entryRuleImportedFQN


    // $ANTLR start ruleImportedFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:293:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:298:6: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:299:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:299:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:300:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleImportedFQN538);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:310:1: (kw= '.*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:311:2: kw= '.*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleImportedFQN557); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1(), null); 
                        

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
    // $ANTLR end ruleImportedFQN


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:324:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:325:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:326:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN600);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN611); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:333:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:338:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:339:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:339:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:339:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN651); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:346:1: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:347:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,16,FollowSets000.FOLLOW_16_in_ruleFQN670); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN685); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end ruleFQN


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_ruleModel153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleReferenceHolder235 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleReferenceHolder276 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleReferenceHolder317 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport377 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleImport422 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN480 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN538 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleImportedFQN557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN651 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleFQN670 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN685 = new BitSet(new long[]{0x0000000000010002L});
    }


}
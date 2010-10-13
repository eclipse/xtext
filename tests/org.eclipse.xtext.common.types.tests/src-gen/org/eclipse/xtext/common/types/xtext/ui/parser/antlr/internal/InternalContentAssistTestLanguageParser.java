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
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g"; }



     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, ContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ContentAssistTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_referenceHolder_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:85:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_referenceHolder_1_0= ruleReferenceHolder ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:87:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:87:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:88:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


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

            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:110:3: ( (lv_referenceHolder_1_0= ruleReferenceHolder ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:111:1: (lv_referenceHolder_1_0= ruleReferenceHolder )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:111:1: (lv_referenceHolder_1_0= ruleReferenceHolder )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:112:3: lv_referenceHolder_1_0= ruleReferenceHolder
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_ruleModel153);
            lv_referenceHolder_1_0=ruleReferenceHolder();

            state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:142:1: entryRuleReferenceHolder returns [EObject current=null] : iv_ruleReferenceHolder= ruleReferenceHolder EOF ;
    public final EObject entryRuleReferenceHolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceHolder = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:143:2: (iv_ruleReferenceHolder= ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:144:2: iv_ruleReferenceHolder= ruleReferenceHolder EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceHolderRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder189);
            iv_ruleReferenceHolder=ruleReferenceHolder();

            state._fsp--;

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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:151:1: ruleReferenceHolder returns [EObject current=null] : ( (otherlv_0= 'default' ( ( ruleFQN ) ) ) | (otherlv_2= 'custom' ( ( ruleFQN ) ) ) | (otherlv_4= 'subtype' ( ( ruleFQN ) ) ) ) ;
    public final EObject ruleReferenceHolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:156:6: ( ( (otherlv_0= 'default' ( ( ruleFQN ) ) ) | (otherlv_2= 'custom' ( ( ruleFQN ) ) ) | (otherlv_4= 'subtype' ( ( ruleFQN ) ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:157:1: ( (otherlv_0= 'default' ( ( ruleFQN ) ) ) | (otherlv_2= 'custom' ( ( ruleFQN ) ) ) | (otherlv_4= 'subtype' ( ( ruleFQN ) ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:157:1: ( (otherlv_0= 'default' ( ( ruleFQN ) ) ) | (otherlv_2= 'custom' ( ( ruleFQN ) ) ) | (otherlv_4= 'subtype' ( ( ruleFQN ) ) ) )
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
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:157:2: (otherlv_0= 'default' ( ( ruleFQN ) ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:157:2: (otherlv_0= 'default' ( ( ruleFQN ) ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:157:4: otherlv_0= 'default' ( ( ruleFQN ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleReferenceHolder237); 

                        	createLeafNode(otherlv_0, grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:161:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:162:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:162:1: ( ruleFQN )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceHolderRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder260);
                    ruleFQN();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:6: (otherlv_2= 'custom' ( ( ruleFQN ) ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:6: (otherlv_2= 'custom' ( ( ruleFQN ) ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:8: otherlv_2= 'custom' ( ( ruleFQN ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReferenceHolder280); 

                        	createLeafNode(otherlv_2, grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:182:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:183:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:183:1: ( ruleFQN )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:184:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceHolderRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder303);
                    ruleFQN();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:199:6: (otherlv_4= 'subtype' ( ( ruleFQN ) ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:199:6: (otherlv_4= 'subtype' ( ( ruleFQN ) ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:199:8: otherlv_4= 'subtype' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleReferenceHolder323); 

                        	createLeafNode(otherlv_4, grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:203:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:204:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:204:1: ( ruleFQN )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:205:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceHolderRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder346);
                    ruleFQN();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:227:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:228:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:229:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport383);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport393); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:236:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:241:6: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:242:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:242:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:242:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleImport430); 

                	createLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0(), null);
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:246:1: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:247:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:247:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:248:3: lv_importedNamespace_1_0= ruleImportedFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_ruleImport451);
            lv_importedNamespace_1_0=ruleImportedFQN();

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:278:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:279:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:280:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportedFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN488);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportedFQN499); 

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
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:287:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:292:6: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:293:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:293:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:294:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleImportedFQN546);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:304:1: (kw= '.*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:305:2: kw= '.*'
                    {
                    kw=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleImportedFQN565); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1(), null); 
                        

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
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:318:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:319:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:320:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN608);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN619); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:327:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:332:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:333:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:333:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:333:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN659); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:340:1: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.g:341:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFQN678); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN693); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_ruleModel153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleReferenceHolder237 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleReferenceHolder280 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleReferenceHolder323 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport383 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleImport430 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN546 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleImportedFQN565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN608 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN659 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleFQN678 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN693 = new BitSet(new long[]{0x0000000000010002L});
    }


}
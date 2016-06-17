package org.eclipse.xtext.linking.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.linking.services.IgnoreCaseNamespacesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIgnoreCaseNamespacesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIgnoreCaseNamespacesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIgnoreCaseNamespacesTestLanguage.g"; }



     	private IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input, IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected IgnoreCaseNamespacesTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalIgnoreCaseNamespacesTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalIgnoreCaseNamespacesTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalIgnoreCaseNamespacesTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalIgnoreCaseNamespacesTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_elements_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIgnoreCaseNamespacesTestLanguage.g:79:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) )
            // InternalIgnoreCaseNamespacesTestLanguage.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            // InternalIgnoreCaseNamespacesTestLanguage.g:80:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:80:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:81:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:81:1: (lv_imports_0_0= ruleImport )
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:82:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguage.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalIgnoreCaseNamespacesTestLanguage.g:98:3: ( (lv_elements_1_0= ruleElement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:99:1: (lv_elements_1_0= ruleElement )
            	    {
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:99:1: (lv_elements_1_0= ruleElement )
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:100:3: lv_elements_1_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_elements_1_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_1_0, 
            	            		"org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // InternalIgnoreCaseNamespacesTestLanguage.g:124:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalIgnoreCaseNamespacesTestLanguage.g:125:2: (iv_ruleImport= ruleImport EOF )
            // InternalIgnoreCaseNamespacesTestLanguage.g:126:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalIgnoreCaseNamespacesTestLanguage.g:133:1: ruleImport returns [EObject current=null] : ( (lv_importedNamespace_0_0= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importedNamespace_0_0=null;

         enterRule(); 
            
        try {
            // InternalIgnoreCaseNamespacesTestLanguage.g:136:28: ( ( (lv_importedNamespace_0_0= RULE_STRING ) ) )
            // InternalIgnoreCaseNamespacesTestLanguage.g:137:1: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:137:1: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            // InternalIgnoreCaseNamespacesTestLanguage.g:138:1: (lv_importedNamespace_0_0= RULE_STRING )
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:138:1: (lv_importedNamespace_0_0= RULE_STRING )
            // InternalIgnoreCaseNamespacesTestLanguage.g:139:3: lv_importedNamespace_0_0= RULE_STRING
            {
            lv_importedNamespace_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_importedNamespace_0_0, grammarAccess.getImportAccess().getImportedNamespaceSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // InternalIgnoreCaseNamespacesTestLanguage.g:163:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalIgnoreCaseNamespacesTestLanguage.g:164:2: (iv_ruleElement= ruleElement EOF )
            // InternalIgnoreCaseNamespacesTestLanguage.g:165:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalIgnoreCaseNamespacesTestLanguage.g:172:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIgnoreCaseNamespacesTestLanguage.g:175:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) )
            // InternalIgnoreCaseNamespacesTestLanguage.g:176:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:176:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            // InternalIgnoreCaseNamespacesTestLanguage.g:176:2: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}'
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:176:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalIgnoreCaseNamespacesTestLanguage.g:177:1: (lv_name_0_0= RULE_ID )
            {
            // InternalIgnoreCaseNamespacesTestLanguage.g:177:1: (lv_name_0_0= RULE_ID )
            // InternalIgnoreCaseNamespacesTestLanguage.g:178:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_name_0_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalIgnoreCaseNamespacesTestLanguage.g:194:2: ( (otherlv_1= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalIgnoreCaseNamespacesTestLanguage.g:195:1: (otherlv_1= RULE_ID )
                    {
                    // InternalIgnoreCaseNamespacesTestLanguage.g:195:1: (otherlv_1= RULE_ID )
                    // InternalIgnoreCaseNamespacesTestLanguage.g:196:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    		newLeafNode(otherlv_1, grammarAccess.getElementAccess().getReferenceElementCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_2, grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalIgnoreCaseNamespacesTestLanguage.g:211:1: ( (lv_elements_3_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:212:1: (lv_elements_3_0= ruleElement )
            	    {
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:212:1: (lv_elements_3_0= ruleElement )
            	    // InternalIgnoreCaseNamespacesTestLanguage.g:213:3: lv_elements_3_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getElementsElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_3_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_3_0, 
            	            		"org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4());
                

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001020L});
    }


}
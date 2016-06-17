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
import org.eclipse.xtext.linking.services.AbstractIgnoreCaseLinkingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAbstractIgnoreCaseLinkingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalAbstractIgnoreCaseLinkingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAbstractIgnoreCaseLinkingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAbstractIgnoreCaseLinkingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAbstractIgnoreCaseLinkingTestLanguage.g"; }



     	private AbstractIgnoreCaseLinkingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAbstractIgnoreCaseLinkingTestLanguageParser(TokenStream input, AbstractIgnoreCaseLinkingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected AbstractIgnoreCaseLinkingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )+ ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:79:28: ( ( (lv_elements_0_0= ruleElement ) )+ )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:80:1: ( (lv_elements_0_0= ruleElement ) )+
            {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:80:1: ( (lv_elements_0_0= ruleElement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:81:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:81:1: (lv_elements_0_0= ruleElement )
            	    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:82:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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


    // $ANTLR start "entryRuleElement"
    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:106:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:107:2: (iv_ruleElement= ruleElement EOF )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:108:2: iv_ruleElement= ruleElement EOF
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
    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:115:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:118:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:119:2: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}'
            {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:119:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:120:1: (lv_name_0_0= RULE_ID )
            {
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:120:1: (lv_name_0_0= RULE_ID )
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:121:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

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

            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:137:2: ( (otherlv_1= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:138:1: (otherlv_1= RULE_ID )
                    {
                    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:138:1: (otherlv_1= RULE_ID )
                    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:139:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    		newLeafNode(otherlv_1, grammarAccess.getElementAccess().getReferenceElementCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalAbstractIgnoreCaseLinkingTestLanguage.g:154:1: ( (lv_elements_3_0= ruleElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:155:1: (lv_elements_3_0= ruleElement )
            	    {
            	    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:155:1: (lv_elements_3_0= ruleElement )
            	    // InternalAbstractIgnoreCaseLinkingTestLanguage.g:156:3: lv_elements_3_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getElementsElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
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
            	    break loop3;
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001010L});
    }


}
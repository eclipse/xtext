package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCrossReferenceProposalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<-'", "'{'", "'}'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCrossReferenceProposalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCrossReferenceProposalTestLanguage.g"; }



     	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;
     	
        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected CrossReferenceProposalTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalCrossReferenceProposalTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCrossReferenceProposalTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalCrossReferenceProposalTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalCrossReferenceProposalTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleClass ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalCrossReferenceProposalTestLanguage.g:79:28: ( ( (lv_elements_0_0= ruleClass ) )* )
            // InternalCrossReferenceProposalTestLanguage.g:80:1: ( (lv_elements_0_0= ruleClass ) )*
            {
            // InternalCrossReferenceProposalTestLanguage.g:80:1: ( (lv_elements_0_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCrossReferenceProposalTestLanguage.g:81:1: (lv_elements_0_0= ruleClass )
            	    {
            	    // InternalCrossReferenceProposalTestLanguage.g:81:1: (lv_elements_0_0= ruleClass )
            	    // InternalCrossReferenceProposalTestLanguage.g:82:3: lv_elements_0_0= ruleClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.CrossReferenceProposalTestLanguage.Class");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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


    // $ANTLR start "entryRuleClass"
    // InternalCrossReferenceProposalTestLanguage.g:106:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalCrossReferenceProposalTestLanguage.g:107:2: (iv_ruleClass= ruleClass EOF )
            // InternalCrossReferenceProposalTestLanguage.g:108:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalCrossReferenceProposalTestLanguage.g:115:1: ruleClass returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalCrossReferenceProposalTestLanguage.g:118:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= '}' ) )
            // InternalCrossReferenceProposalTestLanguage.g:119:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= '}' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:119:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= '}' )
            // InternalCrossReferenceProposalTestLanguage.g:119:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= '}'
            {
            // InternalCrossReferenceProposalTestLanguage.g:119:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==11) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:119:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-'
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:119:3: ( (otherlv_0= RULE_ID ) )
                    // InternalCrossReferenceProposalTestLanguage.g:120:1: (otherlv_0= RULE_ID )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:120:1: (otherlv_0= RULE_ID )
                    // InternalCrossReferenceProposalTestLanguage.g:121:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

                    		newLeafNode(otherlv_0, grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalCrossReferenceProposalTestLanguage.g:136:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:137:1: (lv_name_2_0= RULE_ID )
            {
            // InternalCrossReferenceProposalTestLanguage.g:137:1: (lv_name_2_0= RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:138:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			newLeafNode(lv_name_2_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_3, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleClass"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    }


}
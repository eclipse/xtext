package org.eclipse.xtext.parsetree.impl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.impl.services.Bug305397GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug305397Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'a'", "'element'", "'end'"
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
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug305397Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug305397Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug305397Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug305397.g"; }



     	private Bug305397GrammarAccess grammarAccess;
     	
        public InternalBug305397Parser(TokenStream input, Bug305397GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug305397GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug305397.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug305397.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug305397.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug305397.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug305397.g:79:28: ( ( (lv_elements_0_0= ruleElement ) )* )
            // InternalBug305397.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // InternalBug305397.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug305397.g:81:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalBug305397.g:81:1: (lv_elements_0_0= ruleElement )
            	    // InternalBug305397.g:82:3: lv_elements_0_0= ruleElement
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
            	            		"org.eclipse.xtext.parsetree.impl.Bug305397.Element");
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


    // $ANTLR start "entryRuleElement"
    // InternalBug305397.g:106:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalBug305397.g:107:2: (iv_ruleElement= ruleElement EOF )
            // InternalBug305397.g:108:2: iv_ruleElement= ruleElement EOF
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
    // InternalBug305397.g:115:1: ruleElement returns [EObject current=null] : ( () ( (lv_a_1_0= 'a' ) )? otherlv_2= 'element' ( (lv_name_3_0= RULE_ID ) )? ( (lv_elements_4_0= ruleElement ) )* otherlv_5= 'end' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_a_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBug305397.g:118:28: ( ( () ( (lv_a_1_0= 'a' ) )? otherlv_2= 'element' ( (lv_name_3_0= RULE_ID ) )? ( (lv_elements_4_0= ruleElement ) )* otherlv_5= 'end' ) )
            // InternalBug305397.g:119:1: ( () ( (lv_a_1_0= 'a' ) )? otherlv_2= 'element' ( (lv_name_3_0= RULE_ID ) )? ( (lv_elements_4_0= ruleElement ) )* otherlv_5= 'end' )
            {
            // InternalBug305397.g:119:1: ( () ( (lv_a_1_0= 'a' ) )? otherlv_2= 'element' ( (lv_name_3_0= RULE_ID ) )? ( (lv_elements_4_0= ruleElement ) )* otherlv_5= 'end' )
            // InternalBug305397.g:119:2: () ( (lv_a_1_0= 'a' ) )? otherlv_2= 'element' ( (lv_name_3_0= RULE_ID ) )? ( (lv_elements_4_0= ruleElement ) )* otherlv_5= 'end'
            {
            // InternalBug305397.g:119:2: ()
            // InternalBug305397.g:120:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            // InternalBug305397.g:125:2: ( (lv_a_1_0= 'a' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug305397.g:126:1: (lv_a_1_0= 'a' )
                    {
                    // InternalBug305397.g:126:1: (lv_a_1_0= 'a' )
                    // InternalBug305397.g:127:3: lv_a_1_0= 'a'
                    {
                    lv_a_1_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                            newLeafNode(lv_a_1_0, grammarAccess.getElementAccess().getAAKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(current, "a", true, "a");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getElementAccess().getElementKeyword_2());
                
            // InternalBug305397.g:144:1: ( (lv_name_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug305397.g:145:1: (lv_name_3_0= RULE_ID )
                    {
                    // InternalBug305397.g:145:1: (lv_name_3_0= RULE_ID )
                    // InternalBug305397.g:146:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            // InternalBug305397.g:162:3: ( (lv_elements_4_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=11 && LA4_0<=12)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug305397.g:163:1: (lv_elements_4_0= ruleElement )
            	    {
            	    // InternalBug305397.g:163:1: (lv_elements_4_0= ruleElement )
            	    // InternalBug305397.g:164:3: lv_elements_4_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getElementsElementParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_elements_4_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_4_0, 
            	            		"org.eclipse.xtext.parsetree.impl.Bug305397.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getElementAccess().getEndKeyword_5());
                

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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003810L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000003800L});
    }


}
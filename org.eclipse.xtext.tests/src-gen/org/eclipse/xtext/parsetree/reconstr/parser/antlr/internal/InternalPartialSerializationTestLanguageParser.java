package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.reconstr.services.PartialSerializationTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPartialSerializationTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'node'", "'('", "')'"
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
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalPartialSerializationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPartialSerializationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPartialSerializationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPartialSerializationTestLanguage.g"; }



     	private PartialSerializationTestLanguageGrammarAccess grammarAccess;
     	
        public InternalPartialSerializationTestLanguageParser(TokenStream input, PartialSerializationTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected PartialSerializationTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalPartialSerializationTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPartialSerializationTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalPartialSerializationTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalPartialSerializationTestLanguage.g:76:1: ruleModel returns [EObject current=null] : this_NodeRoot_0= ruleNodeRoot ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_NodeRoot_0 = null;


         enterRule(); 
            
        try {
            // InternalPartialSerializationTestLanguage.g:79:28: (this_NodeRoot_0= ruleNodeRoot )
            // InternalPartialSerializationTestLanguage.g:81:5: this_NodeRoot_0= ruleNodeRoot
            {
             
                    newCompositeNode(grammarAccess.getModelAccess().getNodeRootParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_NodeRoot_0=ruleNodeRoot();

            state._fsp--;

             
                    current = this_NodeRoot_0; 
                    afterParserOrEnumRuleCall();
                

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


    // $ANTLR start "entryRuleNodeRoot"
    // InternalPartialSerializationTestLanguage.g:97:1: entryRuleNodeRoot returns [EObject current=null] : iv_ruleNodeRoot= ruleNodeRoot EOF ;
    public final EObject entryRuleNodeRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRoot = null;


        try {
            // InternalPartialSerializationTestLanguage.g:98:2: (iv_ruleNodeRoot= ruleNodeRoot EOF )
            // InternalPartialSerializationTestLanguage.g:99:2: iv_ruleNodeRoot= ruleNodeRoot EOF
            {
             newCompositeNode(grammarAccess.getNodeRootRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeRoot=ruleNodeRoot();

            state._fsp--;

             current =iv_ruleNodeRoot; 
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
    // $ANTLR end "entryRuleNodeRoot"


    // $ANTLR start "ruleNodeRoot"
    // InternalPartialSerializationTestLanguage.g:106:1: ruleNodeRoot returns [EObject current=null] : (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) ;
    public final EObject ruleNodeRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_node_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPartialSerializationTestLanguage.g:109:28: ( (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) )
            // InternalPartialSerializationTestLanguage.g:110:1: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            {
            // InternalPartialSerializationTestLanguage.g:110:1: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            // InternalPartialSerializationTestLanguage.g:110:3: otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeRootAccess().getNumberSignDigitOneKeyword_0());
                
            // InternalPartialSerializationTestLanguage.g:114:1: ( (lv_node_1_0= ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:115:1: (lv_node_1_0= ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:115:1: (lv_node_1_0= ruleNode )
            // InternalPartialSerializationTestLanguage.g:116:3: lv_node_1_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getNodeRootAccess().getNodeNodeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_node_1_0=ruleNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeRootRule());
            	        }
                   		set(
                   			current, 
                   			"node",
                    		lv_node_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.PartialSerializationTestLanguage.Node");
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
    // $ANTLR end "ruleNodeRoot"


    // $ANTLR start "entryRuleNode"
    // InternalPartialSerializationTestLanguage.g:140:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalPartialSerializationTestLanguage.g:141:2: (iv_ruleNode= ruleNode EOF )
            // InternalPartialSerializationTestLanguage.g:142:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalPartialSerializationTestLanguage.g:149:1: ruleNode returns [EObject current=null] : (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_children_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPartialSerializationTestLanguage.g:152:28: ( (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) )
            // InternalPartialSerializationTestLanguage.g:153:1: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            {
            // InternalPartialSerializationTestLanguage.g:153:1: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            // InternalPartialSerializationTestLanguage.g:153:3: otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
                
            // InternalPartialSerializationTestLanguage.g:157:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:158:1: (lv_name_1_0= RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:158:1: (lv_name_1_0= RULE_ID )
            // InternalPartialSerializationTestLanguage.g:159:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalPartialSerializationTestLanguage.g:175:2: (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:175:4: otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalPartialSerializationTestLanguage.g:179:1: ( (lv_children_3_0= ruleNode ) )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalPartialSerializationTestLanguage.g:180:1: (lv_children_3_0= ruleNode )
                    	    {
                    	    // InternalPartialSerializationTestLanguage.g:180:1: (lv_children_3_0= ruleNode )
                    	    // InternalPartialSerializationTestLanguage.g:181:3: lv_children_3_0= ruleNode
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_children_3_0=ruleNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"children",
                    	            		lv_children_3_0, 
                    	            		"org.eclipse.xtext.parsetree.reconstr.PartialSerializationTestLanguage.Node");
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

                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_2());
                        

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
    // $ANTLR end "ruleNode"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000005000L});
    }


}
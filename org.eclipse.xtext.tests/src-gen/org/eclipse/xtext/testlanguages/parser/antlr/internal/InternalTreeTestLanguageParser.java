package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTreeTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'{'", "'};'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalTreeTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTreeTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTreeTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTreeTestLanguage.g"; }



     	private TreeTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTreeTestLanguageParser(TokenStream input, TreeTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected TreeTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalTreeTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTreeTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalTreeTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalTreeTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_children_0_0= ruleNode ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTreeTestLanguage.g:79:28: ( ( (lv_children_0_0= ruleNode ) )* )
            // InternalTreeTestLanguage.g:80:1: ( (lv_children_0_0= ruleNode ) )*
            {
            // InternalTreeTestLanguage.g:80:1: ( (lv_children_0_0= ruleNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTreeTestLanguage.g:81:1: (lv_children_0_0= ruleNode )
            	    {
            	    // InternalTreeTestLanguage.g:81:1: (lv_children_0_0= ruleNode )
            	    // InternalTreeTestLanguage.g:82:3: lv_children_0_0= ruleNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getChildrenNodeParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_children_0_0=ruleNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"children",
            	            		lv_children_0_0, 
            	            		"org.eclipse.xtext.testlanguages.TreeTestLanguage.Node");
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


    // $ANTLR start "entryRuleNode"
    // InternalTreeTestLanguage.g:106:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalTreeTestLanguage.g:107:2: (iv_ruleNode= ruleNode EOF )
            // InternalTreeTestLanguage.g:108:2: iv_ruleNode= ruleNode EOF
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
    // InternalTreeTestLanguage.g:115:1: ruleNode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_attrib_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_children_5_0 = null;


         enterRule(); 
            
        try {
            // InternalTreeTestLanguage.g:118:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' ) )
            // InternalTreeTestLanguage.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' )
            {
            // InternalTreeTestLanguage.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' )
            // InternalTreeTestLanguage.g:119:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};'
            {
            // InternalTreeTestLanguage.g:119:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalTreeTestLanguage.g:120:1: (lv_name_0_0= RULE_ID )
            {
            // InternalTreeTestLanguage.g:120:1: (lv_name_0_0= RULE_ID )
            // InternalTreeTestLanguage.g:121:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            			newLeafNode(lv_name_0_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_1());
                
            // InternalTreeTestLanguage.g:141:1: ( (lv_attrib_2_0= RULE_STRING ) )
            // InternalTreeTestLanguage.g:142:1: (lv_attrib_2_0= RULE_STRING )
            {
            // InternalTreeTestLanguage.g:142:1: (lv_attrib_2_0= RULE_STRING )
            // InternalTreeTestLanguage.g:143:3: lv_attrib_2_0= RULE_STRING
            {
            lv_attrib_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_6); 

            			newLeafNode(lv_attrib_2_0, grammarAccess.getNodeAccess().getAttribSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attrib",
                    		lv_attrib_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_3, grammarAccess.getNodeAccess().getRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalTreeTestLanguage.g:167:1: ( (lv_children_5_0= ruleNode ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTreeTestLanguage.g:168:1: (lv_children_5_0= ruleNode )
            	    {
            	    // InternalTreeTestLanguage.g:168:1: (lv_children_5_0= ruleNode )
            	    // InternalTreeTestLanguage.g:169:3: lv_children_5_0= ruleNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_children_5_0=ruleNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"children",
            	            		lv_children_5_0, 
            	            		"org.eclipse.xtext.testlanguages.TreeTestLanguage.Node");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getRightCurlyBracketSemicolonKeyword_6());
                

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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    }


}
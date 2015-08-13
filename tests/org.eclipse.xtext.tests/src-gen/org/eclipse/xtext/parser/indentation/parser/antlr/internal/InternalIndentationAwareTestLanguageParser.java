package org.eclipse.xtext.parser.indentation.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.indentation.services.IndentationAwareTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIndentationAwareTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_COMMENT", "RULE_INDENT", "RULE_DEDENT", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=7;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=8;
    public static final int RULE_INDENT=5;
    public static final int RULE_DEDENT=6;
    public static final int RULE_WS=11;
    public static final int RULE_SL_COMMENT=4;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=10;

    // delegates
    // delegators


        public InternalIndentationAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIndentationAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIndentationAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g"; }




    	private IndentationAwareTestLanguageGrammarAccess grammarAccess;
    	 	
    	public InternalIndentationAwareTestLanguageParser(TokenStream input, IndentationAwareTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Tree";	
    	} 
    	   	   	
    	@Override
    	protected IndentationAwareTestLanguageGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleTree"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:61:1: entryRuleTree returns [EObject current=null] : iv_ruleTree= ruleTree EOF ;
    public final EObject entryRuleTree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTree = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:62:2: (iv_ruleTree= ruleTree EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:63:2: iv_ruleTree= ruleTree EOF
            {
             newCompositeNode(grammarAccess.getTreeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTree_in_entryRuleTree67);
            iv_ruleTree=ruleTree();

            state._fsp--;

             current =iv_ruleTree; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTree77); 

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
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:70:1: ruleTree returns [EObject current=null] : ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ) ;
    public final EObject ruleTree() throws RecognitionException {
        EObject current = null;

        EObject lv_nodes_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:73:28: ( ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:74:1: ( () ( (lv_nodes_1_0= ruleTreeNode ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:74:1: ( () ( (lv_nodes_1_0= ruleTreeNode ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:74:2: () ( (lv_nodes_1_0= ruleTreeNode ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:74:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:75:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTreeAccess().getTreeAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:80:2: ( (lv_nodes_1_0= ruleTreeNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:81:1: (lv_nodes_1_0= ruleTreeNode )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:81:1: (lv_nodes_1_0= ruleTreeNode )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:82:3: lv_nodes_1_0= ruleTreeNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTreeNode_in_ruleTree132);
            	    lv_nodes_1_0=ruleTreeNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTreeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodes",
            	            		lv_nodes_1_0, 
            	            		"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.TreeNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleTree"


    // $ANTLR start "entryRuleTreeNode"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:106:1: entryRuleTreeNode returns [EObject current=null] : iv_ruleTreeNode= ruleTreeNode EOF ;
    public final EObject entryRuleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTreeNode = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:107:2: (iv_ruleTreeNode= ruleTreeNode EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:108:2: iv_ruleTreeNode= ruleTreeNode EOF
            {
             newCompositeNode(grammarAccess.getTreeNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTreeNode_in_entryRuleTreeNode168);
            iv_ruleTreeNode=ruleTreeNode();

            state._fsp--;

             current =iv_ruleTreeNode; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTreeNode178); 

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
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:115:1: ruleTreeNode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? ) ;
    public final EObject ruleTreeNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_INDENT_1=null;
        Token this_DEDENT_3=null;
        EObject lv_children_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:118:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:119:2: ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:119:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:120:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:120:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:121:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTreeNode220); 

            			newLeafNode(lv_name_0_0, grammarAccess.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTreeNodeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:137:2: (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INDENT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:137:3: this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT
                    {
                    this_INDENT_1=(Token)match(input,RULE_INDENT,FollowSets000.FOLLOW_RULE_INDENT_in_ruleTreeNode237); 
                     
                        newLeafNode(this_INDENT_1, grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0()); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:141:1: ( (lv_children_2_0= ruleTreeNode ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:142:1: (lv_children_2_0= ruleTreeNode )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:142:1: (lv_children_2_0= ruleTreeNode )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/indentation/parser/antlr/internal/InternalIndentationAwareTestLanguageParser.g:143:3: lv_children_2_0= ruleTreeNode
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTreeNode_in_ruleTreeNode257);
                    	    lv_children_2_0=ruleTreeNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTreeNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"children",
                    	            		lv_children_2_0, 
                    	            		"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.TreeNode");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    this_DEDENT_3=(Token)match(input,RULE_DEDENT,FollowSets000.FOLLOW_RULE_DEDENT_in_ruleTreeNode269); 
                     
                        newLeafNode(this_DEDENT_3, grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2()); 
                        

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
    // $ANTLR end "ruleTreeNode"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleTree_in_entryRuleTree67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTree77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTreeNode_in_ruleTree132 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleTreeNode_in_entryRuleTreeNode168 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTreeNode178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTreeNode220 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_INDENT_in_ruleTreeNode237 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTreeNode_in_ruleTreeNode257 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_DEDENT_in_ruleTreeNode269 = new BitSet(new long[]{0x0000000000000002L});
    }


}
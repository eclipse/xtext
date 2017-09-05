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
    public static final int RULE_DEDENT=6;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=4;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_INDENT=5;

    // delegates
    // delegators


        public InternalIndentationAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIndentationAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIndentationAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIndentationAwareTestLanguageParser.g"; }



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
    // InternalIndentationAwareTestLanguageParser.g:57:1: entryRuleTree returns [EObject current=null] : iv_ruleTree= ruleTree EOF ;
    public final EObject entryRuleTree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTree = null;


        try {
            // InternalIndentationAwareTestLanguageParser.g:57:45: (iv_ruleTree= ruleTree EOF )
            // InternalIndentationAwareTestLanguageParser.g:58:2: iv_ruleTree= ruleTree EOF
            {
             newCompositeNode(grammarAccess.getTreeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTree=ruleTree();

            state._fsp--;

             current =iv_ruleTree; 
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
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // InternalIndentationAwareTestLanguageParser.g:64:1: ruleTree returns [EObject current=null] : ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ( (lv_moreNodes_2_0= ruleOtherTreeNode ) )* ) ;
    public final EObject ruleTree() throws RecognitionException {
        EObject current = null;

        EObject lv_nodes_1_0 = null;

        EObject lv_moreNodes_2_0 = null;



        	enterRule();

        try {
            // InternalIndentationAwareTestLanguageParser.g:70:2: ( ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ( (lv_moreNodes_2_0= ruleOtherTreeNode ) )* ) )
            // InternalIndentationAwareTestLanguageParser.g:71:2: ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ( (lv_moreNodes_2_0= ruleOtherTreeNode ) )* )
            {
            // InternalIndentationAwareTestLanguageParser.g:71:2: ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ( (lv_moreNodes_2_0= ruleOtherTreeNode ) )* )
            // InternalIndentationAwareTestLanguageParser.g:72:3: () ( (lv_nodes_1_0= ruleTreeNode ) )* ( (lv_moreNodes_2_0= ruleOtherTreeNode ) )*
            {
            // InternalIndentationAwareTestLanguageParser.g:72:3: ()
            // InternalIndentationAwareTestLanguageParser.g:73:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTreeAccess().getTreeAction_0(),
            					current);
            			

            }

            // InternalIndentationAwareTestLanguageParser.g:79:3: ( (lv_nodes_1_0= ruleTreeNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguageParser.g:80:4: (lv_nodes_1_0= ruleTreeNode )
            	    {
            	    // InternalIndentationAwareTestLanguageParser.g:80:4: (lv_nodes_1_0= ruleTreeNode )
            	    // InternalIndentationAwareTestLanguageParser.g:81:5: lv_nodes_1_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
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

            // InternalIndentationAwareTestLanguageParser.g:98:3: ( (lv_moreNodes_2_0= ruleOtherTreeNode ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_STRING) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguageParser.g:99:4: (lv_moreNodes_2_0= ruleOtherTreeNode )
            	    {
            	    // InternalIndentationAwareTestLanguageParser.g:99:4: (lv_moreNodes_2_0= ruleOtherTreeNode )
            	    // InternalIndentationAwareTestLanguageParser.g:100:5: lv_moreNodes_2_0= ruleOtherTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getTreeAccess().getMoreNodesOtherTreeNodeParserRuleCall_2_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_moreNodes_2_0=ruleOtherTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTreeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"moreNodes",
            	    						lv_moreNodes_2_0,
            	    						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.OtherTreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // InternalIndentationAwareTestLanguageParser.g:121:1: entryRuleTreeNode returns [EObject current=null] : iv_ruleTreeNode= ruleTreeNode EOF ;
    public final EObject entryRuleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTreeNode = null;


        try {
            // InternalIndentationAwareTestLanguageParser.g:121:49: (iv_ruleTreeNode= ruleTreeNode EOF )
            // InternalIndentationAwareTestLanguageParser.g:122:2: iv_ruleTreeNode= ruleTreeNode EOF
            {
             newCompositeNode(grammarAccess.getTreeNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTreeNode=ruleTreeNode();

            state._fsp--;

             current =iv_ruleTreeNode; 
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
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // InternalIndentationAwareTestLanguageParser.g:128:1: ruleTreeNode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? ) ;
    public final EObject ruleTreeNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_INDENT_1=null;
        Token this_DEDENT_3=null;
        EObject lv_children_2_0 = null;



        	enterRule();

        try {
            // InternalIndentationAwareTestLanguageParser.g:134:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? ) )
            // InternalIndentationAwareTestLanguageParser.g:135:2: ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? )
            {
            // InternalIndentationAwareTestLanguageParser.g:135:2: ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? )
            // InternalIndentationAwareTestLanguageParser.g:136:3: ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )?
            {
            // InternalIndentationAwareTestLanguageParser.g:136:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalIndentationAwareTestLanguageParser.g:137:4: (lv_name_0_0= RULE_ID )
            {
            // InternalIndentationAwareTestLanguageParser.g:137:4: (lv_name_0_0= RULE_ID )
            // InternalIndentationAwareTestLanguageParser.g:138:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

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

            // InternalIndentationAwareTestLanguageParser.g:154:3: (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INDENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalIndentationAwareTestLanguageParser.g:155:4: this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT
                    {
                    this_INDENT_1=(Token)match(input,RULE_INDENT,FollowSets000.FOLLOW_6); 

                    				newLeafNode(this_INDENT_1, grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0());
                    			
                    // InternalIndentationAwareTestLanguageParser.g:159:4: ( (lv_children_2_0= ruleTreeNode ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalIndentationAwareTestLanguageParser.g:160:5: (lv_children_2_0= ruleTreeNode )
                    	    {
                    	    // InternalIndentationAwareTestLanguageParser.g:160:5: (lv_children_2_0= ruleTreeNode )
                    	    // InternalIndentationAwareTestLanguageParser.g:161:6: lv_children_2_0= ruleTreeNode
                    	    {

                    	    						newCompositeNode(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
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
                    	    break loop3;
                        }
                    } while (true);

                    this_DEDENT_3=(Token)match(input,RULE_DEDENT,FollowSets000.FOLLOW_2); 

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


    // $ANTLR start "entryRuleOtherTreeNode"
    // InternalIndentationAwareTestLanguageParser.g:187:1: entryRuleOtherTreeNode returns [EObject current=null] : iv_ruleOtherTreeNode= ruleOtherTreeNode EOF ;
    public final EObject entryRuleOtherTreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherTreeNode = null;


        try {
            // InternalIndentationAwareTestLanguageParser.g:187:54: (iv_ruleOtherTreeNode= ruleOtherTreeNode EOF )
            // InternalIndentationAwareTestLanguageParser.g:188:2: iv_ruleOtherTreeNode= ruleOtherTreeNode EOF
            {
             newCompositeNode(grammarAccess.getOtherTreeNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOtherTreeNode=ruleOtherTreeNode();

            state._fsp--;

             current =iv_ruleOtherTreeNode; 
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
    // $ANTLR end "entryRuleOtherTreeNode"


    // $ANTLR start "ruleOtherTreeNode"
    // InternalIndentationAwareTestLanguageParser.g:194:1: ruleOtherTreeNode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) ( (lv_childList_1_0= ruleChildList ) )? ) ;
    public final EObject ruleOtherTreeNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_childList_1_0 = null;



        	enterRule();

        try {
            // InternalIndentationAwareTestLanguageParser.g:200:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) ( (lv_childList_1_0= ruleChildList ) )? ) )
            // InternalIndentationAwareTestLanguageParser.g:201:2: ( ( (lv_name_0_0= RULE_STRING ) ) ( (lv_childList_1_0= ruleChildList ) )? )
            {
            // InternalIndentationAwareTestLanguageParser.g:201:2: ( ( (lv_name_0_0= RULE_STRING ) ) ( (lv_childList_1_0= ruleChildList ) )? )
            // InternalIndentationAwareTestLanguageParser.g:202:3: ( (lv_name_0_0= RULE_STRING ) ) ( (lv_childList_1_0= ruleChildList ) )?
            {
            // InternalIndentationAwareTestLanguageParser.g:202:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalIndentationAwareTestLanguageParser.g:203:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalIndentationAwareTestLanguageParser.g:203:4: (lv_name_0_0= RULE_STRING )
            // InternalIndentationAwareTestLanguageParser.g:204:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOtherTreeNodeAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOtherTreeNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalIndentationAwareTestLanguageParser.g:220:3: ( (lv_childList_1_0= ruleChildList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalIndentationAwareTestLanguageParser.g:221:4: (lv_childList_1_0= ruleChildList )
                    {
                    // InternalIndentationAwareTestLanguageParser.g:221:4: (lv_childList_1_0= ruleChildList )
                    // InternalIndentationAwareTestLanguageParser.g:222:5: lv_childList_1_0= ruleChildList
                    {

                    					newCompositeNode(grammarAccess.getOtherTreeNodeAccess().getChildListChildListParserRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_childList_1_0=ruleChildList();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOtherTreeNodeRule());
                    					}
                    					set(
                    						current,
                    						"childList",
                    						lv_childList_1_0,
                    						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.ChildList");
                    					afterParserOrEnumRuleCall();
                    				

                    }


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
    // $ANTLR end "ruleOtherTreeNode"


    // $ANTLR start "entryRuleChildList"
    // InternalIndentationAwareTestLanguageParser.g:243:1: entryRuleChildList returns [EObject current=null] : iv_ruleChildList= ruleChildList EOF ;
    public final EObject entryRuleChildList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildList = null;


        try {
            // InternalIndentationAwareTestLanguageParser.g:243:50: (iv_ruleChildList= ruleChildList EOF )
            // InternalIndentationAwareTestLanguageParser.g:244:2: iv_ruleChildList= ruleChildList EOF
            {
             newCompositeNode(grammarAccess.getChildListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChildList=ruleChildList();

            state._fsp--;

             current =iv_ruleChildList; 
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
    // $ANTLR end "entryRuleChildList"


    // $ANTLR start "ruleChildList"
    // InternalIndentationAwareTestLanguageParser.g:250:1: ruleChildList returns [EObject current=null] : ( () this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleOtherTreeNode ) )+ this_DEDENT_3= RULE_DEDENT ) ;
    public final EObject ruleChildList() throws RecognitionException {
        EObject current = null;

        Token this_INDENT_1=null;
        Token this_DEDENT_3=null;
        EObject lv_children_2_0 = null;



        	enterRule();

        try {
            // InternalIndentationAwareTestLanguageParser.g:256:2: ( ( () this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleOtherTreeNode ) )+ this_DEDENT_3= RULE_DEDENT ) )
            // InternalIndentationAwareTestLanguageParser.g:257:2: ( () this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleOtherTreeNode ) )+ this_DEDENT_3= RULE_DEDENT )
            {
            // InternalIndentationAwareTestLanguageParser.g:257:2: ( () this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleOtherTreeNode ) )+ this_DEDENT_3= RULE_DEDENT )
            // InternalIndentationAwareTestLanguageParser.g:258:3: () this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleOtherTreeNode ) )+ this_DEDENT_3= RULE_DEDENT
            {
            // InternalIndentationAwareTestLanguageParser.g:258:3: ()
            // InternalIndentationAwareTestLanguageParser.g:259:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getChildListAccess().getChildListAction_0(),
            					current);
            			

            }

            this_INDENT_1=(Token)match(input,RULE_INDENT,FollowSets000.FOLLOW_7); 

            			newLeafNode(this_INDENT_1, grammarAccess.getChildListAccess().getINDENTTerminalRuleCall_1());
            		
            // InternalIndentationAwareTestLanguageParser.g:269:3: ( (lv_children_2_0= ruleOtherTreeNode ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_STRING) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguageParser.g:270:4: (lv_children_2_0= ruleOtherTreeNode )
            	    {
            	    // InternalIndentationAwareTestLanguageParser.g:270:4: (lv_children_2_0= ruleOtherTreeNode )
            	    // InternalIndentationAwareTestLanguageParser.g:271:5: lv_children_2_0= ruleOtherTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getChildListAccess().getChildrenOtherTreeNodeParserRuleCall_2_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_children_2_0=ruleOtherTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getChildListRule());
            	    					}
            	    					add(
            	    						current,
            	    						"children",
            	    						lv_children_2_0,
            	    						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.OtherTreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            this_DEDENT_3=(Token)match(input,RULE_DEDENT,FollowSets000.FOLLOW_2); 

            			newLeafNode(this_DEDENT_3, grammarAccess.getChildListAccess().getDEDENTTerminalRuleCall_3());
            		

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
    // $ANTLR end "ruleChildList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000282L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000202L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000002C0L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000240L});
    }


}
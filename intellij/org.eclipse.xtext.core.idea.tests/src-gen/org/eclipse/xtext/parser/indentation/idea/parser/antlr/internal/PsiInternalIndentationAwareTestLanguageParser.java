package org.eclipse.xtext.parser.indentation.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.indentation.services.IndentationAwareTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalIndentationAwareTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INDENT", "RULE_DEDENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=8;
    public static final int RULE_INDENT=5;
    public static final int RULE_DEDENT=6;
    public static final int RULE_WS=11;
    public static final int RULE_SL_COMMENT=7;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=10;

    // delegates
    // delegators


        public PsiInternalIndentationAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalIndentationAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalIndentationAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalIndentationAwareTestLanguage.g"; }



    	protected IndentationAwareTestLanguageGrammarAccess grammarAccess;

    	protected IndentationAwareTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalIndentationAwareTestLanguageParser(PsiBuilder builder, TokenStream input, IndentationAwareTestLanguageElementTypeProvider elementTypeProvider, IndentationAwareTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Tree";
    	}




    // $ANTLR start "entryRuleTree"
    // PsiInternalIndentationAwareTestLanguage.g:52:1: entryRuleTree : ruleTree EOF ;
    public final void entryRuleTree() throws RecognitionException {
        try {
            // PsiInternalIndentationAwareTestLanguage.g:52:14: ( ruleTree EOF )
            // PsiInternalIndentationAwareTestLanguage.g:53:2: ruleTree EOF
            {
             markComposite(elementTypeProvider.getTreeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTree();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // PsiInternalIndentationAwareTestLanguage.g:58:1: ruleTree : ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ) ;
    public final void ruleTree() throws RecognitionException {
        try {
            // PsiInternalIndentationAwareTestLanguage.g:58:9: ( ( () ( (lv_nodes_1_0= ruleTreeNode ) )* ) )
            // PsiInternalIndentationAwareTestLanguage.g:59:2: ( () ( (lv_nodes_1_0= ruleTreeNode ) )* )
            {
            // PsiInternalIndentationAwareTestLanguage.g:59:2: ( () ( (lv_nodes_1_0= ruleTreeNode ) )* )
            // PsiInternalIndentationAwareTestLanguage.g:60:3: () ( (lv_nodes_1_0= ruleTreeNode ) )*
            {
            // PsiInternalIndentationAwareTestLanguage.g:60:3: ()
            // PsiInternalIndentationAwareTestLanguage.g:61:4: 
            {

            				precedeComposite(elementTypeProvider.getTree_TreeAction_0ElementType());
            				doneComposite();
            			

            }

            // PsiInternalIndentationAwareTestLanguage.g:66:3: ( (lv_nodes_1_0= ruleTreeNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalIndentationAwareTestLanguage.g:67:4: (lv_nodes_1_0= ruleTreeNode )
            	    {
            	    // PsiInternalIndentationAwareTestLanguage.g:67:4: (lv_nodes_1_0= ruleTreeNode )
            	    // PsiInternalIndentationAwareTestLanguage.g:68:5: lv_nodes_1_0= ruleTreeNode
            	    {

            	    					markComposite(elementTypeProvider.getTree_NodesTreeNodeParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleTreeNode();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleTree"


    // $ANTLR start "entryRuleTreeNode"
    // PsiInternalIndentationAwareTestLanguage.g:81:1: entryRuleTreeNode : ruleTreeNode EOF ;
    public final void entryRuleTreeNode() throws RecognitionException {
        try {
            // PsiInternalIndentationAwareTestLanguage.g:81:18: ( ruleTreeNode EOF )
            // PsiInternalIndentationAwareTestLanguage.g:82:2: ruleTreeNode EOF
            {
             markComposite(elementTypeProvider.getTreeNodeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTreeNode();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // PsiInternalIndentationAwareTestLanguage.g:87:1: ruleTreeNode : ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? ) ;
    public final void ruleTreeNode() throws RecognitionException {
        Token lv_name_0_0=null;
        Token this_INDENT_1=null;
        Token this_DEDENT_3=null;

        try {
            // PsiInternalIndentationAwareTestLanguage.g:87:13: ( ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? ) )
            // PsiInternalIndentationAwareTestLanguage.g:88:2: ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? )
            {
            // PsiInternalIndentationAwareTestLanguage.g:88:2: ( ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )? )
            // PsiInternalIndentationAwareTestLanguage.g:89:3: ( (lv_name_0_0= RULE_ID ) ) (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )?
            {
            // PsiInternalIndentationAwareTestLanguage.g:89:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalIndentationAwareTestLanguage.g:90:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalIndentationAwareTestLanguage.g:90:4: (lv_name_0_0= RULE_ID )
            // PsiInternalIndentationAwareTestLanguage.g:91:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTreeNode_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalIndentationAwareTestLanguage.g:100:3: (this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INDENT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalIndentationAwareTestLanguage.g:101:4: this_INDENT_1= RULE_INDENT ( (lv_children_2_0= ruleTreeNode ) )* this_DEDENT_3= RULE_DEDENT
                    {

                    				markLeaf(elementTypeProvider.getTreeNode_INDENTTerminalRuleCall_1_0ElementType());
                    			
                    this_INDENT_1=(Token)match(input,RULE_INDENT,FollowSets000.FOLLOW_5); 

                    				doneLeaf(this_INDENT_1);
                    			
                    // PsiInternalIndentationAwareTestLanguage.g:108:4: ( (lv_children_2_0= ruleTreeNode ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalIndentationAwareTestLanguage.g:109:5: (lv_children_2_0= ruleTreeNode )
                    	    {
                    	    // PsiInternalIndentationAwareTestLanguage.g:109:5: (lv_children_2_0= ruleTreeNode )
                    	    // PsiInternalIndentationAwareTestLanguage.g:110:6: lv_children_2_0= ruleTreeNode
                    	    {

                    	    						markComposite(elementTypeProvider.getTreeNode_ChildrenTreeNodeParserRuleCall_1_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    ruleTreeNode();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    				markLeaf(elementTypeProvider.getTreeNode_DEDENTTerminalRuleCall_1_2ElementType());
                    			
                    this_DEDENT_3=(Token)match(input,RULE_DEDENT,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_DEDENT_3);
                    			

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleTreeNode"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000050L});
    }


}
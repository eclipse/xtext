package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.PartialSerializationTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalPartialSerializationTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'node'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalPartialSerializationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalPartialSerializationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalPartialSerializationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalPartialSerializationTestLanguage.g"; }



    	protected PartialSerializationTestLanguageGrammarAccess grammarAccess;

    	protected PartialSerializationTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalPartialSerializationTestLanguageParser(PsiBuilder builder, TokenStream input, PartialSerializationTestLanguageElementTypeProvider elementTypeProvider, PartialSerializationTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalPartialSerializationTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalPartialSerializationTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalPartialSerializationTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalPartialSerializationTestLanguage.g:58:1: ruleModel : ruleNodeRoot ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalPartialSerializationTestLanguage.g:58:10: ( ruleNodeRoot )
            // PsiInternalPartialSerializationTestLanguage.g:59:2: ruleNodeRoot
            {

            		markComposite(elementTypeProvider.getModel_NodeRootParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNodeRoot();

            state._fsp--;


            		doneComposite();
            	

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleNodeRoot"
    // PsiInternalPartialSerializationTestLanguage.g:69:1: entryRuleNodeRoot : ruleNodeRoot EOF ;
    public final void entryRuleNodeRoot() throws RecognitionException {
        try {
            // PsiInternalPartialSerializationTestLanguage.g:69:18: ( ruleNodeRoot EOF )
            // PsiInternalPartialSerializationTestLanguage.g:70:2: ruleNodeRoot EOF
            {
             markComposite(elementTypeProvider.getNodeRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNodeRoot();

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
    // $ANTLR end "entryRuleNodeRoot"


    // $ANTLR start "ruleNodeRoot"
    // PsiInternalPartialSerializationTestLanguage.g:75:1: ruleNodeRoot : (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) ;
    public final void ruleNodeRoot() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalPartialSerializationTestLanguage.g:75:13: ( (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) )
            // PsiInternalPartialSerializationTestLanguage.g:76:2: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            {
            // PsiInternalPartialSerializationTestLanguage.g:76:2: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            // PsiInternalPartialSerializationTestLanguage.g:77:3: otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) )
            {

            			markLeaf(elementTypeProvider.getNodeRoot_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalPartialSerializationTestLanguage.g:84:3: ( (lv_node_1_0= ruleNode ) )
            // PsiInternalPartialSerializationTestLanguage.g:85:4: (lv_node_1_0= ruleNode )
            {
            // PsiInternalPartialSerializationTestLanguage.g:85:4: (lv_node_1_0= ruleNode )
            // PsiInternalPartialSerializationTestLanguage.g:86:5: lv_node_1_0= ruleNode
            {

            					markComposite(elementTypeProvider.getNodeRoot_NodeNodeParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNode();

            state._fsp--;


            					doneComposite();
            				

            }


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
    // $ANTLR end "ruleNodeRoot"


    // $ANTLR start "entryRuleNode"
    // PsiInternalPartialSerializationTestLanguage.g:99:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // PsiInternalPartialSerializationTestLanguage.g:99:14: ( ruleNode EOF )
            // PsiInternalPartialSerializationTestLanguage.g:100:2: ruleNode EOF
            {
             markComposite(elementTypeProvider.getNodeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNode();

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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // PsiInternalPartialSerializationTestLanguage.g:105:1: ruleNode : (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) ;
    public final void ruleNode() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalPartialSerializationTestLanguage.g:105:9: ( (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) )
            // PsiInternalPartialSerializationTestLanguage.g:106:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            {
            // PsiInternalPartialSerializationTestLanguage.g:106:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            // PsiInternalPartialSerializationTestLanguage.g:107:3: otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            {

            			markLeaf(elementTypeProvider.getNode_NodeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalPartialSerializationTestLanguage.g:114:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalPartialSerializationTestLanguage.g:115:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalPartialSerializationTestLanguage.g:115:4: (lv_name_1_0= RULE_ID )
            // PsiInternalPartialSerializationTestLanguage.g:116:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNode_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalPartialSerializationTestLanguage.g:125:3: (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalPartialSerializationTestLanguage.g:126:4: otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')'
                    {

                    				markLeaf(elementTypeProvider.getNode_LeftParenthesisKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalPartialSerializationTestLanguage.g:133:4: ( (lv_children_3_0= ruleNode ) )+
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
                    	    // PsiInternalPartialSerializationTestLanguage.g:134:5: (lv_children_3_0= ruleNode )
                    	    {
                    	    // PsiInternalPartialSerializationTestLanguage.g:134:5: (lv_children_3_0= ruleNode )
                    	    // PsiInternalPartialSerializationTestLanguage.g:135:6: lv_children_3_0= ruleNode
                    	    {

                    	    						markComposite(elementTypeProvider.getNode_ChildrenNodeParserRuleCall_2_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    ruleNode();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    					

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


                    				markLeaf(elementTypeProvider.getNode_RightParenthesisKeyword_2_2ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(otherlv_4);
                    			

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
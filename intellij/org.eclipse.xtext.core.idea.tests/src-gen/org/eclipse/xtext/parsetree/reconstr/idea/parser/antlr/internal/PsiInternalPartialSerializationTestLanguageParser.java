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
    // PsiInternalPartialSerializationTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalPartialSerializationTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalPartialSerializationTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalPartialSerializationTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : this_NodeRoot_0= ruleNodeRoot ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_NodeRoot_0 = null;


        try {
            // PsiInternalPartialSerializationTestLanguage.g:60:1: (this_NodeRoot_0= ruleNodeRoot )
            // PsiInternalPartialSerializationTestLanguage.g:61:2: this_NodeRoot_0= ruleNodeRoot
            {

            		markComposite(elementTypeProvider.getModel_NodeRootParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            this_NodeRoot_0=ruleNodeRoot();

            state._fsp--;


            		current = this_NodeRoot_0;
            		doneComposite();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleNodeRoot"
    // PsiInternalPartialSerializationTestLanguage.g:72:1: entryRuleNodeRoot returns [Boolean current=false] : iv_ruleNodeRoot= ruleNodeRoot EOF ;
    public final Boolean entryRuleNodeRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNodeRoot = null;


        try {
            // PsiInternalPartialSerializationTestLanguage.g:72:50: (iv_ruleNodeRoot= ruleNodeRoot EOF )
            // PsiInternalPartialSerializationTestLanguage.g:73:2: iv_ruleNodeRoot= ruleNodeRoot EOF
            {
             markComposite(elementTypeProvider.getNodeRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeRoot=ruleNodeRoot();

            state._fsp--;

             current =iv_ruleNodeRoot; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeRoot"


    // $ANTLR start "ruleNodeRoot"
    // PsiInternalPartialSerializationTestLanguage.g:79:1: ruleNodeRoot returns [Boolean current=false] : (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) ;
    public final Boolean ruleNodeRoot() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_node_1_0 = null;


        try {
            // PsiInternalPartialSerializationTestLanguage.g:80:1: ( (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) )
            // PsiInternalPartialSerializationTestLanguage.g:81:2: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            {
            // PsiInternalPartialSerializationTestLanguage.g:81:2: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            // PsiInternalPartialSerializationTestLanguage.g:82:3: otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) )
            {

            			markLeaf(elementTypeProvider.getNodeRoot_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalPartialSerializationTestLanguage.g:89:3: ( (lv_node_1_0= ruleNode ) )
            // PsiInternalPartialSerializationTestLanguage.g:90:4: (lv_node_1_0= ruleNode )
            {
            // PsiInternalPartialSerializationTestLanguage.g:90:4: (lv_node_1_0= ruleNode )
            // PsiInternalPartialSerializationTestLanguage.g:91:5: lv_node_1_0= ruleNode
            {

            					markComposite(elementTypeProvider.getNodeRoot_NodeNodeParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_node_1_0=ruleNode();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleNodeRoot"


    // $ANTLR start "entryRuleNode"
    // PsiInternalPartialSerializationTestLanguage.g:108:1: entryRuleNode returns [Boolean current=false] : iv_ruleNode= ruleNode EOF ;
    public final Boolean entryRuleNode() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNode = null;


        try {
            // PsiInternalPartialSerializationTestLanguage.g:108:46: (iv_ruleNode= ruleNode EOF )
            // PsiInternalPartialSerializationTestLanguage.g:109:2: iv_ruleNode= ruleNode EOF
            {
             markComposite(elementTypeProvider.getNodeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // PsiInternalPartialSerializationTestLanguage.g:115:1: ruleNode returns [Boolean current=false] : (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) ;
    public final Boolean ruleNode() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_children_3_0 = null;


        try {
            // PsiInternalPartialSerializationTestLanguage.g:116:1: ( (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) )
            // PsiInternalPartialSerializationTestLanguage.g:117:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            {
            // PsiInternalPartialSerializationTestLanguage.g:117:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            // PsiInternalPartialSerializationTestLanguage.g:118:3: otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            {

            			markLeaf(elementTypeProvider.getNode_NodeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalPartialSerializationTestLanguage.g:125:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalPartialSerializationTestLanguage.g:126:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalPartialSerializationTestLanguage.g:126:4: (lv_name_1_0= RULE_ID )
            // PsiInternalPartialSerializationTestLanguage.g:127:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNode_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalPartialSerializationTestLanguage.g:142:3: (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalPartialSerializationTestLanguage.g:143:4: otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')'
                    {

                    				markLeaf(elementTypeProvider.getNode_LeftParenthesisKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalPartialSerializationTestLanguage.g:150:4: ( (lv_children_3_0= ruleNode ) )+
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
                    	    // PsiInternalPartialSerializationTestLanguage.g:151:5: (lv_children_3_0= ruleNode )
                    	    {
                    	    // PsiInternalPartialSerializationTestLanguage.g:151:5: (lv_children_3_0= ruleNode )
                    	    // PsiInternalPartialSerializationTestLanguage.g:152:6: lv_children_3_0= ruleNode
                    	    {

                    	    						markComposite(elementTypeProvider.getNode_ChildrenNodeParserRuleCall_2_1_0ElementType());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_children_3_0=ruleNode();

                    	    state._fsp--;


                    	    						doneComposite();
                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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
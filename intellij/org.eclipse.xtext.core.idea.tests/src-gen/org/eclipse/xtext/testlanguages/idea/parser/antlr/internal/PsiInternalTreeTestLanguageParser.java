package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalTreeTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'{'", "'};'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalTreeTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalTreeTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalTreeTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalTreeTestLanguage.g"; }



    	protected TreeTestLanguageGrammarAccess grammarAccess;

    	protected TreeTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalTreeTestLanguageParser(PsiBuilder builder, TokenStream input, TreeTestLanguageElementTypeProvider elementTypeProvider, TreeTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalTreeTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalTreeTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalTreeTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalTreeTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_children_0_0= ruleNode ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_children_0_0 = null;


        try {
            // PsiInternalTreeTestLanguage.g:60:1: ( ( (lv_children_0_0= ruleNode ) )* )
            // PsiInternalTreeTestLanguage.g:61:2: ( (lv_children_0_0= ruleNode ) )*
            {
            // PsiInternalTreeTestLanguage.g:61:2: ( (lv_children_0_0= ruleNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalTreeTestLanguage.g:62:3: (lv_children_0_0= ruleNode )
            	    {
            	    // PsiInternalTreeTestLanguage.g:62:3: (lv_children_0_0= ruleNode )
            	    // PsiInternalTreeTestLanguage.g:63:4: lv_children_0_0= ruleNode
            	    {

            	    				markComposite(elementTypeProvider.getModel_ChildrenNodeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_children_0_0=ruleNode();

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
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start "entryRuleNode"
    // PsiInternalTreeTestLanguage.g:79:1: entryRuleNode returns [Boolean current=false] : iv_ruleNode= ruleNode EOF ;
    public final Boolean entryRuleNode() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNode = null;


        try {
            // PsiInternalTreeTestLanguage.g:79:46: (iv_ruleNode= ruleNode EOF )
            // PsiInternalTreeTestLanguage.g:80:2: iv_ruleNode= ruleNode EOF
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
    // PsiInternalTreeTestLanguage.g:86:1: ruleNode returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' ) ;
    public final Boolean ruleNode() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_attrib_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_children_5_0 = null;


        try {
            // PsiInternalTreeTestLanguage.g:87:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' ) )
            // PsiInternalTreeTestLanguage.g:88:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' )
            {
            // PsiInternalTreeTestLanguage.g:88:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};' )
            // PsiInternalTreeTestLanguage.g:89:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_attrib_2_0= RULE_STRING ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_children_5_0= ruleNode ) )* otherlv_6= '};'
            {
            // PsiInternalTreeTestLanguage.g:89:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalTreeTestLanguage.g:90:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalTreeTestLanguage.g:90:4: (lv_name_0_0= RULE_ID )
            // PsiInternalTreeTestLanguage.g:91:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNode_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getNode_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalTreeTestLanguage.g:113:3: ( (lv_attrib_2_0= RULE_STRING ) )
            // PsiInternalTreeTestLanguage.g:114:4: (lv_attrib_2_0= RULE_STRING )
            {
            // PsiInternalTreeTestLanguage.g:114:4: (lv_attrib_2_0= RULE_STRING )
            // PsiInternalTreeTestLanguage.g:115:5: lv_attrib_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getNode_AttribSTRINGTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_attrib_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_6); 

            					doneLeaf(lv_attrib_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getNode_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_3);
            		

            			markLeaf(elementTypeProvider.getNode_LeftCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalTreeTestLanguage.g:144:3: ( (lv_children_5_0= ruleNode ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalTreeTestLanguage.g:145:4: (lv_children_5_0= ruleNode )
            	    {
            	    // PsiInternalTreeTestLanguage.g:145:4: (lv_children_5_0= ruleNode )
            	    // PsiInternalTreeTestLanguage.g:146:5: lv_children_5_0= ruleNode
            	    {

            	    					markComposite(elementTypeProvider.getNode_ChildrenNodeParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_children_5_0=ruleNode();

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
            	    break loop2;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getNode_RightCurlyBracketSemicolonKeyword_6ElementType());
            		
            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    }


}
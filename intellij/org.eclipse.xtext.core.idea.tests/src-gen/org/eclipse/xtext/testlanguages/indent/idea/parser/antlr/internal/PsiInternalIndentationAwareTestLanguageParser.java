package org.eclipse.xtext.testlanguages.indent.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.indent.services.IndentationAwareTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalIndentationAwareTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_BEGIN", "RULE_END", "RULE_OTHER"
    };
    public static final int RULE_OTHER=7;
    public static final int RULE_END=6;
    public static final int RULE_BEGIN=5;
    public static final int RULE_NL=4;
    public static final int EOF=-1;

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
    		return "NodeList";
    	}




    // $ANTLR start "entryRuleNodeList"
    // PsiInternalIndentationAwareTestLanguage.g:52:1: entryRuleNodeList returns [Boolean current=false] : iv_ruleNodeList= ruleNodeList EOF ;
    public final Boolean entryRuleNodeList() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNodeList = null;


        try {
            // PsiInternalIndentationAwareTestLanguage.g:52:50: (iv_ruleNodeList= ruleNodeList EOF )
            // PsiInternalIndentationAwareTestLanguage.g:53:2: iv_ruleNodeList= ruleNodeList EOF
            {
             markComposite(elementTypeProvider.getNodeListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeList=ruleNodeList();

            state._fsp--;

             current =iv_ruleNodeList; 
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
    // $ANTLR end "entryRuleNodeList"


    // $ANTLR start "ruleNodeList"
    // PsiInternalIndentationAwareTestLanguage.g:59:1: ruleNodeList returns [Boolean current=false] : ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* ) ;
    public final Boolean ruleNodeList() throws RecognitionException {
        Boolean current = false;

        Token this_NL_1=null;
        Boolean lv_children_0_0 = null;

        Boolean lv_children_2_0 = null;


        try {
            // PsiInternalIndentationAwareTestLanguage.g:60:1: ( ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* ) )
            // PsiInternalIndentationAwareTestLanguage.g:61:2: ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* )
            {
            // PsiInternalIndentationAwareTestLanguage.g:61:2: ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* )
            // PsiInternalIndentationAwareTestLanguage.g:62:3: ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )*
            {
            // PsiInternalIndentationAwareTestLanguage.g:62:3: ( (lv_children_0_0= ruleNode ) )
            // PsiInternalIndentationAwareTestLanguage.g:63:4: (lv_children_0_0= ruleNode )
            {
            // PsiInternalIndentationAwareTestLanguage.g:63:4: (lv_children_0_0= ruleNode )
            // PsiInternalIndentationAwareTestLanguage.g:64:5: lv_children_0_0= ruleNode
            {

            					markComposite(elementTypeProvider.getNodeList_ChildrenNodeParserRuleCall_0_0ElementType());
            				
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

            // PsiInternalIndentationAwareTestLanguage.g:77:3: (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalIndentationAwareTestLanguage.g:78:4: this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) )
            	    {

            	    				markLeaf(elementTypeProvider.getNodeList_NLTerminalRuleCall_1_0ElementType());
            	    			
            	    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(this_NL_1);
            	    			
            	    // PsiInternalIndentationAwareTestLanguage.g:85:4: ( (lv_children_2_0= ruleNode ) )
            	    // PsiInternalIndentationAwareTestLanguage.g:86:5: (lv_children_2_0= ruleNode )
            	    {
            	    // PsiInternalIndentationAwareTestLanguage.g:86:5: (lv_children_2_0= ruleNode )
            	    // PsiInternalIndentationAwareTestLanguage.g:87:6: lv_children_2_0= ruleNode
            	    {

            	    						markComposite(elementTypeProvider.getNodeList_ChildrenNodeParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_children_2_0=ruleNode();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeList"


    // $ANTLR start "entryRuleNode"
    // PsiInternalIndentationAwareTestLanguage.g:105:1: entryRuleNode returns [Boolean current=false] : iv_ruleNode= ruleNode EOF ;
    public final Boolean entryRuleNode() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNode = null;


        try {
            // PsiInternalIndentationAwareTestLanguage.g:105:46: (iv_ruleNode= ruleNode EOF )
            // PsiInternalIndentationAwareTestLanguage.g:106:2: iv_ruleNode= ruleNode EOF
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
    // PsiInternalIndentationAwareTestLanguage.g:112:1: ruleNode returns [Boolean current=false] : ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? ) ;
    public final Boolean ruleNode() throws RecognitionException {
        Boolean current = false;

        Token this_NL_1=null;
        Token this_BEGIN_2=null;
        Token this_END_4=null;
        Boolean lv_name_0_0 = null;

        Boolean lv_children_3_0 = null;


        try {
            // PsiInternalIndentationAwareTestLanguage.g:113:1: ( ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? ) )
            // PsiInternalIndentationAwareTestLanguage.g:114:2: ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? )
            {
            // PsiInternalIndentationAwareTestLanguage.g:114:2: ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? )
            // PsiInternalIndentationAwareTestLanguage.g:115:3: ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )?
            {
            // PsiInternalIndentationAwareTestLanguage.g:115:3: ( (lv_name_0_0= ruleString ) )
            // PsiInternalIndentationAwareTestLanguage.g:116:4: (lv_name_0_0= ruleString )
            {
            // PsiInternalIndentationAwareTestLanguage.g:116:4: (lv_name_0_0= ruleString )
            // PsiInternalIndentationAwareTestLanguage.g:117:5: lv_name_0_0= ruleString
            {

            					markComposite(elementTypeProvider.getNode_NameStringParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            lv_name_0_0=ruleString();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalIndentationAwareTestLanguage.g:130:3: (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_NL) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_BEGIN) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalIndentationAwareTestLanguage.g:131:4: this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END
                    {

                    				markLeaf(elementTypeProvider.getNode_NLTerminalRuleCall_1_0ElementType());
                    			
                    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_5); 

                    				doneLeaf(this_NL_1);
                    			

                    				markLeaf(elementTypeProvider.getNode_BEGINTerminalRuleCall_1_1ElementType());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FollowSets000.FOLLOW_4); 

                    				doneLeaf(this_BEGIN_2);
                    			
                    // PsiInternalIndentationAwareTestLanguage.g:145:4: ( (lv_children_3_0= ruleNodeList ) )
                    // PsiInternalIndentationAwareTestLanguage.g:146:5: (lv_children_3_0= ruleNodeList )
                    {
                    // PsiInternalIndentationAwareTestLanguage.g:146:5: (lv_children_3_0= ruleNodeList )
                    // PsiInternalIndentationAwareTestLanguage.g:147:6: lv_children_3_0= ruleNodeList
                    {

                    						markComposite(elementTypeProvider.getNode_ChildrenNodeListParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_children_3_0=ruleNodeList();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getNode_ENDTerminalRuleCall_1_3ElementType());
                    			
                    this_END_4=(Token)match(input,RULE_END,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_END_4);
                    			

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


    // $ANTLR start "entryRuleString"
    // PsiInternalIndentationAwareTestLanguage.g:172:1: entryRuleString returns [Boolean current=false] : iv_ruleString= ruleString EOF ;
    public final Boolean entryRuleString() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleString = null;


        try {
            // PsiInternalIndentationAwareTestLanguage.g:172:48: (iv_ruleString= ruleString EOF )
            // PsiInternalIndentationAwareTestLanguage.g:173:2: iv_ruleString= ruleString EOF
            {
             markComposite(elementTypeProvider.getStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleString=ruleString();

            state._fsp--;

             current =iv_ruleString; 
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
    // $ANTLR end "entryRuleString"


    // $ANTLR start "ruleString"
    // PsiInternalIndentationAwareTestLanguage.g:179:1: ruleString returns [Boolean current=false] : (this_OTHER_0= RULE_OTHER )+ ;
    public final Boolean ruleString() throws RecognitionException {
        Boolean current = false;

        Token this_OTHER_0=null;

        try {
            // PsiInternalIndentationAwareTestLanguage.g:180:1: ( (this_OTHER_0= RULE_OTHER )+ )
            // PsiInternalIndentationAwareTestLanguage.g:181:2: (this_OTHER_0= RULE_OTHER )+
            {
            // PsiInternalIndentationAwareTestLanguage.g:181:2: (this_OTHER_0= RULE_OTHER )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_OTHER) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalIndentationAwareTestLanguage.g:182:3: this_OTHER_0= RULE_OTHER
            	    {

            	    			markLeaf(elementTypeProvider.getString_OTHERTerminalRuleCallElementType());
            	    		
            	    this_OTHER_0=(Token)match(input,RULE_OTHER,FollowSets000.FOLLOW_7); 

            	    			doneLeaf(this_OTHER_0);
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
    // $ANTLR end "ruleString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000082L});
    }


}
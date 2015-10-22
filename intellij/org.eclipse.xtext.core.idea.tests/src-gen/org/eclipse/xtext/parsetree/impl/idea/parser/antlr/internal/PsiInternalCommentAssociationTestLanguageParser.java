package org.eclipse.xtext.parsetree.impl.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.impl.services.CommentAssociationTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalCommentAssociationTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'parent'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalCommentAssociationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalCommentAssociationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalCommentAssociationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalCommentAssociationTestLanguage.g"; }



    	protected CommentAssociationTestLanguageGrammarAccess grammarAccess;

    	protected CommentAssociationTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalCommentAssociationTestLanguageParser(PsiBuilder builder, TokenStream input, CommentAssociationTestLanguageElementTypeProvider elementTypeProvider, CommentAssociationTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalCommentAssociationTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalCommentAssociationTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalCommentAssociationTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalCommentAssociationTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;


        try {
            // PsiInternalCommentAssociationTestLanguage.g:60:1: ( ( (lv_elements_0_0= ruleElement ) )* )
            // PsiInternalCommentAssociationTestLanguage.g:61:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // PsiInternalCommentAssociationTestLanguage.g:61:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalCommentAssociationTestLanguage.g:62:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalCommentAssociationTestLanguage.g:62:3: (lv_elements_0_0= ruleElement )
            	    // PsiInternalCommentAssociationTestLanguage.g:63:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

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


    // $ANTLR start "entryRuleElement"
    // PsiInternalCommentAssociationTestLanguage.g:79:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalCommentAssociationTestLanguage.g:79:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalCommentAssociationTestLanguage.g:80:2: iv_ruleElement= ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalCommentAssociationTestLanguage.g:86:1: ruleElement returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

        try {
            // PsiInternalCommentAssociationTestLanguage.g:87:1: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? ) )
            // PsiInternalCommentAssociationTestLanguage.g:88:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? )
            {
            // PsiInternalCommentAssociationTestLanguage.g:88:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? )
            // PsiInternalCommentAssociationTestLanguage.g:89:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalCommentAssociationTestLanguage.g:96:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalCommentAssociationTestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalCommentAssociationTestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            // PsiInternalCommentAssociationTestLanguage.g:98:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalCommentAssociationTestLanguage.g:113:3: ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalCommentAssociationTestLanguage.g:114:4: () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) )
                    {
                    // PsiInternalCommentAssociationTestLanguage.g:114:4: ()
                    // PsiInternalCommentAssociationTestLanguage.g:115:5: 
                    {

                    					precedeComposite(elementTypeProvider.getElement_ElementChildAction_2_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }


                    				markLeaf(elementTypeProvider.getElement_ParentKeyword_2_1ElementType());
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalCommentAssociationTestLanguage.g:128:4: ( (lv_name_4_0= RULE_ID ) )
                    // PsiInternalCommentAssociationTestLanguage.g:129:5: (lv_name_4_0= RULE_ID )
                    {
                    // PsiInternalCommentAssociationTestLanguage.g:129:5: (lv_name_4_0= RULE_ID )
                    // PsiInternalCommentAssociationTestLanguage.g:130:6: lv_name_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_2_2_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_name_4_0);
                    					

                    }


                    }


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
    // $ANTLR end "ruleElement"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    }


}
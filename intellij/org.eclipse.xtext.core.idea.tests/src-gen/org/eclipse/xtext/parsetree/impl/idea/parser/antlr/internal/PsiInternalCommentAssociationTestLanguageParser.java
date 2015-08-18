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
    // PsiInternalCommentAssociationTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalCommentAssociationTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalCommentAssociationTestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalCommentAssociationTestLanguage.g:58:1: ruleModel : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalCommentAssociationTestLanguage.g:58:10: ( ( (lv_elements_0_0= ruleElement ) )* )
            // PsiInternalCommentAssociationTestLanguage.g:59:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // PsiInternalCommentAssociationTestLanguage.g:59:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalCommentAssociationTestLanguage.g:60:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalCommentAssociationTestLanguage.g:60:3: (lv_elements_0_0= ruleElement )
            	    // PsiInternalCommentAssociationTestLanguage.g:61:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleElement();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // PsiInternalCommentAssociationTestLanguage.g:73:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalCommentAssociationTestLanguage.g:73:17: ( ruleElement EOF )
            // PsiInternalCommentAssociationTestLanguage.g:74:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalCommentAssociationTestLanguage.g:79:1: ruleElement : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

        try {
            // PsiInternalCommentAssociationTestLanguage.g:79:12: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? ) )
            // PsiInternalCommentAssociationTestLanguage.g:80:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? )
            {
            // PsiInternalCommentAssociationTestLanguage.g:80:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? )
            // PsiInternalCommentAssociationTestLanguage.g:81:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalCommentAssociationTestLanguage.g:88:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalCommentAssociationTestLanguage.g:89:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalCommentAssociationTestLanguage.g:89:4: (lv_name_1_0= RULE_ID )
            // PsiInternalCommentAssociationTestLanguage.g:90:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalCommentAssociationTestLanguage.g:99:3: ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalCommentAssociationTestLanguage.g:100:4: () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) )
                    {
                    // PsiInternalCommentAssociationTestLanguage.g:100:4: ()
                    // PsiInternalCommentAssociationTestLanguage.g:101:5: 
                    {

                    					precedeComposite(elementTypeProvider.getElement_ElementChildAction_2_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getElement_ParentKeyword_2_1ElementType());
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalCommentAssociationTestLanguage.g:113:4: ( (lv_name_4_0= RULE_ID ) )
                    // PsiInternalCommentAssociationTestLanguage.g:114:5: (lv_name_4_0= RULE_ID )
                    {
                    // PsiInternalCommentAssociationTestLanguage.g:114:5: (lv_name_4_0= RULE_ID )
                    // PsiInternalCommentAssociationTestLanguage.g:115:6: lv_name_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_2_2_0ElementType());
                    					
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
        return ;
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
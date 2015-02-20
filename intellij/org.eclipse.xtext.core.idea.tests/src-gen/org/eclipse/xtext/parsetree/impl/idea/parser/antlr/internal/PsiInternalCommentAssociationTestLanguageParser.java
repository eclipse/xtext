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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:59:1: ruleModel : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:59:10: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:60:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:60:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:61:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:61:3: (lv_elements_0_0= ruleElement )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:62:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel85);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:74:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:74:17: ( ruleElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:75:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement111);
            ruleElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement117); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:81:1: ruleElement : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:81:12: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:82:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:82:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:83:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement136); 

            			doneLeaf(otherlv_0, elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:90:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:91:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:91:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:92:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement163); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getElement_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:101:3: ( () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:102:4: () otherlv_3= 'parent' ( (lv_name_4_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:102:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:103:5: 
                    {

                    					precedeComposite(elementTypeProvider.getElement_ElementChildAction_2_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElement210); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getElement_ParentKeyword_2_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:115:4: ( (lv_name_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:116:5: (lv_name_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:116:5: (lv_name_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/impl/idea/parser/antlr/internal/PsiInternalCommentAssociationTestLanguage.g:117:6: lv_name_4_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement242); 

                    						doneLeaf(lv_name_4_0, elementTypeProvider.getElement_NameIDTerminalRuleCall_2_2_0ElementType());
                    					

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel85 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement136 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement163 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleElement210 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement242 = new BitSet(new long[]{0x0000000000000002L});
    }


}
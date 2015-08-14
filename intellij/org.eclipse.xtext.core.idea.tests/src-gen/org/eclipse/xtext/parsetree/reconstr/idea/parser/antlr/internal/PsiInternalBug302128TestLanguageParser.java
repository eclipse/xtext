package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.Bug302128TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug302128TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VALUE", "RULE_ID", "RULE_SL_COMMENT", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'-'"
    };
    public static final int RULE_VALUE=4;
    public static final int RULE_ID=5;
    public static final int RULE_STRING=8;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=7;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=6;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;

    // delegates
    // delegators


        public PsiInternalBug302128TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug302128TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug302128TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug302128TestLanguage.g"; }



    	protected Bug302128TestLanguageGrammarAccess grammarAccess;

    	protected Bug302128TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug302128TestLanguageParser(PsiBuilder builder, TokenStream input, Bug302128TestLanguageElementTypeProvider elementTypeProvider, Bug302128TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBug302128TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug302128TestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalBug302128TestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalBug302128TestLanguage.g:58:1: ruleModel : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalBug302128TestLanguage.g:58:10: ( ( (lv_elements_0_0= ruleElement ) )* )
            // PsiInternalBug302128TestLanguage.g:59:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // PsiInternalBug302128TestLanguage.g:59:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug302128TestLanguage.g:60:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalBug302128TestLanguage.g:60:3: (lv_elements_0_0= ruleElement )
            	    // PsiInternalBug302128TestLanguage.g:61:4: lv_elements_0_0= ruleElement
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
    // PsiInternalBug302128TestLanguage.g:73:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalBug302128TestLanguage.g:73:17: ( ruleElement EOF )
            // PsiInternalBug302128TestLanguage.g:74:2: ruleElement EOF
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
    // PsiInternalBug302128TestLanguage.g:79:1: ruleElement : ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? ) ;
    public final void ruleElement() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // PsiInternalBug302128TestLanguage.g:79:12: ( ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? ) )
            // PsiInternalBug302128TestLanguage.g:80:2: ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? )
            {
            // PsiInternalBug302128TestLanguage.g:80:2: ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? )
            // PsiInternalBug302128TestLanguage.g:81:3: ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )?
            {
            // PsiInternalBug302128TestLanguage.g:81:3: ( (lv_name_0_0= ruleVariable ) )
            // PsiInternalBug302128TestLanguage.g:82:4: (lv_name_0_0= ruleVariable )
            {
            // PsiInternalBug302128TestLanguage.g:82:4: (lv_name_0_0= ruleVariable )
            // PsiInternalBug302128TestLanguage.g:83:5: lv_name_0_0= ruleVariable
            {

            					markComposite(elementTypeProvider.getElement_NameVariableParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleVariable();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalBug302128TestLanguage.g:92:3: ( (lv_value_1_0= RULE_VALUE ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_VALUE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug302128TestLanguage.g:93:4: (lv_value_1_0= RULE_VALUE )
                    {
                    // PsiInternalBug302128TestLanguage.g:93:4: (lv_value_1_0= RULE_VALUE )
                    // PsiInternalBug302128TestLanguage.g:94:5: lv_value_1_0= RULE_VALUE
                    {

                    					markLeaf(elementTypeProvider.getElement_ValueValueTerminalRuleCall_1_0ElementType());
                    				
                    lv_value_1_0=(Token)match(input,RULE_VALUE,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_value_1_0);
                    				

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


    // $ANTLR start "entryRuleVariable"
    // PsiInternalBug302128TestLanguage.g:107:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // PsiInternalBug302128TestLanguage.g:107:18: ( ruleVariable EOF )
            // PsiInternalBug302128TestLanguage.g:108:2: ruleVariable EOF
            {
             markComposite(elementTypeProvider.getVariableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVariable();

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // PsiInternalBug302128TestLanguage.g:113:1: ruleVariable : (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* ) ;
    public final void ruleVariable() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

        try {
            // PsiInternalBug302128TestLanguage.g:113:13: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* ) )
            // PsiInternalBug302128TestLanguage.g:114:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* )
            {
            // PsiInternalBug302128TestLanguage.g:114:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* )
            // PsiInternalBug302128TestLanguage.g:115:3: this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getVariable_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalBug302128TestLanguage.g:122:3: ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalBug302128TestLanguage.g:123:4: (kw= '.' | kw= '-' ) this_ID_3= RULE_ID
            	    {
            	    // PsiInternalBug302128TestLanguage.g:123:4: (kw= '.' | kw= '-' )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==12) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==13) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // PsiInternalBug302128TestLanguage.g:124:5: kw= '.'
            	            {

            	            					markLeaf(elementTypeProvider.getVariable_FullStopKeyword_1_0_0ElementType());
            	            				
            	            kw=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            	            					doneLeaf(kw);
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBug302128TestLanguage.g:132:5: kw= '-'
            	            {

            	            					markLeaf(elementTypeProvider.getVariable_HyphenMinusKeyword_1_0_1ElementType());
            	            				
            	            kw=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            	            					doneLeaf(kw);
            	            				

            	            }
            	            break;

            	    }


            	    				markLeaf(elementTypeProvider.getVariable_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            	    				doneLeaf(this_ID_3);
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleVariable"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    }


}
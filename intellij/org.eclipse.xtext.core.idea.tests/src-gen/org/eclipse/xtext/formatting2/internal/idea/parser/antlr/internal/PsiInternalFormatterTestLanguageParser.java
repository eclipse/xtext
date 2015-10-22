package org.eclipse.xtext.formatting2.internal.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalFormatterTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'idlist'", "'kwlist'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'kw5'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
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


        public PsiInternalFormatterTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFormatterTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFormatterTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalFormatterTestLanguage.g"; }



    	protected FormatterTestLanguageGrammarAccess grammarAccess;

    	protected FormatterTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalFormatterTestLanguageParser(PsiBuilder builder, TokenStream input, FormatterTestLanguageElementTypeProvider elementTypeProvider, FormatterTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // PsiInternalFormatterTestLanguage.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalFormatterTestLanguage.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalFormatterTestLanguage.g:53:2: iv_ruleRoot= ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalFormatterTestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean this_IDList_0 = null;

        Boolean this_KWList_1 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:60:1: ( (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList ) )
            // PsiInternalFormatterTestLanguage.g:61:2: (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList )
            {
            // PsiInternalFormatterTestLanguage.g:61:2: (this_IDList_0= ruleIDList | this_KWList_1= ruleKWList )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:62:3: this_IDList_0= ruleIDList
                    {

                    			markComposite(elementTypeProvider.getRoot_IDListParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IDList_0=ruleIDList();

                    state._fsp--;


                    			current = this_IDList_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalFormatterTestLanguage.g:71:3: this_KWList_1= ruleKWList
                    {

                    			markComposite(elementTypeProvider.getRoot_KWListParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_KWList_1=ruleKWList();

                    state._fsp--;


                    			current = this_KWList_1;
                    			doneComposite();
                    		

                    }
                    break;

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleIDList"
    // PsiInternalFormatterTestLanguage.g:83:1: entryRuleIDList returns [Boolean current=false] : iv_ruleIDList= ruleIDList EOF ;
    public final Boolean entryRuleIDList() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIDList = null;


        try {
            // PsiInternalFormatterTestLanguage.g:83:48: (iv_ruleIDList= ruleIDList EOF )
            // PsiInternalFormatterTestLanguage.g:84:2: iv_ruleIDList= ruleIDList EOF
            {
             markComposite(elementTypeProvider.getIDListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIDList=ruleIDList();

            state._fsp--;

             current =iv_ruleIDList; 
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
    // $ANTLR end "entryRuleIDList"


    // $ANTLR start "ruleIDList"
    // PsiInternalFormatterTestLanguage.g:90:1: ruleIDList returns [Boolean current=false] : ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* ) ;
    public final Boolean ruleIDList() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_ids_2_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:91:1: ( ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* ) )
            // PsiInternalFormatterTestLanguage.g:92:2: ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* )
            {
            // PsiInternalFormatterTestLanguage.g:92:2: ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* )
            // PsiInternalFormatterTestLanguage.g:93:3: () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )*
            {
            // PsiInternalFormatterTestLanguage.g:93:3: ()
            // PsiInternalFormatterTestLanguage.g:94:4: 
            {

            				precedeComposite(elementTypeProvider.getIDList_IDListAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getIDList_IdlistKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFormatterTestLanguage.g:107:3: ( (lv_ids_2_0= RULE_ID ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalFormatterTestLanguage.g:108:4: (lv_ids_2_0= RULE_ID )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:108:4: (lv_ids_2_0= RULE_ID )
            	    // PsiInternalFormatterTestLanguage.g:109:5: lv_ids_2_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getIDList_IdsIDTerminalRuleCall_2_0ElementType());
            	    				

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				
            	    lv_ids_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(lv_ids_2_0);
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleIDList"


    // $ANTLR start "entryRuleKWList"
    // PsiInternalFormatterTestLanguage.g:128:1: entryRuleKWList returns [Boolean current=false] : iv_ruleKWList= ruleKWList EOF ;
    public final Boolean entryRuleKWList() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKWList = null;


        try {
            // PsiInternalFormatterTestLanguage.g:128:48: (iv_ruleKWList= ruleKWList EOF )
            // PsiInternalFormatterTestLanguage.g:129:2: iv_ruleKWList= ruleKWList EOF
            {
             markComposite(elementTypeProvider.getKWListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKWList=ruleKWList();

            state._fsp--;

             current =iv_ruleKWList; 
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
    // $ANTLR end "entryRuleKWList"


    // $ANTLR start "ruleKWList"
    // PsiInternalFormatterTestLanguage.g:135:1: ruleKWList returns [Boolean current=false] : ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? ) ;
    public final Boolean ruleKWList() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_kw1_2_0=null;
        Token lv_kw2_3_0=null;
        Token lv_kw3_4_0=null;
        Token lv_kw4_5_0=null;
        Token lv_kw5_6_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:136:1: ( ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? ) )
            // PsiInternalFormatterTestLanguage.g:137:2: ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? )
            {
            // PsiInternalFormatterTestLanguage.g:137:2: ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? )
            // PsiInternalFormatterTestLanguage.g:138:3: () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )?
            {
            // PsiInternalFormatterTestLanguage.g:138:3: ()
            // PsiInternalFormatterTestLanguage.g:139:4: 
            {

            				precedeComposite(elementTypeProvider.getKWList_KWListAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getKWList_KwlistKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFormatterTestLanguage.g:152:3: ( (lv_kw1_2_0= 'kw1' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:153:4: (lv_kw1_2_0= 'kw1' )
                    {
                    // PsiInternalFormatterTestLanguage.g:153:4: (lv_kw1_2_0= 'kw1' )
                    // PsiInternalFormatterTestLanguage.g:154:5: lv_kw1_2_0= 'kw1'
                    {

                    					markLeaf(elementTypeProvider.getKWList_Kw1Kw1Keyword_2_0ElementType());
                    				
                    lv_kw1_2_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					doneLeaf(lv_kw1_2_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalFormatterTestLanguage.g:169:3: ( (lv_kw2_3_0= 'kw2' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:170:4: (lv_kw2_3_0= 'kw2' )
                    {
                    // PsiInternalFormatterTestLanguage.g:170:4: (lv_kw2_3_0= 'kw2' )
                    // PsiInternalFormatterTestLanguage.g:171:5: lv_kw2_3_0= 'kw2'
                    {

                    					markLeaf(elementTypeProvider.getKWList_Kw2Kw2Keyword_3_0ElementType());
                    				
                    lv_kw2_3_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                    					doneLeaf(lv_kw2_3_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalFormatterTestLanguage.g:186:3: ( (lv_kw3_4_0= 'kw3' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:187:4: (lv_kw3_4_0= 'kw3' )
                    {
                    // PsiInternalFormatterTestLanguage.g:187:4: (lv_kw3_4_0= 'kw3' )
                    // PsiInternalFormatterTestLanguage.g:188:5: lv_kw3_4_0= 'kw3'
                    {

                    					markLeaf(elementTypeProvider.getKWList_Kw3Kw3Keyword_4_0ElementType());
                    				
                    lv_kw3_4_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                    					doneLeaf(lv_kw3_4_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalFormatterTestLanguage.g:203:3: ( (lv_kw4_5_0= 'kw4' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:204:4: (lv_kw4_5_0= 'kw4' )
                    {
                    // PsiInternalFormatterTestLanguage.g:204:4: (lv_kw4_5_0= 'kw4' )
                    // PsiInternalFormatterTestLanguage.g:205:5: lv_kw4_5_0= 'kw4'
                    {

                    					markLeaf(elementTypeProvider.getKWList_Kw4Kw4Keyword_5_0ElementType());
                    				
                    lv_kw4_5_0=(Token)match(input,16,FollowSets000.FOLLOW_8); 

                    					doneLeaf(lv_kw4_5_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalFormatterTestLanguage.g:220:3: ( (lv_kw5_6_0= 'kw5' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:221:4: (lv_kw5_6_0= 'kw5' )
                    {
                    // PsiInternalFormatterTestLanguage.g:221:4: (lv_kw5_6_0= 'kw5' )
                    // PsiInternalFormatterTestLanguage.g:222:5: lv_kw5_6_0= 'kw5'
                    {

                    					markLeaf(elementTypeProvider.getKWList_Kw5Kw5Keyword_6_0ElementType());
                    				
                    lv_kw5_6_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_kw5_6_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
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
    // $ANTLR end "ruleKWList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000003E002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020002L});
    }


}
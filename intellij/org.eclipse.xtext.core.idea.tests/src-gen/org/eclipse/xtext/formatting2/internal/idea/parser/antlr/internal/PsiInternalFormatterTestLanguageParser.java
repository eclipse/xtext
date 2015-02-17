package org.eclipse.xtext.formatting2.internal.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g"; }



    private FormatterTestLanguageGrammarAccess grammarAccess;

    private FormatterTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalFormatterTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, FormatterTestLanguageElementTypeProvider elementTypeProvider, FormatterTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Root";
    }




    // $ANTLR start "entryRuleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:49:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:49:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:50:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot54);
            ruleRoot();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot60); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:58:1: ruleRoot : ( ruleIDList | ruleKWList ) ;
    public final void ruleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:58:9: ( ( ruleIDList | ruleKWList ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:59:2: ( ruleIDList | ruleKWList )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:59:2: ( ruleIDList | ruleKWList )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:60:3: ruleIDList
                    {

                    			markComposite(elementTypeProvider.getRoot_IDListParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleIDList_in_ruleRoot81);
                    ruleIDList();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:68:3: ruleKWList
                    {

                    			markComposite(elementTypeProvider.getRoot_KWListParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleKWList_in_ruleRoot101);
                    ruleKWList();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleIDList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:79:1: entryRuleIDList : ruleIDList EOF ;
    public final void entryRuleIDList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:79:16: ( ruleIDList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:80:2: ruleIDList EOF
            {
             markComposite(elementTypeProvider.getIDListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleIDList_in_entryRuleIDList121);
            ruleIDList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIDList127); 

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
    // $ANTLR end "entryRuleIDList"


    // $ANTLR start "ruleIDList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:88:1: ruleIDList : ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* ) ;
    public final void ruleIDList() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_ids_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:88:11: ( ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:89:2: ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:89:2: ( () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:90:3: () otherlv_1= 'idlist' ( (lv_ids_2_0= RULE_ID ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:90:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:91:4: 
            {

            				precedeComposite(elementTypeProvider.getIDList_IDListAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleIDList163); 

            			doneLeaf(otherlv_1, elementTypeProvider.getIDList_IdlistKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:103:3: ( (lv_ids_2_0= RULE_ID ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:104:4: (lv_ids_2_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:104:4: (lv_ids_2_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:105:5: lv_ids_2_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    lv_ids_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIDList190); 

            	    					doneLeaf(lv_ids_2_0, elementTypeProvider.getIDList_IdsIDTerminalRuleCall_2_0ElementType());
            	    				

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
        return ;
    }
    // $ANTLR end "ruleIDList"


    // $ANTLR start "entryRuleKWList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:118:1: entryRuleKWList : ruleKWList EOF ;
    public final void entryRuleKWList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:118:16: ( ruleKWList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:119:2: ruleKWList EOF
            {
             markComposite(elementTypeProvider.getKWListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKWList_in_entryRuleKWList222);
            ruleKWList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKWList228); 

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
    // $ANTLR end "entryRuleKWList"


    // $ANTLR start "ruleKWList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:127:1: ruleKWList : ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? ) ;
    public final void ruleKWList() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_kw1_2_0=null;
        Token lv_kw2_3_0=null;
        Token lv_kw3_4_0=null;
        Token lv_kw4_5_0=null;
        Token lv_kw5_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:127:11: ( ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:128:2: ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:128:2: ( () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:129:3: () otherlv_1= 'kwlist' ( (lv_kw1_2_0= 'kw1' ) )? ( (lv_kw2_3_0= 'kw2' ) )? ( (lv_kw3_4_0= 'kw3' ) )? ( (lv_kw4_5_0= 'kw4' ) )? ( (lv_kw5_6_0= 'kw5' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:129:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:130:4: 
            {

            				precedeComposite(elementTypeProvider.getKWList_KWListAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleKWList264); 

            			doneLeaf(otherlv_1, elementTypeProvider.getKWList_KwlistKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:142:3: ( (lv_kw1_2_0= 'kw1' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:143:4: (lv_kw1_2_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:143:4: (lv_kw1_2_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:144:5: lv_kw1_2_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_kw1_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleKWList291); 

                    					doneLeaf(lv_kw1_2_0, elementTypeProvider.getKWList_Kw1Kw1Keyword_2_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:153:3: ( (lv_kw2_3_0= 'kw2' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:154:4: (lv_kw2_3_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:154:4: (lv_kw2_3_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:155:5: lv_kw2_3_0= 'kw2'
                    {

                    					markLeaf();
                    				
                    lv_kw2_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleKWList330); 

                    					doneLeaf(lv_kw2_3_0, elementTypeProvider.getKWList_Kw2Kw2Keyword_3_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:164:3: ( (lv_kw3_4_0= 'kw3' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:165:4: (lv_kw3_4_0= 'kw3' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:165:4: (lv_kw3_4_0= 'kw3' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:166:5: lv_kw3_4_0= 'kw3'
                    {

                    					markLeaf();
                    				
                    lv_kw3_4_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleKWList369); 

                    					doneLeaf(lv_kw3_4_0, elementTypeProvider.getKWList_Kw3Kw3Keyword_4_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:175:3: ( (lv_kw4_5_0= 'kw4' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:176:4: (lv_kw4_5_0= 'kw4' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:176:4: (lv_kw4_5_0= 'kw4' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:177:5: lv_kw4_5_0= 'kw4'
                    {

                    					markLeaf();
                    				
                    lv_kw4_5_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleKWList408); 

                    					doneLeaf(lv_kw4_5_0, elementTypeProvider.getKWList_Kw4Kw4Keyword_5_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:186:3: ( (lv_kw5_6_0= 'kw5' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:187:4: (lv_kw5_6_0= 'kw5' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:187:4: (lv_kw5_6_0= 'kw5' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/internal/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:188:5: lv_kw5_6_0= 'kw5'
                    {

                    					markLeaf();
                    				
                    lv_kw5_6_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleKWList447); 

                    					doneLeaf(lv_kw5_6_0, elementTypeProvider.getKWList_Kw5Kw5Keyword_6_0ElementType());
                    				

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
    // $ANTLR end "ruleKWList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIDList_in_ruleRoot81 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKWList_in_ruleRoot101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIDList_in_entryRuleIDList121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIDList127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleIDList163 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIDList190 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleKWList_in_entryRuleKWList222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKWList228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleKWList264 = new BitSet(new long[]{0x000000000003E002L});
        public static final BitSet FOLLOW_13_in_ruleKWList291 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_14_in_ruleKWList330 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_15_in_ruleKWList369 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleKWList408 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleKWList447 = new BitSet(new long[]{0x0000000000000002L});
    }


}
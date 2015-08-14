package org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.assignments.services.Bug287184TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug287184TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'detail'", "'private'", "'protected'", "'public'", "'associated'", "';'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
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


        public PsiInternalBug287184TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug287184TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug287184TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug287184TestLanguage.g"; }



    	protected Bug287184TestLanguageGrammarAccess grammarAccess;

    	protected Bug287184TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug287184TestLanguageParser(PsiBuilder builder, TokenStream input, Bug287184TestLanguageElementTypeProvider elementTypeProvider, Bug287184TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBug287184TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug287184TestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalBug287184TestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalBug287184TestLanguage.g:58:1: ruleModel : (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalBug287184TestLanguage.g:58:10: ( (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) )
            // PsiInternalBug287184TestLanguage.g:59:2: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            {
            // PsiInternalBug287184TestLanguage.g:59:2: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            // PsiInternalBug287184TestLanguage.g:60:3: otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            {

            			markLeaf(elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug287184TestLanguage.g:67:3: ( (lv_name_1_0= ruleFQN ) )
            // PsiInternalBug287184TestLanguage.g:68:4: (lv_name_1_0= ruleFQN )
            {
            // PsiInternalBug287184TestLanguage.g:68:4: (lv_name_1_0= ruleFQN )
            // PsiInternalBug287184TestLanguage.g:69:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getModel_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalBug287184TestLanguage.g:78:3: ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBug287184TestLanguage.g:79:4: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    {
            	    // PsiInternalBug287184TestLanguage.g:79:4: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    // PsiInternalBug287184TestLanguage.g:80:5: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    {
            	    // PsiInternalBug287184TestLanguage.g:80:5: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==12) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==16) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // PsiInternalBug287184TestLanguage.g:81:6: lv_detail_2_1= ruleDetail
            	            {

            	            						markComposite(elementTypeProvider.getModel_DetailDetailParserRuleCall_2_0_0ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_5);
            	            ruleDetail();

            	            state._fsp--;


            	            						doneComposite();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBug287184TestLanguage.g:89:6: lv_detail_2_2= ruleAssociatedDetail
            	            {

            	            						markComposite(elementTypeProvider.getModel_DetailAssociatedDetailParserRuleCall_2_0_1ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_5);
            	            ruleAssociatedDetail();

            	            state._fsp--;


            	            						doneComposite();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDetail"
    // PsiInternalBug287184TestLanguage.g:103:1: entryRuleDetail : ruleDetail EOF ;
    public final void entryRuleDetail() throws RecognitionException {
        try {
            // PsiInternalBug287184TestLanguage.g:103:16: ( ruleDetail EOF )
            // PsiInternalBug287184TestLanguage.g:104:2: ruleDetail EOF
            {
             markComposite(elementTypeProvider.getDetailElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDetail();

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
    // $ANTLR end "entryRuleDetail"


    // $ANTLR start "ruleDetail"
    // PsiInternalBug287184TestLanguage.g:109:1: ruleDetail : (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) ;
    public final void ruleDetail() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        try {
            // PsiInternalBug287184TestLanguage.g:109:11: ( (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) )
            // PsiInternalBug287184TestLanguage.g:110:2: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            {
            // PsiInternalBug287184TestLanguage.g:110:2: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            // PsiInternalBug287184TestLanguage.g:111:3: otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getDetail_DetailKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug287184TestLanguage.g:118:3: ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=13 && LA4_0<=15)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBug287184TestLanguage.g:119:4: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    {
                    // PsiInternalBug287184TestLanguage.g:119:4: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    // PsiInternalBug287184TestLanguage.g:120:5: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    {
                    // PsiInternalBug287184TestLanguage.g:120:5: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    int alt3=3;
                    switch ( input.LA(1) ) {
                    case 13:
                        {
                        alt3=1;
                        }
                        break;
                    case 14:
                        {
                        alt3=2;
                        }
                        break;
                    case 15:
                        {
                        alt3=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // PsiInternalBug287184TestLanguage.g:121:6: lv_visibility_1_1= 'private'
                            {

                            						markLeaf(elementTypeProvider.getDetail_VisibilityPrivateKeyword_1_0_0ElementType());
                            					
                            lv_visibility_1_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            						doneLeaf(lv_visibility_1_1);
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalBug287184TestLanguage.g:129:6: lv_visibility_1_2= 'protected'
                            {

                            						markLeaf(elementTypeProvider.getDetail_VisibilityProtectedKeyword_1_0_1ElementType());
                            					
                            lv_visibility_1_2=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            						doneLeaf(lv_visibility_1_2);
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalBug287184TestLanguage.g:137:6: lv_visibility_1_3= 'public'
                            {

                            						markLeaf(elementTypeProvider.getDetail_VisibilityPublicKeyword_1_0_2ElementType());
                            					
                            lv_visibility_1_3=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                            						doneLeaf(lv_visibility_1_3);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287184TestLanguage.g:147:3: ( ( ruleFQN ) )
            // PsiInternalBug287184TestLanguage.g:148:4: ( ruleFQN )
            {
            // PsiInternalBug287184TestLanguage.g:148:4: ( ruleFQN )
            // PsiInternalBug287184TestLanguage.g:149:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getDetail_DetailClassModelCrossReference_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

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
    // $ANTLR end "ruleDetail"


    // $ANTLR start "entryRuleAssociatedDetail"
    // PsiInternalBug287184TestLanguage.g:162:1: entryRuleAssociatedDetail : ruleAssociatedDetail EOF ;
    public final void entryRuleAssociatedDetail() throws RecognitionException {
        try {
            // PsiInternalBug287184TestLanguage.g:162:26: ( ruleAssociatedDetail EOF )
            // PsiInternalBug287184TestLanguage.g:163:2: ruleAssociatedDetail EOF
            {
             markComposite(elementTypeProvider.getAssociatedDetailElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssociatedDetail();

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
    // $ANTLR end "entryRuleAssociatedDetail"


    // $ANTLR start "ruleAssociatedDetail"
    // PsiInternalBug287184TestLanguage.g:168:1: ruleAssociatedDetail : (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) ;
    public final void ruleAssociatedDetail() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug287184TestLanguage.g:168:21: ( (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) )
            // PsiInternalBug287184TestLanguage.g:169:2: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            {
            // PsiInternalBug287184TestLanguage.g:169:2: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            // PsiInternalBug287184TestLanguage.g:170:3: otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';'
            {

            			markLeaf(elementTypeProvider.getAssociatedDetail_AssociatedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug287184TestLanguage.g:177:3: ( ( ruleFQN ) )
            // PsiInternalBug287184TestLanguage.g:178:4: ( ruleFQN )
            {
            // PsiInternalBug287184TestLanguage.g:178:4: ( ruleFQN )
            // PsiInternalBug287184TestLanguage.g:179:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getAssociatedDetail_DetailClassModelCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_7);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getAssociatedDetail_SemicolonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleAssociatedDetail"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalBug287184TestLanguage.g:199:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // PsiInternalBug287184TestLanguage.g:199:13: ( ruleFQN EOF )
            // PsiInternalBug287184TestLanguage.g:200:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalBug287184TestLanguage.g:205:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalBug287184TestLanguage.g:205:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalBug287184TestLanguage.g:206:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalBug287184TestLanguage.g:206:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalBug287184TestLanguage.g:207:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalBug287184TestLanguage.g:214:3: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalBug287184TestLanguage.g:215:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    				doneLeaf(this_ID_2);
            	    			

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000011000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000011002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000E010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
    }


}
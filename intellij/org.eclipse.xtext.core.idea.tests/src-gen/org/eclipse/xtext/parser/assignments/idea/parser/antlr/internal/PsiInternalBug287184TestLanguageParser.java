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
    // PsiInternalBug287184TestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug287184TestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug287184TestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug287184TestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_name_1_0 = null;

        Boolean lv_detail_2_1 = null;

        Boolean lv_detail_2_2 = null;


        try {
            // PsiInternalBug287184TestLanguage.g:60:1: ( (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) )
            // PsiInternalBug287184TestLanguage.g:61:2: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            {
            // PsiInternalBug287184TestLanguage.g:61:2: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            // PsiInternalBug287184TestLanguage.g:62:3: otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            {

            			markLeaf(elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug287184TestLanguage.g:69:3: ( (lv_name_1_0= ruleFQN ) )
            // PsiInternalBug287184TestLanguage.g:70:4: (lv_name_1_0= ruleFQN )
            {
            // PsiInternalBug287184TestLanguage.g:70:4: (lv_name_1_0= ruleFQN )
            // PsiInternalBug287184TestLanguage.g:71:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getModel_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalBug287184TestLanguage.g:84:3: ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
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
            	    // PsiInternalBug287184TestLanguage.g:85:4: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    {
            	    // PsiInternalBug287184TestLanguage.g:85:4: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    // PsiInternalBug287184TestLanguage.g:86:5: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    {
            	    // PsiInternalBug287184TestLanguage.g:86:5: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
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
            	            // PsiInternalBug287184TestLanguage.g:87:6: lv_detail_2_1= ruleDetail
            	            {

            	            						markComposite(elementTypeProvider.getModel_DetailDetailParserRuleCall_2_0_0ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_5);
            	            lv_detail_2_1=ruleDetail();

            	            state._fsp--;


            	            						doneComposite();
            	            						if(!current) {
            	            							associateWithSemanticElement();
            	            							current = true;
            	            						}
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBug287184TestLanguage.g:99:6: lv_detail_2_2= ruleAssociatedDetail
            	            {

            	            						markComposite(elementTypeProvider.getModel_DetailAssociatedDetailParserRuleCall_2_0_1ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_5);
            	            lv_detail_2_2=ruleAssociatedDetail();

            	            state._fsp--;


            	            						doneComposite();
            	            						if(!current) {
            	            							associateWithSemanticElement();
            	            							current = true;
            	            						}
            	            					

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDetail"
    // PsiInternalBug287184TestLanguage.g:117:1: entryRuleDetail returns [Boolean current=false] : iv_ruleDetail= ruleDetail EOF ;
    public final Boolean entryRuleDetail() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDetail = null;


        try {
            // PsiInternalBug287184TestLanguage.g:117:48: (iv_ruleDetail= ruleDetail EOF )
            // PsiInternalBug287184TestLanguage.g:118:2: iv_ruleDetail= ruleDetail EOF
            {
             markComposite(elementTypeProvider.getDetailElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDetail=ruleDetail();

            state._fsp--;

             current =iv_ruleDetail; 
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
    // $ANTLR end "entryRuleDetail"


    // $ANTLR start "ruleDetail"
    // PsiInternalBug287184TestLanguage.g:124:1: ruleDetail returns [Boolean current=false] : (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) ;
    public final Boolean ruleDetail() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        try {
            // PsiInternalBug287184TestLanguage.g:125:1: ( (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) )
            // PsiInternalBug287184TestLanguage.g:126:2: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            {
            // PsiInternalBug287184TestLanguage.g:126:2: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            // PsiInternalBug287184TestLanguage.g:127:3: otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getDetail_DetailKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug287184TestLanguage.g:134:3: ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=13 && LA4_0<=15)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBug287184TestLanguage.g:135:4: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    {
                    // PsiInternalBug287184TestLanguage.g:135:4: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    // PsiInternalBug287184TestLanguage.g:136:5: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    {
                    // PsiInternalBug287184TestLanguage.g:136:5: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
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
                            // PsiInternalBug287184TestLanguage.g:137:6: lv_visibility_1_1= 'private'
                            {

                            						markLeaf(elementTypeProvider.getDetail_VisibilityPrivateKeyword_1_0_0ElementType());
                            					
                            lv_visibility_1_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                            						doneLeaf(lv_visibility_1_1);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalBug287184TestLanguage.g:151:6: lv_visibility_1_2= 'protected'
                            {

                            						markLeaf(elementTypeProvider.getDetail_VisibilityProtectedKeyword_1_0_1ElementType());
                            					
                            lv_visibility_1_2=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            						doneLeaf(lv_visibility_1_2);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalBug287184TestLanguage.g:165:6: lv_visibility_1_3= 'public'
                            {

                            						markLeaf(elementTypeProvider.getDetail_VisibilityPublicKeyword_1_0_2ElementType());
                            					
                            lv_visibility_1_3=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                            						doneLeaf(lv_visibility_1_3);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBug287184TestLanguage.g:181:3: ( ( ruleFQN ) )
            // PsiInternalBug287184TestLanguage.g:182:4: ( ruleFQN )
            {
            // PsiInternalBug287184TestLanguage.g:182:4: ( ruleFQN )
            // PsiInternalBug287184TestLanguage.g:183:5: ruleFQN
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleDetail"


    // $ANTLR start "entryRuleAssociatedDetail"
    // PsiInternalBug287184TestLanguage.g:202:1: entryRuleAssociatedDetail returns [Boolean current=false] : iv_ruleAssociatedDetail= ruleAssociatedDetail EOF ;
    public final Boolean entryRuleAssociatedDetail() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssociatedDetail = null;


        try {
            // PsiInternalBug287184TestLanguage.g:202:58: (iv_ruleAssociatedDetail= ruleAssociatedDetail EOF )
            // PsiInternalBug287184TestLanguage.g:203:2: iv_ruleAssociatedDetail= ruleAssociatedDetail EOF
            {
             markComposite(elementTypeProvider.getAssociatedDetailElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssociatedDetail=ruleAssociatedDetail();

            state._fsp--;

             current =iv_ruleAssociatedDetail; 
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
    // $ANTLR end "entryRuleAssociatedDetail"


    // $ANTLR start "ruleAssociatedDetail"
    // PsiInternalBug287184TestLanguage.g:209:1: ruleAssociatedDetail returns [Boolean current=false] : (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) ;
    public final Boolean ruleAssociatedDetail() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug287184TestLanguage.g:210:1: ( (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) )
            // PsiInternalBug287184TestLanguage.g:211:2: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            {
            // PsiInternalBug287184TestLanguage.g:211:2: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            // PsiInternalBug287184TestLanguage.g:212:3: otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';'
            {

            			markLeaf(elementTypeProvider.getAssociatedDetail_AssociatedKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug287184TestLanguage.g:219:3: ( ( ruleFQN ) )
            // PsiInternalBug287184TestLanguage.g:220:4: ( ruleFQN )
            {
            // PsiInternalBug287184TestLanguage.g:220:4: ( ruleFQN )
            // PsiInternalBug287184TestLanguage.g:221:5: ruleFQN
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleAssociatedDetail"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalBug287184TestLanguage.g:247:1: entryRuleFQN returns [Boolean current=false] : iv_ruleFQN= ruleFQN EOF ;
    public final Boolean entryRuleFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN = null;


        try {
            // PsiInternalBug287184TestLanguage.g:247:45: (iv_ruleFQN= ruleFQN EOF )
            // PsiInternalBug287184TestLanguage.g:248:2: iv_ruleFQN= ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN; 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalBug287184TestLanguage.g:254:1: ruleFQN returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleFQN() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalBug287184TestLanguage.g:255:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalBug287184TestLanguage.g:256:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalBug287184TestLanguage.g:256:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalBug287184TestLanguage.g:257:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalBug287184TestLanguage.g:264:3: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalBug287184TestLanguage.g:265:4: kw= '.' this_ID_2= RULE_ID
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
        return current;
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
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:59:1: ruleModel : (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:62:2: ( (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:63:2: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:63:2: (otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:64:3: otherlv_0= 'model' ( (lv_name_1_0= ruleFQN ) ) ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel88); 

            			doneLeaf(otherlv_0, elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:71:3: ( (lv_name_1_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:72:4: (lv_name_1_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:72:4: (lv_name_1_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:73:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getModel_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleModel115);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:82:3: ( ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:83:4: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:83:4: ( (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:84:5: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:84:5: (lv_detail_2_1= ruleDetail | lv_detail_2_2= ruleAssociatedDetail )
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
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:85:6: lv_detail_2_1= ruleDetail
            	            {

            	            						markComposite(elementTypeProvider.getModel_DetailDetailParserRuleCall_2_0_0ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_ruleDetail_in_ruleModel161);
            	            ruleDetail();

            	            state._fsp--;


            	            						doneComposite();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:93:6: lv_detail_2_2= ruleAssociatedDetail
            	            {

            	            						markComposite(elementTypeProvider.getModel_DetailAssociatedDetailParserRuleCall_2_0_1ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_ruleAssociatedDetail_in_ruleModel195);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:107:1: entryRuleDetail : ruleDetail EOF ;
    public final void entryRuleDetail() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:107:16: ( ruleDetail EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:108:2: ruleDetail EOF
            {
             markComposite(elementTypeProvider.getDetailElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDetail_in_entryRuleDetail234);
            ruleDetail();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDetail240); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:114:1: ruleDetail : (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) ;
    public final void ruleDetail() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:117:2: ( (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:118:2: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:118:2: (otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:119:3: otherlv_0= 'detail' ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )? ( ( ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDetail268); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDetail_DetailKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:126:3: ( ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=13 && LA4_0<=15)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:127:4: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:127:4: ( (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:128:5: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:128:5: (lv_visibility_1_1= 'private' | lv_visibility_1_2= 'protected' | lv_visibility_1_3= 'public' )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:129:6: lv_visibility_1_1= 'private'
                            {

                            						markLeaf();
                            					
                            lv_visibility_1_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDetail303); 

                            						doneLeaf(lv_visibility_1_1, elementTypeProvider.getDetail_VisibilityPrivateKeyword_1_0_0ElementType());
                            					

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:137:6: lv_visibility_1_2= 'protected'
                            {

                            						markLeaf();
                            					
                            lv_visibility_1_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDetail337); 

                            						doneLeaf(lv_visibility_1_2, elementTypeProvider.getDetail_VisibilityProtectedKeyword_1_0_1ElementType());
                            					

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:145:6: lv_visibility_1_3= 'public'
                            {

                            						markLeaf();
                            					
                            lv_visibility_1_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDetail371); 

                            						doneLeaf(lv_visibility_1_3, elementTypeProvider.getDetail_VisibilityPublicKeyword_1_0_2ElementType());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:155:3: ( ( ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:156:4: ( ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:156:4: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:157:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getDetail_DetailClassModelCrossReference_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDetail415);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:170:1: entryRuleAssociatedDetail : ruleAssociatedDetail EOF ;
    public final void entryRuleAssociatedDetail() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:170:26: ( ruleAssociatedDetail EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:171:2: ruleAssociatedDetail EOF
            {
             markComposite(elementTypeProvider.getAssociatedDetailElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssociatedDetail_in_entryRuleAssociatedDetail446);
            ruleAssociatedDetail();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssociatedDetail452); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:177:1: ruleAssociatedDetail : (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) ;
    public final void ruleAssociatedDetail() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:180:2: ( (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:181:2: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:181:2: (otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:182:3: otherlv_0= 'associated' ( ( ruleFQN ) ) otherlv_2= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAssociatedDetail480); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAssociatedDetail_AssociatedKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:189:3: ( ( ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:190:4: ( ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:190:4: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:191:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getAssociatedDetail_DetailClassModelCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleAssociatedDetail505);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAssociatedDetail530); 

            			doneLeaf(otherlv_2, elementTypeProvider.getAssociatedDetail_SemicolonKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:211:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:211:13: ( ruleFQN EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:212:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN550);
            ruleFQN();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN556); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:218:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:221:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:222:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:222:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:223:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN584); 

            			doneLeaf(this_ID_0, elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:230:3: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalBug287184TestLanguage.g:231:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFQN604); 

            	    				doneLeaf(kw, elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN621); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel88 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleModel115 = new BitSet(new long[]{0x0000000000011000L});
        public static final BitSet FOLLOW_ruleDetail_in_ruleModel161 = new BitSet(new long[]{0x0000000000011002L});
        public static final BitSet FOLLOW_ruleAssociatedDetail_in_ruleModel195 = new BitSet(new long[]{0x0000000000011002L});
        public static final BitSet FOLLOW_ruleDetail_in_entryRuleDetail234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDetail240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleDetail268 = new BitSet(new long[]{0x000000000000E010L});
        public static final BitSet FOLLOW_13_in_ruleDetail303 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleDetail337 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_15_in_ruleDetail371 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDetail415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssociatedDetail_in_entryRuleAssociatedDetail446 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssociatedDetail452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleAssociatedDetail480 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleAssociatedDetail505 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAssociatedDetail530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN550 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN584 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleFQN604 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN621 = new BitSet(new long[]{0x0000000000040002L});
    }


}
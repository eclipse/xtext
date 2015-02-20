package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.services.Bug289524TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBug289524TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'reference'", "'$'", "'containment'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
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


        public PsiInternalBug289524TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug289524TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug289524TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected Bug289524TestLanguageGrammarAccess grammarAccess;

    	protected Bug289524TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug289524TestLanguageParser(PsiBuilder builder, TokenStream input, Bug289524TestLanguageElementTypeProvider elementTypeProvider, Bug289524TestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:58:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:59:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel66); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:65:1: ruleModel : ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:65:10: ( ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:66:2: ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:66:2: ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:67:3: () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:67:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:68:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getModel_ModelAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel103); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1, elementTypeProvider.getModel_ModelKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:83:3: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:84:4: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:84:4: (lv_refs_2_0= ruleModelElement )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:85:5: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_RefsModelElementParserRuleCall_2_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_ruleModel130);
            	    ruleModelElement();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:98:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:98:22: ( ruleModelElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:99:2: ruleModelElement EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement162);
            ruleModelElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement168); if (state.failed) return ;

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
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:105:1: ruleModelElement : ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ ) ;
    public final void ruleModelElement() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:105:17: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:106:2: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:106:2: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:107:3: () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:107:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:108:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getModelElement_ModelElementAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:116:3: ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred2_PsiInternalBug289524TestLanguage()) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==12) ) {
                    int LA3_3 = input.LA(2);

                    if ( (synpred4_PsiInternalBug289524TestLanguage()) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:117:4: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:117:4: ( (lv_containments_1_0= ruleContained ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:118:5: (lv_containments_1_0= ruleContained )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:118:5: (lv_containments_1_0= ruleContained )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:119:6: lv_containments_1_0= ruleContained
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getModelElement_ContainmentsContainedParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContained_in_ruleModelElement226);
            	    ruleContained();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:129:4: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:129:4: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:130:5: otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf();
            	      				
            	    }
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModelElement272); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_2, elementTypeProvider.getModelElement_ReferenceKeyword_1_1_0ElementType());
            	      				
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:137:5: ( (otherlv_3= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:138:6: (otherlv_3= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:138:6: (otherlv_3= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:139:7: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf();
            	      						
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement309); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(otherlv_3, elementTypeProvider.getModelElement_RefsContainedCrossReference_1_1_1_0ElementType());
            	      						
            	    }

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:148:5: (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==13) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:149:6: otherlv_4= '$' ( (otherlv_5= RULE_ID ) )
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      						markLeaf();
            	    	      					
            	    	    }
            	    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModelElement352); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      						doneLeaf(otherlv_4, elementTypeProvider.getModelElement_DollarSignKeyword_1_1_2_0ElementType());
            	    	      					
            	    	    }
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:156:6: ( (otherlv_5= RULE_ID ) )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:157:7: (otherlv_5= RULE_ID )
            	    	    {
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:157:7: (otherlv_5= RULE_ID )
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:158:8: otherlv_5= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      								markLeaf();
            	    	      							
            	    	    }
            	    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement394); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      								doneLeaf(otherlv_5, elementTypeProvider.getModelElement_RefsContainedCrossReference_1_1_2_1_0ElementType());
            	    	      							
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleContained"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:174:1: entryRuleContained : ruleContained EOF ;
    public final void entryRuleContained() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:174:19: ( ruleContained EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:175:2: ruleContained EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getContainedElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContained_in_entryRuleContained451);
            ruleContained();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContained457); if (state.failed) return ;

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
    // $ANTLR end "entryRuleContained"


    // $ANTLR start "ruleContained"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:181:1: ruleContained : (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleContained() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:181:14: ( (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:182:2: (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:182:2: (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:183:3: otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleContained476); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getContained_ContainmentKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:190:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:191:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:191:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:192:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContained503); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0, elementTypeProvider.getContained_NameIDTerminalRuleCall_1_0ElementType());
              				
            }

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
    // $ANTLR end "ruleContained"

    // $ANTLR start synpred2_PsiInternalBug289524TestLanguage
    public final void synpred2_PsiInternalBug289524TestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:117:4: ( ( (lv_containments_1_0= ruleContained ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:117:4: ( (lv_containments_1_0= ruleContained ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:117:4: ( (lv_containments_1_0= ruleContained ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:118:5: (lv_containments_1_0= ruleContained )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:118:5: (lv_containments_1_0= ruleContained )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:119:6: lv_containments_1_0= ruleContained
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getModelElement_ContainmentsContainedParserRuleCall_1_0_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_ruleContained_in_synpred2_PsiInternalBug289524TestLanguage226);
        ruleContained();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_PsiInternalBug289524TestLanguage

    // $ANTLR start synpred4_PsiInternalBug289524TestLanguage
    public final void synpred4_PsiInternalBug289524TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:129:4: ( (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:129:4: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:129:4: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:130:5: otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
        {
        if ( state.backtracking==0 ) {

          					markLeaf();
          				
        }
        otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_synpred4_PsiInternalBug289524TestLanguage272); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:137:5: ( (otherlv_3= RULE_ID ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:138:6: (otherlv_3= RULE_ID )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:138:6: (otherlv_3= RULE_ID )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:139:7: otherlv_3= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf();
          						
        }
        otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_PsiInternalBug289524TestLanguage309); if (state.failed) return ;

        }


        }

        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:148:5: (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:149:6: otherlv_4= '$' ( (otherlv_5= RULE_ID ) )
        	    {
        	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_synpred4_PsiInternalBug289524TestLanguage352); if (state.failed) return ;
        	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:156:6: ( (otherlv_5= RULE_ID ) )
        	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:157:7: (otherlv_5= RULE_ID )
        	    {
        	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:157:7: (otherlv_5= RULE_ID )
        	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289524TestLanguage.g:158:8: otherlv_5= RULE_ID
        	    {
        	    if ( state.backtracking==0 ) {

        	      								markLeaf();
        	      							
        	    }
        	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_PsiInternalBug289524TestLanguage394); if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop4;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred4_PsiInternalBug289524TestLanguage

    // Delegated rules

    public final boolean synpred2_PsiInternalBug289524TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalBug289524TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalBug289524TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalBug289524TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel66 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel103 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_ruleModelElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement162 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_ruleModelElement226 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_12_in_ruleModelElement272 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement309 = new BitSet(new long[]{0x0000000000007002L});
        public static final BitSet FOLLOW_13_in_ruleModelElement352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement394 = new BitSet(new long[]{0x0000000000007002L});
        public static final BitSet FOLLOW_ruleContained_in_entryRuleContained451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContained457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleContained476 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContained503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_synpred2_PsiInternalBug289524TestLanguage226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_synpred4_PsiInternalBug289524TestLanguage272 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_PsiInternalBug289524TestLanguage309 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_synpred4_PsiInternalBug289524TestLanguage352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_PsiInternalBug289524TestLanguage394 = new BitSet(new long[]{0x0000000000002002L});
    }


}
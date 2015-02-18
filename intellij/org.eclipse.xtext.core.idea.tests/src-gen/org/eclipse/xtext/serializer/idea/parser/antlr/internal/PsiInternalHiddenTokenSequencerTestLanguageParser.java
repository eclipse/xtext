package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.serializer.services.HiddenTokenSequencerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalHiddenTokenSequencerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entities'", "'end'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalHiddenTokenSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalHiddenTokenSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalHiddenTokenSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g"; }



    	protected HiddenTokenSequencerTestLanguageGrammarAccess grammarAccess;

    	protected HiddenTokenSequencerTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalHiddenTokenSequencerTestLanguageParser(PsiBuilder builder, TokenStream input, HiddenTokenSequencerTestLanguageElementTypeProvider elementTypeProvider, HiddenTokenSequencerTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:59:1: ruleModel : ( (lv_domainModel_0_0= ruleDomainModel ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:59:10: ( ( (lv_domainModel_0_0= ruleDomainModel ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:60:2: ( (lv_domainModel_0_0= ruleDomainModel ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:60:2: ( (lv_domainModel_0_0= ruleDomainModel ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:61:3: (lv_domainModel_0_0= ruleDomainModel )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:61:3: (lv_domainModel_0_0= ruleDomainModel )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:62:4: lv_domainModel_0_0= ruleDomainModel
            {

            				markComposite(elementTypeProvider.getModel_DomainModelDomainModelParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleDomainModel_in_ruleModel89);
            ruleDomainModel();

            state._fsp--;


            				doneComposite();
            			

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:74:1: entryRuleDomainModel : ruleDomainModel EOF ;
    public final void entryRuleDomainModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:74:21: ( ruleDomainModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:75:2: ruleDomainModel EOF
            {
             markComposite(elementTypeProvider.getDomainModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDomainModel_in_entryRuleDomainModel114);
            ruleDomainModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDomainModel120); 

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
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:83:1: ruleDomainModel : (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' ) ;
    public final void ruleDomainModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:83:16: ( (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:84:2: (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:84:2: (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:85:3: otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleDomainModel143); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDomainModel_EntitiesKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:92:3: ( (lv_entities_1_0= ruleEntity ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:93:4: (lv_entities_1_0= ruleEntity )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:93:4: (lv_entities_1_0= ruleEntity )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:94:5: lv_entities_1_0= ruleEntity
            	    {

            	    					markComposite(elementTypeProvider.getDomainModel_EntitiesEntityParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleEntity_in_ruleDomainModel170);
            	    ruleEntity();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDomainModel196); 

            			doneLeaf(otherlv_2, elementTypeProvider.getDomainModel_EndKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleEntity"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:114:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:114:16: ( ruleEntity EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:115:2: ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEntity_in_entryRuleEntity216);
            ruleEntity();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntity222); 

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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:123:1: ruleEntity : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final void ruleEntity() throws RecognitionException {
        Token lv_name_0_0=null;
        Token lv_description_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:123:11: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:124:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:124:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:125:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:125:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:126:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:126:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:127:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntity258); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getEntity_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:136:3: ( (lv_description_1_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:137:4: (lv_description_1_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:137:4: (lv_description_1_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalHiddenTokenSequencerTestLanguage.g:138:5: lv_description_1_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_description_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEntity296); 

            					doneLeaf(lv_description_1_0, elementTypeProvider.getEntity_DescriptionSTRINGTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleEntity"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDomainModel_in_ruleModel89 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDomainModel_in_entryRuleDomainModel114 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDomainModel120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDomainModel143 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleEntity_in_ruleDomainModel170 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleDomainModel196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntity222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntity258 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEntity296 = new BitSet(new long[]{0x0000000000000002L});
    }


}
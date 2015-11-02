package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalHiddenTokenSequencerTestLanguage.g"; }



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
    // PsiInternalHiddenTokenSequencerTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalHiddenTokenSequencerTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_domainModel_0_0= ruleDomainModel ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_domainModel_0_0 = null;


        try {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:60:1: ( ( (lv_domainModel_0_0= ruleDomainModel ) ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:61:2: ( (lv_domainModel_0_0= ruleDomainModel ) )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:61:2: ( (lv_domainModel_0_0= ruleDomainModel ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:62:3: (lv_domainModel_0_0= ruleDomainModel )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:62:3: (lv_domainModel_0_0= ruleDomainModel )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:63:4: lv_domainModel_0_0= ruleDomainModel
            {

            				markComposite(elementTypeProvider.getModel_DomainModelDomainModelParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_domainModel_0_0=ruleDomainModel();

            state._fsp--;


            				doneComposite();
            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainModel"
    // PsiInternalHiddenTokenSequencerTestLanguage.g:79:1: entryRuleDomainModel returns [Boolean current=false] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final Boolean entryRuleDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDomainModel = null;


        try {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:79:53: (iv_ruleDomainModel= ruleDomainModel EOF )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:80:2: iv_ruleDomainModel= ruleDomainModel EOF
            {
             markComposite(elementTypeProvider.getDomainModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDomainModel=ruleDomainModel();

            state._fsp--;

             current =iv_ruleDomainModel; 
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
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // PsiInternalHiddenTokenSequencerTestLanguage.g:86:1: ruleDomainModel returns [Boolean current=false] : (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' ) ;
    public final Boolean ruleDomainModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_entities_1_0 = null;


        try {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:87:1: ( (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:88:2: (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:88:2: (otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end' )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:89:3: otherlv_0= 'entities' ( (lv_entities_1_0= ruleEntity ) )* otherlv_2= 'end'
            {

            			markLeaf(elementTypeProvider.getDomainModel_EntitiesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTokenSequencerTestLanguage.g:96:3: ( (lv_entities_1_0= ruleEntity ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalHiddenTokenSequencerTestLanguage.g:97:4: (lv_entities_1_0= ruleEntity )
            	    {
            	    // PsiInternalHiddenTokenSequencerTestLanguage.g:97:4: (lv_entities_1_0= ruleEntity )
            	    // PsiInternalHiddenTokenSequencerTestLanguage.g:98:5: lv_entities_1_0= ruleEntity
            	    {

            	    					markComposite(elementTypeProvider.getDomainModel_EntitiesEntityParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_entities_1_0=ruleEntity();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getDomainModel_EndKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleEntity"
    // PsiInternalHiddenTokenSequencerTestLanguage.g:122:1: entryRuleEntity returns [Boolean current=false] : iv_ruleEntity= ruleEntity EOF ;
    public final Boolean entryRuleEntity() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntity = null;


        try {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:122:48: (iv_ruleEntity= ruleEntity EOF )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:123:2: iv_ruleEntity= ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // PsiInternalHiddenTokenSequencerTestLanguage.g:129:1: ruleEntity returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final Boolean ruleEntity() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token lv_description_1_0=null;

        try {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:130:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:131:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:131:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:132:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_description_1_0= RULE_STRING ) )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:132:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:133:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:133:4: (lv_name_0_0= RULE_ID )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:134:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEntity_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalHiddenTokenSequencerTestLanguage.g:149:3: ( (lv_description_1_0= RULE_STRING ) )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:150:4: (lv_description_1_0= RULE_STRING )
            {
            // PsiInternalHiddenTokenSequencerTestLanguage.g:150:4: (lv_description_1_0= RULE_STRING )
            // PsiInternalHiddenTokenSequencerTestLanguage.g:151:5: lv_description_1_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getEntity_DescriptionSTRINGTerminalRuleCall_1_0ElementType());
            				
            lv_description_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_description_1_0);
            				

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
    // $ANTLR end "ruleEntity"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    }


}
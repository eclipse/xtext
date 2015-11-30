package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalTerminalRulesTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "RULE_ESCAPED_CHAR", "RULE_IN_RICH_STRING"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_RICH_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;
    public static final int RULE_ESCAPED_CHAR=12;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_IN_RICH_STRING=13;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators


        public PsiInternalTerminalRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalTerminalRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalTerminalRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalTerminalRulesTestLanguage.g"; }



    	protected TerminalRulesTestLanguageGrammarAccess grammarAccess;

    	protected TerminalRulesTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalTerminalRulesTestLanguageParser(PsiBuilder builder, TokenStream input, TerminalRulesTestLanguageElementTypeProvider elementTypeProvider, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalTerminalRulesTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalTerminalRulesTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalTerminalRulesTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalTerminalRulesTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token lv_idValue_0_0=null;
        Token lv_intValue_1_0=null;
        Token lv_stringValue_2_0=null;
        Token lv_richStringValue_3_0=null;
        Token lv_mlCommentValue_4_0=null;
        Token lv_slCommentValue_5_0=null;
        Token lv_wsValue_6_0=null;
        Token lv_anyValue_7_0=null;

        try {
            // PsiInternalTerminalRulesTestLanguage.g:60:1: ( ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) ) )
            // PsiInternalTerminalRulesTestLanguage.g:61:2: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) )
            {
            // PsiInternalTerminalRulesTestLanguage.g:61:2: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case RULE_INT:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            case RULE_RICH_STRING:
                {
                alt1=4;
                }
                break;
            case RULE_ML_COMMENT:
                {
                alt1=5;
                }
                break;
            case RULE_SL_COMMENT:
                {
                alt1=6;
                }
                break;
            case RULE_WS:
                {
                alt1=7;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalTerminalRulesTestLanguage.g:62:3: ( (lv_idValue_0_0= RULE_ID ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:62:3: ( (lv_idValue_0_0= RULE_ID ) )
                    // PsiInternalTerminalRulesTestLanguage.g:63:4: (lv_idValue_0_0= RULE_ID )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:63:4: (lv_idValue_0_0= RULE_ID )
                    // PsiInternalTerminalRulesTestLanguage.g:64:5: lv_idValue_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getModel_IdValueIDTerminalRuleCall_0_0ElementType());
                    				
                    lv_idValue_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_idValue_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalTerminalRulesTestLanguage.g:80:3: ( (lv_intValue_1_0= RULE_INT ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:80:3: ( (lv_intValue_1_0= RULE_INT ) )
                    // PsiInternalTerminalRulesTestLanguage.g:81:4: (lv_intValue_1_0= RULE_INT )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:81:4: (lv_intValue_1_0= RULE_INT )
                    // PsiInternalTerminalRulesTestLanguage.g:82:5: lv_intValue_1_0= RULE_INT
                    {

                    					markLeaf(elementTypeProvider.getModel_IntValueINTTerminalRuleCall_1_0ElementType());
                    				
                    lv_intValue_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_intValue_1_0);
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalTerminalRulesTestLanguage.g:98:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:98:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // PsiInternalTerminalRulesTestLanguage.g:99:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:99:4: (lv_stringValue_2_0= RULE_STRING )
                    // PsiInternalTerminalRulesTestLanguage.g:100:5: lv_stringValue_2_0= RULE_STRING
                    {

                    					markLeaf(elementTypeProvider.getModel_StringValueSTRINGTerminalRuleCall_2_0ElementType());
                    				
                    lv_stringValue_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_stringValue_2_0);
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalTerminalRulesTestLanguage.g:116:3: ( (lv_richStringValue_3_0= RULE_RICH_STRING ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:116:3: ( (lv_richStringValue_3_0= RULE_RICH_STRING ) )
                    // PsiInternalTerminalRulesTestLanguage.g:117:4: (lv_richStringValue_3_0= RULE_RICH_STRING )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:117:4: (lv_richStringValue_3_0= RULE_RICH_STRING )
                    // PsiInternalTerminalRulesTestLanguage.g:118:5: lv_richStringValue_3_0= RULE_RICH_STRING
                    {

                    					markLeaf(elementTypeProvider.getModel_RichStringValueRICH_STRINGTerminalRuleCall_3_0ElementType());
                    				
                    lv_richStringValue_3_0=(Token)match(input,RULE_RICH_STRING,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_richStringValue_3_0);
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalTerminalRulesTestLanguage.g:134:3: ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:134:3: ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) )
                    // PsiInternalTerminalRulesTestLanguage.g:135:4: (lv_mlCommentValue_4_0= RULE_ML_COMMENT )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:135:4: (lv_mlCommentValue_4_0= RULE_ML_COMMENT )
                    // PsiInternalTerminalRulesTestLanguage.g:136:5: lv_mlCommentValue_4_0= RULE_ML_COMMENT
                    {

                    					markLeaf(elementTypeProvider.getModel_MlCommentValueML_COMMENTTerminalRuleCall_4_0ElementType());
                    				
                    lv_mlCommentValue_4_0=(Token)match(input,RULE_ML_COMMENT,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_mlCommentValue_4_0);
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalTerminalRulesTestLanguage.g:152:3: ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:152:3: ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) )
                    // PsiInternalTerminalRulesTestLanguage.g:153:4: (lv_slCommentValue_5_0= RULE_SL_COMMENT )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:153:4: (lv_slCommentValue_5_0= RULE_SL_COMMENT )
                    // PsiInternalTerminalRulesTestLanguage.g:154:5: lv_slCommentValue_5_0= RULE_SL_COMMENT
                    {

                    					markLeaf(elementTypeProvider.getModel_SlCommentValueSL_COMMENTTerminalRuleCall_5_0ElementType());
                    				
                    lv_slCommentValue_5_0=(Token)match(input,RULE_SL_COMMENT,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_slCommentValue_5_0);
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalTerminalRulesTestLanguage.g:170:3: ( (lv_wsValue_6_0= RULE_WS ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:170:3: ( (lv_wsValue_6_0= RULE_WS ) )
                    // PsiInternalTerminalRulesTestLanguage.g:171:4: (lv_wsValue_6_0= RULE_WS )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:171:4: (lv_wsValue_6_0= RULE_WS )
                    // PsiInternalTerminalRulesTestLanguage.g:172:5: lv_wsValue_6_0= RULE_WS
                    {

                    					markLeaf(elementTypeProvider.getModel_WsValueWSTerminalRuleCall_6_0ElementType());
                    				
                    lv_wsValue_6_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_wsValue_6_0);
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalTerminalRulesTestLanguage.g:188:3: ( (lv_anyValue_7_0= RULE_ANY_OTHER ) )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:188:3: ( (lv_anyValue_7_0= RULE_ANY_OTHER ) )
                    // PsiInternalTerminalRulesTestLanguage.g:189:4: (lv_anyValue_7_0= RULE_ANY_OTHER )
                    {
                    // PsiInternalTerminalRulesTestLanguage.g:189:4: (lv_anyValue_7_0= RULE_ANY_OTHER )
                    // PsiInternalTerminalRulesTestLanguage.g:190:5: lv_anyValue_7_0= RULE_ANY_OTHER
                    {

                    					markLeaf(elementTypeProvider.getModel_AnyValueANY_OTHERTerminalRuleCall_7_0ElementType());
                    				
                    lv_anyValue_7_0=(Token)match(input,RULE_ANY_OTHER,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_anyValue_7_0);
                    				

                    }


                    }


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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    }


}
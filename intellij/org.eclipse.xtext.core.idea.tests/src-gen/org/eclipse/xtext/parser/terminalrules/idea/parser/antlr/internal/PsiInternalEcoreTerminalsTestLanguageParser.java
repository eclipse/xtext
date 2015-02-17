package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.terminalrules.services.EcoreTerminalsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEcoreTerminalsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_EINT", "RULE_EDOUBLE", "RULE_EDATE", "RULE_WS", "'int'", "'double'", "'date'"
    };
    public static final int RULE_EDATE=6;
    public static final int RULE_EDOUBLE=5;
    public static final int T__10=10;
    public static final int RULE_EINT=4;
    public static final int RULE_WS=7;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;

    // delegates
    // delegators


        public PsiInternalEcoreTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEcoreTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEcoreTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g"; }



    private EcoreTerminalsTestLanguageGrammarAccess grammarAccess;

    private EcoreTerminalsTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalEcoreTerminalsTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, EcoreTerminalsTestLanguageElementTypeProvider elementTypeProvider, EcoreTerminalsTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:49:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:49:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:50:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:58:1: ruleModel : ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_intValues_1_0=null;
        Token otherlv_2=null;
        Token lv_doubleValues_3_0=null;
        Token otherlv_4=null;
        Token lv_dateValues_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:58:10: ( ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:59:2: ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:59:2: ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 8:
                    {
                    alt1=1;
                    }
                    break;
                case 9:
                    {
                    alt1=2;
                    }
                    break;
                case 10:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:60:3: (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:60:3: (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:61:4: otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleModel89); 

            	    				doneLeaf(otherlv_0, elementTypeProvider.getModel_IntKeyword_0_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:68:4: ( (lv_intValues_1_0= RULE_EINT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:69:5: (lv_intValues_1_0= RULE_EINT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:69:5: (lv_intValues_1_0= RULE_EINT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:70:6: lv_intValues_1_0= RULE_EINT
            	    {

            	    						markLeaf();
            	    					
            	    lv_intValues_1_0=(Token)match(input,RULE_EINT,FollowSets000.FOLLOW_RULE_EINT_in_ruleModel121); 

            	    						doneLeaf(lv_intValues_1_0, elementTypeProvider.getModel_IntValuesEINTTerminalRuleCall_0_1_0ElementType());
            	    					

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:81:3: (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:81:3: (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:82:4: otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleModel167); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getModel_DoubleKeyword_1_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:89:4: ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:90:5: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:90:5: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:91:6: lv_doubleValues_3_0= RULE_EDOUBLE
            	    {

            	    						markLeaf();
            	    					
            	    lv_doubleValues_3_0=(Token)match(input,RULE_EDOUBLE,FollowSets000.FOLLOW_RULE_EDOUBLE_in_ruleModel199); 

            	    						doneLeaf(lv_doubleValues_3_0, elementTypeProvider.getModel_DoubleValuesEDOUBLETerminalRuleCall_1_1_0ElementType());
            	    					

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:102:3: (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:102:3: (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:103:4: otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_4=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleModel245); 

            	    				doneLeaf(otherlv_4, elementTypeProvider.getModel_DateKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:110:4: ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:111:5: (lv_dateValues_5_0= RULE_EDATE )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:111:5: (lv_dateValues_5_0= RULE_EDATE )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalEcoreTerminalsTestLanguage.g:112:6: lv_dateValues_5_0= RULE_EDATE
            	    {

            	    						markLeaf();
            	    					
            	    lv_dateValues_5_0=(Token)match(input,RULE_EDATE,FollowSets000.FOLLOW_RULE_EDATE_in_ruleModel277); 

            	    						doneLeaf(lv_dateValues_5_0, elementTypeProvider.getModel_DateValuesEDATETerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleModel89 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_EINT_in_ruleModel121 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_9_in_ruleModel167 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_EDOUBLE_in_ruleModel199 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_10_in_ruleModel245 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_EDATE_in_ruleModel277 = new BitSet(new long[]{0x0000000000000702L});
    }


}
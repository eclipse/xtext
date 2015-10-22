package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalEcoreTerminalsTestLanguage.g"; }



    	protected EcoreTerminalsTestLanguageGrammarAccess grammarAccess;

    	protected EcoreTerminalsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEcoreTerminalsTestLanguageParser(PsiBuilder builder, TokenStream input, EcoreTerminalsTestLanguageElementTypeProvider elementTypeProvider, EcoreTerminalsTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalEcoreTerminalsTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalEcoreTerminalsTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalEcoreTerminalsTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalEcoreTerminalsTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_intValues_1_0=null;
        Token otherlv_2=null;
        Token lv_doubleValues_3_0=null;
        Token otherlv_4=null;
        Token lv_dateValues_5_0=null;

        try {
            // PsiInternalEcoreTerminalsTestLanguage.g:60:1: ( ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* )
            // PsiInternalEcoreTerminalsTestLanguage.g:61:2: ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
            {
            // PsiInternalEcoreTerminalsTestLanguage.g:61:2: ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
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
            	    // PsiInternalEcoreTerminalsTestLanguage.g:62:3: (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    {
            	    // PsiInternalEcoreTerminalsTestLanguage.g:62:3: (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:63:4: otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) )
            	    {

            	    				markLeaf(elementTypeProvider.getModel_IntKeyword_0_0ElementType());
            	    			
            	    otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_0);
            	    			
            	    // PsiInternalEcoreTerminalsTestLanguage.g:70:4: ( (lv_intValues_1_0= RULE_EINT ) )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:71:5: (lv_intValues_1_0= RULE_EINT )
            	    {
            	    // PsiInternalEcoreTerminalsTestLanguage.g:71:5: (lv_intValues_1_0= RULE_EINT )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:72:6: lv_intValues_1_0= RULE_EINT
            	    {

            	    						markLeaf(elementTypeProvider.getModel_IntValuesEINTTerminalRuleCall_0_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_intValues_1_0=(Token)match(input,RULE_EINT,FollowSets000.FOLLOW_4); 

            	    						doneLeaf(lv_intValues_1_0);
            	    					

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalEcoreTerminalsTestLanguage.g:89:3: (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    {
            	    // PsiInternalEcoreTerminalsTestLanguage.g:89:3: (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:90:4: otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    {

            	    				markLeaf(elementTypeProvider.getModel_DoubleKeyword_1_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_5); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalEcoreTerminalsTestLanguage.g:97:4: ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:98:5: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    {
            	    // PsiInternalEcoreTerminalsTestLanguage.g:98:5: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:99:6: lv_doubleValues_3_0= RULE_EDOUBLE
            	    {

            	    						markLeaf(elementTypeProvider.getModel_DoubleValuesEDOUBLETerminalRuleCall_1_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_doubleValues_3_0=(Token)match(input,RULE_EDOUBLE,FollowSets000.FOLLOW_4); 

            	    						doneLeaf(lv_doubleValues_3_0);
            	    					

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalEcoreTerminalsTestLanguage.g:116:3: (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    {
            	    // PsiInternalEcoreTerminalsTestLanguage.g:116:3: (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:117:4: otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    {

            	    				markLeaf(elementTypeProvider.getModel_DateKeyword_2_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,10,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalEcoreTerminalsTestLanguage.g:124:4: ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:125:5: (lv_dateValues_5_0= RULE_EDATE )
            	    {
            	    // PsiInternalEcoreTerminalsTestLanguage.g:125:5: (lv_dateValues_5_0= RULE_EDATE )
            	    // PsiInternalEcoreTerminalsTestLanguage.g:126:6: lv_dateValues_5_0= RULE_EDATE
            	    {

            	    						markLeaf(elementTypeProvider.getModel_DateValuesEDATETerminalRuleCall_2_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_dateValues_5_0=(Token)match(input,RULE_EDATE,FollowSets000.FOLLOW_4); 

            	    						doneLeaf(lv_dateValues_5_0);
            	    					

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
        return current;
    }
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000040L});
    }


}
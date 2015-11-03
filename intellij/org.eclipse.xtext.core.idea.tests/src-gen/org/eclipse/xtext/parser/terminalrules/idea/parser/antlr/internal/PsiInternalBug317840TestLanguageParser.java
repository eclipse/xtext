package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.Bug317840TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug317840TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug317840TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug317840TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug317840TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug317840TestLanguage.g"; }



    	protected Bug317840TestLanguageGrammarAccess grammarAccess;

    	protected Bug317840TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug317840TestLanguageParser(PsiBuilder builder, TokenStream input, Bug317840TestLanguageElementTypeProvider elementTypeProvider, Bug317840TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBug317840TestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug317840TestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug317840TestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug317840TestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;


        try {
            // PsiInternalBug317840TestLanguage.g:60:1: ( ( (lv_elements_0_0= ruleElement ) )* )
            // PsiInternalBug317840TestLanguage.g:61:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // PsiInternalBug317840TestLanguage.g:61:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug317840TestLanguage.g:62:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalBug317840TestLanguage.g:62:3: (lv_elements_0_0= ruleElement )
            	    // PsiInternalBug317840TestLanguage.g:63:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

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


    // $ANTLR start "entryRuleElement"
    // PsiInternalBug317840TestLanguage.g:79:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalBug317840TestLanguage.g:79:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalBug317840TestLanguage.g:80:2: iv_ruleElement= ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalBug317840TestLanguage.g:86:1: ruleElement returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_first_1_0 = null;

        Boolean lv_second_2_0 = null;

        Boolean lv_third_3_0 = null;

        Boolean lv_forth_4_0 = null;


        try {
            // PsiInternalBug317840TestLanguage.g:87:1: ( (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) )
            // PsiInternalBug317840TestLanguage.g:88:2: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            {
            // PsiInternalBug317840TestLanguage.g:88:2: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            // PsiInternalBug317840TestLanguage.g:89:3: otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            {

            			markLeaf(elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug317840TestLanguage.g:96:3: ( (lv_first_1_0= ruleNamed ) )
            // PsiInternalBug317840TestLanguage.g:97:4: (lv_first_1_0= ruleNamed )
            {
            // PsiInternalBug317840TestLanguage.g:97:4: (lv_first_1_0= ruleNamed )
            // PsiInternalBug317840TestLanguage.g:98:5: lv_first_1_0= ruleNamed
            {

            					markComposite(elementTypeProvider.getElement_FirstNamedParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_5);
            lv_first_1_0=ruleNamed();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalBug317840TestLanguage.g:111:3: ( (lv_second_2_0= ruleNamed ) )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // PsiInternalBug317840TestLanguage.g:112:4: (lv_second_2_0= ruleNamed )
                    {
                    // PsiInternalBug317840TestLanguage.g:112:4: (lv_second_2_0= ruleNamed )
                    // PsiInternalBug317840TestLanguage.g:113:5: lv_second_2_0= ruleNamed
                    {

                    					markComposite(elementTypeProvider.getElement_SecondNamedParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_second_2_0=ruleNamed();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalBug317840TestLanguage.g:126:3: ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalBug317840TestLanguage.g:127:4: ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) )
            	    {
            	    // PsiInternalBug317840TestLanguage.g:127:4: ( (lv_third_3_0= ruleNamed ) )
            	    // PsiInternalBug317840TestLanguage.g:128:5: (lv_third_3_0= ruleNamed )
            	    {
            	    // PsiInternalBug317840TestLanguage.g:128:5: (lv_third_3_0= ruleNamed )
            	    // PsiInternalBug317840TestLanguage.g:129:6: lv_third_3_0= ruleNamed
            	    {

            	    						markComposite(elementTypeProvider.getElement_ThirdNamedParserRuleCall_3_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_third_3_0=ruleNamed();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }

            	    // PsiInternalBug317840TestLanguage.g:142:4: ( (lv_forth_4_0= ruleNamed ) )
            	    // PsiInternalBug317840TestLanguage.g:143:5: (lv_forth_4_0= ruleNamed )
            	    {
            	    // PsiInternalBug317840TestLanguage.g:143:5: (lv_forth_4_0= ruleNamed )
            	    // PsiInternalBug317840TestLanguage.g:144:6: lv_forth_4_0= ruleNamed
            	    {

            	    						markComposite(elementTypeProvider.getElement_ForthNamedParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_forth_4_0=ruleNamed();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleNamed"
    // PsiInternalBug317840TestLanguage.g:162:1: entryRuleNamed returns [Boolean current=false] : iv_ruleNamed= ruleNamed EOF ;
    public final Boolean entryRuleNamed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamed = null;


        try {
            // PsiInternalBug317840TestLanguage.g:162:47: (iv_ruleNamed= ruleNamed EOF )
            // PsiInternalBug317840TestLanguage.g:163:2: iv_ruleNamed= ruleNamed EOF
            {
             markComposite(elementTypeProvider.getNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamed=ruleNamed();

            state._fsp--;

             current =iv_ruleNamed; 
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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // PsiInternalBug317840TestLanguage.g:169:1: ruleNamed returns [Boolean current=false] : ( (lv_name_0_0= ruleNAME ) ) ;
    public final Boolean ruleNamed() throws RecognitionException {
        Boolean current = false;

        Boolean lv_name_0_0 = null;


        try {
            // PsiInternalBug317840TestLanguage.g:170:1: ( ( (lv_name_0_0= ruleNAME ) ) )
            // PsiInternalBug317840TestLanguage.g:171:2: ( (lv_name_0_0= ruleNAME ) )
            {
            // PsiInternalBug317840TestLanguage.g:171:2: ( (lv_name_0_0= ruleNAME ) )
            // PsiInternalBug317840TestLanguage.g:172:3: (lv_name_0_0= ruleNAME )
            {
            // PsiInternalBug317840TestLanguage.g:172:3: (lv_name_0_0= ruleNAME )
            // PsiInternalBug317840TestLanguage.g:173:4: lv_name_0_0= ruleNAME
            {

            				markComposite(elementTypeProvider.getNamed_NameNAMEParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=ruleNAME();

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
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleNAME"
    // PsiInternalBug317840TestLanguage.g:189:1: entryRuleNAME returns [Boolean current=false] : iv_ruleNAME= ruleNAME EOF ;
    public final Boolean entryRuleNAME() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNAME = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalBug317840TestLanguage.g:191:2: (iv_ruleNAME= ruleNAME EOF )
            // PsiInternalBug317840TestLanguage.g:192:2: iv_ruleNAME= ruleNAME EOF
            {
             markComposite(elementTypeProvider.getNAMEElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNAME=ruleNAME();

            state._fsp--;

             current =iv_ruleNAME; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNAME"


    // $ANTLR start "ruleNAME"
    // PsiInternalBug317840TestLanguage.g:201:1: ruleNAME returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleNAME() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalBug317840TestLanguage.g:204:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalBug317840TestLanguage.g:205:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalBug317840TestLanguage.g:205:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalBug317840TestLanguage.g:206:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getNAME_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalBug317840TestLanguage.g:213:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalBug317840TestLanguage.g:214:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getNAME_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getNAME_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(this_ID_2);
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNAME"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\2\1\5\2\uffff\1\2\1\uffff\1\5\1\uffff\1\5\1\2\1\uffff\1\5";
    static final String dfa_3s = "\2\4\1\uffff\2\4\1\uffff\6\4";
    static final String dfa_4s = "\1\13\1\14\1\uffff\1\4\1\14\1\uffff\1\14\1\4\2\14\1\4\1\14";
    static final String dfa_5s = "\2\uffff\1\2\2\uffff\1\1\6\uffff";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\6\uffff\1\2",
            "\1\4\6\uffff\1\5\1\3",
            "",
            "\1\6",
            "\1\10\6\uffff\1\2\1\7",
            "",
            "\1\4\6\uffff\1\5\1\3",
            "\1\11",
            "\1\4\6\uffff\1\5\1\12",
            "\1\10\6\uffff\1\2\1\7",
            "\1\13",
            "\1\4\6\uffff\1\5\1\12"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "111:3: ( (lv_second_2_0= ruleNamed ) )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    }


}
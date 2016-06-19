package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.terminalrules.services.Bug317840TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug317840TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug317840TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug317840TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug317840TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug317840TestLanguage.g"; }



     	private Bug317840TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug317840TestLanguageParser(TokenStream input, Bug317840TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug317840TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug317840TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug317840TestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug317840TestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug317840TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug317840TestLanguage.g:79:28: ( ( (lv_elements_0_0= ruleElement ) )* )
            // InternalBug317840TestLanguage.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // InternalBug317840TestLanguage.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug317840TestLanguage.g:81:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalBug317840TestLanguage.g:81:1: (lv_elements_0_0= ruleElement )
            	    // InternalBug317840TestLanguage.g:82:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // InternalBug317840TestLanguage.g:106:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalBug317840TestLanguage.g:107:2: (iv_ruleElement= ruleElement EOF )
            // InternalBug317840TestLanguage.g:108:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalBug317840TestLanguage.g:115:1: ruleElement returns [EObject current=null] : (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_first_1_0 = null;

        EObject lv_second_2_0 = null;

        EObject lv_third_3_0 = null;

        EObject lv_forth_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBug317840TestLanguage.g:118:28: ( (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) )
            // InternalBug317840TestLanguage.g:119:1: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            {
            // InternalBug317840TestLanguage.g:119:1: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            // InternalBug317840TestLanguage.g:119:3: otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getElementAccess().getElementKeyword_0());
                
            // InternalBug317840TestLanguage.g:123:1: ( (lv_first_1_0= ruleNamed ) )
            // InternalBug317840TestLanguage.g:124:1: (lv_first_1_0= ruleNamed )
            {
            // InternalBug317840TestLanguage.g:124:1: (lv_first_1_0= ruleNamed )
            // InternalBug317840TestLanguage.g:125:3: lv_first_1_0= ruleNamed
            {
             
            	        newCompositeNode(grammarAccess.getElementAccess().getFirstNamedParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_first_1_0=ruleNamed();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getElementRule());
            	        }
                   		set(
                   			current, 
                   			"first",
                    		lv_first_1_0, 
                    		"org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage.Named");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug317840TestLanguage.g:141:2: ( (lv_second_2_0= ruleNamed ) )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalBug317840TestLanguage.g:142:1: (lv_second_2_0= ruleNamed )
                    {
                    // InternalBug317840TestLanguage.g:142:1: (lv_second_2_0= ruleNamed )
                    // InternalBug317840TestLanguage.g:143:3: lv_second_2_0= ruleNamed
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getSecondNamedParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_second_2_0=ruleNamed();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	        }
                           		set(
                           			current, 
                           			"second",
                            		lv_second_2_0, 
                            		"org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage.Named");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalBug317840TestLanguage.g:159:3: ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug317840TestLanguage.g:159:4: ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) )
            	    {
            	    // InternalBug317840TestLanguage.g:159:4: ( (lv_third_3_0= ruleNamed ) )
            	    // InternalBug317840TestLanguage.g:160:1: (lv_third_3_0= ruleNamed )
            	    {
            	    // InternalBug317840TestLanguage.g:160:1: (lv_third_3_0= ruleNamed )
            	    // InternalBug317840TestLanguage.g:161:3: lv_third_3_0= ruleNamed
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getThirdNamedParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_third_3_0=ruleNamed();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"third",
            	            		lv_third_3_0, 
            	            		"org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage.Named");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalBug317840TestLanguage.g:177:2: ( (lv_forth_4_0= ruleNamed ) )
            	    // InternalBug317840TestLanguage.g:178:1: (lv_forth_4_0= ruleNamed )
            	    {
            	    // InternalBug317840TestLanguage.g:178:1: (lv_forth_4_0= ruleNamed )
            	    // InternalBug317840TestLanguage.g:179:3: lv_forth_4_0= ruleNamed
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getForthNamedParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_forth_4_0=ruleNamed();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"forth",
            	            		lv_forth_4_0, 
            	            		"org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage.Named");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleNamed"
    // InternalBug317840TestLanguage.g:203:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // InternalBug317840TestLanguage.g:204:2: (iv_ruleNamed= ruleNamed EOF )
            // InternalBug317840TestLanguage.g:205:2: iv_ruleNamed= ruleNamed EOF
            {
             newCompositeNode(grammarAccess.getNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamed=ruleNamed();

            state._fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // InternalBug317840TestLanguage.g:212:1: ruleNamed returns [EObject current=null] : ( (lv_name_0_0= ruleNAME ) ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug317840TestLanguage.g:215:28: ( ( (lv_name_0_0= ruleNAME ) ) )
            // InternalBug317840TestLanguage.g:216:1: ( (lv_name_0_0= ruleNAME ) )
            {
            // InternalBug317840TestLanguage.g:216:1: ( (lv_name_0_0= ruleNAME ) )
            // InternalBug317840TestLanguage.g:217:1: (lv_name_0_0= ruleNAME )
            {
            // InternalBug317840TestLanguage.g:217:1: (lv_name_0_0= ruleNAME )
            // InternalBug317840TestLanguage.g:218:3: lv_name_0_0= ruleNAME
            {
             
            	        newCompositeNode(grammarAccess.getNamedAccess().getNameNAMEParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=ruleNAME();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage.NAME");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleNAME"
    // InternalBug317840TestLanguage.g:242:1: entryRuleNAME returns [String current=null] : iv_ruleNAME= ruleNAME EOF ;
    public final String entryRuleNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNAME = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalBug317840TestLanguage.g:246:2: (iv_ruleNAME= ruleNAME EOF )
            // InternalBug317840TestLanguage.g:247:2: iv_ruleNAME= ruleNAME EOF
            {
             newCompositeNode(grammarAccess.getNAMERule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNAME=ruleNAME();

            state._fsp--;

             current =iv_ruleNAME.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNAME"


    // $ANTLR start "ruleNAME"
    // InternalBug317840TestLanguage.g:257:1: ruleNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalBug317840TestLanguage.g:261:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalBug317840TestLanguage.g:262:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalBug317840TestLanguage.g:262:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalBug317840TestLanguage.g:262:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getNAMEAccess().getIDTerminalRuleCall_0()); 
                
            // InternalBug317840TestLanguage.g:269:1: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug317840TestLanguage.g:270:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getNAMEAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getNAMEAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
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
            return "141:2: ( (lv_second_2_0= ruleNamed ) )?";
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
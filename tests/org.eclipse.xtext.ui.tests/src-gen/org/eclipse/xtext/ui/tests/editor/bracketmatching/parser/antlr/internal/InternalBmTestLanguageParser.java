package org.eclipse.xtext.ui.tests.editor.bracketmatching.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.services.BmTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBmTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "')'", "'begin'", "'end'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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


        public InternalBmTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBmTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBmTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBmTestLanguage.g"; }



     	private BmTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBmTestLanguageParser(TokenStream input, BmTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected BmTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFile"
    // InternalBmTestLanguage.g:67:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // InternalBmTestLanguage.g:68:2: (iv_ruleFile= ruleFile EOF )
            // InternalBmTestLanguage.g:69:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalBmTestLanguage.g:76:1: ruleFile returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBmTestLanguage.g:79:28: ( ( (lv_expression_0_0= ruleExpression ) )* )
            // InternalBmTestLanguage.g:80:1: ( (lv_expression_0_0= ruleExpression ) )*
            {
            // InternalBmTestLanguage.g:80:1: ( (lv_expression_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||LA1_0==11||LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBmTestLanguage.g:81:1: (lv_expression_0_0= ruleExpression )
            	    {
            	    // InternalBmTestLanguage.g:81:1: (lv_expression_0_0= ruleExpression )
            	    // InternalBmTestLanguage.g:82:3: lv_expression_0_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFileAccess().getExpressionExpressionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_expression_0_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expression",
            	            		lv_expression_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage.Expression");
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
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleExpression"
    // InternalBmTestLanguage.g:106:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalBmTestLanguage.g:107:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalBmTestLanguage.g:108:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalBmTestLanguage.g:115:1: ruleExpression returns [EObject current=null] : (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_SExpression_0 = null;

        EObject this_Atom_1 = null;

        EObject this_Expression_3 = null;


         enterRule(); 
            
        try {
            // InternalBmTestLanguage.g:118:28: ( (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) ) )
            // InternalBmTestLanguage.g:119:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) )
            {
            // InternalBmTestLanguage.g:119:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBmTestLanguage.g:120:5: this_SExpression_0= ruleSExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SExpression_0=ruleSExpression();

                    state._fsp--;

                     
                            current = this_SExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBmTestLanguage.g:130:5: this_Atom_1= ruleAtom
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Atom_1=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalBmTestLanguage.g:139:6: (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' )
                    {
                    // InternalBmTestLanguage.g:139:6: (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' )
                    // InternalBmTestLanguage.g:139:8: otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0());
                        
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_5);
                    this_Expression_3=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2());
                        

                    }


                    }
                    break;

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleSExpression"
    // InternalBmTestLanguage.g:164:1: entryRuleSExpression returns [EObject current=null] : iv_ruleSExpression= ruleSExpression EOF ;
    public final EObject entryRuleSExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSExpression = null;


        try {
            // InternalBmTestLanguage.g:165:2: (iv_ruleSExpression= ruleSExpression EOF )
            // InternalBmTestLanguage.g:166:2: iv_ruleSExpression= ruleSExpression EOF
            {
             newCompositeNode(grammarAccess.getSExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSExpression=ruleSExpression();

            state._fsp--;

             current =iv_ruleSExpression; 
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
    // $ANTLR end "entryRuleSExpression"


    // $ANTLR start "ruleSExpression"
    // InternalBmTestLanguage.g:173:1: ruleSExpression returns [EObject current=null] : ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) ) ;
    public final EObject ruleSExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_element_2_0 = null;

        EObject lv_element_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBmTestLanguage.g:176:28: ( ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) ) )
            // InternalBmTestLanguage.g:177:1: ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) )
            {
            // InternalBmTestLanguage.g:177:1: ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) )
            // InternalBmTestLanguage.g:177:2: () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) )
            {
            // InternalBmTestLanguage.g:177:2: ()
            // InternalBmTestLanguage.g:178:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSExpressionAccess().getSExpressionAction_0(),
                        current);
                

            }

            // InternalBmTestLanguage.g:183:2: ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBmTestLanguage.g:183:3: (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' )
                    {
                    // InternalBmTestLanguage.g:183:3: (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' )
                    // InternalBmTestLanguage.g:183:5: otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_1, grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0());
                        
                    // InternalBmTestLanguage.g:187:1: ( (lv_element_2_0= ruleExpression ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)||LA3_0==11||LA3_0==13||LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBmTestLanguage.g:188:1: (lv_element_2_0= ruleExpression )
                    	    {
                    	    // InternalBmTestLanguage.g:188:1: (lv_element_2_0= ruleExpression )
                    	    // InternalBmTestLanguage.g:189:3: lv_element_2_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_0_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_element_2_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"element",
                    	            		lv_element_2_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage.Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_3, grammarAccess.getSExpressionAccess().getRightParenthesisKeyword_1_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBmTestLanguage.g:210:6: (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' )
                    {
                    // InternalBmTestLanguage.g:210:6: (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' )
                    // InternalBmTestLanguage.g:210:8: otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end'
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_4, grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0());
                        
                    // InternalBmTestLanguage.g:214:1: ( (lv_element_5_0= ruleExpression ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)||LA4_0==11||LA4_0==13||LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBmTestLanguage.g:215:1: (lv_element_5_0= ruleExpression )
                    	    {
                    	    // InternalBmTestLanguage.g:215:1: (lv_element_5_0= ruleExpression )
                    	    // InternalBmTestLanguage.g:216:3: lv_element_5_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_7);
                    	    lv_element_5_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"element",
                    	            		lv_element_5_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage.Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_6, grammarAccess.getSExpressionAccess().getEndKeyword_1_1_2());
                        

                    }


                    }
                    break;

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
    // $ANTLR end "ruleSExpression"


    // $ANTLR start "entryRuleAtom"
    // InternalBmTestLanguage.g:244:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalBmTestLanguage.g:245:2: (iv_ruleAtom= ruleAtom EOF )
            // InternalBmTestLanguage.g:246:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalBmTestLanguage.g:253:1: ruleAtom returns [EObject current=null] : ( (lv_value_0_0= ruleVALUE ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBmTestLanguage.g:256:28: ( ( (lv_value_0_0= ruleVALUE ) ) )
            // InternalBmTestLanguage.g:257:1: ( (lv_value_0_0= ruleVALUE ) )
            {
            // InternalBmTestLanguage.g:257:1: ( (lv_value_0_0= ruleVALUE ) )
            // InternalBmTestLanguage.g:258:1: (lv_value_0_0= ruleVALUE )
            {
            // InternalBmTestLanguage.g:258:1: (lv_value_0_0= ruleVALUE )
            // InternalBmTestLanguage.g:259:3: lv_value_0_0= ruleVALUE
            {
             
            	        newCompositeNode(grammarAccess.getAtomAccess().getValueVALUEParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleVALUE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAtomRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage.VALUE");
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
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleVALUE"
    // InternalBmTestLanguage.g:283:1: entryRuleVALUE returns [String current=null] : iv_ruleVALUE= ruleVALUE EOF ;
    public final String entryRuleVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE = null;


        try {
            // InternalBmTestLanguage.g:284:2: (iv_ruleVALUE= ruleVALUE EOF )
            // InternalBmTestLanguage.g:285:2: iv_ruleVALUE= ruleVALUE EOF
            {
             newCompositeNode(grammarAccess.getVALUERule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVALUE=ruleVALUE();

            state._fsp--;

             current =iv_ruleVALUE.getText(); 
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
    // $ANTLR end "entryRuleVALUE"


    // $ANTLR start "ruleVALUE"
    // InternalBmTestLanguage.g:292:1: ruleVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;

         enterRule(); 
            
        try {
            // InternalBmTestLanguage.g:295:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING ) )
            // InternalBmTestLanguage.g:296:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )
            {
            // InternalBmTestLanguage.g:296:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt6=1;
                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case RULE_STRING:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalBmTestLanguage.g:296:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalBmTestLanguage.g:304:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalBmTestLanguage.g:312:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    		current.merge(this_STRING_2);
                        
                     
                        newLeafNode(this_STRING_2, grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                        

                    }
                    break;

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
    // $ANTLR end "ruleVALUE"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000A872L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000B870L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001A870L});
    }


}
package org.eclipse.xtext.ui.tests.editor.bracketmatching.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBmTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBmTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBmTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g"; }



     	private BmTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBmTestLanguageParser(TokenStream input, IAstFactory factory, BmTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:70:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:71:2: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:72:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFile_in_entryRuleFile75);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFile85); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:79:1: ruleFile returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:82:28: ( ( (lv_expression_0_0= ruleExpression ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:83:1: ( (lv_expression_0_0= ruleExpression ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:83:1: ( (lv_expression_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||LA1_0==11||LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:84:1: (lv_expression_0_0= ruleExpression )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:84:1: (lv_expression_0_0= ruleExpression )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:85:3: lv_expression_0_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFileAccess().getExpressionExpressionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleFile130);
            	    lv_expression_0_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expression",
            	            		lv_expression_0_0, 
            	            		"Expression");
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:109:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:110:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:111:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression166);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression176); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:118:1: ruleExpression returns [EObject current=null] : (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_SExpression_0 = null;

        EObject this_Atom_1 = null;

        EObject this_Expression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:121:28: ( (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:122:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:122:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:123:5: this_SExpression_0= ruleSExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSExpression_in_ruleExpression223);
                    this_SExpression_0=ruleSExpression();

                    state._fsp--;

                     
                            current = this_SExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:133:5: this_Atom_1= ruleAtom
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleExpression250);
                    this_Atom_1=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:142:6: (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:142:6: (otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:142:8: otherlv_2= '[' this_Expression_3= ruleExpression otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExpression268); 

                        	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0());
                        
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleExpression290);
                    this_Expression_3=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExpression301); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:167:1: entryRuleSExpression returns [EObject current=null] : iv_ruleSExpression= ruleSExpression EOF ;
    public final EObject entryRuleSExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSExpression = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:168:2: (iv_ruleSExpression= ruleSExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:169:2: iv_ruleSExpression= ruleSExpression EOF
            {
             newCompositeNode(grammarAccess.getSExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSExpression_in_entryRuleSExpression338);
            iv_ruleSExpression=ruleSExpression();

            state._fsp--;

             current =iv_ruleSExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSExpression348); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:176:1: ruleSExpression returns [EObject current=null] : ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) ) ;
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:179:28: ( ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:180:1: ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:180:1: ( () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:180:2: () ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:180:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:181:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSExpressionAccess().getSExpressionAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:186:2: ( (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' ) | (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:186:3: (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:186:3: (otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:186:5: otherlv_1= '(' ( (lv_element_2_0= ruleExpression ) )* otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSExpression396); 

                        	newLeafNode(otherlv_1, grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:190:1: ( (lv_element_2_0= ruleExpression ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)||LA3_0==11||LA3_0==13||LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:191:1: (lv_element_2_0= ruleExpression )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:191:1: (lv_element_2_0= ruleExpression )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:192:3: lv_element_2_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_0_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSExpression417);
                    	    lv_element_2_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"element",
                    	            		lv_element_2_0, 
                    	            		"Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSExpression430); 

                        	newLeafNode(otherlv_3, grammarAccess.getSExpressionAccess().getRightParenthesisKeyword_1_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:213:6: (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:213:6: (otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:213:8: otherlv_4= 'begin' ( (lv_element_5_0= ruleExpression ) )* otherlv_6= 'end'
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSExpression450); 

                        	newLeafNode(otherlv_4, grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:217:1: ( (lv_element_5_0= ruleExpression ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)||LA4_0==11||LA4_0==13||LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:218:1: (lv_element_5_0= ruleExpression )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:218:1: (lv_element_5_0= ruleExpression )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:219:3: lv_element_5_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSExpression471);
                    	    lv_element_5_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"element",
                    	            		lv_element_5_0, 
                    	            		"Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSExpression484); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:247:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:248:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:249:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom522);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom532); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:256:1: ruleAtom returns [EObject current=null] : ( (lv_value_0_0= ruleVALUE ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:259:28: ( ( (lv_value_0_0= ruleVALUE ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:260:1: ( (lv_value_0_0= ruleVALUE ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:260:1: ( (lv_value_0_0= ruleVALUE ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:261:1: (lv_value_0_0= ruleVALUE )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:261:1: (lv_value_0_0= ruleVALUE )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:262:3: lv_value_0_0= ruleVALUE
            {
             
            	        newCompositeNode(grammarAccess.getAtomAccess().getValueVALUEParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleVALUE_in_ruleAtom577);
            lv_value_0_0=ruleVALUE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAtomRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"VALUE");
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:286:1: entryRuleVALUE returns [String current=null] : iv_ruleVALUE= ruleVALUE EOF ;
    public final String entryRuleVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:287:2: (iv_ruleVALUE= ruleVALUE EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:288:2: iv_ruleVALUE= ruleVALUE EOF
            {
             newCompositeNode(grammarAccess.getVALUERule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVALUE_in_entryRuleVALUE613);
            iv_ruleVALUE=ruleVALUE();

            state._fsp--;

             current =iv_ruleVALUE.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVALUE624); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:295:1: ruleVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:298:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:299:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:299:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:299:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVALUE664); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:307:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVALUE690); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g:315:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVALUE716); 

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
        public static final BitSet FOLLOW_ruleFile_in_entryRuleFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleFile130 = new BitSet(new long[]{0x000000000000A872L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSExpression_in_ruleExpression223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleExpression250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleExpression268 = new BitSet(new long[]{0x000000000000B870L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleExpression290 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleExpression301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSExpression_in_entryRuleSExpression338 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSExpression348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSExpression396 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSExpression417 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_14_in_ruleSExpression430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSExpression450 = new BitSet(new long[]{0x000000000001A870L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSExpression471 = new BitSet(new long[]{0x000000000001A870L});
        public static final BitSet FOLLOW_16_in_ruleSExpression484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom522 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVALUE_in_ruleAtom577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE613 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVALUE624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVALUE664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVALUE690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVALUE716 = new BitSet(new long[]{0x0000000000000002L});
    }


}
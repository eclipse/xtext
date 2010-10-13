package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalComplexReconstrTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'('", "')'", "'!'", "'TG'", "'['", "','", "']'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalComplexReconstrTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalComplexReconstrTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalComplexReconstrTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g"; }



     	private ComplexReconstrTestLanguageGrammarAccess grammarAccess;
     	
        public InternalComplexReconstrTestLanguageParser(TokenStream input, IAstFactory factory, ComplexReconstrTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected ComplexReconstrTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:71:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:72:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:73:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:80:1: ruleRoot returns [EObject current=null] : (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_Op_0 = null;

        EObject this_TrickyG_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:85:6: ( (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:86:1: (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:86:1: (this_Op_0= ruleOp | this_TrickyG_1= ruleTrickyG )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==16) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:87:5: this_Op_0= ruleOp
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getOpParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOp_in_ruleRoot132);
                    this_Op_0=ruleOp();

                    state._fsp--;

                     
                            current = this_Op_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:97:5: this_TrickyG_1= ruleTrickyG
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTrickyGParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTrickyG_in_ruleRoot159);
                    this_TrickyG_1=ruleTrickyG();

                    state._fsp--;

                     
                            current = this_TrickyG_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleOp"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:113:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:114:2: (iv_ruleOp= ruleOp EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:115:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOpRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_entryRuleOp194);
            iv_ruleOp=ruleOp();

            state._fsp--;

             current =iv_ruleOp; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOp204); 

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
    // $ANTLR end "entryRuleOp"


    // $ANTLR start "ruleOp"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:122:1: ruleOp returns [EObject current=null] : (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject this_Term_0 = null;

        EObject lv_addOperands_3_0 = null;

        EObject lv_minusOperands_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:127:6: ( (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:128:1: (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:128:1: (this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:129:5: this_Term_0= ruleTerm ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getOpAccess().getTermParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp251);
            this_Term_0=ruleTerm();

            state._fsp--;

             
                    current = this_Term_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:137:1: ( ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) ) | ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }
                else if ( (LA2_0==12) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:137:2: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:137:2: ( () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:137:3: () otherlv_2= '+' ( (lv_addOperands_3_0= ruleTerm ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:137:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:138:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getOpAccess().getAddAddOperandsAction_1_0_0().getType().getClassifier());
            	            try {
            	            	factory.add(temp, "addOperands", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getOpAccess().getAddAddOperandsAction_1_0_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleOp273); 

            	        	createLeafNode(otherlv_2, grammarAccess.getOpAccess().getPlusSignKeyword_1_0_1(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:157:1: ( (lv_addOperands_3_0= ruleTerm ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:158:1: (lv_addOperands_3_0= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:158:1: (lv_addOperands_3_0= ruleTerm )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:159:3: lv_addOperands_3_0= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOpAccess().getAddOperandsTermParserRuleCall_1_0_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp294);
            	    lv_addOperands_3_0=ruleTerm();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOpRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"addOperands",
            	    	        		lv_addOperands_3_0, 
            	    	        		"Term", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:182:6: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:182:6: ( () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:182:7: () otherlv_5= '-' ( (lv_minusOperands_6_0= ruleTerm ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:182:7: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:183:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getOpAccess().getMinusMinusOperandsAction_1_1_0().getType().getClassifier());
            	            try {
            	            	factory.add(temp, "minusOperands", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getOpAccess().getMinusMinusOperandsAction_1_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleOp323); 

            	        	createLeafNode(otherlv_5, grammarAccess.getOpAccess().getHyphenMinusKeyword_1_1_1(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:202:1: ( (lv_minusOperands_6_0= ruleTerm ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:203:1: (lv_minusOperands_6_0= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:203:1: (lv_minusOperands_6_0= ruleTerm )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:204:3: lv_minusOperands_6_0= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOpAccess().getMinusOperandsTermParserRuleCall_1_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp344);
            	    lv_minusOperands_6_0=ruleTerm();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOpRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"minusOperands",
            	    	        		lv_minusOperands_6_0, 
            	    	        		"Term", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:234:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:235:2: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:236:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTermRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_entryRuleTerm383);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerm393); 

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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:243:1: ruleTerm returns [EObject current=null] : (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject this_Parens_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:248:6: ( (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:249:1: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:249:1: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:250:5: this_Atom_0= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getAtomParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleTerm440);
                    this_Atom_0=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:260:5: this_Parens_1= ruleParens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getParensParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParens_in_ruleTerm467);
                    this_Parens_1=ruleParens();

                    state._fsp--;

                     
                            current = this_Parens_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:276:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:277:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:278:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom502);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom512); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:285:1: ruleAtom returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:290:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:291:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:291:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:292:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:292:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:293:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAtom553); 

            			createLeafNode(lv_name_0_0, grammarAccess.getAtomAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAtomRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start "entryRuleParens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:323:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:324:2: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:325:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParens_in_entryRuleParens593);
            iv_ruleParens=ruleParens();

            state._fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParens603); 

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
    // $ANTLR end "entryRuleParens"


    // $ANTLR start "ruleParens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:332:1: ruleParens returns [EObject current=null] : (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;
        EObject this_Op_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:337:6: ( (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:338:1: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:338:1: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:338:3: otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParens640); 

                	createLeafNode(otherlv_0, grammarAccess.getParensAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParensAccess().getOpParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_ruleParens662);
            this_Op_1=ruleOp();

            state._fsp--;

             
                    current = this_Op_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParens673); 

                	createLeafNode(otherlv_2, grammarAccess.getParensAccess().getRightParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:355:1: ( (lv_em_3_0= '!' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:356:1: (lv_em_3_0= '!' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:356:1: (lv_em_3_0= '!' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:357:3: lv_em_3_0= '!'
                    {
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParens691); 

                            createLeafNode(lv_em_3_0, grammarAccess.getParensAccess().getEmExclamationMarkKeyword_3_0(), "em");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParensRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "em", lv_em_3_0, "!", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParens"


    // $ANTLR start "entryRuleTrickyA1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:386:1: entryRuleTrickyA1 returns [EObject current=null] : iv_ruleTrickyA1= ruleTrickyA1 EOF ;
    public final EObject entryRuleTrickyA1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrickyA1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:387:2: (iv_ruleTrickyA1= ruleTrickyA1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:388:2: iv_ruleTrickyA1= ruleTrickyA1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrickyA1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyA1_in_entryRuleTrickyA1743);
            iv_ruleTrickyA1=ruleTrickyA1();

            state._fsp--;

             current =iv_ruleTrickyA1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyA1753); 

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
    // $ANTLR end "entryRuleTrickyA1"


    // $ANTLR start "ruleTrickyA1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:395:1: ruleTrickyA1 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleTrickyA1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:400:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:401:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:401:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:402:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:402:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:403:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTrickyA1794); 

            			createLeafNode(lv_name_0_0, grammarAccess.getTrickyA1Access().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTrickyA1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrickyA1"


    // $ANTLR start "entryRuleTrickyG"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:443:1: entryRuleTrickyG returns [EObject current=null] : iv_ruleTrickyG= ruleTrickyG EOF ;
    public final EObject entryRuleTrickyG() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrickyG = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:444:2: (iv_ruleTrickyG= ruleTrickyG EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:445:2: iv_ruleTrickyG= ruleTrickyG EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrickyGRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG_in_entryRuleTrickyG844);
            iv_ruleTrickyG=ruleTrickyG();

            state._fsp--;

             current =iv_ruleTrickyG; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyG854); 

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
    // $ANTLR end "entryRuleTrickyG"


    // $ANTLR start "ruleTrickyG"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:452:1: ruleTrickyG returns [EObject current=null] : (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) ;
    public final EObject ruleTrickyG() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_tree_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:457:6: ( (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:458:1: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:458:1: (otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:458:3: otherlv_0= 'TG' ( (lv_tree_1_0= ruleTrickyG1 ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTrickyG891); 

                	createLeafNode(otherlv_0, grammarAccess.getTrickyGAccess().getTGKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:462:1: ( (lv_tree_1_0= ruleTrickyG1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:463:1: (lv_tree_1_0= ruleTrickyG1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:463:1: (lv_tree_1_0= ruleTrickyG1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:464:3: lv_tree_1_0= ruleTrickyG1
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTrickyGAccess().getTreeTrickyG1ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG1_in_ruleTrickyG912);
            lv_tree_1_0=ruleTrickyG1();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTrickyGRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"tree",
            	        		lv_tree_1_0, 
            	        		"TrickyG1", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrickyG"


    // $ANTLR start "entryRuleTrickyG1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:494:1: entryRuleTrickyG1 returns [EObject current=null] : iv_ruleTrickyG1= ruleTrickyG1 EOF ;
    public final EObject entryRuleTrickyG1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrickyG1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:495:2: (iv_ruleTrickyG1= ruleTrickyG1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:496:2: iv_ruleTrickyG1= ruleTrickyG1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrickyG1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG1_in_entryRuleTrickyG1948);
            iv_ruleTrickyG1=ruleTrickyG1();

            state._fsp--;

             current =iv_ruleTrickyG1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyG1958); 

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
    // $ANTLR end "entryRuleTrickyG1"


    // $ANTLR start "ruleTrickyG1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:503:1: ruleTrickyG1 returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) ;
    public final EObject ruleTrickyG1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_vals_1_0 = null;

        EObject lv_vals_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:508:6: ( (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:509:1: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:509:1: (otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:509:3: otherlv_0= '[' ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTrickyG1995); 

                	createLeafNode(otherlv_0, grammarAccess.getTrickyG1Access().getLeftSquareBracketKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:513:1: ( ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT||LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:513:2: ( (lv_vals_1_0= ruleTrickyG2 ) ) (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:513:2: ( (lv_vals_1_0= ruleTrickyG2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:514:1: (lv_vals_1_0= ruleTrickyG2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:514:1: (lv_vals_1_0= ruleTrickyG2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:515:3: lv_vals_1_0= ruleTrickyG2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTrickyG1Access().getValsTrickyG2ParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTrickyG2_in_ruleTrickyG11017);
                    lv_vals_1_0=ruleTrickyG2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTrickyG1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"vals",
                    	        		lv_vals_1_0, 
                    	        		"TrickyG2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:537:2: (otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:537:4: otherlv_2= ',' ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTrickyG11030); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getTrickyG1Access().getCommaKeyword_1_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:541:1: ( (lv_vals_3_0= ruleTrickyG2 ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:542:1: (lv_vals_3_0= ruleTrickyG2 )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:542:1: (lv_vals_3_0= ruleTrickyG2 )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:543:3: lv_vals_3_0= ruleTrickyG2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTrickyG1Access().getValsTrickyG2ParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTrickyG2_in_ruleTrickyG11051);
                    	    lv_vals_3_0=ruleTrickyG2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTrickyG1Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"vals",
                    	    	        		lv_vals_3_0, 
                    	    	        		"TrickyG2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTrickyG11067); 

                	createLeafNode(otherlv_4, grammarAccess.getTrickyG1Access().getRightSquareBracketKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrickyG1"


    // $ANTLR start "entryRuleTrickyG2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:577:1: entryRuleTrickyG2 returns [EObject current=null] : iv_ruleTrickyG2= ruleTrickyG2 EOF ;
    public final EObject entryRuleTrickyG2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrickyG2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:578:2: (iv_ruleTrickyG2= ruleTrickyG2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:579:2: iv_ruleTrickyG2= ruleTrickyG2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrickyG2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTrickyG2_in_entryRuleTrickyG21103);
            iv_ruleTrickyG2=ruleTrickyG2();

            state._fsp--;

             current =iv_ruleTrickyG2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrickyG21113); 

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
    // $ANTLR end "entryRuleTrickyG2"


    // $ANTLR start "ruleTrickyG2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:586:1: ruleTrickyG2 returns [EObject current=null] : (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleTrickyG2() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        EObject this_TrickyG1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:591:6: ( (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:592:1: (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:592:1: (this_TrickyG1_0= ruleTrickyG1 | ( (lv_val_1_0= RULE_INT ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:593:5: this_TrickyG1_0= ruleTrickyG1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrickyG2Access().getTrickyG1ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTrickyG1_in_ruleTrickyG21160);
                    this_TrickyG1_0=ruleTrickyG1();

                    state._fsp--;

                     
                            current = this_TrickyG1_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:602:6: ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:602:6: ( (lv_val_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:603:1: (lv_val_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:603:1: (lv_val_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g:604:3: lv_val_1_0= RULE_INT
                    {
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTrickyG21182); 

                    			createLeafNode(lv_val_1_0, grammarAccess.getTrickyG2Access().getValINTTerminalRuleCall_1_0(), "val"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTrickyG2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val",
                    	        		lv_val_1_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrickyG2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOp_in_ruleRoot132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG_in_ruleRoot159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOp_in_entryRuleOp194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOp204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp251 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_11_in_ruleOp273 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp294 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_12_in_ruleOp323 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp344 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm383 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerm393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleTerm440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_ruleTerm467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom502 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAtom553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_entryRuleParens593 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParens603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParens640 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleOp_in_ruleParens662 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleParens673 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleParens691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyA1_in_entryRuleTrickyA1743 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyA1753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTrickyA1794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG_in_entryRuleTrickyG844 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyG854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleTrickyG891 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleTrickyG1_in_ruleTrickyG912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG1_in_entryRuleTrickyG1948 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyG1958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleTrickyG1995 = new BitSet(new long[]{0x00000000000A0020L});
        public static final BitSet FOLLOW_ruleTrickyG2_in_ruleTrickyG11017 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleTrickyG11030 = new BitSet(new long[]{0x0000000000020020L});
        public static final BitSet FOLLOW_ruleTrickyG2_in_ruleTrickyG11051 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_19_in_ruleTrickyG11067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG2_in_entryRuleTrickyG21103 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrickyG21113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrickyG1_in_ruleTrickyG21160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTrickyG21182 = new BitSet(new long[]{0x0000000000000002L});
    }


}
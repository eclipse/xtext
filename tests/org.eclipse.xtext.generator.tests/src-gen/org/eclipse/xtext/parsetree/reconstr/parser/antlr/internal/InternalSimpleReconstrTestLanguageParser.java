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
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleReconstrTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'", "'#3'", "'.'", "'#4'", "'myoption'", "'kw'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSimpleReconstrTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g"; }


     
     	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, IAstFactory factory, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Op";	
       	} 



    // $ANTLR start entryRuleOp
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:69:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:69:44: (iv_ruleOp= ruleOp EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:70:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOp().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOp_in_entryRuleOp71);
            iv_ruleOp=ruleOp();
            _fsp--;

             current =iv_ruleOp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOp81); 

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
    // $ANTLR end entryRuleOp


    // $ANTLR start ruleOp
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:77:1: ruleOp returns [EObject current=null] : (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term_0 = null;

        EObject lv_values_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:82:6: ( (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:83:1: (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:83:1: (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:84:5: this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prOp().ele0ParserRuleCallTerm(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp128);
            this_Term_0=ruleTerm();
            _fsp--;

             
                    current = this_Term_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prOp().ele0ParserRuleCallTerm(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:1: ( () (lv_values_2= ruleTerm ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||LA1_0==21||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:2: () (lv_values_2= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:2: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:97:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prOp().ele10ActionOpvalues().getTypeName().getType());
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prOp().ele10ActionOpvalues(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:112:2: (lv_values_2= ruleTerm )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:115:6: lv_values_2= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prOp().ele110ParserRuleCallTerm(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp178);
            	    lv_values_2=ruleTerm();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prOp().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "values", lv_values_2, "Term", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end ruleOp


    // $ANTLR start entryRuleTerm
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:140:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:140:46: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:141:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerm().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm217);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm227); 

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
    // $ANTLR end entryRuleTerm


    // $ANTLR start ruleTerm
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:148:1: ruleTerm returns [EObject current=null] : ( ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare ) | this_Boolean_7= ruleBoolean ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject this_TwoNumbers_1 = null;

        EObject this_ManyStrings_2 = null;

        EObject this_Parens_3 = null;

        EObject this_Type_4 = null;

        EObject this_Ref2_5 = null;

        EObject this_Spare_6 = null;

        EObject this_Boolean_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:153:6: ( ( ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare ) | this_Boolean_7= ruleBoolean ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:1: ( ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare ) | this_Boolean_7= ruleBoolean )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:1: ( ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare ) | this_Boolean_7= ruleBoolean )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||LA8_0==11||(LA8_0>=15 && LA8_0<=16)||LA8_0==18||LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("154:1: ( ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare ) | this_Boolean_7= ruleBoolean )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:2: ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:2: ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||LA7_0==11||(LA7_0>=15 && LA7_0<=16)||LA7_0==18) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==21) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("154:2: ( ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 ) | this_Spare_6= ruleSpare )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:3: ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:3: ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 )
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==11||(LA6_0>=15 && LA6_0<=16)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_0==18) ) {
                                alt6=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("154:3: ( ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType ) | this_Ref2_5= ruleRef2 )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:4: ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:4: ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType )
                                    int alt5=2;
                                    int LA5_0 = input.LA(1);

                                    if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_INT)||LA5_0==11||LA5_0==15) ) {
                                        alt5=1;
                                    }
                                    else if ( (LA5_0==16) ) {
                                        alt5=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("154:4: ( ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens ) | this_Type_4= ruleType )", 5, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt5) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:5: ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:5: ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens )
                                            int alt4=2;
                                            int LA4_0 = input.LA(1);

                                            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_INT)||LA4_0==15) ) {
                                                alt4=1;
                                            }
                                            else if ( (LA4_0==11) ) {
                                                alt4=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("154:5: ( ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings ) | this_Parens_3= ruleParens )", 4, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt4) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:6: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:6: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings )
                                                    int alt3=2;
                                                    int LA3_0 = input.LA(1);

                                                    if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_INT)) ) {
                                                        alt3=1;
                                                    }
                                                    else if ( (LA3_0==15) ) {
                                                        alt3=2;
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("154:6: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers ) | this_ManyStrings_2= ruleManyStrings )", 3, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt3) {
                                                        case 1 :
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:7: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers )
                                                            {
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:7: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers )
                                                            int alt2=2;
                                                            int LA2_0 = input.LA(1);

                                                            if ( (LA2_0==RULE_ID) ) {
                                                                alt2=1;
                                                            }
                                                            else if ( (LA2_0==RULE_INT) ) {
                                                                alt2=2;
                                                            }
                                                            else {
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("154:7: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers )", 2, 0, input);

                                                                throw nvae;
                                                            }
                                                            switch (alt2) {
                                                                case 1 :
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:155:5: this_Atom_0= ruleAtom
                                                                    {
                                                                     
                                                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele0000000ParserRuleCallAtom(), currentNode); 
                                                                        
                                                                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm280);
                                                                    this_Atom_0=ruleAtom();
                                                                    _fsp--;

                                                                     
                                                                            current = this_Atom_0; 
                                                                            currentNode = currentNode.getParent();
                                                                        
                                                                     
                                                                        createLeafNode(grammarAccess.prTerm().ele0000000ParserRuleCallAtom(), null); 
                                                                        

                                                                    }
                                                                    break;
                                                                case 2 :
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:169:5: this_TwoNumbers_1= ruleTwoNumbers
                                                                    {
                                                                     
                                                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele0000001ParserRuleCallTwoNumbers(), currentNode); 
                                                                        
                                                                    pushFollow(FOLLOW_ruleTwoNumbers_in_ruleTerm314);
                                                                    this_TwoNumbers_1=ruleTwoNumbers();
                                                                    _fsp--;

                                                                     
                                                                            current = this_TwoNumbers_1; 
                                                                            currentNode = currentNode.getParent();
                                                                        
                                                                     
                                                                        createLeafNode(grammarAccess.prTerm().ele0000001ParserRuleCallTwoNumbers(), null); 
                                                                        

                                                                    }
                                                                    break;

                                                            }


                                                            }
                                                            break;
                                                        case 2 :
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:183:5: this_ManyStrings_2= ruleManyStrings
                                                            {
                                                             
                                                                    currentNode=createCompositeNode(grammarAccess.prTerm().ele000001ParserRuleCallManyStrings(), currentNode); 
                                                                
                                                            pushFollow(FOLLOW_ruleManyStrings_in_ruleTerm349);
                                                            this_ManyStrings_2=ruleManyStrings();
                                                            _fsp--;

                                                             
                                                                    current = this_ManyStrings_2; 
                                                                    currentNode = currentNode.getParent();
                                                                
                                                             
                                                                createLeafNode(grammarAccess.prTerm().ele000001ParserRuleCallManyStrings(), null); 
                                                                

                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:197:5: this_Parens_3= ruleParens
                                                    {
                                                     
                                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele00001ParserRuleCallParens(), currentNode); 
                                                        
                                                    pushFollow(FOLLOW_ruleParens_in_ruleTerm384);
                                                    this_Parens_3=ruleParens();
                                                    _fsp--;

                                                     
                                                            current = this_Parens_3; 
                                                            currentNode = currentNode.getParent();
                                                        
                                                     
                                                        createLeafNode(grammarAccess.prTerm().ele00001ParserRuleCallParens(), null); 
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:211:5: this_Type_4= ruleType
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerm().ele0001ParserRuleCallType(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleType_in_ruleTerm419);
                                            this_Type_4=ruleType();
                                            _fsp--;

                                             
                                                    current = this_Type_4; 
                                                    currentNode = currentNode.getParent();
                                                
                                             
                                                createLeafNode(grammarAccess.prTerm().ele0001ParserRuleCallType(), null); 
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:225:5: this_Ref2_5= ruleRef2
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele001ParserRuleCallRef2(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRef2_in_ruleTerm454);
                                    this_Ref2_5=ruleRef2();
                                    _fsp--;

                                     
                                            current = this_Ref2_5; 
                                            currentNode = currentNode.getParent();
                                        
                                     
                                        createLeafNode(grammarAccess.prTerm().ele001ParserRuleCallRef2(), null); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:239:5: this_Spare_6= ruleSpare
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prTerm().ele01ParserRuleCallSpare(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleSpare_in_ruleTerm489);
                            this_Spare_6=ruleSpare();
                            _fsp--;

                             
                                    current = this_Spare_6; 
                                    currentNode = currentNode.getParent();
                                
                             
                                createLeafNode(grammarAccess.prTerm().ele01ParserRuleCallSpare(), null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:253:5: this_Boolean_7= ruleBoolean
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerm().ele1ParserRuleCallBoolean(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBoolean_in_ruleTerm524);
                    this_Boolean_7=ruleBoolean();
                    _fsp--;

                     
                            current = this_Boolean_7; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prTerm().ele1ParserRuleCallBoolean(), null); 
                        

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
    // $ANTLR end ruleTerm


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:272:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:272:46: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:273:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAtom().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom563);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom573); 

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
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:280:1: ruleAtom returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:285:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:286:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:286:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:288:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom619); 

            		createLeafNode(grammarAccess.prAtom().ele0TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAtom().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleParens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:313:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:313:48: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:314:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens659);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens669); 

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
    // $ANTLR end entryRuleParens


    // $ANTLR start ruleParens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:321:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op_1= ruleOp ) ')' ) (lv_em_3= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em_3=null;
        EObject this_Op_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:326:6: ( ( ( ( '(' this_Op_1= ruleOp ) ')' ) (lv_em_3= '!' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:1: ( ( ( '(' this_Op_1= ruleOp ) ')' ) (lv_em_3= '!' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:1: ( ( ( '(' this_Op_1= ruleOp ) ')' ) (lv_em_3= '!' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:2: ( ( '(' this_Op_1= ruleOp ) ')' ) (lv_em_3= '!' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:2: ( ( '(' this_Op_1= ruleOp ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:3: ( '(' this_Op_1= ruleOp ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:3: ( '(' this_Op_1= ruleOp )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:4: '(' this_Op_1= ruleOp
            {
            match(input,11,FOLLOW_11_in_ruleParens705); 

                    createLeafNode(grammarAccess.prParens().ele000KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParens().ele001ParserRuleCallOp(), currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens727);
            this_Op_1=ruleOp();
            _fsp--;

             
                    current = this_Op_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prParens().ele001ParserRuleCallOp(), null); 
                

            }

            match(input,12,FOLLOW_12_in_ruleParens743); 

                    createLeafNode(grammarAccess.prParens().ele01KeywordRightParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:348:2: (lv_em_3= '!' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:350:6: lv_em_3= '!'
                    {
                    lv_em_3=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParens765); 

                            createLeafNode(grammarAccess.prParens().ele10KeywordExclamationMark(), "em"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prParens().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "em", /* lv_em_3 */ input.LT(-1), "!", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // $ANTLR end ruleParens


    // $ANTLR start entryRuleTwoNumbers
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:376:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:376:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:377:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTwoNumbers().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers812);
            iv_ruleTwoNumbers=ruleTwoNumbers();
            _fsp--;

             current =iv_ruleTwoNumbers; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoNumbers822); 

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
    // $ANTLR end entryRuleTwoNumbers


    // $ANTLR start ruleTwoNumbers
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:384:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ) ( '#' (lv_num3_3= RULE_INT ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1_0=null;
        Token lv_num2_1=null;
        Token lv_num3_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:389:6: ( ( ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ) ( '#' (lv_num3_3= RULE_INT ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:1: ( ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ) ( '#' (lv_num3_3= RULE_INT ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:1: ( ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ) ( '#' (lv_num3_3= RULE_INT ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:2: ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ) ( '#' (lv_num3_3= RULE_INT ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:2: ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:3: (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:3: (lv_num1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:392:6: lv_num1_0= RULE_INT
            {
            lv_num1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers870); 

            		createLeafNode(grammarAccess.prTwoNumbers().ele000TerminalRuleCallINT(), "num1"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTwoNumbers().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "num1", lv_num1_0, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:410:2: (lv_num2_1= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:412:6: lv_num2_1= RULE_INT
            {
            lv_num2_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers900); 

            		createLeafNode(grammarAccess.prTwoNumbers().ele010TerminalRuleCallINT(), "num2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTwoNumbers().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "num2", lv_num2_1, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:430:3: ( '#' (lv_num3_3= RULE_INT ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:430:4: '#' (lv_num3_3= RULE_INT )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTwoNumbers919); 

            	            createLeafNode(grammarAccess.prTwoNumbers().ele10KeywordNumberSign(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:434:1: (lv_num3_3= RULE_INT )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:436:6: lv_num3_3= RULE_INT
            	    {
            	    lv_num3_3=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers941); 

            	    		createLeafNode(grammarAccess.prTwoNumbers().ele110TerminalRuleCallINT(), "num3"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTwoNumbers().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "num3", lv_num3_3, "INT", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end ruleTwoNumbers


    // $ANTLR start entryRuleManyStrings
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:461:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:461:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:462:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode(grammarAccess.prManyStrings().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleManyStrings_in_entryRuleManyStrings984);
            iv_ruleManyStrings=ruleManyStrings();
            _fsp--;

             current =iv_ruleManyStrings; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManyStrings994); 

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
    // $ANTLR end entryRuleManyStrings


    // $ANTLR start ruleManyStrings
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:469:1: ruleManyStrings returns [EObject current=null] : ( ( '=' (lv_str1_1= RULE_STRING )* ) (lv_str2_2= RULE_STRING ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token lv_str1_1=null;
        Token lv_str2_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:474:6: ( ( ( '=' (lv_str1_1= RULE_STRING )* ) (lv_str2_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:475:1: ( ( '=' (lv_str1_1= RULE_STRING )* ) (lv_str2_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:475:1: ( ( '=' (lv_str1_1= RULE_STRING )* ) (lv_str2_2= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:475:2: ( '=' (lv_str1_1= RULE_STRING )* ) (lv_str2_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:475:2: ( '=' (lv_str1_1= RULE_STRING )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:475:3: '=' (lv_str1_1= RULE_STRING )*
            {
            match(input,15,FOLLOW_15_in_ruleManyStrings1029); 

                    createLeafNode(grammarAccess.prManyStrings().ele00KeywordEqualsSign(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:479:1: (lv_str1_1= RULE_STRING )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_STRING) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==RULE_STRING) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:481:6: lv_str1_1= RULE_STRING
            	    {
            	    lv_str1_1=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1051); 

            	    		createLeafNode(grammarAccess.prManyStrings().ele010TerminalRuleCallSTRING(), "str1"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prManyStrings().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "str1", lv_str1_1, "STRING", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:499:4: (lv_str2_2= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:501:6: lv_str2_2= RULE_STRING
            {
            lv_str2_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1083); 

            		createLeafNode(grammarAccess.prManyStrings().ele10TerminalRuleCallSTRING(), "str2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prManyStrings().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "str2", lv_str2_2, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleManyStrings


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:526:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:526:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:527:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType1124);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1134); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:534:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:539:6: ( ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:1: ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:1: ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:2: ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:2: ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:3: ( 'type' (lv_name_1= RULE_ID ) ) 'extends'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:3: ( 'type' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:4: 'type' (lv_name_1= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleType1170); 

                    createLeafNode(grammarAccess.prType().ele000KeywordType(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:544:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:546:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1192); 

            		createLeafNode(grammarAccess.prType().ele0010TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prType().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleType1210); 

                    createLeafNode(grammarAccess.prType().ele01KeywordExtends(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:568:2: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:571:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prType().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1233); 

            		createLeafNode(grammarAccess.prType().ele10CrossReferenceEStringType(), "extends"); 
            	

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleRef2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:591:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:591:46: (iv_ruleRef2= ruleRef2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:592:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRef2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRef2_in_entryRuleRef21269);
            iv_ruleRef2=ruleRef2();
            _fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRef21279); 

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
    // $ANTLR end entryRuleRef2


    // $ANTLR start ruleRef2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:599:1: ruleRef2 returns [EObject current=null] : ( '#2' (lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:604:6: ( ( '#2' (lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:605:1: ( '#2' (lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:605:1: ( '#2' (lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:605:2: '#2' (lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            {
            match(input,18,FOLLOW_18_in_ruleRef21313); 

                    createLeafNode(grammarAccess.prRef2().ele0KeywordNumberSignDigitTwo(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:609:1: (lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:6: lv_ref2_1= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:16: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING||LA13_0==19) ) {
                alt13=1;
            }
            else if ( (LA13_0==20) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("611:16: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:17: ( 'mykeyword1' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:17: ( 'mykeyword1' | RULE_STRING )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==19) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_STRING) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("611:17: ( 'mykeyword1' | RULE_STRING )", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:18: 'mykeyword1'
                            {
                            match(input,19,FOLLOW_19_in_ruleRef21336); 

                                    createLeafNode(grammarAccess.prRef2().ele1000KeywordMykeyword1(), "ref2"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:617:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef21353); 

                            		createLeafNode(grammarAccess.prRef2().ele1001TerminalRuleCallSTRING(), "ref2"); 
                            	

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:623:6: 'mykeyword2'
                    {
                    match(input,20,FOLLOW_20_in_ruleRef21366); 

                            createLeafNode(grammarAccess.prRef2().ele101KeywordMykeyword2(), "ref2"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prRef2().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "ref2", /* lv_ref2_1 */ input.LT(-1), null, lastConsumedNode);
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
    // $ANTLR end ruleRef2


    // $ANTLR start entryRuleSpare
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:650:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:650:47: (iv_ruleSpare= ruleSpare EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:651:2: iv_ruleSpare= ruleSpare EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpare().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpare_in_entryRuleSpare1414);
            iv_ruleSpare=ruleSpare();
            _fsp--;

             current =iv_ruleSpare; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpare1424); 

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
    // $ANTLR end entryRuleSpare


    // $ANTLR start ruleSpare
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:658:1: ruleSpare returns [EObject current=null] : ( ( '#3' (lv_id_1= RULE_ID ) ) ( '.' (lv_id_3= RULE_ID ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token lv_id_1=null;
        Token lv_id_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:663:6: ( ( ( '#3' (lv_id_1= RULE_ID ) ) ( '.' (lv_id_3= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:664:1: ( ( '#3' (lv_id_1= RULE_ID ) ) ( '.' (lv_id_3= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:664:1: ( ( '#3' (lv_id_1= RULE_ID ) ) ( '.' (lv_id_3= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:664:2: ( '#3' (lv_id_1= RULE_ID ) ) ( '.' (lv_id_3= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:664:2: ( '#3' (lv_id_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:664:3: '#3' (lv_id_1= RULE_ID )
            {
            match(input,21,FOLLOW_21_in_ruleSpare1459); 

                    createLeafNode(grammarAccess.prSpare().ele00KeywordNumberSignDigitThree(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:668:1: (lv_id_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:670:6: lv_id_1= RULE_ID
            {
            lv_id_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1481); 

            		createLeafNode(grammarAccess.prSpare().ele010TerminalRuleCallID(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpare().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:688:3: ( '.' (lv_id_3= RULE_ID ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:688:4: '.' (lv_id_3= RULE_ID )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleSpare1500); 

            	            createLeafNode(grammarAccess.prSpare().ele10KeywordFullStop(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:692:1: (lv_id_3= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:6: lv_id_3= RULE_ID
            	    {
            	    lv_id_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1522); 

            	    		createLeafNode(grammarAccess.prSpare().ele110TerminalRuleCallID(), "id"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSpare().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "id", lv_id_3, "ID", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end ruleSpare


    // $ANTLR start entryRuleBoolean
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:719:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:719:49: (iv_ruleBoolean= ruleBoolean EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:720:2: iv_ruleBoolean= ruleBoolean EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBoolean().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoolean_in_entryRuleBoolean1565);
            iv_ruleBoolean=ruleBoolean();
            _fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolean1575); 

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
    // $ANTLR end entryRuleBoolean


    // $ANTLR start ruleBoolean
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:727:1: ruleBoolean returns [EObject current=null] : ( ( ( '#4' (lv_bool_1= 'myoption' )? ) 'kw' ) (lv_value_3= RULE_ID ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool_1=null;
        Token lv_value_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:732:6: ( ( ( ( '#4' (lv_bool_1= 'myoption' )? ) 'kw' ) (lv_value_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:1: ( ( ( '#4' (lv_bool_1= 'myoption' )? ) 'kw' ) (lv_value_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:1: ( ( ( '#4' (lv_bool_1= 'myoption' )? ) 'kw' ) (lv_value_3= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:2: ( ( '#4' (lv_bool_1= 'myoption' )? ) 'kw' ) (lv_value_3= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:2: ( ( '#4' (lv_bool_1= 'myoption' )? ) 'kw' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:3: ( '#4' (lv_bool_1= 'myoption' )? ) 'kw'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:3: ( '#4' (lv_bool_1= 'myoption' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:733:4: '#4' (lv_bool_1= 'myoption' )?
            {
            match(input,23,FOLLOW_23_in_ruleBoolean1611); 

                    createLeafNode(grammarAccess.prBoolean().ele000KeywordNumberSignDigitFour(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:737:1: (lv_bool_1= 'myoption' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:739:6: lv_bool_1= 'myoption'
                    {
                    lv_bool_1=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleBoolean1632); 

                            createLeafNode(grammarAccess.prBoolean().ele0010KeywordMyoption(), "bool"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prBoolean().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "bool", true, "myoption", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleBoolean1656); 

                    createLeafNode(grammarAccess.prBoolean().ele01KeywordKw(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:762:2: (lv_value_3= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:764:6: lv_value_3= RULE_ID
            {
            lv_value_3=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBoolean1679); 

            		createLeafNode(grammarAccess.prBoolean().ele10TerminalRuleCallID(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prBoolean().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_3, "ID", lastConsumedNode);
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
    // $ANTLR end ruleBoolean


 

    public static final BitSet FOLLOW_ruleOp_in_entryRuleOp71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOp81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp128 = new BitSet(new long[]{0x0000000000A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp178 = new BitSet(new long[]{0x0000000000A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleTerm419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_ruleTerm454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_ruleTerm489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_ruleTerm524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParens705 = new BitSet(new long[]{0x0000000000A58830L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens727 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParens743 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleParens765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers870 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers900 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTwoNumbers919 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers941 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleManyStrings1029 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1051 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleType1170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1192 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleType1210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRef21279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRef21313 = new BitSet(new long[]{0x0000000000180040L});
    public static final BitSet FOLLOW_19_in_ruleRef21336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRef21366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_entryRuleSpare1414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpare1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSpare1459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1481 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleSpare1500 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1522 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBoolean1611 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleBoolean1632 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleBoolean1656 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean1679 = new BitSet(new long[]{0x0000000000000002L});

}
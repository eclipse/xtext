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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'", "'#3'", "'.'", "'#4'", "'myoption'", "'kw'", "'#5'", "'*'", "','", "'#6'", "'v1'", "'v2'", "'#7'", "'kw0'", "'#8'", "'kw1'", "'kw2'", "'kw30'", "'#9'", "'kw3'", "'kw4'", "'kw5'", "'kw6'", "'#10'", "'#11'", "'kw7'", "'#12'", "'interface'", "'class'", "'#13'", "'static'", "'final'", "'transient'", "'#14'", "'item'", "'#15'"
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
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:72:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:72:44: (iv_ruleOp= ruleOp EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:73:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOpRule(), currentNode); 
            pushFollow(FOLLOW_ruleOp_in_entryRuleOp73);
            iv_ruleOp=ruleOp();
            _fsp--;

             current =iv_ruleOp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOp83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:80:1: ruleOp returns [EObject current=null] : (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term_0 = null;

        EObject lv_values_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:85:6: ( (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:86:1: (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:86:1: (this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:87:5: this_Term_0= ruleTerm ( () (lv_values_2= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getOpAccess().getTermParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp130);
            this_Term_0=ruleTerm();
            _fsp--;

             
                    current = this_Term_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:95:1: ( () (lv_values_2= ruleTerm ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||LA1_0==21||LA1_0==23||LA1_0==26||LA1_0==29||(LA1_0>=32 && LA1_0<=36)||(LA1_0>=38 && LA1_0<=39)||LA1_0==44||LA1_0==46||LA1_0==49||LA1_0==53||LA1_0==55) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:95:2: () (lv_values_2= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:95:2: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getOpAccess().getOpValuesAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getOpAccess().getOpValuesAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:111:2: (lv_values_2= ruleTerm )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:114:6: lv_values_2= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOpAccess().getValuesTermParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp173);
            	    lv_values_2=ruleTerm();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOpRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:139:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:139:46: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:140:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm212);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm222); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:147:1: ruleTerm returns [EObject current=null] : (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 ) ;
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

        EObject this_Transient1_8 = null;

        EObject this_Consumed1_9 = null;

        EObject this_Consumed2_10 = null;

        EObject this_Loop1_11 = null;

        EObject this_Loop2_12 = null;

        EObject this_Loop3_13 = null;

        EObject this_Loop4_14 = null;

        EObject this_LoopBug285452_15 = null;

        EObject this_DuplicateBug284491_16 = null;

        EObject this_EmptyObjectBug284850_17 = null;

        EObject this_MultiInheritanceBug280439_18 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:152:6: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:153:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:153:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 )
            int alt2=19;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case RULE_INT:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            case 11:
                {
                alt2=4;
                }
                break;
            case 16:
                {
                alt2=5;
                }
                break;
            case 18:
                {
                alt2=6;
                }
                break;
            case 21:
                {
                alt2=7;
                }
                break;
            case 23:
                {
                alt2=8;
                }
                break;
            case 26:
                {
                alt2=9;
                }
                break;
            case 29:
                {
                alt2=10;
                }
                break;
            case 32:
                {
                alt2=11;
                }
                break;
            case 33:
            case 34:
                {
                alt2=12;
                }
                break;
            case 38:
                {
                alt2=13;
                }
                break;
            case 35:
            case 36:
            case 39:
                {
                alt2=14;
                }
                break;
            case 44:
                {
                alt2=15;
                }
                break;
            case 46:
                {
                alt2=16;
                }
                break;
            case 49:
                {
                alt2=17;
                }
                break;
            case 53:
                {
                alt2=18;
                }
                break;
            case 55:
                {
                alt2=19;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("153:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:154:5: this_Atom_0= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getAtomParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm269);
                    this_Atom_0=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:164:5: this_TwoNumbers_1= ruleTwoNumbers
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTwoNumbersParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTwoNumbers_in_ruleTerm296);
                    this_TwoNumbers_1=ruleTwoNumbers();
                    _fsp--;

                     
                            current = this_TwoNumbers_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:174:5: this_ManyStrings_2= ruleManyStrings
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getManyStringsParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleManyStrings_in_ruleTerm323);
                    this_ManyStrings_2=ruleManyStrings();
                    _fsp--;

                     
                            current = this_ManyStrings_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:184:5: this_Parens_3= ruleParens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getParensParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm350);
                    this_Parens_3=ruleParens();
                    _fsp--;

                     
                            current = this_Parens_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:194:5: this_Type_4= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTypeParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleTerm377);
                    this_Type_4=ruleType();
                    _fsp--;

                     
                            current = this_Type_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:204:5: this_Ref2_5= ruleRef2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getRef2ParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRef2_in_ruleTerm404);
                    this_Ref2_5=ruleRef2();
                    _fsp--;

                     
                            current = this_Ref2_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:214:5: this_Spare_6= ruleSpare
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getSpareParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSpare_in_ruleTerm431);
                    this_Spare_6=ruleSpare();
                    _fsp--;

                     
                            current = this_Spare_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:224:5: this_Boolean_7= ruleBoolean
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getBooleanParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBoolean_in_ruleTerm458);
                    this_Boolean_7=ruleBoolean();
                    _fsp--;

                     
                            current = this_Boolean_7; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:234:5: this_Transient1_8= ruleTransient1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTransient1ParserRuleCall_8(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransient1_in_ruleTerm485);
                    this_Transient1_8=ruleTransient1();
                    _fsp--;

                     
                            current = this_Transient1_8; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:244:5: this_Consumed1_9= ruleConsumed1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getConsumed1ParserRuleCall_9(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConsumed1_in_ruleTerm512);
                    this_Consumed1_9=ruleConsumed1();
                    _fsp--;

                     
                            current = this_Consumed1_9; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:254:5: this_Consumed2_10= ruleConsumed2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getConsumed2ParserRuleCall_10(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConsumed2_in_ruleTerm539);
                    this_Consumed2_10=ruleConsumed2();
                    _fsp--;

                     
                            current = this_Consumed2_10; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:264:5: this_Loop1_11= ruleLoop1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop1ParserRuleCall_11(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop1_in_ruleTerm566);
                    this_Loop1_11=ruleLoop1();
                    _fsp--;

                     
                            current = this_Loop1_11; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:274:5: this_Loop2_12= ruleLoop2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop2ParserRuleCall_12(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop2_in_ruleTerm593);
                    this_Loop2_12=ruleLoop2();
                    _fsp--;

                     
                            current = this_Loop2_12; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:284:5: this_Loop3_13= ruleLoop3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop3ParserRuleCall_13(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop3_in_ruleTerm620);
                    this_Loop3_13=ruleLoop3();
                    _fsp--;

                     
                            current = this_Loop3_13; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:5: this_Loop4_14= ruleLoop4
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop4ParserRuleCall_14(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop4_in_ruleTerm647);
                    this_Loop4_14=ruleLoop4();
                    _fsp--;

                     
                            current = this_Loop4_14; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:304:5: this_LoopBug285452_15= ruleLoopBug285452
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoopBug285452ParserRuleCall_15(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoopBug285452_in_ruleTerm674);
                    this_LoopBug285452_15=ruleLoopBug285452();
                    _fsp--;

                     
                            current = this_LoopBug285452_15; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:314:5: this_DuplicateBug284491_16= ruleDuplicateBug284491
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getDuplicateBug284491ParserRuleCall_16(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDuplicateBug284491_in_ruleTerm701);
                    this_DuplicateBug284491_16=ruleDuplicateBug284491();
                    _fsp--;

                     
                            current = this_DuplicateBug284491_16; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:324:5: this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getEmptyObjectBug284850ParserRuleCall_17(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm728);
                    this_EmptyObjectBug284850_17=ruleEmptyObjectBug284850();
                    _fsp--;

                     
                            current = this_EmptyObjectBug284850_17; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 19 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:334:5: this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getMultiInheritanceBug280439ParserRuleCall_18(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm755);
                    this_MultiInheritanceBug280439_18=ruleMultiInheritanceBug280439();
                    _fsp--;

                     
                            current = this_MultiInheritanceBug280439_18; 
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
    // $ANTLR end ruleTerm


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:349:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:349:46: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:350:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom787);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom797); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:357:1: ruleAtom returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:362:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:363:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:363:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:365:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom843); 

            		createLeafNode(grammarAccess.getAtomAccess().getNameIDTerminalRuleCall_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAtomRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:48: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:391:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParensRule(), currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens883);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens893); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:398:1: ruleParens returns [EObject current=null] : ( '(' this_Op_1= ruleOp ')' (lv_em_3= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em_3=null;
        EObject this_Op_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:403:6: ( ( '(' this_Op_1= ruleOp ')' (lv_em_3= '!' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:404:1: ( '(' this_Op_1= ruleOp ')' (lv_em_3= '!' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:404:1: ( '(' this_Op_1= ruleOp ')' (lv_em_3= '!' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:404:2: '(' this_Op_1= ruleOp ')' (lv_em_3= '!' )?
            {
            match(input,11,FOLLOW_11_in_ruleParens927); 

                    createLeafNode(grammarAccess.getParensAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParensAccess().getOpParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens949);
            this_Op_1=ruleOp();
            _fsp--;

             
                    current = this_Op_1; 
                    currentNode = currentNode.getParent();
                
            match(input,12,FOLLOW_12_in_ruleParens957); 

                    createLeafNode(grammarAccess.getParensAccess().getRightParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:421:1: (lv_em_3= '!' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:423:6: lv_em_3= '!'
                    {
                    lv_em_3=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParens978); 

                            createLeafNode(grammarAccess.getParensAccess().getEmExclamationMarkKeyword_3_0(), "em"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParensRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:449:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:449:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:450:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoNumbersRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers1025);
            iv_ruleTwoNumbers=ruleTwoNumbers();
            _fsp--;

             current =iv_ruleTwoNumbers; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoNumbers1035); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:457:1: ruleTwoNumbers returns [EObject current=null] : ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ( '#' (lv_num3_3= RULE_INT ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1_0=null;
        Token lv_num2_1=null;
        Token lv_num3_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:462:6: ( ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ( '#' (lv_num3_3= RULE_INT ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:1: ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ( '#' (lv_num3_3= RULE_INT ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:1: ( (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ( '#' (lv_num3_3= RULE_INT ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:2: (lv_num1_0= RULE_INT ) (lv_num2_1= RULE_INT ) ( '#' (lv_num3_3= RULE_INT ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:2: (lv_num1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:465:6: lv_num1_0= RULE_INT
            {
            lv_num1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers1082); 

            		createLeafNode(grammarAccess.getTwoNumbersAccess().getNum1INTTerminalRuleCall_0_0(), "num1"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoNumbersRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "num1", lv_num1_0, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:483:2: (lv_num2_1= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:485:6: lv_num2_1= RULE_INT
            {
            lv_num2_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers1112); 

            		createLeafNode(grammarAccess.getTwoNumbersAccess().getNum2INTTerminalRuleCall_1_0(), "num2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoNumbersRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "num2", lv_num2_1, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:2: ( '#' (lv_num3_3= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:3: '#' (lv_num3_3= RULE_INT )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTwoNumbers1130); 

            	            createLeafNode(grammarAccess.getTwoNumbersAccess().getNumberSignKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:507:1: (lv_num3_3= RULE_INT )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:509:6: lv_num3_3= RULE_INT
            	    {
            	    lv_num3_3=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers1152); 

            	    		createLeafNode(grammarAccess.getTwoNumbersAccess().getNum3INTTerminalRuleCall_2_1_0(), "num3"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTwoNumbersRule().getType().getClassifier());
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
            	    break loop4;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:534:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:534:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:535:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode(grammarAccess.getManyStringsRule(), currentNode); 
            pushFollow(FOLLOW_ruleManyStrings_in_entryRuleManyStrings1195);
            iv_ruleManyStrings=ruleManyStrings();
            _fsp--;

             current =iv_ruleManyStrings; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManyStrings1205); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:542:1: ruleManyStrings returns [EObject current=null] : ( '=' (lv_str1_1= RULE_STRING )* (lv_str2_2= RULE_STRING ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token lv_str1_1=null;
        Token lv_str2_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:547:6: ( ( '=' (lv_str1_1= RULE_STRING )* (lv_str2_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:548:1: ( '=' (lv_str1_1= RULE_STRING )* (lv_str2_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:548:1: ( '=' (lv_str1_1= RULE_STRING )* (lv_str2_2= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:548:2: '=' (lv_str1_1= RULE_STRING )* (lv_str2_2= RULE_STRING )
            {
            match(input,15,FOLLOW_15_in_ruleManyStrings1239); 

                    createLeafNode(grammarAccess.getManyStringsAccess().getEqualsSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:552:1: (lv_str1_1= RULE_STRING )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_STRING) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==RULE_STRING) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:554:6: lv_str1_1= RULE_STRING
            	    {
            	    lv_str1_1=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1261); 

            	    		createLeafNode(grammarAccess.getManyStringsAccess().getStr1STRINGTerminalRuleCall_1_0(), "str1"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getManyStringsRule().getType().getClassifier());
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
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:572:3: (lv_str2_2= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:6: lv_str2_2= RULE_STRING
            {
            lv_str2_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1292); 

            		createLeafNode(grammarAccess.getManyStringsAccess().getStr2STRINGTerminalRuleCall_2_0(), "str2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getManyStringsRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:599:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:599:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:600:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType1333);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1343); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:607:1: ruleType returns [EObject current=null] : ( 'type' (lv_name_1= RULE_ID ) 'extends' ( RULE_ID ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:612:6: ( ( 'type' (lv_name_1= RULE_ID ) 'extends' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:613:1: ( 'type' (lv_name_1= RULE_ID ) 'extends' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:613:1: ( 'type' (lv_name_1= RULE_ID ) 'extends' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:613:2: 'type' (lv_name_1= RULE_ID ) 'extends' ( RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleType1377); 

                    createLeafNode(grammarAccess.getTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:617:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:619:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1399); 

            		createLeafNode(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,17,FOLLOW_17_in_ruleType1416); 

                    createLeafNode(grammarAccess.getTypeAccess().getExtendsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:641:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:644:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1438); 

            		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0(), "extends"); 
            	
             lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:665:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:665:46: (iv_ruleRef2= ruleRef2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:666:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRef2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleRef2_in_entryRuleRef21478);
            iv_ruleRef2=ruleRef2();
            _fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRef21488); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:673:1: ruleRef2 returns [EObject current=null] : ( '#2' (lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:678:6: ( ( '#2' (lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:679:1: ( '#2' (lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:679:1: ( '#2' (lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:679:2: '#2' (lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' ) )
            {
            match(input,18,FOLLOW_18_in_ruleRef21522); 

                    createLeafNode(grammarAccess.getRef2Access().getNumberSignDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:683:1: (lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:685:6: lv_ref2_1= ( 'mykeyword1' | RULE_STRING | 'mykeyword2' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:685:16: ( 'mykeyword1' | RULE_STRING | 'mykeyword2' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("685:16: ( 'mykeyword1' | RULE_STRING | 'mykeyword2' )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:685:17: 'mykeyword1'
                    {
                    match(input,19,FOLLOW_19_in_ruleRef21544); 

                            createLeafNode(grammarAccess.getRef2Access().getRef2Mykeyword1Keyword_1_0_0(), "ref2"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:691:7: RULE_STRING
                    {
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef21561); 

                    		createLeafNode(grammarAccess.getRef2Access().getRef2STRINGTerminalRuleCall_1_0_1(), "ref2"); 
                    	

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:6: 'mykeyword2'
                    {
                    match(input,20,FOLLOW_20_in_ruleRef21572); 

                            createLeafNode(grammarAccess.getRef2Access().getRef2Mykeyword2Keyword_1_0_2(), "ref2"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRef2Rule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:723:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:723:47: (iv_ruleSpare= ruleSpare EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:724:2: iv_ruleSpare= ruleSpare EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpareRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpare_in_entryRuleSpare1620);
            iv_ruleSpare=ruleSpare();
            _fsp--;

             current =iv_ruleSpare; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpare1630); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:731:1: ruleSpare returns [EObject current=null] : ( '#3' (lv_id_1= RULE_ID ) ( '.' (lv_id_3= RULE_ID ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token lv_id_1=null;
        Token lv_id_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:736:6: ( ( '#3' (lv_id_1= RULE_ID ) ( '.' (lv_id_3= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:737:1: ( '#3' (lv_id_1= RULE_ID ) ( '.' (lv_id_3= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:737:1: ( '#3' (lv_id_1= RULE_ID ) ( '.' (lv_id_3= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:737:2: '#3' (lv_id_1= RULE_ID ) ( '.' (lv_id_3= RULE_ID ) )*
            {
            match(input,21,FOLLOW_21_in_ruleSpare1664); 

                    createLeafNode(grammarAccess.getSpareAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:741:1: (lv_id_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:743:6: lv_id_1= RULE_ID
            {
            lv_id_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1686); 

            		createLeafNode(grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_1_0(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpareRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:761:2: ( '.' (lv_id_3= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:761:3: '.' (lv_id_3= RULE_ID )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleSpare1704); 

            	            createLeafNode(grammarAccess.getSpareAccess().getFullStopKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:765:1: (lv_id_3= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:767:6: lv_id_3= RULE_ID
            	    {
            	    lv_id_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1726); 

            	    		createLeafNode(grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_2_1_0(), "id"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSpareRule().getType().getClassifier());
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
            	    break loop7;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:792:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:792:49: (iv_ruleBoolean= ruleBoolean EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:793:2: iv_ruleBoolean= ruleBoolean EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoolean_in_entryRuleBoolean1769);
            iv_ruleBoolean=ruleBoolean();
            _fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolean1779); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:800:1: ruleBoolean returns [EObject current=null] : ( '#4' (lv_bool_1= 'myoption' )? 'kw' (lv_value_3= RULE_ID ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool_1=null;
        Token lv_value_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:805:6: ( ( '#4' (lv_bool_1= 'myoption' )? 'kw' (lv_value_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:806:1: ( '#4' (lv_bool_1= 'myoption' )? 'kw' (lv_value_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:806:1: ( '#4' (lv_bool_1= 'myoption' )? 'kw' (lv_value_3= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:806:2: '#4' (lv_bool_1= 'myoption' )? 'kw' (lv_value_3= RULE_ID )
            {
            match(input,23,FOLLOW_23_in_ruleBoolean1813); 

                    createLeafNode(grammarAccess.getBooleanAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:810:1: (lv_bool_1= 'myoption' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:812:6: lv_bool_1= 'myoption'
                    {
                    lv_bool_1=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleBoolean1834); 

                            createLeafNode(grammarAccess.getBooleanAccess().getBoolMyoptionKeyword_1_0(), "bool"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBooleanRule().getType().getClassifier());
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

            match(input,25,FOLLOW_25_in_ruleBoolean1857); 

                    createLeafNode(grammarAccess.getBooleanAccess().getKwKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:835:1: (lv_value_3= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:837:6: lv_value_3= RULE_ID
            {
            lv_value_3=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBoolean1879); 

            		createLeafNode(grammarAccess.getBooleanAccess().getValueIDTerminalRuleCall_3_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanRule().getType().getClassifier());
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


    // $ANTLR start entryRuleTransient1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:862:1: entryRuleTransient1 returns [EObject current=null] : iv_ruleTransient1= ruleTransient1 EOF ;
    public final EObject entryRuleTransient1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransient1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:862:52: (iv_ruleTransient1= ruleTransient1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:863:2: iv_ruleTransient1= ruleTransient1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransient1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleTransient1_in_entryRuleTransient11920);
            iv_ruleTransient1=ruleTransient1();
            _fsp--;

             current =iv_ruleTransient1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransient11930); 

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
    // $ANTLR end entryRuleTransient1


    // $ANTLR start ruleTransient1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:870:1: ruleTransient1 returns [EObject current=null] : ( '#5' ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) ) ( ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) ) )? ) ;
    public final EObject ruleTransient1() throws RecognitionException {
        EObject current = null;

        Token lv_precStar_1=null;
        Token lv_prec_2=null;
        Token lv_scaleStar_4=null;
        Token lv_scale_5=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:875:6: ( ( '#5' ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) ) ( ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:876:1: ( '#5' ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) ) ( ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:876:1: ( '#5' ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) ) ( ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:876:2: '#5' ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) ) ( ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) ) )?
            {
            match(input,26,FOLLOW_26_in_ruleTransient11964); 

                    createLeafNode(grammarAccess.getTransient1Access().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:880:1: ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_INT) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("880:1: ( (lv_precStar_1= '*' ) | (lv_prec_2= RULE_INT ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:880:2: (lv_precStar_1= '*' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:880:2: (lv_precStar_1= '*' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:882:6: lv_precStar_1= '*'
                    {
                    lv_precStar_1=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleTransient11986); 

                            createLeafNode(grammarAccess.getTransient1Access().getPrecStarAsteriskKeyword_1_0_0(), "precStar"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransient1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "precStar", true, "*", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:902:6: (lv_prec_2= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:902:6: (lv_prec_2= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:904:6: lv_prec_2= RULE_INT
                    {
                    lv_prec_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTransient12027); 

                    		createLeafNode(grammarAccess.getTransient1Access().getPrecINTTerminalRuleCall_1_1_0(), "prec"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransient1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "prec", lv_prec_2, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:922:3: ( ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:922:4: ',' ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) )
                    {
                    match(input,28,FOLLOW_28_in_ruleTransient12046); 

                            createLeafNode(grammarAccess.getTransient1Access().getCommaKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:926:1: ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==27) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RULE_INT) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("926:1: ( (lv_scaleStar_4= '*' ) | (lv_scale_5= RULE_INT ) )", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:926:2: (lv_scaleStar_4= '*' )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:926:2: (lv_scaleStar_4= '*' )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:928:6: lv_scaleStar_4= '*'
                            {
                            lv_scaleStar_4=(Token)input.LT(1);
                            match(input,27,FOLLOW_27_in_ruleTransient12068); 

                                    createLeafNode(grammarAccess.getTransient1Access().getScaleStarAsteriskKeyword_2_1_0_0(), "scaleStar"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTransient1Rule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "scaleStar", true, "*", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:948:6: (lv_scale_5= RULE_INT )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:948:6: (lv_scale_5= RULE_INT )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:950:6: lv_scale_5= RULE_INT
                            {
                            lv_scale_5=(Token)input.LT(1);
                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTransient12109); 

                            		createLeafNode(grammarAccess.getTransient1Access().getScaleINTTerminalRuleCall_2_1_1_0(), "scale"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTransient1Rule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "scale", lv_scale_5, "INT", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

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
    // $ANTLR end ruleTransient1


    // $ANTLR start entryRuleConsumed1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:975:1: entryRuleConsumed1 returns [EObject current=null] : iv_ruleConsumed1= ruleConsumed1 EOF ;
    public final EObject entryRuleConsumed1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:975:51: (iv_ruleConsumed1= ruleConsumed1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:976:2: iv_ruleConsumed1= ruleConsumed1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConsumed1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleConsumed1_in_entryRuleConsumed12153);
            iv_ruleConsumed1=ruleConsumed1();
            _fsp--;

             current =iv_ruleConsumed1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConsumed12163); 

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
    // $ANTLR end entryRuleConsumed1


    // $ANTLR start ruleConsumed1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:983:1: ruleConsumed1 returns [EObject current=null] : ( '#6' ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) ) ) ;
    public final EObject ruleConsumed1() throws RecognitionException {
        EObject current = null;

        Token lv_v1_2=null;
        Token lv_v2_3=null;
        Token lv_v2_5=null;
        Token lv_v1_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:988:6: ( ( '#6' ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:989:1: ( '#6' ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:989:1: ( '#6' ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:989:2: '#6' ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) )
            {
            match(input,29,FOLLOW_29_in_ruleConsumed12197); 

                    createLeafNode(grammarAccess.getConsumed1Access().getNumberSignDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:993:1: ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            else if ( (LA14_0==31) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("993:1: ( ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) ) | ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) ) )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:993:2: ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:993:2: ( 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:993:3: 'v1' (lv_v1_2= RULE_INT )* (lv_v2_3= RULE_ID )
                    {
                    match(input,30,FOLLOW_30_in_ruleConsumed12208); 

                            createLeafNode(grammarAccess.getConsumed1Access().getV1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:997:1: (lv_v1_2= RULE_INT )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_INT) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:999:6: lv_v1_2= RULE_INT
                    	    {
                    	    lv_v1_2=(Token)input.LT(1);
                    	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleConsumed12230); 

                    	    		createLeafNode(grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_0_1_0(), "v1"); 
                    	    	

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "v1", lv_v1_2, "INT", lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1017:3: (lv_v2_3= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1019:6: lv_v2_3= RULE_ID
                    {
                    lv_v2_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConsumed12261); 

                    		createLeafNode(grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_0_2_0(), "v2"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "v2", lv_v2_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1038:6: ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1038:6: ( 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1038:7: 'v2' (lv_v2_5= RULE_ID )* (lv_v1_6= RULE_INT )
                    {
                    match(input,31,FOLLOW_31_in_ruleConsumed12286); 

                            createLeafNode(grammarAccess.getConsumed1Access().getV2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1042:1: (lv_v2_5= RULE_ID )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1044:6: lv_v2_5= RULE_ID
                    	    {
                    	    lv_v2_5=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConsumed12308); 

                    	    		createLeafNode(grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_1_1_0(), "v2"); 
                    	    	

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "v2", lv_v2_5, "ID", lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1062:3: (lv_v1_6= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1064:6: lv_v1_6= RULE_INT
                    {
                    lv_v1_6=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleConsumed12339); 

                    		createLeafNode(grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_1_2_0(), "v1"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "v1", lv_v1_6, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end ruleConsumed1


    // $ANTLR start entryRuleConsumed2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1089:1: entryRuleConsumed2 returns [EObject current=null] : iv_ruleConsumed2= ruleConsumed2 EOF ;
    public final EObject entryRuleConsumed2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1089:51: (iv_ruleConsumed2= ruleConsumed2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1090:2: iv_ruleConsumed2= ruleConsumed2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConsumed2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleConsumed2_in_entryRuleConsumed22382);
            iv_ruleConsumed2=ruleConsumed2();
            _fsp--;

             current =iv_ruleConsumed2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConsumed22392); 

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
    // $ANTLR end entryRuleConsumed2


    // $ANTLR start ruleConsumed2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1097:1: ruleConsumed2 returns [EObject current=null] : ( '#7' (lv_child_1= ruleConsumed1 ) ) ;
    public final EObject ruleConsumed2() throws RecognitionException {
        EObject current = null;

        EObject lv_child_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1102:6: ( ( '#7' (lv_child_1= ruleConsumed1 ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1103:1: ( '#7' (lv_child_1= ruleConsumed1 ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1103:1: ( '#7' (lv_child_1= ruleConsumed1 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1103:2: '#7' (lv_child_1= ruleConsumed1 )
            {
            match(input,32,FOLLOW_32_in_ruleConsumed22426); 

                    createLeafNode(grammarAccess.getConsumed2Access().getNumberSignDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1107:1: (lv_child_1= ruleConsumed1 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1110:6: lv_child_1= ruleConsumed1
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConsumed2Access().getChildConsumed1ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConsumed1_in_ruleConsumed22460);
            lv_child_1=ruleConsumed1();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConsumed2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "child", lv_child_1, "Consumed1", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleConsumed2


    // $ANTLR start entryRuleLoop1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1135:1: entryRuleLoop1 returns [EObject current=null] : iv_ruleLoop1= ruleLoop1 EOF ;
    public final EObject entryRuleLoop1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1135:47: (iv_ruleLoop1= ruleLoop1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1136:2: iv_ruleLoop1= ruleLoop1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop1_in_entryRuleLoop12497);
            iv_ruleLoop1=ruleLoop1();
            _fsp--;

             current =iv_ruleLoop1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop12507); 

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
    // $ANTLR end entryRuleLoop1


    // $ANTLR start ruleLoop1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1143:1: ruleLoop1 returns [EObject current=null] : ( ( 'kw0' )? '#8' (lv_id_2= RULE_ID ) ( 'kw1' )? (lv_id_4= RULE_ID ) ( ( 'kw2' )* 'kw30' )+ ) ;
    public final EObject ruleLoop1() throws RecognitionException {
        EObject current = null;

        Token lv_id_2=null;
        Token lv_id_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1148:6: ( ( ( 'kw0' )? '#8' (lv_id_2= RULE_ID ) ( 'kw1' )? (lv_id_4= RULE_ID ) ( ( 'kw2' )* 'kw30' )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1149:1: ( ( 'kw0' )? '#8' (lv_id_2= RULE_ID ) ( 'kw1' )? (lv_id_4= RULE_ID ) ( ( 'kw2' )* 'kw30' )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1149:1: ( ( 'kw0' )? '#8' (lv_id_2= RULE_ID ) ( 'kw1' )? (lv_id_4= RULE_ID ) ( ( 'kw2' )* 'kw30' )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1149:2: ( 'kw0' )? '#8' (lv_id_2= RULE_ID ) ( 'kw1' )? (lv_id_4= RULE_ID ) ( ( 'kw2' )* 'kw30' )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1149:2: ( 'kw0' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1149:3: 'kw0'
                    {
                    match(input,33,FOLLOW_33_in_ruleLoop12542); 

                            createLeafNode(grammarAccess.getLoop1Access().getKw0Keyword_0(), null); 
                        

                    }
                    break;

            }

            match(input,34,FOLLOW_34_in_ruleLoop12553); 

                    createLeafNode(grammarAccess.getLoop1Access().getNumberSignDigitEightKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1157:1: (lv_id_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1159:6: lv_id_2= RULE_ID
            {
            lv_id_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop12575); 

            		createLeafNode(grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1177:2: ( 'kw1' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1177:3: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop12593); 

                            createLeafNode(grammarAccess.getLoop1Access().getKw1Keyword_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1181:3: (lv_id_4= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1183:6: lv_id_4= RULE_ID
            {
            lv_id_4=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop12617); 

            		createLeafNode(grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_4_0(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_4, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1201:2: ( ( 'kw2' )* 'kw30' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==36) ) {
                    int LA18_2 = input.LA(2);

                    if ( ((LA18_2>=36 && LA18_2<=37)) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==37) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1201:3: ( 'kw2' )* 'kw30'
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1201:3: ( 'kw2' )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==36) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1201:4: 'kw2'
            	    	    {
            	    	    match(input,36,FOLLOW_36_in_ruleLoop12636); 

            	    	            createLeafNode(grammarAccess.getLoop1Access().getKw2Keyword_5_0(), null); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);

            	    match(input,37,FOLLOW_37_in_ruleLoop12647); 

            	            createLeafNode(grammarAccess.getLoop1Access().getKw30Keyword_5_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
    // $ANTLR end ruleLoop1


    // $ANTLR start entryRuleLoop2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1216:1: entryRuleLoop2 returns [EObject current=null] : iv_ruleLoop2= ruleLoop2 EOF ;
    public final EObject entryRuleLoop2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1216:47: (iv_ruleLoop2= ruleLoop2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1217:2: iv_ruleLoop2= ruleLoop2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop2_in_entryRuleLoop22682);
            iv_ruleLoop2=ruleLoop2();
            _fsp--;

             current =iv_ruleLoop2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop22692); 

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
    // $ANTLR end entryRuleLoop2


    // $ANTLR start ruleLoop2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1224:1: ruleLoop2 returns [EObject current=null] : ( '#9' (lv_id_1= RULE_ID ) ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) ) ( 'kw3' | ( (lv_id_6= RULE_ID ) 'kw4' ) )? ( 'kw5' | 'kw6' ) ) ;
    public final EObject ruleLoop2() throws RecognitionException {
        EObject current = null;

        Token lv_id_1=null;
        Token lv_id_3=null;
        Token lv_id_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1229:6: ( ( '#9' (lv_id_1= RULE_ID ) ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) ) ( 'kw3' | ( (lv_id_6= RULE_ID ) 'kw4' ) )? ( 'kw5' | 'kw6' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1230:1: ( '#9' (lv_id_1= RULE_ID ) ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) ) ( 'kw3' | ( (lv_id_6= RULE_ID ) 'kw4' ) )? ( 'kw5' | 'kw6' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1230:1: ( '#9' (lv_id_1= RULE_ID ) ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) ) ( 'kw3' | ( (lv_id_6= RULE_ID ) 'kw4' ) )? ( 'kw5' | 'kw6' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1230:2: '#9' (lv_id_1= RULE_ID ) ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) ) ( 'kw3' | ( (lv_id_6= RULE_ID ) 'kw4' ) )? ( 'kw5' | 'kw6' )
            {
            match(input,38,FOLLOW_38_in_ruleLoop22726); 

                    createLeafNode(grammarAccess.getLoop2Access().getNumberSignDigitNineKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1234:1: (lv_id_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1236:6: lv_id_1= RULE_ID
            {
            lv_id_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop22748); 

            		createLeafNode(grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_1_0(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1254:2: ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1254:2: ( 'kw1' | ( (lv_id_3= RULE_ID ) 'kw2' ) )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1254:3: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop22766); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw1Keyword_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1259:6: ( (lv_id_3= RULE_ID ) 'kw2' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1259:6: ( (lv_id_3= RULE_ID ) 'kw2' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1259:7: (lv_id_3= RULE_ID ) 'kw2'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1259:7: (lv_id_3= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1261:6: lv_id_3= RULE_ID
                    {
                    lv_id_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop22795); 

                    		createLeafNode(grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_2_1_0_0(), "id"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLoop2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "id", lv_id_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,36,FOLLOW_36_in_ruleLoop22812); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw2Keyword_2_1_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1283:3: ( 'kw3' | ( (lv_id_6= RULE_ID ) 'kw4' ) )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
                alt20=2;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1283:4: 'kw3'
                    {
                    match(input,39,FOLLOW_39_in_ruleLoop22824); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw3Keyword_3_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1288:6: ( (lv_id_6= RULE_ID ) 'kw4' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1288:6: ( (lv_id_6= RULE_ID ) 'kw4' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1288:7: (lv_id_6= RULE_ID ) 'kw4'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1288:7: (lv_id_6= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1290:6: lv_id_6= RULE_ID
                    {
                    lv_id_6=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop22853); 

                    		createLeafNode(grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_3_1_0_0(), "id"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLoop2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "id", lv_id_6, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,40,FOLLOW_40_in_ruleLoop22870); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw4Keyword_3_1_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1312:4: ( 'kw5' | 'kw6' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            else if ( (LA21_0==42) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1312:4: ( 'kw5' | 'kw6' )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1312:5: 'kw5'
                    {
                    match(input,41,FOLLOW_41_in_ruleLoop22883); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw5Keyword_4_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1317:6: 'kw6'
                    {
                    match(input,42,FOLLOW_42_in_ruleLoop22898); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw6Keyword_4_1(), null); 
                        

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
    // $ANTLR end ruleLoop2


    // $ANTLR start entryRuleLoop3
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1328:1: entryRuleLoop3 returns [EObject current=null] : iv_ruleLoop3= ruleLoop3 EOF ;
    public final EObject entryRuleLoop3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1328:47: (iv_ruleLoop3= ruleLoop3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1329:2: iv_ruleLoop3= ruleLoop3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop3Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop3_in_entryRuleLoop32932);
            iv_ruleLoop3=ruleLoop3();
            _fsp--;

             current =iv_ruleLoop3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop32942); 

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
    // $ANTLR end entryRuleLoop3


    // $ANTLR start ruleLoop3
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1336:1: ruleLoop3 returns [EObject current=null] : ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' (lv_id_4= RULE_ID ) ( 'kw4' (lv_id_6= RULE_ID ) 'kw5' )* ) ;
    public final EObject ruleLoop3() throws RecognitionException {
        EObject current = null;

        Token lv_id_4=null;
        Token lv_id_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1341:6: ( ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' (lv_id_4= RULE_ID ) ( 'kw4' (lv_id_6= RULE_ID ) 'kw5' )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:1: ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' (lv_id_4= RULE_ID ) ( 'kw4' (lv_id_6= RULE_ID ) 'kw5' )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:1: ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' (lv_id_4= RULE_ID ) ( 'kw4' (lv_id_6= RULE_ID ) 'kw5' )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:2: ( 'kw1' | 'kw2' | 'kw3' ) '#10' (lv_id_4= RULE_ID ) ( 'kw4' (lv_id_6= RULE_ID ) 'kw5' )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:2: ( 'kw1' | 'kw2' | 'kw3' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt22=1;
                }
                break;
            case 36:
                {
                alt22=2;
                }
                break;
            case 39:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1342:2: ( 'kw1' | 'kw2' | 'kw3' )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:3: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop32977); 

                            createLeafNode(grammarAccess.getLoop3Access().getKw1Keyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1347:6: 'kw2'
                    {
                    match(input,36,FOLLOW_36_in_ruleLoop32992); 

                            createLeafNode(grammarAccess.getLoop3Access().getKw2Keyword_0_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1352:6: 'kw3'
                    {
                    match(input,39,FOLLOW_39_in_ruleLoop33007); 

                            createLeafNode(grammarAccess.getLoop3Access().getKw3Keyword_0_2(), null); 
                        

                    }
                    break;

            }

            match(input,43,FOLLOW_43_in_ruleLoop33017); 

                    createLeafNode(grammarAccess.getLoop3Access().getNumberSignDigitOneDigitZeroKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1360:1: (lv_id_4= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1362:6: lv_id_4= RULE_ID
            {
            lv_id_4=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop33039); 

            		createLeafNode(grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_4, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1380:2: ( 'kw4' (lv_id_6= RULE_ID ) 'kw5' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==40) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1380:3: 'kw4' (lv_id_6= RULE_ID ) 'kw5'
            	    {
            	    match(input,40,FOLLOW_40_in_ruleLoop33057); 

            	            createLeafNode(grammarAccess.getLoop3Access().getKw4Keyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1384:1: (lv_id_6= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1386:6: lv_id_6= RULE_ID
            	    {
            	    lv_id_6=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop33079); 

            	    		createLeafNode(grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_3_1_0(), "id"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoop3Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "id", lv_id_6, "ID", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }

            	    match(input,41,FOLLOW_41_in_ruleLoop33096); 

            	            createLeafNode(grammarAccess.getLoop3Access().getKw5Keyword_3_2(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end ruleLoop3


    // $ANTLR start entryRuleLoop4
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1415:1: entryRuleLoop4 returns [EObject current=null] : iv_ruleLoop4= ruleLoop4 EOF ;
    public final EObject entryRuleLoop4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop4 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1415:47: (iv_ruleLoop4= ruleLoop4 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1416:2: iv_ruleLoop4= ruleLoop4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop4Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop4_in_entryRuleLoop43131);
            iv_ruleLoop4=ruleLoop4();
            _fsp--;

             current =iv_ruleLoop4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop43141); 

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
    // $ANTLR end entryRuleLoop4


    // $ANTLR start ruleLoop4
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1423:1: ruleLoop4 returns [EObject current=null] : ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) (lv_id_5= RULE_ID ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ ) ;
    public final EObject ruleLoop4() throws RecognitionException {
        EObject current = null;

        Token lv_id_5=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1428:6: ( ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) (lv_id_5= RULE_ID ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:1: ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) (lv_id_5= RULE_ID ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:1: ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) (lv_id_5= RULE_ID ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:2: '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) (lv_id_5= RULE_ID ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+
            {
            match(input,44,FOLLOW_44_in_ruleLoop43175); 

                    createLeafNode(grammarAccess.getLoop4Access().getNumberSignDigitOneDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1433:1: ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt24=1;
                }
                break;
            case 36:
                {
                alt24=2;
                }
                break;
            case 39:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1433:1: ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1433:2: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop43185); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw1Keyword_1_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1438:6: 'kw2'
                    {
                    match(input,36,FOLLOW_36_in_ruleLoop43200); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw2Keyword_1_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1443:6: ( 'kw3' 'kw4' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1443:6: ( 'kw3' 'kw4' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1443:7: 'kw3' 'kw4'
                    {
                    match(input,39,FOLLOW_39_in_ruleLoop43216); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw3Keyword_1_2_0(), null); 
                        
                    match(input,40,FOLLOW_40_in_ruleLoop43225); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw4Keyword_1_2_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1451:3: (lv_id_5= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1453:6: lv_id_5= RULE_ID
            {
            lv_id_5=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop43249); 

            		createLeafNode(grammarAccess.getLoop4Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "id", lv_id_5, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1471:2: ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1471:3: 'kw5' ( 'kw6' ( 'kw7' )? )?
            	    {
            	    match(input,41,FOLLOW_41_in_ruleLoop43267); 

            	            createLeafNode(grammarAccess.getLoop4Access().getKw5Keyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1475:1: ( 'kw6' ( 'kw7' )? )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==42) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1475:2: 'kw6' ( 'kw7' )?
            	            {
            	            match(input,42,FOLLOW_42_in_ruleLoop43277); 

            	                    createLeafNode(grammarAccess.getLoop4Access().getKw6Keyword_3_1_0(), null); 
            	                
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1479:1: ( 'kw7' )?
            	            int alt25=2;
            	            int LA25_0 = input.LA(1);

            	            if ( (LA25_0==45) ) {
            	                alt25=1;
            	            }
            	            switch (alt25) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1479:2: 'kw7'
            	                    {
            	                    match(input,45,FOLLOW_45_in_ruleLoop43287); 

            	                            createLeafNode(grammarAccess.getLoop4Access().getKw7Keyword_3_1_1(), null); 
            	                        

            	                    }
            	                    break;

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
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
    // $ANTLR end ruleLoop4


    // $ANTLR start entryRuleLoopBug285452
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1490:1: entryRuleLoopBug285452 returns [EObject current=null] : iv_ruleLoopBug285452= ruleLoopBug285452 EOF ;
    public final EObject entryRuleLoopBug285452() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopBug285452 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1490:55: (iv_ruleLoopBug285452= ruleLoopBug285452 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1491:2: iv_ruleLoopBug285452= ruleLoopBug285452 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopBug285452Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523326);
            iv_ruleLoopBug285452=ruleLoopBug285452();
            _fsp--;

             current =iv_ruleLoopBug285452; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoopBug2854523336); 

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
    // $ANTLR end entryRuleLoopBug285452


    // $ANTLR start ruleLoopBug285452
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1498:1: ruleLoopBug285452 returns [EObject current=null] : ( '#12' ( (lv_interface_1= 'interface' ) | 'class' ) (lv_name_3= RULE_ID ) ) ;
    public final EObject ruleLoopBug285452() throws RecognitionException {
        EObject current = null;

        Token lv_interface_1=null;
        Token lv_name_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1503:6: ( ( '#12' ( (lv_interface_1= 'interface' ) | 'class' ) (lv_name_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1504:1: ( '#12' ( (lv_interface_1= 'interface' ) | 'class' ) (lv_name_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1504:1: ( '#12' ( (lv_interface_1= 'interface' ) | 'class' ) (lv_name_3= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1504:2: '#12' ( (lv_interface_1= 'interface' ) | 'class' ) (lv_name_3= RULE_ID )
            {
            match(input,46,FOLLOW_46_in_ruleLoopBug2854523370); 

                    createLeafNode(grammarAccess.getLoopBug285452Access().getNumberSignDigitOneDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1508:1: ( (lv_interface_1= 'interface' ) | 'class' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==47) ) {
                alt28=1;
            }
            else if ( (LA28_0==48) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1508:1: ( (lv_interface_1= 'interface' ) | 'class' )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1508:2: (lv_interface_1= 'interface' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1508:2: (lv_interface_1= 'interface' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1510:6: lv_interface_1= 'interface'
                    {
                    lv_interface_1=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleLoopBug2854523392); 

                            createLeafNode(grammarAccess.getLoopBug285452Access().getInterfaceInterfaceKeyword_1_0_0(), "interface"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLoopBug285452Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "interface", true, "interface", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1530:6: 'class'
                    {
                    match(input,48,FOLLOW_48_in_ruleLoopBug2854523420); 

                            createLeafNode(grammarAccess.getLoopBug285452Access().getClassKeyword_1_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1534:2: (lv_name_3= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1536:6: lv_name_3= RULE_ID
            {
            lv_name_3=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoopBug2854523443); 

            		createLeafNode(grammarAccess.getLoopBug285452Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoopBug285452Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_3, "ID", lastConsumedNode);
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
    // $ANTLR end ruleLoopBug285452


    // $ANTLR start entryRuleDuplicateBug284491
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1561:1: entryRuleDuplicateBug284491 returns [EObject current=null] : iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF ;
    public final EObject entryRuleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDuplicateBug284491 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1561:60: (iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1562:2: iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDuplicateBug284491Rule(), currentNode); 
            pushFollow(FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913484);
            iv_ruleDuplicateBug284491=ruleDuplicateBug284491();
            _fsp--;

             current =iv_ruleDuplicateBug284491; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDuplicateBug2844913494); 

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
    // $ANTLR end entryRuleDuplicateBug284491


    // $ANTLR start ruleDuplicateBug284491
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1569:1: ruleDuplicateBug284491 returns [EObject current=null] : ( '#13' ( (lv_static_1= 'static' ) | (lv_final_2= 'final' ) | (lv_transient_3= 'transient' ) )* ) ;
    public final EObject ruleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        Token lv_static_1=null;
        Token lv_final_2=null;
        Token lv_transient_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1574:6: ( ( '#13' ( (lv_static_1= 'static' ) | (lv_final_2= 'final' ) | (lv_transient_3= 'transient' ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1575:1: ( '#13' ( (lv_static_1= 'static' ) | (lv_final_2= 'final' ) | (lv_transient_3= 'transient' ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1575:1: ( '#13' ( (lv_static_1= 'static' ) | (lv_final_2= 'final' ) | (lv_transient_3= 'transient' ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1575:2: '#13' ( (lv_static_1= 'static' ) | (lv_final_2= 'final' ) | (lv_transient_3= 'transient' ) )*
            {
            match(input,49,FOLLOW_49_in_ruleDuplicateBug2844913528); 

                    createLeafNode(grammarAccess.getDuplicateBug284491Access().getNumberSignDigitOneDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1579:1: ( (lv_static_1= 'static' ) | (lv_final_2= 'final' ) | (lv_transient_3= 'transient' ) )*
            loop29:
            do {
                int alt29=4;
                switch ( input.LA(1) ) {
                case 50:
                    {
                    alt29=1;
                    }
                    break;
                case 51:
                    {
                    alt29=2;
                    }
                    break;
                case 52:
                    {
                    alt29=3;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1579:2: (lv_static_1= 'static' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1579:2: (lv_static_1= 'static' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1581:6: lv_static_1= 'static'
            	    {
            	    lv_static_1=(Token)input.LT(1);
            	    match(input,50,FOLLOW_50_in_ruleDuplicateBug2844913550); 

            	            createLeafNode(grammarAccess.getDuplicateBug284491Access().getStaticStaticKeyword_1_0_0(), "static"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDuplicateBug284491Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "static", true, "static", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1601:6: (lv_final_2= 'final' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1601:6: (lv_final_2= 'final' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1603:6: lv_final_2= 'final'
            	    {
            	    lv_final_2=(Token)input.LT(1);
            	    match(input,51,FOLLOW_51_in_ruleDuplicateBug2844913590); 

            	            createLeafNode(grammarAccess.getDuplicateBug284491Access().getFinalFinalKeyword_1_1_0(), "final"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDuplicateBug284491Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "final", true, "final", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1623:6: (lv_transient_3= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1623:6: (lv_transient_3= 'transient' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1625:6: lv_transient_3= 'transient'
            	    {
            	    lv_transient_3=(Token)input.LT(1);
            	    match(input,52,FOLLOW_52_in_ruleDuplicateBug2844913630); 

            	            createLeafNode(grammarAccess.getDuplicateBug284491Access().getTransientTransientKeyword_1_2_0(), "transient"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDuplicateBug284491Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "transient", true, "transient", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // $ANTLR end ruleDuplicateBug284491


    // $ANTLR start entryRuleEmptyObjectBug284850
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1651:1: entryRuleEmptyObjectBug284850 returns [EObject current=null] : iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF ;
    public final EObject entryRuleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectBug284850 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1651:62: (iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1652:2: iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectBug284850Rule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848503678);
            iv_ruleEmptyObjectBug284850=ruleEmptyObjectBug284850();
            _fsp--;

             current =iv_ruleEmptyObjectBug284850; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyObjectBug2848503688); 

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
    // $ANTLR end entryRuleEmptyObjectBug284850


    // $ANTLR start ruleEmptyObjectBug284850
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1659:1: ruleEmptyObjectBug284850 returns [EObject current=null] : ( '#14' (lv_items_1= ruleEmptyObjectItems ) ) ;
    public final EObject ruleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1664:6: ( ( '#14' (lv_items_1= ruleEmptyObjectItems ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1665:1: ( '#14' (lv_items_1= ruleEmptyObjectItems ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1665:1: ( '#14' (lv_items_1= ruleEmptyObjectItems ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1665:2: '#14' (lv_items_1= ruleEmptyObjectItems )
            {
            match(input,53,FOLLOW_53_in_ruleEmptyObjectBug2848503722); 

                    createLeafNode(grammarAccess.getEmptyObjectBug284850Access().getNumberSignDigitOneDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1669:1: (lv_items_1= ruleEmptyObjectItems )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1672:6: lv_items_1= ruleEmptyObjectItems
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEmptyObjectBug284850Access().getItemsEmptyObjectItemsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848503756);
            lv_items_1=ruleEmptyObjectItems();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEmptyObjectBug284850Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "items", lv_items_1, "EmptyObjectItems", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleEmptyObjectBug284850


    // $ANTLR start entryRuleEmptyObjectItems
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1697:1: entryRuleEmptyObjectItems returns [EObject current=null] : iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF ;
    public final EObject entryRuleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItems = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1697:58: (iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1698:2: iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectItemsRule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems3793);
            iv_ruleEmptyObjectItems=ruleEmptyObjectItems();
            _fsp--;

             current =iv_ruleEmptyObjectItems; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyObjectItems3803); 

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
    // $ANTLR end entryRuleEmptyObjectItems


    // $ANTLR start ruleEmptyObjectItems
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1705:1: ruleEmptyObjectItems returns [EObject current=null] : (lv_list_0= ruleEmptyObjectItem )* ;
    public final EObject ruleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject lv_list_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1710:6: ( (lv_list_0= ruleEmptyObjectItem )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1711:1: (lv_list_0= ruleEmptyObjectItem )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1711:1: (lv_list_0= ruleEmptyObjectItem )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==54) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1714:6: lv_list_0= ruleEmptyObjectItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEmptyObjectItemsAccess().getListEmptyObjectItemParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems3861);
            	    lv_list_0=ruleEmptyObjectItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEmptyObjectItemsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "list", lv_list_0, "EmptyObjectItem", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


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
    // $ANTLR end ruleEmptyObjectItems


    // $ANTLR start entryRuleEmptyObjectItem
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1739:1: entryRuleEmptyObjectItem returns [EObject current=null] : iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF ;
    public final EObject entryRuleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItem = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1739:57: (iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1740:2: iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectItemRule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem3898);
            iv_ruleEmptyObjectItem=ruleEmptyObjectItem();
            _fsp--;

             current =iv_ruleEmptyObjectItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyObjectItem3908); 

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
    // $ANTLR end entryRuleEmptyObjectItem


    // $ANTLR start ruleEmptyObjectItem
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1747:1: ruleEmptyObjectItem returns [EObject current=null] : ( 'item' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1752:6: ( ( 'item' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1753:1: ( 'item' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1753:1: ( 'item' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1753:2: 'item' (lv_name_1= RULE_ID )
            {
            match(input,54,FOLLOW_54_in_ruleEmptyObjectItem3942); 

                    createLeafNode(grammarAccess.getEmptyObjectItemAccess().getItemKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1757:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1759:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEmptyObjectItem3964); 

            		createLeafNode(grammarAccess.getEmptyObjectItemAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEmptyObjectItemRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleEmptyObjectItem


    // $ANTLR start entryRuleMultiInheritanceBug280439
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1784:1: entryRuleMultiInheritanceBug280439 returns [EObject current=null] : iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF ;
    public final EObject entryRuleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiInheritanceBug280439 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1784:67: (iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1785:2: iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiInheritanceBug280439Rule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804394005);
            iv_ruleMultiInheritanceBug280439=ruleMultiInheritanceBug280439();
            _fsp--;

             current =iv_ruleMultiInheritanceBug280439; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804394015); 

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
    // $ANTLR end entryRuleMultiInheritanceBug280439


    // $ANTLR start ruleMultiInheritanceBug280439
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1792:1: ruleMultiInheritanceBug280439 returns [EObject current=null] : ( '#15' (lv_val_1= ruleConcreteMulti ) ) ;
    public final EObject ruleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        EObject lv_val_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1797:6: ( ( '#15' (lv_val_1= ruleConcreteMulti ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1798:1: ( '#15' (lv_val_1= ruleConcreteMulti ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1798:1: ( '#15' (lv_val_1= ruleConcreteMulti ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1798:2: '#15' (lv_val_1= ruleConcreteMulti )
            {
            match(input,55,FOLLOW_55_in_ruleMultiInheritanceBug2804394049); 

                    createLeafNode(grammarAccess.getMultiInheritanceBug280439Access().getNumberSignDigitOneDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1802:1: (lv_val_1= ruleConcreteMulti )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1805:6: lv_val_1= ruleConcreteMulti
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiInheritanceBug280439Access().getValConcreteMultiParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804394083);
            lv_val_1=ruleConcreteMulti();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiInheritanceBug280439Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "val", lv_val_1, "ConcreteMulti", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleMultiInheritanceBug280439


    // $ANTLR start entryRuleConcreteMulti
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1834:1: entryRuleConcreteMulti returns [EObject current=null] : iv_ruleConcreteMulti= ruleConcreteMulti EOF ;
    public final EObject entryRuleConcreteMulti() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteMulti = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1834:55: (iv_ruleConcreteMulti= ruleConcreteMulti EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1835:2: iv_ruleConcreteMulti= ruleConcreteMulti EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteMultiRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti4124);
            iv_ruleConcreteMulti=ruleConcreteMulti();
            _fsp--;

             current =iv_ruleConcreteMulti; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteMulti4134); 

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
    // $ANTLR end entryRuleConcreteMulti


    // $ANTLR start ruleConcreteMulti
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1842:1: ruleConcreteMulti returns [EObject current=null] : ( (lv_m1_0= RULE_ID ) (lv_m2_1= RULE_ID ) ) ;
    public final EObject ruleConcreteMulti() throws RecognitionException {
        EObject current = null;

        Token lv_m1_0=null;
        Token lv_m2_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1847:6: ( ( (lv_m1_0= RULE_ID ) (lv_m2_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1848:1: ( (lv_m1_0= RULE_ID ) (lv_m2_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1848:1: ( (lv_m1_0= RULE_ID ) (lv_m2_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1848:2: (lv_m1_0= RULE_ID ) (lv_m2_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1848:2: (lv_m1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1850:6: lv_m1_0= RULE_ID
            {
            lv_m1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConcreteMulti4181); 

            		createLeafNode(grammarAccess.getConcreteMultiAccess().getM1IDTerminalRuleCall_0_0(), "m1"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcreteMultiRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "m1", lv_m1_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1868:2: (lv_m2_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1870:6: lv_m2_1= RULE_ID
            {
            lv_m2_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConcreteMulti4211); 

            		createLeafNode(grammarAccess.getConcreteMultiAccess().getM2IDTerminalRuleCall_1_0(), "m2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcreteMultiRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "m2", lv_m2_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleConcreteMulti


 

    public static final BitSet FOLLOW_ruleOp_in_entryRuleOp73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOp83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp130 = new BitSet(new long[]{0x00A250DF24A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp173 = new BitSet(new long[]{0x00A250DF24A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleTerm377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_ruleTerm404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_ruleTerm431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_ruleTerm458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransient1_in_ruleTerm485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed1_in_ruleTerm512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed2_in_ruleTerm539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop1_in_ruleTerm566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop2_in_ruleTerm593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop3_in_ruleTerm620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop4_in_ruleTerm647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoopBug285452_in_ruleTerm674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDuplicateBug284491_in_ruleTerm701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParens927 = new BitSet(new long[]{0x00A250DF24A58830L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens949 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParens957 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleParens978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers1025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1082 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1112 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTwoNumbers1130 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1152 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings1195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleManyStrings1239 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1261 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleType1377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1399 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleType1416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRef21488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRef21522 = new BitSet(new long[]{0x0000000000180040L});
    public static final BitSet FOLLOW_19_in_ruleRef21544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRef21572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_entryRuleSpare1620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpare1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSpare1664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1686 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleSpare1704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1726 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBoolean1813 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleBoolean1834 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleBoolean1857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransient1_in_entryRuleTransient11920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransient11930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTransient11964 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_ruleTransient11986 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTransient12027 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleTransient12046 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_ruleTransient12068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTransient12109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed1_in_entryRuleConsumed12153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConsumed12163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleConsumed12197 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleConsumed12208 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12230 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleConsumed12286 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12308 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed2_in_entryRuleConsumed22382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConsumed22392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleConsumed22426 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleConsumed1_in_ruleConsumed22460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop1_in_entryRuleLoop12497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop12507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleLoop12542 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleLoop12553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12575 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_35_in_ruleLoop12593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12617 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_36_in_ruleLoop12636 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_37_in_ruleLoop12647 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleLoop2_in_entryRuleLoop22682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop22692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleLoop22726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22748 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_35_in_ruleLoop22766 = new BitSet(new long[]{0x0000068000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22795 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleLoop22812 = new BitSet(new long[]{0x0000068000000010L});
    public static final BitSet FOLLOW_39_in_ruleLoop22824 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22853 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleLoop22870 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_41_in_ruleLoop22883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLoop22898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop3_in_entryRuleLoop32932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop32942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLoop32977 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_36_in_ruleLoop32992 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_39_in_ruleLoop33007 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleLoop33017 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop33039 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleLoop33057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop33079 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleLoop33096 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleLoop4_in_entryRuleLoop43131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop43141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLoop43175 = new BitSet(new long[]{0x0000009800000000L});
    public static final BitSet FOLLOW_35_in_ruleLoop43185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_36_in_ruleLoop43200 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_39_in_ruleLoop43216 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleLoop43225 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop43249 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleLoop43267 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_42_in_ruleLoop43277 = new BitSet(new long[]{0x0000220000000002L});
    public static final BitSet FOLLOW_45_in_ruleLoop43287 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoopBug2854523336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLoopBug2854523370 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_ruleLoopBug2854523392 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_48_in_ruleLoopBug2854523420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoopBug2854523443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDuplicateBug2844913494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDuplicateBug2844913528 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDuplicateBug2844913550 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDuplicateBug2844913590 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_52_in_ruleDuplicateBug2844913630 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848503678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectBug2848503688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleEmptyObjectBug2848503722 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848503756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems3793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItems3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems3861 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem3898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItem3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleEmptyObjectItem3942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEmptyObjectItem3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804394005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804394015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleMultiInheritanceBug2804394049 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804394083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti4124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteMulti4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti4181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti4211 = new BitSet(new long[]{0x0000000000000002L});

}
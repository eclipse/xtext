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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:80:1: ruleOp returns [EObject current=null] : (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term_0 = null;

        EObject lv_values_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:85:6: ( (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:86:1: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:86:1: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:87:5: this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getOpAccess().getTermParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp130);
            this_Term_0=ruleTerm();
            _fsp--;

             
                    current = this_Term_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:95:1: ( () ( (lv_values_2_0= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||LA1_0==21||LA1_0==23||LA1_0==26||LA1_0==29||(LA1_0>=32 && LA1_0<=36)||(LA1_0>=38 && LA1_0<=39)||LA1_0==44||LA1_0==46||LA1_0==49||LA1_0==53||LA1_0==55) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:95:2: () ( (lv_values_2_0= ruleTerm ) )
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

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:111:2: ( (lv_values_2_0= ruleTerm ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:112:1: (lv_values_2_0= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:112:1: (lv_values_2_0= ruleTerm )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:113:3: lv_values_2_0= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOpAccess().getValuesTermParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp160);
            	    lv_values_2_0=ruleTerm();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOpRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"values",
            	    	        		lv_values_2_0, 
            	    	        		"Term", 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:142:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:142:46: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:143:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm195);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm205); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:150:1: ruleTerm returns [EObject current=null] : (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 ) ;
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


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:155:6: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:156:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:156:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 )
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
                    new NoViableAltException("156:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Parens_3= ruleParens | this_Type_4= ruleType | this_Ref2_5= ruleRef2 | this_Spare_6= ruleSpare | this_Boolean_7= ruleBoolean | this_Transient1_8= ruleTransient1 | this_Consumed1_9= ruleConsumed1 | this_Consumed2_10= ruleConsumed2 | this_Loop1_11= ruleLoop1 | this_Loop2_12= ruleLoop2 | this_Loop3_13= ruleLoop3 | this_Loop4_14= ruleLoop4 | this_LoopBug285452_15= ruleLoopBug285452 | this_DuplicateBug284491_16= ruleDuplicateBug284491 | this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439 )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:157:5: this_Atom_0= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getAtomParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm252);
                    this_Atom_0=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:167:5: this_TwoNumbers_1= ruleTwoNumbers
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTwoNumbersParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTwoNumbers_in_ruleTerm279);
                    this_TwoNumbers_1=ruleTwoNumbers();
                    _fsp--;

                     
                            current = this_TwoNumbers_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:177:5: this_ManyStrings_2= ruleManyStrings
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getManyStringsParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleManyStrings_in_ruleTerm306);
                    this_ManyStrings_2=ruleManyStrings();
                    _fsp--;

                     
                            current = this_ManyStrings_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:187:5: this_Parens_3= ruleParens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getParensParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm333);
                    this_Parens_3=ruleParens();
                    _fsp--;

                     
                            current = this_Parens_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:197:5: this_Type_4= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTypeParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleTerm360);
                    this_Type_4=ruleType();
                    _fsp--;

                     
                            current = this_Type_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:207:5: this_Ref2_5= ruleRef2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getRef2ParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRef2_in_ruleTerm387);
                    this_Ref2_5=ruleRef2();
                    _fsp--;

                     
                            current = this_Ref2_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:217:5: this_Spare_6= ruleSpare
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getSpareParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSpare_in_ruleTerm414);
                    this_Spare_6=ruleSpare();
                    _fsp--;

                     
                            current = this_Spare_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:227:5: this_Boolean_7= ruleBoolean
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getBooleanParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBoolean_in_ruleTerm441);
                    this_Boolean_7=ruleBoolean();
                    _fsp--;

                     
                            current = this_Boolean_7; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:237:5: this_Transient1_8= ruleTransient1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTransient1ParserRuleCall_8(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransient1_in_ruleTerm468);
                    this_Transient1_8=ruleTransient1();
                    _fsp--;

                     
                            current = this_Transient1_8; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:247:5: this_Consumed1_9= ruleConsumed1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getConsumed1ParserRuleCall_9(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConsumed1_in_ruleTerm495);
                    this_Consumed1_9=ruleConsumed1();
                    _fsp--;

                     
                            current = this_Consumed1_9; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:257:5: this_Consumed2_10= ruleConsumed2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getConsumed2ParserRuleCall_10(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConsumed2_in_ruleTerm522);
                    this_Consumed2_10=ruleConsumed2();
                    _fsp--;

                     
                            current = this_Consumed2_10; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:267:5: this_Loop1_11= ruleLoop1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop1ParserRuleCall_11(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop1_in_ruleTerm549);
                    this_Loop1_11=ruleLoop1();
                    _fsp--;

                     
                            current = this_Loop1_11; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:277:5: this_Loop2_12= ruleLoop2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop2ParserRuleCall_12(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop2_in_ruleTerm576);
                    this_Loop2_12=ruleLoop2();
                    _fsp--;

                     
                            current = this_Loop2_12; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:287:5: this_Loop3_13= ruleLoop3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop3ParserRuleCall_13(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop3_in_ruleTerm603);
                    this_Loop3_13=ruleLoop3();
                    _fsp--;

                     
                            current = this_Loop3_13; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:297:5: this_Loop4_14= ruleLoop4
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop4ParserRuleCall_14(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoop4_in_ruleTerm630);
                    this_Loop4_14=ruleLoop4();
                    _fsp--;

                     
                            current = this_Loop4_14; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:307:5: this_LoopBug285452_15= ruleLoopBug285452
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoopBug285452ParserRuleCall_15(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLoopBug285452_in_ruleTerm657);
                    this_LoopBug285452_15=ruleLoopBug285452();
                    _fsp--;

                     
                            current = this_LoopBug285452_15; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:317:5: this_DuplicateBug284491_16= ruleDuplicateBug284491
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getDuplicateBug284491ParserRuleCall_16(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDuplicateBug284491_in_ruleTerm684);
                    this_DuplicateBug284491_16=ruleDuplicateBug284491();
                    _fsp--;

                     
                            current = this_DuplicateBug284491_16; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:327:5: this_EmptyObjectBug284850_17= ruleEmptyObjectBug284850
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getEmptyObjectBug284850ParserRuleCall_17(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm711);
                    this_EmptyObjectBug284850_17=ruleEmptyObjectBug284850();
                    _fsp--;

                     
                            current = this_EmptyObjectBug284850_17; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 19 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:337:5: this_MultiInheritanceBug280439_18= ruleMultiInheritanceBug280439
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getMultiInheritanceBug280439ParserRuleCall_18(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm738);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:352:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:352:46: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom770);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom780); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:360:1: ruleAtom returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:365:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:366:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:366:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:367:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:367:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:368:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom821); 

            			createLeafNode(grammarAccess.getAtomAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleParens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:397:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:397:48: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:398:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParensRule(), currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens858);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens868); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:405:1: ruleParens returns [EObject current=null] : ( '(' this_Op_1= ruleOp ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em_3_0=null;
        EObject this_Op_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:410:6: ( ( '(' this_Op_1= ruleOp ')' ( (lv_em_3_0= '!' ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:411:1: ( '(' this_Op_1= ruleOp ')' ( (lv_em_3_0= '!' ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:411:1: ( '(' this_Op_1= ruleOp ')' ( (lv_em_3_0= '!' ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:411:2: '(' this_Op_1= ruleOp ')' ( (lv_em_3_0= '!' ) )?
            {
            match(input,11,FOLLOW_11_in_ruleParens902); 

                    createLeafNode(grammarAccess.getParensAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParensAccess().getOpParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens924);
            this_Op_1=ruleOp();
            _fsp--;

             
                    current = this_Op_1; 
                    currentNode = currentNode.getParent();
                
            match(input,12,FOLLOW_12_in_ruleParens932); 

                    createLeafNode(grammarAccess.getParensAccess().getRightParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:428:1: ( (lv_em_3_0= '!' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:429:1: (lv_em_3_0= '!' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:429:1: (lv_em_3_0= '!' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:430:3: lv_em_3_0= '!'
                    {
                    lv_em_3_0=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParens949); 

                            createLeafNode(grammarAccess.getParensAccess().getEmExclamationMarkKeyword_3_0(), "em"); 
                        

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
    // $ANTLR end ruleParens


    // $ANTLR start entryRuleTwoNumbers
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:456:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:456:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:457:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoNumbersRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers996);
            iv_ruleTwoNumbers=ruleTwoNumbers();
            _fsp--;

             current =iv_ruleTwoNumbers; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoNumbers1006); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:464:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) ( '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1_0_0=null;
        Token lv_num2_1_0=null;
        Token lv_num3_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:469:6: ( ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) ( '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:470:1: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) ( '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:470:1: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) ( '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:470:2: ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) ( '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:470:2: ( (lv_num1_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:471:1: (lv_num1_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:471:1: (lv_num1_0_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:472:3: lv_num1_0_0= RULE_INT
            {
            lv_num1_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers1048); 

            			createLeafNode(grammarAccess.getTwoNumbersAccess().getNum1INTTerminalRuleCall_0_0(), "num1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoNumbersRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"num1",
            	        		lv_num1_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:494:2: ( (lv_num2_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:495:1: (lv_num2_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:495:1: (lv_num2_1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:496:3: lv_num2_1_0= RULE_INT
            {
            lv_num2_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers1070); 

            			createLeafNode(grammarAccess.getTwoNumbersAccess().getNum2INTTerminalRuleCall_1_0(), "num2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoNumbersRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"num2",
            	        		lv_num2_1_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:518:2: ( '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:518:3: '#' ( (lv_num3_3_0= RULE_INT ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTwoNumbers1085); 

            	            createLeafNode(grammarAccess.getTwoNumbersAccess().getNumberSignKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:522:1: ( (lv_num3_3_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:523:1: (lv_num3_3_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:523:1: (lv_num3_3_0= RULE_INT )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:524:3: lv_num3_3_0= RULE_INT
            	    {
            	    lv_num3_3_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers1102); 

            	    			createLeafNode(grammarAccess.getTwoNumbersAccess().getNum3INTTerminalRuleCall_2_1_0(), "num3"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTwoNumbersRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"num3",
            	    	        		lv_num3_3_0, 
            	    	        		"INT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:553:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:553:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:554:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode(grammarAccess.getManyStringsRule(), currentNode); 
            pushFollow(FOLLOW_ruleManyStrings_in_entryRuleManyStrings1142);
            iv_ruleManyStrings=ruleManyStrings();
            _fsp--;

             current =iv_ruleManyStrings; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManyStrings1152); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:561:1: ruleManyStrings returns [EObject current=null] : ( '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token lv_str1_1_0=null;
        Token lv_str2_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:566:6: ( ( '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:567:1: ( '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:567:1: ( '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:567:2: '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) )
            {
            match(input,15,FOLLOW_15_in_ruleManyStrings1186); 

                    createLeafNode(grammarAccess.getManyStringsAccess().getEqualsSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:571:1: ( (lv_str1_1_0= RULE_STRING ) )*
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:572:1: (lv_str1_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:572:1: (lv_str1_1_0= RULE_STRING )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:573:3: lv_str1_1_0= RULE_STRING
            	    {
            	    lv_str1_1_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1203); 

            	    			createLeafNode(grammarAccess.getManyStringsAccess().getStr1STRINGTerminalRuleCall_1_0(), "str1"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getManyStringsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"str1",
            	    	        		lv_str1_1_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:595:3: ( (lv_str2_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:596:1: (lv_str2_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:596:1: (lv_str2_2_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:597:3: lv_str2_2_0= RULE_STRING
            {
            lv_str2_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1226); 

            			createLeafNode(grammarAccess.getManyStringsAccess().getStr2STRINGTerminalRuleCall_2_0(), "str2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getManyStringsRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"str2",
            	        		lv_str2_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:627:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType1264);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1274); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:634:1: ruleType returns [EObject current=null] : ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:639:6: ( ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:640:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:640:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:640:2: 'type' ( (lv_name_1_0= RULE_ID ) ) 'extends' ( ( RULE_ID ) )
            {
            match(input,16,FOLLOW_16_in_ruleType1308); 

                    createLeafNode(grammarAccess.getTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:644:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:645:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:645:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:646:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1325); 

            			createLeafNode(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleType1339); 

                    createLeafNode(grammarAccess.getTypeAccess().getExtendsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:672:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:673:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:673:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:674:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1357); 

            		createLeafNode(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0(), "extends"); 
            	

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleRef2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:693:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:693:46: (iv_ruleRef2= ruleRef2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRef2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleRef2_in_entryRuleRef21390);
            iv_ruleRef2=ruleRef2();
            _fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRef21400); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:701:1: ruleRef2 returns [EObject current=null] : ( '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2_1_1=null;
        Token lv_ref2_1_2=null;
        Token lv_ref2_1_3=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:706:6: ( ( '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:707:1: ( '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:707:1: ( '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:707:2: '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            {
            match(input,18,FOLLOW_18_in_ruleRef21434); 

                    createLeafNode(grammarAccess.getRef2Access().getNumberSignDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:711:1: ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:712:1: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:712:1: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:713:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:713:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
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
                    new NoViableAltException("713:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:714:3: lv_ref2_1_1= 'mykeyword1'
                    {
                    lv_ref2_1_1=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleRef21453); 

                            createLeafNode(grammarAccess.getRef2Access().getRef2Mykeyword1Keyword_1_0_0(), "ref2"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRef2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "ref2", lv_ref2_1_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:732:8: lv_ref2_1_2= RULE_STRING
                    {
                    lv_ref2_1_2=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef21481); 

                    			createLeafNode(grammarAccess.getRef2Access().getRef2STRINGTerminalRuleCall_1_0_1(), "ref2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRef2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"ref2",
                    	        		lv_ref2_1_2, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:753:8: lv_ref2_1_3= 'mykeyword2'
                    {
                    lv_ref2_1_3=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleRef21501); 

                            createLeafNode(grammarAccess.getRef2Access().getRef2Mykeyword2Keyword_1_0_2(), "ref2"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRef2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "ref2", lv_ref2_1_3, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:781:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:781:47: (iv_ruleSpare= ruleSpare EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:782:2: iv_ruleSpare= ruleSpare EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpareRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpare_in_entryRuleSpare1550);
            iv_ruleSpare=ruleSpare();
            _fsp--;

             current =iv_ruleSpare; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpare1560); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:789:1: ruleSpare returns [EObject current=null] : ( '#3' ( (lv_id_1_0= RULE_ID ) ) ( '.' ( (lv_id_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token lv_id_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:794:6: ( ( '#3' ( (lv_id_1_0= RULE_ID ) ) ( '.' ( (lv_id_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:795:1: ( '#3' ( (lv_id_1_0= RULE_ID ) ) ( '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:795:1: ( '#3' ( (lv_id_1_0= RULE_ID ) ) ( '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:795:2: '#3' ( (lv_id_1_0= RULE_ID ) ) ( '.' ( (lv_id_3_0= RULE_ID ) ) )*
            {
            match(input,21,FOLLOW_21_in_ruleSpare1594); 

                    createLeafNode(grammarAccess.getSpareAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:799:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:800:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:800:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:801:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1611); 

            			createLeafNode(grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_1_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpareRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"id",
            	        		lv_id_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:823:2: ( '.' ( (lv_id_3_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:823:3: '.' ( (lv_id_3_0= RULE_ID ) )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleSpare1626); 

            	            createLeafNode(grammarAccess.getSpareAccess().getFullStopKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:827:1: ( (lv_id_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:828:1: (lv_id_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:828:1: (lv_id_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:829:3: lv_id_3_0= RULE_ID
            	    {
            	    lv_id_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1643); 

            	    			createLeafNode(grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_2_1_0(), "id"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSpareRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"id",
            	    	        		lv_id_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:858:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:858:49: (iv_ruleBoolean= ruleBoolean EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:859:2: iv_ruleBoolean= ruleBoolean EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoolean_in_entryRuleBoolean1683);
            iv_ruleBoolean=ruleBoolean();
            _fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolean1693); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:866:1: ruleBoolean returns [EObject current=null] : ( '#4' ( (lv_bool_1_0= 'myoption' ) )? 'kw' ( (lv_value_3_0= RULE_ID ) ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool_1_0=null;
        Token lv_value_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:871:6: ( ( '#4' ( (lv_bool_1_0= 'myoption' ) )? 'kw' ( (lv_value_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:872:1: ( '#4' ( (lv_bool_1_0= 'myoption' ) )? 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:872:1: ( '#4' ( (lv_bool_1_0= 'myoption' ) )? 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:872:2: '#4' ( (lv_bool_1_0= 'myoption' ) )? 'kw' ( (lv_value_3_0= RULE_ID ) )
            {
            match(input,23,FOLLOW_23_in_ruleBoolean1727); 

                    createLeafNode(grammarAccess.getBooleanAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:876:1: ( (lv_bool_1_0= 'myoption' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:877:1: (lv_bool_1_0= 'myoption' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:877:1: (lv_bool_1_0= 'myoption' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:878:3: lv_bool_1_0= 'myoption'
                    {
                    lv_bool_1_0=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleBoolean1744); 

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


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_ruleBoolean1767); 

                    createLeafNode(grammarAccess.getBooleanAccess().getKwKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:901:1: ( (lv_value_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:902:1: (lv_value_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:902:1: (lv_value_3_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:903:3: lv_value_3_0= RULE_ID
            {
            lv_value_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBoolean1784); 

            			createLeafNode(grammarAccess.getBooleanAccess().getValueIDTerminalRuleCall_3_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:932:1: entryRuleTransient1 returns [EObject current=null] : iv_ruleTransient1= ruleTransient1 EOF ;
    public final EObject entryRuleTransient1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransient1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:932:52: (iv_ruleTransient1= ruleTransient1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:933:2: iv_ruleTransient1= ruleTransient1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransient1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleTransient1_in_entryRuleTransient11822);
            iv_ruleTransient1=ruleTransient1();
            _fsp--;

             current =iv_ruleTransient1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransient11832); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:940:1: ruleTransient1 returns [EObject current=null] : ( '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) ( ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) ;
    public final EObject ruleTransient1() throws RecognitionException {
        EObject current = null;

        Token lv_precStar_1_0=null;
        Token lv_prec_2_0=null;
        Token lv_scaleStar_4_0=null;
        Token lv_scale_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:945:6: ( ( '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) ( ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:946:1: ( '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) ( ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:946:1: ( '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) ( ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:946:2: '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) ( ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            {
            match(input,26,FOLLOW_26_in_ruleTransient11866); 

                    createLeafNode(grammarAccess.getTransient1Access().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:950:1: ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) )
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
                    new NoViableAltException("950:1: ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:950:2: ( (lv_precStar_1_0= '*' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:950:2: ( (lv_precStar_1_0= '*' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:951:1: (lv_precStar_1_0= '*' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:951:1: (lv_precStar_1_0= '*' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:952:3: lv_precStar_1_0= '*'
                    {
                    lv_precStar_1_0=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleTransient11884); 

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


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:972:6: ( (lv_prec_2_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:972:6: ( (lv_prec_2_0= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:973:1: (lv_prec_2_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:973:1: (lv_prec_2_0= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:974:3: lv_prec_2_0= RULE_INT
                    {
                    lv_prec_2_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTransient11920); 

                    			createLeafNode(grammarAccess.getTransient1Access().getPrecINTTerminalRuleCall_1_1_0(), "prec"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransient1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"prec",
                    	        		lv_prec_2_0, 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:996:3: ( ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:996:4: ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
                    {
                    match(input,28,FOLLOW_28_in_ruleTransient11936); 

                            createLeafNode(grammarAccess.getTransient1Access().getCommaKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1000:1: ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
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
                            new NoViableAltException("1000:1: ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1000:2: ( (lv_scaleStar_4_0= '*' ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1000:2: ( (lv_scaleStar_4_0= '*' ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1001:1: (lv_scaleStar_4_0= '*' )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1001:1: (lv_scaleStar_4_0= '*' )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1002:3: lv_scaleStar_4_0= '*'
                            {
                            lv_scaleStar_4_0=(Token)input.LT(1);
                            match(input,27,FOLLOW_27_in_ruleTransient11954); 

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


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1022:6: ( (lv_scale_5_0= RULE_INT ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1022:6: ( (lv_scale_5_0= RULE_INT ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1023:1: (lv_scale_5_0= RULE_INT )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1023:1: (lv_scale_5_0= RULE_INT )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1024:3: lv_scale_5_0= RULE_INT
                            {
                            lv_scale_5_0=(Token)input.LT(1);
                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTransient11990); 

                            			createLeafNode(grammarAccess.getTransient1Access().getScaleINTTerminalRuleCall_2_1_1_0(), "scale"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTransient1Rule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"scale",
                            	        		lv_scale_5_0, 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1053:1: entryRuleConsumed1 returns [EObject current=null] : iv_ruleConsumed1= ruleConsumed1 EOF ;
    public final EObject entryRuleConsumed1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1053:51: (iv_ruleConsumed1= ruleConsumed1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1054:2: iv_ruleConsumed1= ruleConsumed1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConsumed1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleConsumed1_in_entryRuleConsumed12031);
            iv_ruleConsumed1=ruleConsumed1();
            _fsp--;

             current =iv_ruleConsumed1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConsumed12041); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1061:1: ruleConsumed1 returns [EObject current=null] : ( '#6' ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) ;
    public final EObject ruleConsumed1() throws RecognitionException {
        EObject current = null;

        Token lv_v1_2_0=null;
        Token lv_v2_3_0=null;
        Token lv_v2_5_0=null;
        Token lv_v1_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1066:6: ( ( '#6' ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1067:1: ( '#6' ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1067:1: ( '#6' ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1067:2: '#6' ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
            {
            match(input,29,FOLLOW_29_in_ruleConsumed12075); 

                    createLeafNode(grammarAccess.getConsumed1Access().getNumberSignDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1071:1: ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
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
                    new NoViableAltException("1071:1: ( ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1071:2: ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1071:2: ( 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1071:3: 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) )
                    {
                    match(input,30,FOLLOW_30_in_ruleConsumed12086); 

                            createLeafNode(grammarAccess.getConsumed1Access().getV1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1075:1: ( (lv_v1_2_0= RULE_INT ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_INT) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1076:1: (lv_v1_2_0= RULE_INT )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1076:1: (lv_v1_2_0= RULE_INT )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1077:3: lv_v1_2_0= RULE_INT
                    	    {
                    	    lv_v1_2_0=(Token)input.LT(1);
                    	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleConsumed12103); 

                    	    			createLeafNode(grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_0_1_0(), "v1"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"v1",
                    	    	        		lv_v1_2_0, 
                    	    	        		"INT", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1099:3: ( (lv_v2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1100:1: (lv_v2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1100:1: (lv_v2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1101:3: lv_v2_3_0= RULE_ID
                    {
                    lv_v2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConsumed12126); 

                    			createLeafNode(grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_0_2_0(), "v2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"v2",
                    	        		lv_v2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1124:6: ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1124:6: ( 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1124:7: 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleConsumed12148); 

                            createLeafNode(grammarAccess.getConsumed1Access().getV2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1128:1: ( (lv_v2_5_0= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1129:1: (lv_v2_5_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1129:1: (lv_v2_5_0= RULE_ID )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1130:3: lv_v2_5_0= RULE_ID
                    	    {
                    	    lv_v2_5_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConsumed12165); 

                    	    			createLeafNode(grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_1_1_0(), "v2"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"v2",
                    	    	        		lv_v2_5_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1152:3: ( (lv_v1_6_0= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1153:1: (lv_v1_6_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1153:1: (lv_v1_6_0= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1154:3: lv_v1_6_0= RULE_INT
                    {
                    lv_v1_6_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleConsumed12188); 

                    			createLeafNode(grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_1_2_0(), "v1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConsumed1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"v1",
                    	        		lv_v1_6_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1183:1: entryRuleConsumed2 returns [EObject current=null] : iv_ruleConsumed2= ruleConsumed2 EOF ;
    public final EObject entryRuleConsumed2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1183:51: (iv_ruleConsumed2= ruleConsumed2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1184:2: iv_ruleConsumed2= ruleConsumed2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConsumed2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleConsumed2_in_entryRuleConsumed22228);
            iv_ruleConsumed2=ruleConsumed2();
            _fsp--;

             current =iv_ruleConsumed2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConsumed22238); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1191:1: ruleConsumed2 returns [EObject current=null] : ( '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) ;
    public final EObject ruleConsumed2() throws RecognitionException {
        EObject current = null;

        EObject lv_child_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1196:6: ( ( '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1197:1: ( '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1197:1: ( '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1197:2: '#7' ( (lv_child_1_0= ruleConsumed1 ) )
            {
            match(input,32,FOLLOW_32_in_ruleConsumed22272); 

                    createLeafNode(grammarAccess.getConsumed2Access().getNumberSignDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1201:1: ( (lv_child_1_0= ruleConsumed1 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1202:1: (lv_child_1_0= ruleConsumed1 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1202:1: (lv_child_1_0= ruleConsumed1 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1203:3: lv_child_1_0= ruleConsumed1
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConsumed2Access().getChildConsumed1ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConsumed1_in_ruleConsumed22293);
            lv_child_1_0=ruleConsumed1();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConsumed2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"child",
            	        		lv_child_1_0, 
            	        		"Consumed1", 
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
    // $ANTLR end ruleConsumed2


    // $ANTLR start entryRuleLoop1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1232:1: entryRuleLoop1 returns [EObject current=null] : iv_ruleLoop1= ruleLoop1 EOF ;
    public final EObject entryRuleLoop1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1232:47: (iv_ruleLoop1= ruleLoop1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1233:2: iv_ruleLoop1= ruleLoop1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop1_in_entryRuleLoop12326);
            iv_ruleLoop1=ruleLoop1();
            _fsp--;

             current =iv_ruleLoop1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop12336); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1240:1: ruleLoop1 returns [EObject current=null] : ( ( 'kw0' )? '#8' ( (lv_id_2_0= RULE_ID ) ) ( 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( ( 'kw2' )* 'kw30' )+ ) ;
    public final EObject ruleLoop1() throws RecognitionException {
        EObject current = null;

        Token lv_id_2_0=null;
        Token lv_id_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1245:6: ( ( ( 'kw0' )? '#8' ( (lv_id_2_0= RULE_ID ) ) ( 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( ( 'kw2' )* 'kw30' )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1246:1: ( ( 'kw0' )? '#8' ( (lv_id_2_0= RULE_ID ) ) ( 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( ( 'kw2' )* 'kw30' )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1246:1: ( ( 'kw0' )? '#8' ( (lv_id_2_0= RULE_ID ) ) ( 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( ( 'kw2' )* 'kw30' )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1246:2: ( 'kw0' )? '#8' ( (lv_id_2_0= RULE_ID ) ) ( 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( ( 'kw2' )* 'kw30' )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1246:2: ( 'kw0' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1246:3: 'kw0'
                    {
                    match(input,33,FOLLOW_33_in_ruleLoop12371); 

                            createLeafNode(grammarAccess.getLoop1Access().getKw0Keyword_0(), null); 
                        

                    }
                    break;

            }

            match(input,34,FOLLOW_34_in_ruleLoop12382); 

                    createLeafNode(grammarAccess.getLoop1Access().getNumberSignDigitEightKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1254:1: ( (lv_id_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1255:1: (lv_id_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1255:1: (lv_id_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1256:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop12399); 

            			createLeafNode(grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"id",
            	        		lv_id_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1278:2: ( 'kw1' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1278:3: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop12414); 

                            createLeafNode(grammarAccess.getLoop1Access().getKw1Keyword_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1282:3: ( (lv_id_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1283:1: (lv_id_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1283:1: (lv_id_4_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1284:3: lv_id_4_0= RULE_ID
            {
            lv_id_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop12433); 

            			createLeafNode(grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_4_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"id",
            	        		lv_id_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1306:2: ( ( 'kw2' )* 'kw30' )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1306:3: ( 'kw2' )* 'kw30'
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1306:3: ( 'kw2' )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==36) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1306:4: 'kw2'
            	    	    {
            	    	    match(input,36,FOLLOW_36_in_ruleLoop12449); 

            	    	            createLeafNode(grammarAccess.getLoop1Access().getKw2Keyword_5_0(), null); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);

            	    match(input,37,FOLLOW_37_in_ruleLoop12460); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1321:1: entryRuleLoop2 returns [EObject current=null] : iv_ruleLoop2= ruleLoop2 EOF ;
    public final EObject entryRuleLoop2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1321:47: (iv_ruleLoop2= ruleLoop2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1322:2: iv_ruleLoop2= ruleLoop2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop2_in_entryRuleLoop22495);
            iv_ruleLoop2=ruleLoop2();
            _fsp--;

             current =iv_ruleLoop2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop22505); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1329:1: ruleLoop2 returns [EObject current=null] : ( '#9' ( (lv_id_1_0= RULE_ID ) ) ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) ) ( 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' ) )? ( 'kw5' | 'kw6' ) ) ;
    public final EObject ruleLoop2() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token lv_id_3_0=null;
        Token lv_id_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1334:6: ( ( '#9' ( (lv_id_1_0= RULE_ID ) ) ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) ) ( 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' ) )? ( 'kw5' | 'kw6' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1335:1: ( '#9' ( (lv_id_1_0= RULE_ID ) ) ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) ) ( 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' ) )? ( 'kw5' | 'kw6' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1335:1: ( '#9' ( (lv_id_1_0= RULE_ID ) ) ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) ) ( 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' ) )? ( 'kw5' | 'kw6' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1335:2: '#9' ( (lv_id_1_0= RULE_ID ) ) ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) ) ( 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' ) )? ( 'kw5' | 'kw6' )
            {
            match(input,38,FOLLOW_38_in_ruleLoop22539); 

                    createLeafNode(grammarAccess.getLoop2Access().getNumberSignDigitNineKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1339:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1340:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1340:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1341:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop22556); 

            			createLeafNode(grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_1_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"id",
            	        		lv_id_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1363:2: ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) )
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
                    new NoViableAltException("1363:2: ( 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' ) )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1363:3: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop22571); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw1Keyword_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1368:6: ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1368:6: ( ( (lv_id_3_0= RULE_ID ) ) 'kw2' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1368:7: ( (lv_id_3_0= RULE_ID ) ) 'kw2'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1368:7: ( (lv_id_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1369:1: (lv_id_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1369:1: (lv_id_3_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1370:3: lv_id_3_0= RULE_ID
                    {
                    lv_id_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop22595); 

                    			createLeafNode(grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_2_1_0_0(), "id"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLoop2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"id",
                    	        		lv_id_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,36,FOLLOW_36_in_ruleLoop22609); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw2Keyword_2_1_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1396:3: ( 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' ) )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1396:4: 'kw3'
                    {
                    match(input,39,FOLLOW_39_in_ruleLoop22621); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw3Keyword_3_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1401:6: ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1401:6: ( ( (lv_id_6_0= RULE_ID ) ) 'kw4' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1401:7: ( (lv_id_6_0= RULE_ID ) ) 'kw4'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1401:7: ( (lv_id_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1402:1: (lv_id_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1402:1: (lv_id_6_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1403:3: lv_id_6_0= RULE_ID
                    {
                    lv_id_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop22645); 

                    			createLeafNode(grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_3_1_0_0(), "id"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLoop2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"id",
                    	        		lv_id_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,40,FOLLOW_40_in_ruleLoop22659); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw4Keyword_3_1_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:4: ( 'kw5' | 'kw6' )
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
                    new NoViableAltException("1429:4: ( 'kw5' | 'kw6' )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:5: 'kw5'
                    {
                    match(input,41,FOLLOW_41_in_ruleLoop22672); 

                            createLeafNode(grammarAccess.getLoop2Access().getKw5Keyword_4_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1434:6: 'kw6'
                    {
                    match(input,42,FOLLOW_42_in_ruleLoop22687); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1445:1: entryRuleLoop3 returns [EObject current=null] : iv_ruleLoop3= ruleLoop3 EOF ;
    public final EObject entryRuleLoop3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1445:47: (iv_ruleLoop3= ruleLoop3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1446:2: iv_ruleLoop3= ruleLoop3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop3Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop3_in_entryRuleLoop32721);
            iv_ruleLoop3=ruleLoop3();
            _fsp--;

             current =iv_ruleLoop3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop32731); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1453:1: ruleLoop3 returns [EObject current=null] : ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' ( (lv_id_4_0= RULE_ID ) ) ( 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5' )* ) ;
    public final EObject ruleLoop3() throws RecognitionException {
        EObject current = null;

        Token lv_id_4_0=null;
        Token lv_id_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1458:6: ( ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' ( (lv_id_4_0= RULE_ID ) ) ( 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5' )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1459:1: ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' ( (lv_id_4_0= RULE_ID ) ) ( 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5' )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1459:1: ( ( 'kw1' | 'kw2' | 'kw3' ) '#10' ( (lv_id_4_0= RULE_ID ) ) ( 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5' )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1459:2: ( 'kw1' | 'kw2' | 'kw3' ) '#10' ( (lv_id_4_0= RULE_ID ) ) ( 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5' )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1459:2: ( 'kw1' | 'kw2' | 'kw3' )
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
                    new NoViableAltException("1459:2: ( 'kw1' | 'kw2' | 'kw3' )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1459:3: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop32766); 

                            createLeafNode(grammarAccess.getLoop3Access().getKw1Keyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1464:6: 'kw2'
                    {
                    match(input,36,FOLLOW_36_in_ruleLoop32781); 

                            createLeafNode(grammarAccess.getLoop3Access().getKw2Keyword_0_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1469:6: 'kw3'
                    {
                    match(input,39,FOLLOW_39_in_ruleLoop32796); 

                            createLeafNode(grammarAccess.getLoop3Access().getKw3Keyword_0_2(), null); 
                        

                    }
                    break;

            }

            match(input,43,FOLLOW_43_in_ruleLoop32806); 

                    createLeafNode(grammarAccess.getLoop3Access().getNumberSignDigitOneDigitZeroKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1477:1: ( (lv_id_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1478:1: (lv_id_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1478:1: (lv_id_4_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1479:3: lv_id_4_0= RULE_ID
            {
            lv_id_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop32823); 

            			createLeafNode(grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"id",
            	        		lv_id_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1501:2: ( 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==40) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1501:3: 'kw4' ( (lv_id_6_0= RULE_ID ) ) 'kw5'
            	    {
            	    match(input,40,FOLLOW_40_in_ruleLoop32838); 

            	            createLeafNode(grammarAccess.getLoop3Access().getKw4Keyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1505:1: ( (lv_id_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1506:1: (lv_id_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1506:1: (lv_id_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1507:3: lv_id_6_0= RULE_ID
            	    {
            	    lv_id_6_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop32855); 

            	    			createLeafNode(grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_3_1_0(), "id"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoop3Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"id",
            	    	        		lv_id_6_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,41,FOLLOW_41_in_ruleLoop32869); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1540:1: entryRuleLoop4 returns [EObject current=null] : iv_ruleLoop4= ruleLoop4 EOF ;
    public final EObject entryRuleLoop4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop4 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1540:47: (iv_ruleLoop4= ruleLoop4 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1541:2: iv_ruleLoop4= ruleLoop4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop4Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoop4_in_entryRuleLoop42904);
            iv_ruleLoop4=ruleLoop4();
            _fsp--;

             current =iv_ruleLoop4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop42914); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1548:1: ruleLoop4 returns [EObject current=null] : ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ ) ;
    public final EObject ruleLoop4() throws RecognitionException {
        EObject current = null;

        Token lv_id_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1553:6: ( ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1554:1: ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1554:1: ( '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1554:2: '#11' ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+
            {
            match(input,44,FOLLOW_44_in_ruleLoop42948); 

                    createLeafNode(grammarAccess.getLoop4Access().getNumberSignDigitOneDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1558:1: ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) )
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
                    new NoViableAltException("1558:1: ( 'kw1' | 'kw2' | ( 'kw3' 'kw4' ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1558:2: 'kw1'
                    {
                    match(input,35,FOLLOW_35_in_ruleLoop42958); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw1Keyword_1_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1563:6: 'kw2'
                    {
                    match(input,36,FOLLOW_36_in_ruleLoop42973); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw2Keyword_1_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1568:6: ( 'kw3' 'kw4' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1568:6: ( 'kw3' 'kw4' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1568:7: 'kw3' 'kw4'
                    {
                    match(input,39,FOLLOW_39_in_ruleLoop42989); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw3Keyword_1_2_0(), null); 
                        
                    match(input,40,FOLLOW_40_in_ruleLoop42998); 

                            createLeafNode(grammarAccess.getLoop4Access().getKw4Keyword_1_2_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1576:3: ( (lv_id_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1577:1: (lv_id_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1577:1: (lv_id_5_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1578:3: lv_id_5_0= RULE_ID
            {
            lv_id_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoop43017); 

            			createLeafNode(grammarAccess.getLoop4Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoop4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"id",
            	        		lv_id_5_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1600:2: ( 'kw5' ( 'kw6' ( 'kw7' )? )? )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1600:3: 'kw5' ( 'kw6' ( 'kw7' )? )?
            	    {
            	    match(input,41,FOLLOW_41_in_ruleLoop43032); 

            	            createLeafNode(grammarAccess.getLoop4Access().getKw5Keyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1604:1: ( 'kw6' ( 'kw7' )? )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==42) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1604:2: 'kw6' ( 'kw7' )?
            	            {
            	            match(input,42,FOLLOW_42_in_ruleLoop43042); 

            	                    createLeafNode(grammarAccess.getLoop4Access().getKw6Keyword_3_1_0(), null); 
            	                
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1608:1: ( 'kw7' )?
            	            int alt25=2;
            	            int LA25_0 = input.LA(1);

            	            if ( (LA25_0==45) ) {
            	                alt25=1;
            	            }
            	            switch (alt25) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1608:2: 'kw7'
            	                    {
            	                    match(input,45,FOLLOW_45_in_ruleLoop43052); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1619:1: entryRuleLoopBug285452 returns [EObject current=null] : iv_ruleLoopBug285452= ruleLoopBug285452 EOF ;
    public final EObject entryRuleLoopBug285452() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopBug285452 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1619:55: (iv_ruleLoopBug285452= ruleLoopBug285452 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1620:2: iv_ruleLoopBug285452= ruleLoopBug285452 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopBug285452Rule(), currentNode); 
            pushFollow(FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523091);
            iv_ruleLoopBug285452=ruleLoopBug285452();
            _fsp--;

             current =iv_ruleLoopBug285452; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoopBug2854523101); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1627:1: ruleLoopBug285452 returns [EObject current=null] : ( '#12' ( ( (lv_interface_1_0= 'interface' ) ) | 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleLoopBug285452() throws RecognitionException {
        EObject current = null;

        Token lv_interface_1_0=null;
        Token lv_name_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1632:6: ( ( '#12' ( ( (lv_interface_1_0= 'interface' ) ) | 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1633:1: ( '#12' ( ( (lv_interface_1_0= 'interface' ) ) | 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1633:1: ( '#12' ( ( (lv_interface_1_0= 'interface' ) ) | 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1633:2: '#12' ( ( (lv_interface_1_0= 'interface' ) ) | 'class' ) ( (lv_name_3_0= RULE_ID ) )
            {
            match(input,46,FOLLOW_46_in_ruleLoopBug2854523135); 

                    createLeafNode(grammarAccess.getLoopBug285452Access().getNumberSignDigitOneDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1637:1: ( ( (lv_interface_1_0= 'interface' ) ) | 'class' )
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
                    new NoViableAltException("1637:1: ( ( (lv_interface_1_0= 'interface' ) ) | 'class' )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1637:2: ( (lv_interface_1_0= 'interface' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1637:2: ( (lv_interface_1_0= 'interface' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1638:1: (lv_interface_1_0= 'interface' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1638:1: (lv_interface_1_0= 'interface' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1639:3: lv_interface_1_0= 'interface'
                    {
                    lv_interface_1_0=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleLoopBug2854523153); 

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


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1659:6: 'class'
                    {
                    match(input,48,FOLLOW_48_in_ruleLoopBug2854523181); 

                            createLeafNode(grammarAccess.getLoopBug285452Access().getClassKeyword_1_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1663:2: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1664:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1664:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1665:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoopBug2854523199); 

            			createLeafNode(grammarAccess.getLoopBug285452Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoopBug285452Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1694:1: entryRuleDuplicateBug284491 returns [EObject current=null] : iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF ;
    public final EObject entryRuleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDuplicateBug284491 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1694:60: (iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1695:2: iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDuplicateBug284491Rule(), currentNode); 
            pushFollow(FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913237);
            iv_ruleDuplicateBug284491=ruleDuplicateBug284491();
            _fsp--;

             current =iv_ruleDuplicateBug284491; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDuplicateBug2844913247); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1702:1: ruleDuplicateBug284491 returns [EObject current=null] : ( '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) ;
    public final EObject ruleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        Token lv_static_1_0=null;
        Token lv_final_2_0=null;
        Token lv_transient_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1707:6: ( ( '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1708:1: ( '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1708:1: ( '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1708:2: '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
            {
            match(input,49,FOLLOW_49_in_ruleDuplicateBug2844913281); 

                    createLeafNode(grammarAccess.getDuplicateBug284491Access().getNumberSignDigitOneDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1712:1: ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1712:2: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1712:2: ( (lv_static_1_0= 'static' ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1713:1: (lv_static_1_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1713:1: (lv_static_1_0= 'static' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1714:3: lv_static_1_0= 'static'
            	    {
            	    lv_static_1_0=(Token)input.LT(1);
            	    match(input,50,FOLLOW_50_in_ruleDuplicateBug2844913299); 

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


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1734:6: ( (lv_final_2_0= 'final' ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1734:6: ( (lv_final_2_0= 'final' ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1735:1: (lv_final_2_0= 'final' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1735:1: (lv_final_2_0= 'final' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1736:3: lv_final_2_0= 'final'
            	    {
            	    lv_final_2_0=(Token)input.LT(1);
            	    match(input,51,FOLLOW_51_in_ruleDuplicateBug2844913335); 

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


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1756:6: ( (lv_transient_3_0= 'transient' ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1756:6: ( (lv_transient_3_0= 'transient' ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1757:1: (lv_transient_3_0= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1757:1: (lv_transient_3_0= 'transient' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1758:3: lv_transient_3_0= 'transient'
            	    {
            	    lv_transient_3_0=(Token)input.LT(1);
            	    match(input,52,FOLLOW_52_in_ruleDuplicateBug2844913371); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1784:1: entryRuleEmptyObjectBug284850 returns [EObject current=null] : iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF ;
    public final EObject entryRuleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectBug284850 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1784:62: (iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1785:2: iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectBug284850Rule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848503419);
            iv_ruleEmptyObjectBug284850=ruleEmptyObjectBug284850();
            _fsp--;

             current =iv_ruleEmptyObjectBug284850; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyObjectBug2848503429); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1792:1: ruleEmptyObjectBug284850 returns [EObject current=null] : ( '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) ;
    public final EObject ruleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1797:6: ( ( '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1798:1: ( '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1798:1: ( '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1798:2: '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) )
            {
            match(input,53,FOLLOW_53_in_ruleEmptyObjectBug2848503463); 

                    createLeafNode(grammarAccess.getEmptyObjectBug284850Access().getNumberSignDigitOneDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1802:1: ( (lv_items_1_0= ruleEmptyObjectItems ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1803:1: (lv_items_1_0= ruleEmptyObjectItems )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1803:1: (lv_items_1_0= ruleEmptyObjectItems )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1804:3: lv_items_1_0= ruleEmptyObjectItems
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEmptyObjectBug284850Access().getItemsEmptyObjectItemsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848503484);
            lv_items_1_0=ruleEmptyObjectItems();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEmptyObjectBug284850Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"items",
            	        		lv_items_1_0, 
            	        		"EmptyObjectItems", 
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
    // $ANTLR end ruleEmptyObjectBug284850


    // $ANTLR start entryRuleEmptyObjectItems
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1833:1: entryRuleEmptyObjectItems returns [EObject current=null] : iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF ;
    public final EObject entryRuleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItems = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1833:58: (iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1834:2: iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectItemsRule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems3517);
            iv_ruleEmptyObjectItems=ruleEmptyObjectItems();
            _fsp--;

             current =iv_ruleEmptyObjectItems; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyObjectItems3527); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1841:1: ruleEmptyObjectItems returns [EObject current=null] : ( (lv_list_0_0= ruleEmptyObjectItem ) )* ;
    public final EObject ruleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject lv_list_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1846:6: ( ( (lv_list_0_0= ruleEmptyObjectItem ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1847:1: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1847:1: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==54) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1848:1: (lv_list_0_0= ruleEmptyObjectItem )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1848:1: (lv_list_0_0= ruleEmptyObjectItem )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1849:3: lv_list_0_0= ruleEmptyObjectItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEmptyObjectItemsAccess().getListEmptyObjectItemParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems3572);
            	    lv_list_0_0=ruleEmptyObjectItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEmptyObjectItemsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"list",
            	    	        		lv_list_0_0, 
            	    	        		"EmptyObjectItem", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1878:1: entryRuleEmptyObjectItem returns [EObject current=null] : iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF ;
    public final EObject entryRuleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItem = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1878:57: (iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1879:2: iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectItemRule(), currentNode); 
            pushFollow(FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem3605);
            iv_ruleEmptyObjectItem=ruleEmptyObjectItem();
            _fsp--;

             current =iv_ruleEmptyObjectItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyObjectItem3615); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1886:1: ruleEmptyObjectItem returns [EObject current=null] : ( 'item' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1891:6: ( ( 'item' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1892:1: ( 'item' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1892:1: ( 'item' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1892:2: 'item' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,54,FOLLOW_54_in_ruleEmptyObjectItem3649); 

                    createLeafNode(grammarAccess.getEmptyObjectItemAccess().getItemKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1896:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1897:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1897:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1898:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEmptyObjectItem3666); 

            			createLeafNode(grammarAccess.getEmptyObjectItemAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEmptyObjectItemRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1927:1: entryRuleMultiInheritanceBug280439 returns [EObject current=null] : iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF ;
    public final EObject entryRuleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiInheritanceBug280439 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1927:67: (iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1928:2: iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiInheritanceBug280439Rule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804393704);
            iv_ruleMultiInheritanceBug280439=ruleMultiInheritanceBug280439();
            _fsp--;

             current =iv_ruleMultiInheritanceBug280439; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804393714); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1935:1: ruleMultiInheritanceBug280439 returns [EObject current=null] : ( '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) ;
    public final EObject ruleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        EObject lv_val_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1940:6: ( ( '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1941:1: ( '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1941:1: ( '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1941:2: '#15' ( (lv_val_1_0= ruleConcreteMulti ) )
            {
            match(input,55,FOLLOW_55_in_ruleMultiInheritanceBug2804393748); 

                    createLeafNode(grammarAccess.getMultiInheritanceBug280439Access().getNumberSignDigitOneDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1945:1: ( (lv_val_1_0= ruleConcreteMulti ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1946:1: (lv_val_1_0= ruleConcreteMulti )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1946:1: (lv_val_1_0= ruleConcreteMulti )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1947:3: lv_val_1_0= ruleConcreteMulti
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiInheritanceBug280439Access().getValConcreteMultiParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804393769);
            lv_val_1_0=ruleConcreteMulti();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiInheritanceBug280439Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val",
            	        		lv_val_1_0, 
            	        		"ConcreteMulti", 
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
    // $ANTLR end ruleMultiInheritanceBug280439


    // $ANTLR start entryRuleConcreteMulti
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1980:1: entryRuleConcreteMulti returns [EObject current=null] : iv_ruleConcreteMulti= ruleConcreteMulti EOF ;
    public final EObject entryRuleConcreteMulti() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteMulti = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1980:55: (iv_ruleConcreteMulti= ruleConcreteMulti EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1981:2: iv_ruleConcreteMulti= ruleConcreteMulti EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteMultiRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti3806);
            iv_ruleConcreteMulti=ruleConcreteMulti();
            _fsp--;

             current =iv_ruleConcreteMulti; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteMulti3816); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1988:1: ruleConcreteMulti returns [EObject current=null] : ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleConcreteMulti() throws RecognitionException {
        EObject current = null;

        Token lv_m1_0_0=null;
        Token lv_m2_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1993:6: ( ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1994:1: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1994:1: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1994:2: ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1994:2: ( (lv_m1_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1995:1: (lv_m1_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1995:1: (lv_m1_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1996:3: lv_m1_0_0= RULE_ID
            {
            lv_m1_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConcreteMulti3858); 

            			createLeafNode(grammarAccess.getConcreteMultiAccess().getM1IDTerminalRuleCall_0_0(), "m1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcreteMultiRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"m1",
            	        		lv_m1_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2018:2: ( (lv_m2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2019:1: (lv_m2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2019:1: (lv_m2_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2020:3: lv_m2_1_0= RULE_ID
            {
            lv_m2_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConcreteMulti3880); 

            			createLeafNode(grammarAccess.getConcreteMultiAccess().getM2IDTerminalRuleCall_1_0(), "m2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcreteMultiRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"m2",
            	        		lv_m2_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp160 = new BitSet(new long[]{0x00A250DF24A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleTerm360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_ruleTerm387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_ruleTerm414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_ruleTerm441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransient1_in_ruleTerm468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed1_in_ruleTerm495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed2_in_ruleTerm522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop1_in_ruleTerm549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop2_in_ruleTerm576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop3_in_ruleTerm603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop4_in_ruleTerm630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoopBug285452_in_ruleTerm657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDuplicateBug284491_in_ruleTerm684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens858 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParens902 = new BitSet(new long[]{0x00A250DF24A58830L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens924 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParens932 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleParens949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1048 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1070 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTwoNumbers1085 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1102 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleManyStrings1186 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1203 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleType1308 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1325 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleType1339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRef21400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRef21434 = new BitSet(new long[]{0x0000000000180040L});
    public static final BitSet FOLLOW_19_in_ruleRef21453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRef21501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_entryRuleSpare1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpare1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSpare1594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1611 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleSpare1626 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1643 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBoolean1727 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleBoolean1744 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleBoolean1767 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransient1_in_entryRuleTransient11822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransient11832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTransient11866 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_ruleTransient11884 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTransient11920 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleTransient11936 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_ruleTransient11954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTransient11990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed1_in_entryRuleConsumed12031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConsumed12041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleConsumed12075 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleConsumed12086 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12103 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleConsumed12148 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12165 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConsumed2_in_entryRuleConsumed22228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConsumed22238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleConsumed22272 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleConsumed1_in_ruleConsumed22293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop1_in_entryRuleLoop12326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop12336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleLoop12371 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleLoop12382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12399 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_35_in_ruleLoop12414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12433 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_36_in_ruleLoop12449 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_37_in_ruleLoop12460 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleLoop2_in_entryRuleLoop22495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop22505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleLoop22539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22556 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_35_in_ruleLoop22571 = new BitSet(new long[]{0x0000068000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22595 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleLoop22609 = new BitSet(new long[]{0x0000068000000010L});
    public static final BitSet FOLLOW_39_in_ruleLoop22621 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22645 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleLoop22659 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_41_in_ruleLoop22672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLoop22687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop3_in_entryRuleLoop32721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop32731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLoop32766 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_36_in_ruleLoop32781 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_39_in_ruleLoop32796 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleLoop32806 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop32823 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleLoop32838 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop32855 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleLoop32869 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleLoop4_in_entryRuleLoop42904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop42914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLoop42948 = new BitSet(new long[]{0x0000009800000000L});
    public static final BitSet FOLLOW_35_in_ruleLoop42958 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_36_in_ruleLoop42973 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_39_in_ruleLoop42989 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleLoop42998 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoop43017 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleLoop43032 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_42_in_ruleLoop43042 = new BitSet(new long[]{0x0000220000000002L});
    public static final BitSet FOLLOW_45_in_ruleLoop43052 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoopBug2854523101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLoopBug2854523135 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_ruleLoopBug2854523153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_48_in_ruleLoopBug2854523181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoopBug2854523199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDuplicateBug2844913247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDuplicateBug2844913281 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDuplicateBug2844913299 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDuplicateBug2844913335 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_52_in_ruleDuplicateBug2844913371 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848503419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectBug2848503429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleEmptyObjectBug2848503463 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848503484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems3517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItems3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems3572 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem3605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItem3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleEmptyObjectItem3649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEmptyObjectItem3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804393704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804393714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleMultiInheritanceBug2804393748 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804393769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti3806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteMulti3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti3858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti3880 = new BitSet(new long[]{0x0000000000000002L});

}